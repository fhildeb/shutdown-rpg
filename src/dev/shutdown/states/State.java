package dev.shutdown.states;

import java.awt.Graphics;

import dev.shutdown.Handler;

/**
 * Diese abstrakte Klasse definiert alle Methoden
 * welche ein Spiel-Zustand benoetigt
 * @author Felix Hildebrandt
 *
 */
public abstract class State {

	//State zum Anfang
	private static State currentState = null;
	
	//Handler
	protected Handler handler;
	
	/**
	 * Es wird der Handler fuer den aktuellen Zustand gesetzt.
	 * 
	 * @param handler Handler des Spiels
	 */
	public State(Handler handler) {
		this.handler = handler;
	}
	
	/**
	 * Festlegen des aktuellen Zustand des Spiels.
	 * 
	 * @param state aktueller Zustand des Spiels
	 */
	public static void setState(State state) {
		currentState = state;
	}
	
	/**
	 * Zurueckgabe des aktuellen Zustands des Spiels.
	 * 
	 * @return aktueller Zustand des Spiels
	 */
	public static State getState() {
		return currentState;
	}
	
	/**
	 * Aktualisieren der Objekte innerhalb des Zustands.
	 */
	public abstract void tick();
	
	/**
	 * Zeichnen der Objekte des Zustandes auf die Bildflaeche.
	 * 
	 * @param paintbrush Bildflaeche
	 */
	public abstract void render(Graphics paintbrush);
}
