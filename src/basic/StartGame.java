package basic;

import io.safeLoad.HighScoreLoader;
import io.safeLoad.LoadException;
import io.safeLoad.PlayerLoader;
import io.safeLoad.SafeException;

import java.io.File;

import game.GameView;
import game.HighScore;
import menu.MenuView;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import player.Player;
import player.PlayerView;

public class StartGame extends StateBasedGame {
	
	private final static String gameName = "Farbenspiel";
	private InputState inputState = new InputState();

	
	public StartGame() throws SlickException {
		super(gameName);
		
		GameGlobals.setConfiguration();
		
		/* highscore */
		HighScore highscore;
		if(new File("safe/player/_score.scr").isFile()) {
			try {
				highscore = HighScoreLoader.loadScore();
			} catch (LoadException e) {
				highscore = new HighScore();
			}
		}
		else {
			highscore = new HighScore();
			try {
				highscore.safe();
			} catch (SafeException e) {}
		}
		
		/* player */
		Player[] players = new Player[GameGlobals.MAX_PLAYER];
		for(int i=0; i<players.length; i++) {
			if(new File("safe/player/player" + i + ".ply").isFile()) {
				try {
					players[i] = PlayerLoader.loadPlayer(i);
				} catch (LoadException e) {
					e.printStackTrace();
					players[i] = null;
				}
			}
			else {
				players[i] = null;
			}
		}
		
		
		/* add states (screens) */
		GameView gameState = new GameView(inputState, highscore);
		MenuView menuView  = new MenuView(inputState, gameState, highscore);
		gameState.setMenuView(menuView);
		
		this.addState(new PlayerView(inputState, players, menuView, gameState));
		this.addState(menuView);
		this.addState(gameState);
	}
	

	@Override
	public void initStatesList(GameContainer gameContainer) throws SlickException {
		gameContainer.setShowFPS(false);
		
		/* initialise screens */
		this.getState(GameWindow.MENU).init(gameContainer, this);
		this.getState(GameWindow.GAME).init(gameContainer, this);
		this.getState(GameWindow.PLAYER).init(gameContainer, this);
		
		/* set first screen */
		this.enterState(GameWindow.PLAYER);
	}

	
	
	public static void main(String[] args) {
		
		// create necessary folders
		new File("safe").mkdir();
		new File("safe/level").mkdir();
		new File("safe/player").mkdir();
		
		/* create window */
		AppGameContainer appGameContainer;
		try {
			appGameContainer = new AppGameContainer(new StartGame());
			appGameContainer.setIcon("res/spr/icon32.png");
			appGameContainer.setDisplayMode(GameGlobals.SCREEN_WIDTH, GameGlobals.SCREEN_HEIGHT, false);
			appGameContainer.start();
		} catch(SlickException e) {
			e.printStackTrace();
		}
	}
}
