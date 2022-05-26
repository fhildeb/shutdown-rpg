package dev.shutdown.entities;

import java.awt.Graphics;
import java.awt.Rectangle;

import dev.shutdown.Handler;
import dev.shutdown.maps.Maps;

/**
 * Dies ist eine abstrakte Klasse die dazu dient Objekte
 * in der Spielwelt platzieren zu koennen. Jedes Objekt wird 
 * in den Objekte-Manager aufgenommen von welchem die Gesamtheit 
 * organisiert werden.
 * 
 * @author Felix Hildebrandt
 *
 */
public abstract class Entity {

	//Standard-Lebensanzahl eines Objektes
	public static final int DEFAULT_HEALTH = 4;
	
	//Klasse
	protected Handler handler;
	protected float x, y;
	protected int width, height;
	protected int health1, health2, health3, health4;
	protected boolean active = true;
	protected Rectangle collisionBox;
	
	/**
	 * Es werden die Parameter Handler und die Anzahl des Lebens bezueglich
	 * der Attacken Hand, Stock, Schwert und Schluessel uebergeben. Ebenso werden
	 * dem Objekt die Position auf X- und Y-Achse sowie dessen Breite und Hoehe in Pixel erfasst.
	 * Zudem wird fuer jedes Objekt ein Kollisionsradius festgelegt, welcher angibt
	 * welcher Bereich des Objektes fuer Kreaturen unbetretbar und angreifbar ist.
	 * 
	 * @param handler	Handler des Objektes
	 * @param x			Position des Objektes auf der X-Achse in Pixel
	 * @param y			Position des Objektes auf der Y-Achse in Pixel
	 * @param width		Breite des Objektes in Pixel
	 * @param height	Hoehe des Objektes in Pixel
	 * @param health1	Lebensbalken des Objektes bezueglich der Hand-Attacke
	 * @param health2	Lebensbalken des Objektes bezueglich des Stock-Attacke
	 * @param health3	Lebensbalken des Objektes bezueglich des Schwert-Attacke
	 * @param health4	Lebensbalken des Objektes bezueglich der Schluessel-Attacke
	 */
	public Entity(Handler handler, float x, float y, int width,int height, int health1, int health2, int health3, int health4) {
		
		this.handler = handler;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.health1 = health1;
		this.health2 = health2;
		this.health3 = health3;
		this.health4 = health4;
		
		//Kollisionsbox
		collisionBox = new Rectangle(0, 0, width, height);
	}
	
	/**
	 * Vorgabe einer Methode welche definiert
	 * was passiert, sobald das Objekt in einem
	 * seiner Balken kein Leben mehr hat.
	 */
	public abstract void disappear();
	
	/**
	 * Ereignismethode beim Attackieren mit der Hand.
	 * 
	 * @param amount 	Anzahl des Lebensverlustes 
	 * 					im Lebensbalken der Hand-Attacke
	 */
	public void damage1(int amount) {
		health1 -= amount;
		if(health1 <= 0) {
			active = false;
			disappear();
		}
	}
	
	/**
	 * Ereignismethode beim Attackieren mit dem Stock.
	 * 
	 * @param amount 	Anzahl des Lebensverlustes
	 * 					im Lebensbalken der Stock-Attacke
	 */
	public void damage2(int amount) {
		health2 -= amount;
		if(health2 <= 0) {
			active = false;
			disappear();
		}
	}
	
	/**
	 * Ereignismethode beim Attackieren mit dem Schwert.
	 * 
	 * @param amount 	Anzahl des Lebensverlustes
	 * 					im Lebensbalken der Schwert-Attacke
	 */
	public void damage3(int amount) {
		health3 -= amount;
		if(health3 <= 0) {
			active = false;
			disappear();
		}
	}
	
	/**
	 * Ereignismethode beim Attackieren mit dem Schluessel.
	 * 
	 * @param amount 	Anzahl des Lebensverlustes
	 * 					im Lebensbalken der Schluessel-Attacke
	 */
	public void damage4(int amount) {
		health4 -= amount;
		if(health4 <= 0) {
			active = false;
			disappear();
		}
	}
	
	/**
	 * Zurueckgabe des aktuellen Wertes des
	 * Lebensbalkens der Hand-Attacke.
	 * 
	 * @return 	Wert des Lebensbalkens der Hand-Attacke
	 */
	public int getHealth1() {
		return health1;
	}

	/**
	 * Festlegen des aktuellen Wertes des
	 * Lebensbalkens der Hand-Attacke.
	 * 
	 * @param health1	Wert des Lebensbalkens der Hand-Attacke
	 */
	public void setHealth1(int health1) {
		this.health1 = health1;
	}

	/**
	 * Zurueckgabe des aktuellen Wertes des
	 * Lebensbalkens der Stock-Attacke.
	 * 
	 * @return 	Wert des Lebensbalkens der Stock-Attacke
	 */
	public int getHealth2() {
		return health2;
	}

	/**
	 * Festlegen des aktuellen Wertes des
	 * Lebensbalkens der Stock-Attacke.
	 * 
	 * @param health2 	Wert des Lebensbalkens der Stock-Attacke
	 */
	public void setHealth2(int health2) {
		this.health2 = health2;
	}

	/**
	 * Zurueckgabe des aktuellen Wertes des
	 * Lebensbalkens der Schwert-Attacke.
	 * 
	 * @return 	Wert des Lebensbalkens der Schwert-Attacke
	 */
	public int getHealth3() {
		return health3;
	}

	/**
	 * Festlegen des aktuellen Wertes des
	 * Lebensbalkens der Schwert-Attacke.
	 * 
	 * @param health3 	Wert des Lebensbalkens der Schwert-Attacke
	 */
	public void setHealth3(int health3) {
		this.health3 = health3;
	}

