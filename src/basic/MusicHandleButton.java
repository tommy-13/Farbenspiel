package basic;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Rectangle;

/**
 * button in a game
 * @author tommy
 *
 */

public class MusicHandleButton extends GraphicObject {
	
	private Image imgNormal;
	private Image imgEntered;
	private Image imgDisabled;
	private Image imgActive;
	
	private boolean clicked = false;
	private boolean enabled = true;
	
	
	public MusicHandleButton(int x, int y, Image imgNormal, Image imgEntered, Image imgDisabled) {
		super(x,y);
		
		this.imgNormal  = imgNormal;
		this.imgEntered = imgEntered;
		this.imgDisabled = imgDisabled;
		imgActive = imgNormal;
		
		collisionMask = new Rectangle(x, y, imgActive.getWidth(), imgActive.getHeight());
	}

	
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public boolean getEnabled() {
		return enabled;
	}
	
	

	@Override
	public void draw(Graphics g) {
		imgActive.draw(x,y);
	}

	
	@Override
	public void update(InputState inputState, int delta) {
		
		int mouseX = inputState.getMouseX();
		int mouseY = inputState.getMouseY();
		
		boolean mouseEntered = super.isCollision(mouseX, mouseY);
		boolean mouseClicked = inputState.mouseButtonLeft.isClicked();
		
		
		if(enabled) {
			if(mouseEntered) {
				imgActive = imgEntered;
				if(mouseClicked) {
					clicked = true;
				}
			}
			else {
				imgActive = imgNormal;
			}
		}
		else {
			imgActive = imgDisabled;
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
