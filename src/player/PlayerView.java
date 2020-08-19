package player;

import io.safeLoad.SafeException;
import game.GameView;
import menu.MenuView;

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

public class PlayerView extends BasicGameState implements GameState {
	
	private InputState inputState;
	private Player[] players;
	private MenuPlayerChoice[] playerLabel;
	
	/* background */
	private Image background;
	
	/* fonts */
	private Font fontInfo;
	private Font fontPlayer;
	private Font fontNewPlayerHead;
	private Font fontNewPlayerKeys;
	private Font fontDeleting;
	private Font fontError;
	
	/* views */
	private MenuView menuView;
	private GameView gameView;
	
	/* new player creation */
	private ArrowButton backButton;
	private boolean creatingNewPlayer = false;
	private int    inputPlayerId = -1;
	private String inputPlayerName = "";
	private TextButton[] letterButtons;
	private static final String[] letters = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M",
		"N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "<", "OK"};
	
	/* player deleting */
	private boolean deletingMode = false;
	private Label delLabel;
	private YesNoButton delYes;
	private YesNoButton delNo;
	
	/* error */
	private Label errorLabel;
	private int   errorCounter = 0;

	
	public PlayerView(InputState inputState, Player[] players, MenuView menuView, GameView gameView) {
		super();
		this.inputState = inputState;
		this.menuView = menuView;
		this.gameView = gameView;
		this.players = players;
	}


	
	@Override
	public void init(GameContainer gameContainer, StateBasedGame stateBasedGame)
			throws SlickException {
		
		/* background */
		background = new Image("res/img/bgFarbenspiel2.jpg");
		
		/* fonts */
		fontInfo = new AngelCodeFont("res/fonts/gameInfo.fnt", "res/fonts/gameInfo.png");
		fontPlayer = new AngelCodeFont("res/fonts/playerInfo.fnt", "res/fonts/playerInfo.png");
		fontNewPlayerHead = new AngelCodeFont("res/fonts/newPlayerHead.fnt", "res/fonts/newPlayerHead.png");
		fontNewPlayerKeys = new AngelCodeFont("res/fonts/newPlayerKeys.fnt", "res/fonts/newPlayerKeys.png");
		fontDeleting = new AngelCodeFont("res/fonts/playerDeleting.fnt", "res/fonts/playerDeleting.png");
		fontError = new AngelCodeFont("res/fonts/error.fnt", "res/fonts/error.png");
		
		/* levels */
		playerLabel = new MenuPlayerChoice[players.length];
		for(int i=0; i<players.length; i++) {
			playerLabel[i] = new MenuPlayerChoice(i, players[i], fontPlayer);
		}
		
		/* letters */
		letterButtons = new TextButton[28];
		for(int i=0; i<26; i++) {
			int row = i / 7;
			int col = i % 7;
			int x = 40 + col * (TextButton.WIDTH + TextButton.XGAP);
			int y = 116 + row * (TextButton.HEIGHT + TextButton.YGAP);
			letterButtons[i] = new TextButton(x, y,	letters[i], fontNewPlayerKeys);
		}
		int x = (int) (40 + 7.5 * (TextButton.WIDTH + TextButton.XGAP));
		letterButtons[26] = new TextButton(x, 116, letters[26], fontNewPlayerKeys, 128, TextButton.HEIGHT);
		int y = 116 + TextButton.HEIGHT + TextButton.YGAP;
		letterButtons[27] = new TextButton(x, y, letters[27], fontNewPlayerKeys, 128, TextButton.HEIGHT);
		
		Image backNormal = new Image("res/spr/leftArrowNormal.png");
		Image backRollover = new Image("res/spr/leftArrowRollover.png");
		backButton = new ArrowButton(0, GameGlobals.SCREEN_HEIGHT - 32, backNormal, backRollover);
		
		
		/* for deleting */
		delLabel = new Label(GameGlobals.SCREEN_WIDTH/2, GameGlobals.SCREEN_HEIGHT/2 - 64,
				"Spieler löschen?", fontDeleting, Label.CENTER);
		delYes = new YesNoButton(GameGlobals.SCREEN_WIDTH/2 - 144, GameGlobals.SCREEN_HEIGHT/2,
				true, fontDeleting);
		delNo = new YesNoButton(GameGlobals.SCREEN_WIDTH/2 + 16, GameGlobals.SCREEN_HEIGHT/2,
				false, fontDeleting);
		
		/* error */
		errorLabel = new Label(GameGlobals.SCREEN_WIDTH/2, GameGlobals.SCREEN_HEIGHT - 36,
				"Fehler", fontError, Label.CENTER);
	}

