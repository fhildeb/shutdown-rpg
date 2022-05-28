package dev.shutdown.items;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import dev.shutdown.Handler;
import dev.shutdown.graphics.Assets;
import dev.shutdown.inventory.Inventory;
import dev.shutdown.maps.Maps;

/**
 * Diese Klasse dient zum Erstellen von Gegenstaenden welche
 * vom Spieler in das Inventar aufgenommen werden koennen um
 * sie als Attacken zu verwenden.
 * 
 * @author Felix Hildebrandt
 */
public class Item {

	//Handler
	public static Item[] items = new Item[256];
	protected Handler handler;
	
	//Aus Gegenstaenden resultierende Attacken
	public static Item attack_1_interact = new Item(Assets.attack_1_interact, "Pick up", "", "Use your fingertip touch to", "retrieve notes and items.", 0);
	public static Item attack_2_stick = new Item(Assets.attack_2_stick, "Wooden stick", "", "With this stick you can smash", "small plants and mushrooms.", 1);
	public static Item attack_3_sword = new Item(Assets.attack_3_sword, "Iron sword", "", "With this weapon you can", "break a wooden trunk.", 2);
	public static Item attack_4_key = new Item(Assets.attack_4_key, "Box key", "", "This universal tool is used to break", "down and dissolve boxes.", 3);
	
	// Klasse
	public static final int ITEMWIDTH = 32, ITEMHEIGHT = 32;
	
	//Eigenschaften
	protected BufferedImage texture;
	protected String name, line2, line3, line4;
	protected final int id;
	protected Rectangle boundBox;
	protected int x, y, count;
	protected boolean pickedUp = false;
	
	/**
	 *  Es wird jedem Gegenstand eine Textur, deren Name, eine
	 * Identifikationsnummer und deren Textboxinhalt zugewiesen. Ausserdem wird fuer jeden
	 * Gegenstand deren Menge und eine neue Kollisionsbox hinzugefuegt.
	 * 
	 * @param texture Grafik des Gegenstandes
	 * @param name Namer des Gegenstandes
	 * @param line2 Textbox des Gegenstandes Zeile 2
	 * @param line3 Textbox des Gegenstandes Zeile 3
	 * @param line4 Textbox des Gegenstandes Zeile 4
	 * @param id Identifikationsnummer des Gegenstandes
	 */
	public Item(BufferedImage texture, 	String name, 	String line2, 
										String line3, 	String line4, int id) {
		//Eigenschaften
		this.texture = texture;
		this.name = name;
		this.line2 = line2;
		this.line3 = line3;
		this.line4 = line4;
		this.id = id;
		count = 1;
		
		//Kollisionsbox
		boundBox = new Rectangle(x, y, ITEMWIDTH, ITEMHEIGHT);
		
		//Zuweisung in die Inventarliste
		items[id] = this;
	}
	
	/**
	 * Aktualisieren der Gegenstaende im Inventar sobald
	 * diese vom Spieler aufgehoben werden.
	 */
	public void tick() {
		handler.getMap();
		if(Maps.getEntityManager().getPlayer().getCollisionBoxes(0f, 0f).intersects(boundBox)) {
			pickedUp = true;
			handler.getMap();
			Maps.getEntityManager().getPlayer().getInventory();
			Inventory.addItem(this);
		}
	}
	
	/**
	 * Zeichnen des Gegenstandes auf die Bildflaeche mit einer
	 * Grafikkomponente als Parameter.
	 * 
	 * @param paintbrush Bildflaeche
	 */
	public void render(Graphics paintbrush) {
		if(handler ==  null)
			return;
		render(paintbrush, (int) (x - handler.getGameView().getxOffSet()), (int) (y - handler.getGameView().getyOffSet()));
	}
	
	/**
	 * Zeichnen des Gegenstandes auf die Bildflaeche mit einer 
	 * Grafikkomponente sowie einer X- und Y-Position als Parameter.
	 * 
	 * @param paintbrush Bildflaeche
	 * @param x Position auf der X-Achse der Bildflaeche in Pixel
	 * @param y Position auf der Y-Achse der Bildflaeche in Pixel
	 */
	public void render(Graphics paintbrush, int x, int y) {
		paintbrush.drawImage(texture,  x,  y,  ITEMWIDTH,  ITEMHEIGHT,  null);
	}

	/**
	 * Einen neuen Gegenstand vom gleichen Typ mit einer Anzahl
	 * auf der Spielwelt erstellen.
	 * 
	 * @param count Anzahl des Gegenstandes
	 * 
	 * @return neuer Gegenstand
	 */
	public Item createNew(int count) {
		Item i = new Item(texture, name, line2, line3, line4, id);
		i.setPickedUp(true);
		i.setCount(count);
		return i;
	}
	
	/**
	 * Einen neuen Gegenstand vom gleichen Typ mit einer X- und Y- Position
	 * in Pixel auf der Spielwelt erstellen.
	 * 
	 * @param x Position der X-Achse auf der Spielwelt in Pixel
	 * @param y Position der Y-Achse auf der Spielwelt in Pixel
	 * 
	 * @return erstellter Gegenstand
	 */
	public Item createNew(int x, int y) {
		Item i = new Item(texture, name, line2, line3, line4, id);
		i.setPosition(x, y);
		return i;
	}
	
