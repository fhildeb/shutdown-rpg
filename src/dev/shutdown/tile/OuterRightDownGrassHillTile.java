package dev.shutdown.tile;

import dev.shutdown.graphics.Assets;

/**
 * Diese Klasse dient zum Erstellen des Hintergrundes "bewachsener Berg" (Rechts-Unten)
 * in der Spielwelt.
 * 
 * @author Felix Hildebrandt
 *
 */
public class OuterRightDownGrassHillTile extends Tile {

	/**
	 * Es wird die Identifikationsnummer des Hintergrundes
	 * an die Oberklasse mit der dazugehoerigen
	 * Hintergrundgrafik uebergeben.
	 * 
	 * @param id Identifikationsnummer der Textur
	 */
	public OuterRightDownGrassHillTile(int id) {
		super(Assets.OuterRightDownGrassHillTile, id);
	}

	@Override
	public boolean isSolid(){
		return true;
	}

}