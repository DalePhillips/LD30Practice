package co.uk.theburninghat.ld;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Images {

	public static BufferedImage terrain, entities;

	public Images() {
		terrain = loadImage("terrain.png");
		entities = loadImage("entities.png");
	}

	public BufferedImage loadImage(String name) {
		try {
			return ImageIO.read(Images.class.getResource("/" + name));
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.err.println("Could not load image: " + name);
		return null;
	}

	public static void getTerrainTile(Graphics g, int tileX, int tileY, int x, int y) {
		g.drawImage(terrain, x, y, x + 16, y + 16, tileX * 16, tileY * 16, (tileX * 16) + 16, (tileY * 16) + 16, null);
	}
	
	public static void getEntityTile(Graphics g, int tileX, int tileY, int x, int y) {
		g.drawImage(entities, x, y, x + 20, y + 20, tileX * 20, tileY * 20, (tileX * 20) + 20, (tileY * 20) + 20, null);
	}

}
