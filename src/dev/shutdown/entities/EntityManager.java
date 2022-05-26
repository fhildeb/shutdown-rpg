package dev.shutdown.entities;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

import dev.shutdown.Handler;
import dev.shutdown.entities.creatures.Player;

/**
 * Diese Klasse definiert den Manager der Objekte in der Spielwelt, mit
 * welchem sich alle Objekte gemeinsam organisieren lassen.
 * 
 * @author Felix Hildebrandt
 *
 */
public class EntityManager {

	//Klasse
	private Handler handler;
	private Player player;
	private static ArrayList<Entity> entities;
	
	//Ordnung in welcher das Objekt auf die Bildflaeche gezeichnet wird
	private Comparator<Entity> renderOrder = new Comparator<Entity>() {

		@Override
		public int compare(Entity one, Entity two) {
			if(one.getY() + one.getHeight() < two.getY() + two.getHeight()) {
				return -1;
			}
			return 1;
		}
	};
	
	/**
	 * Es werden die Parameter Handler und Spieler zugewiesen, 
	 * eine neue Liste fuer die in der Spielwelt vorkommenden Objekte erstellt 
	 * sowie die Spielfigur an erster Position der Liste aufgenommen.
	 * 
	 * @param handler Handler des Objekt-Managers
	 * @param player Zum Objekt-Manager zugehoerige Spielfigur
	 */
	public EntityManager(Handler handler, Player player) {
		this.handler = handler;
		this.player = player;
		entities = new ArrayList<Entity>();
		addEntity(player);
	}
	
	/**
	 * Aktualisieren der aktiven Objekte im Manager 
	 * mit Hilfe eines Iterators und Anpassen der Reihenfolge
	 * in welcher die Objekte in die Spielwelt gezeichnet werden.
	 */
	public void tick() {
		Iterator<Entity> iter = entities.iterator();
		while(iter.hasNext()) {
			Entity e = iter.next();
			e.tick();
			//Wenn Objekt nicht mehr laenger aktiv ist
			if(!e.isActive())
				iter.remove();
		}
		//Reihenfolge waerend des Rendervorganges anpassen
		entities.sort(renderOrder);
	}

	/**
	 * Zeichnen der aktuellen Objekte innerhalb des Objekt-Managers in die
	 * Spielwelt innerhalb der Bildflaeche.
	 * 
	 * @param paintbrush Bildflaeche
	 */
	public void render(Graphics paintbrush) {
		for(Entity e : entities) {
			e.render(paintbrush);
		}
		player.postRender(paintbrush);
	}

	/**
	 * Aufnehmen eines Objektes in den Objekt-Manager.
	 * 
	 * @param e Objekt
	 */
	public static void addEntity(Entity e) {
		entities.add(e);
	}
	
	/**
	 * Zurueckgabe des Handlers des Objekt-Managers.
	 * 
	 * @return Handler des Objekt-Managers
	 */
	public Handler getHandler() {
		return handler;
	}

	/**
	 * Festlegen des Handlers des Objekt-Managers.
	 * 
	 * @param handler Handler des Objekt-Managers
	 */
	public void setHandler(Handler handler) {
		this.handler = handler;
	}

	/**
	 * Zurueckgabe des Spielers des Objekt-Managers.
	 * 
	 * @return Spieler
	 */
	public Player getPlayer() {
		return player;
	}

	/**
	 * Festlegen des Spielers des Objekt-Managers.
	 * 
	 * @param player Spieler des Objekt-Managers
	 */
	public void setPlayer(Player player) {
		this.player = player;
	}

	/**
	 * Zurueckgabe aller Objekte des Objekt-Managers.
	 * 
	 * @return Liste mit allen Objekten des Objekt-Managers
	 */
	public static ArrayList<Entity> getEntities() {
		return entities;
	}

	/**
	 * Festlegen der Objekte des Objekt-Managers.
	 * 
	 * @param entities Liste mit Objekten des Objekt-Managers
	 */
	public void setEntities(ArrayList<Entity> entities) {
		EntityManager.entities = entities;
	}
}
