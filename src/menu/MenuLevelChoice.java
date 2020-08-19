package menu;

import game.HighScore;

import org.newdawn.slick.Font;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Rectangle;

import basic.GameColor;
import basic.GraphicObject;
import basic.InputState;
import player.Player;

/**
 * button in a game
 * @author tommy
 *
 */

public class MenuLevelChoice extends GraphicObject {
	
	private static final int width = 200;
	private static final int height = 64;
	private static final int xGap  = 30;
	private static final int yGap  = 10;
	
	boolean mouseEntered = false;
	
	private Font   font;
	private int    level;
	private Player player;
	private HighScore highscore;
	
	private boolean clicked = false;
	
	
	public MenuLevelChoice(int level, Player player, HighScore highscore, Font font) {
		this.font = font;
		this.level = level;
		this.player = player;
		this.highscore = highscore;
		
		int col = (level-1) % 3;
		int row = (level-1) / 3;
		row %= (MenuView.LEVEL_PANELS_PER_PAGE / 3);
		x = 30 + col * (width + xGap);
		y = 80 + row * (height + yGap);
		
		//super(x,y);
		collisionMask = new Rectangle(x, y, width, height);
	}

	

	@Override
	public void draw(Graphics g) {
		if(player == null) {
			return;
		}
		
		if(level > player.getNextLevel()) {
			g.setColor(GameColor.panelBlocked);
		}
		else {
			if(mouseEntered) {
				g.setColor(GameColor.panelEntered);
			}
			else {
				g.setColor(GameColor.panelNormal);
			}
		}
		g.fillRect(x, y, width, height);
		g.setColor(GameColor.basisWritting);
		g.drawRect(x, y, width, height);
		
		String score = highscore.getScore(level) == 0 ? "" : " (" + highscore.getScore(level) + ")";
		
		g.setFont(font);
		g.drawString("Level " + level + " - Züge: " + player.getMoves(level), x+10, y+4);
		g.drawString("Bester Spieler:", x+10, y+22);
		g.drawString(highscore.getName(level) + score, x+10, y+40);
	}

	@Override
	public void update(InputState inputState, int delta) {
		
		int mouseX = inputState.getMouseX();
		int mouseY = inputState.getMouseY();
		
		mouseEntered = super.isCollision(mouseX, mouseY);
		boolean mouseClicked = inputState.mouseButtonLeft.isClicked();
		
		
		if(mouseEntered) {
			if(mouseClicked && level <= player.getNextLevel()) {
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



	public int getLevel() {
		return level;
	}



	public void setPlayer(Player player) {
		this.player = player;
	}

}
