package dev.shutdown;
/**
 * Diese Klasse erstellt und startet das Spiel.
 * 
 * @author Felix Hildebrandt
 *
 */
public class Gamelauncher {
	
		/**
		 * Es wird ein neues Spiel erstellt und dessen
		 * Thread gestartet.
		 * 
		 * @param args Kommandozeilenparameter
		 */
		public static void main(String[] args) {
			Game shutdown = new Game("Shutdown", 960, 672);
			shutdown.startThread();
		}
}
