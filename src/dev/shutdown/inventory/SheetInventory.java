package dev.shutdown.inventory;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import dev.shutdown.Handler;
import dev.shutdown.graphics.Assets;
import dev.shutdown.graphics.Text;
import dev.shutdown.items.Sheet;

/**
 * Diese Klasse dient zum Erstellen eines Nachrichten-Verzeichnisses des Spielers um dessen
 * Nachrichten auszuwaehlen und einsehen zu koennen.
 * 
 * @author Felix Hildebrandt
 *
 */
public class SheetInventory {
	
	//Klasse
	private Handler handler;
	private boolean active = true;
	private static ArrayList<Sheet> sheetItems;
	
	//Anzeigen der Textbox der Nachrichten
	private int invMessageX = 466;
	private int invMessageLine1 = 561;
	private int invMessageLine2 = 580;
	private int invMessageLine3 = 600;
	private int invMessageLine4 = 620;
	private int invSlotY = 592;
	private int Slot1 = 48;
	
	//Benutzung des Nachrichten-Verzeichnisses
	public static int selectedSheet;
	public static boolean wannaSee = false;
	
	/**
	 * Dem Nachrichten-Verzeichniss wird ein Handler
	 * zugewieden und eine neue Liste fuer
	 * die Nachrichten erstellt.
	 * 
	 * @param handler Handler des Spiels
	 */
	public SheetInventory(Handler handler) {
		this.handler = handler;
		sheetItems = new ArrayList<Sheet>();
		
	}
	
	/**
	 * Aktualisieren des Nachrichten-Verzeichnisses.
	 */
	public void tick(){
		/*
		 * Die Aktualisierung der ausgewaelten Nachrichten wird
		 * ueber die Benutzeroeberflaeche gesteuert
		 */
	}
	
	/**
	 * Zurueckgabe eines boolischen Wertes, ob Nachrichten-Verzeichnis 
	 * angezeigt wird.
	 * 
	 * @return Boolischer Wert, ob Nachrichten-Verzeichis angezeigt wird.
	 */
	public boolean isActive() {
		return active;
	}

	/**
	 * Zeichnen des Nachrichten-Verzeichnisses auf die Bildflaeche.
	 * 
	 * @param paintbrush Bildflaeche
	 */
	public void render(Graphics paintbrush) {
		
		//Keine Anzeige, falls Nachrichten-Verzeichnis nicht aktiv ist
		if(!active)
			return;
		
		//Zeichen des Layouts des Nachrichten-Verzeichnisses
		paintbrush.drawImage(Assets.sheetinventory_default, 0, 0, 960 , 672, null );
		
		//Laenge des Nachrichten-Verzeichnisses ermitteln
		int lengthItems = sheetItems.size();
		int newselect = 0;
		
		//Falls Verzeichis leer
		if (lengthItems == 0)
			return;
		
		/*
		 * Falls Gegenstaende im Inventar groesser oder kleiner als die
		 * gegebene Nachrichten-Verzeichnislaenge sind, ueberspringen
		 */
		for(int i =  0; i < 8; i++) {
			if(selectedSheet + i < 0 || selectedSheet + i >=lengthItems)
				continue;
		}
		
		//Iteration durch alle Nachrichten
		for(int a = sheetItems.size(); a > 0; a--) {
		
			Sheet sheet = sheetItems.get(newselect);
			
			//Bild der Nachricht zeichen
			paintbrush.drawImage(sheet.getTexture(), Slot1 + (newselect*16) + (newselect*32) , invSlotY , null);
			newselect = newselect +1;

			//Textbox der vorherig angezeigten Nachricht leeren
			paintbrush.setColor(Color.decode("#0d3b1c"));
			paintbrush.fillRect(462, 544, 450, 80);
			
			//Textbox der aktuellen Nachricht zeichen
			if(wannaSee == false)
				continue;
			Text.drawString(paintbrush, sheetItems.get(selectedSheet).getName(), invMessageX,  invMessageLine1, false, Color.WHITE, Assets.starmapInv);
			Text.drawString(paintbrush, sheetItems.get(selectedSheet).getLine2(), invMessageX,  invMessageLine2, false, Color.LIGHT_GRAY, Assets.starmapInv);
			Text.drawString(paintbrush, sheetItems.get(selectedSheet).getLine3() , invMessageX,  invMessageLine3, false, Color.LIGHT_GRAY, Assets.starmapInv);
			Text.drawString(paintbrush, sheetItems.get(selectedSheet).getLine4(), invMessageX,  invMessageLine4, false, Color.LIGHT_GRAY, Assets.starmapInv);
		
		}
	}
	
	/**
	 * Hinzufuegen von neuen Nachrichten zum 
	 * Nachrichten-Verzeichnis.
	 * 
	 * @param sheet Nachricht welche zum Inventar hinzugefuegt werden soll
	 */
	public static void addSheet(Sheet sheet) {
		for(Sheet s : sheetItems) {
			if(s.getId() == sheet.getId()) {
				s.setCount(s.getCount() + sheet.getCount());
				return;
			}
		}
		sheetItems.add(sheet);
	}
	
	/**
	 * Zurueckgabe des Handlers des Nachrichten-Verzeichnisses.
	 * 
	 * @return Handler des Nachrichten-Verzeichnisses
	 */
	public Handler getHandler() {
		return handler;
	}

	/**
	 * Festlegen des Handlers des Nachrichten-Verzeichnisses.
	 * 
	 * @param handler Handler des Nachrichten-Verzeichnisses
	 */
	public void setHandler(Handler handler) {
		this.handler = handler;
	}

	/**
	 * Zurueckgabe aller Nachrichten im Nachrichten-Verzeichnis.
	 * 
	 * @return Nachrichten im Nachrichten-Verzeichnis
	 */
	public static ArrayList<Sheet> getSheetItems() {
		return sheetItems;
	}

	/**
	 * Zurueckgabe der ausgewaelten Nachricht im
	 * Nachrichten-Verzeichnis.
	 * 
	 * @return ausgewaelte Nachricht im Nachrichten-Verzeichniss
	 */
	public static int getSelectedSheet() {
		return selectedSheet;
	}

	/**
	 * Festlegen der ausgewaelten Nachricht im
	 * Nachrichten-Verzeichnis.
	 * 
	 * @param selectedSheet Nachricht welche ausgewaelt werden soll
	 */
	public static void setSelectedSheet(int selectedSheet) {
		SheetInventory.selectedSheet = selectedSheet;
	}

	/**
	 * Zurueckgabe eines boolischen Wertes, ob das Nachrichten-Verzeichnis
	 * angezeigt werden soll.
	 * 
	 * @return Boolischer Wert ob Nachrichten-Verzeichis angezeigt werden soll
	 */
	public static boolean isWannaSee() {
		return wannaSee;
	}

	/**
	 * Festlegen eines boolischen Wertes, ob das Nachrichten-Verzeichnis
	 * angezeigt werden soll.
	 * 
	 * @param wannaSee Boolischer Wert ob Nachrichten-Verzeichnis angezeigt werden soll
	 */
	public static void setWannaSee(boolean wannaSee) {
		SheetInventory.wannaSee = wannaSee;
	}
}
