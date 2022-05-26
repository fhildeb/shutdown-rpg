package dev.shutdown.tile;

import dev.shutdown.graphics.Assets;

/**
 * Diese Klasse dient zum Erstellen des Hintergrundes "Zeigelstein" (Rechts-Unten)
 * in der Spielwelt.
 * 
 * @author Felix Hildebrandt
 *
 */
public class OuterRightDownZioTile extends Tile {

	/**
	 * Es wird die Identifikationsnummer des Hintergrundes
	 * an die Oberklasse mit der dazugehoerigen
	 * Hintergrundgrafik uebergeben.
	 * 
	 * @param id Identifikationsnummer der Textur
	 */
	public OuterRightDownZioTile(int id) {
		super(Assets.OuterRightDownZioTile, id);
	}

	@Override
	public boolean isSolid(){
		return false;
	}

}