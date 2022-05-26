package dev.shutdown.entities.statics;

import java.awt.Graphics;

import dev.shutdown.Handler;
import dev.shutdown.graphics.Assets;
import dev.shutdown.items.Item;
import dev.shutdown.items.ItemManager;
import dev.shutdown.maps.Maps;
import dev.shutdown.tile.Tile;

/**
 * Diese Klasse dient zum Erstellen eines statischen "silberne Flasche"-Objektes 
 * fuer die Spielwelt welches einen "Hand"-Gegenstand hinterlaesst.
 * 
 * @author Felix Hildebrandt
 *
 */
public class BottleSilver extends StaticEntity {

	/**
	 * Es werden die Parameter der X- und Y-Position des Objektes auf der
	 * Spielwelt sowie der Handler des Objektes an die Oberklasse uebergeben
	 * und die individuelle Kollisionsbox fuer das "silberne Flasche"-Objekt gesetzt.
	 * 
	 * @param handler Handler des "silberne Flasche"-Objektes
	 * @param x Position auf der X-Achse in der Spielwelt in Pixel
	 * @param y Position auf der Y-Achse in der Spielwelt in Pixel
	 */
	public BottleSilver(Handler handler, float x, float y) {
		super(handler, x, y, Tile.QUATER_WIDTH * 1, Tile.QUATER_HEIGHT * 1, 1, 50000, 50000, 5000);
		
		collisionBox.x = 0;
		collisionBox.y = 15;
		collisionBox.width = 32;
		collisionBox.height = 17;
	}


	@Override
	public void tick() {
		//Keine zu aktualisierenden Eigenschaften
	}

	@Override
	public void disappear() {
		handler.getMap();
		Maps.getItemManager();
		ItemManager.addItem(Item.attack_1_interact.createNew((int)x,(int) y));
	}
	
	@Override
	public void render(Graphics paintbrush) {
		paintbrush.drawImage(Assets.bottle_silver, (int) (x - handler.getGameView().getxOffSet()), (int) (y - handler.getGameView().getyOffSet()), width, height, null);
	}
}
