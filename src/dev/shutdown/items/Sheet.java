package dev.shutdown.items;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import dev.shutdown.Handler;
import dev.shutdown.graphics.Assets;
import dev.shutdown.inventory.SheetInventory;
import dev.shutdown.maps.Maps;

/**
 * Diese Klasse dient zum Erstellen von Nachrichten welche
 * vom Spieler in das Nachrichten-Verzeichnis aufgenommen werden koennen 
 * um sie als Volltext lesen zu koennen.
 * 
 * @author Felix Hildebrandt
 *
 */
public class Sheet {

	//Handler
	public static Sheet[] sheets = new Sheet[256];
	protected Handler handler;
	
	//Nachrichten
	public static Sheet paperSheet1 = new Sheet(Assets.paper_sheet_1, "First message",
			"",
			"Press E to access the message box and",
			"read the full text of this message.", 
			"7:00 a.m., Sunday", 
			"", 
			"Message Number One",
			"",
			"Hello Bob,",
			"",
			"don't worry about me. I just want a little time",
			"to myself. I'm heading towards the swamp and", 
			"I'm going to explore nature.", 
			"Everything is so stressful at the moment, I'm looking for peace", 
			"and quiet. You don't need to follow me, I will be back home by", 
			"tonight. Maybe you will find my father on the way", 
			"then you can tell him the destination of my trip.", 
			"See you later!", 
			"", 
			"signed", 
			"Alice", 
			0);
	
	public static Sheet paperSheet2 = new Sheet(Assets.paper_sheet_2, "Second message",
			"",
			"Press E to access the message box and",
			"read the full text of this message.", 
			"9:00 a.m., Sunday", 
			"", 
			"Message Number Two",
			"",
			"Hello inner child,",
			"",
			"I just spent the last two hours here at the lake.",
			"When you look at the water for so long,", 
			"you get quite thoughtful.", 
			"How freely the fish can move in the water-", 
			"without having to worry about their lives and their problems.", 
			"We as humans have much more burdens on our shoulders.", 
			"At least there are days like today when", 
			"you can relax.", 
			"", 
			"signed", 
			"Alice", 
			1);
	
	public static Sheet paperSheet3 = new Sheet(Assets.paper_sheet_3, "Third message",
			"",
			"Press E to access the message box and",
			"read the full text of this message.", 
			"11:00 a.m., Sunday", 
			"", 
			"Message Number Three",
			"",
			"Hello inner drive,",
			"",
			"I am now on the other side of the pond.",
			"See that row of strong sea leaves there? I have", 
			"arranged them! Let's see... surely the work will ", 
			"be undone already in the next storm. Everything is", 
			"so forgettable and our work is so tiny that only", 
			"in large communities it has any effect at all.", 
			"Isn't that depressing when you're all alone? It feels", 
			"like you're going around in circles all the time.", 
			"", 
			"signed", 
			"Alice",
			2);
	
	public static Sheet paperSheet4 = new Sheet(Assets.paper_sheet_4, "Fourth message",
			"",
			"Press E to access the message box and",
			"read the full text of this message.", 
			"1:00 p.m., Sunday", 
			"", 
			"Message Number Four",
			"",
			"Hello encapsulated mind,",
			"",
			"I'm almost at the swamp now, but I've stopped",
			"for a while on the stump. Apparently a", 
			"tree died here recently. I don't think anyone cared,", 
			"otherwise the stump would have been cleared away long ago.", 
			"", 
			"It's becoming more and more clear to me, how little people", 
			"care about other things than themselves-", 
			"how awful", 
			"", 
			"signed", 
			"Alice",
			3);
	
	public static Sheet paperSheet5 = new Sheet(Assets.paper_sheet_5, "Fifth message",
			"",
			"Press E to access the message box and",
			"read the full text of this message.", 
			"3:00 p.m., Sunday", 
			"", 
			"Message Number Five",
			"",
			"Dear old friends,",
			"",
			"should you still be following me, please turn around.",
			"", 
			"You won't believe what I found under the tree trunk!", 
			"However, it will remain my secret.", 
			"I'll tell you tonight at the most, when I'm back.", 
			"The subject makes me think a lot right now", 
			"... about my life.", 
			"Thank you for being there!", 
			"", 
			"gez.", 
			"Alice",
			4);
	
