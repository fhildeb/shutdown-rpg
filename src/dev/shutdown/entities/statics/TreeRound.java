package dev.shutdown.entities.statics;

import java.awt.Graphics;

import dev.shutdown.Handler;
import dev.shutdown.graphics.Assets;
import dev.shutdown.tile.Tile;

/**
 * Diese Klasse dient zum Erstellen eines statisches "runder Baum"-Objekt
 * fuer die Spielwelt.
 * 
 * @author Felix Hildebrandt
 *
 */
public class TreeRound extends StaticEntity {

	/**
	  * Es werden die Parameter der X- und Y-Position des Objektes auf der
	 * Spielwelt sowie der Handler des Objektes an die Oberklasse uebergeben
	 * und die individuelle Kollisionsbox fuer das "runder Baum"-Objekt gesetzt.
	 * 
	 * @param handler Handler des "runden Baum"-Objektes
	 * @param x Position auf der X-Achse in der Spielwelt in Pixel
	 * @param y Position auf der Y-Achse in der Spielwelt in Pixel
	 */
	public TreeRound(Handler handler, float x, float y) {
		super(handler, x, y, Tile.QUATER_WIDTH * 4, Tile.QUATER_HEIGHT * 4, 50000, 50000, 50000, 5000);
		
		collisionBox.x = 20;
		collisionBox.y = 60;
		collisionBox.width = 88;
		collisionBox.height = 58;
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
		paintbrush.drawImage(Assets.tree_round, (int) (x - handler.getGameView().getxOffSet()), (int) (y - handler.getGameView().getyOffSet()), width, height, null);
	}
}
