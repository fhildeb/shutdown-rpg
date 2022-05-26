package dev.shutdown.graphics;

import java.awt.image.BufferedImage;

/**
 * Diese Klasse realisiert die Animationen fuer die
 * Spielfigur beim Laufen und Attackieren.
 * 
 * @author Felix Hildebrandt
 *
 */
public class Animation {
	
	private int walkingSpeed, pictureIndex, timer;
	private long lastTime;
	private BufferedImage[] frames;
	
	/**
     * Es werden die Parameter Laufgeschwindigkeit und der
	 * Array mit allen Grafiken an die Animation uebergeben.
	 * Zudem wird die Standardgrafik, der Timer und die letzte
	 * Aktualisierung der Grafik mit dem Standardwert versehen.
	 * 
	 * @param walkingSpeed Laufgeschwindigkeit des Spielers
	 * @param frames Array mit allen Grafiken der Animation
	 */
	public Animation(int walkingSpeed, BufferedImage[] frames) {
		this.walkingSpeed = walkingSpeed;
		this.frames = frames;
		pictureIndex = 0; //Standard
		timer = 0;
		lastTime = System.currentTimeMillis();
	}
	
	/**
	 * Aktualisierung der Animation.
	 */
	public void tick() {
		timer += System.currentTimeMillis() - lastTime;
		lastTime = System.currentTimeMillis();
		
		if(timer > walkingSpeed) {
			pictureIndex = pictureIndex +1;
			timer = 0;
			if(pictureIndex >= frames.length)
				pictureIndex = 0;
		}
	}
	
	/**
	 * Zurueckgabe der aktuellen Grafik der Animation.
	 * 
	 * @return aktuelle Grafik der Animation
	 */
	public BufferedImage getCurrentFrame() {
		return frames[pictureIndex];
	}

}
