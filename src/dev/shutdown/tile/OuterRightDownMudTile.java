package dev.shutdown.tile;

import dev.shutdown.graphics.Assets;

/**
 * Diese Klasse dient zum Erstellen des Hintergrundes "Schlamm" (Rechts-Unten)
 * in der Spielwelt. 
 * 
 * @author Felix Hildebrandt
 *
 */
public class OuterRightDownMudTile extends Tile {

	/**
	 * Es wird die Identifikationsnummer des Hintergrundes
	 * an die Oberklasse mit der dazugehoerigen
	 * Hintergrundgrafik uebergeben.
	 * 
	 * @param id Identifikationsnummer der Textur
	 */
	public OuterRightDownMudTile(int id) {
		super(Assets.OuterRightDownMudTile, id);
	}

	@Override
	public boolean isSolid(){
		return true;
	}

}