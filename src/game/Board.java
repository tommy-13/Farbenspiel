package game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Sound;

import comparator.DecreasingXFieldComparator;
import comparator.DecreasingYFieldComparator;
import comparator.IncreasingXFieldComparator;
import comparator.IncreasingYFieldComparator;
import basic.GameGlobals;
import basic.GraphicObject;
import basic.InputState;

public class Board extends GraphicObject {
	
	private List<Field> fields;
	private int levelNr;
	private boolean moveOverGaps;
	
	private int startingMouseX;
	private int startingMouseY;
	private int moves;
	private Field markedField;
	
	private Sound moveStone;
	
	
	public Board(Level level, Sound moveStone) {
		this.moveStone = moveStone;
		levelNr = level.getLevelNumber();
		fields = level.getFields();
		moveOverGaps = level.getMoveOverGaps();
		
		moves = 0;
		markedField = null;
		setFieldPositions(GameGlobals.SCREEN_WIDTH, GameGlobals.SCREEN_HEIGHT);
		
		resetStartingMouse();
	}
	
	private void resetStartingMouse() {
		startingMouseX = -1;
		startingMouseY = -1;
	}
	
	
	public int getLevel() {
		return levelNr;
	}
	
	
	private int getNumberOfRows() {
		int rows = 0;
		for(Field f : fields) {
			rows = Math.max(rows, f.getYOnBoard());
		}
		return rows;
	}
	private int getNumberOfColumns() {
		int cols = 0;
		for(Field f : fields) {
			cols = Math.max(cols, f.getXOnBoard());
		}
		return cols;
	}
	private void setFieldPositions(int screenWidth, int screenHight) {
		int width = (getNumberOfColumns() + 1) * Field.SIZE;
		int hight = (getNumberOfRows() + 1) * Field.SIZE;
		
		int xPos = (screenWidth - width) / 2;
		int yPos = (screenHight - hight) / 2;
		
		xPos = (xPos < 0) ? 0 : xPos;
		yPos = (yPos < 0) ? 0 : yPos;
		
		for(Field f : fields) {
			f.setPosition(xPos, yPos);
		}
	}


	@Override
	public void draw(Graphics g) {
		if(fields != null) {
			for(Field f : fields) {
				f.draw(g);
			}
		}
	}


	@Override
	public void update(InputState inputState, int delta) {
		
		if(fields == null || fields.isEmpty()) {
			resetStartingMouse();
			return;
		}
		
		if(inputState.mouseButtonLeft.isClicked()) {
			startingMouseX = inputState.getMouseX();
			startingMouseY = inputState.getMouseY();

			for(Field f : fields) {
				if(f.isCollision(startingMouseX, startingMouseY)) {
					markedField = f;
					markedField.setMarked(true);
					break;
				}
			}
		}
		
		if(inputState.mouseButtonLeft.isReleased()) {
			if(markedField != null) {
				markedField.setMarked(false);
				markedField = null;
			}
			
			// position of field which was clicked on board
			Field startField = null;
			
			// check fields of board
			for(Field f : fields) {
				if(f.isCollision(startingMouseX, startingMouseY)) {
					startField = f;
					break;
				}
			}
			
			if(startField != null) {
				int endingMouseX = inputState.getMouseX();
				int endingMouseY = inputState.getMouseY();
				Field endField = null;

				// check fields of board
				for(Field f : fields) {
					if(f.isCollision(endingMouseX, endingMouseY)) {
						endField = f;
						break;
					}
				}
				
				if(endField == null || endField != startField) {
					// determine direction
					int xGap = endingMouseX - startingMouseX;
					int yGap = endingMouseY - startingMouseY;
					
					if(Math.abs(xGap) > Math.abs(yGap)) {
						if(checkInRange(startField.getY(), endingMouseY)) {
							List<Field> row = moveOverGaps ?
									getRow(startField.getYOnBoard()) : getNeighboursRow(startField);
									
							if(xGap < 0) {
								Collections.sort(row, new DecreasingXFieldComparator());
							}
							else {
								Collections.sort(row, new IncreasingXFieldComparator());
							}
							shiftColor(row);
							moves++;
						}
					}
					else if(Math.abs(xGap) < Math.abs(yGap)) {
						if(checkInRange(startField.getX(), endingMouseX)) {
							List<Field> col = moveOverGaps ?
									getColumn(startField.getXOnBoard()) : getNeighboursCol(startField);
									
							if(yGap < 0) {
								Collections.sort(col, new DecreasingYFieldComparator());
							}
							else {
								Collections.sort(col, new IncreasingYFieldComparator());
							}
							shiftColor(col);
							moves++;
						}
					}
				}
			}
			
			resetStartingMouse();
		}
	}
	
