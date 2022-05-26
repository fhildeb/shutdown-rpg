package dev.shutdown.maps;

import java.awt.Graphics;

import dev.shutdown.Handler;
import dev.shutdown.entities.EntityManager;
import dev.shutdown.entities.creatures.Player;
import dev.shutdown.entities.statics.*;
import dev.shutdown.inventory.Inventory;
import dev.shutdown.items.Item;
import dev.shutdown.items.ItemManager;
import dev.shutdown.items.SheetManager;
import dev.shutdown.tile.Tile;
import dev.shutdown.utilities.Utilities;

/**
 * Diese Klasse dient zum Erstellen der Spielwelt zu
 * Beginn eines neuen Spiels.
 * 
 * @author Felix Hildebrandt
 *
 */
public class Maps {

	private int width, height, spawnX, spawnY;
	private int[][] tiles;
	
	//Handler
	private static Handler handler;
	
	//Objekte
	private static EntityManager entityManager;
	
	//Gegenstaende
	private static ItemManager itemManager;
	
	//Nachrichten
	private static SheetManager sheetManager;
	
	/**
	 * Es wird eine neue Karte erstellt und
	 * fuer die Objekte, Gegenstaende und Nachrichten einen neuen
	 * Manager anlegt. Auﬂerdem werden alle Objekte zur Spielwelt hinzugefuegt
	 * welche zu Beginn in der Spielwelt platziert werden. 
	 * Der Spawnpunkt des Spielers wird ebenso festegelgt
	 * 
	 * @param handler Handler des Spiels
	 * @param path Pfad der Karte
	 */
	public Maps(Handler handler, String path) {	
		
		//Handler
		Maps.handler = handler;
		
		//Manager
		entityManager = new EntityManager(handler, new Player(handler, 48, 48));
		itemManager = new ItemManager(handler);
		sheetManager = new SheetManager(handler);
		
		//Objekte auf der Karte Erstellen
		
        EntityManager.addEntity(new TrunkSmall(handler, 290, 200));
		EntityManager.addEntity(new EntranceClose(handler, 5*64+17, 15));
		EntityManager.addEntity(new TreeHigh(handler, 50, 4*54));
		EntityManager.addEntity(new TreeHigh(handler, 50+1*64, 5*51));
		EntityManager.addEntity(new TreeHigh(handler, 50+2*64, 5*51));
		EntityManager.addEntity(new TreeHigh(handler, 50+3*64, 5*51));
		EntityManager.addEntity(new TreeHigh(handler, 50+4*64, 5*51));
		EntityManager.addEntity(new TreeHigh(handler, 50+5*64, 5*51));
		EntityManager.addEntity(new TreeHigh(handler, 50+6*64, 5*51));
		EntityManager.addEntity(new TreeHigh(handler, 50, 5*51));
		EntityManager.addEntity(new ClearTree(handler, 300, 150));
		EntityManager.addEntity(new ShroomDark(handler, 50+3*48, 7*55));
		EntityManager.addEntity(new ShroomLight(handler, 50+3*48+64*4, 7*55));
		EntityManager.addEntity(new ShroomLight(handler, 50+3*48+64*2, 7*55));
		EntityManager.addEntity(new ShroomDark(handler, 50+3*48+64*3, 7*55+64));
		EntityManager.addEntity(new ShroomDark(handler, 50+3*48-64, 7*55+64));
		EntityManager.addEntity(new ShroomLight(handler, 50+3*48+64, 7*55+64));
		EntityManager.addEntity(new ShroomLight(handler, 50+3*48, 7*55+2*64));
		EntityManager.addEntity(new ShroomDark(handler, 50+3*48+64*4, 7*55+2*64));
		EntityManager.addEntity(new ShroomLight(handler, 50+3*48+64*2, 7*55+2*64));
		EntityManager.addEntity(new ShroomLight(handler, 7*64+48, 3*64+48));
		EntityManager.addEntity(new ShroomLight(handler, 8*64+48, 3*64+48));
		EntityManager.addEntity(new ShroomLight(handler, 9*64+48, 3*64+48));
		EntityManager.addEntity(new ShroomLight(handler, 7*64+48, 4*64+17));
		EntityManager.addEntity(new ShroomLight(handler, 8*64+48, 4*64+17));
		EntityManager.addEntity(new ShroomLight(handler, 9*64+48, 4*64+17));
		EntityManager.addEntity(new HouseBigRed(handler, 11*64+48, 58));
		EntityManager.addEntity(new HouseBigBlue(handler, 16*64+48, 58));
		EntityManager.addEntity(new Box(handler, 20*64+48, 90));
		EntityManager.addEntity(new BoxSmall(handler, 20*64+78, 90));
		EntityManager.addEntity(new Sword(handler, 20*64+63, 150));
		EntityManager.addEntity(new ClearTreeBig(handler, 780, 400));
		EntityManager.addEntity(new RockBrown(handler, (10*64+63+52*14)-7, 48));
		EntityManager.addEntity(new Barrier(handler, 10*64+37+52*15, 38));
		EntityManager.addEntity(new Barrier(handler, 11*64+36+52*15, 38));
		EntityManager.addEntity(new Barrier(handler, 10*64+37+52*15, 670));
		EntityManager.addEntity(new Barrier(handler, 11*64+36+52*15, 670));
		EntityManager.addEntity(new Hay(handler, 14*64+52*15+6, 590-128));
		EntityManager.addEntity(new Hay(handler, 14*64+52*15+6, 590-160-128));
		EntityManager.addEntity(new Trunk(handler, 19*64+52*15, 260));
		EntityManager.addEntity(new Trunk(handler, 20*64+50*15, 230));
		EntityManager.addEntity(new HouseSmallBlue(handler, 22*64+50*15+3, 300));
		EntityManager.addEntity(new HouseSmallRed(handler, 28*64+51*15, 300));
		EntityManager.addEntity(new ClearTreeBig(handler, 24*64+52*15, 50));
		EntityManager.addEntity(new ClearTreeBig(handler, 26*64+52*15, 50));
		EntityManager.addEntity(new Key(handler, 25*64+53*15, 140));
		EntityManager.addEntity(new Tree(handler, 28*64+54*15+3, 0));
		EntityManager.addEntity(new RockBrown(handler, 30*64+53*15-3, 86));
		EntityManager.addEntity(new Trunk(handler, 25*64+54*15+8, 195));
		EntityManager.addEntity(new Box(handler, 30*64+54*15+8, 195));
		EntityManager.addEntity(new BoxSmall(handler, 30*64+56*15, 175));
		EntityManager.addEntity(new ShroomLight(handler, 31*64+56*15, 145));
		EntityManager.addEntity(new ShroomDark(handler, 31*64+56*15, 115));
		EntityManager.addEntity(new ShroomLight(handler, 31*64+58*15, 105));
		EntityManager.addEntity(new SheetBottle1(handler, 33*64+54*15, 300));
		EntityManager.addEntity(new PlantCube(handler, 33*64+56*15+5, 303));
		EntityManager.addEntity(new GrassLong(handler, 33*64+54*15+5, 400));
		EntityManager.addEntity(new GrassLong(handler, 33*64+56*15+5, 400));
		EntityManager.addEntity(new PlantCube(handler, 33*64+54*15, 500));
		EntityManager.addEntity(new SheetBottle2(handler, 33*64+56*15+5, 500));
		EntityManager.addEntity(new PlantCube(handler, 38*64+54*15, 400));
		EntityManager.addEntity(new SheetBottle3(handler, 38*64+56*15+5, 400));
		EntityManager.addEntity(new Trunk(handler, 37*64+59*15, 170));
		EntityManager.addEntity(new Rocks(handler, 40*64+56*15, 110));
		EntityManager.addEntity(new SheetBottle4(handler, 40*64+56*15+5, 140));
		EntityManager.addEntity(new Rocks(handler, 42*64+56*15, 140));
		EntityManager.addEntity(new SheetBottle5(handler, 42*64+56*15+5, 110));
		EntityManager.addEntity(new SheetBottle6(handler, 44*64+56*15+5, 300));
		EntityManager.addEntity(new Plant(handler, 44*64+54*15+5, 300));
		EntityManager.addEntity(new Plant(handler, 44*64+54*15+5, 330));
		EntityManager.addEntity(new Plant(handler, 44*64+56*15+5, 330));
		EntityManager.addEntity(new Plant(handler, 44*64+54*15+5, 360));
		EntityManager.addEntity(new Plant(handler, 44*64+56*15+5, 360));
		EntityManager.addEntity(new Plant(handler, 44*64+54*15+5, 390));
		EntityManager.addEntity(new Plant(handler, 44*64+56*15+5, 390));
		EntityManager.addEntity(new SheetBottle7(handler, 44*64+56*15+5, 410));
		EntityManager.addEntity(new Box(handler, 45*64+56*15+5, 370));
		EntityManager.addEntity(new Box(handler, 45*64+58*15+5, 340));
		EntityManager.addEntity(new Box(handler, 46*64+56*15+5, 370));
		EntityManager.addEntity(new Box(handler, 46*64+58*15+5, 340));
		EntityManager.addEntity(new Tree(handler, 39*64+58*15+5, 300));
		EntityManager.addEntity(new SheetBottle8(handler, 49*64+56*15+5, 410));
		EntityManager.addEntity(new EntranceOpen(handler, 48*64+57*15+5, 150));
		
		for(int i = 6; i<11; i++)
			EntityManager.addEntity(new TreeHigh(handler, 50, i*42));
		
		for(int i = 0; i<14;i++)
			EntityManager.addEntity(new RockBrown(handler, 10*64+63+52*i, 48));

		for(int i = 0; i<3;i++)
			EntityManager.addEntity(new PlantCube(handler, 11*64+48+28*i, 230));
		
		for(int i = 0; i<3;i++)
			EntityManager.addEntity(new PlantCube(handler, 16*64+48+28*i, 230));
		
		for(int i = 0; i<2; i++)
			EntityManager.addEntity(new TreeRound(handler, 18*64+52*15, 300+i*128));
		
		for(int i = 0; i<3; i++)
			EntityManager.addEntity(new TreeRoundBig(handler, 17*64+52*15-20-i*115, 50));
		
		for(int i = 0; i<3; i++)
			EntityManager.addEntity(new GrassLong(handler, 21*64+52*15-i*30, 200+i*20));
		
		for(int i = 0; i<5; i++)
			EntityManager.addEntity(new Plant(handler, 22*64+52*15, 230+i*20));
		
		for(int i = 0; i<5; i++)
			EntityManager.addEntity(new Plant(handler, 22*64+54*15, 230+i*20));
		
		for(int i = 0; i<4; i++)
			EntityManager.addEntity(new Plant(handler, 22*64+52*15-i*30, 230+4*20));
		
		for(int i = 0; i<4; i++)
			EntityManager.addEntity(new Plant(handler, 22*64+52*15-i*30, 230+3*20));

		for(int i = 0; i<4; i++)
			EntityManager.addEntity(new PlantCube(handler, 22*64+51*15+i*30, 490));
		
		for(int i = 0; i<2; i++)
			EntityManager.addEntity(new PlantCube(handler, 28*64+52*15+i*30, 490));
	
		for(int i = 1; i<4; i++)
			EntityManager.addEntity(new TreeHigh(handler, 29*64+52*15, i*50));
		
		for(int i = 0; i<5; i++)
			EntityManager.addEntity(new Rocks(handler, 23*64+54*15+i*64, 50));
	
		for(int i = 0; i<6; i++)
			EntityManager.addEntity(new SeaPlant(handler, 34*64+58*15+i*35, 225));
	
		for(int i=0;i<4;i++)
			EntityManager.addEntity(new ClearTree(handler, 50*64+58*15+5, 180+i*64));
		
		for(int i=0;i<4;i++)
			EntityManager.addEntity(new EntranceClose(handler, 50*64+56*15+5+i*96, 60));
		
		//Inventar
		Inventory.addItem(Item.attack_1_interact);
		loadMap(path);
		
		//Spieler hinzufuegen
		entityManager.getPlayer().setX(spawnX);
		entityManager.getPlayer().setY(spawnY);
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
	 * Spielwelt auf die Bildflaeche
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
		
		//Gegenstaende zeichen
		itemManager.render(paintbrush);
		
		//Objekte zeichen
		entityManager.render(paintbrush);
	}
	
