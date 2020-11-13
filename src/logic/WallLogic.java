package logic;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Random;
import graphics.GamePanel;
import graphics.Walls;


public class WallLogic {
	private Random random = new Random();
	public static int speed = -7;
	private Walls wall;

	public WallLogic(Walls wall) {

		this.wall = wall;

	}

	public WallLogic() {

	}

	public void getWall(Walls wall) {

		this.wall = wall;

	}

	public void wallCollision() {

		Rectangle lowerRect = new Rectangle(wall.getX(), wall.getY(), wall.getWidth(), wall.getHeight());

		Rectangle upperRect = new Rectangle(wall.getX(), 0, wall.getWidth(), (wall.getY() - wall.getGap()));

	}

	public void wallMovement() {

		int tempX = wall.getX();

		tempX += speed;

		wall.setX(tempX);

		if (wall.getX() <= -wall.getWidth()) {

			int tempY = wall.getY();
			int tempHeight = wall.getHeight();

			wall.setX(GamePanel.WIDTH);
			tempY = random.nextInt(GamePanel.HEIGHT - 400) + 200;
			wall.setY(tempY);
			tempHeight = GamePanel.HEIGHT - tempY;
			wall.setHeight(tempHeight);
		}

	}

}