	/**
	 * Zurueckgabe des aktuellen Wertes des
	 * Lebensbalkens der Schluessel-Attacke.
	 * 
	 * @return 	Wert des Lebensbalkens der Schluessel-Attacke
	 */
	public int getHealth4() {
		return health4;
	}

	/**
	 * Festlegen des aktuellen Wertes des
	 * Lebensbalkens der Schluessel-Attacke.
	 * 
	 * @param health4 	Wert des Lebensbalkens der Schluessel-Attacke
	 */
	public void setHealth4(int health4) {
		this.health4 = health4;
	}

	/**
	 * Zurueckgabe des boolischen Wertes ob das Objekt auf 
	 * der Spielwelt angezeigt wird.
	 * 
	 * @return	Boolischer Wert, ob das Objekt auf der Spielwelt angezeigt
	 * 			wird
	 */
	public boolean isActive() {
		return active;
	}

	/**
	 * Festlegen des boolischen Wertes ob das Objekt gerade auf 
	 * der Spielwelt angezeigt wird.
	 * 
	 * @param active	Boolischer Wert, ob das Objekt auf der Spielwelt angezeigt
	 * 					wird
	 */
	public void setActive(boolean active) {
		this.active = active;
	}

	/**
	 * Zurueckgabe der Position des Objektes auf der X-Achse in Pixel.
	 * 
	 * @return Position des Objektes auf der X-Achse in Pixel
	 */
	public float getX() {
		return x;
	}

	/**
	 * Festlegen der Position des Objektes auf der X-Achse in Pixel.
	 * 
	 * @param x Position des Objektes auf der X-Achse in Pixel
	 */
	public void setX(float x) {
		this.x = x;
	}

	/**
	 * Zurueckgabe der Position des Objektes auf der Y-Achse in Pixel.
	 * 
	 * @return Position des Objektes auf der Y-Achse in Pixel
	 */
	public float getY() {
		return y;
	}

	/**
	 * Festlegen der Position des Objektes auf der Y-Achse in Pixel.
	 * 
	 * @param y Position des Objektes auf der Y-Achse in Pixel
	 */
	public void setY(float y) {
		this.y = y;
	}

	/**
	 * Zurueckgabe der Breite des Objektes in Pixel.
	 * 
	 * @return Breite des Objektes in Pixel
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * Festlegen der Breite des Objektes in Pixel.
	 * 
	 * @param width Breite des Objektes in Pixel
	 */
	public void setWidth(int width) {
		this.width = width;
	}

	/**
	 * Zurueckgabe der Hoehe des Objektes in Pixel.
	 * 
	 * @return Hoehe des Objektes in Pixel
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * Festlegen der Hoehe des Objektes in Pixel.
	 * 
	 * @param height Hoehe des Objektes in Pixel
	 */
	public void setHeight(int height) {
		this.height = height;
	}

	/**
	 * Aktualisieren der Objekteigenschaften
	 * wie Animationen, Bewegungen, Kamera, Attacken oder die Inventare.
	 */
	public abstract void tick();
	
	/**
	 * Zeichen der aktuellen Objekte und Animationen in die Spielwelt innerhalb 
	 * der Bildflaeche des Spiels.
	 * 
	 * @param paintbrush Bildflaeche des Spiels
	 */
	public abstract void render(Graphics paintbrush);
	
	/**
	 * Ueberpruefung ob das Objekt mit der Kollisionsbox eines
	 * anderen Objektes in der Spielwelt kollidiert. Dabei muss die
	 * Verschiebung vom Spielausschnitt bezueglich der Spielwelt
	 * einkalkuliert werden.
	 * 
	 * @param 	xOffSet	Verschiebung auf der X-Achse bedingt durch den sich
	 * 					mit dem Spieler dynamisch bewegenden Spielausschnittes 
	 * 					im Bezug auf die Spielwelt und deren Objekte
	 * @param 	yOffSet	Verschiebung auf der Y-Achse bedingt durch den sich
	 * 					mit dem Spieler dynamisch bewegenden Spielausschnittes 
	 * 					im Bezug auf die Spielwelt und deren Objekte
	 * 
	 * @return 	Boolischer Wert, ob das Objekt mit einem anderen Objekt
	 * 			kollidiert.
	 */
	public boolean checkEntityCollisions(float xOffSet, float yOffSet) {
		handler.getMap();
		Maps.getEntityManager();
		for(Entity e : EntityManager.getEntities()) {
			
			//Falls Objekt mit sich selbst kollidiert
			if(e.equals(this)) {
				continue;
			}
			
			//Falls tatsaechliche Kollision stattfindet
			if(e.getCollisionBoxes(0f, 0f).intersects(getCollisionBoxes(xOffSet, yOffSet)))
				return true;
		}
		return false;
	}
	
	/**
	 * Zurueckgabe der Kollisionsbox des Objektes.
	 * 
	 * @param 	xOffSet	Verschiebung auf der X-Achse bedingt durch den sich
	 * 					mit dem Spieler dynamisch bewegenden Spielausschnittes 
	 * 					im Bezug auf die Spielwelt und deren Objekte
	 * @param 	yOffSet	Verschiebung auf der Y-Achse bedingt durch den sich
	 * 					mit dem Spieler dynamisch bewegenden Spielausschnittes 
	 * 					im Bezug auf die Spielwelt und deren Objekte
	 * 
	 * @return	Kollisionbox des Objektes
	 */
	public Rectangle getCollisionBoxes(float xOffSet, float yOffSet){
		return new Rectangle((int)(x + collisionBox.x + xOffSet), (int) (y + collisionBox.y + yOffSet), collisionBox.width, collisionBox.height);
	}
}
