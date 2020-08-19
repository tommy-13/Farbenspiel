package levelCreation;

import game.FieldColor;
import game.Level;
import io.safeLoad.LevelSafer;

public class LevelCreator3 {
	
	private static final int levelNr = 20;
	
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
				{lila,   dgreen, none,   none, lila,   lila,   none,   none},
				{brown,  lila,   none,   none, dgreen, blue,   none,   none},
				{dgreen, brown,  brown,  lila, blue,   dgreen, brown,  dgreen},
				{none,   none,   brown,  blue, none,   none,   blue,   blue},
				{none,   none,   blue,   lila, none,   none,   dgreen, brown}
		};
		FieldColor[][] wishCol = {
				{blue, blue, none,   none,   brown, brown, none, none},
				{blue, blue, none,   none,   brown, brown, none, none},
				{blue, blue, dgreen, dgreen, brown, brown, lila, lila},
				{none, none, dgreen, dgreen, none, none,   lila, lila},
				{none, none, dgreen, dgreen, none, none,   lila, lila}
		};
		return LevelCreator.makeLevel(levelNr + 1, false, curCol, wishCol);
	} // ok
	
	private static Level createLevel2() {
		FieldColor[][] curCol = {
				{lila,   dgreen, none,  none,  dgreen, dgreen, none,  none},
				{dgreen, lila,   none,  none,  lila,   lila,   none,  none},
				{lila,   dgreen, brown, brown, lila,   dgreen, blue,  brown},
				{none,   none,   brown, blue,  none,   none,   blue,  brown},
				{none,   none,   blue,  blue,  none,   none,   brown, blue}
		};
		FieldColor[][] wishCol = {
				{blue, blue, none,   none,   brown, brown, none, none},
				{blue, blue, none,   none,   brown, brown, none, none},
				{blue, blue, dgreen, dgreen, brown, brown, lila, lila},
				{none, none, dgreen, dgreen, none, none,   lila, lila},
				{none, none, dgreen, dgreen, none, none,   lila, lila}
		};
		return LevelCreator.makeLevel(levelNr + 2, true, curCol, wishCol);
	} // ok
	
	private static Level createLevel3() {
		FieldColor[][] curCol = {
				{orange, magenta, blue, magenta, dgreen, magenta, magenta},
				{orange, none,    blue, none,    dgreen, none,    magenta},
				{orange, blue,    blue, blue,    dgreen, orange,  magenta},
				{orange, none,    blue, none,    dgreen, none,    magenta},
				{orange, dgreen,  blue, dgreen,  dgreen, orange,  magenta}
		};
		FieldColor[][] wishCol = {
				{orange,  orange, orange,  orange, orange,  orange, orange},
				{magenta, none,   magenta, none,   magenta, none,   magenta},
				{blue,    blue,   blue,    blue,   blue,    blue,   blue},
				{magenta, none,   magenta, none,   magenta, none,   magenta},
				{dgreen,  dgreen, dgreen,  dgreen, dgreen,  dgreen, dgreen}
		};
		return LevelCreator.makeLevel(levelNr + 3, true, curCol, wishCol);
	} // ok
	
	private static Level createLevel4() {
		FieldColor[][] curCol = {
				{brown, brown, brown, none, none,  green, green, green, none},
				{brown, brown, brown, red,  red,   green, green, green, none},
				{brown, brown, brown, none, none,  green, green, green, none},
				{none,  none,  none,  none, none,  none,  none,  red,   none},
				{none,  cyan,  cyan,  cyan, none,  none,  none,  red,   none},
				{none,  cyan,  cyan,  cyan, green, green, red,   red,   red},
				{none,  cyan,  cyan,  cyan, none,  none,  red,   red,   red},
				{none,  none,  none,  none, none,  none,  red,   red,   red}
		};
		FieldColor[][] wishCol = {
				{cyan, cyan,  cyan,  none,  none, green, green, green, none},
				{cyan, cyan,  cyan,  none,  none, green, green, green, none},
				{cyan, cyan,  cyan,  none,  none, green, green, green, none},
				{none, none,  none,  none,  none, none,  none,  none,  none},
				{none, brown, brown, brown, none, none,  none,  none,  none},
				{none, brown, brown, brown, none, none,  red,   red,   red},
				{none, brown, brown, brown, none, none,  red,   red,   red},
				{none, none,  none,  none,  none, none,  red,   red,   red}
		};
		return LevelCreator.makeLevel(levelNr + 4, false, curCol, wishCol);
	} // ok
	
	private static Level createLevel5() {
		FieldColor[][] curCol = {
				{green, red,   red,   green, none, blue,   orange, orange, blue},
				{red,   green, green, red,   lila, orange, blue,   blue,   orange},
				{red,   green, green, red,   none, orange, blue,   blue,   orange},
				{green, red,   red,   green, none, blue,   orange, orange, blue}
		};
		FieldColor[][] wishCol = {
				{orange, blue,   blue,   orange, none, red,   green, green, red},
				{blue,   orange, orange, blue,   lila, green, red,   red,   green},
				{blue,   orange, orange, blue,   none, green, red,   red,   green},
				{orange, blue,   blue,   orange, none, red,   green, green, red}
		};
		return LevelCreator.makeLevel(levelNr + 5, false, curCol, wishCol);
	} // ok
	
	private static Level createLevel6() {
		FieldColor[][] curCol = {
				{blue, orange, blue, red, blue, red, orange},
				{orange, orange, green, red, orange, red, orange},
				{red, green, orange, red, blue, blue, blue},
				{green, orange, red, blue, red, green, blue}
		};
		FieldColor[][] wishCol = {
				{red, red, blue, blue, orange, orange, green},
				{red, red, blue, blue, orange, orange, green},
				{red, red, blue, blue, orange, orange, green},
				{red, red, blue, blue, orange, orange, green}
		};
		return LevelCreator.makeLevel(levelNr + 6, true, curCol, wishCol);
	} // ok
	
	private static Level createLevel7() {
		FieldColor[][] curCol = {
				{green, blue, blue,  none, blue,  red,   blue,  none, green, red,  brown, none, blue, brown, red},
				{none,  none, red,   none, none,  none,  red,   none, green, none, none,  none, none, none, green},
				{none,  none, brown, none, green, blue,  red,   none, green, red,  brown, none, blue, brown, brown},
				{none,  none, red,   none, none,  none,  blue,  none, none,  none, brown, none, none, none, red},
				{none,  none, brown, none, blue,  brown, blue,  none, green, red,  brown, none, blue, brown, red}
		};
		FieldColor[][] wishCol = {
				{green, green, green, none, red,  red,  red, none, blue, blue, blue, none, brown, brown, brown},
				{none,  none,  green, none, none, none, red, none, blue, none, none, none, none,  none,  brown},
				{none,  none,  green, none, red,  red,  red, none, blue, blue, blue, none, brown, brown, brown},
				{none,  none,  green, none, none, none, red, none, none, none, blue, none, none,  none,  brown},
				{none,  none,  green, none, red,  red,  red, none, blue, blue, blue, none, brown, brown, brown}
		};
		return LevelCreator.makeLevel(levelNr + 7, true, curCol, wishCol);
	} // ok
	
	private static Level createLevel8() {
		FieldColor[][] curCol = {
				{none, none, none, none,  green, green, green, none,  none, none, none},
				{none, none, none, green, green, green, green, green, none, none, none},
				{none, none, cyan, cyan,  lila,  lila,  lila,  blue,  blue, none, none},
				{none, cyan, cyan, lila,  none,  none,  none,  lila,  blue, blue, none},
				{cyan, cyan, cyan, lila,  none,  none,  none,  lila,  blue, blue, blue},
				{none, cyan, cyan, lila,  none,  none,  none,  lila,  blue, blue, none},
				{none, none, cyan, cyan,  red,   red,   red,   blue,  blue, none, none},
				{none, none, none, cyan,  red,   red,   red,   blue,  none, none, none},
				{none, none, none, none,  red,   red,   red,   none,  none, none, none}
		};
		FieldColor[][] wishCol = {
				{none, none, none,  none,  red,  red,  red,  none,  none,  none, none},
				{none, none, none,  blue,  red,  red,  red,  cyan,  none,  none, none},
				{none, none, blue,  blue,  red,  red,  red,  cyan,  cyan,  none, none},
				{none, blue, blue,  green, none, none, none, green, cyan,  cyan, none},
				{blue, blue, green, green, none, none, none, green, green, cyan, cyan},
				{none, blue, blue,  green, none, none, none, green, cyan,  cyan, none},
				{none, none, blue,  blue,  lila, lila, lila, cyan,  cyan,  none, none},
				{none, none, none,  blue,  lila, lila, lila, cyan,  none,  none, none},
				{none, none, none,  none,  lila, lila, lila, none,  none,  none, none}
		};
		return LevelCreator.makeLevel(levelNr + 8, false, curCol, wishCol);
	} // ok
	
	private static Level createLevel9() {
		FieldColor[][] curCol = {
				{green, green, lila, red,   green, red},
				{lila,  red,   blue, lila,  red,   blue},
				{green, blue,  lila, blue,  green, red},
				{lila,  red,   blue, red,   red,   blue},
				{lila,  green, lila, lila,  blue,  green},
				{red,   lila,  blue, green, blue,  green}
		};
		FieldColor[][] wishCol = {
				{red,  red,  red,  green, green, green},
				{red,  red,  red,  green, green, green},
				{red,  red,  red,  green, green, green},
				{blue, blue, blue, lila,  lila,  lila},
				{blue, blue, blue, lila,  lila,  lila},
				{blue, blue, blue, lila,  lila,  lila}
		};
		return LevelCreator.makeLevel(levelNr + 9, true, curCol, wishCol);
	} // ok
	
	private static Level createLevel10() {
		FieldColor[][] curCol = {
				{blue, blue, blue, blue, blue, blue,    blue,    blue,    blue,    none,    none,    green, green,  green},
				{blue, blue, blue, none, none, blue,    blue,    blue,    blue,    none,    none,    green, dgreen, green},
				{blue, blue, blue, none, none, magenta, magenta, magenta, magenta, magenta, magenta, green, green,  green},
				{blue, blue, blue, none, none, blue,    blue,    blue,    dgreen,  none,    none,    red,   red,    red},
				{blue, blue, blue, blue, blue, dgreen,  dgreen,  dgreen,  dgreen,  none,    none,    red,   red,    red}
		};
		FieldColor[][] wishCol = {
				{blue, blue, blue, dgreen, dgreen, blue,  blue,  blue,  blue,  none,   none,   blue,    blue,    blue},
				{red,  red,  red,  none,   none,   green, green, green, green, none,   none,   magenta, magenta, magenta},
				{blue, blue, blue, none,   none,   blue,  blue,  blue,  blue,  dgreen, dgreen, blue,    blue,    blue},
				{red,  red,  red,  none,   none,   green, green, green, green, none,   none,   magenta, magenta, magenta},
				{blue, blue, blue, dgreen, dgreen, blue,  blue,  blue,  blue,  none,   none,   blue,    blue,    blue}
		};
		return LevelCreator.makeLevel(levelNr + 10, false, curCol, wishCol);
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
