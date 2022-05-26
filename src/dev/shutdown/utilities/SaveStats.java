package dev.shutdown.utilities;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import dev.shutdown.entities.EntityManager;
import dev.shutdown.entities.statics.BottleGold;
import dev.shutdown.entities.statics.BottleSilver;
import dev.shutdown.entities.statics.Box;
import dev.shutdown.entities.statics.BoxSmall;
import dev.shutdown.entities.statics.ClearTree;
import dev.shutdown.entities.statics.ClearTreeBig;
import dev.shutdown.entities.statics.EntranceClose;
import dev.shutdown.entities.statics.EntranceOpen;
import dev.shutdown.entities.statics.GrassLong;
import dev.shutdown.entities.statics.Hay;
import dev.shutdown.entities.statics.HouseBigBlue;
import dev.shutdown.entities.statics.HouseBigRed;
import dev.shutdown.entities.statics.HouseSmallBlue;
import dev.shutdown.entities.statics.HouseSmallRed;
import dev.shutdown.entities.statics.Key;
import dev.shutdown.entities.statics.Plant;
import dev.shutdown.entities.statics.PlantCube;
import dev.shutdown.entities.statics.RockBrown;
import dev.shutdown.entities.statics.Rocks;
import dev.shutdown.entities.statics.SeaPlant;
import dev.shutdown.entities.statics.SheetBottle1;
import dev.shutdown.entities.statics.SheetBottle2;
import dev.shutdown.entities.statics.SheetBottle3;
import dev.shutdown.entities.statics.SheetBottle4;
import dev.shutdown.entities.statics.SheetBottle5;
import dev.shutdown.entities.statics.SheetBottle6;
import dev.shutdown.entities.statics.SheetBottle7;
import dev.shutdown.entities.statics.SheetBottle8;
import dev.shutdown.entities.statics.ShroomDark;
import dev.shutdown.entities.statics.ShroomLight;
import dev.shutdown.entities.statics.Sword;
import dev.shutdown.entities.statics.Tree;
import dev.shutdown.entities.statics.TreeHigh;
import dev.shutdown.entities.statics.TreeRound;
import dev.shutdown.entities.statics.TreeRoundBig;
import dev.shutdown.entities.statics.Trunk;
import dev.shutdown.entities.statics.TrunkSmall;
import dev.shutdown.inventory.Inventory;
import dev.shutdown.inventory.SheetInventory;
import dev.shutdown.items.Item;
import dev.shutdown.items.Sheet;
import dev.shutdown.maps.Maps;


/**
 * Diese Klasse dient zum Speichern und Laden der im Spielstand
 * gespeicherten Objekte, Items und Standpunkte.
 * 
 * @author Felix Hildebrandt
 *
 */
public class SaveStats {

	public static int PLAYERX;
	public static int PLAYERY;
	
