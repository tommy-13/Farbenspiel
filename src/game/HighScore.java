package game;

import io.safeLoad.HighScoreSafer;
import io.safeLoad.SafeException;

import java.util.HashMap;
import java.util.Map;

public class HighScore {
	
	private Map<Integer, String> names;
	private Map<Integer, Integer> scores;
	
	
	public HighScore(Map<Integer, String> names, Map<Integer, Integer> scores) {
		this.names = names;
		this.scores = scores;
	}
	public HighScore() {
		this(new HashMap<Integer, String>(), new HashMap<Integer, Integer>());
	}
	
	
	public int getCheckSum() {
		int sum = 0;
		for(int lvl : scores.keySet()) {
			if(names.containsKey(lvl)) {
				sum += lvl + names.get(lvl).length() - scores.get(lvl);
			}
		}
		return sum;
	}
	
	public String getName(int level) {
		if(names.containsKey(level)) {
			return names.get(level);
		}
		else {
			return "---";
		}
	}
	public int getScore(int level) {
		if(scores.containsKey(level)) {
			return scores.get(level);
		}
		else {
			return 0;
		}
	}
	
	public void set(int level, String name, int moves) {
		if(!scores.containsKey(level)) {
			names.put(level, name);
			scores.put(level, moves);
		}
		else if(moves < scores.get(level)){
			names.put(level, name);
			scores.put(level, moves);
		}
	}
	
	
	
	public void safe() throws SafeException {
		if(!HighScoreSafer.safeScore(this)) {
			throw new SafeException("highscore");
		}
	}
	public Map<Integer, Integer> getScores() {
		return scores;
	}

}
