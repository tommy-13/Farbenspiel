package basic;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.newdawn.slick.Color;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;
import org.newdawn.slick.state.transition.Transition;

public class GameGlobals {
	
	public static final int SCREEN_WIDTH = 800;
	public static final int SCREEN_HEIGHT = 450;
	
	public static final int MAX_PLAYER = 4;
	
	public static int MAX_LEVEL = 1;
	// only neighbouring fields change color
	
	public static int ERROR_TEXT_TIME = 10000;
	
	public static Transition transitionOut() {
		return new FadeOutTransition(Color.black, 500);
	}
	public static Transition transitionIn() {
		return new FadeInTransition(Color.black, 500);
	}
	
	
	public static void setConfiguration() {
		Properties properties = new Properties();
		try {
			BufferedInputStream stream = new BufferedInputStream(new FileInputStream("safe/level/config.properties"));
			properties.load(stream);
			stream.close();
		} catch (IOException e) {e.printStackTrace();}
		
		try {
			MAX_LEVEL = Integer.parseInt(properties.getProperty("MAXLEVEL"));
		} catch(NumberFormatException e) {e.printStackTrace();}
		finally {
			try {
				ERROR_TEXT_TIME = Integer.parseInt(properties.getProperty("ERRORTEXTTIME"));
			} catch(NumberFormatException e) {e.printStackTrace();}
		}
	}
	
}
