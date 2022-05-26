package dev.shutdown.tile;

import dev.shutdown.graphics.Assets;

/**
 * Diese Klasse dient zum Erstellen des Hintergrundes "Wasser" (Links-Mitte)
 * in der Spielwelt.
 * 
 * @author Felix Hildebrandt
 *
 */
public class OuterLeftMidWaterTile extends Tile {

	/**
	 * Es wird die Identifikationsnummer des Hintergrundes
	 * an die Oberklasse mit der dazugehoerigen
	 * Hintergrundgrafik uebergeben.
	 * 
	 * @param id Identifikationsnummer der Textur
	 */
	public OuterLeftMidWaterTile(int id) {
		super(Assets.OuterLeftMidWaterTile, id);
	}

	@Override
	public boolean isSolid(){
		return true;
	}

}