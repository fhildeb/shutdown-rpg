package dev.shutdown.audio;

import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 * Diese Klasse dient zur Wiedergeben von Effekt-Toenen waehrend des Spiels.
 * 
 * @author Felix Hildebrandt
 *
 */
public class Soundplayer {
	
	/**
	 * Es wird der Dateipfad zum Ton uebergeben und die
	 * dazugehoerige Audiospur in einem Thread abgespielt.
	 * 
	 * @param filepath Pfad der Tondatei
	 */
	public static synchronized void music(String filepath) {
		new Thread(new Runnable() {
			public void run() {
				
				//Wenn Ton abgespielt werden soll
				Boolean wannaPlay = true;
				while(wannaPlay) {
					try {
						Clip clip = AudioSystem.getClip();
						URL url = this.getClass().getResource(filepath);
						AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(url);
						clip.open(audioInputStream);
						clip.start();
							Thread.sleep(500);
						clip.stop();
						clip.close();
							wannaPlay = false;	
					}catch(Exception e) {
						e.printStackTrace();
					}
				}
			}
		}).start();
	}
}
