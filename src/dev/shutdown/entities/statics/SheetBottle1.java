package dev.shutdown.entities.statics;

import java.awt.Graphics;

import dev.shutdown.Handler;
import dev.shutdown.graphics.Assets;
import dev.shutdown.items.Sheet;
import dev.shutdown.maps.Maps;
import dev.shutdown.tile.Tile;

/**
 * Diese Klasse dient zum Erstellen eines statischen "Nachrichtentopf 1"-Objektes
 * fuer die Spielwelt welches den "Nachricht 1"-Gegenstand hinterlaesst.
 * 
 * @author Felix Hildebrandt
 *
 */
public class SheetBottle1 extends StaticEntity {

	/**
	  * Es werden die Parameter der X- und Y-Position des Objektes auf der
	 * Spielwelt sowie der Handler des Objektes an die Oberklasse uebergeben
	 * und die individuelle Kollisionsbox fuer das "Nachrichtentopf 1"-Objekt gesetzt.
	 * 
	 * @param handler Handler des "Nachrichtentopf 1"-Objektes
	 * @param x Position auf der X-Achse in der Spielwelt in Pixel
	 * @param y Position auf der Y-Achse in der Spielwelt in Pixel
	 */
	public SheetBottle1(Handler handler, float x, float y) {
		super(handler, x, y, Tile.QUATER_WIDTH * 1, Tile.QUATER_HEIGHT * 1, 2, 50000, 50000, 5000);
		
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
			Maps.getSheetManager().addSheet(Sheet.paperSheet1.createNew((int)x,(int) y));
	}
	
	@Override
	public void render(Graphics paintbrush) {
		paintbrush.drawImage(Assets.bottle_gold, (int) (x - handler.getGameView().getxOffSet()), (int) (y - handler.getGameView().getyOffSet()), width, height, null);
	}
}
