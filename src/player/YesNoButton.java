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

public class YesNoButton extends GraphicObject {
	
	private final int width = 128;
	private final int height = 48;
	
	private boolean clicked = false;
	private boolean mouseEntered = false;
	
	private Font font;
	private String text;
	private int textX, textY;
	boolean yes;
	

	public YesNoButton(int x, int y, boolean yes, Font font) {
		super(x,y);
		this.yes = yes;
		this.text = yes ? "Ja" : "Nein";
		this.font = font;
		textX = x + (width - font.getWidth(text)) / 2;
		textY = y;
		
		collisionMask = new Rectangle(x, y, width, height);
	}
	
	
	public String getLetter() {
		return text;
	}
	

	@Override
	public void draw(Graphics g) {
		if(mouseEntered) {
			if(yes) {
				g.setColor(GameColor.yesEntered);
			}
			else {
				g.setColor(GameColor.noEntered);
			}
		}
		else {
			if(yes) {
				g.setColor(GameColor.yesNormal);
			}
			else {
				g.setColor(GameColor.noNormal);
			}
		}
		g.fillRect(x, y, width, height);

		g.setColor(GameColor.deletingForeground);
		g.drawRect(x, y, width, height);
		g.setFont(font);
		g.drawString(text, textX, textY);
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
