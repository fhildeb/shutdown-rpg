package dev.shutdown;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import dev.shutdown.display.Gamedisplay;
import dev.shutdown.graphics.Assets;
import dev.shutdown.graphics.GameView;
import dev.shutdown.input.InvMouseManager;
import dev.shutdown.input.KeyManager;
import dev.shutdown.input.MouseManager;
import dev.shutdown.states.CreditsState;
import dev.shutdown.states.GameState;
import dev.shutdown.states.LoadState;
import dev.shutdown.states.MenuState;
import dev.shutdown.states.State;

/**
 * Diese Klasse dient zum Erstellen des eigentlichen Spiel
 * in einem Thread. 
 * 
 * @author Felix Hildebrandt
 *
 */
public class Game implements Runnable {

		//Spiel-Objekte
		private Gamedisplay display;
		private int width, height;
		public String title;
		private Thread process;
		private boolean running = false;
		private BufferStrategy prescreen;
		private Graphics paintbrush;
		private GameView gameView;
		
		//Zustands-Objekte
		public State gameState;
		public State menuState;
		public static State loadState;
		public State creditsState;
		
		//Eingabe-Objekte
		private KeyManager keyManager;
		private MouseManager mouseManager;
		private InvMouseManager invMouseManager;
		
		//Handler
		private static Handler handler;
		
		/**
		 * Es werden die Parameter Spieltitel sowie Breite und Hoehe der
		 * Bildflaeche in Pixel uebergeben. Ebenso werden die Manager
		 * fuer die Benutzereingaben der Tastatur, der Maus und des
		 * Inventars initialisiert.
		 * 
		 * @param title Titel des Spiels
		 * @param width Breite des Spiels in Pixel
		 * @param height Hoehe des Spiels in Pixel
		 */
		public Game(String title, int width, int height){
			
			//Eigenschaften
			this.width = width;
			this.height = height;
			this.title = title;
			
			//Manager
			keyManager = new KeyManager();
			mouseManager = new MouseManager();
			invMouseManager = new InvMouseManager();
		}
		
		/**
		 * Initialisieren des Spiels. Die Bildflaeche wird
		 * erstellt, mit den noetigen Eigenschaften versehen
		 * und auf alle Instanzen der Bildflaeche die Listener fuer
		 * die Benutzereingaben bezueglich der Tasten, der Maus sowie
		 * des Inventars erstellt. 
		 * 
		 * Ebenso werden alle Grafiken ins Spiel geladen und der Handler
		 * und ein Spielausschnitt erstellt. Zuletzt werden alle 
		 * standardmaessig zur Verfuegung stehenden Spiel-Zustaende 
		 * erstellt und der Menue-Zustand als Standard ausewaehlt.
		 */
		private void initialize() {
			
			//Display
			display = new Gamedisplay(title, width, height);
			display.getWindow().addKeyListener(keyManager);
			display.getWindow().addMouseListener(mouseManager);
			display.getWindow().addMouseListener(invMouseManager);
			display.getWindow().addMouseMotionListener(invMouseManager);
			display.getWindow().addMouseMotionListener(mouseManager);
			display.getCanvasScreen().addMouseListener(mouseManager);
			display.getCanvasScreen().addMouseMotionListener(mouseManager);
			display.getCanvasScreen().addMouseListener(invMouseManager);
			display.getCanvasScreen().addMouseMotionListener(invMouseManager);
			
			//Grafik
			Assets.initialize();
			
			//Handler und Spielausschnitt
			handler = new Handler(this);
			gameView = new GameView(handler, 0, 0);
			
			//Spiel-Zustaende
			gameState = new GameState(handler);
			menuState = new MenuState(handler);
			creditsState = new CreditsState(handler);
			
			//Standard-Zustand
			State.setState(menuState);
			
		}

		/**
		 * Generieren eines neuen Spiel-Zustands
		 * innerhalb des Spiels.
		 */
		public static void generateLoadState() {
			loadState = new LoadState(handler);
		}
		
