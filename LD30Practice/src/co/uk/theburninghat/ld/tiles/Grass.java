package co.uk.theburninghat.ld.tiles;

import java.awt.Graphics;
import java.awt.Rectangle;

import co.uk.theburninghat.ld.Images;
import co.uk.theburninghat.ld.Tile;

public class Grass extends Tile {

	private static final long serialVersionUID = 1L;

	public Grass(Rectangle r) {
		super(r);
	}
	
	public void render(Graphics g) {
		Images.getTerrainTile(g, 0, 0, x, y);
	}

}
