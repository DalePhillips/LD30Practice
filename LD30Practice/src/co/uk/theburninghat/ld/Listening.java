package co.uk.theburninghat.ld;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Listening implements KeyListener, MouseListener, MouseMotionListener {

	public void keyPressed(KeyEvent e) {
		Main.keys.put(KeyEvent.getKeyText(e.getExtendedKeyCode()), true);
	}

	public void keyReleased(KeyEvent e) {
		Main.keys.put(KeyEvent.getKeyText(e.getExtendedKeyCode()), false);
	}

	public void keyTyped(KeyEvent e) {
	}

	public void mouseDragged(MouseEvent e) {
		Main.mse.setLocation(e.getX() / Main.SCALE, e.getY() / Main.SCALE);
	}

	public void mouseMoved(MouseEvent e) {
		Main.mse.setLocation(e.getX() / Main.SCALE, e.getY() / Main.SCALE);
	}

	public void mousePressed(MouseEvent e) {
		if (e.getButton() == MouseEvent.BUTTON1)
			Main.isMouseLeft = true;
		else if (e.getButton() == MouseEvent.BUTTON3)
			Main.isMouseRight = true;
	}

	public void mouseReleased(MouseEvent e) {
		if (e.getButton() == MouseEvent.BUTTON1)
			Main.isMouseLeft = false;
		else if (e.getButton() == MouseEvent.BUTTON3)
			Main.isMouseRight = false;
	}

	public void mouseExited(MouseEvent e) {
	}

	public void mouseClicked(MouseEvent e) {
	}

	public void mouseEntered(MouseEvent e) {
	}

}
