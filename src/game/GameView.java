package game;

import io.safeLoad.LevelLoader;
import io.safeLoad.LoadException;
import io.safeLoad.SafeException;
import menu.MenuView;

import org.newdawn.slick.AngelCodeFont;
import org.newdawn.slick.Font;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.GameState;
import org.newdawn.slick.state.StateBasedGame;

import player.Player;
import basic.ArrowButton;
import basic.GameColor;
import basic.GameGlobals;
import basic.GameWindow;
import basic.InputState;
import basic.Label;

public class GameView extends BasicGameState implements GameState {
	
	private MenuView menuView = null;
	
	private InputState inputState;
	private Player player;
	private HighScore highscore;
	private int currentLevel;
	private Board board;
	
	private Font fontInfo, fontWon, fontError;
	private Image background1, background2;
	
	private ArrowButton backButton;
	
	private boolean won;
	private int wonCounter;
	private static final int WON_WAITING_TIME = 3000;
	
	private Label errorLabel;
	private int errorCounter = 0;
	private int levelErrorExit = 0;
	
	private Sound moveStone;
	
	private boolean moveOverGaps = false;
	
	
	public GameView(InputState inputState, HighScore highscore) {
		super();
		this.inputState = inputState;
		this.highscore = highscore;
		
		won = false;
		wonCounter = WON_WAITING_TIME;
	}
	
	public void setPlayer(Player player) {
		this.player = player;
	}
	
	public void setMenuView(MenuView menuView) {
		if(this.menuView == null) {
			this.menuView = menuView;
		}
	}
	
	
	public void setBoard(int levelNumber) {
		currentLevel = levelNumber;
		Level level;
		try {
			level = LevelLoader.loadLevel(levelNumber);
			board = new Board(level, moveStone);
			moveOverGaps = level.getMoveOverGaps();
		} catch (LoadException e) {
			levelErrorExit = levelNumber;
		}
	}
	

	@Override
	public void init(GameContainer gameContainer, StateBasedGame stateBasedGame)
			throws SlickException {
		
		/* background */
		background1 = new Image("res/img/bgFarbenspiel2.jpg");
		background2 = new Image("res/img/bgFarbenspiel2.jpg");
		
		/* fonts */
		fontInfo = new AngelCodeFont("res/fonts/gameInfo.fnt", "res/fonts/gameInfo.png");
		fontWon = new AngelCodeFont("res/fonts/gameWon.fnt", "res/fonts/gameWon.png");
		fontError = new AngelCodeFont("res/fonts/error.fnt", "res/fonts/error.png");
		
		/* sprites */
		Image backNormal = new Image("res/spr/leftArrowNormal.png");
		Image backRollover = new Image("res/spr/leftArrowRollover.png");
		backButton = new ArrowButton(0, GameGlobals.SCREEN_HEIGHT - 32, backNormal, backRollover);
		
		/* error label */
		errorLabel = new Label(GameGlobals.SCREEN_WIDTH/2, GameGlobals.SCREEN_HEIGHT - 36,
				"Fehler", fontError, Label.CENTER);
		
		/* sound */
		moveStone = new Sound("res/sound/moveStone.wav");
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
			throws SlickException {
		
		if(moveOverGaps) {
			background1.draw();
		}
		else {
			background2.draw();
		}
		
		backButton.draw(g);
		
		
		if(board != null) {
			board.draw(g);
		}
		
		if(fontInfo != null) {
			g.setFont(fontInfo);
		}
		g.setColor(GameColor.basisWritting);
		if(player != null && player.getName() != null) {
			g.drawString(player.getName() + " - Level " + currentLevel, 10, 0);
		}
		if(board != null) {
			int movesX = GameGlobals.SCREEN_WIDTH - fontInfo.getWidth("Züge: " + board.getMoves()) - 10;
			g.drawString("Züge: " + board.getMoves(), movesX, 0);
		}
		
		if(won) {
			g.setFont(fontWon);
			g.setColor(GameColor.wonBackground);
			g.fillRect(0, 0, GameGlobals.SCREEN_WIDTH, GameGlobals.SCREEN_HEIGHT);
			g.setColor(GameColor.wonForeground);
			g.drawString("gewonnen",
					(GameGlobals.SCREEN_WIDTH - fontWon.getWidth("gewonnen"))/2,
					(GameGlobals.SCREEN_HEIGHT - fontWon.getHeight("gewonnen"))/2);
		}
		
		if(errorCounter > 0 && !won) {
			g.setFont(fontError);
			g.setColor(GameColor.inputError);
			errorLabel.draw(g);
		}
	}

	@Override
	public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int delta)
			throws SlickException {
		
		Input input = gameContainer.getInput();
		
		inputState.setMousePosition(input.getMouseX(), input.getMouseY());
		inputState.mouseButtonLeft.setMouseState(input.isMousePressed(Input.MOUSE_LEFT_BUTTON),
				input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON));
		inputState.mouseButtonRight.setMouseState(input.isMousePressed(Input.MOUSE_RIGHT_BUTTON),
				input.isMouseButtonDown(Input.MOUSE_RIGHT_BUTTON));

		if(levelErrorExit != 0 && !won) {
			menuView.showLevelError(levelErrorExit);
			levelErrorExit = 0;
			goBackToMenu(stateBasedGame);
			errorCounter = 0;
			return;
		}
		
		if(errorCounter > 0 && !won) {
			errorCounter -= delta;
		}
		
		
		if(won) {
			// wait a little
			if(wonCounter > 0) {
				wonCounter -= delta;
				return;
			}
			
			won = false;
			wonCounter = WON_WAITING_TIME;

			if(currentLevel == GameGlobals.MAX_LEVEL) { // end of game
				player.setNextLevel(GameGlobals.MAX_LEVEL+1);
				goBackToMenu(stateBasedGame);
			}
			else {
				if(currentLevel == player.getNextLevel()) {
					player.setNextLevel(currentLevel+1);
					setBoard(player.getNextLevel());
				}
				else {
					goBackToMenu(stateBasedGame);
				}
			}
			return;
		}
		
		board.update(inputState, delta);
		
		backButton.update(inputState, delta);
		if(backButton.isClicked()) {
			backButton.resetClicked();
			goBackToMenu(stateBasedGame);
		}
		
		
		if(board.checkWinning()) {
			int oldNextLevel = player.getNextLevel();
			player.setNextLevel(Math.max(currentLevel+1, oldNextLevel));
			player.setMoves(currentLevel, board.getMoves());
			highscore.set(currentLevel, player.getName(), board.getMoves());
			won = true;
			
			try {
				player.safe();
			} catch (SafeException e) {
				e.printStackTrace();
				errorCounter = GameGlobals.ERROR_TEXT_TIME;
				errorLabel.setText("Fehler beim Speichern von " + player.getName() + ".");
			}

			try {
				highscore.safe();
			} catch (SafeException e) {
				e.printStackTrace();
				errorCounter = GameGlobals.ERROR_TEXT_TIME;
				errorLabel.setText("Fehler beim Speichern des Highscores.");
			}
			
			// reset max level now to make no mistake later
			player.setNextLevel(oldNextLevel);
		}
	}
	
	private void goBackToMenu(StateBasedGame sbg) {
		menuView.setPage(currentLevel);
		this.errorCounter = 0;
		this.wonCounter   = WON_WAITING_TIME;
		this.won = false;
		sbg.enterState(GameWindow.MENU,	GameGlobals.transitionOut(), GameGlobals.transitionIn());
	}

	@Override
	public int getID() {
		return GameWindow.GAME;
	}

}
