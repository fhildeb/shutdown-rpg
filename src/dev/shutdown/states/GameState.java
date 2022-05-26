package dev.shutdown.states;

import java.awt.Graphics;

import dev.shutdown.Handler;
import dev.shutdown.audio.Soundplayer;
import dev.shutdown.graphics.Assets;
import dev.shutdown.inventory.Inventory;
import dev.shutdown.inventory.SheetInventory;
import dev.shutdown.maps.Maps;
import dev.shutdown.ui.ClickListener;
import dev.shutdown.ui.InvUIImageButton;
import dev.shutdown.ui.InvUIManager;
import dev.shutdown.utilities.SaveStats;

/**
 * Diese Klasse dient zum Erstellen des Spiel-Zustandes
 * zu Beginn.
 * 
 * @author Felix Hildebrandt
 *
 */
public class GameState extends State {

	public static int activeAttack;
	public static int activeSheet;
	public static int invlayer = 2;
	private Maps startmap;
	public static InvUIManager invUIManager;
	
	/**
	 * Es wird der Handler des Spiel-Zustandes an die Oberklasse uebereben und die Startwelt erstellt.
	 * Zusaetzlich werden der Manager der Inventar-Benutzeroberflaeche sowie
	 * die Overlays mit ihren On-Click-Methoden erstellt.
	 * 
	 * @param handler Handler des Spiel-Zustandes
	 */
	public GameState(Handler handler) {
		super(handler);
		
		//Karte
		startmap = new Maps(handler, "/maps/startmap.txt");
		
		//Inventar-Overlay
		invUIManager = new InvUIManager(handler);
				
		//Handler
		handler.setMap(startmap);
		handler.getInvMouseManager().setInvUIManager(invUIManager);
		
		
		
		//Standardauswahl im Inventar
		activeAttack = 1;
		activeSheet = 1;
		
		//Overlay fuer die Hand-Attacke
		invUIManager.addInvObject(new InvUIImageButton(0, 48, 528, 32, 32, Assets.frameButton, new ClickListener() {
	
			@Override
			public void onClick() {
				if(Inventory.getInventoryItems().size()+SheetInventory.getSheetItems().size() >= 1) {
					
					setInvlayer(1);
					
					setActiveAttack(1);
					Inventory.setSelectedItem(0);
					Inventory.setWannaSee(true);
					
					setActiveSheet(9);
					SheetInventory.setSelectedSheet(8);
					SheetInventory.setWannaSee(false);
					
					Soundplayer.music("/audio/interface/select.wav");

				}
			}
					
		}));
		
		//Overlay fuer die Stock-Attacke
		invUIManager.addInvObject(new InvUIImageButton(1, 80, 528, 32, 32, Assets.frameButton, new ClickListener() {
			
			@Override
			public void onClick() {
				if(Inventory.getInventoryItems().size()+SheetInventory.getSheetItems().size() >= 2) {

					setInvlayer(1);
					
					setActiveAttack(2);
					Inventory.setSelectedItem(1);
					Inventory.setWannaSee(true);
					
					setActiveSheet(9);
					SheetInventory.setSelectedSheet(8);
					SheetInventory.setWannaSee(false);
					
					Soundplayer.music("/audio/interface/select.wav");
					
				}
			}
			
		}));
		
		//Overlay fuer die Schwert-Attacke
		invUIManager.addInvObject(new InvUIImageButton(2, 112, 528, 32, 32, Assets.frameButton, new ClickListener() {

			@Override
			public void onClick() {
				if(Inventory.getInventoryItems().size()+SheetInventory.getSheetItems().size() >= 3) {

					setInvlayer(1);
					
					setActiveAttack(3);
					Inventory.setSelectedItem(2);
					Inventory.setWannaSee(true);
					
					setActiveSheet(9);
					SheetInventory.setSelectedSheet(8);
					SheetInventory.setWannaSee(false);
					
					Soundplayer.music("/audio/interface/select.wav");
				}
			}
			
		}));
		
		//Overlay fuer die Schluessel-Attacke
		invUIManager.addInvObject(new InvUIImageButton(3, 144, 528, 32, 32, Assets.frameButton, new ClickListener() {

			@Override
			public void onClick() {
				if(Inventory.getInventoryItems().size()+SheetInventory.getSheetItems().size() >= 4) {

					setInvlayer(1);
					
					setActiveAttack(4);
					Inventory.setSelectedItem(3);
					Inventory.setWannaSee(true);
					
					setActiveSheet(9);
					SheetInventory.setSelectedSheet(8);
					SheetInventory.setWannaSee(false);
					
					Soundplayer.music("/audio/interface/select.wav");
				}
			}
			
		}));
		
		//Overlay fuer die Nachricht 1
		invUIManager.addInvObject(new InvUIImageButton(4, 48, 592, 32, 32, Assets.frameButton, new ClickListener() {

			@Override
			public void onClick() {
				if(Inventory.getInventoryItems().size()+SheetInventory.getSheetItems().size() >= 5) {
					
					setInvlayer(2);
					
					setActiveAttack(5);
					Inventory.setSelectedItem(4);
					Inventory.setWannaSee(false);
					
					setActiveSheet(1);
					SheetInventory.setSelectedSheet(0);
					SheetInventory.setWannaSee(true);
					
					Soundplayer.music("/audio/interface/select.wav");
				}
			}
			
		}));
		
		//Overlay fuer die Nachricht 2
		invUIManager.addInvObject(new InvUIImageButton(5, 96, 592, 32, 32, Assets.frameButton, new ClickListener() {

			@Override
			public void onClick() {
				if(Inventory.getInventoryItems().size()+SheetInventory.getSheetItems().size() >= 6) {
					
					setInvlayer(2);
					
					setActiveAttack(5);
					Inventory.setSelectedItem(4);
					Inventory.setWannaSee(false);
					
					setActiveSheet(2);
					SheetInventory.setSelectedSheet(1);
					SheetInventory.setWannaSee(true);
	
					Soundplayer.music("/audio/interface/select.wav");
				}
			}
			
		}));
		
		//Overlay fuer die Nachricht 3
		invUIManager.addInvObject(new InvUIImageButton(6, 144, 592, 32, 32, Assets.frameButton, new ClickListener() {

			@Override
			public void onClick() {
				if(Inventory.getInventoryItems().size()+SheetInventory.getSheetItems().size() >= 7) {
					
					setInvlayer(2);
					
					setActiveAttack(5);
					Inventory.setSelectedItem(4);
					Inventory.setWannaSee(false);
					
					setActiveSheet(3);
					SheetInventory.setSelectedSheet(2);
					SheetInventory.setWannaSee(true);
					
					Soundplayer.music("/audio/interface/select.wav");
				}
			}
			
		}));
		
		//Overlay fuer die Nachricht 4
		invUIManager.addInvObject(new InvUIImageButton(7, 192, 592, 32, 32, Assets.frameButton, new ClickListener() {

			@Override
			public void onClick() {
				if(Inventory.getInventoryItems().size()+SheetInventory.getSheetItems().size() >= 8) {

					setInvlayer(2);
					
					setActiveAttack(5);
					Inventory.setSelectedItem(4);
					Inventory.setWannaSee(false);
					
					setActiveSheet(4);
					SheetInventory.setSelectedSheet(3);
					SheetInventory.setWannaSee(true);
					
					Soundplayer.music("/audio/interface/select.wav");
				}
			}
			
		}));
		
		//Overlay fuer die Nachricht 5
		invUIManager.addInvObject(new InvUIImageButton(8, 240, 592, 32, 32, Assets.frameButton, new ClickListener() {

			@Override
			public void onClick() {
				if(Inventory.getInventoryItems().size()+SheetInventory.getSheetItems().size() >= 9) {
					
					setInvlayer(2);
					
					setActiveAttack(5);
					Inventory.setSelectedItem(4);
					Inventory.setWannaSee(false);
					
					setActiveSheet(5);
					SheetInventory.setSelectedSheet(4);
					SheetInventory.setWannaSee(true);

					Soundplayer.music("/audio/interface/select.wav");
				}
			}
			
		}));
		
		//Overlay fuer die Nachricht 6
		invUIManager.addInvObject(new InvUIImageButton(9, 288, 592, 32, 32, Assets.frameButton, new ClickListener() {

			@Override
			public void onClick() {
				if(Inventory.getInventoryItems().size()+SheetInventory.getSheetItems().size() >= 10) {
					
					setInvlayer(2);
					
					setActiveAttack(5);
					Inventory.setSelectedItem(4);
					Inventory.setWannaSee(false);
					
					setActiveSheet(6);
					SheetInventory.setSelectedSheet(5);
					SheetInventory.setWannaSee(true);
					
					Soundplayer.music("/audio/interface/select.wav");
				}
			}
			
		}));
		
		//Overlay fuer die Nachricht 7
		invUIManager.addInvObject(new InvUIImageButton(10, 336, 592, 32, 32, Assets.frameButton, new ClickListener() {

			@Override
			public void onClick() {
				if(Inventory.getInventoryItems().size()+SheetInventory.getSheetItems().size() >= 11) {

					setInvlayer(2);
					
					setActiveAttack(5);
					Inventory.setSelectedItem(4);
					Inventory.setWannaSee(false);
					
					setActiveSheet(7);
					SheetInventory.setSelectedSheet(6);
					SheetInventory.setWannaSee(true);
					
					Soundplayer.music("/audio/interface/select.wav");
				}
			}
			
		}));
		
		//Overlay fuer die Nachricht 8
		invUIManager.addInvObject(new InvUIImageButton(11, 384, 592, 32, 32, Assets.frameButton, new ClickListener() {

			@Override
			public void onClick() {
				if(Inventory.getInventoryItems().size()+SheetInventory.getSheetItems().size() >= 12) {

					setInvlayer(2);
					
					setActiveAttack(5);
					Inventory.setSelectedItem(4);
					Inventory.setWannaSee(false);
					
					setActiveSheet(8);
					SheetInventory.setSelectedSheet(7);
					SheetInventory.setWannaSee(true);
					
					Soundplayer.music("/audio/interface/select.wav");
				}
			}
			
		}));
		
		//Overlay fuer das Schliessen und Speichern des Spiels
		invUIManager.addInvObject(new InvUIImageButton(12, 240, 528, 176, 32, Assets.saveButton, new ClickListener() {
			
			@Override
			public void onClick() {
					Soundplayer.music("/audio/interface/select.wav");
					if(MenuState.getCreditStateactive() == 2) {
						SaveStats ss = new SaveStats();
					ss.SaveCurrentGame();
					System.exit(2);
					}
					//Falls man im Credit-Zustand ist
					else if(MenuState.getCreditStateactive() == 1) {
						System.exit(1);
						}
					else {
					}			
			}
			}));
		
	}
	
