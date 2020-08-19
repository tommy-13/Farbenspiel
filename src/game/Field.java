package game;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Rectangle;

import basic.GameColor;
import basic.GraphicObject;
import basic.InputState;

public class Field extends GraphicObject {
	
	public static int SIZE = 32;
	
	private int xOnBoard;
	private int yOnBoard;
	
	private FieldColor desiredColor;
	private FieldColor currentColor;
	
	private boolean marked = false;
	
	
	public Field(int xPosition, int yPosition, FieldColor currentColor, FieldColor desiredColor) {
		this.xOnBoard = xPosition;
		this.yOnBoard = yPosition;
		this.currentColor = currentColor;
		this.desiredColor = desiredColor;
		this.collisionMask = new Rectangle(0, 0, SIZE, SIZE);
	}
	public Field(int xPosition, int yPosition, FieldColor currentColor) {
		this(xPosition, yPosition, currentColor, FieldColor.NONE);
	}
	
	
	public void setPosition(int boardX, int boardY) {
		setX(boardX + SIZE * xOnBoard);
		setY(boardY + SIZE * yOnBoard);
	}
	
	
	public void setCurrentColor(FieldColor currentColor) {
		this.currentColor = currentColor;
	}
	public FieldColor getCurrentColor() {
		return currentColor;
	}
	public FieldColor getDesiredColor() {
		return desiredColor;
	}
	
	
	public int getXOnBoard() {
		return xOnBoard;
	}
	public int getYOnBoard() {
		return yOnBoard;
	}
	
	public void setMarked(boolean marked) {
		this.marked = marked;
	}
	
	
	@Override
	public void draw(Graphics g) {
		g.setColor(desiredColor.toColor());
		g.fillRoundRect(x+1, y+1, SIZE-2, SIZE-2, 0);
		g.setColor(currentColor.toColor());
		g.fillRoundRect(x+2, y+2, SIZE-4, SIZE-4, (SIZE-4) / 2);
		
		if(marked) {
			g.setColor(GameColor.markedField);
			g.fillRoundRect(x+1, y+1, SIZE-2, SIZE-2, 0);
		}
	}
	@Override
	public void update(InputState inputState, int delta) {}

}