	public static Sheet paperSheet6 = new Sheet(Assets.paper_sheet_6, "Sixth message",
			"",
			"Press E to access the message box and",
			"read the full text of this message.", 
			"5:00 p.m., Sunday", 
			"", 
			"Message Number Six",
			"",
			"To a lost soul,",
			"",
			"It's already 5:00 p.m. and getting dark",
			"I don't feel like going back to the city at all.", 
			"I'll just stay out here.", 
			"Whoever is reading this:", 
			"What problems got you so far out of town?", 
			"PS: I found the perfect remedy to deal with any problem.", 
			"Eventually, I'll leave it to you.", 
			"Just keep walking south towards the plants.", 
			"", 
			"signed", 
			"Alice",
			5);
	
	public static Sheet paperSheet7 = new Sheet(Assets.paper_sheet_7, "Seventh message",
			"",
			"Press E to access the message box and",
			"read the full text of this message.", 
			"7:00 p.m., Sunday", 
			"", 
			"Message Number Seven",
			"",
			"To a very lost soul,",
			"",
			"It's east from here, if you want to solve",
			"your problems the same way I do.", 
			"Behind all the old stacked trunks", 
			"is a secret meadow with a big cave.", 
			"Just the place to do whatever it is you want to do undisturbed.", 
			"Don't you think such retreats are the best?", 
			"Well, at least they're better than all the", 
			"other nonsense going on in the world, right?", 
			"", 
			"signed", 
			"Alice",
			6);
	
	public static Sheet paperSheet8 = new Sheet(Assets.paper_sheet_8, "Eighth message",
			"",
			"Press E to access the message box and",
			"read the full text of this message.", 
			"11:00 p.m., Sunday", 
			"", 
			"Message Number Eight",
			"",
			"To a very very lost soul,",
			"",
			"Now is the time to tell you about my plan.",
			"I found a gun in the swamp. It is fully loaded.", 
			"Isn't it the perfect tool to get rid of all bad?", 
			"In any case, I will need only one of the bullets.", 
			"I'll leave the rest to others who will come", 
			"across the swamp.", 
			"...", 
			"Bye.", 
			"", 
			"signed one last time from", 
			"Alice",
			7);
	
	//Klasse
	public static final int SHEETWIDTH = 32, SHEETHEIGHT = 32;
	protected BufferedImage texture;
	
	//Beschreibungsbox
	protected String name;
	protected String line2;
	protected String line3;
	protected String line4;
	
	//Nachrichtenbox
	protected String tline1;
	protected String tline2;
	protected String tline3;
	protected String tline4;
	protected String tline5;
	protected String tline6;
	protected String tline7;
	protected String tline8;
	protected String tline9;
	protected String tline10;
	protected String tline11;
	protected String tline12;
	protected String tline13;
	protected String tline14;
	protected String tline15;
	protected String tline16;
	protected String tline17;
	
	//Eigenschaften
	protected final int id;
	protected Rectangle boundBox;
	protected int x, y, count;
	protected boolean pickedUp = false;
	
