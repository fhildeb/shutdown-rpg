package dev.shutdown.entities.creatures;

import dev.shutdown.Handler;
import dev.shutdown.entities.Entity;
import dev.shutdown.tile.Tile;

/**
 * Dies ist eine abstrakte Klasse welche dazu dient Kreaturen
 * in der Spielwelt plazieren und navigieren zu koennen.
 * 
 * @author Felix Hildebrandt
 *
 */
public abstract class Creature extends Entity {

	//Eigenschaften der Kreatur
	public static final float DEFAULT_SPEED = 2.0f;
	public static final int DEFAULT_CREATURE_WIDTH = 64;
	public static final int DEFAULT_CREATURE_HEIGHT = 64;
	
	//Bewegungen
	protected float speed;
	protected float xMove;
	protected float yMove;
	
	/**
	 * Es werden die Parameter Handler und die Anzahl des Lebens bezueglich
	 * der Attacken Hand, Stock, Schwert und Schluessel an die Oberklasse uebergeben. 
	 * Ebenso wird die X- und Y-Position sowie die Breite und Hoehe der Kreatur in Pixel
	 * an die Oberklasse uebergeben. Zusaetzlich dazu werden die Bewegungseigenschaften
	 * der Kreatur zum Start des Spiels festgelegt.
	 * 
	 * @param handler 	Handler der Kreatur
	 * @param x 		Position auf der X-Achse der Spielwelt in Pixel
	 * @param y 		Position auf der Y-Achse der Spielwelt in Pixel
	 * @param width		Breite der Kreatur in Pixel
	 * @param height 	Hoehe der Kreatur in Pixel
	 * @param health1	Lebensbalken des Objektes bezueglich der Interaktion mit der Hand
	 * @param health2	Lebensbalken des Objektes bezueglich des Stock-Angriffs
	 * @param health3	Lebensbalken des Objektes bezueglich des Schwert-Angriffs
	 * @param health4	Lebensbalken des Objektes bezueglich der Interaktion mit dem Schluessel
	 */
	public Creature(Handler handler, float x, float y, int width, int height, int health1, int health2, int health3, int health4) {
		super(handler, x, y, width, height, health1, health2, health3, health4);
		
		//Bewegungen
		speed = DEFAULT_SPEED;
		xMove = 0;
		yMove = 0;
	}
	
	/**
	 * Zurueckgabe der Pixel um die sich die Position der Kreatur auf der X-Achse nach dem
	 * Bewegen veraendert hat.
	 * 
	 * @return Veraenderung der Position auf der X-Achse nach dem Bewegen der Kreatur in Pixel
	 */
	public float getxMove() {
		return xMove;
	}

	/**
	 * Festlegen um wie viele Pixel sich die Position der Kreatur auf der X-Achse nach dem
	 * Bewegen veraendert hat.
	 * 
	 * @param xMove Veraenderung der Position auf der X-Achse nach dem Bewegen der Kreatur in Pixel
	 */
	public void setxMove(float xMove) {
		this.xMove = xMove;
	}

	/**
	 * Zurueckgabe um wie viele Pixel sich die Position der Kreatur auf der Y-Achse nach dem
	 * Bewegen veraendert hat.
	 * 
	 * @return Veraenderung der Position auf der Y-Achse nach dem Bewegen der Kreatur in Pixel
	 */
	public float getyMove() {
		return yMove;
	}

	/**
	 * Festlegen um wie viele Pixel sich die Position der Kreatur auf der Y-Achse nach dem
	 * Bewegen hat.
	 * 
	 * @param yMove Veraenderung der Position auf der Y-Achse nach dem Bewegen der Kreatur in Pixel
	 */
	public void setyMove(float yMove) {
		this.yMove = yMove;
	}

	/**
	 * Bewegen der Kreatur auf dem Spielfeld auf beiden Achsen solang
	 * diese mit keinem anderen Objekt kollidiert.
	 */
	public void move() {
		//Pruefung auf Kollision auf der X-Achse
		if(!checkEntityCollisions(xMove, 0f)) {
			moveX();
		}
		//Pruefung auf Kollision auf der Y-Achse
		if(!checkEntityCollisions(0f, yMove)) {
			moveY();
		}
	}
	