	@Override
	public void tick(){
		startmap.tick();
		invUIManager.tick();
	}

	@Override
	public void render(Graphics paintbrush) {
		startmap.render(paintbrush);
		invUIManager.render(paintbrush);
		
	}

	/**
	 * Zurueckgabe der aktiven Attacke im Spiel-Zustand.
	 * 
	 * @return aktive Attacke im Spiel-Zustand
	 */
	public static int getActiveAttack() {
		return activeAttack;
	}

	/**
	 * Festlegen der aktiven Attacke im Spiel-Zustand.
	 * 
	 * @param activeAttack aktive Attacke im Spiel-Zustand
	 */
	public void setActiveAttack(int activeAttack) {
		GameState.activeAttack = activeAttack;
	}

	/**
	 * Zurueckgabe der aktiven Nachricht im Spiel-Zustand.
	 * 
	 * @return aktive Nachricht im Spiel-Zustand
	 */
	public static int getActiveSheet() {
		return activeSheet;
	}

	/**
	 * Festlegen der aktiven Nachricht im Spiel-Zustand.
	 * 
	 * @param activeSheet aktive Nachricht im Spiel-Zustand
	 */
	public static void setActiveSheet(int activeSheet) {
		GameState.activeSheet = activeSheet;
	}

	/**
	 * Zurueckgabe der aktiven Inventarschicht im Spiel-Zustand.
	 * 
	 * @return aktive Inventarschicht im Spiel-Zustand
	 */
	public static int getInvlayer() {
		return invlayer;
	}

	/**
	 * Festlegen der aktiven Inventarschicht im Spiel-Zustand.
	 * 
	 * @param invlayer aktive Inventarschicht im Spiel-Zustand
	 */
	public static void setInvlayer(int invlayer) {
		GameState.invlayer = invlayer;
	}
	
}
