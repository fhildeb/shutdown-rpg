package dev.shutdown.ui;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;

import dev.shutdown.inventory.Inventory;
import dev.shutdown.inventory.SheetInventory;

/**
 * Diese abstrakte Klasse dient zum erstellen eines Benutzeroberflaechen-Objektes
 * des Inventars.
 * 
 * @author Felix Hildebrandt
 *
 */
public abstract class InvUIObject {

	protected float x, y;
	protected int width, height;
	protected int id;
	protected boolean frameActive; //= new boolean[12];
	protected boolean hover = false;
	protected boolean possible = false;
	protected Rectangle boundBox;
	
	/**
	 * Es werden der Parameter Identifikationsnummer sowie die Hoehe, Breite
	 * und Position auf der X- und Y-Achse der Bildflaeche des Objektes
	 * uebergeben und eine neue Objektbox angelegt.
	 * 
	 * @param id Identifikationsnummer des Inventar-Objektes
	 * @param x X-Position auf der Bildflaeche
	 * @param y Y-Position auf der Bildflaeche
	 * @param width Breite des Inventar-Objektes
	 * @param height Hoehe des Inventar-Objektes
	 */
	public InvUIObject(int id, float x, float y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		boundBox = new Rectangle((int) x, (int) y, width, height);
		this.id = id;
	}

	/**
	 * Aktualisieren des Inventar-Objektes.
	 */
	public abstract void tick();
	
	/**
	 * Zeichen der Inventar-Objekte auf die Bildflaeche.
	 * 
	 * @param paintbrush Bildflaeche
	 */
	public abstract void render(Graphics paintbrush);
	
	/**
	 * Ereignis welches beim Klicken auf das Inventar-Objekt ausgefuert werden soll.
	 */
	public abstract void onClick();
	
	/**
	 * Ereignis welches ausgefuert werden soll wenn sich die Maustaste ueber
	 * dem Inventar-Objekt befindet.
	 * 
	 * @param e Maus-Event
	 */
	public void onMouseMove(MouseEvent e) {
		if(boundBox.contains(e.getX(), e.getY()))
			hover = true;
		else
			hover = false;
	}
	
	/**
	 * Ereignis welches ausgefuert werden soll wenn 
	 * die Maustaste auf dem Inventar-Objekt losgelassen wird.
	 * 
	 * @param e Maus-Event
	 */
	public void onMouseRelease(MouseEvent e) {
		if(hover) {
			for(int o = 0; o < 12; o++) {
				InvUIManager.getObjects().get(o).setFrameActive(false);
				//i = InvUIManager.getObjects().get(o).getId();
			}
			if((this.id +1) <= (SheetInventory.getSheetItems().size()+Inventory.getInventoryItems().size())) {
				frameActive /*[id]*/ = true;
			}
			hover = true;
			onClick();
		}
	}
	
	/**
	 * Zurueckgabe der Position des Inventar-Objektes auf der X-Achse der Bildflaeche in Pixel.
	 * 
	 * @return Position des Inventar-Objektes auf der X-Achse der Bildflaeche in Pixel
	 */
	public float getX() {
		return x;
	}

	/**
	 * Festlegen der Position des Inventar-Objektes auf der X-Achse der Bildflaechen in Pixel.
	 * 
	 * @param x Position des Inventar-Objektes auf der X-Achse der Bildflaeche in Pixel
	 */
	public void setX(float x) {
		this.x = x;
	}

	/**
	 * Zurueckgabe der Position des Inventar-Objektes auf der Y-Achse der Bildflaeche in Pixel.
	 * 
	 * @return Position des Inventar-Objektes auf der Y-Achse der Bildflaeche in Pixel
	 */
	public float getY() {
		return y;
	}

	/**
	 * Festlegen der Position des Inventar-Objektes auf der Y-Achse der Bildflaeche in Pixel.
	 * 
	 * @param y Position des Inventar-Objektes auf der Y-Achse der Bildflaeche in Pixel
	 */
	public void setY(float y) {
		this.y = y;
	}

	/**
	 * Zurueckgabe der Breite des Inventar-Objektes in Pixel.
	 * 
	 * @return Breite des Inventar-Objektes in Pixel
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * Festlegen der Breite des Inventar-Objektes in Pixel.
	 * 
	 * @param width Breite des Inventar-Objektes in Pixel
	 */
	public void setWidth(int width) {
		this.width = width;
	}

	/**
	 * Zurueckgabe der Hoehe des Inventar-Objektes in Pixel.
	 * 
	 * @return Hoehe des Inventar-Objektes in Pixel
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * Festlegen der Hoehe des Inventar-Objektes in Pixel.
	 * 
	 * @param height Hoehe des Inventar-Objektes in Pixel
	 */
	public void setHeight(int height) {
		this.height = height;
	}

	/**
	 * Zurueckgabe der Identifikationsnummer des Inventar-Objektes.
	 * 
	 * @return Identifikationsnummer des Inventar-Objektes
	 */
	public int getId() {
		return id;
	}

	/**
	 * Zurueckgeben eines boolischen Wertes, ob das Inventar-Objekt angezeigt wird.
	 * 
	 * @return boolischer Wert, ob das Invnetar-Objekt angezeigt wird
	 */
	public boolean getFrameActive() {
		return frameActive;
	}
	
	/**
	 * Festlegen des boolischen Wertes, ob das Inventar-Objekt angezeigt wird.
	 * 
	 * @param frameActive boolischer Wert ob des Inventar-Objekt angezeigt wird
	 */
	public void setFrameActive(boolean frameActive) {
		this.frameActive = frameActive;
	}
		
}
