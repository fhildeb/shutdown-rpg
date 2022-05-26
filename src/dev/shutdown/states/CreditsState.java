package dev.shutdown.states;

import java.awt.Graphics;

import dev.shutdown.Handler;
import dev.shutdown.graphics.Assets;

/**
 * Diese Klasse dient zum Erstellen eines Credit-Zustands im Spiel
 * bei welchem dem Benutzer die Danksagungen und Quellen
 * von benutzten Grafiken angezeigt werden.
 * 
 * @author Felix Hildebrandt
 *
 */
public class CreditsState extends State {
	/**
	 * Es wird der Handler des Credit-States an die
	 * Oberklasse uebergeben.
	 * 
	 * @param handler Hander des Credit-Zustandes
	 */
	public CreditsState(Handler handler){
		super(handler);
	}
	
	@Override
	public void tick() {
		GameState.invUIManager.tick();
	}

	@Override
	public void render(Graphics paintbrush) {
		paintbrush.drawImage(Assets.credits,0, 0, null);
		GameState.invUIManager.render(paintbrush);
	}

}
