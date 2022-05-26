package dev.shutdown.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Diese Klasse realisiert den Tasten-Manager welcher
 * die Tastatureingaben vom Benutzer behandelt.
 * 
 * @author Felix Hildebrandt
 *
 */
public class KeyManager implements KeyListener {

	public boolean[] keys, justPressed, cantPressed;
	public boolean up, down, left, right, attack, interact;
	
	/**
	 * Es wird fuer jede neue Taste einen boolischer Wert initialisiert
	 * welcher angibt, ob die Taste gedrueckt wurde.
	 */
	public KeyManager() {
		keys = new boolean[256];
		justPressed = new boolean[keys.length];
		cantPressed = new boolean[keys.length];
	}
	
	/**
	 * Angabe, ob die Taste schon einmal gedrueckt wurde.
	 * 
	 * @param keyCode Code der Taste auf der Tastatur
	 * 
	 * @return boolischer Wert, ob Taste schon gedrueckt wurde
	 */
	public boolean keyJustPressed(int keyCode) {
		if(keyCode < 0 || keyCode >= keys.length)
			return false;
		return justPressed[keyCode];
	}
	
	/**
	 * Aktualisieren welche Taste gerade gedrueckt bzw.
	 * losgelassen wurde.
	 */
	public void tick() {
		for(int i = 0; i < keys.length; i++) {
			if(cantPressed[i] && !keys[i]) {
				cantPressed[i] = false;
			}
			else if(justPressed[i]) {
				cantPressed[i] = true;
				justPressed[i] = false;
			}
			if (!cantPressed[i] && keys[i]) {
				justPressed[i] = true;
			}
		}
		
		//Wenn Taste zuvor schon einmal gedrueckt wurde
		if(keyJustPressed(KeyEvent.VK_E)) {
		}
		
		up = keys[KeyEvent.VK_W];
		down = keys[KeyEvent.VK_S];
		left = keys[KeyEvent.VK_A];
		right = keys[KeyEvent.VK_D];
		interact = keys[KeyEvent.VK_F];
		attack = keys[KeyEvent.VK_SPACE];
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() < 0 || e.getKeyCode() >= keys.length)
			return;
		keys[e.getKeyCode()] = true;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() < 0 || e.getKeyCode() >= keys.length)
			return;
		keys[e.getKeyCode()] = false;
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		//Aktion nicht benoetigt
	}

}
