package videopoker.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class Analyser {	
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
			
	private boolean checkPair(Card[] hand){
		for(int i = 1; i < hand.length; i++)
			if(hand[i].getValue() > 10 && hand[i].getValue() == hand[i-1].getValue())
				return true;
		return false;
	}
	
	private boolean checkThreeOfAKind(Card[] hand){
		for(int i = 1; i < hand.length-1; i++)
			if(hand[i-1].getValue() == hand[i+1].getValue())
				return true;
		return false;
	}
	
	private boolean checkFourOfAKind(Card[] hand){
		if(hand[0].getValue() == hand[3].getValue()	|| hand[1].getValue() == hand[4].getValue())
			return true;
		return false;
	}
	
	private boolean checkTwoPairs(Card[] hand){
		int pairCount = 0;
		for(int i = 0; i < hand.length-1; i++){
			if(hand[i].getValue() == hand[i+1].getValue()){
				pairCount++; 
				i++;
			}
		}
		return pairCount == 2;
	}

	private boolean checkStraight(Card[] hand){
		if(hand[0].getValue() == hand[hand.length-1].getValue() + 4)
			return false;
		return true;
	}
	
	private boolean checkFlush(Card[] hand){
		char firstSuit = hand[0].getSuit();
		for(int i = 1; i < hand.length; i++)
			if(hand[i].getSuit() != firstSuit)
				return false;
		return true;
	}
	
	protected int analyseHand(Card[] hand){
		Arrays.sort(hand, (card1, card2) -> card2.getValue() - card1.getValue());
		
		
		
		return PAIR;
	}
}
