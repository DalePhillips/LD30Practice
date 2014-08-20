package co.uk.theburninghat.ld;

import java.awt.Graphics;

public class ScreenManager {
	
	public Game game;
	
	public ScreenManager() {
		game = new Game();
	}
	
	public void tick() {
		// Placeholder to test
		game.tick();
	}
	
	public void render(Graphics g) {
		game.render(g);
	}

}
