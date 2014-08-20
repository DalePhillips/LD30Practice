package co.uk.theburninghat.ld;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class Game extends Screen {

	public Level level;
	public Player player;
	public Inventory inv;
	public List<Entity> entities = new ArrayList<Entity>();

	public boolean testDown = false;
	private boolean paused = false, inventoryOpen = false;

	public Game() {
		level = new Level();
		player = new Player(20, 20);
		inv = new Inventory();
		entities.add(new Enemy(200, 200));
	}

	public void tick() {
		level.tick();
		if (!paused) {
			player.tick();

			for (Entity e : entities) {
				e.tick();
			}

			if (Main.getKey("E") && !Main.held) {
				Main.held = true;
				if (invOpen()) {
					setInventory(false);
				} else {
					setInventory(true);
				}
			}

			if (Main.isMouseLeft && !testDown) {
				addEntity(Main.mse.x, Main.mse.y);
				testDown = true;
			}

			if (Main.getKey("Z"))
				clearEntity();
		}

		if (Main.getKey("Q") && !Main.held) {
			Main.held = true;
			if (paused) {
				paused = false;
			} else {
				paused = true;
			}

		}

		if (!Main.isMouseLeft)
			testDown = false;
	}

	public void render(Graphics g) {
		g.setFont(new Font("Tahoma", Font.BOLD, 8));
		level.render(g);

		for (Entity e : entities) {
			e.render(g);
		}

		player.render(g);
		inv.render(g);

		if (paused) {
			g.setColor(new Color(0, 0, 0, 155));
			g.fillRect(0, 0, Main.getDrawableWidth(), Main.getDrawableHeight());

			g.setColor(Color.WHITE);
			FontMetrics f = g.getFontMetrics();
			int length = f.stringWidth("PAUSED");
			g.drawString("PAUSED", Main.getScaledWidth() / 2 - length / 2, Main.getScaledHeight() / 2);
		}

		g.setColor(Color.WHITE);
		g.drawString("Entities: " + entities.size(), 10, 10);
	}

	public void addEntity(int x, int y) {
		entities.add(new Enemy(x, y));
	}

	public void clearEntity() {
		entities.clear();
	}

	public void setInventory(boolean open) {
		inventoryOpen = open;
	}

	public boolean invOpen() {
		return inventoryOpen;
	}
}
