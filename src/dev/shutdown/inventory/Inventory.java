package dev.shutdown.inventory;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import dev.shutdown.Handler;
import dev.shutdown.graphics.Assets;
import dev.shutdown.graphics.Text;
import dev.shutdown.items.Item;

/**
 * Diese Klasse dient zum Erstellen eines Inventar des Spielers um dessen
 * aufgehobene Gegenstarnde als Attacken benutzen und dessen Eigenschaften einsehe
 * zu koennen.
 * 
 * @author Felix Hildebrandt
 *
 */
public class Inventory {

	//Klasse
	private Handler handler;
	private boolean active = true;
	private static ArrayList<Item> inventoryItems;
	
	//Anzeige der Textboxen der Attacke
	private int invMessageX = 466;
	private int invMessageLine1 = 561;
	private int invMessageLine2 = 580;
	private int invMessageLine3 = 600;
	private int invMessageLine4 = 620;
	
	//Anzeige der Grafiken der Attacke
	private int attackSlotY = 528;
	private int Slot1 = 48;
	
	//Benutzung des Inventars
	public static int selectedItem = 0;
	public static boolean wannaSee = false;
	public int positionItem = 0;
	
	/**
	 * Dem Inventar wird ein Handler
	 * zugewieden und eine neue Liste fuer
	 * die Gegenstaende erstellt.
	 * 
	 * @param handler Handler des Inventars
	 */
	public Inventory(Handler handler) {
		this.handler = handler;
		inventoryItems = new ArrayList<Item>();

	}
	
	/**
	 * Aktualisieren des Inventars.
	 */
	public void tick(){
		/*
		 * Die Aktualisierung der ausgewaelten Gegenstaende wird
		 * ueber die Benutzeroeberflaeche gesteuert
		 */
	}
	
	/**
	 * Zurueckgabe eines boolischen Wertes, ob Inventar angezeigt wird.
	 * 
	 * @return boolischer Wert, ob Inventar angezeigt wird
	 */
	public boolean isActive() {
		return active;
	}

	/**
	 * Zeichnen des Inventars mit allen Gegenstaenden
	 * sowie deren Beschreibung auf die Bildflaeche.
	 * 
	 * @param paintbrush Bildflaeche
	 */
	public void render(Graphics paintbrush) {
		
		//Falls Inventar nicht aktiv ist
		if(!active)
			return;
		
		//Inventarlayout zeichen
		paintbrush.drawImage(Assets.inventory_default, 0, 0, 960 , 672, null );
		
		//Groesse des Inventars ermitteln
		int lengthItems = inventoryItems.size();
		int newselect = 0;
		
		//Falls Inventar leer
		if (lengthItems == 0)
			return;
		
		/*
		 * Falls Gegenstaende im Inventar groesser oder kleiner als die
		 * gegebene Inventarlaenge sind, ueberspringen
		 */
		for(int i =  0; i < 4; i++) {
			if(selectedItem + i < 0 || selectedItem + i >=lengthItems)
				continue;
		}
		
		//Iteration durch alle Gegenstaende
		for(int a = inventoryItems.size(); a > 0; a--) {
		
			Item item = inventoryItems.get(newselect);
			
			//Bild des Gegenstandes zeichen
			paintbrush.drawImage(item.getTexture(), Slot1 + (newselect*32) , attackSlotY , null);
			newselect = newselect +1;
			
			//Textbox des vorherigen angezeigten Gegenstandes leeren
			paintbrush.setColor(Color.decode("#0d3b1c"));
			paintbrush.fillRect(462, 544, 450, 80);
			
			//Textbox des aktuellen Gegenstandes zeichen
			if(wannaSee == false)
				continue;
			Text.drawString(paintbrush, inventoryItems.get(selectedItem).getName(), invMessageX,  invMessageLine1, false, Color.WHITE, Assets.starmapInv);
			Text.drawString(paintbrush, inventoryItems.get(selectedItem).getLine2(), invMessageX,  invMessageLine2, false, Color.LIGHT_GRAY, Assets.starmapInv);
			Text.drawString(paintbrush, inventoryItems.get(selectedItem).getLine3(), invMessageX,  invMessageLine3, false, Color.LIGHT_GRAY, Assets.starmapInv);
			Text.drawString(paintbrush, inventoryItems.get(selectedItem).getLine4(), invMessageX,  invMessageLine4, false, Color.LIGHT_GRAY, Assets.starmapInv);
		
		}
	}
	
	/**
	 * Hinzufuegen eines Gegenstandes zum Inventar.
	 * 
	 * @param item Gegenstand welcher hinzugefuegt werden soll
	 */
	public static void addItem(Item item) {
		for(Item i : inventoryItems) {
			if(i.getId() == item.getId()) {
				i.setCount(i.getCount() + item.getCount());
				return;
			}
		}
		inventoryItems.add(item);
	}
	
	/**
	 * Zurueckgabe des Handlers des Inventars.
	 * 
	 * @return Handler des Inventars
	 */
	public Handler getHandler() {
		return handler;
	}

	/**
	 * Festlegen des Handlers des Inventars.
	 * 
	 * @param handler Handler des Inventars
	 */
	public void setHandler(Handler handler) {
		this.handler = handler;
	}

	/**
	 * Zurueckgabe aller Gegenstaende in der Inventarliste.
	 * 
	 * @return Inventarliste
	 */
	public static ArrayList<Item> getInventoryItems() {
		return inventoryItems;
	}

	/**
	 * Zurueckgabe des ausgewaelten Gegenstandes.
	 * 
	 * @return ausgewaelter Gegenstand
	 */
	public static int getSelectedItem() {
		return selectedItem;
	}

	/**
	 * Festlegen des ausgewaelten Gegenstandes.
	 * 
	 * @param selectedItem Gegenstand welcher ausgewaelt werden soll
	 */
	public static void setSelectedItem(int selectedItem) {
		Inventory.selectedItem = selectedItem;
	}

	/**
	 * Zurueckgabe eines boolischen Wertes, ob die Textbox des Gegenstandes
	 * angezeigt werden soll.
	 * 
	 * @return Boolischer Wert, ob Textbox des Gegenstandes angezeigt werden soll
	 */
	public static boolean getWannaSee() {
		return wannaSee;
	}

	/**
	 * Festlegen eines boolischen Wertes, ob die Textbox des Gegenstandes
	 * angezeigt werden soll.
	 * 
	 * @param wannaSee Boolischer Wert, ob Textbox des Gegenstandes angezeigt werden soll
	 */
	public static void setWannaSee(boolean wannaSee) {
		Inventory.wannaSee = wannaSee;
	}
}
