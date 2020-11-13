package graphics;

import java.awt.Graphics;

import java.util.Random;

public class Walls {

	private Random random = new Random();
	private int x;
	private int Y = random.nextInt(GamePanel.HEIGHT - 400) + 200; // min 200, max 600
	private int width = 45;
	private int height = GamePanel.HEIGHT - Y;
	private int gap = 125;

	public Walls(int x) {

		this.x = x;

	}

	public void DrawWall(Graphics g) {

		g.fillRect(x, Y, width, height); // Bottom wall

		g.fillRect(x, 0, width, (Y - gap)); // Top wall

	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return Y;
	}

	public void setY(int y) {
		Y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getGap() {
		return gap;
	}

	public void setGap(int gap) {
		this.gap = gap;
	}

}