	/**
	 * Festlegen der Position des Gegenstandes auf der Spielwelt.
	 * 
	 * @param x Position der X-Achse auf der Spielwelt in Pixel
	 * @param y Position der Y-Achse auf der Spielwelt in Pixel
	 */
	public void setPosition(int x, int y) {
		this.x = x;
		this.y = y;
		boundBox.x = x;
		boundBox.y = y;
	}
	
	/**
	 * Zurueckgabe des Handlers	des Gegenstandes.
	 * 
	 * @return Handler des Gegenstandes
	 */
	public Handler getHandler() {
		return handler;
	}

	/**
	 * Festlegen des Handlers des Gegenstandes.
	 * 
	 * @param handler Handler des Gegenstandes
	 */
	public void setHandler(Handler handler) {
		this.handler = handler;
	}

	/**
	 * Zurueckgabe der Grafik des Gegenstandes.
	 * 
	 * @return Grafik des Gegenstandes
	 */
	public BufferedImage getTexture() {
		return texture;
	}

	/**
	 * Festlegen der Grafik des Gegenstandes.
	 * 
	 * @param texture Grafik des Gegenstandes
	 */
	public void setTexture(BufferedImage texture) {
		this.texture = texture;
	}

	/**
	 * Zurueckgabe des Namens des Gegenstandes.
	 * 
	 * @return Name des Gegenstandes
	 */
	public String getName() {
		return name;
	}

	/**
	 * Festlegen des Namens des Gegenstandes.
	 * 
	 * @param name Name des Gegenstandes
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Zurueckgabe der Position des Gegenstandes auf der X-Achse der Spielwelt in Pixel.
	 * 
	 * @return Position des Gegenstandes auf der X-Achse der Spielwelt in Pixel.
	 */
	public int getX() {
		return x;
	}

	/**
	 * Festlegen der Position des Gegenstandes auf der X-Achse der Spielwelt in Pixel.
	 * 
	 * @param x Position des Gegenstandes auf der X-Achse der Spielwelt in Pixel.
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * Zurueckgabe der Position des Gegenstandes auf der Y-Achse der Spielwelt in Pixel.
	 * 
	 * @return y Position des Gegenstandes auf der Y-Achse der Spielwelt in Pixel.
	 */
	public int getY() {
		return y;
	}

	/**
	 * Festlegen der Position des Gegenstandes auf der Y-Achse der Spielwelt in Pixel.
	 * 
	 * @param y Position des Gegenstandes auf der Y-Achse der Spielwelt in Pixel.
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * Zurueckgabe der Anzahl des Gegenstandes.
	 * 
	 * @return Anzahl des Gegenstandes
	 */
	public int getCount() {
		return count;
	}

	/**
	 * Festlegen der Anzahl des Gegenstandes.
	 * 
	 * @param count Anzahl des Gegenstands
	 */
	public void setCount(int count) {
		this.count = count;
	}

	/**
	 * Zurueckgabe der Identifikationsnummer des Gegenstandes.
	 * 
	 * @return Identifikationsnummer des Gegenstandes
	 */
	public int getId() {
		return id;
	}

	/**
	 * Zurueckgabe eines boolischen Wertes, ob der Gegenstand bereits aufgehoben wurde.
	 * 
	 * @return Boolischer Wert, ob der Gegenstand schon aufgehoben wurde
	 */
	public boolean isPickedUp() {
		return pickedUp;
	}

	/**
	 * Festlegen eines boolischen Wertes, ob der Gegenstand bereits aufgehoben wurde.
	 * 
	 * @param pickedUp Boolischer Wert, ob der Gegenstand schon aufgehoben wurde
	 */
	public void setPickedUp(boolean pickedUp) {
		this.pickedUp = pickedUp;
	}

	/**
	 * Zurueckgabe der zweiten Beschreibungszeile des Gegenstandes.
	 * 
	 * @return zweite Beschreibungszeile des Gegenstandes
	 */
	public String getLine2() {
		return line2;
	}

	/**
	 * Festlegen der zweiten Beschreibungszeile des Gegenstandes.
	 * 
	 * @param line2 zweite Beschreibungszeile des Gegenstandes
	 */
	public void setLine2(String line2) {
		this.line2 = line2;
	}

	/**
	 * Zurueckgabe der dritten Beschreibungszeile des Gegenstandes
	 * 
	 * @return dritte Beschreibungszeile des Gegenstandes
	 */
	public String getLine3() {
		return line3;
	}

	/**
	 * Festlegen der dritten Beschreibungszeile des Gegenstandes.
	 * 
	 * @param line3 dritte Beschreibungszeile des Gegenstandes
	 */
	public void setLine3(String line3) {
		this.line3 = line3;
	}

	/**
	 * Zurueckgabe der vierten Beschreibungszeile des Gegenstandes.
	 * 
	 * @return vierte Beschreibungszeile des Gegenstandes
	 */
	public String getLine4() {
		return line4;
	}

	/**
	 * Festlegen der vierten Beschreibungszeile des Gegenstandes.
	 * 
	 * @param line4 vierte Beschreibungszeile des Gegenstandes
	 */
	public void setLine4(String line4) {
		this.line4 = line4;
	}
}