	/**
	 * Es wird jeder Nachricht eine Textur, deren Name, eine
	 * Identifikationsnummer und deren Inhalt der Text- sowie
	 * Nachrichtenbox zugewiesen. Ausserdem wird fuer jede
	 * Nachricht deren Menge und eine neue Kollisionsbox hinzugefuegt.
	 * 
	 * @param texture Textur der Nachricht
	 * @param name Name der Nachricht
	 * @param line2 Text in der Textbox Zeile 2
	 * @param line3 Text in der Textbox Zeile 3
	 * @param line4 Text in der Textbox Zeile 4
	 * @param tline1 Text in Zeile 1 der Nachricht
	 * @param tline2 Text in Zeile 2 der Nachricht
	 * @param tline3 Text in Zeile 3 der Nachricht
	 * @param tline4 Text in Zeile 4 der Nachricht
	 * @param tline5 Text in Zeile 5 der Nachricht
	 * @param tline6 Text in Zeile 6 der Nachricht
	 * @param tline7 Text in Zeile 7 der Nachricht
	 * @param tline8 Text in Zeile 8 der Nachricht
	 * @param tline9 Text in Zeile 9 der Nachricht
	 * @param tline10 Text in Zeile 10 der Nachricht
	 * @param tline11 Text in Zeile 11 der Nachricht
	 * @param tline12 Text in Zeile 12 der Nachricht
	 * @param tline13 Text in Zeile 13 der Nachricht
	 * @param tline14 Text in Zeile 14 der Nachricht
	 * @param tline15 Text in Zeile 15 der Nachricht
	 * @param tline16 Text in Zeile 16 der Nachricht
	 * @param tline17 Text in Zeile 17 der Nachricht
	 * @param id Identifikationsnummer der Nachricht
	 */
	public Sheet(BufferedImage texture, String name, 	String line2, 
										String line3, 	String line4, 	
										String tline1, 	String tline2,
										String tline3, 	String tline4,
										String tline5, 	String tline6,
										String tline7, 	String tline8,
										String tline9, 	String tline10,
										String tline11, String tline12,
										String tline13,	String tline14,
										String tline15,	String tline16,
										String tline17,	int id) {
		this.texture = texture;
		this.name = name;
		
		this.line2 = line2;
		this.line3 = line3;
		this.line4 = line4;
		
		this.tline1 = tline1;
		this.tline2 = tline2;
		this.tline3 = tline3;
		this.tline4 = tline4;
		this.tline5 = tline5;
		this.tline6 = tline6;
		this.tline7 = tline7;
		this.tline8 = tline8;
		this.tline9 = tline9;
		this.tline10 = tline10;
		this.tline11 = tline11;
		this.tline12 = tline12;
		this.tline13 = tline13;
		this.tline14 = tline14;
		this.tline15 = tline15;
		this.tline16 = tline16;
		this.tline17 = tline17;
		
		this.id = id;
		count = 1;
		
		//Kollisionsbox
		boundBox = new Rectangle(x, y, SHEETWIDTH, SHEETHEIGHT);
		
		sheets[id] = this;
	}
	
	/**
	 * Aktualisieren der Nachrichten im Nachrichten-Verzeichnis.
	 */
	public void tick() {
		handler.getMap();
		if(Maps.getEntityManager().getPlayer().getCollisionBoxes(0f, 0f).intersects(boundBox)) {
			pickedUp = true;
			handler.getMap();
			Maps.getEntityManager().getPlayer().getSheetInventory();
			SheetInventory.addSheet(this);
		}
	}
	
	/**
	 * Zeichnen der Nachricht auf die Bildflaeche mit einer
	 * Grafikkomponente als Parameter.
	 * 
	 * @param paintbrush Bildflaeche
	 */
	public void render(Graphics paintbrush) {
		if(handler == null)
			return;
		
		render(paintbrush, (int) (x - handler.getGameView().getxOffSet()),(int) (y - handler.getGameView().getyOffSet()));
	}
	
	/**
	 * Zeichnen der Nachricht auf die Bildflaeche mit einer 
	 * Grafikkomponente sowie einer X- und Y-Position als Parameter.
	 * 
	 * @param paintbrush Bildflaeche
	 * @param x Position auf der X-Achse der Bildflaeche in Pixel
	 * @param y Position auf der Y-Achse der Bildflaeche in Pixel
	 */
	public void render(Graphics paintbrush, int x, int y) {
		paintbrush.drawImage(texture, x, y, SHEETWIDTH, SHEETHEIGHT, null);
	}

	/**
	 * Einen neue Nachricht vom gleichen Typ mit einer Anzahl
	 * auf der Spielwelt erstellen.
	 * 
	 * @param count Anzahl der Nachrichten
	 * 
	 * @return hinzugefuegte Nachricht
	 */
	public Sheet createNew(int count) {
		Sheet s = new Sheet(texture, name, line2, line3, line4,
							tline1, tline2, tline3, tline4, tline5, tline6,
							tline7, tline8, tline9, tline10, tline11, tline12,
							tline13, tline14, tline15, tline16, tline17, id);
		s.setPickedUp(true);
		s.setCount(count);
		return s;
	}
	
