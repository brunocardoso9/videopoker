package videopoker.model;

import java.util.HashMap;

public class StatisticsManager {
	public HashMap<String, Integer> statistics = new HashMap<String, Integer>();
	
	public void registerHand(String handName){
		int value = statistics.getOrDefault(handName, 0);
		statistics.put(handName, ++value);
	}
	
}
