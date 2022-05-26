package dev.shutdown.tile;

import dev.shutdown.graphics.Assets;

/**
 * Diese Klasse dient zum Erstellen des Hintergrundes "Stein"
 * in der Spielwelt.
 * 
 * @author Felix Hildebrandt
 *
 */
public class RockTile extends Tile {

	/**
	 * Es wird die Identifikationsnummer des Hintergrundes
	 * an die Oberklasse mit der dazugehoerigen
	 * Hintergrundgrafik uebergeben.
	 * 
	 * @param id Identifikationsnummer der Textur
	 */
	public RockTile(int id) {
		super(Assets.rockTile, id);
	}
	
	@Override
	public boolean isSolid(){
		return true;
	}

}