	private void shiftColor(List<Field> fields) {
		if(fields == null || fields.isEmpty()) {
			return;
		}
		int len = fields.size();
		FieldColor savedColor = fields.get(len-1).getCurrentColor();
		for(Field f : fields) {
			FieldColor tempColor = f.getCurrentColor();
			f.setCurrentColor(savedColor);
			savedColor = tempColor;
		}
		moveStone.play();
	}
	
	private List<Field> getRow(int row) {
		List<Field> fieldsInRow = new ArrayList<Field>();
		for(Field f : fields) {
			if(f.getYOnBoard() == row) {
				fieldsInRow.add(f);
			}
		}
		return fieldsInRow;
	}
	private List<Field> getColumn(int col) {
		List<Field> fieldsInCol = new ArrayList<Field>();
		for(Field f : fields) {
			if(f.getXOnBoard() == col) {
				fieldsInCol.add(f);
			}
		}
		return fieldsInCol;
	}
	
	private List<Field> getNeighboursRow(Field startField) {
		int row = startField.getYOnBoard();
		List<Field> fieldsInRow = new ArrayList<Field>();
		for(Field f : fields) {
			if(f.getYOnBoard() == row) {
				fieldsInRow.add(f);
			}
		}
		
		List<Field> neighbours = new ArrayList<Field>();
		int col = startField.getXOnBoard();
		neighbours.add(startField);
		int pos = col-1;
		boolean goOn = true;
		while(goOn) {
			for(Field f : fieldsInRow) {
				if(f.getXOnBoard() == pos) {
					goOn = true;
					pos--;
					neighbours.add(f);
					break;
				}
				goOn = false;
			}
		}
		pos = col+1;
		goOn = true;
		while(goOn) {
			for(Field f : fieldsInRow) {
				if(f.getXOnBoard() == pos) {
					goOn = true;
					pos++;
					neighbours.add(f);
					break;
				}
				goOn = false;
			}
		}
		return neighbours;
	}
	private List<Field> getNeighboursCol(Field startField) {
		int col = startField.getXOnBoard();
		List<Field> fieldsInCol = new ArrayList<Field>();
		for(Field f : fields) {
			if(f.getXOnBoard() == col) {
				fieldsInCol.add(f);
			}
		}
		
		List<Field> neighbours = new ArrayList<Field>();
		int row = startField.getYOnBoard();
		neighbours.add(startField);
		int pos = row-1;
		boolean goOn = true;
		while(goOn) {
			for(Field f : fieldsInCol) {
				if(f.getYOnBoard() == pos) {
					goOn = true;
					pos--;
					neighbours.add(f);
					break;
				}
				goOn = false;
			}
		}
		pos = row+1;
		goOn = true;
		while(goOn) {
			for(Field f : fieldsInCol) {
				if(f.getYOnBoard() == pos) {
					goOn = true;
					pos++;
					neighbours.add(f);
					break;
				}
				goOn = false;
			}
		}
		return neighbours;
	}
	
	
	private boolean checkInRange(int basis, int value) {
		if(value < basis - Field.SIZE/4) {
			return false;
		}
		if(value > basis + Field.SIZE + Field.SIZE/4) {
			return false;
		}
		return true;
	}
	
	
	public int getMoves() {
		return moves;
	}
	
	public boolean checkWinning() {
		for(Field f : fields) {
			if(f.getDesiredColor() == FieldColor.NONE) {
				continue;
			}
			if(f.getDesiredColor() != f.getCurrentColor()) {
				return false;
			}
		}
		return true;
	}
}
