package dev.shutdown.ui;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 * Diese Klasse dient zum Erstellen von Buttons der
 * Benutzeroberflaeche des Menues im Spiel.
 * 
 * @author Felix Hildebrandt
 *
 */
public class UIImageButton extends UIObject {

	private BufferedImage[] images;
	private ClickListener clicker;
	
	/**
	 * Es werden die Parameter Grafik, das Ereignisevent 
	 * sowie die Breite, Hoehe und Position des Buttons auf der X- und Y-Achse
	 * der Bildflaeche an die Oberklasse uebergeben.
	 * 
	 * @param x X-Position des Buttons auf der Bildflaeche
	 * @param y Y-Position des Buttons auf der Bildflaeche
	 * @param width Breite des Buttons
	 * @param height Hoehe des Buttons
	 * @param images Bild des Buttons
	 * @param clicker Ereignisevent beim Betaetigen des Buttons
	 */
	public UIImageButton(float x, float y, int width, int height, BufferedImage[] images, ClickListener clicker) {
		super(x, y, width, height);
		this.images = images;
		this.clicker = clicker;
	}

	@Override
	public void tick() {
		
	}

	@Override
	public void render(Graphics paintbrush) {
		if(hover) {
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
}