	/**
	 * Eine neue Nachricht vom gleichen Typ mit einer X- und Y- Position
	 * in Pixel auf der Spielwelt erstellen.
	 * 
	 * @param x Position der X-Achse auf der Spielwelt in Pixel
	 * @param y Position der Y-Achse auf der Spielwelt in Pixel
	 * 
	 * @return erstellte Nachricht
	 */
	public Sheet createNew(int x, int y) {
		Sheet s = new Sheet(texture, name, line2, line3, line4,
							tline1, tline2, tline3, tline4, tline5, tline6,
							tline7, tline8, tline9, tline10, tline11, tline12,
							tline13, tline14, tline15, tline16, tline17, id);
		s.setPosition(x, y);
		return s;
	}
	
	/**
	 * Festlegen der Position der Nachricht auf der Spielwelt.
	 * 
	 * @param x Position der X-Achse auf der Spielwelt in Pixel
	 * @param y Position der Y-Achse auf der Spielwelt in Pixel
	 */
	public void setPosition(int x, int y) {
		this.x = x;
		this.y = y;
		boundBox.x = x;
		boundBox.y = y;
	}
	
	/**
	 * Zurueckgabe des Handlers der Nachricht.
	 * 
	 * @return Handler der Nachricht
	 */
	public Handler getHandler() {
		return handler;
	}

	/**
	 * Festlegen des Handlers der Nachricht.
	 * 
	 * @param handler Handler der Nachricht
	 */
	public void setHandler(Handler handler) {
		this.handler = handler;
	}

	/**
	 * Zurueckgabe der Grafik der Nachricht.
	 * 
	 * @return Grafik der Nachricht
	 */
	public BufferedImage getTexture() {
		return texture;
	}

	/**
	 * Festlegen der Grafik der Nachricht.
	 * 
	 * @param texture Grafik der Nachricht
	 */
	public void setTexture(BufferedImage texture) {
		this.texture = texture;
	}

	/**
	 * Zurueckgabe des Namen der Nachricht.
	 * 
	 * @return Name der Nachricht
	 */
	public String getName() {
		return name;
	}

	/**
	 * Festlegen des Namens der Nachricht.
	 * 
	 * @param name Name der Nachricht
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Zurueckgabe der Position der Nachricht auf der X-Achse der Spielwelt in Pixel.
	 * 
	 * @return Position der Nachricht auf der X-Achse der Spielwelt in Pixel
	 */
	public int getX() {
		return x;
	}

	/**
	 * Festlegen der Position der Nachricht auf der X-Achse der Spielwelt in Pixel.
	 * 
	 * @param x Position der Nachricht auf der X-Achse der Spielwelt in Pixel
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * Zurueckgabe der Position der Nachricht auf der Y-Achse der Spielwelt in Pixel.
	 * 
	 * @return Position der Nachricht auf der Y-Achse der Spielwelt in Pixel
	 */
	public int getY() {
		return y;
	}

	/**
	 * Festlegen der Position der Nachricht auf der Y-Achse der Spielwelt in Pixel.
	 * 
	 * @param y Position der Nachricht auf der Y-Achse der Spielwelt in Pixel
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * Zurueckgabe der Anzahl einer Nachricht.
	 * 
	 * @return Anzahl der Nachricht
	 */
	public int getCount() {
		return count;
	}

	/**
	 * Festlegen der Anzahl einer Nachricht.
	 * 
	 * @param count Anzahl der Nachricht
	 */
	public void setCount(int count) {
		this.count = count;
	}

	/**
	 * Zurueckgabe der Identifikationsnummer einer Nachricht.
	 * 
	 * @return Identifikationsnummer der Nachricht
	 */
	public int getId() {
		return id;
	}

	/**
	 * Zurueckgabe eines boolischen Wertes, ob Nachricht aufgehoben wurde.
	 * 
	 * @return Boolischer Wert, ob Nachricht aufgehoben wurde
	 */
	public boolean isPickedUp() {
		return pickedUp;
	}

	/**
	 * Festlegen eines boolischen Wertes ob Nachricht aufgehoben wurde.
	 * 
	 * @param pickedUp Booischer Wert, ob Nachricht aufgehoben wurde
	 */
	public void setPickedUp(boolean pickedUp) {
		this.pickedUp = pickedUp;
	}

	/**
	 * Zurueckgabe der zweiten Zeile der Textbox der Nachricht.
	 * 
	 * @return zweite Zeile der Textbox der Nachricht
	 */
	public String getLine2() {
		return line2;
	}

