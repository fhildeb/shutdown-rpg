package dev.shutdown.tile;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 * Diese Klasse dient dazu den Hintergrundobjekten der Spielwelt
 * die Identifikationsnummer sowie die Grafik zuzuweisen. Im Anschluss
 * wird der Hintergrund auf die Bildflaeche gezeichnet.
 * 
 * @author Felix Hildebrandt
 *
 */
public class Tile {

	//Grafikarray
	public static Tile[] tiles = new Tile[256];
	
	//Einzelhintergruende
	public static Tile grassTile = new GrassTile(81);
	public static Tile rockTile = new RockTile(82);
	public static Tile grassRockTile = new GrassRockTile(83);
	public static Tile grassBushTile = new GrassBushTile(84);
	public static Tile dirtRockLeft = new DirtRockLeftTile(85);
	public static Tile dirtRockRight = new DirtRockRightTile(86);
	public static Tile dirtRockMid = new DirtRockMidTile(87);
	
		//Strassen-Hintergruende
		public static Tile outerLeftUpRoadTile = new OuterLeftUpRoadTile(11);
		public static Tile outerLeftMidRoadTile = new OuterLeftMidRoadTile(12);
		public static Tile outerLeftDownRoadTile = new OuterLeftDownRoadTile(13);
		public static Tile outerUpMidRoadTile = new OuterUpMidRoadTile(14);
		public static Tile middleRoadTile = new MiddleRoadTile(15);
		public static Tile outerDownMidRoadTile = new OuterDownMidRoadTile(16);
		public static Tile outerRightUpRoadTile = new OuterRightUpRoadTile(17);
		public static Tile outerRightMidRoadTile = new OuterRightMidRoadTile(18);
		public static Tile outerRightDownRoadTile = new OuterRightDownRoadTile(19);
	
		//Ziegelstein-Hintergruende
		public static Tile outerLeftUpZioTile = new OuterLeftUpZioTile(21);
		public static Tile outerLeftMidZioTile = new OuterLeftMidZioTile(22);
		public static Tile outerLeftDownZioTile = new OuterLeftDownZioTile(23);
		public static Tile outerUpMidZioTile = new OuterUpMidZioTile(24);
		public static Tile middleZioTile = new MiddleZioTile(25);
		public static Tile outerDownMidZioTile = new OuterDownMidZioTile(26);
		public static Tile outerRightUpZioTile = new OuterRightUpZioTile(27);
		public static Tile outerRightMidZioTile = new OuterRightMidZioTile(28);
		public static Tile outerRightDownZioTile = new OuterRightDownZioTile(29);
		
		//Wasser-Hintergruende
		public static Tile outerLeftUpWaterTile = new OuterLeftUpWaterTile(31);
		public static Tile outerLeftMidWaterTile = new OuterLeftMidWaterTile(32);
		public static Tile outerLeftDownWaterTile = new OuterLeftDownWaterTile(33);
		public static Tile outerUpMidWaterTile = new OuterUpMidWaterTile(34);
		public static Tile middleWaterTile = new MiddleWaterTile(35);
		public static Tile outerDownMidWaterTile = new OuterDownMidWaterTile(36);
		public static Tile outerRightUpWaterTile = new OuterRightUpWaterTile(37);
		public static Tile outerRightMidWaterTile = new OuterRightMidWaterTile(38);
		public static Tile outerRightDownWaterTile = new OuterRightDownWaterTile(39);
		
		//Schlamm-Hintergruende
		public static Tile outerLeftUpMudTile = new OuterLeftUpMudTile(41);
		public static Tile outerLeftMidMudTile = new OuterLeftMidMudTile(42);
		public static Tile outerLeftDownMudTile = new OuterLeftDownMudTile(43);
		public static Tile outerUpMidMudTile = new OuterUpMidMudTile(44);
		public static Tile middleMudTile = new MiddleMudTile(45);
		public static Tile outerDownMidMudTile = new OuterDownMidMudTile(46);
		public static Tile outerRightUpMudTile = new OuterRightUpMudTile(47);
		public static Tile outerRightMidMudTile = new OuterRightMidMudTile(48);
		public static Tile outerRightDownMudTile = new OuterRightDownMudTile(49);

