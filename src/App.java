

import java.io.FileNotFoundException;
import java.io.IOException;

import videopoker.model.Deck;

public class App {

	public static void main(String[] args) throws FileNotFoundException, IOException{
		Deck deck = new Deck("card-file.txt");
	}
}
