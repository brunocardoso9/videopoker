package videopoker.model;

class Player {
	private Card[] hand = new Card[5];
	private int credits;
	
	protected Player(int credits){
		this.credits = credits;
	}

	protected Card[] getHand(){
		return hand;
	}
	
	protected void giveHand(Card[] cards){
		this.hand = cards;
	}
	
	protected void giveCards(Card[] cards){
		for(int i = 0, j = 0; i < this.hand.length && j < cards.length; i++)
			if(this.hand[i] == null)
				this.hand[i] = cards[j++];
	}
	
	protected void discardCards(byte[] indexes){
		for(byte idx : indexes)
			this.hand[idx] = null;
	}
	
	protected void giveCredits(int credits){
		this.credits += credits;
	}
	
	protected void takeCredits(int credits){
		this.credits -= credits;
	}
	
	protected int getCredits(){
		return credits;
	}
}
