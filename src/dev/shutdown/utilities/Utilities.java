package dev.shutdown.utilities;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Diese Klasse dient zum Laden von
 * Informationen aus Textdateien.
 * 
 * @author Felix Hildebrandt
 *
 */
public class Utilities {
	
	/**
	 * Laden der Spielwelt-Zeichenkette aus einer Textdatei.
	 * 
	 * @param 	path Pfad der Textdatei
	 * @return	Zeichenkette der Spielwelt
	 */
	public String loadFileAsString(String path){
		StringBuilder builder = new StringBuilder();
		try{
			InputStream stream = this.getClass().getResourceAsStream(path);
			BufferedReader br = new BufferedReader(new InputStreamReader(stream, "UTF-8"));
			String line;
			while((line = br.readLine()) != null)
				builder.append(line + "\n");
			
			br.close();
		}catch(IOException e){
			e.printStackTrace();
		}
		
		return builder.toString();
	}
	
	/**
	 * Eine Zeichenkette der Spielwelt
	 * in Integerwerte umwandeln damit diese den Identifikationsnummern
	 * der Hintergruenden in der Spielwelt zugeschrieben werden koennen.
	 * 
	 * @param number Zeichenkette der Spielwelt
	 * @return Identifikationsnummern der Spielwelt-Hintergruende
	 */
	public static int parseInt(String number){
		try{
			return Integer.parseInt(number);
		}catch(NumberFormatException e){
			e.printStackTrace();
			return 0;
		}
	}

}