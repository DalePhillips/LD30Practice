package co.uk.theburninghat.ld;

import java.awt.Graphics;
import java.awt.Rectangle;

public class Entity extends Rectangle {

	private static final long serialVersionUID = 1L;

	public Entity(int x, int y) {
		setBounds(x, y, 20, 20);
	}

	public void tick() {

	}

	public void render(Graphics g) {

	}

	public int distanceTo(Rectangle r) {
		int a = x - r.x;
		int b = y - r.y;
		int c = (int) Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
		return c;
	}
}
