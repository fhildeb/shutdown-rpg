package dev.shutdown.graphics;

import dev.shutdown.Handler;
import dev.shutdown.entities.Entity;
import dev.shutdown.tile.Tile;

/**
 * Diese Klasse dient zum Erstellen eines Spielausschnittes fuer die Karte
 * auf dem Spiel-Bildschirm, welche nur den fuer den Spieler einsehbaren
 * Bereich der Karte rendert und auf die Bildflaeche zeichnet. Der Spielausschnitt
 * folgt dem Spieler dynamisch sobald dieser sich bewegt.
 * 
 * @author Felix Hildebrandt
 *
 */
public class GameView {

	private float xOffSet, yOffSet;
	private Handler handler;
	
	/**
	 * Es wird der Handler des Spiels sowie die Verschiebung der
	 * X- und Y-Achse des anzuzeigenden Kartenauschnitts im
	 * Bezug auf die Spielwelt uebergeben.
	 * 
	 * @param handler 	Handler des Spiels
	 * @param xOffSet 	Verschiebung des anzuzeigenen Spielausschittes auf der X-Achse
	 * 					im Bezug auf die Spielwelt
	 * @param yOffSet 	Verschiebung des anzuzeigenen Spielausschittes auf der Y-Achse
	 * 					im Bezug auf die Spielwelt
	 */
	public GameView(Handler handler, float xOffSet, float yOffSet) {
		this.xOffSet = xOffSet;
		this.yOffSet = yOffSet;
		this.handler= handler;
	}
	
	/**
	 * Pausieren des dynamischen Folgens des Spielausschnittes sobald der Spieler
	 * einen gewissen Abstand zum Rand der Karte ueberschritten
	 * hat, sodass keine leeren Zwischenraeume angezeigt und sich der Spieler
	 * nicht ueber die Spielwelt hinausbewegen kann.
	 */
	public void outOfMap() {
		
		//Falls linker Kartenrand erreicht
		if(xOffSet < 0) {
			xOffSet = 0;
		}
		
		//Falls rechter Kartenrand erreicht
		else if(xOffSet > handler.getMap().getWidth() * Tile.TILE_WIDTH - handler.getWidth() + 96) {
			xOffSet =handler.getMap().getWidth() * Tile.TILE_WIDTH - handler.getWidth() + 96;
		}
		
		//Falls oberer Kartenrand erreicht
		if(yOffSet < 0) {
			yOffSet = 0;
		}
		
		//Falls unterer Kartenrand erreicht
		else if(yOffSet > handler.getMap().getHeight() * Tile.TILE_HEIGHT - handler.getHeight() + 224-64*3) {
			yOffSet = handler.getMap().getHeight() * Tile.TILE_HEIGHT - handler.getHeight() + 224-64*3;
		}
	}
	
	/**
	 * Zentrieren der Spielfeldansicht auf 
	 * die aktuelle Position des Spielers.
	 * 
	 * @param entity Spieler
	 */
	public void centerOnEntity(Entity entity) {
		xOffSet = entity.getX() - handler.getWidth() / 2 + entity.getWidth() / 2;
		yOffSet = entity.getY() - handler.getHeight() / 2 + entity.getHeight() / 2 + 64;
		outOfMap();
	}

	/**
	 * Anpassen des Spielausschnitts, sobald sich
	 * der Spieler bewegt.
	 * 
	 * @param xAmmount Veraenderung der Spielerposition bezueglich der X-Achse in Pixel
	 * @param yAmmount Veraenderung der Spielerposition bezueglich der Y-Achse in Pixel
	 */
	public void move(float xAmmount, float yAmmount) {
		xOffSet += xAmmount;
		yOffSet += yAmmount;
		outOfMap();
	}
	
	/**
	 * Zurueckgabe des Wertes, um wie viel Pixel die Objekte in der Kamera
	 * auf der horizontalen Achse verschoben wurden.
	 * 
	 * @return xOffSet Verschiebung auf der X-Achse in Pixel
	 */
	public float getxOffSet() {
		return xOffSet;
	}

	/**
	 * Festlegen des Wertes, um wie viel Pixel die Objekte in der Kamera
	 * auf der horizontalen Achse verschoben werden.
	 * 
	 * @param xOffSet Verschiebung auf der X-Achse in Pixel
	 */
	public void setxOffSet(float xOffSet) {
		this.xOffSet = xOffSet;
	}

	/**
	 * Zurueckgabe des Wertes, um wie viel Pixel die Objekte in der Kamera
	 * auf der vertikalen Achse verschoben wurden.
	 * 
	 * @return yOffSet Verschiebung auf der Y-Achse in Pixel
	 */
	public float getyOffSet() {
		return yOffSet;
	}
	
	/**
	 * Festlegen des Wertes, um wie viel Pixel die Objekte in der Kamera
	 * auf der vertikalen Achse verschoben werden.
	 * 
	 * @param yOffSet Verschiebung auf der Y-Achse in Pixel
	 */
	public void setyOffSet(float yOffSet) {
		this.yOffSet = yOffSet;
	}
}
