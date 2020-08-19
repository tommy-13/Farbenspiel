package levelCreation;

import game.FieldColor;
import game.Level;
import io.safeLoad.LevelSafer;

public class TestLevelCreator {
	
	// breite höchstens 23
	// höhe höchstens 
	
	private static final FieldColor none 	= FieldColor.NONE;
	private static final FieldColor red  	= FieldColor.RED;
	private static final FieldColor green 	= FieldColor.GREEN;
	private static final FieldColor blue 	= FieldColor.BLUE;
	private static final FieldColor cyan 	= FieldColor.CYAN;
	private static final FieldColor dgreen 	= FieldColor.DARKGREEN;
	private static final FieldColor magenta = FieldColor.MAGENTA;
	private static final FieldColor brown 	= FieldColor.BROWN;
	private static final FieldColor orange 	= FieldColor.ORANGE;
	private static final FieldColor lila 	= FieldColor.LILAC;
	
	
	private static Level createLevel1() {
		FieldColor[][] curCol = {
				{none,    orange,  none,    none,    none,   orange, none,    magenta, none, none, none, none, brown, none, none, none, green, none, none, none},
				{none,    none,    orange,  none,    orange, none,   none,    dgreen, none, none, brown, none, none, none, none, none, none, none, red, none},
				{orange,  none,    none,    none,    none,   none,   none,    none, none, brown, none, none, none, green, none, cyan, none, none, none, lila},
				{none,    none,    orange,  none,    none,   dgreen, none,    none, brown, none, none, none, green, none, cyan, cyan, none, red, none, none},
				{none,    none,    none,    magenta, none,   none,   dgreen,  none, brown, none, none, none, none, cyan, none, none, red, none, none, blue},
				{magenta, none,    magenta, none,    none,   dgreen, brown,   none, green, none, none, cyan, none, none, none, none, none, lila, none, none},
				{none,    magenta, none,    none,    dgreen, none,   none,    green, none, none, none, none, red, none, lila, none, lila, none, none, blue},
				{none,    none,    none,    brown,   none,   none,   green, none, none, cyan, none, red, none, none, none, none, none, blue, none, none},
				{dgreen,  dgreen,  none,    none,    none,   none,   none,    none, cyan, none, none, none, lila, none, blue, none, none, none, none, blue}
		};
		FieldColor[][] wishCol = {
				{none, blue, none, none, none, blue, none, blue, none, none, none, none, blue, none, none, none, blue, none, none, none},
				{none, none, lila, none, lila, none, none, lila, none, none, lila, none, none, none, none, none, none, none, lila, none},
				{red, none, none, none, none, none, none, none, none, red, none, none, none, red, none, red, none, none, none, red},
				{none, none, cyan, none, none, cyan, none, none, cyan, none, none, none, cyan, none, cyan, cyan, none, cyan, none, none},
				{none, none, none, green, none, none, green, none, green, none, none, none, none, green, none, none, green, none, none, green},
				{brown, none, brown, none, none, brown, brown, none, brown, none, none, brown, none, none, none, none, none, brown, none, none},
				{none, dgreen, none, none, dgreen, none, none, dgreen, none, none, none, none, dgreen, none, dgreen, none, dgreen, none, none, dgreen},
				{none, none, none, magenta, none, none, magenta, none, none, magenta, none, magenta, none, none, none, none, none, magenta, none, none},
				{orange, orange, none, none, none, none, none, none, orange, none, none, none, orange, none, orange, none, none, none, none, orange}
		};
		//return LevelCreator.makeLevel(1, true, curCol, wishCol);
		return LevelCreator.makeTestLevel(1, true, curCol, wishCol);
	}

	public static void main(String[] args) {
		LevelSafer.safeLevel(createLevel1());
		System.out.println("Level 1 erzeugt.");
	}

}
