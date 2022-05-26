package dev.shutdown.tile;

import dev.shutdown.graphics.Assets;

/**
 * Diese Klasse dient zum Erstellen eines Hintergrundes "Gras"
 * in der Spielwelt.
 * 
 * @author Felix Hildebrandt
 *
 */
public class DirtRockMidTile extends Tile {

	/**
	 * Es wird die Identifikationsnummer des Hintergrundes
	 * an die Oberklasse mit der dazugehoerigen
	 * Hintergrundgrafik uebergeben.
	 * 
	 * @param id Identifikationsnummer der Textur
	 */
	public DirtRockMidTile(int id) {
		super(Assets.dirtRockMid, id);
	}
	
	@Override
	public boolean isSolid(){
		return true;
	}
}