package videopoker.cli;

import videopoker.model.GameManager;

public class CLIView {
	public void printCredits(){
		System.out.println("Gatos");
	}
	
	public void printStats(GameManager gm){
		String x = gm.getStats();
	}
}
