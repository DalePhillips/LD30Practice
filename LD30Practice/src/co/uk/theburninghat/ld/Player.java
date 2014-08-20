package co.uk.theburninghat.ld;

import java.awt.Graphics;

public class Player extends Entity {

	private static final long serialVersionUID = 1L;
	private Animation anim;

	public double speed = 2;

	public Player(int x, int y) {
		super(x, y);
		anim = new Animation(1, 10, 0, x, y);
	}

	public void tick() {
		anim.tick(x, y);
		if (Main.getKey("W"))
			y -= speed;
		if (Main.getKey("S"))
			y += speed;
		if (Main.getKey("A"))
			x -= speed;
		if (Main.getKey("D"))
			x += speed;
	}

	public void render(Graphics g) {
		anim.render(g);
	}

}