	@Override
	public void render(GameContainer gameContainer, StateBasedGame stateBasedGame,
			Graphics g) throws SlickException {
		
		/* background */
		background.draw();


		if(creatingNewPlayer) {
			g.setColor(GameColor.playerHead);
			g.setFont(fontNewPlayerHead);
			g.drawString("Neuen Spieler anlegen:",
					(GameGlobals.SCREEN_WIDTH - fontNewPlayerHead.getWidth("Neuen Spieler anlegen:")) / 2, 10);
			
			g.setColor(GameColor.inputName);
			g.drawString(inputPlayerName,
					(GameGlobals.SCREEN_WIDTH - fontNewPlayerHead.getWidth(inputPlayerName)) / 2, 56);
			
			g.setColor(GameColor.basisWritting);
			g.setFont(fontNewPlayerKeys);
			for(TextButton tb : letterButtons) {
				tb.draw(g);
			}
			
			backButton.draw(g);
		}
		else {
			g.setColor(GameColor.playerHead);
			g.setFont(fontNewPlayerHead);
			g.drawString("Spieler wählen",
					(GameGlobals.SCREEN_WIDTH - fontNewPlayerHead.getWidth("Spieler wählen")) / 2, 10);
			
			
			if(fontInfo != null) {
				g.setFont(fontInfo);
			}

			if(playerLabel != null) {
				for(MenuPlayerChoice mpc : playerLabel) {
					mpc.draw(g);
				}
			}
			
			
			if(deletingMode) {
				g.setColor(GameColor.deletingBackground);
				g.fillRect(0, 0, GameGlobals.SCREEN_WIDTH, GameGlobals.SCREEN_HEIGHT);
				g.setColor(GameColor.deletingForeground);
				delLabel.draw(g);
				delYes.draw(g);
				delNo.draw(g);
			}
		}

		
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
		inputState.mouseButtonLeft.setMouseState(input.isMousePressed(Input.MOUSE_LEFT_BUTTON),
				input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON));
		inputState.mouseButtonRight.setMouseState(input.isMousePressed(Input.MOUSE_RIGHT_BUTTON),
				input.isMouseButtonDown(Input.MOUSE_RIGHT_BUTTON));
		
		
		/* esc: end the game */
		if(input.isKeyDown(Input.KEY_ESCAPE)) {
			gameContainer.exit();
		}
		
		
		if(errorCounter > 0) {
			errorCounter -= delta;
		}
		
		
		if(deletingMode) {
			delYes.update(inputState, delta);
			if(delYes.isClicked()) {
				delYes.resetClicked();
				deletePlayer(inputPlayerId);
				inputPlayerId = -1;
				deletingMode = false;
			}
			
			delNo.update(inputState, delta);
			if(delNo.isClicked()) {
				delNo.resetClicked();
				inputPlayerId = -1;
				deletingMode = false;
			}
			
			return;
		}

		
		/* start game */
		if(playerLabel != null && !creatingNewPlayer) {
			for(MenuPlayerChoice mpc : playerLabel) {
				mpc.update(inputState, delta);
				if(mpc.isClicked()) {
					mpc.resetClicked();
					if(mpc.getPlayer() == null) {
						// create new player
						creatingNewPlayer = true;
						errorCounter = 0;
						inputPlayerId = mpc.getId();
					}
					else {
						Player player = mpc.getPlayer();
						menuView.setPlayer(player);
						gameView.setPlayer(player);
						this.errorCounter = 0;
						stateBasedGame.enterState(GameWindow.MENU,
								GameGlobals.transitionOut(), GameGlobals.transitionIn());
					}
					return;
				}
				else if(mpc.isRightClicked()) {
					mpc.resetClicked();
					if(mpc.getPlayer() == null) {
						return;
					}
					// ask player, if he wants to delete this player
					inputPlayerId = mpc.getId();
					deletingMode = true;
					delLabel.setText("Spieler " + mpc.getPlayer().getName() + " löschen?");
				}
			}
		}
		
		
		if(playerLabel != null && creatingNewPlayer) {
			
			for(TextButton tb : letterButtons) {
				tb.update(inputState, delta);
				
				if(tb.isClicked()) {
					tb.resetClicked();
					if(handleLetter(tb.getLetter())) {
						creatingNewPlayer = false;
						errorCounter = 0;
						inputPlayerId = -1;
						stateBasedGame.enterState(GameWindow.MENU,
								GameGlobals.transitionOut(), GameGlobals.transitionIn());
					}
					return;
				}
			}
			
			backButton.update(inputState, delta);
			if(backButton.isClicked()) {
				backButton.resetClicked();
				inputPlayerId = -1;
				creatingNewPlayer = false;
				errorCounter = 0;
			}
		}
		
		

