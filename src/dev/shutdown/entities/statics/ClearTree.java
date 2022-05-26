package dev.shutdown.entities.statics;

import java.awt.Graphics;

import dev.shutdown.Handler;
import dev.shutdown.graphics.Assets;
import dev.shutdown.tile.Tile;

/**
 * Diese Klasse dient zum Erstellen eines statischen "lichter Baum"-Objektes
 * fuer die Spielwelt.
 * 
 * @author Felix Hildebrandt
 *
 */
public class ClearTree extends StaticEntity {

	/**
	  * Es werden die Parameter der X- und Y-Position des Objektes auf der
	 * Spielwelt sowie der Handler des Objektes an die Oberklasse uebergeben
	 * und die individuelle Kollisionsbox fuer das "lichter Baum"-Objekt gesetzt.
	 * 
	 * @param handler Handler des "lichter Baum"-Objektes
	 * @param x Position auf der X-Achse in der Spielwelt in Pixel
	 * @param y Position auf der Y-Achse in der Spielwelt in Pixel
	 */
	public ClearTree(Handler handler, float x, float y) {
		super(handler, x, y, Tile.TILE_WIDTH * 2, Tile.TILE_HEIGHT * 2, 50000, 50000, 50000, 50000);
		
		collisionBox.x = 20;
		collisionBox.y = 60;
		collisionBox.width = 87;
		collisionBox.height = 60;
		
	}

	@Override
	public void tick() {
		//Keine zu aktualisierenden Eigenschaften
	}
	
	@Override
	public void disappear(){
		//Keine besonderen Aktionen beim Zerstoeren
	}

	@Override
	public void render(Graphics paintbrush) {
		paintbrush.drawImage(Assets.clear_tree, (int) (x - handler.getGameView().getxOffSet()), (int) (y - handler.getGameView().getyOffSet()), width, height, null);
		
	}

}
