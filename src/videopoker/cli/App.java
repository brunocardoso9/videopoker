package videopoker.cli;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class App {

	public static void main(String[] args) throws FileNotFoundException, IOException{
		CLIController controller = new CLIController();
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		String arg1 = sc.nextLine();
		controller.executeCommand(input, new String[]{arg1});
	}
}