	/**
	 * Zurueckgabe des Hintergrunds fuer eine bestimmte Position
	 * der Spielwelt sowie Festlegen eines Standardhintergrunds 
	 * falls die Spielwelt vom Spieler ueberschritten wird.
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
	 * Zurueckgabe des Objekt-Managers der Spielwelt.
	 * 
	 * @return Objekt Manager der Spielwelt
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
		Maps.handler = handler;
	}

	/**
	 * Zurueckgabe des Gegenstand-Managers der Spielwelt.
	 * 
	 * @return Gegenstand-Manager der Spielwelt
	 */
	public static ItemManager getItemManager() {
		return itemManager;
	}

	/**
	 * Festlegen des Gegenstand-Manager der Spielwelt.
	 * 
	 * @param itemManager Gegenstand-Manager der Spielwelt
	 */
	public void setItemManager(ItemManager itemManager) {
		Maps.itemManager = itemManager;
	}

	/**
	 * Zurueckgabe des Nachrichten-Managers der Spielwelt.
	 * 
	 * @return Nachrichten-Manager der Spielwelt
	 */
	public static SheetManager getSheetManager() {
		return sheetManager;
	}

	/**
	 * Festlegen des Nachrichten-Managers der Spielwelt.
	 * 
	 * @param sheetManager Nachrichten-Manager der Spielwelt
	 */
	public void setSheetManager(SheetManager sheetManager) {
		Maps.sheetManager = sheetManager;
	}
}
