package videopoker.model;

import java.util.Arrays;

public class HandInformation {
	public Card[] hand;
	private String handName = DEFAULT_NAME;
	private int handValue = -1;
	
	public int pairNumber = 0;
	
	public boolean distinctCards = true;
	public boolean straight = false;
	public boolean flush = true;
	
	public boolean realPair = false;
	public boolean poker = false;
	public boolean trio = false;
	
	public HandInformation(Card[] hand){
		this.hand = hand;
		Arrays.sort(this.hand, (card1, card2) -> card2.getValue() - card1.getValue());
	}
	
	public void managePair(int count, int cardValue){
		switch(count){
			case 3:
				this.trio = true;
				break;
			case 4:
				this.poker = true;
				break;
			default:
				if(cardValue > 10)
					realPair = true;
				this.pairNumber++;
		}
	}
	
	public String getHandName(){
		getHandValue();
		return handName;
	}
	
	public int getHandValue(){
		if(handValue != -1)
			return handValue;
		
		// :yuck:
		if(straight && flush && hand[0].getValue() == 10){
			handName = ROYAL_FLUSH_NAME;
			return handValue = ROYAL_FLUSH;
		}
		
		if(poker){
			handName = FOUR_OF_A_KIND_NAME;
			if(hand[3].getValue() == 14)
				return handValue = FOUR_OF_A_KIND_T1;
			if(hand[3].getValue() >= 2 && hand[3].getValue() <= 5)
				return handValue = FOUR_OF_A_KIND_T2;
			return handValue = FOUR_OF_A_KIND_T3;
		}
		
		if(straight && flush){
			handName = STRAIGHT_FLUSH_NAME;
			return handValue = STRAIGHT_FLUSH;
		}
		
		if(trio && pairNumber == 1){
			handName = FULL_HOUSE_NAME;
			return handValue = FULL_HOUSE;
		}
		
		if(flush){
			handName = FLUSH_NAME;
			return handValue = FLUSH;
		}
		
		if(straight){
			handName = STRAIGHT_NAME;
			return handValue = STRAIGHT;
		}
		
		if(trio){
			handName = THREE_OF_A_KIND_NAME;
			return handValue = THREE_OF_A_KIND;
		}
		
		if(pairNumber == 2){
			handName = TWO_PAIRS_NAME;
			return handValue = TWO_PAIRS;
		}
		
		if(pairNumber == 1 ){
			handName = PAIR_NAME;
			return handValue = PAIR;
		}
		return handValue = 0;
	}
	
	public static final int ROYAL_FLUSH = 250,
			FOUR_OF_A_KIND_T1 = 160,
			FOUR_OF_A_KIND_T2 = 80,
			FOUR_OF_A_KIND_T3 = 50,
			THREE_OF_A_KIND = 3,
			STRAIGHT_FLUSH = 50,
			FULL_HOUSE = 10, 
			TWO_PAIRS = 1,
			STRAIGHT = 5,
			FLUSH = 7,
			PAIR = 1;
	
	public static final String ROYAL_FLUSH_NAME = "Royal Flush",
			THREE_OF_A_KIND_NAME = "Three of a Kind",
			STRAIGHT_FLUSH_NAME = "Straight Flush",
			FOUR_OF_A_KIND_NAME = "Four of a Kind",
			FULL_HOUSE_NAME = "Full House",
			TWO_PAIRS_NAME = "Two pairs",
			STRAIGHT_NAME = "Straight",
			DEFAULT_NAME = "Others",
			FLUSH_NAME = "Flush",
			PAIR_NAME = "Pair";
}
