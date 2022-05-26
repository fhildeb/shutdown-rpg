package dev.shutdown.graphics;

import java.awt.Font;
import java.awt.image.BufferedImage;

/**
 * Diese Klasse dient zum Einlesen und Teilen aller Bilddaten in einzelne
 * Grafiken fuer Layouts, Objekte, Hintergruende, Gegenstaende und Icons.
 * Zudem koennen mit diese Klassen die Grafik-Arrays fuer die Animationen
 * erstellt werden.
 * 
 * @author Felix Hildebrandt
 *
 */
public class Assets {

	//Regulaere Groessen
	private static int 			generalWidth = 64, generalHeight = 64,
					   			layoutWidth = 960, layoutHeight = 672,
					   			quaterWidth = 32, quaterHeight = 32;
	
	//Schriftarten
	public static Font 			starmapInv, 
								starmapSheet;
	
	//Animationen
	public static BufferedImage[] 	
								//Charakter 
								mainChar_down, 
								mainChar_up, 
								mainChar_left, 
								mainChar_right,
								mainChar_still,
								
								//Character bei Attacke 1
								mainChar_attk_right,
								mainChar_attk_left,
								mainChar_attk_up,
								mainChar_attk_down,
								
								//Character bei Attacke 2
								mainChar_attk2_right,
								mainChar_attk2_left,
								mainChar_attk2_up,
								mainChar_attk2_down,
								
								//Charakter bei Attacke 3
								mainChar_attk3_right,
								mainChar_attk3_left,
								mainChar_attk3_up,
								mainChar_attk3_down,
								
								//Charakter bei Attacke 4
								mainChar_attk4_right,
								mainChar_attk4_left,
								mainChar_attk4_up,
								mainChar_attk4_down,
								
								//Menue
								startGameButton,
								loadGameButton,
								creditsButton,
								exitButton,
									
								//Inventar
								frameButton,
								saveButton,
								backButton;
	
	//Texturen					
	public static BufferedImage 
								//Layout
								gameWindow, 
								gameLauncher,
								credits,
								
								//Charactere
	
								//Inventar
								inventory_default, 
								sheetinventory_default,
								sheetBox,
	
								//Kartentexturen
								grassTile, 
								rockTile, 
								grassRockTile,
								grassBushTile,
								dirtRockLeft,
								dirtRockRight,
								dirtRockMid,
								
									//RoadTile
									OuterLeftUpRoadTile,
									OuterLeftDownRoadTile,
									OuterLeftMidRoadTile,
									OuterRightUpRoadTile,
									OuterRightDownRoadTile,
									OuterRightMidRoadTile,
									OuterUpMidRoadTile,
									OuterDownMidRoadTile,
									MiddleRoadTile,
									
									//ZioTile
									OuterLeftUpZioTile,
									OuterLeftDownZioTile,
									OuterLeftMidZioTile,
									OuterRightUpZioTile,
									OuterRightDownZioTile,
									OuterRightMidZioTile,
									OuterUpMidZioTile,
									OuterDownMidZioTile,
									MiddleZioTile,
									
									//WaterTile
									OuterLeftUpWaterTile,
									OuterLeftDownWaterTile,
									OuterLeftMidWaterTile,
									OuterRightUpWaterTile,
									OuterRightDownWaterTile,
									OuterRightMidWaterTile,
									OuterUpMidWaterTile,
									OuterDownMidWaterTile,
									MiddleWaterTile,
									
									//MudTile
									OuterLeftUpMudTile,
									OuterLeftDownMudTile,
									OuterLeftMidMudTile,
									OuterRightUpMudTile,
									OuterRightDownMudTile,
									OuterRightMidMudTile,
									OuterUpMidMudTile,
									OuterDownMidMudTile,
									MiddleMudTile,
									
									//DirtTile
									OuterLeftUpDirtTile,
									OuterLeftDownDirtTile,
									OuterLeftMidDirtTile,
									OuterRightUpDirtTile,
									OuterRightDownDirtTile,
									OuterRightMidDirtTile,
									OuterUpMidDirtTile,
									OuterDownMidDirtTile,
									MiddleDirtTile,
									
									//HillTile
									OuterLeftUpHillTile,
									OuterLeftDownHillTile,
									OuterLeftMidHillTile,
									OuterRightUpHillTile,
									OuterRightDownHillTile,
									OuterRightMidHillTile,
									OuterUpMidHillTile,
									OuterDownMidHillTile,
									MiddleHillTile,
									
