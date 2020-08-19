package player;

import io.safeLoad.PlayerSafer;
import io.safeLoad.SafeException;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class Player {
	
	public static final int MAX_PLAYER_NAME_LENGTH = 10;
	
	private int id;
	private String name;
	private int maxLevel;
	private Map<Integer, Integer> moves;
	
	
	public Player(int id, String name, int level, Map<Integer, Integer> moves) {
		this.id = id;
		this.name = name;
		this.maxLevel = level;
		this.moves = moves;
	}
	public Player(int id, String name) {
		this(id, name, 1, new HashMap<Integer, Integer>());
	}
	
	
	public int getId() {
		return id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public void setNextLevel(int level) {
		this.maxLevel = level;
	}
	public void setMoves(Map<Integer, Integer> moves) {
		this.moves = moves;
	}
	public void setMoves(int level, int steps) {
		if(!moves.containsKey(level)) {
			moves.put(level, steps);
		}
		else {
			moves.put(level, Math.min(steps, moves.get(level)));
		}
	}
	
	
	public String getName() {
		return name;
	}
	public int getNextLevel() {
		return maxLevel;
	}
	public int getMoves(int level) {
		if(moves.containsKey(level)) {
			return moves.get(level);
		}
		else {
			return 0;
		}
	}
	public int getSumMoves() {
		int sum = 0;
		for(int m : moves.values()) {
			sum += m;
		}
		return sum;
	}
	
	
	public int getCheckSum() {
		int sum = 0;
		sum += (id + maxLevel) * name.length();
		for(Map.Entry<Integer, Integer> entry : moves.entrySet()) {
			sum += entry.getKey() * entry.getValue();
		}
		return sum;
	}
	
	
	public void safe() throws SafeException {
		if(!PlayerSafer.safePlayer(this)) {
			throw new SafeException("player " + name);
		}
	}
	
	public void delete() throws PlayerDeletingException {
		String path = PlayerSafer.safeFolder + id + ".ply";
		if(!new File(path).delete()) {
			throw new PlayerDeletingException(name);
		}
	}
	public Map<Integer, Integer> getMoves() {
		return moves;
	}

}
