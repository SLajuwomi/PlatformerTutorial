package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;

import inputs.KeyboardInputs;
import inputs.MouseInputs;

public class GamePanel extends JPanel {

	private MouseInputs mouseInputs;
	private float xDelta = 100, yDelta = 100;
	private float xDir = 1f, yDir = 1f;
	private Color color = new Color(150, 20, 90);
	private Random random;

	public GamePanel() {
		random = new Random();
		mouseInputs = new MouseInputs(this);
		setPanelSize();
		addKeyListener(new KeyboardInputs(this));
		addMouseListener(mouseInputs);
		addMouseMotionListener(mouseInputs);

	}

	private void setPanelSize() {
		Dimension size = new Dimension(1280, 800);
		setMinimumSize(size);
		setPreferredSize(size);
		setMaximumSize(size);
	}

	public void changeXDelta(int value) {
		this.xDelta += value;

	}

	public void changeYDelta(int value) {
		this.yDelta += value;

	}

	public void setRectPos(int x, int y) {
		this.xDelta = x;
		this.yDelta = y;
	}

	public void spawnRect(int x, int y) {
		rects.add(new MyRect(x, y));
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		updateRectangle();

		g.setColor(color);
		g.fillRect((int) xDelta, (int) yDelta, 200, 50);

	}

	private void updateRectangle() {
		xDelta += xDir;
		if (xDelta > 400 || xDelta < 0) {
			xDir *= -1;
			color = getRndColor();
		}

		yDelta += yDir;
		if (yDelta > 400 || yDelta < 0) {
			yDir *= -1;
			color = getRndColor();
		}
	}

	private Color getRndColor() {
		int r = random.nextInt(255);
		int g = random.nextInt(255);
		int b = random.nextInt(255);

		return new Color(r, g, b);
	}

	private Color newColor() {
		return new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255));
	}

}
