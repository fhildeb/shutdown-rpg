package dev.shutdown;

import dev.shutdown.graphics.GameView;
import dev.shutdown.input.InvMouseManager;
import dev.shutdown.input.KeyManager;
import dev.shutdown.input.MouseManager;
import dev.shutdown.maps.LoadMap;
import dev.shutdown.maps.Maps;

/**
 * Diese Klasse definiert den Handler des Spiels ueber
 * welchen sich alle benoetigten Parameter und Objekte
 * im Spiel vereinfacht und zentral aufrufen lassen.
 * 
 * @author Felix Hildebrandt
 *
 */
public class Handler{

	private Game game;
	private Maps map;
	private LoadMap loadmap;
	
	/**
	 * Es wird das Spiel an den Handler uebergeben,
	 * sodass dessen Parameter und Methoden ueber
	 * diesen aufgerufen werden koennen.
	 * 
	 * @param game Spiel
	 */
	public Handler(Game game) {
		this.game = game;
	}

	/**
	 * Zurueckgabe der Breite der Bildflaeche des Spiels in Pixel.
	 * 
	 * @return 	Breite der Bildflaeche des Spiels in Pixel.
	 */
	public int getWidth() {
		return game.getWidth();
	}
	
	/**
	 * Zurueckgabe der Hoehe der Bildflaeche des Spiels in Pixel.
	 * 
	 * @return 	Hoehe der Bildflaeche des Spiels in Pixel.
	 */
	public int getHeight() {
		return game.getHeight();
	}
	
	/**
	 * Zurueckgabe des Managers der Tastatur-Eingabe des Spiels
	 * 
	 * @return 	Manager der Tastatur-Eingabe des Spiels
	 */
	public KeyManager getKeyManager() {
		return game.getKeyManager();
	}
	
	/**
	 * Zurueckgabe des Managers der Maus-Eingabe des Spiels.
	 * 
	 * @return 	Manager der Maus-Eingabe
	 */
	public MouseManager getMouseManager() {
		return game.getMouseManager();
	}
	
	/**
	 * Zurueckgabe des Managers der Inventar-Eingabe des Spiels.
	 * 
	 * @return	Manager der Invantar-Eingabe
	 */
	public InvMouseManager getInvMouseManager() {
		return game.getInvMouseManager();
	}
	
	/**
	 * Zurueckgabe des Spielausschnitts welcher auf der
	 * Bildflaeche des Spiels angezeigt wird.
	 * 
	 * @return	Spielausschnitt der Bildflaeche
	 */
	public GameView getGameView() {
		return game.getGameView();
	}
	
	/**
	 * Zurueckgabe des  Spiels.
	 * 
	 * @return	Spiel
	 */
	public Game getGame() {
		return game;
	}

	/**
	 * Festlegen des Spiels.
	 *  
	 * @param game Spiel
	 */
	public void setGame(Game game) {
		this.game = game;
	}

	/**
	 * Zurueckgabe der Spielwelt.
	 * 
	 * @return 	Spielwelt
	 */
	public Maps getMap() {
		return map;
	}

	/**
	 * Festlegen der Spielwelt.
	 * 
	 * @param map Spielwelt
	 */
	public void setMap(Maps map) {
		this.map = map;
	}

	/**
	 * Zurueckgabe der Spielwelt des gespeicherten Spielstands.
	 * 
	 * @return	 Spielwelt des gespeicherten Spielstands
	 */
	public LoadMap getLoadmap() {
		return loadmap;
	}

	/**
	 * Festlegen der Spielwelt des gespeicherten Spielstands.
	 * 
	 * @param loadmap Spielwelt des gespeicherten Spielstands
	 */
	public void setLoadmap(LoadMap loadmap) {
		this.loadmap = loadmap;
	}
	
}
