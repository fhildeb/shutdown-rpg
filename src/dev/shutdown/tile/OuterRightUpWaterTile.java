package dev.shutdown.tile;

import dev.shutdown.graphics.Assets;

/**
 * Diese Klasse dient zum Erstellen des Hintergrundes "Wasser" (Rechts-Oben)
 * in der Spielwelt.
 * 
 * @author Felix Hildebrandt
 *
 */
public class OuterRightUpWaterTile extends Tile {

	/**
	 * Es wird die Identifikationsnummer des Hintergrundes
	 * an die Oberklasse mit der dazugehoerigen
	 * Hintergrundgrafik uebergeben.
	 * 
	 * @param id Identifikationsnummer der Textur
	 */
	public OuterRightUpWaterTile(int id) {
		super(Assets.OuterRightUpWaterTile, id);
	}
	
	@Override
	public boolean isSolid(){
		return true;
	}

}