		/**
		 * Aktualisieren des Eingabe-Managers bezueglich
		 * der Tasteneingaben sowie des Spiel-Zustandes.
		 */
		private void tick() {
			keyManager.tick();
			if(State.getState() != null) {
				State.getState().tick();
			}
		}
		
		/**
		 * Rendern der Bildflaeche mit Hilfe von 3 gepufferten
		 * Bildflaechen fuer eine lueckenfreie Uebertragung.
		 * Es werden die vorlaeufigen und die aktuell angezeigte 
		 * Bildflaeche erstellt. Ebenso werden die Displays gezeichnet 
		 * und der aktuelle Display angezeigt.
		 */
		private void render() {
			prescreen = display.getCanvasScreen().getBufferStrategy();
			
			//Falls kein vorlaeufiger Display vorhanden
			if(prescreen == null){
				display.getCanvasScreen().createBufferStrategy(3);
				return;
			}
			//Zeichenvorgang
			paintbrush = prescreen.getDrawGraphics();
			paintbrush.clearRect(0, 0, width, height);
			
			if(State.getState() != null){
				State.getState().render(paintbrush);
			}
			
			//Abschliessen des Zeichenvorgangs
			prescreen.show();
			paintbrush.dispose();
		}
		
		/**
		 * Ausfueren des Spiels bei einer konstanten
		 * Bildwiederholungsrate innerhalb des Threads.
		 */
		public void run(){
			initialize();
			
			int fps = 60;
			double timePerTick = 1000000000 / fps;
			double delta = 0;
			long now;
			long lastTime = System.nanoTime();
			
			while(running) {
				now = System.nanoTime();
				delta += (now - lastTime) / timePerTick;
				lastTime = now;
				
				if(delta >= 1) {
					tick();
					render();
					delta--;
				}
			}
			stopThread();
		}
		
		/**
		 * Sicheres Starten des Spiel-Threads.
		 */
		public synchronized void startThread() {
			if(running)
				return;
			running = true;
			process = new Thread(this);
			process.start();
		}
		
		/**
		 * Sicheres Beenden des Spiel-Threads.
		 */
		public synchronized void stopThread() {
			if(!running)
				return;
			running = false;
			try {
				process.join();
			} catch (InterruptedException e) {
				System.out.println("Fehler beim sichernen Beenden des Spiels");
			}
		}
		
		/**
		 * Zurueckgabe des Managers fuer die
		 * Tastatur-Eingaben.
		 * 
		 * @return	Manager der Tastatur-Eingaben
		 */
		public KeyManager getKeyManager() {
			return keyManager;
		}
		
		/**
		 * Zurueckgabe des Managers fuer die
		 * Maus-Eingaben.
		 * 
		 * @return Manager der Maus-Eingaben
		 */
		public MouseManager getMouseManager() {
			return mouseManager;
		}
		
		/**
		 * Zurueckgabe des Managers fuer die
		 * Inventar-Eingaben.
		 * 
		 * @return 	Manager der Inventar-Eingaben
		 */
		public InvMouseManager getInvMouseManager() {
			return invMouseManager;
		}

		/**
		 * Zurueckgabe des Spielausschnitts welcher
		 * auf der Bildflaeche die Spielwelt anzeigt.
		 * 
		 * @return	Spielausschnitt, welcher die Spielwelt anzeigt
		 */
		public GameView getGameView() {
			return gameView;
		}
		
		/**
		 * Zurueckgabe der Breite der Bildflaeche des Spiels in Pixel.
		 * 
		 * @return 	Breite der Bildflaeche des Spiels in Pixel
		 */
		public int getWidth() {
			return width;
		}
		
		/**
		 * Zurueckgabe der Hoehe der Bildflaeche des Spiels in Pixel.
		 * 
		 * @return	Hoehe der Bildflaeche des Spiels in Pixel
		 */
		public int getHeight() {
			return height;
		}
}
