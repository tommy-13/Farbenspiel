package menu;

import game.GameView;
import game.HighScore;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.AngelCodeFont;
import org.newdawn.slick.Font;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
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

public class MenuView extends BasicGameState implements GameState {
	
	public final static int LEVEL_PANELS_PER_PAGE = 12;
	
	private InputState inputState;
	private Player player;
	private HighScore highscore;
	private MenuLevelChoice[] levelLabel;
	private int page;
	private int maxPage;
	
	/* background */
	private Image background;
	
	/* fonts */
	private Font fontInfo;
	private Font fontLevel;
	private Font fontError;
	
	/* dayview */
	private GameView game;
	
	private PageUpDownButton pageUpButton;
	private PageUpDownButton pageDownButton;
	private ArrowButton backButton;

	/* error */
	private Label errorLabel;
	private int errorCounter = 0;
	
	
	public MenuView(InputState inputState, GameView game, HighScore highscore) {
		super();
		this.inputState = inputState;
		this.game = game;
		maxPage = (GameGlobals.MAX_LEVEL-1) / LEVEL_PANELS_PER_PAGE;
		this.highscore = highscore;
	}
	
	public void setPage(int level) {
		page = (level-1) / LEVEL_PANELS_PER_PAGE;
	}
	public void setPlayer(Player player) {
		this.player = player;
		
		for(int i=0; i<GameGlobals.MAX_LEVEL; i++) {
			levelLabel[i].setPlayer(player);
		}
		
		setPage(player.getNextLevel());
	}

	
	@Override
	public void init(GameContainer gameContainer, StateBasedGame stateBasedGame)
			throws SlickException {
		
		/* background */
		background = new Image("res/img/bgFarbenspiel2.jpg");
		
		/* fonts */
		fontInfo = new AngelCodeFont("res/fonts/gameInfo.fnt", "res/fonts/gameInfo.png");
		fontLevel = new AngelCodeFont("res/fonts/levelInfo.fnt", "res/fonts/levelInfo.png");
		fontError = new AngelCodeFont("res/fonts/error.fnt", "res/fonts/error.png");
		
		/* levels */
		levelLabel = new MenuLevelChoice[GameGlobals.MAX_LEVEL];
		for(int i=0; i<GameGlobals.MAX_LEVEL; i++) {
			levelLabel[i] = new MenuLevelChoice(i+1, player, highscore, fontLevel);
		}
		
		/* page up, down */
		pageUpButton = new PageUpDownButton(GameGlobals.SCREEN_WIDTH - 70,
				GameGlobals.SCREEN_HEIGHT/2 - 50,
				new Image("res/spr/arrowUpNormal.png"),
				new Image("res/spr/arrowUpRollover.png"));
		pageDownButton = new PageUpDownButton(GameGlobals.SCREEN_WIDTH - 70,
				GameGlobals.SCREEN_HEIGHT/2 + 10,
				new Image("res/spr/arrowDownNormal.png"),
				new Image("res/spr/arrowDownRollover.png"));

		Image backNormal = new Image("res/spr/leftArrowNormal.png");
		Image backRollover = new Image("res/spr/leftArrowRollover.png");
		backButton = new ArrowButton(0, GameGlobals.SCREEN_HEIGHT - 32, backNormal, backRollover);
		
		/* error label */
		errorLabel = new Label(GameGlobals.SCREEN_WIDTH/2, GameGlobals.SCREEN_HEIGHT - 36,
				"Fehler", fontError, Label.CENTER);
	}

