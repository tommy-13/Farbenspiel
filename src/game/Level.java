package game;

import java.util.List;

public class Level {

	private int levelNumber;
	private boolean moveOverGaps;
	private List<Field> fields;
	
	
	public Level(int levelNumber, List<Field> fields, boolean moveOverGaps) {
		this.levelNumber = levelNumber;
		this.fields = fields;
		this.moveOverGaps = moveOverGaps;
	}
	
	
	public int getCheckSum() {
		int sum = levelNumber * (moveOverGaps ? 3 : 7);
		sum += fields.size();
		for(Field f : fields) {
			sum += (f.getXOnBoard() + 2*f.getYOnBoard()) * (3*f.getDesiredColor().ordinal() + f.getCurrentColor().ordinal());
		}
		return sum;
	}
	
	public int getLevelNumber() {
		return levelNumber;
	}
	public boolean getMoveOverGaps() {
		return moveOverGaps;
	}
	public List<Field> getFields() {
		return fields;
	}
	
}