									//GrassHillTile
									OuterLeftUpGrassHillTile,
									OuterLeftDownGrassHillTile,
									OuterLeftMidGrassHillTile,
									OuterRightUpGrassHillTile,
									OuterRightDownGrassHillTile,
									OuterRightMidGrassHillTile,
									OuterUpMidGrassHillTile,
									OuterDownMidGrassHillTile,
									MiddleGrassHillTile,
									
	
									// Objekte
									tree, 
									clear_tree,
									shroom_dark,
									shroom_light,
									plant,
									plant_cube,
									rocks,
									sea_plant,
									rock_brown,
									grass_long,
									barrier,
									bottle_gold,
									bottle_silver,
									entrance_open,
									entrance_close,
									house_small_blue,
									house_small_red,
									house_big_blue,
									house_big_red,
									clear_tree_big,
									tree_high,
									tree_round,
									tree_round_big,
									trunk_small,
									trunk,
									hay,
									box,
									box_small,
									key,
									sword,
									
									//Beute
									attack_1_interact,
									attack_2_stick,
									attack_3_sword,
									attack_4_key,
									
									paper_sheet_1,
									paper_sheet_2,
									paper_sheet_3,
									paper_sheet_4,
									paper_sheet_5,
									paper_sheet_6,
									paper_sheet_7,
									paper_sheet_8;
								
