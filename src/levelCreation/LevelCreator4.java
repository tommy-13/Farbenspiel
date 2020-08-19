package levelCreation;

import game.FieldColor;
import game.Level;
import io.safeLoad.LevelSafer;

public class LevelCreator4 {
	
	private static final int levelNr = 30;
	
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
				{dgreen, red,  orange, lila, none, none, none, none,   none,   none,   dgreen, dgreen, red,  red},
				{dgreen, red,  orange, lila, none, none, none, none,   none,   none,   dgreen, dgreen, red,  red},
				{dgreen, red,  orange, lila, cyan, cyan, lila, none,   none,   none,   orange, orange, lila, lila},
				{none,   none, none,   none, cyan, cyan, cyan, red,    dgreen, blue,   orange, orange, lila, lila},
				{none,   cyan, cyan,   cyan, lila, cyan, cyan, orange, blue,   dgreen, none,   none,   none, none},
				{none,   cyan, cyan,   cyan, none, none, none, blue,   orange, red,    none,   none,   none, none},
				{none,   cyan, cyan,   cyan, none, none, none, none,   none,   blue,   blue,   blue,   none, none},
				{none,   none, none,   none, none, none, none, none,   none,   blue,   blue,   blue,   none, none},
				{none,   none, none,   none, none, none, none, none,   none,   blue,   blue,   blue,   none, none}
		};
		FieldColor[][] wishCol = {
				{blue, blue,   blue,   blue,   none,   none,   none,   none, none, none, cyan, cyan, cyan, cyan},
				{blue, blue,   blue,   blue,   none,   none,   none,   none, none, none, cyan, cyan, cyan, cyan},
				{blue, blue,   blue,   blue,   orange, orange, orange, none, none, none, cyan, cyan, cyan, cyan},
				{none, none,   none,   none,   orange, orange, orange, lila, lila, lila, cyan, cyan, cyan, cyan},
				{none, dgreen, dgreen, dgreen, orange, orange, orange, lila, lila, lila, none, none, none, none},
				{none, dgreen, dgreen, dgreen, none,   none,   none,   lila, lila, lila, none, none, none, none},
				{none, dgreen, dgreen, dgreen, none,   none,   none,   none, none, red,  red,  red,  none, none},
				{none, none,   none,   none,   none,   none,   none,   none, none, red,  red,  red,  none, none},
				{none, none,   none,   none,   none,   none,   none,   none, none, red,  red,  red,  none, none}
		};
		return LevelCreator.makeLevel(levelNr + 1, true, curCol, wishCol);
	} // ok
	
	private static Level createLevel2() {
		FieldColor[][] curCol = {
				{green,  brown,  green,  brown,  green,  cyan,   green,  cyan,   brown,  cyan,   brown,  cyan},
				{brown,  green,  brown,  green,  cyan,   green,  cyan,   green,  cyan,   brown,  cyan,   brown},
				{green,  brown,  green,  brown,  green,  cyan,   green,  cyan,   brown,  cyan,   brown,  cyan},
				{blue,   blue,   blue,   blue,   blue,   blue,   blue,   blue,   blue,   blue,   blue,   blue},
				{orange, orange, orange, orange, orange, orange, orange, orange, orange, orange, orange, orange},
				{lila,   lila,   lila,   lila,   lila,   lila,   lila,   lila,   lila,   lila,   lila,   lila}
		};
		FieldColor[][] wishCol = {
				{blue, blue, blue, blue, lila,  lila,  lila,  lila,  orange, orange, orange, orange},
				{blue, blue, blue, blue, lila,  lila,  lila,  lila,  orange, orange, orange, orange},
				{blue, blue, blue, blue, lila,  lila,  lila,  lila,  orange, orange, orange, orange},
				{cyan, cyan, cyan, cyan, brown, brown, brown, brown, green,  green,  green,  green},
				{cyan, cyan, cyan, cyan, brown, brown, brown, brown, green,  green,  green,  green},
				{cyan, cyan, cyan, cyan, brown, brown, brown, brown, green,  green,  green,  green}
		};
		return LevelCreator.makeLevel(levelNr + 2, true, curCol, wishCol);
	} // ok
	
	private static Level createLevel3() {
		FieldColor[][] curCol = {
				{red,   lila, red,   lila,  red,   dgreen, cyan,   cyan,   dgreen, dgreen, dgreen, dgreen},
				{red,   red,  red,   red,   red,   dgreen, cyan,   cyan,   dgreen, dgreen, dgreen, dgreen},
				{lila,  red,  lila,  red,   red,   dgreen, dgreen, dgreen, dgreen, cyan,   cyan,   cyan},
				{none,  none, none,  none,  none,  none,   none,   none,   none,   cyan,   cyan,   blue},
				{green, lila, green, green, green, green,  brown,  brown,  blue,   blue,   blue,   blue},
				{green, lila, green, green, green, green,  brown,  brown,  blue,   blue,   blue,   blue},
				{green, lila, green, green, green, brown,  brown,  brown,  brown,  brown,  brown,  brown}
		};
		FieldColor[][] wishCol = {
				{blue,  green,  green,  green,  blue,  green,  green,  green,  blue,  green,  green,  green},
				{brown, blue,   green,  blue,   brown, blue,   green,  blue,   brown, lila,   green,  green},
				{brown, brown,  blue,   brown,  brown, brown,  blue,   brown,  brown, brown,  lila,   green},
				{none,  none,   none,   none,   none,  none,   none,   none,   none,  lila,   lila,   lila},
				{red,   red,    cyan,   red,    red,   red,    cyan,   red,    red,   red,    lila,   dgreen},
				{red,   cyan,   dgreen, cyan,   red,   cyan,   dgreen, cyan,   red,   lila,   dgreen, dgreen},
				{cyan,  dgreen, dgreen, dgreen, cyan,  dgreen, dgreen, dgreen, cyan,  dgreen, dgreen, dgreen}
		};
		return LevelCreator.makeLevel(levelNr + 3, false, curCol, wishCol);
	} // ok
	
	private static Level createLevel4() {
		FieldColor[][] curCol = {
				{none,    none,    orange,  red,     red,     red,   red,   red,   red,  red},
				{none,    none,    orange,  none,    none,    none,  none,  none,  none, red},
				{none,    none,    orange,  none,    lila,    lila,  lila,  lila,  none, blue},
				{brown,   none,    orange,  none,    lila,    lila,  none,  lila,  none, blue},
				{brown,   none,    orange,  none,    none,    none,  none,  green, none, blue},
				{magenta, none,    green,   green,   green,   green, green, green, none, blue},
				{magenta, none,    none,    none,    none,    none,  none,  none,  none, blue},
				{magenta, magenta, magenta, magenta, magenta, blue,  blue,  blue,  blue, blue}
		};
		FieldColor[][] wishCol = {
				{none,    none,  blue,   blue,   green,   green,   red,  green, green, red},
				{none,    none,  blue,   none,   none,    none,    none, none,  none,  red},
				{none,    none,  lila,   none,   brown,   magenta, blue, red,   none,  lila},
				{blue,    none,  lila,   none,   magenta, brown,   none, red,   none,  lila},
				{green,   none,  orange, none,   none,    none,    none, blue,  none,  magenta},
				{red,     none,  orange, orange, magenta, magenta, blue, blue,  none,  blue},
				{lila,    none,  none,   none,   none,    none,    none, none,  none,  blue},
				{magenta, green, green,  orange, orange,  red,     red,  lila,  lila,  magenta}
		};
		return LevelCreator.makeLevel(levelNr + 4, false, curCol, wishCol);
	} // ok
	
	private static Level createLevel5() {
		FieldColor[][] curCol = {
				{dgreen, none, none, dgreen, none, none,  dgreen, none,  none,  dgreen, none,  none,  dgreen},
				{red,    none, none, red,    none, none,  red,    none,  none,  red,    none,  none,  red},
				{cyan,   none, none, cyan,   none, none,  cyan,   none,  none,  cyan,   none,  none,  cyan},
				{lila,   none, none, lila,   none, none,  lila,   none,  none,  lila,   none,  none,  lila},
				{blue,   none, none, blue,   none, none,  blue,   none,  none,  blue,   none,  none,  blue},
				{dgreen, red,  lila, blue,   cyan, brown, brown,  brown, brown, brown,  brown, brown, brown}
		};
		FieldColor[][] wishCol = {
				{lila, none,  none,  red, none,  none,  dgreen, none,  none,  blue, none,  none,  cyan},
				{lila, none,  none,  red, none,  none,  dgreen, none,  none,  blue, none,  none,  cyan},
				{lila, none,  none,  red, none,  none,  dgreen, none,  none,  blue, none,  none,  cyan},
				{lila, none,  none,  red, none,  none,  dgreen, none,  none,  blue, none,  none,  cyan},
				{lila, none,  none,  red, none,  none,  dgreen, none,  none,  blue, none,  none,  cyan},
				{lila, brown, brown, red, brown, brown, dgreen, brown, brown, blue, brown, brown, cyan}
		};
		return LevelCreator.makeLevel(levelNr + 5, true, curCol, wishCol);
	} // ok
	
	private static Level createLevel6() {
		FieldColor[][] curCol = {
				{none, none, none, none, none, blue, none, none, blue, none, blue, blue, none, blue, none, none, blue, none, none, none, none, none},
				{none, none, none, none, red, none, none, red, none, none, red, red, none, none, red, none, none, red, none, none, none, none},
				{none, none, none, brown, none, none, brown, none, none, brown, none, none, brown, none, none, brown, none, none, brown, none, none, none},
				{none, none, cyan, none, none, cyan, none, none, cyan, none, none, none, none, cyan, none, none, cyan, none, none, cyan, none, none},
				{none, orange, none, none, orange, none, none, orange, none, none, none, none, none, none, orange, none, none, orange, none, none, orange, none},
				{lila, none, none, lila, none, none, lila, none, none, none, green, green, none, none, none, lila, none, none, lila, none, none, lila}
		};
		FieldColor[][] wishCol = {
				{none, none, none, none, none, cyan, none, none, blue, none, red, lila, none, brown, none, none, orange, none, none, none, none, none},
				{none, none, none, none, cyan, none, none, blue, none, none, lila, red, none, none, brown, none, none, orange, none, none, none, none},
				{none, none, none, cyan, none, none, blue, none, none, lila, none, none, red, none, none, brown, none, none, orange, none, none, none},
				{none, none, cyan, none, none, blue, none, none, lila, none, none, none, none, red, none, none, brown, none, none, orange, none, none},
				{none, cyan, none, none, blue, none, none, lila, none, none, none, none, none, none, red, none, none, brown, none, none, orange, none},
				{cyan, none, none, blue, none, none, lila, none, none, none, green, green, none, none, none, red, none, none, brown, none, none, orange}
		};
		return LevelCreator.makeLevel(levelNr + 6, true, curCol, wishCol);
	} // ok
	
	private static Level createLevel7() {
		FieldColor[][] curCol = {
				{green, none,   lila, none, red,  none,  green, none, cyan, none, green,  none, red,    none, blue, none, red,  none, green},
				{none,  dgreen, none, none, none, green, none,  none, none, lila, none,   none, dgreen, none, cyan, none, blue, none, red},
				{lila,  none,   cyan, none, red,  none,  blue,  none, blue, none, dgreen, none, none,   lila, none, none, lila, none, blue}
		};
		FieldColor[][] wishCol = {
				{blue, none, blue, none, lila, none, lila, none, red,  none, red,  none, green, none,  green, none, cyan, none, dgreen},
				{none, blue, none, none, none, lila, none, none, none, red,  none, none, green, none,  green, none, cyan, none, dgreen},
				{blue, none, blue, none, lila, none, lila, none, red,  none, red,  none, none,  green, none,  none, cyan, none, dgreen}
		};
		return LevelCreator.makeLevel(levelNr + 7, true, curCol, wishCol);
	} // ok
	
	private static Level createLevel8() {
		FieldColor[][] curCol = {
				{none, none,  blue,   blue,    brown,  blue,   red,     cyan,  brown,   none,   none},
				{none, blue,  red,    none,    none,   none,   none,    none,  green,   dgreen, none},
				{lila, brown, none,   none,    none,   red,    none,    none,  none,    brown,  blue},
				{lila, none,  none,   none,    blue,   dgreen, magenta, none,  none,    none,   red},
				{lila, red,   none,   none,    none,   red,    none,    none,  none,    red,    green},
				{none, brown, dgreen, none,    none,   none,   none,    none,  cyan,    blue,   none},
				{none, none,  cyan,   magenta, orange, orange, orange,  green, magenta, none,   none}
		};
		FieldColor[][] wishCol = {
				{none,  none,    red,     red,  red,   red,   red,   red,  red,  none, none},
				{none,  magenta, magenta, none, none,  none,  none,  none, cyan, cyan, none},
				{green, magenta, none,    none, none,  brown, none,  none, none, cyan, dgreen},
				{green, none,    none,    none, brown, brown, brown, none, none, none, dgreen},
				{green, orange,  none,    none, none,  brown, none,  none, none, lila, dgreen},
				{none,  orange,  orange,  none, none,  none,  none,  none, lila, lila, none},
				{none,  none,    blue,    blue, blue,  blue,  blue,  blue, blue, none, none}
		};
		return LevelCreator.makeLevel(levelNr + 8, true, curCol, wishCol);
	} // ok
	
	private static Level createLevel9() {
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
		return LevelCreator.makeLevel(levelNr + 9, true, curCol, wishCol);
	} // ok
	
	private static Level createLevel10() {
		FieldColor[][] curCol = {
				{lila, none, none, none, none, red, none, none, none, none, blue},
				{none, dgreen, none, none, none, lila, none, none, none, red, none},
				{none, none, cyan, none, none, dgreen, none, none, lila, none, none},
				{none, none, none, orange, none, cyan, none, dgreen, none, none, none},
				{none, none, none, none, magenta, orange, cyan, none, none, none, none},
				{dgreen, cyan, orange, magenta, green, brown, dgreen, lila, red, blue, green},
				{none, none, none, none, blue, red, lila, none, none, none, none},
				{none, none, none, green, none, blue, none, red, none, none, none},
				{none, none, magenta, none, none, green, none, none, blue, none, none},
				{none, orange, none, none, none, magenta, none, none, none, green, none},
				{cyan, none, none, none, none, orange, none, none, none, none, magenta}
		};
		FieldColor[][] wishCol = {
				{blue, none, none, none, none, green, none, none, none, none, magenta},
				{none, blue, none, none, none, green, none, none, none, magenta, none},
				{none, none, blue, none, none, green, none, none, magenta, none, none},
				{none, none, none, blue, none, green, none, magenta, none, none, none},
				{none, none, none, none, blue, green, magenta, none, none, none, none},
				{red, red, red, red, red, brown, orange, orange, orange, orange, orange},
				{none, none, none, none, lila, dgreen, cyan, none, none, none, none},
				{none, none, none, lila, none, dgreen, none, cyan, none, none, none},
				{none, none, lila, none, none, dgreen, none, none, cyan, none, none},
				{none, lila, none, none, none, dgreen, none, none, none, cyan, none},
				{lila, none, none, none, none, dgreen, none, none, none, none, cyan}
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