	/**
	 * Festlegen der zweiten Zeile der Textbox der Nachricht.
	 * 
	 * @param line2 zweite Zeile der Textbox der Nachricht
	 */
	public void setLine2(String line2) {
		this.line2 = line2;
	}

	/**
	 * Zurueckgabe der dritte Zeile der Textbox der Nachricht.
	 * 
	 * @return dritte Zeile der Textbox der Nachricht
	 */
	public String getLine3() {
		return line3;
	}

	/**
	 * Festlegen der dritten Zeile der Textbox der Nachricht.
	 * 
	 * @param line3 dritte Zeile der Textbox der Nachricht
	 */
	public void setLine3(String line3) {
		this.line3 = line3;
	}

	/**
	 * Zurueckgabe der vierten Zeile der Textbox der Nachricht.
	 * 
	 * @return vierte Zeile der Textbox der Nachricht
	 */
	public String getLine4() {
		return line4;
	}

	/**
	 * Festlegen der vierten Zeile der Textbox der Nachricht.
	 * 
	 * @param line4 vierte Zeile der Textbox der Nachricht
	 */
	public void setLine4(String line4) {
		this.line4 = line4;
	}

	/**
	 * Zurueckgabe der ersten Zeile der Nachricht.
	 * 
	 * @return erste Zeile der Nachricht
	 */
	public String getTline1() {
		return tline1;
	}

	/**
	 * Festlegen der ersten Zeile der Nachricht.
	 * 
	 * @param tline1 erste Zeile der Nachricht
	 */
	public void setTline1(String tline1) {
		this.tline1 = tline1;
	}

	/**
	 * Zurueckgabe der zweiten Zeile der Nachricht.
	 * 
	 * @return zweite Zeile der Nachricht
	 */
	public String getTline2() {
		return tline2;
	}

	/**
	 * Festlegen der zweiten Zeile der Nachricht.
	 * 
	 * @param tline2 zweite Zeile der Nachricht
	 */
	public void setTline2(String tline2) {
		this.tline2 = tline2;
	}

	/**
	 * Zurueckgabe der dritten Zeile der Nachricht.
	 * 
	 * @return dritte Zeile der Nachricht
	 */
	public String getTline3() {
		return tline3;
	}

	/**
	 * Festlegen der dritten Zeile der Nachricht.
	 * 
	 * @param tline3 dritte Zeile der Nachricht
	 */
	public void setTline3(String tline3) {
		this.tline3 = tline3;
	}

	/**
	 * Zurueckgabe der vierten Zeile der Nachricht.
	 * 
	 * @return vierte Zeile der Nachricht
	 */
	public String getTline4() {
		return tline4;
	}

	/**
	 * Festlegen der vierten Zeile der Nachricht.
	 * 
	 * @param tline4 vierte Zeile der Nachricht
	 */
	public void setTline4(String tline4) {
		this.tline4 = tline4;
	}

	/**
	 * Zurueckgabe der fuenf Zeile der Nachricht.
	 * 
	 * @return fuenf Zeile der Nachricht
	 */
	public String getTline5() {
		return tline5;
	}

	/**
	 * Festlegen der fuenften Zeile der Nachricht.
	 * 
	 * @param tline5 fuenfte Zeile der Nachricht
	 */
	public void setTline5(String tline5) {
		this.tline5 = tline5;
	}

	/**
	 * Zurueckgabe der sechsten Zeile der Nachricht.
	 * 
	 * @return sechsten Zeile der Nachricht
	 */
	public String getTline6() {
		return tline6;
	}

	/**
	 * Festlegen der sechsten Zeile der Nachricht.
	 * 
	 * @param tline6 sechste Zeile der Nachricht
	 */
	public void setTline6(String tline6) {
		this.tline6 = tline6;
	}

	/**
	 * Zurueckgabe der siebenter Zeile der Nachricht.
	 * 
	 * @return siebente Zeile der Nachricht
	 */
	public String getTline7() {
		return tline7;
	}

	/**
	 * Festlegen der siebenten Zeile der Nachricht.
	 * 
	 * @param tline7 siebente Zeile der Nachricht
	 */
	public void setTline7(String tline7) {
		this.tline7 = tline7;
	}

	/**
	 * Zurueckgabe der achten Zeile der Nachricht.
	 * 
	 * @return achte Zeile der Nachricht
	 */
	public String getTline8() {
		return tline8;
	}