	/**
	 * Speichern der aktuellen Objekte mit deren Positionen, der
	 * Inventar-Gegenstaenden sowie der gesammelten Nachrichten.
	 */
	public void SaveCurrentGame() {
		
		//Erstellen der Files
		File fileName = new File("./saveEntitieName.txt");
		File fileX = new File("./saveEntitieX.txt");
		File fileY = new File("./saveEntitieY.txt");
		File fileItems = new File("./saveInventory.txt");
		File fileSheet = new File("./saveSheet.txt");
		
		//Erstellen von Listen fuer die Objektinformationen
		ArrayList<String> stringlistName = new ArrayList<>();
		ArrayList<Integer> intlistX = new ArrayList<>();
		ArrayList<Integer> intlistY = new ArrayList<>();
		ArrayList<Integer> intlistItems = new ArrayList<>();
		ArrayList<Integer> intlistSheet = new ArrayList<>();
		
		//Aktuelle Objektinformationen einlesen und in die Listen speichern
		for(int i = EntityManager.getEntities().size()-1; i >= 0; i--) {
			String name = EntityManager.getEntities().get(i).getClass().toString();
			int x = (int)EntityManager.getEntities().get(i).getX();
			int y = (int)EntityManager.getEntities().get(i).getY();
			stringlistName.add(name);
			intlistX.add(x);
			intlistY.add(y);
		}

		//Aktuelle Inventarobjekte einlesen und in die Listen speichern
		for(int i = Inventory.getInventoryItems().size()-1; i >= 0; i--) {
			int item = Inventory.getInventoryItems().get(i).getId();
			intlistItems.add(item);
		}
		
		//Aktuelle Nachrichtenobjekte einlesen und in die Listen speichern
		for(int i = SheetInventory.getSheetItems().size()-1; i >= 0; i--) {
			int sheet = SheetInventory.getSheetItems().get(i).getId();
			intlistSheet.add(sheet);
		}
	    
		//Output-Streams fuer die uebermittelten Iinformationen initialisieren
	      ObjectOutputStream oosName =null;
	      ObjectOutputStream oosX =null;
	      ObjectOutputStream oosY =null;
	      ObjectOutputStream oosItem =null;
	      ObjectOutputStream oosSheet =null;
	      
		try {
			//BufferedOutputStreams anlegen
			oosName = new ObjectOutputStream(
				new BufferedOutputStream(
					new FileOutputStream(fileName)));
			oosX = new ObjectOutputStream(
					new BufferedOutputStream(
						new FileOutputStream(fileX)));
			oosY = new ObjectOutputStream(
					new BufferedOutputStream(
						new FileOutputStream(fileY)));
			oosItem = new ObjectOutputStream(
					new BufferedOutputStream(
						new FileOutputStream(fileItems)));
			oosSheet = new ObjectOutputStream(
					new BufferedOutputStream(
						new FileOutputStream(fileSheet)));
			
		} catch (FileNotFoundException e) {
			System.out.println("Datei nicht gefunden");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Fehler beim Erstellen der Datei");
			e.printStackTrace();
		}
		try {
			//Objektinformationen in die Dateien schreiben
			oosName.writeObject(stringlistName);
			oosX.writeObject(intlistX);
			oosY.writeObject(intlistY);
			oosItem.writeObject(intlistItems);
			oosSheet.writeObject(intlistSheet);
		} catch (IOException e) {
			System.out.println("Fehler beim Schreiben in die Datei");
			e.printStackTrace();
		}
		try {
			//Beenden des Schreibvorgangs
			oosName.flush();
			oosX.flush();
			oosY.flush();
			oosItem.flush();
			oosSheet.flush();
		} catch (IOException e) {
			System.out.println("Fehler beim Abschliessen des Schreibvorgangs");
			e.printStackTrace();
		}
	     
		    try {
				oosName.close();
				oosX.close();
				oosY.close();
				oosItem.close();
				oosSheet.close();
			} catch (IOException e) {
				System.out.println("Fehler beim Schliessen der Datei");
				e.printStackTrace();
			}
	    
	}
	
