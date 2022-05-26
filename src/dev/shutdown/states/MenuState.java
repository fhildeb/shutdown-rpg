package dev.shutdown.states;

import java.awt.Graphics;
import java.io.File;

import dev.shutdown.graphics.Assets;
import dev.shutdown.ui.ClickListener;
import dev.shutdown.ui.UIImageButton;
import dev.shutdown.ui.UIManager;
import dev.shutdown.Game;
import dev.shutdown.Handler;
import dev.shutdown.audio.Musicplayer;
import dev.shutdown.audio.Soundplayer;

/**
 * Diese Klasse dient zum Erstellen eines Menue-Zustandes
 * in welchem der Spieler die Moeglichkeit erhaelt auszuwahlen ob ein Spiel neu gestartet
 * bzw. geladen werden soll bzw. ob er sich die Credits anzeigen oder das 
 * Spiel verlassen moechte.
 * 
 * @author Felix Hildebrandt
 *
 */
public class MenuState extends State {

	public static UIManager menuUiManager;

	public static int creditStateactive = 0;
	
	public static boolean[] playing = new boolean[4];


	/**
	 * Es wird der Handler des Manue-Zustandes and die Oberklasse
	 * uebergeben sowie die Manager der Benutzeroberflaeche mit allen Buttons und
	 * deren On-Click-Methoden definiert.
	 * 
	 * @param handler Handler des Menue-Zustandes
	 */
	public MenuState(Handler handler) {
		super(handler);
		menuUiManager = new UIManager(handler);		
		
		handler.getMouseManager().SetUIManager(menuUiManager);
		
		//Musikspuren ein oder ausschalten
		playing[0] = true;
		playing[1] = true;
		playing[2] = true;
		playing[3] = true;
		
		Musicplayer.music("/audio/themes/menu_theme.wav", true, 0);
		
		//Neues Spiel starten
		menuUiManager.addObject(new UIImageButton(688, 64, 210, 32, Assets.startGameButton, new ClickListener() {

			@Override
			public void onClick() {
				handler.getMouseManager().SetUIManager(null);
				State.setState(handler.getGame().gameState);
				MenuState.setPlaying(0, false);
				creditStateactive = 2;
				Soundplayer.music("/audio/interface/select.wav");
				Musicplayer.music("/audio/themes/game_theme.wav", true, 1);
			}
		}));
		
		//Spiel laden
		menuUiManager.addObject(new UIImageButton(688, 160, 210, 32, Assets.loadGameButton, new ClickListener() {

			@Override
			public void onClick() {
				if(new File("./saveEntitieName.txt").exists()) {
					handler.getMouseManager().SetUIManager(null);
					MenuState.setPlaying(0, false);
					creditStateactive = 2;
					Soundplayer.music("/audio/interface/select.wav");
					Musicplayer.music("/audio/themes/game_theme.wav", true, 1);
					handler.getGame();
					Game.generateLoadState();
					handler.getGame();
					State.setState(Game.loadState);
				}
				else {
					System.out.println("Es wurde noch kein Spielstand gespeichert!");
				}
			}
		}));
		
		//Spiel verlassen
		menuUiManager.addObject(new UIImageButton(688, 480, 210, 32, Assets.exitButton, new ClickListener() {

			@Override
			public void onClick() {
				handler.getMouseManager().SetUIManager(null);
				Soundplayer.music("/audio/interface/select.wav");
				System.exit(1);
			}
		}));
		
		//Credit-State aufrufen
		menuUiManager.addObject(new UIImageButton(688, 576, 210, 32, Assets.creditsButton, new ClickListener() {

			@Override
			public void onClick() {
				handler.getMouseManager().SetUIManager(null);
				State.setState(handler.getGame().creditsState);
				creditStateactive = 1;
				Soundplayer.music("/audio/interface/select.wav");
			}
		}));
		

		
	}
	
	@Override
	public void tick() {
		menuUiManager.tick();
	}

	@Override
	public void render(Graphics paintbrush) {
		paintbrush.drawImage(Assets.gameLauncher, 0, 0, null);
		menuUiManager.render(paintbrush);
		
	}
	
	/**
	 * Zurueckgabe eines boolischen Wertes, ob der Thread der i-ten
	 * Musikspur gerade abgespielt wird.
	 * 
	 * @param i Identifikationsnummer der Tonspur
	 * @return Boolischer Wert, ob Tonspur gerade abgespielt wird
	 */
	public static boolean getPlaying(int i) {
		return playing[i];
	}
	
	/**
	 * Festlegen eines boolischen Wertes, ob der Thread der i-ten 
	 * Musikspur gerade abgespielt wird.
	 * 
	 * @param i Nummer der Tonspur
	 * @param play Boolischer Wert, ob Tonspur gerade abgespielt werden soll
	 */
	public static void setPlaying(int i, boolean play) {
		playing[i] = play;
	}

	/**
	 * Zurueckgabe des Wertes, durch welchen Zustand der Benutzer navigiert ist.
	 * 
	 * @return  0, wenn noch kein Zustand im Menue ausgewaelt<p>
	 * 			1, wenn der Credit-Zustand ausgewaelt wurde<p>
	 * 			2, wenn einer der Spiel-Zustaende ausgewaelt wurde
	 */
	public static int getCreditStateactive() {
		return creditStateactive;
	}

}
