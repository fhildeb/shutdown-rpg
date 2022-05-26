package dev.shutdown.items;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;

import dev.shutdown.Handler;

/**
 * Diese Klasse realisiert den Manager fuer die Gegenstaende
 * ueber welchen diese zentral organisiert und angesprochen werden
 * koennen.
 * 
 * @author Felix Hildebrandt
 *
 */
public class ItemManager {

	private static Handler handler;
	private static ArrayList<Item> items;
	
	/**
	 * Es wird dem Gegenstand-Manager ein
	 * neuer Handler zugewiesen und eine
	 * neue Gegenstandsliste erstellt.
	 * 
	 * @param handler Handler des Spiels
	 */
	public ItemManager(Handler handler) {
		ItemManager.handler = handler;
		items = new ArrayList<Item>();
	}
	
	/**
	 * Aktualisieren der Gegenstaende mit Hilfe eines
	 * Iterators.
	 */
	public void tick() {
		Iterator<Item> iter = items.iterator();
		while(iter.hasNext()) {
			Item i = iter.next();
			i.tick();
			if(i.isPickedUp())
				iter.remove();
		}
	}
	
	/**
	 * Zeichnen aller Gegenstaende im
	 * Gegenstand-Manager auf die Bildflaeche.
	 * 
	 * @param paintbrush Bildflaeche
	 */
	public void render(Graphics paintbrush) {
		for(Item i: items)
			i.render(paintbrush);
	}
	
	/**
	 * Hinzufuegen eines neuen Gegenstandes zum Gegenstand-Manager.
	 * 
	 * @param i Gegenstand welcher zum Gegenstand-Manager hinzugefuegt werden soll
	 */
	public static void addItem(Item i) {
		i.setHandler(handler);
		items.add(i);
	}

	
	/**
	 * Zurueckgabe des Handlers des Gegenstand-Managers.
	 * 
	 * @return Handler des Gegenstand-Managers
	 */
	public Handler getHandler() {
		return handler;
	}

	/**
	 * Setzen des Handlers des Gegenstand-Managers.
	 * 
	 * @param handler Handler des Gegenstand-Managers
	 */
	public void setHandler(Handler handler) {
		ItemManager.handler = handler;
	}

	/**
	 * Zuruegabe der Gegenstaende im Gegenstand-Manager.
	 * 
	 * @return Gegenstaende im Gegenstand-Manager
	 */
	public static ArrayList<Item> getItems() {
		return items;
	}

	/**
	 * Festlegen der Gegenstaende im Gegenstand-Manager.
	 * 
	 * @param items Gegenstaendsliste im Gegenstand-Manager.
	 */
	public void setItems(ArrayList<Item> items) {
		ItemManager.items = items;
	}
}
