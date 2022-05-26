package dev.shutdown.entities.statics;

import java.awt.Graphics;

import dev.shutdown.Handler;
import dev.shutdown.graphics.Assets;
import dev.shutdown.tile.Tile;

/**
 * Diese Klasse dient zum Erstellen eines statischen 
 * "Barriere"-Objektes fuer die Spielwelt.
 * 
 * @author Felix Hildebrandt
 *
 */
public class Barrier extends StaticEntity {

	/**
	 * Es werden die Parameter der X- und Y-Position des Objektes auf der
	 * Spielwelt sowie der Handler des Objektes an die Oberklasse uebergeben
	 * und die individuelle Kollisionsbox fuer das "Barriere"-Objekt gesetzt.
	 * 
	 * @param handler Handler des "Barriere"-Objektes
	 * @param x Position auf der X-Achse in der Spielwelt in Pixel
	 * @param y Position auf der Y-Achse in der Spielwelt in Pixel
	 */
	public Barrier(Handler handler, float x, float y) {
		super(handler, x, y, Tile.QUATER_WIDTH * 2, Tile.QUATER_HEIGHT * 2, 50000, 50000, 50000, 50000);
		
		collisionBox.x = 0;
		collisionBox.y = 30;
		collisionBox.width = 64;
		collisionBox.height = 34;
	}

	@Override
	public void tick() {
		//Keine zu aktualisierenden Eigenschaften
	}

	@Override
	public void disappear() {
		//Keine besondere Aktion beim Zerstoeren ausfueren
	}
	
	@Override
	public void render(Graphics paintbrush) {
		paintbrush.drawImage(Assets.barrier, (int) (x - handler.getGameView().getxOffSet()), (int) (y - handler.getGameView().getyOffSet()), width, height, null);
	}
}
