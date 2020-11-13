package graphics;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public abstract class PowerUps {


	private static final long serialVersionUID = 1L;

	private Random random = new Random();

	private int x = GamePanel.WIDTH + GamePanel.WIDTH / 2;
	private int y = random.nextInt(350) + 100; // min 200, max 600
	private int height = 25;
	private int width = 25;

	public PowerUps() {

	}

	public abstract void collisionEffect();

	public abstract Color getColor();

	public int getX() {
		return x;

	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public void DrawYourself(Graphics g) {

		g.setColor(getColor());
		g.fillRect(x, y, height, width);
	}

}
