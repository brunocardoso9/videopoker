package videopoker.cli;

import videopoker.model.GameManager;
import videopoker.model.HandInformation;

public class CLIView {
	public void printCredits(){
		System.out.println("Gatos");
	}
	
	public void printStats(GameManager gm){
		int royalFlushCount = gm.getStats().get(HandInformation.ROYAL_FLUSH_NAME);
	}
}
