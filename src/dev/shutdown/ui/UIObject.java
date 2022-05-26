package dev.shutdown.ui;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;

/**
 * Diese abstrakte Klasse dient zum Erstellen eines Benutzeroberflaechen-Objektes
 * des Menues.
 * 
 * @author Felix Hildebrandt
 *
 */
public abstract class UIObject {

	protected float x, y;
	protected int width, height;
	protected boolean hover = false;
	protected Rectangle buttonBox;
	
	/**
	 * Es werden der Parameter Hoehe, Breite
	 * und Position auf der X- und Y-Achse der Bildflaeche des Objektes
	 * uebergeben und eine neue Objektbox angelegt.
	 * 
	 * @param x X-Position auf der Bildflaeche
	 * @param y Y-Position auf der Bildflaeche
	 * @param width Breite des Menue-Objektes
	 * @param height Hoehe des Menue-Objektes
	 */
	public UIObject(float x, float y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		buttonBox = new Rectangle((int)x, (int) y, width, height);
		
	}
	
	/**
	 * Aktualisieren des Menu-Objektes.
	 */
	public abstract void tick();
	
	/**
	 * Zeichen des Menue-Objekt auf die Bildflaeche.
	 * 
	 * @param paintbrush Bildflaeche
	 */
	public abstract void render(Graphics paintbrush);
	
	/**
     * Aktion welche beim Klicken auf das Menue-Objektes ausgefuert werden soll.
	 */
	public abstract void onClick();
	
	/**
	 * Ereignis welches ausgefuert werden soll wenn sich die Maustaste ueber
	 * dem Menue-Objekt befindet.
	 * 
	 * @param e Maus-Event
	 */
	public void onMouseMove(MouseEvent e) {
		if(buttonBox.contains(e.getX(), e.getY())) {
			hover = true;
		}
		else {
			hover = false;
			}
	}
	
	/**
	 * Ereignis welches ausgefuert werden soll wenn 
	 * die Maustaste auf dem Menue-Objekt losgelassen wird.
	 * 
	 * @param e Maus-Event
	 */
	public void onMouseRelease(MouseEvent e) {
		if(hover) {
			onClick();
		}
	}
	
	/**
	 * Zurueckgabe der Position des Menue-Objektes auf der X-Achse der Bildflaeche in Pixel.
	 * 
	 * @return Position des Menue-Objektes auf der X-Achse der Bildflaeche in Pixel
	 */
	public float getX() {
		return x;
	}

	/**
	 * Festlegen Position des Menue-Objektes auf der X-Achse der Bildflaeche in Pixel.
	 * 
	 * @param x Position des Menue-Objektes auf der X-Achse der Bildflaeche in Pixel
	 */
	public void setX(float x) {
		this.x = x;
	}

	/**
	 * Zurueckgabe der Position des Menue-Objektes auf der Y-Achse der Bildflaeche in Pixel.
	 * 
	 * @return Position des Menue-Objektes auf der Y-Achse der Bildflaeche in Pixel
	 */
	public float getY() {
		return y;
	}

	/**
	 * Festlegen der Position des Menue-Objektes auf der Y-Achse der Bildflaeche in Pixel.
	 * 
	 * @param y Position des Menue-Objektes auf der Y-Achse der Bildflaeche in Pixel
	 */
	public void setY(float y) {
		this.y = y;
	}

	/**
	 * Zurueckgabe der Breite des Menue-Objektes in Pixel.
	 * 
	 * @return Breite des Menue-Objektes in Pixel
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * Festlegen der Breite des Menue-Objektes in Pixel.
	 * 
	 * @param width Breite des Menue-Objektes in Pixel
	 */
	public void setWidth(int width) {
		this.width = width;
	}

	/**
	 * Zurueckgabe der Hoehe des Menue-Objektes in Pixel.
	 * 
	 * @return Hoehe des Menue-Objektes in Pixel
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * Festlegen der Hoehe des Menue-Objektes in Pixel.
	 * 
	 * @param height Hoehe des Menue-Objektes in Pixel
	 */
	public void setHeight(int height) {
		this.height = height;
	}

	/**
	 * Zurueckgabe eines booischen Werts, ob das Menue-Objekt im Hover-Zustand ist.
	 * 
	 * @return booischer Wert, ob das Menue-Objekt im Hover-Zustand ist
	 */
	public boolean isHover() {
		return hover;
	}

	/**
	 * Festlegen eines booischen Werts, ob das Menue-Objekt im Hover-Zustand ist.
	 * 
	 * @param hover booischer Wert, ob das Menue-Objekt im Hover-Zustand sein soll
	 */
	public void setHover(boolean hover) {
		this.hover = hover;
	}
}
