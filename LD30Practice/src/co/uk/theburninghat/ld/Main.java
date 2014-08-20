package co.uk.theburninghat.ld;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.image.BufferStrategy;
import java.util.HashMap;

import javax.swing.JFrame;

public class Main extends Canvas implements Runnable {

	private static final long serialVersionUID = 1L;
	public static double SCALE = 2.0;
	public static final int WIDTH = 1024, HEIGHT = WIDTH / 16 * 9;
	public static final Dimension SIZE = new Dimension(WIDTH, HEIGHT);
	public static final String NAME = "Ludum Dare Practice";
	private boolean isRunning = false;
	private BufferStrategy bs;
	private static JFrame frame;
	public static int globalTicks;
	public static boolean held;

	public static HashMap<String, Boolean> keys = new HashMap<String, Boolean>();
	public static Point mse = new Point(0, 0);
	public static boolean isMouseLeft = false, isMouseRight = false;

	public static ScreenManager screen;

	public Main() {
		requestFocus();
		addKeyListener(new Listening());
		addMouseListener(new Listening());
		addMouseMotionListener(new Listening());

		new Images();

		screen = new ScreenManager();
	}

	public synchronized void start() {
		isRunning = true;
		new Thread(this).start();
	}

	public synchronized void stop() {
		isRunning = false;
	}

	public void tick() {
		screen.tick();
		if(!keys.containsValue(true)) {
			held = false;
		}
	}

	public void render() {
		if (bs == null) {
			createBufferStrategy(3);
			bs = this.getBufferStrategy();
			return;
		}

		Graphics g = bs.getDrawGraphics();
		Graphics2D g2d = (Graphics2D) g;
		g2d.scale(SCALE, SCALE);
		g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, SIZE.width, SIZE.height);
		screen.render(g);
		g.dispose();
		g2d.dispose();
		bs.show();
	}

	public static void main(String[] args) {
		Main main = new Main();
		frame = new JFrame();
		frame.add(main);
		frame.pack();

		frame.setTitle("Ludum Dare Practice");
		SIZE.setSize(new Dimension(SIZE.width + frame.getInsets().left - 2, SIZE.height + frame.getInsets().top - 2));
		frame.setSize(SIZE);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

		main.start();
	}

	public void run() {
		long currenttime;
		long previoustime = System.nanoTime();
		long passedtime;
		int frames = 0;
		double unprocessedseconds = 0;
		double secondspertick = 1 / 60.0;
		int tickcount = 0;
		boolean ticked = false;

		while (isRunning) {
			currenttime = System.nanoTime();
			passedtime = currenttime - previoustime;
			previoustime = currenttime;
			unprocessedseconds += passedtime / 1000000000.0;

			while (unprocessedseconds > secondspertick) {
				tick();
				unprocessedseconds -= secondspertick;
				ticked = true;
				tickcount++;
				globalTicks++;
				if (tickcount % 60 == 0) {
					System.out.println(frames + " FPS " + tickcount + " TPS");
					previoustime += 1000;
					frames = 0;
					tickcount = 0;
				}
			}
			if (ticked) {
				render();
				frames++;
			}
		}
	}

	public static boolean getKey(String key) {
		if (keys.get(key) != null) {
			return keys.get(key);
		}
		return false;
	}

	public static int getDrawableWidth() {
		return WIDTH;
	}

	public static int getDrawableHeight() {
		return HEIGHT;
	}

	public static int getScaledWidth() {
		return (int) (WIDTH / Main.SCALE);
	}

	public static int getScaledHeight() {
		return (int) (HEIGHT / Main.SCALE);
	}
}
