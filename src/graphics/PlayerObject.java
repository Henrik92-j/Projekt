package graphics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class PlayerObject extends Rectangle {

	private static final long serialVersionUID = 1L;

	private int x;
	private int y;
	private int height;
	private int width;
	

	public PlayerObject(int x, int y, int width, int height) {

		this.x = x;
		this.y = y;
		this.height = height;
		this.width = width;

	}

	public int getHHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getXX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getYY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void drawRectangle(Graphics g) {

		g.setColor(Color.orange);
		g.fillRect(x, y, height, width);
	}

}
