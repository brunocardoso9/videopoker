package videopoker.model;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

class Deck {
	private static final int[] values = new int[13];
	private static final char[] suits = new char[]{'H', 'C', 'S', 'D'};
	
	static {
		for(int i = 0; i <= 12; i++)
			values[i] = i+2;
	}
	
	private ArrayList<Card> cards = new ArrayList<Card>();
	private int index = 0;
	
	protected Deck(){
		for(int i : values)
			for(char c : suits)
				cards.add(new Card(i, c));				
	}
	
	protected Card[] drawCards(int count){
		Card[] cards = new Card[count];
		for(int i = 0; i < count; i++)
			cards[i] = this.cards.get(i + index);
		index += count;
		return cards;
	}
	
	protected Deck(String fileName) throws FileNotFoundException, IOException {
		try(FileReader fr = new FileReader(fileName)){
			char[] buffer = new char[3];
			while(fr.read(buffer, 0, 3) != -1)
				cards.add(new Card(buffer[0], buffer[1]));
		}
	}

	protected void shuffle(){
		Collections.shuffle(cards);
		index = 0;
	}
}
