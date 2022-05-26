package dev.shutdown.tile;

import dev.shutdown.graphics.Assets;

/**
 * Diese Klasse dient zum Erstellen des Hintergrundes "bewachsener Berg" (Oben-Mitte)
 * in der Spielwelt.
 * 
 * @author Felix Hildebrandt
 *
 */
public class OuterUpMidGrassHillTile extends Tile {

	/**
	 * Es wird die Identifikationsnummer des Hintergrundes
	 * an die Oberklasse mit der dazugehoerigen
	 * Hintergrundgrafik uebergeben.
	 * 
	 * @param id Identifikationsnummer der Textur
	 */
	public OuterUpMidGrassHillTile(int id) {
		super(Assets.OuterUpMidGrassHillTile, id);
	}

	@Override
	public boolean isSolid(){
		return true;
	}

}