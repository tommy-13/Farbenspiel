package basic;

import org.newdawn.slick.Color;


public class GameColor {
	
	public static final Color basisWritting = Color.blue.darker();
	
	public static final Color wonBackground = new Color(200, 200, 200, 200);
	public static final Color wonForeground = Color.red.brighter();
	
	public static final Color deletingBackground = new Color(0, 0, 0, 200);
	public static final Color deletingForeground = Color.white;
	
	public static final Color panelEntered  = new Color(150,200,200,150);
	public static final Color panelNormal   = new Color(255,255,255,150);
	public static final Color panelBlocked  = new Color(255,150,150,100);
	
	public static final Color inputError    = Color.red.darker();
	public static final Color inputName     = Color.white;

	public static final Color yesEntered = new Color(255, 80, 80);
	public static final Color noEntered  = new Color(80, 180, 80);
	public static final Color yesNormal  = new Color(255, 0, 0);
	public static final Color noNormal   = new Color(0, 180, 0);
	
	public static final Color playerHead = Color.white;

	public static final Color markedField = new Color(255, 255, 255, 100);
	
}
