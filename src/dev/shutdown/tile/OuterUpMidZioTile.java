package dev.shutdown.tile;

import dev.shutdown.graphics.Assets;

/**
 * Diese Klasse dient zum Erstellen des Hintergrundes "Zeigelstein" (Oben-Mitte)
 * in der Spielwelt.
 * 
 * @author Felix Hildebrandt
 *
 */
public class OuterUpMidZioTile extends Tile {

	/**
	 * Es wird die Identifikationsnummer des Hintergrundes
	 * an die Oberklasse mit der dazugehoerigen
	 * Hintergrundgrafik uebergeben.
	 * 
	 * @param id Identifikationsnummer der Textur
	 */
	public OuterUpMidZioTile(int id) {
		super(Assets.OuterUpMidZioTile, id);
	}

	@Override
	public boolean isSolid(){
		return false;
	}

}