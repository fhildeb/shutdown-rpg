package dev.shutdown.inventory;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import dev.shutdown.Handler;
import dev.shutdown.graphics.Assets;
import dev.shutdown.graphics.Text;
import dev.shutdown.items.Sheet;

/**
 * Diese Klasse dient zum Erstellen des Nachrichtenfensters in
 * welchem die Volltexte der gesammelten Nachrichten
 * angezeigt werden.
 * 
 * @author Felix Hildebrandt
 *
 */
public class SheetBox {

	//Zeilen der Nachrichtenbox
	private int sheetBoxMessageX = 105;
	private int sheetBoxMessageLine1 = 115;
	private int sheetBoxMessageLine2 = 135;
	private int sheetBoxMessageLine3 = 155;
	private int sheetBoxMessageLine4 = 175;
	private int sheetBoxMessageLine5 = 195;
	private int sheetBoxMessageLine6 = 215;
	private int sheetBoxMessageLine7 = 235;
	private int sheetBoxMessageLine8 = 255;
	private int sheetBoxMessageLine9 = 275;
	private int sheetBoxMessageLine10 = 295;
	private int sheetBoxMessageLine11 = 315;
	private int sheetBoxMessageLine12 = 335;
	private int sheetBoxMessageLine13 = 355;
	private int sheetBoxMessageLine14 = 375;
	private int sheetBoxMessageLine15 = 395;
	private int sheetBoxMessageLine16 = 415;
	private int sheetBoxMessageLine17 = 435;

	//Allgemeines
	private Handler handler;
	private boolean active = false;
	
	/**
	 * Der Nachrichtenbox wird der Handler zugewiesen.
	 * 
	 * @param handler Handler des Spiels
	 */
	public SheetBox(Handler handler) {
	
		this.handler = handler;
	}
	
	/**
	 * Aktualsisieren der Nachrichtenbox.
	 */
	public void tick() {
		
		//Aus und Einblenden der Nachrichtenbox
		if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_E))
			active = !active;
		
		//Keine Aktualisierung wenn das Inventar nicht angezeigt wird
		if(!active)
			return;
		
	}
	
	/**
	 * Zeichenen der Nachrichtenbox auf die Bildflaeche
	 * und Einfuegen der Nachrichtenzeilen der ausgewaehlten
	 * Nachricht.
	 * 
	 * @param paintbrush Bildflaeche
	 */
	public void render(Graphics paintbrush) {
		
		//Kein Anzeigen falls Nachrichtenbox nicht aktiv
		if(!active)
			return;
		
		//Layout der Nachrichtenbox zeichen
		paintbrush.drawImage(Assets.sheetBox, 80, 80, 800, 384, null);
		
		//Falls Anzeige aktiv
		if(SheetInventory.wannaSee == true) {
			int selectedSheet = SheetInventory.getSelectedSheet();
			ArrayList<Sheet> sheetItems;
			sheetItems = SheetInventory.getSheetItems();
			
			//Zeichen der einzelnen Zeilen
			Text.drawString(paintbrush, sheetItems.get(selectedSheet).getTline1(), sheetBoxMessageX, sheetBoxMessageLine1, false, Color.YELLOW, Assets.starmapSheet);
			Text.drawString(paintbrush, sheetItems.get(selectedSheet).getTline2(), sheetBoxMessageX, sheetBoxMessageLine2, false, Color.white, Assets.starmapSheet);
			Text.drawString(paintbrush, sheetItems.get(selectedSheet).getTline3(), sheetBoxMessageX, sheetBoxMessageLine3, false, Color.BLACK, Assets.starmapSheet);
			Text.drawString(paintbrush, sheetItems.get(selectedSheet).getTline4(), sheetBoxMessageX, sheetBoxMessageLine4, false, Color.white, Assets.starmapSheet);
			Text.drawString(paintbrush, sheetItems.get(selectedSheet).getTline5(), sheetBoxMessageX, sheetBoxMessageLine5, false, Color.white, Assets.starmapSheet);
			Text.drawString(paintbrush, sheetItems.get(selectedSheet).getTline6(), sheetBoxMessageX, sheetBoxMessageLine6, false, Color.white, Assets.starmapSheet);
			Text.drawString(paintbrush, sheetItems.get(selectedSheet).getTline7(), sheetBoxMessageX, sheetBoxMessageLine7, false, Color.white, Assets.starmapSheet);
			Text.drawString(paintbrush, sheetItems.get(selectedSheet).getTline8(), sheetBoxMessageX, sheetBoxMessageLine8, false, Color.white, Assets.starmapSheet);
			Text.drawString(paintbrush, sheetItems.get(selectedSheet).getTline9(), sheetBoxMessageX, sheetBoxMessageLine9, false, Color.white, Assets.starmapSheet);
			Text.drawString(paintbrush, sheetItems.get(selectedSheet).getTline10(), sheetBoxMessageX, sheetBoxMessageLine10, false, Color.white, Assets.starmapSheet);
			Text.drawString(paintbrush, sheetItems.get(selectedSheet).getTline11(), sheetBoxMessageX, sheetBoxMessageLine11, false, Color.white, Assets.starmapSheet);
			Text.drawString(paintbrush, sheetItems.get(selectedSheet).getTline12(), sheetBoxMessageX, sheetBoxMessageLine12, false, Color.white, Assets.starmapSheet);
			Text.drawString(paintbrush, sheetItems.get(selectedSheet).getTline13(), sheetBoxMessageX, sheetBoxMessageLine13, false, Color.white, Assets.starmapSheet);
			Text.drawString(paintbrush, sheetItems.get(selectedSheet).getTline14(), sheetBoxMessageX, sheetBoxMessageLine14, false, Color.white, Assets.starmapSheet);
			Text.drawString(paintbrush, sheetItems.get(selectedSheet).getTline15(), sheetBoxMessageX, sheetBoxMessageLine15, false, Color.white, Assets.starmapSheet);
			Text.drawString(paintbrush, sheetItems.get(selectedSheet).getTline16(), sheetBoxMessageX, sheetBoxMessageLine16, false, Color.BLACK, Assets.starmapSheet);
			Text.drawString(paintbrush, sheetItems.get(selectedSheet).getTline17(), sheetBoxMessageX, sheetBoxMessageLine17, false, Color.BLACK, Assets.starmapSheet);
			
		}
	}

	/**
	 * Zurueckgabe eines boolischen Werts, ob Nachrichtenbox 
	 * angezeigt wird.
	 * 
	 * @return Boolischer Wert, ob Nachrichtenbox angezeigt wird
	 */
	public boolean isActive() {
		return active;
	}

	/**
	 * Zurueckgabe des Handlers der Nachrichtenbox.
	 * 
	 * @return Handler der Nachrichtenbox
	 */
	public Handler getHandler() {
		return handler;
	}

	/**
	 * Festlegen des Handlers der Nachrichtenbox.
	 * 
	 * @param handler Handler der Nachrichtenbox
	 */
	public void setHandler(Handler handler) {
		this.handler = handler;
	}
}
