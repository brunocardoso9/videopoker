package videopoker.model;

import java.io.FileNotFoundException;
import java.io.IOException;

public class GameManager {
	public Player player;
	public Deck deck;
	public int currentBet;
	public Analyser analyser;
	
	public GameManager(int credits){
		this.player = new Player(credits);
		this.analyser = new Analyser();
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
	
	public String getStats(){
		return "O jogo está viciado.";
	}
	
	private int calculateRewards(){
		return analyser.analyseHand(player.getHand()) * currentBet;
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
