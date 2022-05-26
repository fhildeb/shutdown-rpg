package dev.shutdown.entities.statics;

import java.awt.Graphics;

import dev.shutdown.Handler;
import dev.shutdown.graphics.Assets;
import dev.shutdown.tile.Tile;

/**
 * Diese Klasse dient zum Erstellen eines statischen "langes Grass"-Objektes
 * fuer die Spielwelt.
 * 
 * @author Felix Hildebrandt
 *
 */
public class GrassLong extends StaticEntity {

	/**
	  * Es werden die Parameter der X- und Y-Position des Objektes auf der
	 * Spielwelt sowie der Handler des Objektes an die Oberklasse uebergeben
	 * und die individuelle Kollisionsbox fuer das "langes Grass"-Objekt gesetzt.
	 * 
	 * @param handler Handler des "langes Grass"-Objektes
	 * @param x Position auf der X-Achse in der Spielwelt in Pixel
	 * @param y Position auf der Y-Achse in der Spielwelt in Pixel
	 */
	public GrassLong(Handler handler, float x, float y) {
		super(handler, x, y, Tile.QUATER_WIDTH * 1, Tile.QUATER_HEIGHT * 2, 50000, 2, 50000, 5000);
		
		collisionBox.x = 0;
		collisionBox.y = 40;
		collisionBox.width = 32;
		collisionBox.height = 24;
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
		paintbrush.drawImage(Assets.grass_long, (int) (x - handler.getGameView().getxOffSet()), (int) (y - handler.getGameView().getyOffSet()), width, height, null);
	}
}
