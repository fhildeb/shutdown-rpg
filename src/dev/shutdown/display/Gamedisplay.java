package dev.shutdown.display;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;

/**
 * Diese Klasse dient zum Erstellen der Bildflaeche des Spiels.
 * 
 * @author Felix Hildebrandt
 *
 */
public class Gamedisplay {

		private JFrame window;
		private Canvas screen;
		private String title;
		private int width, height;
		
		/**
		 * Es werden die Parameter Titel sowie Breite und Hoehe
		 * der Bildflaeche in Pixel uebergeben und
		 * die Bildflaeche samt Inhalt erstellt.
		 * 
		 * @param title Titel der Bildflaeche
		 * @param width Breite der Bildflaeche in Pixel
		 * @param height Hoehe des Bildflaeche in Pixel
		 */
		public Gamedisplay(String title, int width, int height) {
			
			this.title = title;
			this.width = width;
			this.height = height;
			
			createWindow();
		}
		
		/**
		 * Es wird ein neues Fenster erstellt und mit den Eigenschaften bezueglich
		 * Titel, Skalierung, Anzeigbarkeit, relativer Position, Standardaktion beim Schliessen,
		 * Programmsymbol und der Fenstergroesse in Pixeln versehen.
		 * Dannach wird die Bildflaeche erstellt und in das Fenster eingefuegt.
		 */
		private void createWindow() {

			//Einstellen der Eigenschaften des Fensters.
			window = new JFrame(title);
			window.setSize(width, height);
			window.setResizable(false);
			window.setLocationRelativeTo(null);
			window.setVisible(true);
			window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			window.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/textures/layout/Icon.png")));
			
			//Erstellen und Einstellen des Spiel-Bildschirms.
			screen = new Canvas();
			screen.setPreferredSize(new Dimension(width, height));
			screen.setMaximumSize(new Dimension(width, height));
			screen.setMinimumSize(new Dimension(width, height));
			screen.setFocusable(false);
			
			//Einfuegen des Spiel-Bildschirms in das Fenster
			window.add(screen);
			window.pack();
		}
		
		/**
		 * Zurueckgabe der Bildflaeche welche im Fenster angezeigt wird.
		 * 
		 * @return 	Bildflaeche welche im Fenster angezeigt wird
		 */
		public Canvas getCanvasScreen(){
			return screen;
		}
		
		/**
		 * Zurueckgabe des Fensters des Spiels.
		 * 
		 * @return	Fenster des Spiels
		 */
		public JFrame getWindow() {
			return window;
		}
}
