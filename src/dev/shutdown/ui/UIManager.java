package dev.shutdown.ui;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import dev.shutdown.Handler;

/**
 * Diese Klasse realisiert den Manager der Benutzeroberflaeche
 * des Menues ueber welchen alle Objekte organisiert werden.
 * 
 * @author Felix Hildebrandt
 */
public class UIManager {

	private Handler handler;
	private ArrayList<UIObject> objects;
	
	/**
	 * Es wird dem Manager ein Handler zugewiesen und
	 * eine neue Liste mit allen Menue-Objekten der Benutzeroberflaeche
	 * angelegt.
	 * 
	 * @param handler Handler des Managers der
	 * Menue-Objekte der Benutzeroberflaeche
	 */
	public UIManager(Handler handler) {
		this.handler = handler;
		objects = new ArrayList<UIObject>();
	}
	
	/**
	 * Aktualisieren der Objekte im Manager der
	 * Menue-Objekte der Benutzeroberflaeche.
	 */
	public void tick() {
		for(UIObject uio : objects) {
			uio.tick();
		}
	}
	
	/**
	 * Zeichenen der Menue-Objekte im Manager der
	 * Objekte der Benutzeroberflaeche
	 * auf die Bildflaeche.
	 * 
	 * @param paintbrush Bildflaeche
	 */
	public void render(Graphics paintbrush) {
		for(UIObject uio : objects) {
			uio.render(paintbrush);
		}
	}
	
	/**
	 * Ereignis beim Bewegen des Mauszeigers
	 * auf dem Menue-Objekt.
	 * 
	 * @param e Maus-Event
	 */
	public void onMouseMove(MouseEvent e) {
		try {
		for(UIObject uio : objects) {
			uio.onMouseMove(e);
		}
		}
		catch(Exception ex){}
	}
	
	/**
	 * Ereignis beim Loslassen der Maustaste ueber
	 * dem Menue-Objekt.
	 * 
	 * @param e Maus-Event
	 */
	public void onMouseRelease(MouseEvent e) {
		for(UIObject uio : objects) {
			uio.onMouseRelease(e);
		}
	}
	
	/**
	 * Hinzufuegen eines neuen Menue-Objektes zum Manager der
	 * Objekte der Benutzeroberflaeche.
	 * 
	 * @param uio Menue-Objekt welches zum Manager der
	 * Objekte der Benutzeroberflaeche
	 */
	public void addObject(UIObject uio) {
		objects.add(uio);
	}
	
	/**
	 * Entfernen eines Menue-Objektes aus dem Manager der
	 * Menue-Objekte der Benutzeroberflaeche.
	 * 
	 * @param uio Menue-Objekt welches aus dem Manager der
	 * Menue-Objekte der Benutzeroberflaeche entfernt werden soll
	 */
	public void removeObject(UIObject uio) {
		objects.remove(uio);
	}
	
	/**
	 * Zurueckgabe des Handlers des Managers der
	 * Menue-Objekte der Benutzeroberflaeche.
	 * 
	 * @return  Handler des Managers der
	 * 			Menue-Objekte der Benutzeroberflaeche
	 */
	public Handler getHandler() {
		return handler;
	}

	/**
	 * Festlegen des Handlers Managers der
	 * Menue-Objekte der Benutzeroberflaeche.
	 * 
	 * @param 	handler Handler des Managers der
	 * 			Menue-Objekte der Benutzeroberflaeche
	 */
	public void setHandler(Handler handler) {
		this.handler = handler;
	}

	/**
	 * Zurueckgabe der Liste mit allen Menue-Objekten des Managers der
	 * Menue-Objekte der Benutzeroberflaeche.
	 * 
	 * @return 	Liste mit allen Menue-Objekten des Managers der
	 * 			Menue-Objekte der Benutzeroberflaeche
	 */
	public ArrayList<UIObject> getObjects() {
		return objects;
	}

	/**
	 * Festlegen der Menue-Objekten der Liste des Managers der
	 * Menue-Objekte der Benutzeroberflaeche.
	 * 
	 * @param objects Menueobjekt
	 */
	public void setObjects(ArrayList<UIObject> objects) {
		this.objects = objects;
	}
}
