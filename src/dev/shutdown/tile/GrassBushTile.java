package dev.shutdown.tile;

import dev.shutdown.graphics.Assets;

/**
 * Diese Klasse dient zum Erstellen des Hintergrundes "Wiese"
 * in der Spielwelt.
 * 
 * @author Felix Hildebrandt
 *
 */
public class GrassBushTile extends Tile {

	/**
	 * Es wird die Identifikationsnummer des Hintergrundes
	 * an die Oberklasse mit der dazugehoerigen
	 * Hintergrundgrafik uebergeben.
	 * 
	 * @param id Identifikationsnummer der Textur
	 */
	public GrassBushTile(int id) {
		super(Assets.grassBushTile, id);
	}
	
	@Override
	public boolean isSolid(){
		return false;
	}

}