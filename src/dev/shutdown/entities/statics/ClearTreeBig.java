package dev.shutdown.entities.statics;

import java.awt.Graphics;

import dev.shutdown.Handler;
import dev.shutdown.graphics.Assets;
import dev.shutdown.tile.Tile;

/**
 * Diese Klasse dient zum Erstellen eines statischen "grosser lichter Baum"-Objektes
 * fuer die Spielwelt.
 * 
 * @author Felix Hildebrandt
 *
 */
public class ClearTreeBig extends StaticEntity {

	/**
	 * Es werden die Parameter der X- und Y-Position des Objektes auf der
	 * Spielwelt sowie der Handler des Objektes an die Oberklasse uebergeben
	 * und die individuelle Kollisionsbox fuer das "grosser lichter Baum"-Objekt gesetzt.
	 * 
	 * @param handler Handler des "grosser lichter Baum"-Objektes
	 * @param x Position auf der X-Achse in der Spielwelt in Pixel
	 * @param y Position auf der Y-Achse in der Spielwelt in Pixel
	 */
	public ClearTreeBig(Handler handler, float x, float y) {
		super(handler, x, y, Tile.QUATER_WIDTH * 4, Tile.QUATER_HEIGHT * 4, 50000, 50000, 50000, 5000);
		
		collisionBox.x = 28;
		collisionBox.y = 80;
		collisionBox.width = 72;
		collisionBox.height = 46;
	}

	@Override
	public void tick() {
		//Keine zu aktualisierenden Eigenschaften
	}

	@Override
	public void disappear() {
		//Keine besonderen Aktionen beim Zerstoeren
	}
	
	@Override
	public void render(Graphics paintbrush) {
		paintbrush.drawImage(Assets.clear_tree_big, (int) (x - handler.getGameView().getxOffSet()), (int) (y - handler.getGameView().getyOffSet()), width, height, null);
	}
}
