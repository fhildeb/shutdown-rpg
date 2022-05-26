package dev.shutdown.tile;

import dev.shutdown.graphics.Assets;

/**
 * Diese Klasse dient zum Erstellen des Hintergrundes "Strasse" (Rechts-Mitte)
 * in der Spielwelt.
 * 
 * @author Felix Hildebrandt
 *
 */
public class OuterRightMidRoadTile extends Tile {

	/**
	 * Es wird die Identifikationsnummer des Hintergrundes
	 * an die Oberklasse mit der dazugehoerigen
	 * Hintergrundgrafik uebergeben.
	 * 
	 * @param id Identifikationsnummer der Textur
	 */
	public OuterRightMidRoadTile(int id) {
		super(Assets.OuterRightMidRoadTile, id);
	}
	
	@Override
	public boolean isSolid(){
		return false;
	}

}