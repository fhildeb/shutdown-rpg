package dev.shutdown.entities.statics;

import java.awt.Graphics;

import dev.shutdown.Handler;
import dev.shutdown.graphics.Assets;
import dev.shutdown.tile.Tile;

/**
 * Diese Klasse dient zum Erstellen eines statischen "kleines rotes Haus"-Objektes
 * fuer die Spielwelt.
 * 
 * @author Felix Hildebrandt
 *
 */
public class HouseSmallRed extends StaticEntity {

	/**
	  * Es werden die Parameter der X- und Y-Position des Objektes auf der
	 * Spielwelt sowie der Handler des Objektes an die Oberklasse uebergeben
	 * und die individuelle Kollisionsbox fuer das "kleines rotes Haus"-Objekt gesetzt.
	 * 
	 * @param handler Handler des "kleines rotes Haus"-Objekt
	 * @param x Position auf der X-Achse in der Spielwelt in Pixel
	 * @param y Position auf der Y-Achse in der Spielwelt in Pixel
	 */
	public HouseSmallRed(Handler handler, float x, float y) {
		super(handler, x, y, Tile.QUATER_WIDTH * 6, Tile.QUATER_HEIGHT * 8, 50000, 50000, 50000, 5000);
		
		collisionBox.x = 0;
		collisionBox.y = 90;
		collisionBox.width = 150;
		collisionBox.height = 140;
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
		paintbrush.drawImage(Assets.house_small_red, (int) (x - handler.getGameView().getxOffSet()), (int) (y - handler.getGameView().getyOffSet()), width, height, null);
	}
}
