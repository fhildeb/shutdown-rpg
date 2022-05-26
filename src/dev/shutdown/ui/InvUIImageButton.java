package dev.shutdown.ui;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 * Diese Klasse dient zum Erstellen von Buttons der
 * Benutzeroberflaeche des Inventars im Spiel.
 * 
 * @author Felix Hildebrandt
 *
 */
public class InvUIImageButton extends InvUIObject {

	private BufferedImage[] images;
	private ClickListener clicker;
	private int id;
	
	/**
	 * Es werden die Parameter
	 * Identifikationsnummer, Grafik, das Ereignisevent sowie
	 * die Breite, Hoehe und Position des Buttons auf der X- und Y-Achse
	 * der Bildflaeche an die Oberklasse uebergeben.
	 * 
	 * @param id Identifikationsnummer des Buttons
	 * @param x X-Position des Buttons auf der Bildflaeche in Pixel
	 * @param y Y-Position des Buttons auf der Bildflaeche in Pixel
	 * @param width Breite des Buttons in Pixel
	 * @param height Hoehe des Buttons in Pixel
	 * @param images Grafik des Buttons
	 * @param clicker Ereignisevent beim Betaetigen des Buttons
	 */
	public InvUIImageButton(int id, float x, float y, int width, int height, BufferedImage[] images, ClickListener clicker) {
		super(id, x, y, width, height);
		this.images = images;
		this.clicker = clicker;
		this.id = id;
	}

	@Override
	public void tick() {
		//Keine Aktionen benoetigt
	}

	@Override
	public void render(Graphics paintbrush) {
		if(frameActive) {
			paintbrush.drawImage(images[1], (int) x, (int) y, width, height, null);
		}
		else {
			paintbrush.drawImage(images[0], (int) x, (int) y, width, height, null);
		}
		
	}

	@Override
	public void onClick() {
		clicker.onClick();
		
	}

	/**
	 * Zurueckgabe der Identifikationsnummer des Buttons.
	 * 
	 * @return Identifikationsnummer des Buttons
	 */
	public int getId() {
		return id;
	}
}
