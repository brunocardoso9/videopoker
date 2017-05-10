package videopoker.model;

public class Card {
	private static final char[] conversionTable = new char[]{'T','J','Q','K','A'};
	
	private int value;
	private char suit;
	
	private String ValueToText(){
		return value > 9? conversionTable[value-10]+"" : value+"";
	}
	
	private static int TextToValue(char text) throws NumberFormatException{
		int aux = 0;
		try{
			aux = Integer.parseInt(text+"");
		} catch(NumberFormatException e) {
			for(int i = 0; i < conversionTable.length; i++)
				if(conversionTable[i] == text)
					aux = i+10;
			if(aux == 0)
				throw e; // File is badly written
		}
		return aux;
	}
	
	@Override
	public String toString(){
		return ValueToText() + suit;
	}
	
	public int getValue(){
		return value;
	}
	
	public char getSuit(){
		return suit;
	}
	
	protected Card(int value, char suit){
		this.value = value;
		this.suit = suit;
	}
	
	protected Card(char value, char suit){
		this.value = TextToValue(value);
		this.suit = suit;
	}
}
