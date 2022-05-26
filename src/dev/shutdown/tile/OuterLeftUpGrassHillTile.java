package dev.shutdown.tile;

import dev.shutdown.graphics.Assets;

/**
 * Diese Klasse dient zum Erstellen des Hintergrundes "bewachsener Berg" (Links-Oben)
 * in der Spielwelt.
 * 
 * @author Felix Hildebrandt
 *
 */
public class OuterLeftUpGrassHillTile extends Tile {

	/**
	 * Es wird die Identifikationsnummer des Hintergrundes
	 * an die Oberklasse mit der dazugehoerigen
	 * Hintergrundgrafik uebergeben.
	 * 
	 * @param id Identifikationsnummer der Textur
	 */
	public OuterLeftUpGrassHillTile(int id) {
		super(Assets.OuterLeftUpGrassHillTile, id);
	}

	@Override
	public boolean isSolid(){
		return true;
	}

}