package dev.shutdown.tile;

import dev.shutdown.graphics.Assets;

/**
 * Diese Klasse dient zum Erstellen des Hintergrund "Strasse" (Links-Oben)
 * in der Spielwelt.
 * 
 * @author Felix Hildebrandt
 *
 */
public class OuterLeftUpRoadTile extends Tile {

	/**
	 * Es wird die Identifikationsnummer des Hintergrundes
	 * an die Oberklasse mit der dazugehoerigen
	 * Hintergrundgrafik uebergeben.
	 * 
	 * @param id Identifikationsnummer der Textur
	 */
	public OuterLeftUpRoadTile(int id) {
		super(Assets.OuterLeftUpRoadTile, id);
	}

	@Override
	public boolean isSolid(){
		return false;
	}

}