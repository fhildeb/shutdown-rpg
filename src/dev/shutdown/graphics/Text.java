package dev.shutdown.graphics;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;

/**
 * Diese Klasse dient zur Ausgabe von
 * Text auf der Bildflaeche.
 * 
 * @author Felix Hildebrandt
 *
 */
public class Text {

	/**
	 * Es werden die Eigenschaften Text, Zentrierung, Farbe, Schriftart
	 * sowie die X- und Y-Position auf der Bildflaeche in Pixel eingelesen
	 * und der Text mit den angegebenen Konfigurationen auf die 
	 * Bildflaeche gezeichet.
	 * 
	 * @param paintbrush Bildflaeche
	 * @param text Text
	 * @param xPosition Position des Textanfangs auf der X-Achse in Pixel
	 * @param yPosition Position des Textanfangs auf der Y-Achse in Pixel
	 * @param center Boolischer Wert, ob Text zentriert werden soll
	 * @param c Farbe des Textes
	 * @param font Schriftart des Textes
	 */
	public static void drawString(Graphics paintbrush, String text, int xPosition, int yPosition, boolean center, Color c, Font font){
		
		paintbrush.setColor(c);
		paintbrush.setFont(font);
		int x = xPosition;
		int y = yPosition;
		
		//Falls Zentrierung
		if(center) {
			FontMetrics fm = paintbrush.getFontMetrics(font);
			x = (xPosition - fm.stringWidth(text) / 2);
			y = (yPosition - fm.getHeight() / 2) + fm.getAscent();
		}
		
		paintbrush.drawString(text, x, y);
	}
}
