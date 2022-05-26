package dev.shutdown.audio;

import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import dev.shutdown.states.MenuState;

/**
 * Diese Klasse dient zur Wiedergeben von Musik waehrend des Spiels.
 * 
 * @author Felix Hildebrandt
 *
 */
public class Musicplayer {
	
	/**
	 * Es wird der Dateipfad sowie ein
	 * boolischer Wert, welcher angibt ob die Musik
	 * in Endlosschleife oder nur einmal abgespielt werden soll, uebergeben.
	 * Zudem erhaelt der Musicplayer eine Identifikationsnummer ueber
	 * welcher der erstellte Thread von Aussen fruehzeitig beendet werden kann.
	 * Nach dem Uebergeben wird die Audiospur in einem Thread wiedergegeben.	
	 *
	 * @param 	filepath 	Dateipfad der Musikdatei
	 * @param 	loop 		Boolischer Wert ob Musik in Endlosschleife
	 * 						abgespielt wird
	 * @param 	array		Identifikationsnummer fuer das fruehzeitige Beenden
	 * 						des Threads
	 */
	public static synchronized void music(String filepath, Boolean loop, int array) {
		new Thread(new Runnable() {
			@SuppressWarnings("static-access")
			public void run() {
				
				//Wenn Datei abgespielt werden soll
				Boolean wannaPlay = true;
				while(wannaPlay) {
					try {
						Clip clip = AudioSystem.getClip();
						URL url = this.getClass().getResource(filepath);
						AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(url);
						clip.open(audioInputStream);
						
						//Falls endlose Wiedergabe
						if(loop == true) {
							clip.loop(clip.LOOP_CONTINUOUSLY);
							long i = clip.getMicrosecondLength();
							
							//Pruefen auf fruehzeitiges Beenden aller 5 Millisekunden
							while(MenuState.getPlaying(array) && i > 0)
							{
								Thread.sleep(500);
								i = i - 500;
							}
							clip.stop();
							clip.close();
						}
						//Falls nur einfache Wiedergabe
						else {
							clip.start();
							Thread.sleep(clip.getMicrosecondLength()/1000);
							clip.stop();
							clip.close();
							wannaPlay = false;
							
						}
						clip.stop();
						clip.close();
						
						
					}catch(Exception e) {
						System.out.println("Fehler beim Abspielen der Musikspur");
					}
				}
			}
		}).start();
	}
}
