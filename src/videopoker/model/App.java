package videopoker.model;

import java.io.FileNotFoundException;
import java.io.IOException;

public class App {

	public static void main(String[] args) throws FileNotFoundException, IOException{
		Deck deck = new Deck("C:\\Users\\Bruno\\workspace\\VideoPoker\\src\\card-file.txt");
	}
}
