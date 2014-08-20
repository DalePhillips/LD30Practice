package co.uk.theburninghat.ld;

import java.awt.Graphics;

public class Animation {

	private int id;
	private int sheetY;
	private int tpf, frame;
	private int x, y;

	private Timer timer;

	public Animation(int id, int tpf, int sheetY, int x, int y) {
		this.id = id;
		this.tpf = tpf;
		this.sheetY = sheetY;
		this.x = x;
		this.y = y;
		timer = new Timer();
		timer.start(tpf);
	}

	public void tick(int x, int y) {
		this.x = x;
		this.y = y;
		if (timer.isDone()) {
			frame++;
			timer.start(tpf);
		}
		if(frame == 5) frame = 0;
	}

	public void render(Graphics g) {
		if (id == 1) {
			Images.getEntityTile(g, frame, sheetY, x, y);
		}
	}

	public void updateLocation(int x, int y) {
		this.x = x;
		this.y = y;
	}

}
