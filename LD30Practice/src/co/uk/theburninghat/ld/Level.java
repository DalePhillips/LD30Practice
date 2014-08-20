package co.uk.theburninghat.ld;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

import co.uk.theburninghat.ld.tiles.Grass;
import co.uk.theburninghat.ld.tiles.Sand;
import co.uk.theburninghat.ld.tiles.Stone;
import co.uk.theburninghat.ld.tiles.Water;

public class Level {

	private static final int MAP_WIDTH = (int) (Main.getDrawableWidth() / Main.SCALE) / 16, MAP_HEIGHT = (int) (Main.getDrawableHeight() / Main.SCALE) / 16;
	public Tile[][] tiles = new Tile[MAP_WIDTH][MAP_HEIGHT];

	public Level() {
		generateLevel();
	}

	public void tick() {
		for (int y = 0; y < tiles[0].length; y++) {
			for (int x = 0; x < tiles.length; x++) {
				tiles[x][y].tick();
			}
		}
	}

	public void render(Graphics g) {
		for (int y = 0; y < tiles[0].length; y++) {
			for (int x = 0; x < tiles.length; x++) {
				tiles[x][y].render(g);
			}
		}
	}
	
	public void generateLevel() {
		for (int y = 0; y < tiles[0].length; y++) {
			for (int x = 0; x < tiles.length; x++) {
				if (x == 0 || y == 0 || x == MAP_WIDTH - 1 || y == MAP_HEIGHT - 1)
					tiles[x][y] = new Water(new Rectangle(x * 16, y * 16, 16, 16));
				else
					tiles[x][y] = new Grass(new Rectangle(x * 16, y * 16, 16, 16));
			}
		}

		for (int y = 1; y < tiles[0].length - 1; y++) {
			for (int x = 1; x < tiles.length - 1; x++) {
				Random r = new Random();
				if (r.nextInt(10) < 3) {
					if (tiles[x - 1][y].getClass().getSimpleName().contains("Water") || tiles[x][y - 1].getClass().getSimpleName().contains("Water") || tiles[x + 1][y].getClass().getSimpleName().contains("Water") || tiles[x][y + 1].getClass().getSimpleName().contains("Water"))
						tiles[x][y] = new Water(new Rectangle(x * 16, y * 16, 16, 16));
				}
			}
		}

		for (int y = 1; y < tiles[0].length - 1; y++) {
			for (int x = 1; x < tiles.length - 1; x++) {
				if (tiles[x][y].getClass().getSimpleName().contains("Grass") && (tiles[x - 1][y].getClass().getSimpleName().contains("Water") || tiles[x][y - 1].getClass().getSimpleName().contains("Water") || tiles[x + 1][y].getClass().getSimpleName().contains("Water") || tiles[x][y + 1].getClass().getSimpleName().contains("Water")))
					tiles[x][y] = new Sand(new Rectangle(x * 16, y * 16, 16, 16));
			}
		}

		for (int y = 0; y < tiles[0].length; y++) {
			for (int x = 0; x < tiles.length; x++) {
				Random r = new Random();
				if (r.nextInt(10) == 1 && !tiles[x][y].getClass().getSimpleName().contains("Water") && !tiles[x][y].getClass().getSimpleName().contains("Sand")) {
					tiles[x][y] = new Stone(new Rectangle(x * 16, y * 16, 16, 16));
				}
			}
		}
	}

}
