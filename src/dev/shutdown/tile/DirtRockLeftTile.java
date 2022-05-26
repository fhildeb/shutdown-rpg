package dev.shutdown.tile;

import dev.shutdown.graphics.Assets;

/**
 * Diese Klasse dient zum Erstellen eines Hintergrundes "Gras"
 * in der Spielwelt.
 * 
 * @author Felix Hildebrandt
 *
 */
public class DirtRockLeftTile extends Tile {

	/**
	 * Es wird die Identifikationsnummer des Hintergrundes
	 * an die Oberklasse mit der dazugehoerigen
	 * Hintergrundgrafik uebergeben.
	 * 
	 * @param id Identifikationsnummer der Textur
	 */
	public DirtRockLeftTile(int id) {
		super(Assets.dirtRockLeft, id);
	}
	
	@Override
	public boolean isSolid(){
		return true;
	}
}