		/* catch input */
		input.isKeyPressed(Input.KEY_LEFT);
		input.isKeyPressed(Input.KEY_UP);
		input.isKeyPressed(Input.KEY_HOME);
		input.isKeyPressed(Input.KEY_PRIOR);
		input.isKeyPressed(Input.KEY_RIGHT);
		input.isKeyPressed(Input.KEY_DOWN);
		input.isKeyPressed(Input.KEY_END);
		input.isKeyPressed(Input.KEY_NEXT);
		Mouse.getDWheel();
	}
	
	

	@Override
	public int getID() {
		return GameWindow.PLAYER;
	}
	

	private boolean handleLetter(String letter) {
		int len = inputPlayerName.length();
		
		if(letter.equals(letters[26])) { // <
			inputPlayerName = (len <= 1) ? "" : inputPlayerName.substring(0, len-1);
		}
		else if(letter.equals(letters[27])) { // ok
			for(Player p : players) {
				if(inputPlayerName.length() == 0) {
					errorCounter = GameGlobals.ERROR_TEXT_TIME;
					errorLabel.setText("Bitte gib einen Namen ein.");
					return false;
				}
				if(p != null && p.getName().equals(inputPlayerName)) {
					errorCounter = GameGlobals.ERROR_TEXT_TIME;
					errorLabel.setText("Dieser Name existiert bereits.");
					return false;
				}
			}
			createNewPlayer();
			return true;
		}
		else {
			if(len < Player.MAX_PLAYER_NAME_LENGTH) {
				inputPlayerName += len == 0 ? letter : letter.toLowerCase();
			}
			else {
				errorCounter = GameGlobals.ERROR_TEXT_TIME;
				errorLabel.setText("Es sind maximal " + Player.MAX_PLAYER_NAME_LENGTH + " Buchstaben möglich.");
			}
		}
		return false;
	}
	
	private void createNewPlayer() {
		Player newPlayer = new Player(inputPlayerId, inputPlayerName);
		players[inputPlayerId] = newPlayer;
		playerLabel[inputPlayerId].setPlayer(newPlayer);
		try {
			newPlayer.safe();
		} catch (SafeException e) {
			errorCounter = GameGlobals.ERROR_TEXT_TIME;
			errorLabel.setText("Fehler beim Speichern von " + inputPlayerName + ".");
		}
		menuView.setPlayer(newPlayer);
		gameView.setPlayer(newPlayer);
	}
	


	private void deletePlayer(int id) {
		try {
			players[id].delete();
			players[id] = null;
			playerLabel[id].setPlayer(null);
		} catch(NullPointerException | ArrayIndexOutOfBoundsException | PlayerDeletingException e) {
			e.printStackTrace();
			errorCounter = GameGlobals.ERROR_TEXT_TIME;
			errorLabel.setText("Fehler beim Löschen des Spielers " + id + ".");
		}
		
	}


}
