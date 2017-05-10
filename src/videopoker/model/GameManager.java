package videopoker.model;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

public class GameManager {
	public Player player;
	public int currentBet;
	
	public Deck deck;
	public Analyser analyser;
	public StatisticsManager stats;
	
	public GameManager(int credits){
		this.player = new Player(credits);
		this.analyser = new Analyser();
		this.stats = new StatisticsManager();
	}
	
	public void initDeck(){
		this.deck = new Deck();
	}
	
	public void initDeck(String fileName) throws FileNotFoundException, IOException{
		this.deck = new Deck(fileName);
	}
	
	public void dealCards(){
		player.giveHand(deck.drawCards(5));
	}
	
	public HashMap<String, Integer> getStats(){
		return stats.statistics;
	}
	
	private int calculateRewards(){
		HandInformation hi = analyser.analyseHand(player.getHand());
		int multiplier = hi.getHandValue();
		int prize = (multiplier == 250 && currentBet == 5)? 4000 : multiplier * currentBet;
		stats.registerHand(hi.getHandName());
		return prize;
	}
	
	public void discardCards(byte[] toDiscard){
		player.discardCards(toDiscard);
		player.giveCards(deck.drawCards(toDiscard.length));
		player.giveCredits(calculateRewards());
	}
	
	public void acceptBet(int amount){
		player.takeCredits(amount);
		currentBet = amount;
	}
}
