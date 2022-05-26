package dev.shutdown.entities.creatures;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import dev.shutdown.Handler;
import dev.shutdown.audio.Soundplayer;
import dev.shutdown.entities.Entity;
import dev.shutdown.entities.EntityManager;
import dev.shutdown.graphics.Animation;
import dev.shutdown.graphics.Assets;
import dev.shutdown.inventory.Inventory;
import dev.shutdown.inventory.SheetBox;
import dev.shutdown.inventory.SheetInventory;
import dev.shutdown.maps.Maps;
import dev.shutdown.states.GameState;
import dev.shutdown.states.LoadState;

/**
 * Diese klasse dient zum Erstellen von Spielern in der
 * Spielwelt.
 * 
 * @author Felix Hildebrandt
 *
 */
public class Player extends Creature {
	
	//Animationen des Spielers
	private Animation downAnimation, upAnimation, leftAnimation, rightAnimation;
	private Animation downAttkAnimation, upAttkAnimation, leftAttkAnimation, rightAttkAnimation;
	private Animation downAttk2Animation, upAttk2Animation, leftAttk2Animation, rightAttk2Animation;
	private Animation downAttk3Animation, upAttk3Animation, leftAttk3Animation, rightAttk3Animation;
	private Animation downAttk4Animation, upAttk4Animation, leftAttk4Animation, rightAttk4Animation;
	private int movingDirection = 0;
	
	//Abklingzeit einer Attacke
	private long lastAttackTimer, attackCooldown = 1000, attackTimer = attackCooldown;
	
	//Inventarobjekte
	public Inventory inventory;
	private SheetInventory sheetInventory;
	private SheetBox sheetBox;
	
	/**
	 * Es werden die Eigenschaften X- und Y-Position sowie der Handler
	 * des Spielers an die Oberklasse uebergegeben und die 
	 * Kollisionsbox des Spielers festlegt. 
	 * Ebenfalls werden die Animationen fuer alle Laufrichtungen und 
	 * Attacken sowie das Inventar des Spielers erstellt.
	 * 
	 * @param handler Handler des Spielers
	 * @param x Position des Spielers auf der X-Achse in der Spielwelt in Pixel
	 * @param y Position des Spielers auf der Y-Achse in der SPielwelt in Pixel
	 */
	public Player(Handler handler, float x, float y) {
		super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT, 4, 4, 4, 4);
		
		//Kollisionsbox
		collisionBox.x = 20;
		collisionBox.y = 43;
		collisionBox.width = 22;
		collisionBox.height = 13;
		
		//Animationen Charakter
		downAnimation = new Animation(500, Assets.mainChar_down);
		upAnimation = new Animation(500, Assets.mainChar_up);
		leftAnimation = new Animation(500, Assets.mainChar_left);
		rightAnimation = new Animation(500, Assets.mainChar_right);
		
		//Animationen Charakter Attacke 1
		downAttkAnimation = new Animation(500, Assets.mainChar_attk_down);
		upAttkAnimation = new Animation(500, Assets.mainChar_attk_up);
		leftAttkAnimation = new Animation(500, Assets.mainChar_attk_left);
		rightAttkAnimation = new Animation(500, Assets.mainChar_attk_right);
		
		//Animationen Charakter Attacke 2
		downAttk2Animation = new Animation(500, Assets.mainChar_attk2_down);
		upAttk2Animation = new Animation(500, Assets.mainChar_attk2_up);
		leftAttk2Animation = new Animation(500, Assets.mainChar_attk2_left);
		rightAttk2Animation = new Animation(500, Assets.mainChar_attk2_right);
		
		//Animationen Charaker Attacke 3
		downAttk3Animation = new Animation(500, Assets.mainChar_attk3_down);
		upAttk3Animation = new Animation(500, Assets.mainChar_attk3_up);
		leftAttk3Animation = new Animation(500, Assets.mainChar_attk3_left);
		rightAttk3Animation = new Animation(500, Assets.mainChar_attk3_right);
		
		//Animationen CHaraker Attacke 4
		downAttk4Animation = new Animation(500, Assets.mainChar_attk4_down);
		upAttk4Animation = new Animation(500, Assets.mainChar_attk4_up);
		leftAttk4Animation = new Animation(500, Assets.mainChar_attk4_left);
		rightAttk4Animation = new Animation(500, Assets.mainChar_attk4_right);
		
