package levelCreation;

import game.FieldColor;
import game.Level;
import io.safeLoad.LevelSafer;

public class LevelCreator2 {
	
	private static final int levelNr = 10;
	
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
				{dgreen, dgreen, none,    none},
				{dgreen, dgreen, magenta, none},
				{none,   none,   cyan,    cyan},
				{none,   none,   orange,  orange}
		};
		FieldColor[][] wishCol = {
				{orange, cyan,   none,    none},
				{cyan,   orange, magenta, none},
				{none,   none,   dgreen,  dgreen},
				{none,   none,   dgreen,  dgreen}
		};
		return LevelCreator.makeLevel(levelNr + 1, true, curCol, wishCol);
	} // ok
	
	private static Level createLevel2() {
		FieldColor[][] curCol = {
				{none, brown, none},
				{blue, red, green},
				{none, orange, none}
		};
		FieldColor[][] wishCol = {
				{none, orange, none},
				{red, blue, green},
				{none, brown, none}
		};
		return LevelCreator.makeLevel(levelNr + 2, true, curCol, wishCol);
	} // ok
	
	private static Level createLevel3() {
		FieldColor[][] curCol = {
				{none, none, blue,   green},
				{none, none, green,   red},
				{red, green, red, green},
				{blue, blue, red, blue}
		};
		FieldColor[][] wishCol = {
				{none, none, red,   red},
				{none, none, red,   red},
				{blue, blue, green, green},
				{blue, blue, green, green}
		};
		return LevelCreator.makeLevel(levelNr + 3, true, curCol, wishCol);
	} // ok
	
	private static Level createLevel4() {
		FieldColor[][] curCol = {
				{blue,   blue, blue,   blue, blue, blue,   blue,   blue},
				{dgreen, red,  dgreen, blue, red,  dgreen, dgreen, blue},
				{red,    red,  red,    red,  red,  red,    red,    red}
		};
		FieldColor[][] wishCol = {
				{red, red, red, none, none, blue, blue, blue},
				{red, red, red, none, none, blue, blue, blue},
				{red, red, red, none, none, blue, blue, blue}
		};
		return LevelCreator.makeLevel(levelNr + 4, true, curCol, wishCol);
	} // ok
	
	private static Level createLevel5() {
		FieldColor[][] curCol = {
				{green, green, blue, red, red},
				{green, green, none, red, red}
		};
		FieldColor[][] wishCol = {
				{red, red, blue, green, green},
				{red, red, none, green, green}
		};
		return LevelCreator.makeLevel(levelNr + 5, false, curCol, wishCol);
	} // ok
	
	private static Level createLevel6() {
		FieldColor[][] curCol = {
				{blue, blue, green, red, red},
				{blue, blue, none, red, red},
				{green, none, none, none, green},
				{red, red, none, blue, blue},
				{red, red, green, blue, blue}
		};
		FieldColor[][] wishCol = {
				{red, red, green, blue, blue},
				{red, red, none, blue, blue},
				{green, none, none, none, green},
				{blue, blue, none, red, red},
				{blue, blue, green, red, red}
		};
		return LevelCreator.makeLevel(levelNr + 6, false, curCol, wishCol);
	} // ok
	
	private static Level createLevel7() {
		FieldColor[][] curCol = {
				{lila, blue, brown, none, lila, green, red},
				{blue, lila, green, none, lila, red, green},
				{blue, green, brown, brown, red, green, brown},
				{none, none, blue, red, brown, none, none},
				{none, none, red, green, red, none, none}
		};
		FieldColor[][] wishCol = {
				{none, none, none, none, none, none, none},
				{none, red, red, none, blue, blue, none},
				{none, red, red, lila, blue, blue, none},
				{none, none, none, none, none, none, none},
				{none, none, lila, none, lila, none, none}
		};
		return LevelCreator.makeLevel(levelNr + 7, true, curCol, wishCol);
	} // ok
	
	private static Level createLevel8() {
		FieldColor[][] curCol = {
				{none, none,  none,  green, red, none},
				{red,  blue,  none,  red,  red,  none},
				{blue, blue,  green, red,  none, none},
				{none, none,  red,   blue, red,  blue},
				{none, blue,  blue,  none, red,  green},
				{none, green, blue,  none, none, none}
		};
		FieldColor[][] wishCol = {
				{none, none, none,  blue,  blue, none},
				{red,  red,  none,  blue,  blue, none},
				{red,  red,  green, green, none, none},
				{none, none, green, green, blue, blue},
				{none, red,  red,   none,  blue, blue},
				{none, red,  red,   none,  none, none}
		};
		return LevelCreator.makeLevel(levelNr + 8, true, curCol, wishCol);
	} // ok
	
	private static Level createLevel9() {
		FieldColor[][] curCol = {
				{green, lila, blue, blue, green, green, blue, blue, lila,  green, blue, blue},
				{green, blue, none, none, none,  none,  none, none, blue,  blue,  none, none},
				{green, blue, none, none, none,  none,  none, none, green, lila,  none, none},
				{blue,  red,  none, none, none,  none,  none, none, green, blue,  none, none}
		};
		FieldColor[][] wishCol = {
				{blue,  blue,  none, none, none, none, none, none, blue,  blue,  none, red},
				{blue,  blue,  none, none, none, none, none, none, blue,  blue,  none, none},
				{green, green, none, none, none, none, none, none, green, green, none, none},
				{green, green, none, none, none, none, none, none, green, green, none, none}
		};
		return LevelCreator.makeLevel(levelNr + 9, true, curCol, wishCol);
	} // ok
	
	private static Level createLevel10() {
		FieldColor[][] curCol = {
				{none, none, blue,  red,   none,  none},
				{none, none, red,   blue,  none,  none},
				{red,  red,  blue,  red,   blue,  green},
				{red,  red,  blue,  blue,  green, blue},
				{none, none, blue,  green, none,  none},
				{none, none, green, red,  none,   none}
		};
		FieldColor[][] wishCol = {
				{none, none, red,   red,   none, none},
				{none, none, red,   red,   none, none},
				{blue, blue, green, green, red,  red},
				{blue, blue, green, green, red,  red},
				{none, none, blue,  blue,  none, none},
				{none, none, blue,  blue,  none, none}
		};
		return LevelCreator.makeLevel(levelNr + 10, true, curCol, wishCol);
	} // ok
	

	public static void main(String[] args) {
		LevelSafer.safeLevel(createLevel1());
		LevelSafer.safeLevel(createLevel2());
		LevelSafer.safeLevel(createLevel3());
		LevelSafer.safeLevel(createLevel4());
		LevelSafer.safeLevel(createLevel5());
		LevelSafer.safeLevel(createLevel6());
		LevelSafer.safeLevel(createLevel7());
		LevelSafer.safeLevel(createLevel8());
		LevelSafer.safeLevel(createLevel9());
		LevelSafer.safeLevel(createLevel10());
		
		int from = levelNr + 1;
		int to   = levelNr + 10;
		System.out.println("Level " + from + " - " + to + " erzeugt.");
	}

}