	@Override
	public void render(GameContainer gameContainer, StateBasedGame stateBasedGame,
			Graphics g) throws SlickException {
		
		/* background */
		background.draw();
		backButton.draw(g);
		
		
		if(fontInfo != null) {
			g.setFont(fontInfo);
		}
		g.setColor(GameColor.basisWritting);
		if(player != null && player.getName() != null) {
			g.drawString(player.getName() + " - Level " + Math.min(player.getNextLevel(), GameGlobals.MAX_LEVEL), 10, 0);
			int sumMoves = player.getSumMoves();
			int movesX = GameGlobals.SCREEN_WIDTH - fontInfo.getWidth("Gesamtzüge: " + sumMoves) - 10;
			g.drawString("Gesamtzüge: " + sumMoves, movesX, 0);
		}
		
		if(levelLabel != null) {
			for(MenuLevelChoice mlc : levelLabel) {
				if(((mlc.getLevel()-1) / LEVEL_PANELS_PER_PAGE) == page) {
					mlc.draw(g);
				}
			}
		}
		
		pageUpButton.draw(g);
		pageDownButton.draw(g);
		

		if(errorCounter > 0) {
			g.setFont(fontError);
			g.setColor(GameColor.inputError);
			errorLabel.draw(g);
		}
	}

	
	@Override
	public void update(GameContainer gameContainer, StateBasedGame stateBasedGame,
			int delta) throws SlickException {
		
		Input input = gameContainer.getInput();
		
		inputState.setMousePosition(input.getMouseX(), input.getMouseY());
		inputState.setMouseWheel(Mouse.getDWheel());
		inputState.mouseButtonLeft.setMouseState(input.isMousePressed(Input.MOUSE_LEFT_BUTTON),
				input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON));
		inputState.mouseButtonRight.setMouseState(input.isMousePressed(Input.MOUSE_RIGHT_BUTTON),
				input.isMouseButtonDown(Input.MOUSE_RIGHT_BUTTON));
		

		if(errorCounter > 0) {
			errorCounter -= delta;
		}
		
		
		/* start game */
		if(levelLabel != null) {
			for(MenuLevelChoice mlc : levelLabel) {
				mlc.update(inputState, delta);
				if(mlc.isClicked()) {
					mlc.resetClicked();
					if(((mlc.getLevel()-1) / LEVEL_PANELS_PER_PAGE) == page) {
						game.setBoard(mlc.getLevel());
						stateBasedGame.enterState(GameWindow.GAME,
								GameGlobals.transitionOut(), GameGlobals.transitionIn());
					}
				}
			}
		}
		
		
		pageUpButton.update(inputState, delta);
		if(pageUpButton.isClicked() || inputState.getMouseWheelUp()) {
			pageUpButton.resetClicked();
			page = Math.max(0, page-1);
		}
		pageDownButton.update(inputState, delta);
		if(pageDownButton.isClicked() || inputState.getMouseWheelDown()) {
			pageDownButton.resetClicked();
			page = Math.min(maxPage, page+1);
		}
		
		backButton.update(inputState, delta);
		if(backButton.isClicked()) {
			backButton.resetClicked();
			stateBasedGame.enterState(GameWindow.PLAYER, GameGlobals.transitionOut(), GameGlobals.transitionIn());
		}
		
		/* esc: end the game */
		if(input.isKeyDown(Input.KEY_ESCAPE)) {
			gameContainer.exit();
		}
		
		
		/* catch input */
//		input.isKeyPressed(Input.KEY_LEFT);
//		input.isKeyPressed(Input.KEY_UP);
//		input.isKeyPressed(Input.KEY_HOME);
//		input.isKeyPressed(Input.KEY_PRIOR);
//		input.isKeyPressed(Input.KEY_RIGHT);
//		input.isKeyPressed(Input.KEY_DOWN);
//		input.isKeyPressed(Input.KEY_END);
//		input.isKeyPressed(Input.KEY_NEXT);
//		Mouse.getDWheel();
	}

	@Override
	public int getID() {
		return GameWindow.MENU;
	}

	public void showLevelError(int levelNumber) {
		errorCounter = GameGlobals.ERROR_TEXT_TIME;
		errorLabel.setText("Fehler beim Laden von Level " + levelNumber + ".");
	}
	

}