	/**
	 * Laden der gespeicherten Objekte mit deren Positionen, der
	 * Inventar-Gegenstaenden sowie der gesammelten Nachrichten.
	 */
	@SuppressWarnings("unchecked")
	public void LoadPastGame() {
		
		//Erstellen der Listen fuer die Objekteigenschaften
		ArrayList<String> stringlistName = new ArrayList<>();
		ArrayList<Integer> intlistX = new ArrayList<>();
		ArrayList<Integer> intlistY = new ArrayList<>();
		ArrayList<Integer> intlistItems = new ArrayList<>();
		ArrayList<Integer> intlistSheet = new ArrayList<>();
		
		//Erstellen der ObjectInputStreams
	    ObjectInputStream oisName = null;
	    ObjectInputStream oisX = null;
	    ObjectInputStream oisY = null;
	    ObjectInputStream oisItem = null;
	    ObjectInputStream oisSheet = null;
	    
	    try{
	    	FileInputStream fis1 = new FileInputStream("./saveEntitieName.txt");
	    	oisName = new ObjectInputStream(fis1);
			stringlistName =  (ArrayList<String>) oisName.readObject();
				
			FileInputStream fis2 = new FileInputStream("./saveEntitieX.txt");
			oisX = new ObjectInputStream(fis2);
			intlistX =  (ArrayList<Integer>) oisX.readObject();
			
			FileInputStream fis3 = new FileInputStream("./saveEntitieY.txt");
			oisY = new ObjectInputStream(fis3);
			intlistY =  (ArrayList<Integer>) oisY.readObject();
						
			FileInputStream fis4 = new FileInputStream("./saveInventory.txt");
			oisItem = new ObjectInputStream(fis4);
			intlistItems =  (ArrayList<Integer>) oisItem.readObject();
						
			FileInputStream fis5 = new FileInputStream("./saveSheet.txt");
			oisSheet = new ObjectInputStream(fis5);
			intlistSheet =  (ArrayList<Integer>) oisSheet.readObject();
		    }
	    catch (IOException e)
	    {
	    	e.printStackTrace();
		System.out.println("Fehler beim Laden");
	    }
	    catch (ClassNotFoundException e)
	    {
		System.out.println("Fehler beim Casten");
	    }
	    finally
	    {
		try
		{
			//Schliessen der  ObjectInputStreams
		    oisName.close();
		    oisX.close();
		    oisY.close();
		    oisItem.close();
		    oisSheet.close();
		}
		catch(IOException e){
			System.out.println("Fehler beim Schliessen der Dateien");
		}
	    }
	    
	    //Lesen der Eingaben und Hinzufuegen der gespeicherten Objekte zur Spielwelt
	    if(stringlistName != null && intlistX != null && intlistY != null)
	    	{	
	    	 for(int i = stringlistName.size()-1; i >= 0; i--) {
	    		 String[] entitynameArray = stringlistName.get(i).split(" ");
	    		 String entityname = entitynameArray[1];
	    		 int entityX = intlistX.get(i);
	    		 int entityY = intlistY.get(i);
	    		 
	    		 if(entityname.equalsIgnoreCase("dev.shutdown.entities.statics.Barrier")) {
	    			Maps.getEntityManager();
					EntityManager.addEntity( new TrunkSmall(Maps.getHandler(), entityX, entityY));
	    		 }
	    		 else if(entityname.equalsIgnoreCase("dev.shutdown.entities.statics.BottleGold")) {
		    			Maps.getEntityManager();
						EntityManager.addEntity( new BottleGold(Maps.getHandler(), entityX, entityY));
		    		 }
	    		 else if(entityname.equalsIgnoreCase("dev.shutdown.entities.statics.BottleSilver")) {
		    			Maps.getEntityManager();
						EntityManager.addEntity( new BottleSilver(Maps.getHandler(), entityX, entityY));
		    		 }
	    		 else if(entityname.equalsIgnoreCase("dev.shutdown.entities.statics.Box")) {
		    			Maps.getEntityManager();
						EntityManager.addEntity( new Box(Maps.getHandler(), entityX, entityY));
		    		 }
	    		 else if(entityname.equalsIgnoreCase("dev.shutdown.entities.statics.BoxSmall")) {
		    			Maps.getEntityManager();
						EntityManager.addEntity( new BoxSmall(Maps.getHandler(), entityX, entityY));
		    		 }
	    		 else if(entityname.equalsIgnoreCase("dev.shutdown.entities.statics.ClearTree")) {
		    			Maps.getEntityManager();
						EntityManager.addEntity( new ClearTree(Maps.getHandler(), entityX, entityY));
		    		 }
	    		 else if(entityname.equalsIgnoreCase("dev.shutdown.entities.statics.ClearTreeBig")) {
		    			Maps.getEntityManager();
						EntityManager.addEntity( new ClearTreeBig(Maps.getHandler(), entityX, entityY));
		    		 }
	    		 else if(entityname.equalsIgnoreCase("dev.shutdown.entities.statics.EntranceClose")) {
		    			Maps.getEntityManager();
						EntityManager.addEntity( new EntranceClose(Maps.getHandler(), entityX, entityY));
		    		 }
	    		 else if(entityname.equalsIgnoreCase("dev.shutdown.entities.statics.EntranceOpen")) {
		    			Maps.getEntityManager();
						EntityManager.addEntity( new EntranceOpen(Maps.getHandler(), entityX, entityY));
		    		 }
	    		 else if(entityname.equalsIgnoreCase("dev.shutdown.entities.statics.GrassLong")) {
		    			Maps.getEntityManager();
						EntityManager.addEntity( new GrassLong(Maps.getHandler(), entityX, entityY));
		    		 }
	    		 else if(entityname.equalsIgnoreCase("dev.shutdown.entities.statics.Hay")) {
		    			Maps.getEntityManager();
						EntityManager.addEntity( new Hay(Maps.getHandler(), entityX, entityY));
		    		 }
	    		 else if(entityname.equalsIgnoreCase("dev.shutdown.entities.statics.HouseBigBlue")) {
		    			Maps.getEntityManager();
						EntityManager.addEntity( new HouseBigBlue(Maps.getHandler(), entityX, entityY));
		    		 }
	    		 else if(entityname.equalsIgnoreCase("dev.shutdown.entities.statics.HouseBigRed")) {
		    			Maps.getEntityManager();
						EntityManager.addEntity( new HouseBigRed(Maps.getHandler(), entityX, entityY));
		    		 }
	    		 else if(entityname.equalsIgnoreCase("dev.shutdown.entities.statics.HouseSmallBlue")) {
		    			Maps.getEntityManager();
						EntityManager.addEntity( new HouseSmallBlue(Maps.getHandler(), entityX, entityY));
		    		 }
	    		 else if(entityname.equalsIgnoreCase("dev.shutdown.entities.statics.HouseSmallRed")) {
		    			Maps.getEntityManager();
						EntityManager.addEntity( new HouseSmallRed(Maps.getHandler(), entityX, entityY));
		    		 }
	    		 else if(entityname.equalsIgnoreCase("dev.shutdown.entities.statics.Key")) {
		    			Maps.getEntityManager();
						EntityManager.addEntity( new Key(Maps.getHandler(), entityX, entityY));
		    		 }
	    		 else if(entityname.equalsIgnoreCase("dev.shutdown.entities.statics.Plant")) {
		    			Maps.getEntityManager();
						EntityManager.addEntity( new Plant(Maps.getHandler(), entityX, entityY));
		    		 }
	    		 else if(entityname.equalsIgnoreCase("dev.shutdown.entities.statics.PlantCube")) {
		    			Maps.getEntityManager();
						EntityManager.addEntity( new PlantCube(Maps.getHandler(), entityX, entityY));
		    		 }
	    		 else if(entityname.equalsIgnoreCase("dev.shutdown.entities.statics.RockBrown")) {
		    			Maps.getEntityManager();
						EntityManager.addEntity( new RockBrown(Maps.getHandler(), entityX, entityY));
		    		 }
	    		 else if(entityname.equalsIgnoreCase("dev.shutdown.entities.statics.Rocks")) {
		    			Maps.getEntityManager();
						EntityManager.addEntity( new Rocks(Maps.getHandler(), entityX, entityY));
		    		 }
	    		 else if(entityname.equalsIgnoreCase("dev.shutdown.entities.statics.SeaPlant")) {
		    			Maps.getEntityManager();
						EntityManager.addEntity( new SeaPlant(Maps.getHandler(), entityX, entityY));
		    		 }
	    		 else if(entityname.equalsIgnoreCase("dev.shutdown.entities.statics.SheetBottle1")) {
		    			Maps.getEntityManager();
						EntityManager.addEntity( new SheetBottle1(Maps.getHandler(), entityX, entityY));
		    		 }
	    		 else if(entityname.equalsIgnoreCase("dev.shutdown.entities.statics.SheetBottle2")) {
		    			Maps.getEntityManager();
						EntityManager.addEntity( new SheetBottle2(Maps.getHandler(), entityX, entityY));
		    		 }
	    		 else if(entityname.equalsIgnoreCase("dev.shutdown.entities.statics.SheetBottle3")) {
		    			Maps.getEntityManager();
						EntityManager.addEntity( new SheetBottle3(Maps.getHandler(), entityX, entityY));
		    		 }
	    		 else if(entityname.equalsIgnoreCase("dev.shutdown.entities.statics.SheetBottle4")) {
		    			Maps.getEntityManager();
						EntityManager.addEntity( new SheetBottle4(Maps.getHandler(), entityX, entityY));
		    		 }
	    		 else if(entityname.equalsIgnoreCase("dev.shutdown.entities.statics.SheetBottle5")) {
		    			Maps.getEntityManager();
						EntityManager.addEntity( new SheetBottle5(Maps.getHandler(), entityX, entityY));
		    		 }
	    		 else if(entityname.equalsIgnoreCase("dev.shutdown.entities.statics.SheetBottle6")) {
		    			Maps.getEntityManager();
						EntityManager.addEntity( new SheetBottle6(Maps.getHandler(), entityX, entityY));
		    		 }
	    		 else if(entityname.equalsIgnoreCase("dev.shutdown.entities.statics.SheetBottle7")) {
		    			Maps.getEntityManager();
						EntityManager.addEntity( new SheetBottle7(Maps.getHandler(), entityX, entityY));
		    		 }
	    		 else if(entityname.equalsIgnoreCase("dev.shutdown.entities.statics.SheetBottle8")) {
		    			Maps.getEntityManager();
						EntityManager.addEntity( new SheetBottle8(Maps.getHandler(), entityX, entityY));
		    		 }
	    		 else if(entityname.equalsIgnoreCase("dev.shutdown.entities.statics.ShroomDark")) {
		    			Maps.getEntityManager();
						EntityManager.addEntity( new ShroomDark(Maps.getHandler(), entityX, entityY));
		    		 }
	    		 else if(entityname.equalsIgnoreCase("dev.shutdown.entities.statics.ShroomLight")) {
		    			Maps.getEntityManager();
						EntityManager.addEntity( new ShroomLight(Maps.getHandler(), entityX, entityY));
		    		 }
	    		 else if(entityname.equalsIgnoreCase("dev.shutdown.entities.statics.Sword")) {
		    			Maps.getEntityManager();
						EntityManager.addEntity( new Sword(Maps.getHandler(), entityX, entityY));
		    		 }
	    		 else if(entityname.equalsIgnoreCase("dev.shutdown.entities.statics.Tree")) {
		    			Maps.getEntityManager();
						EntityManager.addEntity( new Tree(Maps.getHandler(), entityX, entityY));
		    		 }
	    		 else if(entityname.equalsIgnoreCase("dev.shutdown.entities.statics.TreeHigh")) {
		    			Maps.getEntityManager();
						EntityManager.addEntity( new TreeHigh(Maps.getHandler(), entityX, entityY));
		    		 }
	    		 else if(entityname.equalsIgnoreCase("dev.shutdown.entities.statics.TreeRound")) {
		    			Maps.getEntityManager();
						EntityManager.addEntity( new TreeRound(Maps.getHandler(), entityX, entityY));
		    		 }
	    		 else if(entityname.equalsIgnoreCase("dev.shutdown.entities.statics.TreeRoundBig")) {
		    			Maps.getEntityManager();
						EntityManager.addEntity( new TreeRoundBig(Maps.getHandler(), entityX, entityY));
		    		 }
	    		 else if(entityname.equalsIgnoreCase("dev.shutdown.entities.statics.Trunk")) {
		    			Maps.getEntityManager();
						EntityManager.addEntity( new Trunk(Maps.getHandler(), entityX, entityY));
		    		 }
	    		 else if(entityname.equalsIgnoreCase("dev.shutdown.entities.statics.TrunkSmall")) {
		    			Maps.getEntityManager();
						EntityManager.addEntity( new TrunkSmall(Maps.getHandler(), entityX, entityY));
		    		 }
	    		 else if(entityname.equalsIgnoreCase("dev.shutdown.entities.creatures.Player")) {
		    			PLAYERX = entityX;
		    			PLAYERY = entityY;
		    		 }
	    		 
	    	 }
	    	}
	    
	    //Hinzufuegen der Attacken zum inventar
	    if(intlistItems != null) {
	    	for(int i = 0; i <= intlistItems.size()-1 ; i++) {
	    		int id = intlistItems.get(i);
	    		if(id == 0) {
	    			Inventory.addItem(Item.attack_1_interact);
	    		}
	    		if(id == 1) {
	    			Inventory.addItem(Item.attack_2_stick);
	    		}
	    		if(id == 2) {
	    			Inventory.addItem(Item.attack_3_sword);
	    		}
	    		if(id == 3) {
	    			Inventory.addItem(Item.attack_4_key);
	    		}
	    	}
	    }
	    
	    //Hinzufuegen der Nachrichten zum Inventar
	    if(intlistSheet != null) {
	    	for(int i = 0; i <= intlistSheet.size()-1; i++) {
	    		int id = intlistSheet.get(i);
	    		if(id == 0) {
	    			SheetInventory.addSheet(Sheet.paperSheet1);
	    		}
	    		if(id == 1) {
	    			SheetInventory.addSheet(Sheet.paperSheet2);
	    		}
	    		if(id == 2) {
	    			SheetInventory.addSheet(Sheet.paperSheet3);
	    		}
	    		if(id == 3) {
	    			SheetInventory.addSheet(Sheet.paperSheet4);
	    		}
	    		if(id == 4) {
	    			SheetInventory.addSheet(Sheet.paperSheet5);
	    		}
	    		if(id == 5) {
	    			SheetInventory.addSheet(Sheet.paperSheet6);
	    		}
	    		if(id == 6) {
	    			SheetInventory.addSheet(Sheet.paperSheet7);
	    		}
	    		if(id == 7) {
	    			SheetInventory.addSheet(Sheet.paperSheet8);
	    		}
	    	}
	    }
		}
	
	
	}