package dev.shutdown.graphics;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;
import java.io.InputStream;

/**
 * Diese Klasse dient zum Laden von Schriftarten.
 * 
 * @author Felix Hildebrandt
 *
 */
public class FontLoader {

	/**
	 * Einlesen der TTF-Datei ueber den Pfad und
	 * Laden der Schriftart mit Hilfe des Groessenparameters.
	 * 
	 * @param path Pfad zur TTF-Datei
	 * @param size Groesse der Schriftart
	 * 
	 * @return Schriftart
	 */
	public Font loadFont(String path, float size) {
		try {
			
			InputStream stream = this.getClass().getResourceAsStream(path);
			return Font.createFont(Font.TRUETYPE_FONT, stream).deriveFont(Font.PLAIN, size);
			
		} catch (FontFormatException | IOException e) {
			//Bei Fehler
			e.printStackTrace();
			System.exit(1);
		}
		return null;
	}
}
