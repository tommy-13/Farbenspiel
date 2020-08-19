package player;

import org.newdawn.slick.Font;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Rectangle;

import basic.GameColor;
import basic.GraphicObject;
import basic.InputState;

/**
 * button in a game
 * @author tommy
 *
 */

public class TextButton extends GraphicObject {
	
	public static final int WIDTH  = 64;
	public static final int HEIGHT = 64;
	public static final int XGAP   = 16;
	public static final int YGAP   = 8;
	
	private int width;
	private int height;
	
	private boolean clicked = false;
	private boolean mouseEntered = false;
	
	private Font font;
	private String letter;
	private int letterX, letterY;
	
	
	public TextButton(int x, int y, String letter, Font font) {
		this(x, y, letter, font, WIDTH, HEIGHT);
	}
	public TextButton(int x, int y, String letter, Font font, int width, int height) {
		super(x,y);
		this.width = width;
		this.height = height;
		this.letter = letter;
		this.font = font;
		letterX = x + (width - font.getWidth(letter)) / 2;
		letterY = y + (height - font.getHeight(letter)) / 2;
		
		collisionMask = new Rectangle(x, y, width, height);
	}
	
	
	public String getLetter() {
		return letter;
	}
	

	@Override
	public void draw(Graphics g) {
		if(mouseEntered) {
			g.setColor(GameColor.panelEntered);
		}
		else {
			g.setColor(GameColor.panelNormal);
		}
		g.fillRect(x, y, width, height);

		g.setColor(GameColor.basisWritting);
		g.drawRect(x, y, width, height);
		g.setFont(font);
		g.drawString(letter, letterX, letterY);
	}

	
	@Override
	public void update(InputState inputState, int delta) {
		
		int mouseX = inputState.getMouseX();
		int mouseY = inputState.getMouseY();
		
		mouseEntered = super.isCollision(mouseX, mouseY);
		boolean mouseClicked = inputState.mouseButtonLeft.isClicked();
		
		
		if(mouseEntered) {
			if(mouseClicked) {
				clicked = true;
			}
		}
	}
	
	
	/**
	 * check if the mouse button was previously released
	 * @return true / false
	 */
	public boolean isClicked() {
		return clicked;
	}
	
	
	/**
	 * to be executed after button was released
	 */
	public void resetClicked() {
		clicked = false;
	}

}
