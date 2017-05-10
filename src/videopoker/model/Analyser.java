package videopoker.model;

class Analyser {	
	
	private HandInformation countDistinct(HandInformation hi){				
		Card[] hand = hi.hand;
		
		for(int i = 1; i < hand.length; i++){
			if(hand[i].getSuit() != hand[0].getSuit())
				hi.flush = false;
			if(hand[i].getValue() == hand[i-1].getValue())
				hi.distinctCards = false;
		}
		
		return hi;
	}

	private HandInformation testStraight(HandInformation hi){
		Card[] hand = hi.hand;
		
		for(int i = 1; i != hand.length; i++)
			if( hand[i].getValue() != hand[i-1].getValue() + 1 )
				return hi;

		hi.straight = true;
		return hi;
	}
		
	private HandInformation countPairs(HandInformation hi){
		Card[] hand = hi.hand;
		
		int equalCounter = 1;
		for(int i = 0; i < hand.length; i++){
			if(hand[i].getValue() == hand[i-1].getValue()){
				equalCounter++;
				if(i == hand.length-1){
					hi.managePair(equalCounter, hand[i].getValue());
				}
			} else {
				hi.managePair(equalCounter, hand[i-1].getValue());
				equalCounter = 1;
			}
		}
		return hi;
	}
	
	private HandInformation dissectHand(HandInformation hi){
		countDistinct(hi);
		
		if(!hi.distinctCards)
			return testStraight(hi);
			
		return countPairs(hi);
	}
	
	protected HandInformation analyseHand(Card[] hand){
		HandInformation hi = new HandInformation(hand);
		return dissectHand(hi);
	}
}
