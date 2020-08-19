package player;

import org.newdawn.slick.Font;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Rectangle;

import basic.GameColor;
import basic.GameGlobals;
import basic.GraphicObject;
import basic.InputState;
import player.Player;

/**
 * button in a game
 * @author tommy
 *
 */

public class MenuPlayerChoice extends GraphicObject {
	
	private static final int width = 300;
	private static final int height = 120;
	private static final int xGap  = 50;
	private static final int yGap  = 30;
	
	boolean mouseEntered = false;
	
	private Font   font;
	private int    id;
	private Player player;
	
	private boolean clicked = false;
	private boolean rightClicked = false;
	
	
	public MenuPlayerChoice(int id, Player player, Font font) {
		this.font = font;
		this.id = id;
		this.player = player;
		
		int col = id % 2;
		int row = id / 2;
		x = 80 + col * (width + xGap);
		y = 120 + row * (height + yGap);
		
		collisionMask = new Rectangle(x, y, width, height);
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
		if(player == null) {
			g.drawString("(leer)", x+(width-font.getWidth("(leer)"))/2, y+(height-font.getLineHeight())/2);
		}
		else {
			g.drawString(player.getName(), x+10, y+5);
			g.drawString("Level " + Math.min(player.getNextLevel(), GameGlobals.MAX_LEVEL), x+10, y+40);
			g.drawString("Gesamtzüge: " + player.getSumMoves(), x+10, y+75);
		}
	}

	@Override
	public void update(InputState inputState, int delta) {
		
		int mouseX = inputState.getMouseX();
		int mouseY = inputState.getMouseY();
		
		mouseEntered = super.isCollision(mouseX, mouseY);
		boolean mouseClicked = inputState.mouseButtonLeft.isClicked();
		boolean mouseRightClicked = inputState.mouseButtonRight.isClicked();
		
		
		if(mouseEntered) {
			if(mouseClicked) {
				clicked = true;
			}
			else if(mouseRightClicked) {
				rightClicked = true;
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
	
	public boolean isRightClicked() {
		return rightClicked;
	}
	
	
	/**
	 * to be executed after button was released
	 */
	public void resetClicked() {
		clicked = false;
		rightClicked = false;
	}



	public int getId() {
		return id;
	}
	public Player getPlayer() {
		return player;
	}
	
	public void setPlayer(Player player) {
		this.player = player;
	}

}
