package levelCreation;

import game.FieldColor;
import game.Level;
import io.safeLoad.LevelSafer;

public class LevelCreator1 {
	
	private static final int levelNr = 0;
	
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
				{red, green, green},
				{green, green, none},
				{red, green, green}
		};
		FieldColor[][] wishCol = {
				{none, none, red},
				{none, none, none},
				{none, none, red}
		};
		return LevelCreator.makeLevel(levelNr + 1, true, curCol, wishCol);
	}
	
	private static Level createLevel2() {
		FieldColor[][] curCol = {
				{red, none, none},
				{red, green, green},
				{red, red, red}
		};
		FieldColor[][] wishCol = {
				{green, none, none},
				{none, none, none},
				{green, none, none}
		};
		return LevelCreator.makeLevel(levelNr + 2, true, curCol, wishCol);
	}
	
	private static Level createLevel3() {
		FieldColor[][] curCol = {
				{blue, green, red},
				{green, red, green},
				{red, green, green}
		};
		FieldColor[][] wishCol = {
				{red, red, none},
				{red, blue, none},
				{none, none, none}
		};
		return LevelCreator.makeLevel(levelNr + 3, true, curCol, wishCol);
	}
	
	private static Level createLevel4() {
		FieldColor[][] curCol = {
				{green, red, orange},
				{blue, none, blue},
				{orange, orange, orange}
		};
		FieldColor[][] wishCol = {
				{red, green, blue},
				{none, none, none},
				{none, blue, none}
		};
		return LevelCreator.makeLevel(levelNr + 4, true, curCol, wishCol);
	}
	
	private static Level createLevel5() {
		FieldColor[][] curCol = {
				{blue, blue, orange, none, none, none, none},
				{green, blue, green, red, orange, red, orange},
				{none, none, none, none, orange, red, orange}
		};
		FieldColor[][] wishCol = {
				{none, none, none, none, none, none, none},
				{red, red, red, green, blue, blue, blue},
				{none, none, none, none, none, none, none}
		};
		return LevelCreator.makeLevel(levelNr + 5, true, curCol, wishCol);
	}
	
	private static Level createLevel6() {
		FieldColor[][] curCol = {
				{blue, red, blue},
				{blue, blue, red},
				{red, red, blue}
		};
		FieldColor[][] wishCol = {
				{red, blue, blue},
				{red, blue, blue},
				{red, none, none}
		};
		return LevelCreator.makeLevel(levelNr + 6, true, curCol, wishCol);
	}
	
	private static Level createLevel7() {
		FieldColor[][] curCol = {
				{blue, orange, blue},
				{orange, orange, red},
				{red, red, blue}
		};
		FieldColor[][] wishCol = {
				{red, blue, orange},
				{red, blue, orange},
				{red, blue, orange}
		};
		return LevelCreator.makeLevel(levelNr + 7, true, curCol, wishCol);
	}
	
	private static Level createLevel8() {
		FieldColor[][] curCol = {
				{none, none, red, red},
				{none, dgreen, red, red},
				{blue, blue, dgreen, none},
				{blue, blue, none, none}
		};
		FieldColor[][] wishCol = {
				{none, none, blue, blue},
				{none, none, blue, blue},
				{red, red, none, none},
				{red, red, none, none}
		};
		return LevelCreator.makeLevel(levelNr + 8, true, curCol, wishCol);
	}
	
	private static Level createLevel9() {
		FieldColor[][] curCol = {
				{none, none, red, none, none},
				{none, blue, green, blue, none},
				{red, green, brown, green, red},
				{none, blue, green, blue, none},
				{none, none, red, none, none}
		};
		FieldColor[][] wishCol = {
				{none, none, none, none, none},
				{none, red, none, red, none},
				{none, none, none, none, none},
				{none, red, none, red, none},
				{none, none, none, none, none}
		};
		return LevelCreator.makeLevel(levelNr + 9, true, curCol, wishCol);
	}
	
	private static Level createLevel10() {
		FieldColor[][] curCol = {
				{blue, none, blue, blue, blue},
				{red,  none, red,  none, red},
				{blue, none, blue, none, red},
				{blue, none, blue, none, blue},
				{blue, none, blue, blue, red}
		};
		FieldColor[][] wishCol = {
				{red, none, blue, blue, blue},
				{red, none, blue, none, blue},
				{red, none, blue, none, blue},
				{red, none, blue, none, blue},
				{red, none, blue, blue, blue}
		};
		return LevelCreator.makeLevel(levelNr + 10, true, curCol, wishCol);
	}
	

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
