package dev.shutdown.items;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;

import dev.shutdown.Handler;

/**
 * Diese Klasse realisiert den Manager fuer die Nachrichten
 * ueber welchen welchen diese zentral organisiert und angesprochen werden
 * koennen.
 * 
 * @author Felix Hildebrandt
 *
 */
public class SheetManager {

	private Handler handler;
	private ArrayList<Sheet> sheets;
	
	/**
	 * Es wird der Handler fuer den Nachrichten-Manager
	 * gesetzt und eine neue Nachrichtenliste angelegt.
	 * 
	 * @param handler Handler des Spiels
	 */
	public SheetManager(Handler handler) {
		this.handler = handler;
		sheets = new ArrayList<Sheet>();
	}
	
	/**
	 * Aktualisieren der Nachrichten mit Hilfe
	 * eines Iterators.
	 */
	public void tick() {
		Iterator<Sheet> iter = sheets.iterator();
		while(iter.hasNext()) {
			Sheet s = iter.next();
					s.tick();
			if(s.isPickedUp())
				iter.remove();
		}
	}
	
	/**
	 * Zeichen aller Nachrichten im Manager auf die Bildflaeche.
	 * 
	 * @param paintbrush Bildflaeche
	 */
	public void render(Graphics paintbrush) {
		for(Sheet s : sheets)
			s.render(paintbrush);
	}
	
	/**
	 * Hinzufuegen von neuen Nachrichten zum Nachrichten-Manager.
	 * 
	 * @param s Nachricht welche hinzugefuegt werden soll
	 */
	public void addSheet(Sheet s) {
		s.setHandler(handler);
		sheets.add(s);
	}

	/**
	 * Zurueckgabe des Handlers des Nachrichten-Managers.
	 * 
	 * @return Handler des  Nachrichten-Managers
	 */
	public Handler getHandler() {
		return handler;
	}

	/**
	 * Setzen des Handlers des Nachrichten-Managers
	 * 
	 * @param handler Handler des Nachrichten-Managers
	 */
	public void setHandler(Handler handler) {
		this.handler = handler;
	}
}
