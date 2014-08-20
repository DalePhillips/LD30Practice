package co.uk.theburninghat.ld;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class InventorySlot extends Rectangle {

	private static final long serialVersionUID = 1L;
	private int holdingID = 0;

	public InventorySlot(int x, int y) {
		setBounds(x, y, 20, 20);
	}

	public void tick() {

	}

	public void render(Graphics g) {
		g.setColor(Color.PINK);
		g.fillRect(x, y, width, height);
		g.setColor(Color.BLACK);
		g.drawRect(x, y, width, height);
		if (holdingID != 0)
			Images.getTerrainTile(g, holdingID-1, 0, x + 2, y + 2);
	}

	public int getID() {
		return holdingID;
	}

	public void setID(int id) {
		holdingID = id;
	}

}