	/**
	 * Bewegen der Kratur auf der X-Achse mit Beachtung der
	 * Kollisionsbox der Kreatur bezueglich nicht betretbarer
	 * Untergruende auf der Spielwelt.
	 */
	public void moveX() {
		if(xMove > 0) {
			/*
			 * Bewegung von der aktuellen Position aus nach rechts
			 * Formel fuer posx:
			 * 			(
			 * 				  [X-Position des Spielers]
			 *				- [Breite des Layouts rechts]
			 *				+ [Bewegung nach rechts]
			 *				+ [X-Position der Kollisionsbox der Kreatur]
			 *				+ [Breite der Kollisionsbox der Kreatur]
			 *			)	
			 *				/ [Breite der Texturen]
			 */
			
			int posx = (int) ((x -48 + xMove + collisionBox.x + collisionBox.width) / Tile.TILE_WIDTH);
			
			/*
			* Pruefen mit Hilfe der collisionWithTile-Methode,
			* ob Kollision mit nicht betretbarem Untergrund in rechter Richtung vorliegt
			*/
			
			//Falls keine Kollision vorliegt ist Bewegung gestattet
			if( !collisionWithTile(posx, (int)(y -48 + collisionBox.y) / Tile.TILE_HEIGHT) &&
					!collisionWithTile(posx, (int) (y -48 + collisionBox.y + collisionBox.height) / Tile.TILE_HEIGHT)){
				x += xMove;
			
			//Falls Kollision vorliegt wird Ausgangspunkt eingenommen
			}else {
				x = posx * Tile.TILE_WIDTH - collisionBox.x - collisionBox.width +47;
			}
		}else if(xMove < 0) {
			/*
			 * Bewegung von der aktuellen Position aus nach links
			 * Formel fuer posx:
			 * 			(
			 * 				  [X-Position des Spielers]
			 *				- [Breite des Layouts links]
			 *				+ [Bewegung nach links]
			 *				+ [X-Position der Kollisionsbox der Kreatur]
			 *			)	
			 *				/ [Breite der Texturen]
			 */
			
			int posx = (int) ((x -48 + xMove + collisionBox.x) / Tile.TILE_WIDTH);
			
			/*
			* Pruefen mit Hilfe der collisionWithTile-Methode,
			* ob Kollision mit nicht betretbarem Untergrund in linker Richtung vorliegt
			*/
			
			//Falls keine Kollision vorliegt ist Bewegung gestattet
			if(!collisionWithTile(posx, (int) (y -48 + collisionBox.y) / Tile.TILE_HEIGHT) &&
					!collisionWithTile(posx, (int) (y -48 + collisionBox.y + collisionBox.height) / Tile.TILE_HEIGHT)){
				x += xMove;
			}
			//Falls Kollision vorliegt kann sich nicht Bewegt werden
			else {
				x = posx * Tile.TILE_WIDTH + Tile.TILE_WIDTH - collisionBox.x +49;
			}
		}
	}
	
	/**
	 * Bewegung auf der Y-Achse mit Beachtung der
	 * Kollisionsbox der Kreatur bezueglich nicht betretbarer
	 * Untergruende auf der Spielwelt.
	 */
	public void moveY() {
		if(yMove < 0) {
			/*
			 * Bewegung von der aktuellen Position aus nach oben
			 * Formel fuer posy:
			 * 			(
			 * 				  [Y-Position des Spielers]
			 *				- [Hoehe des Layouts oben]
			 *				+ [Bewegung nach oben]
			 *				+ [Y-Position der Kollisionsbox der Kreatur]
			 *			)	
			 *				/ [Hoehe der Texturen]
			 */
			
			int posy = (int) ((y -48 + yMove + collisionBox.y) / Tile.TILE_HEIGHT);
			
			/*
			* Pruefen mit Hilfe der collisionWithTile-Methode,
			* ob Kollision mit nicht betretbarem Untergrund nach oben vorliegt
			*/
			
			//Falls keine Kollision vorliegt ist Bewegung gestattet
			if( !collisionWithTile((int) (x -48 + collisionBox.x) / Tile.TILE_WIDTH, posy) &&
					!collisionWithTile((int) (x -48 + collisionBox.x + collisionBox.width) / Tile.TILE_WIDTH, posy	)){
				y += yMove;
			}
			//Falls Kollision vorliegt kann sich nicht Bewegt werden
			else {
				y = posy * Tile.TILE_HEIGHT + Tile.TILE_HEIGHT - collisionBox.y +49;
			}
			
		}else if(yMove > 0) {
			/*
			 * Bewegung von der aktuellen Position aus nach unten
			 * Formel fuer posy:
			 * 			(
			 * 				  [Y-Position des Spielers]
			 *				- [Hoehe des Layouts unten]
			 *				+ [Bewegung nach unten]
			 *				+ [Y-Position der Kollisionsbox der Kreatur]
			 *				+ [Hoehe der Kollisionsbox der Kreatur]
			 *			)	
			 *				/ [Hoehe der Texturen]
			 */
			int posy = (int) ((y -48 + yMove + collisionBox.y + collisionBox.height) / Tile.TILE_HEIGHT);
			
			/*
			* Pruefen mit Hilfe der collisionWithTile-Methode,
			* ob Kollision mit nicht betretbarem Untergrund nach unten vorliegt
			*/
			
			//Falls keine Kollision vorliegt ist Bewegung gestattet
			if( !collisionWithTile((int) (x -48 + collisionBox.x) / Tile.TILE_WIDTH, posy) &&
					!collisionWithTile((int) (x -48 + collisionBox.x + collisionBox.width) / Tile.TILE_WIDTH, posy	)){
				y += yMove;
			}
			//Falls Kollision vorliegt kann sich nicht Bewegt werden
			else {
				y = posy * Tile.TILE_HEIGHT - collisionBox.y - collisionBox.height +47;
			}
		}
	}
	
	/**
	 * Pruefen ob die Kreatur den Untergrund
	 * der Spielwelt durchlaufen kann oder nicht.
	 * 
	 * @param x Die x-te Untergrundtextur auf der horizontalen Achse der Spielwelt
	 * @param y Die y-te Untergrundtextur auf der vertikalen Achse des Spielwelt
	 */
	protected boolean collisionWithTile(int x, int y) {
		return handler.getMap().getTile(x, y).isSolid();
	}
	
	@Override
	public int getHealth1() {
		return health1;
	}
	
	@Override
	public int getHealth2() {
		return health2;
	}

	@Override
	public int getHealth3() {
		return health3;
	}

	@Override
	public int getHealth4() {
		return health4;
	}

	
	/**
	 * Zurueckgabe der Laufgeschwindigkeit der Kreatur.
	 * 
	 * @return Laufgeschwindigkeit der Kreatur
	 */
	public float getSpeed() {
		return speed;
	}

	/**
	 * Festlegen der Laufgeschwindigkeit der Kreatur.
	 * 
	 * @param speed Laufgeschwindigkeit der Kreatur
	 */
	public void setSpeed(float speed) {
		this.speed = speed;
	}

	
}