		//Inventar
		inventory = new Inventory(handler);
		sheetBox = new SheetBox(handler);
		sheetInventory = new SheetInventory(handler);
	}

	@Override
	public void tick() {
	
		//Animationen
		if(handler.getKeyManager().attack) {
			
			//Animationen fuer die Interaktion mit der Hand
			leftAttkAnimation.tick();
			rightAttkAnimation.tick();
			upAttkAnimation.tick();
			downAttkAnimation.tick();
			
			//Animationen fuer die Interaktion mit dem Stock
			leftAttk2Animation.tick();
			rightAttk2Animation.tick();
			upAttk2Animation.tick();
			downAttk2Animation.tick();
			
			//Animationen fuer die Interaktion mit dem Schwert
			leftAttk3Animation.tick();
			rightAttk3Animation.tick();
			upAttk3Animation.tick();
			downAttk3Animation.tick();
			
			//Animationen fuer die Interaktion mit dem Schluessel
			leftAttk4Animation.tick();
			rightAttk4Animation.tick();
			upAttk4Animation.tick();
			downAttk4Animation.tick();
		}
		
		//Bewegungen
		if(xMove < 0 ) {
			//Bewegung auf X-Achse nach links
			leftAnimation.tick();
		}else if(xMove > 0) {
			//Bewegung auf X-Achse nach rechts
			rightAnimation.tick();
		}else if(yMove <0) {
			//Bewegung auf Y-Achse nach oben
			upAnimation.tick();
		}else if(yMove > 0){
			//Bewegung auf Y-Achse nach unten
			downAnimation.tick();
		}
		
		//Eingabe aktualisieren
		getInput();
		move();
		
		//Kamera neu zentrieren
		handler.getGameView().centerOnEntity(this);
		
		//Attacken
		checkAttacks();
				
		//Inventar
		inventory.tick();
		sheetBox.tick();
		sheetInventory.tick();
	}
	
	/**
	 * Erstellen eines Interaktionsrechtecks in Richtung der Laufposition des Spielers
	 * und anschlieﬂendes Pruefen ob ein Objekt innerhalb dieses Rechtecks attackiert
	 * werden kann. Wenn moeglich, anschlieﬂendes Ausfueren der aktuell ausgewaelten
	 * Attacke unter Beruecksichtigung derer Abklingzeit sowie Abspielen
	 * des Tons des Angriffs.
	 */
	private void checkAttacks() {
		
		//Abklingzeit Attacke
		attackTimer += System.currentTimeMillis() - lastAttackTimer;
		lastAttackTimer = System.currentTimeMillis();
		
		
		// Falls Abklingzeit fuer eine Attacke noch nicht vorrueber
		if(attackTimer < attackCooldown) {
			return;
		}
		
		// Falls die Nachrichtenbox geoeffnet ist, wird Kampf deaktiviert
		if(sheetBox.isActive())
			return;
		
		//Erstellen des Interaktionsrechtecks
		Rectangle collisionBoxAttack = getCollisionBoxes(0,0);
		Rectangle attackRectangle = new Rectangle();
		int attackRectangleSize = 20;
		attackRectangle.width = attackRectangleSize;
		attackRectangle.height = attackRectangleSize;
		
		//Attacke nach oben
		if((movingDirection == 1) && (handler.getKeyManager().attack)) {
			attackRectangle.x = collisionBoxAttack.x + collisionBoxAttack.width / 2 - attackRectangleSize / 2;
			attackRectangle.y = collisionBoxAttack.y - attackRectangleSize;
		}
		//Attacke nach unten
		else if((movingDirection == 0) && (handler.getKeyManager().attack)) {
			attackRectangle.x = collisionBoxAttack.x + collisionBoxAttack.width / 2 - attackRectangleSize / 2;
			attackRectangle.y = collisionBoxAttack.y + collisionBoxAttack.height;
		}
		//Attacke nach links
		else if((movingDirection == 2) && (handler.getKeyManager().attack)) {
			attackRectangle.x = collisionBoxAttack.x - attackRectangleSize;
			attackRectangle.y = collisionBoxAttack.y + collisionBoxAttack.height / 2 - attackRectangleSize / 2;
		}
		//Attacke nach rechts
		else if((movingDirection == 3) && (handler.getKeyManager().attack)) {
			attackRectangle.x = collisionBoxAttack.x + collisionBoxAttack.width;
			attackRectangle.y = collisionBoxAttack.y + collisionBoxAttack.height / 2 - attackRectangleSize / 2;
		}
		else {
			return;
		}
		
		//Abklingzeit fuer Attacken
		attackTimer = 1;
		
		handler.getMap();
		Maps.getEntityManager();
		for(Entity e : EntityManager.getEntities()) {
			
			//Wenn sich das Spielerobjekt selbst im Interaktionsrechteck befindet
			if(e.equals(this))
				continue;
			if(e.getCollisionBoxes(0,  0).intersects(attackRectangle)) {
				
				//Hand-Attacke
				if(GameState.getActiveAttack() == 1) {
					e.damage1(1);
					Soundplayer.music("/audio/attacks/interact.wav");
					return;
				}
				
				//Stock-Attacke
				if(GameState.getActiveAttack() == 2) {
					e.damage2(1);
					Soundplayer.music("/audio/attacks/stick.wav");
					return;
				}
				
				//Stock-Attacke
				if(GameState.getActiveAttack() == 3) {
					e.damage3(1);
					Soundplayer.music("/audio/attacks/sword.wav");
					return;
				}
				
				//Schwert-Attake
				if(GameState.getActiveAttack() == 4) {
					e.damage4(1);
					Soundplayer.music("/audio/attacks/key.wav");
					return;
				}
				//Keine Attacke
				else {
					return;
				}
			}
		}
		
	}
	
	@Override
	public void disappear() {
		//Falls Spieler von Kreatur getoetet wird
	}
	
	/**
	 * Einlesen der Eingabe der Tastatur und darauf
	 * folgendes Bewegen des Spielers auf der Spielwelt in
	 * die zur Eingabe gehoerende Richtung
	 */
	private void getInput() {
		
		//aktuelles Verschieben der Spielerposition
		xMove = 0;
		yMove = 0;
		
		//Falls Nachrichtenbox angezeigt wird, Bewegung deaktivert
		if(sheetBox.isActive())
			return;
		
		//Wenn die Taste fuer "nach oben bewegen" gedrueckt ist
		if(handler.getKeyManager().up)
			yMove = -speed;
		
		//Wenn die Taste fuer "nach unten bewegen" gedrueckt ist
		if(handler.getKeyManager().down)
			yMove = +speed;
		
		//Wenn die Taste fuer "nach links bewegen" gedrueckt
		if(handler.getKeyManager().left)
			xMove = -speed;
		
		//Wenn die Taste fuer "nach rechts bewegen" gedrueckt
		if(handler.getKeyManager().right)
			xMove = +speed;
	}

	@Override
	public void render(Graphics paintbrush) {
		paintbrush.drawImage(getCurrentAnimationFrame(), (int) (x - handler.getGameView().getxOffSet()), (int) (y - handler.getGameView().getyOffSet()), width, height, null);
				
		/* 
		 *  Zeichnen der Kollisionsbox:
		 *  
		 *	paintbrush.setColor(Color.red);
		 *	paintbrush.fillRect((int)(x + collisionBox.x - handler.getGameView().getxOffSet()),
		 *						(int)(y + collisionBox.y - handler.getGameView().getyOffSet()),
		 *						collisionBox.width, collisionBox.height);
		 */
		
	}
	
	/**
	 * Zeichen der verschiedenen Inventar-Schichten auf die Bildflaeche
	 * nachdem die Spielwelt mit den Objekten gezeichnet wurden.
	 * Dabei wird beruecksichtigt welche Inventar-Schicht gerade
	 * aktiv genutzt wird.
	 * 
	 * @param paintbrush Bildflaeche des Spiels
	 */
	public void postRender(Graphics paintbrush) {
		
		// Falls eine Attacke ausgewaelt
		if(GameState.getInvlayer() == 1) {
			sheetInventory.render(paintbrush);
			inventory.render(paintbrush);
		}
		
		// Falls eine Nachricht ausgewaelt
		else {
			inventory.render(paintbrush);
			sheetInventory.render(paintbrush);
		}
		sheetBox.render(paintbrush);
	}
	
	/**
	 * Aendern der Animation bezueglich der Laufrichtung
	 * oder der Attacke nachdem geprueft wurde in welche Richtung 
	 * sich der Charakter bewegt.
	 */
	private BufferedImage getCurrentAnimationFrame() {
		
		//Falls sich der Spieler bewegt
		if(xMove != 0 || yMove != 0) {
			
			//Bewegung nach links
			if(xMove <0) {
				movingDirection = 2;
				return leftAnimation.getCurrentFrame();
			}
			
			//Bewegung nach rechts
			else if(xMove > 0) {
				movingDirection = 3;
				return rightAnimation.getCurrentFrame();
			}
			
			//Bewegung nach oben
			else if(yMove <0) {
				movingDirection = 1;
				return upAnimation.getCurrentFrame();
			}
			
			//Bewegung nach unten
			else{
				movingDirection = 0;
				return downAnimation.getCurrentFrame();
			}
		}
		
		//Falls der Spieler Hand-Attacke ausfuehrt
		else if(handler.getKeyManager().attack && ( GameState.getActiveAttack() == 1 || LoadState.getActiveAttack() == 1 ) ) {
			
			//Hand-Attacke nach unten
			if(movingDirection == 0)
			{
				return downAttkAnimation.getCurrentFrame();
			}
			
			//Hand-Attacke nach oben
			else if(movingDirection == 1) {
				return upAttkAnimation.getCurrentFrame();
			}
			
			//Hand-Attacke nach links
			else if(movingDirection == 2) {
				return leftAttkAnimation.getCurrentFrame();
			}
			
			//Hand-Attacke nach rechts
			else {
				return rightAttkAnimation.getCurrentFrame();
			}
		}
		
		//Falls sich der Spieler Stock-Attacke ausfuehrt
		else if(handler.getKeyManager().attack && ( GameState.getActiveAttack() == 2 || LoadState.getActiveAttack() == 2 ) ) {
			
			//Stock-Attacke nach unten
			if(movingDirection == 0)
			{
				return downAttk2Animation.getCurrentFrame();
			}
			
			//Stock-Attacke nach oben
			else if(movingDirection == 1) {
				return upAttk2Animation.getCurrentFrame();
			}
			
			//Stock-Attacke nach links
			else if(movingDirection == 2) {
				return leftAttk2Animation.getCurrentFrame();
			}
			
			//Stock-Attacke nach rechts
			else {
				return rightAttk2Animation.getCurrentFrame();
			}
		}
		
		//Falls der Spieler die Schwert-Attacke ausfuehrt
		else if(handler.getKeyManager().attack && ( GameState.getActiveAttack() == 3 || LoadState.getActiveAttack() == 3 ) ) {
			
			//Schwert-Attacke nach unten
			if(movingDirection == 0)
			{
				return downAttk3Animation.getCurrentFrame();
			}
			
			//Schwert-Attacke nach oben
			else if(movingDirection == 1) {
				return upAttk3Animation.getCurrentFrame();
			}
			
			//Schwert-Attacke nach links
			else if(movingDirection == 2) {
				return leftAttk3Animation.getCurrentFrame();
			}
			
			//Schwert-Attacke nach rechts
			else {
				return rightAttk3Animation.getCurrentFrame();
			}
		}
		
		////Falls der Spieler die Schluessel-Attacke ausfuehrt
		else if(handler.getKeyManager().attack && ( GameState.getActiveAttack() == 4 || LoadState.getActiveAttack() == 4 ) ) {
			
			//Schluessel-Attacke nach unten
			if(movingDirection == 0)
			{
				return downAttk4Animation.getCurrentFrame();
			}
			
			//Schluessel-Attacke nach oben
			else if(movingDirection == 1) {
				return upAttk4Animation.getCurrentFrame();
			}
			
			//Schluessel-Attacke nach links
			else if(movingDirection == 2) {
				return leftAttk4Animation.getCurrentFrame();
			}
			
			//Schluessel-Attacke nach rechts
			else {
				return rightAttk4Animation.getCurrentFrame();
			}
		}
		
		/*
		 * Falls sich der Spieler nicht bewegt und nicht
		 * attackiert, wird die Animation der letzten
		 * Laufrichtung angezeigt
		 */
		else {
			return Assets.mainChar_still[movingDirection];
		}
	}

	/**
	 * Zurueckgabe des Attacken-Inventars des Spielers.
	 * 
	 * @return Attacken-Inventar des Spielers
	 */
	public Inventory getInventory() {
		return inventory;
	}

	/**
	 * Festlegen des Attacken-Inventars des Spielers.
	 * 
	 * @param inventory Attacken-Inventar des Spielers
	 */
	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}

	/**
	 * Zurueckgabe des Nachrichten-Inventars des Spielers.
	 * 
	 * @return Nachrichten-Inventars des Spielers
	 */
	public SheetInventory getSheetInventory() {
		return sheetInventory;
	}

	/**
	 * Festlegen des Nachrichten-Inventars des Spielers.
	 * 
	 * @param sheetInventory Nachrichten-Inventar des Spielers
	 */
	public void setSheetInventory(SheetInventory sheetInventory) {
		this.sheetInventory = sheetInventory;
	}

}
