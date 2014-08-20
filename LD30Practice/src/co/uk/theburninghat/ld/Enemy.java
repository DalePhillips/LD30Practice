package co.uk.theburninghat.ld;

import java.awt.Graphics;

public class Enemy extends Entity {

	private static final long serialVersionUID = 1L;

	public double speed = 1;

	public Enemy(int x, int y) {
		super(x, y);
	}

	public void tick() {
		if (distanceTo(Main.screen.game.player) < 150) {
			move(Main.screen.game.player.x, Main.screen.game.player.y);
		}
	}

	public void render(Graphics g) {
		Images.getEntityTile(g, 0, 1, x, y);
	}

	public void move(int destX, int destY) {
		if (x == destX && y == destY)
			return;
		if (x < destX)
			x++;
		else
			x--;
		if (y < destY)
			y++;
		else
			y--;
	}

}
