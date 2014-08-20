package co.uk.theburninghat.ld;

import java.awt.Graphics;

public class Inventory {

	public int slotSize = 20, invWidth = 4, invHeight = 5;
	public InventorySlot[][] slots = new InventorySlot[invWidth][invHeight];

	public Inventory() {
		for (int y = 0; y < slots[0].length; y++) {
			for (int x = 0; x < slots.length; x++) {
				int centerLineX = (Main.getScaledWidth() - (slotSize * invWidth) - (invWidth * 4));
				int centerLineY = (Main.getScaledHeight() - (slotSize * invHeight) - (invHeight * 4));
				slots[x][y] = new InventorySlot((centerLineX) + (x * slotSize) + (x * 4), (centerLineY / 2) + (y * slotSize) + (y * 4));
			}
		}
		slots[invWidth - 1][0].setID(1);
	}

	public void tick() {
		for (int y = 0; y < slots[0].length; y++) {
			for (int x = 0; x < slots.length; x++) {
				slots[x][y].tick();
			}
		}
	}

	public void render(Graphics g) {
		for (int y = 0; y < slots[0].length; y++) {
			slots[slots.length - 1][y].render(g);
		}

		if (Main.screen.game.invOpen())
			for (int y = 0; y < slots[0].length; y++) {
				for (int x = 0; x < slots.length; x++) {
					if (x != slots.length - 1)
						slots[x][y].render(g);
				}
			}
	}

}
