package dev.shutdown.ui;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import dev.shutdown.Handler;

/**
 * Diese Klasse realisiert den Manager der Benutzeroberflaeche
 * des Inventars ueber welchen alle Objekte organisiert werden.
 * 
 * @author Felix Hildebrandt
 */
public class InvUIManager {

	private Handler handler;
	private static ArrayList<InvUIObject> objects;
	
	/**
	 * Es wird der Handler des Managers uebergeben und 
	 * eine neue Liste mit allen Inventar-Objekten der Benutzeroberflaeche
	 * angelegt.
	 * 
	 * @param handler 	Handler des Managers der Inventar-Objekte
	 * 					der Benutzeroberflaeche
	 */
	public InvUIManager(Handler handler) {
		this.handler = handler;
		objects = new ArrayList<InvUIObject>();
	}
	
	/**
	 * Aktualisieren der Inventar-Objekte im Manager
	 * der Benutzeroberflaeche.
	 */
	public void tick() {
		for(InvUIObject o: objects)
			o.tick();
	}
	
	/**
	 * Zeichenen aller Objekte des Managers der Inventar-Objekte der
	 * Benutzeroberflaeche auf die Bildflaeche.
	 * 
	 * @param paintbrush Bildflaeche
	 */
	public void render(Graphics paintbrush) {
		for(InvUIObject o: objects)
			o.render(paintbrush);
	}
	
	/**
	 * Ereignis beim Bewegen des Mauszeigers
	 * auf das Inventar-Objekt.
	 * 
	 * @param e Maus-Event
	 */
	public void onMouseMove(MouseEvent e) {
		try {
		for(InvUIObject o: objects)
			o.onMouseMove(e);
		}
		catch(Exception ex) {
			
		}
	}
	
	/**
	 * Ereignis beim Loslassen der Maustaste ueber
	 * dem Inventar-Objekt.
	 * 
	 * @param e Maus-Event
	 */
	public void onMouseRelease(MouseEvent e) {
		for(InvUIObject o: objects)
			o.onMouseRelease(e);
	}
	
	/**
	 * Hinzufuegen eines neuen Inventar-Objektes zum Manager der Objekte
	 * der Benutzeroberflaeche.
	 * 
	 * @param o Inventarobjekt welches zum Manager der Inventar-Objekte
	 * 			der Benutzeroberflaeche hinzugefuegt werden soll
	 */
	public void addInvObject(InvUIObject o) {
		objects.add(o);
	}
	
	/**
	 * Entfernen eines Inventar-Objektes aus dem Manager der Objekte der
	 * Benutzeroberflaeche.
	 * 
	 * @param o Inventarobjekt welches aus dem Manager der Inventar-Objekte
	 * 			der Benutzeroberflaeche entfernt werden soll
	 */
	public void removeObject(InvUIObject o) {
		objects.remove(o);
	}

	/**
	 * Zurueckgabe des Handlers des Managers der Inventar-Objekte der
	 * Benutzeroberflaeche.
	 * 
	 * @return Handler des Managers
	 */
	public Handler getHandler() {
		return handler;
	}

	/**
	 * Festlegen des Handlers des Managers der Inventar-Objekte
	 * der Benutzeroberflaeche.
	 * 
	 * @param handler 	Handler des Managers der Inventar-Objekte
	 * 					der Benutzeroberflaeche
	 */
	public void setHandler(Handler handler) {
		this.handler = handler;
	}

	/**
	 * Zurueckgabe der Liste mit allen Inventar-Objekte des Managers der Objekte
	 * der Benutzeroberflaeche.
	 * 
	 * @return 	Liste mit allen Inventar-Objekten des Managers der Objekte
	 * 			der Benutzeroberflaeche
	 */
	public static ArrayList<InvUIObject> getObjects() {
		return objects;
	}

	/**
	 * Festlegen von neuen Inventar-Objekten der Liste des Managers der Objekte
	 * der Benutzeroberflaeche.
	 * 
	 * @param objects Inventarobjekt
	 */
	public void setObjects(ArrayList<InvUIObject> objects) {
		InvUIManager.objects = objects;
	}
}
