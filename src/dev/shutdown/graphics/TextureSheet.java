package dev.shutdown.graphics;

import java.awt.image.BufferedImage;

/**
 * Diese Klasse dient zum Ausschneiden von
 * Teilgrafiken aus groﬂen Einzelbildern.
 * 
 * @author Felix Hildebrandt
 *
 */
public class TextureSheet {

	private BufferedImage textureSheet;
	
	/**
	 * Es wird das Einzelbild uebergeben, aus welchem der
	 * Bildausschnitt erstellt werden soll.
	 * 
	 * @param textureSheet Einzelbild
	 */
	public TextureSheet(BufferedImage textureSheet) {
		this.textureSheet = textureSheet;
	}
	
	/**
	 * Ausschneiden eines Sektor des Einzelbildes
	 * 
	 * @param x Position auf der X-Achse im Einzelbild in Pixel
	 * @param y Position auf der Y-Achse im Einzelbild in Pixel
	 * @param width Breite der Teilgrafik in Pixel
	 * @param height Hoehe der Teilgrafik in Pixel
	 * 
	 * @return Bildausschnitt
	 */
	public BufferedImage cropSector(int x, int y, int width, int height) {
		return textureSheet.getSubimage(x, y, width, height);
	}
}