	/**
	 * Initialisieren aller Grafikobjekte und 
	 * Zuweisen der richtigen Teilgrafik durch das
	 * Ausschneiden der Sektoren von den zuvor eingelesenen
	 * Einzelbildern.
	 */
	public static void initialize() {
		
		//Schriftarten
		FontLoader fl = new FontLoader();
		starmapInv = fl.loadFont("/fonts/Starmap.ttf", 20);
		FontLoader fl2 = new FontLoader();
		starmapSheet = fl2.loadFont("/fonts/Starmap.ttf", 20);
		
		//Bilder
		TextureSheet gameWindowSheet = new TextureSheet(TextureLoader.loadTexture("/textures/layout/Gamewindow_60x42.png"));
		TextureSheet gameLauncherSheet = new TextureSheet(TextureLoader.loadTexture("/textures/layout/Gamelauncher_60x42.png"));
		TextureSheet characterSheet = new TextureSheet(TextureLoader.loadTexture("/textures/character/Characters_30x18.png"));
		TextureSheet objectsSheet = new TextureSheet(TextureLoader.loadTexture("/textures/objects/Objects_30x18.png"));
		TextureSheet launcherButtonsSheet = new TextureSheet(TextureLoader.loadTexture("/textures/layout/LauncherButtons_60x42.png"));
		TextureSheet inventory_defaultSheet = new TextureSheet(TextureLoader.loadTexture("/textures/layout/Inventory_Default_60x42.png"));
		TextureSheet sheetBoxSheet = new TextureSheet(TextureLoader.loadTexture("/textures/layout/SheetBox_50x24.png"));
		TextureSheet creditsSheet = new TextureSheet(TextureLoader.loadTexture("/textures/layout/CreditState.png"));
		
		//Charakter
		mainChar_down = new BufferedImage[3];
		mainChar_up = new BufferedImage[3];
		mainChar_left = new BufferedImage[3];
		mainChar_right = new BufferedImage[3];
		mainChar_still = new BufferedImage[4];
		
		//Charakter bei Attacke 1
		mainChar_attk_left = new BufferedImage[2];
		mainChar_attk_right = new BufferedImage[2];
		mainChar_attk_up = new BufferedImage[2];
		mainChar_attk_down = new BufferedImage[2];
		
		//Charakter bei Attacke 2
		mainChar_attk2_left = new BufferedImage[2];
		mainChar_attk2_right = new BufferedImage[2];
		mainChar_attk2_up = new BufferedImage[2];
		mainChar_attk2_down = new BufferedImage[2];
		
		//Charakter bei Attacke 3
		mainChar_attk3_left = new BufferedImage[2];
		mainChar_attk3_right = new BufferedImage[2];
		mainChar_attk3_up = new BufferedImage[2];
		mainChar_attk3_down = new BufferedImage[2];
		
		//Charakter bei Attacke 4
		mainChar_attk4_left = new BufferedImage[2];
		mainChar_attk4_right = new BufferedImage[2];
		mainChar_attk4_up = new BufferedImage[2];
		mainChar_attk4_down = new BufferedImage[2];
		
		//Menue
		startGameButton = new BufferedImage[2];
		loadGameButton = new BufferedImage[2];
		creditsButton = new BufferedImage[2];
		exitButton = new BufferedImage[2];
		
		//Inventar
		frameButton = new BufferedImage[2];
		saveButton = new BufferedImage[2];
		backButton = new BufferedImage[2];
		
		//Menue-Buttons
		startGameButton[0] = launcherButtonsSheet.cropSector(0, quaterHeight * 0, 210, quaterHeight * 1);
		startGameButton[1] = launcherButtonsSheet.cropSector(0, quaterHeight * 1, 210, quaterHeight * 1);
		
		loadGameButton[0] = launcherButtonsSheet.cropSector(0, quaterHeight * 4, 210, quaterHeight * 1);
		loadGameButton[1] = launcherButtonsSheet.cropSector(0, quaterHeight * 5, 210, quaterHeight * 1);
		
		creditsButton[0] = launcherButtonsSheet.cropSector(0, quaterHeight * 6, 210, quaterHeight * 1);
		creditsButton[1] = launcherButtonsSheet.cropSector(0, quaterHeight * 7, 210, quaterHeight * 1);
		
		exitButton[0] = launcherButtonsSheet.cropSector(0, quaterHeight * 2, 210, quaterHeight * 1);
		exitButton[1] = launcherButtonsSheet.cropSector(0, quaterHeight * 3, 210, quaterHeight * 1);
		
		//Inventar-Buttons
		frameButton[0] = objectsSheet.cropSector(704, 0, quaterWidth, quaterHeight);
		frameButton[1] = objectsSheet.cropSector(736, 0, quaterWidth, quaterHeight);
		
		saveButton[0] = launcherButtonsSheet.cropSector(0, 256, 176, quaterHeight);
		saveButton[1] = launcherButtonsSheet.cropSector(0, 256, 176, quaterHeight);
		
		backButton[0] = launcherButtonsSheet.cropSector(0, 360, 176, quaterHeight);
		backButton[1] = launcherButtonsSheet.cropSector(0, 360, 176, quaterHeight);
		
		//Layout
		gameWindow = gameWindowSheet.cropSector(0, 0, layoutWidth, layoutHeight);
		gameLauncher = gameLauncherSheet.cropSector(0, 0, layoutWidth, layoutHeight);
		inventory_default = inventory_defaultSheet.cropSector(0, 0, layoutWidth, layoutHeight);
		sheetBox = sheetBoxSheet.cropSector(0, 0, 800, 384);
		credits = creditsSheet.cropSector(0, 0, layoutWidth, layoutHeight);
		
		//Charakter
		mainChar_down[0] = characterSheet.cropSector(quaterWidth * 16, quaterWidth * 10, generalWidth, generalHeight);
		mainChar_down[1] = characterSheet.cropSector(quaterWidth * 16, quaterWidth * 14, generalWidth, generalHeight);
		mainChar_down[2] = characterSheet.cropSector(quaterWidth * 16, quaterWidth * 12, generalWidth, generalHeight);
		
		mainChar_up[0] = characterSheet.cropSector(quaterWidth * 12, quaterWidth * 8, generalWidth, generalHeight);
		mainChar_up[1] = characterSheet.cropSector(quaterWidth * 14, quaterWidth * 14, generalWidth, generalHeight);
		mainChar_up[2] = characterSheet.cropSector(quaterWidth * 16, quaterWidth * 8, generalWidth, generalHeight);
		
		mainChar_left[0] = characterSheet.cropSector(quaterWidth * 12, quaterWidth * 12, generalWidth, generalHeight);
		mainChar_left[1] = characterSheet.cropSector(quaterWidth * 12, quaterWidth * 14, generalWidth, generalHeight);
		mainChar_left[2] = characterSheet.cropSector(quaterWidth * 12, quaterWidth * 10, generalWidth, generalHeight);
		
		mainChar_right[0] = characterSheet.cropSector(quaterWidth * 14, quaterWidth * 8, generalWidth, generalHeight);
		mainChar_right[1] = characterSheet.cropSector(quaterWidth * 14, quaterWidth * 10, generalWidth, generalHeight);
		mainChar_right[2] = characterSheet.cropSector(quaterWidth * 14, quaterWidth * 12, generalWidth, generalHeight);
		
		mainChar_still[0] = characterSheet.cropSector(quaterWidth * 16, quaterWidth * 10, generalWidth, generalHeight);
		mainChar_still[1] = characterSheet.cropSector(quaterWidth * 12, quaterWidth * 8, generalWidth, generalHeight);
		mainChar_still[2] = characterSheet.cropSector(quaterWidth * 12, quaterWidth * 12, generalWidth, generalHeight);
		mainChar_still[3] = characterSheet.cropSector(quaterWidth * 14, quaterWidth * 8, generalWidth, generalHeight);
		
		//Charakter bei Attacke 1
		mainChar_attk_left[0] = characterSheet.cropSector(quaterWidth * 30, quaterWidth * 30, generalWidth, generalHeight);
		mainChar_attk_left[1] = characterSheet.cropSector(quaterWidth * 30, quaterWidth * 26, generalWidth, generalHeight);
		
		mainChar_attk_right[0] = characterSheet.cropSector(quaterWidth * 32, quaterWidth * 26, generalWidth, generalHeight);
		mainChar_attk_right[1] = characterSheet.cropSector(quaterWidth * 32, quaterWidth * 28, generalWidth, generalHeight);
		
		mainChar_attk_up[0] = characterSheet.cropSector(quaterWidth * 32, quaterWidth * 30, generalWidth, generalHeight);
		mainChar_attk_up[1] = characterSheet.cropSector(quaterWidth * 34, quaterWidth * 24, generalWidth, generalHeight);
		
		mainChar_attk_down[0] = characterSheet.cropSector(quaterWidth * 34, quaterWidth * 28, generalWidth, generalHeight);
		mainChar_attk_down[1] = characterSheet.cropSector(quaterWidth * 34, quaterWidth * 30, generalWidth, generalHeight);
		
		//Charakter bei Attacke 2
		mainChar_attk2_left[0] = characterSheet.cropSector(quaterWidth * 30, quaterWidth * 14, generalWidth, generalHeight);
		mainChar_attk2_left[1] = characterSheet.cropSector(quaterWidth * 30, quaterWidth * 10, generalWidth, generalHeight);
		
		mainChar_attk2_right[0] = characterSheet.cropSector(quaterWidth * 32, quaterWidth * 10, generalWidth, generalHeight);
		mainChar_attk2_right[1] = characterSheet.cropSector(quaterWidth * 32, quaterWidth * 12, generalWidth, generalHeight);
	
		mainChar_attk2_up[0] = characterSheet.cropSector(quaterWidth * 32, quaterWidth * 14, generalWidth, generalHeight);
		mainChar_attk2_up[1] = characterSheet.cropSector(quaterWidth * 34, quaterWidth * 8, generalWidth, generalHeight);
		
		mainChar_attk2_down[0] = characterSheet.cropSector(quaterWidth * 34, quaterWidth * 12, generalWidth, generalHeight);
		mainChar_attk2_down[1] = characterSheet.cropSector(quaterWidth * 34, quaterWidth * 14, generalWidth, generalHeight);
		
		//Charakter bei Attacke 3
		mainChar_attk3_left[0] = characterSheet.cropSector(quaterWidth * 30, quaterWidth * 22, generalWidth, generalHeight);
		mainChar_attk3_left[1] = characterSheet.cropSector(quaterWidth * 30, quaterWidth * 18, generalWidth, generalHeight);
		
		mainChar_attk3_right[0] = characterSheet.cropSector(quaterWidth * 32, quaterWidth * 18, generalWidth, generalHeight);
		mainChar_attk3_right[1] = characterSheet.cropSector(quaterWidth * 32, quaterWidth * 20, generalWidth, generalHeight);
	
		mainChar_attk3_up[0] = characterSheet.cropSector(quaterWidth * 32, quaterWidth * 22, generalWidth, generalHeight);
		mainChar_attk3_up[1] = characterSheet.cropSector(quaterWidth * 34, quaterWidth * 16, generalWidth, generalHeight);
		
		mainChar_attk3_down[0] = characterSheet.cropSector(quaterWidth * 34, quaterWidth * 20, generalWidth, generalHeight);
		mainChar_attk3_down[1] = characterSheet.cropSector(quaterWidth * 34, quaterWidth * 22, generalWidth, generalHeight);
		
		//Charakter bei Attacke 4
		mainChar_attk4_left[0] = characterSheet.cropSector(quaterWidth * 30, quaterWidth * 6, generalWidth, generalHeight);
		mainChar_attk4_left[1] = characterSheet.cropSector(quaterWidth * 30, quaterWidth * 2, generalWidth, generalHeight);
		
		mainChar_attk4_right[0] = characterSheet.cropSector(quaterWidth * 32, quaterWidth * 2, generalWidth, generalHeight);
		mainChar_attk4_right[1] = characterSheet.cropSector(quaterWidth * 32, quaterWidth * 4, generalWidth, generalHeight);
	
		mainChar_attk4_up[0] = characterSheet.cropSector(quaterWidth * 32, quaterWidth * 6, generalWidth, generalHeight);
		mainChar_attk4_up[1] = characterSheet.cropSector(quaterWidth * 34, quaterWidth * 0, generalWidth, generalHeight);
		
		mainChar_attk4_down[0] = characterSheet.cropSector(quaterWidth * 34, quaterWidth * 4, generalWidth, generalHeight);
		mainChar_attk4_down[1] = characterSheet.cropSector(quaterWidth * 34, quaterWidth * 6, generalWidth, generalHeight);
		
		//Kartentexturen
		grassTile = objectsSheet.cropSector(generalWidth * 1, generalHeight * 0, generalWidth, generalHeight);
		rockTile = objectsSheet.cropSector(generalWidth * 5, generalHeight * 2, generalWidth, generalHeight);
		grassRockTile = objectsSheet.cropSector(generalWidth * 6, generalHeight * 2, generalWidth, generalHeight);
		grassBushTile = objectsSheet.cropSector(generalWidth * 0, generalHeight * 0, generalWidth, generalHeight);
		dirtRockLeft = objectsSheet.cropSector(generalWidth * 5, generalHeight * 3, generalWidth, generalHeight);
		dirtRockRight = objectsSheet.cropSector(generalWidth * 6, generalHeight * 3, generalWidth, generalHeight);
		dirtRockMid = objectsSheet.cropSector(generalWidth * 4, generalHeight * 3, generalWidth, generalHeight);
		
			//RoadTile
			OuterLeftUpRoadTile = objectsSheet.cropSector(generalWidth * 0, generalHeight * 1, generalWidth, generalHeight);
			OuterLeftDownRoadTile = objectsSheet.cropSector(generalWidth * 0, generalHeight * 2, generalWidth, generalHeight);
			OuterLeftMidRoadTile = objectsSheet.cropSector(generalWidth * 2, generalHeight * 0, generalWidth, generalHeight);
			OuterRightUpRoadTile = objectsSheet.cropSector(generalWidth * 1, generalHeight * 1, generalWidth, generalHeight);
			OuterRightDownRoadTile = objectsSheet.cropSector(generalWidth * 1, generalHeight * 2, generalWidth, generalHeight);
			OuterRightMidRoadTile = objectsSheet.cropSector(generalWidth * 3, generalHeight * 0, generalWidth, generalHeight);
			OuterUpMidRoadTile = objectsSheet.cropSector(generalWidth * 2, generalHeight * 1, generalWidth, generalHeight);
			OuterDownMidRoadTile = objectsSheet.cropSector(generalWidth * 3, generalHeight * 1, generalWidth, generalHeight);
			MiddleRoadTile = objectsSheet.cropSector(generalWidth * 2, generalHeight * 2, generalWidth, generalHeight);
			
			//ZioTile
			OuterLeftUpZioTile = objectsSheet.cropSector(generalWidth * 0, generalHeight * 9, generalWidth, generalHeight);
			OuterLeftDownZioTile = objectsSheet.cropSector(generalWidth * 0, generalHeight * 10, generalWidth, generalHeight);
			OuterLeftMidZioTile = objectsSheet.cropSector(generalWidth * 0, generalHeight * 4, generalWidth, generalHeight);
			OuterRightUpZioTile = objectsSheet.cropSector(generalWidth * 1, generalHeight * 9, generalWidth, generalHeight);
			OuterRightDownZioTile = objectsSheet.cropSector(generalWidth * 1, generalHeight * 10, generalWidth, generalHeight);
			OuterRightMidZioTile = objectsSheet.cropSector(generalWidth * 1, generalHeight * 4, generalWidth, generalHeight);
			OuterUpMidZioTile = objectsSheet.cropSector(generalWidth * 3, generalHeight * 4, generalWidth, generalHeight);
			OuterDownMidZioTile = objectsSheet.cropSector(generalWidth * 2, generalHeight * 4, generalWidth, generalHeight);
			MiddleZioTile = objectsSheet.cropSector(generalWidth * 3, generalHeight * 5, generalWidth, generalHeight);
			
			//WaterTile
			OuterLeftUpWaterTile = objectsSheet.cropSector(generalWidth * 0, generalHeight * 7, generalWidth, generalHeight);
			OuterLeftDownWaterTile = objectsSheet.cropSector(generalWidth * 0, generalHeight * 8, generalWidth, generalHeight);
			OuterLeftMidWaterTile = objectsSheet.cropSector(generalWidth * 0, generalHeight * 5, generalWidth, generalHeight);
			OuterRightUpWaterTile = objectsSheet.cropSector(generalWidth * 1, generalHeight * 7, generalWidth, generalHeight);
			OuterRightDownWaterTile = objectsSheet.cropSector(generalWidth * 1, generalHeight * 8, generalWidth, generalHeight);
			OuterRightMidWaterTile = objectsSheet.cropSector(generalWidth * 1, generalHeight * 5, generalWidth, generalHeight);
			OuterUpMidWaterTile = objectsSheet.cropSector(generalWidth * 0, generalHeight * 6, generalWidth, generalHeight);
			OuterDownMidWaterTile = objectsSheet.cropSector(generalWidth * 1, generalHeight * 6, generalWidth, generalHeight);
			MiddleWaterTile = objectsSheet.cropSector(generalWidth * 2, generalHeight * 8, generalWidth, generalHeight);
	
			//MudTile
			OuterLeftUpMudTile = objectsSheet.cropSector(generalWidth * 0, generalHeight * 11, generalWidth, generalHeight);
			OuterLeftDownMudTile = objectsSheet.cropSector(generalWidth * 0, generalHeight * 12, generalWidth, generalHeight);
			OuterLeftMidMudTile = objectsSheet.cropSector(generalWidth * 17, generalHeight * 2, generalWidth, generalHeight);
			OuterRightUpMudTile = objectsSheet.cropSector(generalWidth * 1, generalHeight * 11, generalWidth, generalHeight);
			OuterRightDownMudTile = objectsSheet.cropSector(generalWidth * 1, generalHeight * 12, generalWidth, generalHeight);
			OuterRightMidMudTile = objectsSheet.cropSector(generalWidth * 16, generalHeight * 2, generalWidth, generalHeight);
			OuterUpMidMudTile = objectsSheet.cropSector(generalWidth * 17, generalHeight * 0, generalWidth, generalHeight);
			OuterDownMidMudTile = objectsSheet.cropSector(generalWidth * 17, generalHeight * 1, generalWidth, generalHeight);
			MiddleMudTile = objectsSheet.cropSector(generalWidth * 17, generalHeight * 3, generalWidth, generalHeight);
			
			//DirtTile
			OuterLeftUpDirtTile = objectsSheet.cropSector(generalWidth * 9, generalHeight * 0, generalWidth, generalHeight);
			OuterLeftDownDirtTile = objectsSheet.cropSector(generalWidth * 9, generalHeight * 1, generalWidth, generalHeight);
			OuterLeftMidDirtTile = objectsSheet.cropSector(generalWidth * 0, generalHeight * 3, generalWidth, generalHeight);
			OuterRightUpDirtTile = objectsSheet.cropSector(generalWidth * 10, generalHeight * 0, generalWidth, generalHeight);
			OuterRightDownDirtTile = objectsSheet.cropSector(generalWidth * 10, generalHeight * 1, generalWidth, generalHeight);
			OuterRightMidDirtTile = objectsSheet.cropSector(generalWidth * 1, generalHeight * 3, generalWidth, generalHeight);
			OuterUpMidDirtTile = objectsSheet.cropSector(generalWidth * 3, generalHeight * 3, generalWidth, generalHeight);
			OuterDownMidDirtTile = objectsSheet.cropSector(generalWidth * 2, generalHeight * 3, generalWidth, generalHeight);
			MiddleDirtTile = objectsSheet.cropSector(generalWidth * 2, generalHeight * 5, generalWidth, generalHeight);
			
			//HillTile
			OuterLeftUpHillTile = objectsSheet.cropSector(generalWidth * 4, generalHeight * 0, generalWidth, generalHeight);
			OuterLeftDownHillTile = objectsSheet.cropSector(generalWidth * 4, generalHeight * 1, generalWidth, generalHeight);
			OuterLeftMidHillTile = objectsSheet.cropSector(generalWidth * 14, generalHeight * 0, generalWidth, generalHeight);
			OuterRightUpHillTile = objectsSheet.cropSector(generalWidth * 5, generalHeight * 0, generalWidth, generalHeight);
			OuterRightDownHillTile = objectsSheet.cropSector(generalWidth * 5, generalHeight * 1, generalWidth, generalHeight);
			OuterRightMidHillTile = objectsSheet.cropSector(generalWidth * 15, generalHeight * 0, generalWidth, generalHeight);
			OuterUpMidHillTile = objectsSheet.cropSector(generalWidth * 15, generalHeight * 1, generalWidth, generalHeight);
			OuterDownMidHillTile = objectsSheet.cropSector(generalWidth * 14, generalHeight * 1, generalWidth, generalHeight);
			MiddleHillTile = objectsSheet.cropSector(generalWidth * 8, generalHeight * 1, generalWidth, generalHeight);
			
			//GrassHillTile
			OuterLeftUpGrassHillTile = objectsSheet.cropSector(generalWidth * 6, generalHeight * 0, generalWidth, generalHeight);
			OuterLeftDownGrassHillTile = objectsSheet.cropSector(generalWidth * 6, generalHeight * 1, generalWidth, generalHeight);
			OuterLeftMidGrassHillTile = objectsSheet.cropSector(generalWidth * 14, generalHeight * 2, generalWidth, generalHeight);
			OuterRightUpGrassHillTile = objectsSheet.cropSector(generalWidth * 7, generalHeight * 0, generalWidth, generalHeight);
			OuterRightDownGrassHillTile = objectsSheet.cropSector(generalWidth * 7, generalHeight * 1, generalWidth, generalHeight);
			OuterRightMidGrassHillTile = objectsSheet.cropSector(generalWidth * 16, generalHeight * 1, generalWidth, generalHeight);
			OuterUpMidGrassHillTile = objectsSheet.cropSector(generalWidth * 16, generalHeight * 0, generalWidth, generalHeight);
			OuterDownMidGrassHillTile = objectsSheet.cropSector(generalWidth * 15, generalHeight * 2, generalWidth, generalHeight);
			MiddleGrassHillTile = objectsSheet.cropSector(generalWidth * 17, generalHeight * 4, generalWidth, generalHeight);
		
		//Objekte
		tree = objectsSheet.cropSector(quaterWidth * 20, quaterHeight * 8, quaterWidth * 4, quaterHeight * 4);
		clear_tree = objectsSheet.cropSector(quaterWidth * 10, quaterHeight * 8, quaterWidth * 4, quaterHeight * 4);
		
		shroom_dark = objectsSheet.cropSector(quaterWidth * 6, quaterHeight * 4, quaterWidth * 1, quaterHeight * 1);
		shroom_light = objectsSheet.cropSector(quaterWidth * 8, quaterHeight * 8, quaterWidth * 1, quaterHeight * 1);
		plant = objectsSheet.cropSector(quaterWidth * 7, quaterHeight * 4, quaterWidth * 1, quaterHeight * 1);
		plant_cube = objectsSheet.cropSector(quaterWidth * 7, quaterHeight * 5, quaterWidth * 1, quaterHeight * 1);
		rocks = objectsSheet.cropSector(quaterWidth * 8, quaterHeight * 5+2, quaterWidth * 2, quaterHeight * 1-2);
		sea_plant = objectsSheet.cropSector(quaterWidth * 9, quaterHeight * 4+8, quaterWidth * 1, quaterHeight * 1-6);
		rock_brown = objectsSheet.cropSector(quaterWidth * 8, quaterHeight * 9, quaterWidth * 1, quaterHeight * 1);
		grass_long = objectsSheet.cropSector(quaterWidth * 9, quaterHeight * 8, quaterWidth * 1, quaterHeight * 2);
		barrier = objectsSheet.cropSector(quaterWidth * 6, quaterHeight * 14, quaterWidth * 2, quaterHeight * 2);
		bottle_gold = objectsSheet.cropSector(quaterWidth * 6, quaterHeight * 17, quaterWidth * 1, quaterHeight * 1);
		bottle_silver = objectsSheet.cropSector(quaterWidth * 7, quaterHeight * 17, quaterWidth * 1, quaterHeight * 1);
		entrance_open = objectsSheet.cropSector(quaterWidth * 4, quaterHeight * 18, quaterWidth * 4, quaterHeight * 4);
		entrance_close = objectsSheet.cropSector(quaterWidth * 4, quaterHeight * 22, quaterWidth * 4, quaterHeight * 4);
		house_small_blue = objectsSheet.cropSector(quaterWidth * 8, quaterHeight * 12, quaterWidth * 6, quaterHeight * 8);
		house_small_red = objectsSheet.cropSector(quaterWidth * 8, quaterHeight * 20, quaterWidth * 6, quaterHeight * 8);
		house_big_blue = objectsSheet.cropSector(quaterWidth * 14, quaterHeight * 12, quaterWidth * 8, quaterHeight * 8); 
		house_big_red = objectsSheet.cropSector(quaterWidth * 14, quaterHeight * 20, quaterWidth * 8, quaterHeight * 8);
		clear_tree_big = objectsSheet.cropSector(quaterWidth * 14, quaterHeight * 8, quaterWidth * 4, quaterHeight * 4);
		tree_high = objectsSheet.cropSector(quaterWidth * 18, quaterHeight * 8, quaterWidth * 2, quaterHeight * 4);
		tree_round = objectsSheet.cropSector(quaterWidth * 24, quaterHeight * 8, quaterWidth * 4, quaterHeight * 4);
		tree_round_big = objectsSheet.cropSector(quaterWidth * 28, quaterHeight * 6, quaterWidth * 6, quaterHeight * 6);
		trunk_small = objectsSheet.cropSector(quaterWidth * 14, quaterHeight * 6, quaterWidth * 1, quaterHeight * 1);
		trunk = objectsSheet.cropSector(quaterWidth * 14, quaterHeight * 7, quaterWidth * 2, quaterHeight * 1);
		hay = objectsSheet.cropSector(quaterWidth * 16, quaterHeight * 4, quaterWidth * 4, quaterHeight * 4);
		box = objectsSheet.cropSector(quaterWidth * 20, quaterHeight * 4, quaterWidth * 1, quaterHeight * 2);
		box_small = objectsSheet.cropSector(quaterWidth * 21, quaterHeight * 4, quaterWidth * 1, quaterHeight * 2);
		key = objectsSheet.cropSector(quaterWidth * 27, quaterHeight * 0, quaterWidth * 1, quaterHeight * 1);
		sword = objectsSheet.cropSector(quaterWidth * 25, quaterHeight * 0, quaterWidth * 1, quaterHeight * 1);
		
		//Beute
		attack_1_interact = objectsSheet.cropSector(quaterWidth * 24 , quaterHeight * 0, quaterWidth, quaterHeight);
		attack_2_stick = objectsSheet.cropSector(quaterWidth * 26 , quaterHeight * 0, quaterWidth, quaterHeight);
		attack_3_sword= objectsSheet.cropSector(quaterWidth * 25 , quaterHeight * 0, quaterWidth, quaterHeight);
		attack_4_key = objectsSheet.cropSector(quaterWidth * 27 , quaterHeight * 0, quaterWidth, quaterHeight);
		
		paper_sheet_1 = objectsSheet.cropSector(quaterWidth * 9 , quaterHeight * 11, quaterWidth, quaterHeight);
		paper_sheet_2 = objectsSheet.cropSector(quaterWidth * 9 , quaterHeight * 10, quaterWidth, quaterHeight);
		paper_sheet_3 = objectsSheet.cropSector(quaterWidth * 8 , quaterHeight * 10, quaterWidth, quaterHeight);
		paper_sheet_4 = objectsSheet.cropSector(quaterWidth * 22 , quaterHeight * 1, quaterWidth, quaterHeight);
		paper_sheet_5 = objectsSheet.cropSector(quaterWidth * 23 , quaterHeight * 1, quaterWidth, quaterHeight);
		paper_sheet_6 = objectsSheet.cropSector(quaterWidth * 24 , quaterHeight * 1, quaterWidth, quaterHeight);
		paper_sheet_7 = objectsSheet.cropSector(quaterWidth * 25 , quaterHeight * 1, quaterWidth, quaterHeight);
		paper_sheet_8 = objectsSheet.cropSector(quaterWidth * 26 , quaterHeight * 1, quaterWidth, quaterHeight);
		
	}
}
