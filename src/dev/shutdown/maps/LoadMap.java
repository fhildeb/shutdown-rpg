package dev.shutdown.maps;

import java.awt.Graphics;

import dev.shutdown.Handler;
import dev.shutdown.entities.EntityManager;
import dev.shutdown.entities.creatures.Player;
import dev.shutdown.items.ItemManager;
import dev.shutdown.items.SheetManager;
import dev.shutdown.tile.Tile;
import dev.shutdown.utilities.SaveStats;
import dev.shutdown.utilities.Utilities;

/**
 * Diese Klasse dient zum Erstellen einer Spielwelt
 * bezueglich des gespiecherten Stielstands.
 * 
 * @author Felix Hildebrandt
 *
 */
public class LoadMap {

	private int width, height, spawnX, spawnY;
	private int[][] tiles;
	private static Handler handler;
	
	//Objekte
	private static EntityManager entityManager;
	
	//Gegenstaende
	private ItemManager itemManager;
	
	//Nachrichten
	private SheetManager sheetManager;
	
	/**
     * Es wird eine neue Karte erstellt und
	 * fuer die gespeicherten Objekte, Gegenstaende und Nachrichten einen neuen
	 * Manager anlegt. Auﬂerdem werden die Objekte, Gegenstaende
	 * und Nachrichten in diese Manager und somit in die Spielwelt hinzugefuegt.
	 * Der Spawnpunkt des Spielers wird ebenso eingelesen.
	 * 
	 * @param handler Handler der Spielwelt
	 * @param path Pfad der gespeicherten Spielwelt-Datei
	 */
	public LoadMap(Handler handler, String path) {	
		
		//Handler
		LoadMap.handler = handler;
		
		//Manager
		entityManager = new EntityManager(handler, new Player(handler, 48, 48));
		itemManager = new ItemManager(handler);
		sheetManager = new SheetManager(handler);
		
		//Laden des Spielstands
			SaveStats ss = new SaveStats();
			ss.LoadPastGame();
			loadMap(path);
			entityManager.getPlayer().setX(SaveStats.PLAYERX);
			entityManager.getPlayer().setY(SaveStats.PLAYERY);
	}

	/**
	 * Aktualisieren der Spielwelt mit ihren
	 * Objekten, Gegenstaenden und Nachrichten.
	 */
	public void tick() {
		entityManager.tick();
		itemManager.tick();
		sheetManager.tick();
	}
	
	/**
	 * Zeichen des benoetigten Spielausschnitts aus der gesamten
	 * geladenen Spielwelt auf die Bildflaeche.
	 * 
	 * @param paintbrush Bildflaeche
	 */
	public void render(Graphics paintbrush) {
		int xStart = (int) Math.max(0, (handler.getGameView().getxOffSet()) / Tile.TILE_WIDTH);
		int xEnd = (int) Math.min(width, (handler.getGameView().getxOffSet() + handler.getWidth()) / Tile.TILE_WIDTH +1);
		int yStart = (int) Math.max(0, (handler.getGameView().getyOffSet()) / Tile.TILE_HEIGHT);
		int yEnd = (int) Math.min(height, (handler.getGameView().getyOffSet() + handler.getHeight()) / Tile.TILE_HEIGHT +1)-3;
		
		
		for(int y = yStart; y < yEnd; y++) {
			for(int x = xStart; x < xEnd; x++) {
				getTile(x, y).render(paintbrush, (int) (x * Tile.TILE_WIDTH + 48 - handler.getGameView().getxOffSet()),
												 (int) (y * Tile.TILE_HEIGHT + 48 - handler.getGameView().getyOffSet()));
			}
		}
		
		//Nachrichten zeichen
		sheetManager.render(paintbrush);
		
		//Gegenstaende zeichnen
		itemManager.render(paintbrush);
		
		//Objekte zeichnen
		entityManager.render(paintbrush);
	}
	
	/**
	 * Zurueckgabe des Hintergrunds fuer eine bestimmte Position
	 * der geladenen Spielwelt sowie Festlegen eines Standardhintergrunds 
	 * falls das Spielwelt vom Spieler ueberschritten wird.
	 * 
	 * @param x Position des Untergrunds auf der X-Achse in Pixel
	 * @param y Position des Untergrunds auf der Y-Achse in Pixel
	 * 
	 * @return Hintergrund der Position
	 */
	public Tile getTile(int x, int y) {
		
		if(x < 0 || y < 0 || x >= width || y >= height) {
			return Tile.grassTile;
		}
		
		Tile tile = Tile.tiles[tiles[x][y]];
		if(tile == null) {
			return Tile.grassTile;
		}
		return tile;
	}
	
