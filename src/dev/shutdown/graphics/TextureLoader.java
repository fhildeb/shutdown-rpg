package dev.shutdown.graphics;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * Diese Klasse dient zum Lesen und Laden von Grafikdateien.
 * 
 * @author Felix Hildebrandt
 *
 */
public class TextureLoader {

	/**
	 * Es wird der Pfad des Bildes uebergeben und
	 * diese Datei dann gelesen und ausgegeben.
	 * 
	 * @param path Pfad des Bildes
	 * 
	 * @return Bild
	 */
	public static BufferedImage loadTexture(String path) {
		try {
			return ImageIO.read(TextureLoader.class.getResource(path));
		} catch (IOException e) {
			System.exit(1);
		}
		return null;
	}
}
