package videopoker.cli;

import java.util.HashMap;

import videopoker.cli.functions.*;
import videopoker.model.GameManager;

public class CLIController {
	private HashMap<String, Function> functionMap;
	private CLIView view;
	private GameManager pokerManager = new GameManager(100);
	
	private void init(){
		functionMap.put("$", (aux) -> view.printCredits());
		functionMap.put("h", new HoldFunction(pokerManager));
		functionMap.put("s", (args) -> view.printStats(pokerManager));
	}
	
	public CLIController(){
		functionMap = new HashMap<String, Function>();
		
		view = new CLIView();
		init();
	}
	
	public void executeCommand(String denominator, String[] args){
		functionMap.get(denominator).execute(args);
	}
}