	/**
	 * Laden der Spielwelt aus einem Textdokument.
	 * 
	 * @param path Pfad der Spielwelt-Textdatei
	 */
	private void loadMap(String path) {
		Utilities u = new Utilities();
		String file = u.loadFileAsString(path);
		String[] tokens = file.split("\\s+");
		width = Utilities.parseInt(tokens[0]);
		height = Utilities.parseInt(tokens[1]);
		spawnX = Utilities.parseInt(tokens[2]);
		spawnY = Utilities.parseInt(tokens[3]);
		
		tiles = new int[width][height];
		for(int y = 0; y < height; y++) {
			for(int x = 0; x < width; x++) {
				tiles[x][y] = Utilities.parseInt(tokens[(x + y * width) + 4]);
			}
		}
	}
	
	/**
	 * Zurueckgabe des Objekt-Managers der geladenen Spielwelt.
	 * 
	 * @return Objekt Manager der geladenen Spielwelt
	 */
	public static EntityManager getEntityManager() {
		return entityManager;
	}
	
	/**
	 * Zurueckgabe der Breite der Spielwelt in Pixel.
	 * 
	 * @return Breite der Spielwelt in Pixel
	 */
	public  int getWidth() {
		return width;
	}
	
	/**
	 * Zurueckgabe der Hoehe der Spielwelt in Pixel.
	 * 
	 * @return Hoehe der Spielwelt in Pixel
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * Zurueckgabe des Handlers der Spielwelt.
	 * 
	 * @return Handler der Spielwelt
	 */
	public static Handler getHandler() {
		return handler;
	}

	/**
	 * Festlegen des Handlers der Spielwelt.
	 * 
	 * @param handler Handler der Spielwelt
	 */
	public void setHandler(Handler handler) {
		LoadMap.handler = handler;
	}

	/**
	 * Zurueckgabe des Gegenstand-Managers der Spielwelt.
	 * 
	 * @return Gegenstand-Manager der Spielwelt
	 */
	public ItemManager getItemManager() {
		return itemManager;
	}

	/**
	 * Festlegen des Gegenstand-Manager fuer die Spielwelt.
	 * 
	 * @param itemManager Gegenstand-Manager der Spielwelt
	 */
	public void setItemManager(ItemManager itemManager) {
		this.itemManager = itemManager;
	}

	/**
	 * Zurueckgabe des Nachrichten-Managers der Spielwelt.
	 * 
	 * @return Nachrichten-Manager der Spielwelt
	 */
	public SheetManager getSheetManager() {
		return sheetManager;
	}

	/**
	 * Festlegen des Nachrichten-Managers der Spielwelt.
	 * 
	 * @param sheetManager Nachrichten-Manager der Spielwelt
	 */
	public void setSheetManager(SheetManager sheetManager) {
		this.sheetManager = sheetManager;
	}

	/**
	 * Zurueckgabe des Spawnpunnktes des Spielers auf der X-Achse
	 * der geladenen Spielwelt.
	 * 
	 * @return Spawnpunkt des Spielers auf der X-Achse der gelanden Spielwelt
	 */
	public int getSpawnX() {
		return spawnX;
	}

	/**
	 * Zurueckgabe des Spawnpunktes des Spielers auf der Y-Achse
	 * der geladenen Spielwelt.
	 * 
	 * @return Spawnpunkt des Spielers auf der Y-Achse der geladenen Spielwelt
	 */
	public int getSpawnY() {
		return spawnY;
	}

	/**
	 * Festlegen des Spawnpunktes des Spielers auf der X-Achse
	 * der geladenen Spielwelt.
	 * 
	 * @param spawnX Spawnpunkt des Spielers auf der X-Achse der geladenen Spielwelt
	 */
	public void setSpawnX(int spawnX) {
		this.spawnX = spawnX;
	}

	/**
	 * Festlegen des Spawnpunktes des Spielers auf der Y-Achse der geladenen Spielwelt.
	 * 
	 * @param spawnY Spawnpunkt des Spielers auf der Y-Achse der geladenen Spielwelt
	 */
	public void setSpawnY(int spawnY) {
		this.spawnY = spawnY;
	}
}
