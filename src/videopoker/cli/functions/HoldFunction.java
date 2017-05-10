package videopoker.cli.functions;

import videopoker.model.GameManager;

public final class HoldFunction implements Function{

	private GameManager gameManager;
	
	public HoldFunction(GameManager gm){
		gameManager = gm;
	}
	
	@Override
	public void execute(String[] arguments) {
		gameManager.discardCards(new byte[]{0,1,3});
	}
	
}
