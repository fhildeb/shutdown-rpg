package dev.shutdown.entities.statics;

import dev.shutdown.Handler;
import dev.shutdown.entities.Entity;

/**
 * Diese abstrakte Klasse vereint alle statischen
 * Objekte in der Spielwelt.
 * 
 * @author Felix Hildebrandt
 *
 */
public abstract class StaticEntity extends Entity {

	/**
	 * Es werden die Parameter der X- und Y-Position sowie die Breite und Hoehe
	 * des statischen Objektes auf der Spielwelt an die Oberklasse uebergeben.
	 * Genauso verhaelt es sich auch mit dem Handler und den Lebensbalken bezueglich der
	 * einzelnen Attacken.
	 * 
	 * @param handler Handler des Spiels
	 * @param x Position des Objekts auf der X-Achse in Pixel
	 * @param y Position des Objekts auf der Y-Achse in Pixel
	 * @param width Breite des Objekts in Pixel
	 * @param height Hoehe des Objekts in Pixel
	 * @param health1 Lebensbalken bezueglich der Hand-Interaktion
	 * @param health2 Lebensbalken bezueglich der Stock-Interaktion
	 * @param health3 Lebensbalken bezueglich der Schwert-Interaktion
	 * @param health4 Lebensbalken bezueglich der Schluessel-Interaktion
	 */
	public StaticEntity(Handler handler, float x, float y, int width, int height, int health1, int health2, int health3, int health4) {
		super(handler, x, y, width, height, health1, health2, health3, health4);
	}
}
