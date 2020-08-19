package levelCreation;

import java.util.ArrayList;
import java.util.List;

import game.Field;
import game.FieldColor;
import game.Level;

public class LevelCreator {
	
	public static Level makeLevel(int levelNr, boolean moveOverGaps,
			FieldColor[][] curCol, FieldColor[][] wishCol) {
		List<Field> fields = new ArrayList<Field>();
		
		for(int row=0; row<curCol.length; row++) {
			for(int col=0; col<curCol[0].length; col++) {
				if(curCol[row][col] != FieldColor.NONE) {
					fields.add(new Field(col, row, curCol[row][col], wishCol[row][col]));
				}
			}
		}
		
		return new Level(levelNr, fields, moveOverGaps);
	}
	
	public static Level makeTestLevel(int levelNr, boolean moveOverGaps,
			FieldColor[][] curCol, FieldColor[][] wishCol) {
		List<Field> fields = new ArrayList<Field>();
		
		for(int row=0; row<curCol.length; row++) {
			for(int col=0; col<curCol[0].length; col++) {
				if(curCol[row][col] != FieldColor.NONE) {
					fields.add(new Field(col, row, curCol[row][col], wishCol[row][col]));
				}
			}
		}
		fields.add(new Field(curCol[0].length, curCol.length, FieldColor.GREEN, FieldColor.RED));
		
		return new Level(levelNr, fields, moveOverGaps);
	}

}
