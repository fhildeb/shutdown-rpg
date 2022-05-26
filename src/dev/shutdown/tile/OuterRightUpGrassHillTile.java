package dev.shutdown.tile;

import dev.shutdown.graphics.Assets;

/**
 * Diese Klasse dient zum Erstellen des Hintergrundes "bewachsener Berg" (Rechts-Oben)
 * in der Spielwelt. 
 * 
 * @author Felix Hildebrandt
 *
 */
public class OuterRightUpGrassHillTile extends Tile {

	/**
	 * Es wird die Identifikationsnummer des Hintergrundes
	 * an die Oberklasse mit der dazugehoerigen
	 * Hintergrundgrafik uebergeben.
	 * 
	 * @param id Identifikationsnummer der Textur
	 */
	public OuterRightUpGrassHillTile(int id) {
		super(Assets.OuterRightUpGrassHillTile, id);
	}
	
	@Override
	public boolean isSolid(){
		return true;
	}

}