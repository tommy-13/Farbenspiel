package game;

import org.newdawn.slick.Color;

public enum FieldColor {
	
	NONE,
	RED,
	BLUE,
	GREEN,
	ORANGE,
	CYAN,
	DARKGREEN,
	BROWN,
	MAGENTA,
	LILAC;
	
	private static final Color colorNone 		= Color.black;
	private static final Color colorRed 		= Color.red;
	private static final Color colorBlue 		= Color.blue;
	private static final Color colorGreen 		= Color.green;
	private static final Color colorOrange 		= Color.orange;
	private static final Color colorCyan 		= Color.cyan;
	private static final Color colorDarkGreen 	= new Color(0,150,0);
	private static final Color colorBrown 		= new Color(180,100,40);
	private static final Color colorMagenta 	= Color.magenta;
	private static final Color colorLilac 		= new Color(120,0,120);
	
	
	public Color toColor() {
		switch(this) {
		case NONE: default: return colorNone;
		case RED:		return colorRed;
		case BLUE: 		return colorBlue;
		case GREEN: 	return colorGreen;
		case ORANGE: 	return colorOrange;
		case CYAN: 		return colorCyan;
		case DARKGREEN: return colorDarkGreen;
		case BROWN: 	return colorBrown;
		case MAGENTA: 	return colorMagenta;
		case LILAC: 	return colorLilac;
		}
	}

}
