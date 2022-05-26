package dev.shutdown.input;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import dev.shutdown.ui.UIManager;

/**
 * Diese Klasse realisiert den Maus-Manager welcher
 * die Eingaben in der Benutzeroberflaeche vom Spieler einliest.
 * 
 * @author Felix Hildebrandt
 *
 */
public class MouseManager implements MouseListener, MouseMotionListener {

	public boolean leftPressed, rightPressed;
	private int mouseX, mouseY;
	private UIManager uiManager;
	
	/**
	 * Konstruktormethode des Maus-Managers der Benutzeroberflaeche.
	 */
	public MouseManager() {
		//Keine Konstruktor benoetigt
	}
	
	/**
	 * Festlegen des Managers der Benutzeroberflaeche.
	 * 
	 * @param uiManager Manager der Benutzeroberflaeche
	 */
	public void SetUIManager(UIManager uiManager) {
		this.uiManager = uiManager;
	}
	
	/**
	 * Zurueckgabe eines boolischen Wertes, ob linke Maus-Taste
	 * gedrueckt ist.
	 * 
	 * @return Boolischer Wert, ob linke Maus-Taste gedrueckt ist
	 */
	public boolean isLeftPressed(){
		return leftPressed;
	}
		
	/**
	 * Zurueckgabe eines boolischen Wertes, ob rechte Maus-Taste
	 * gedrueckt ist.
	 * 
	 * @return Boolischer Wert, ob rechte Maus-Taste gedrueckt ist
	 */
	public boolean isRightPressed(){
		return rightPressed;
	}
	
	/**
	 * Zurueckgabe der Position des Mauszeigers auf der X-Achse in Pixel.
	 * 
	 * @return Position des Mauszeigers auf der X-Achse in Pixel
	 */
	public int getMouseX() {
		return mouseX;
	}
	
	/**
	 * Zurueckgabe der Position des Mauszeigers auf der Y-Achse in Pixel
	 * 
	 * @return Position des Mauszeigers auf der Y-Achse in Pixel
	 */
	public int getMouseY() {
		return mouseY;
	}
	
	// Implementierte Java-Methoden fuer den Mauszeiger
	
	@Override
	public void mouseMoved(MouseEvent e) {
		mouseX = e.getX();
		mouseY = e.getY();
		
		if(uiManager != null)
			uiManager.onMouseMove(e);
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if(e.getButton() == MouseEvent.BUTTON1)
			leftPressed = true;
		if(e.getButton() == MouseEvent.BUTTON3)
			rightPressed = true;
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if(e.getButton() == MouseEvent.BUTTON1)
			leftPressed = false;
		if(e.getButton() == MouseEvent.BUTTON3)
			rightPressed = false;
		
		if(uiManager != null)
			uiManager.onMouseRelease(e);
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		//Aktion nicht benoetigt
	}
	
	@Override
	public void mouseEntered(MouseEvent e) {
		//Aktion nicht benoetigt
	}

	@Override
	public void mouseExited(MouseEvent e) {
		//Aktion nicht benoetigt
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		//Aktion nicht benoetigt	
	}
}