		//Dreck-Hintergruende
		public static Tile outerLeftUpDirtTile = new OuterLeftUpDirtTile(51);
		public static Tile outerLeftMidDirtTile = new OuterLeftMidDirtTile(52);
		public static Tile outerLeftDownDirtTile = new OuterLeftDownDirtTile(53);
		public static Tile outerUpMidDirtTile = new OuterUpMidDirtTile(54);
		public static Tile middleDirtTile = new MiddleDirtTile(55);
		public static Tile outerDownMidDirtTile = new OuterDownMidDirtTile(56);
		public static Tile outerRightUpDirtTile = new OuterRightUpDirtTile(57);
		public static Tile outerRightMidDirtTile = new OuterRightMidDirtTile(58);
		public static Tile outerRightDownDirtTile = new OuterRightDownDirtTile(59);
		
		//Berg-Hintergruende
		public static Tile outerLeftUpHillTile = new OuterLeftUpHillTile(61);
		public static Tile outerLeftMidHillTile = new OuterLeftMidHillTile(62);
		public static Tile outerLeftDownHillTile = new OuterLeftDownHillTile(63);
		public static Tile outerUpMidHillTile = new OuterUpMidHillTile(64);
		public static Tile middleHillTile = new MiddleHillTile(65);
		public static Tile outerDownMidHillTile = new OuterDownMidHillTile(66);
		public static Tile outerRightUpHillTile = new OuterRightUpHillTile(67);
		public static Tile outerRightMidHillTile = new OuterRightMidHillTile(68);
		public static Tile outerRightDownHillTile = new OuterRightDownHillTile(69);
		
		//bewachsener Berg-Hintergruende
		public static Tile outerLeftUpGrassHillTile = new OuterLeftUpGrassHillTile(71);
		public static Tile outerLeftMidGrassHillTile = new OuterLeftMidGrassHillTile(72);
		public static Tile outerLeftDownGrassHillTile = new OuterLeftDownGrassHillTile(73);
		public static Tile outerUpMidGrassHillTile = new OuterUpMidGrassHillTile(74);
		public static Tile middleGrassHillTile = new MiddleGrassHillTile(75);
		public static Tile outerDownMidGrassHillTile = new OuterDownMidGrassHillTile(76);
		public static Tile outerRightUpGrassHillTile = new OuterRightUpGrassHillTile(77);
		public static Tile outerRightMidGrassHillTile = new OuterRightMidGrassHillTile(78);
		public static Tile outerRightDownGrassHillTile = new OuterRightDownGrassHillTile(79);
	
	//Klasse
	protected BufferedImage texture;
	protected final int id;
	
	public static final int TILE_WIDTH = 64;
	public static final int TILE_HEIGHT = 64;
	public static final int QUATER_WIDTH = 32;
	public static final int QUATER_HEIGHT = 32;
	
	/**
	 * Es wird dem Hintergrundobjekt eine Textur und 
	 * die Identifikationsnummer zugewiesen sowie das
	 * Hintergrundobjekt in den Grafikarray eingespeist.
	 * 
	 * @param texture Textur des Hintergrunds
	 * @param id Identifikationsnummer des Hintergrunds
	 */
	public Tile(BufferedImage texture, int id) {
		this.texture = texture;
		this.id = id;
		
		tiles[id] = this;
	}
	
	/**
	 * Aktualisierung der Hintergruende.
	 */
	public void tick() {
		//Keine Aktionen benoetigt
	}
	
	/**
	 * Zeichnen des Hintergrundes auf die Bildflaeche.
	 * 
	 * @param paintbrush Bildflaeche
	 * @param x X-Position der Textur
	 * @param y Y-Position der Textur
	 */
	public void render(Graphics paintbrush, int x, int y) {
		paintbrush.drawImage(texture, x, y, TILE_WIDTH, TILE_HEIGHT, null);
	}
	
	/**
	 * Zurueckgabe eines boolischen Werts, ob der Hintergrund durchquert werden
	 * darf.
	 * 
	 * @return Boolischer Wert, ob der Hintergrund durchquert werden darf
	 */
	public boolean isSolid() {
	return false;
	}
	
	/**
	 * Zurueckgabe der Identifikationsnummer der Hintergrundgrafik.
	 * 
	 * @return Identifikationsnummer der Hintergrundgrafik
	 */
	public int getId() {
		return id;
	}
}
