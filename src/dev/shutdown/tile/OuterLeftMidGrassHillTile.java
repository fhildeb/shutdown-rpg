package dev.shutdown.tile;

import dev.shutdown.graphics.Assets;

/**
 * Diese Klasse dient zum Erstellen des Hintergrundes "bewachsener Berg" (Links-Mitte)
 * in der Spielwelt.
 * 
 * @author Felix Hildebrandt
 *
 */
public class OuterLeftMidGrassHillTile extends Tile {

	/**
	 * Es wird die Identifikationsnummer des Hintergrundes
	 * an die Oberklasse mit der dazugehoerigen
	 * Hintergrundgrafik uebergeben.
	 * 
	 * @param id Identifikationsnummer der Textur
	 */
	public OuterLeftMidGrassHillTile(int id) {
		super(Assets.OuterLeftMidGrassHillTile, id);
	}

	@Override
	public boolean isSolid(){
		return true;
	}

}