	/**
	 * Festlegen der achten Zeile der Nachricht.
	 * 
	 * @param tline8 achte Zeile der Nachricht
	 */
	public void setTline8(String tline8) {
		this.tline8 = tline8;
	}

	/**
	 * Zurueckgabe der neunten Zeile der Nachricht.
	 * 
	 * @return neunte Zeile der Nachricht
	 */
	public String getTline9() {
		return tline9;
	}

	/**
	 * Festlegen der neunten Zeile der Nachricht.
	 * 
	 * @param tline9 neunte Zeile der Nachricht
	 */
	public void setTline9(String tline9) {
		this.tline9 = tline9;
	}

	/**
	 * Zurueckgabe der zehnten Zeile der Nachricht.
	 * 
	 * @return zehnten Zeile der Nachricht
	 */
	public String getTline10() {
		return tline10;
	}

	/**
	 * Festlegen der zehnten Zeile der Nachricht.
	 * 
	 * @param tline10 zehnte Zeile der Nachricht
	 */
	public void setTline10(String tline10) {
		this.tline10 = tline10;
	}

	/**
	 * Zurueckgabe der elften Zeile der Nachricht.
	 * 
	 * @return elfte Zeile der Nachricht
	 */
	public String getTline11() {
		return tline11;
	}

	/**
	 * Festlegen der elften Zeile der Nachricht.
	 * 
	 * @param tline11 elfte Zeile der Nachricht
	 */
	public void setTline11(String tline11) {
		this.tline11 = tline11;
	}

	/**
	 * Zurueckgabe der zwoelften Zeile der Nachricht.
	 * 
	 * @return zwoelfte Zeile der Nachricht
	 */
	public String getTline12() {
		return tline12;
	}

	/**
	 * Festlegen der zwoelften Zeile der Nachricht.
	 * 
	 * @param tline12 zwoelfte Zeile der Nachricht
	 */
	public void setTline12(String tline12) {
		this.tline12 = tline12;
	}

	/**
	 * Zurueckgabe der dreizehnten Zeile der Nachricht.
	 * 
	 * @return dreizehnte Zeile der Nachricht
	 */
	public String getTline13() {
		return tline13;
	}

	/**
	 * Festlegen der dreizehnten Zeile der Nachricht.
	 * 
	 * @param tline13 dreizehnte Zeile der Nachricht
	 */
	public void setTline13(String tline13) {
		this.tline13 = tline13;
	}

	/**
	 * Zurueckgabe der vierzehnten Zeile der Nachricht.
	 * 
	 * @return vierzehnte Zeile der Nachricht
	 */
	public String getTline14() {
		return tline14;
	}

	/**
	 * Festlegen der vierzehnten Zeile der Nachricht.
	 * 
	 * @param tline14 vierzehnte Zeile der Nachricht
	 */
	public void setTline14(String tline14) {
		this.tline14 = tline14;
	}

	/**
	 * Zurueckgabe der fuenfzehnten Zeile der Nachricht.
	 * 
	 * @return fuenfzehnte Zeile der Nachricht
	 */
	public String getTline15() {
		return tline15;
	}

	/**
	 * Festlegen der fuenfzehnten Zeile der Nachricht.
	 * 
	 * @param tline15 fuenfzehnte Zeile der Nachricht
	 */
	public void setTline15(String tline15) {
		this.tline15 = tline15;
	}

	/**
	 * Zurueckgabe der sechszehnten Zeile der Nachricht.
	 * 
	 * @return sehszehnten Zeile der Nachricht
	 */
	public String getTline16() {
		return tline16;
	}

	/**
	 * Festlegen der sechzehnten Zeile der Nachricht.
	 * 
	 * @param tline16 sechzehnte Zeile der Nachricht
	 */
	public void setTline16(String tline16) {
		this.tline16 = tline16;
	}

	/**
	 * Zurueckgabe der siebzehnten Zeile der Nachricht.
	 * 
	 * @return siebzehnte Zeile der Nachricht
	 */
	public String getTline17() {
		return tline17;
	}

	/**
	 * Festlegen der siebzehnten Zeile der Nachricht.
	 * 
	 * @param tline17 siebzehnte Zeile der Nachricht
	 */
	public void setTline17(String tline17) {
		this.tline17 = tline17;
	}
	
}
