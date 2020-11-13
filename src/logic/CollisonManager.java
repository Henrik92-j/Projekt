package logic;

import java.awt.Rectangle;
import java.util.ArrayList;

import graphics.GamePanel;
import graphics.HealthPowerUp;
import graphics.HealthPowerUp;
import graphics.LifeSymbol;
import graphics.PlayerObject;
import graphics.PowerUps;
import graphics.Walls;

public class CollisonManager {

	private PlayerObject rectangle;
	private Rectangle rect;
	private Walls wall;
	private PlayerLogic life;
	private ArrayList<PowerUps> powerup;
	private Rectangle healthboy;

	public Rectangle getRect() {
		return rect;
	}

	public void setRect(Rectangle rect) {
		this.rect = rect;
	}

	public Rectangle getHealthboy() {
		return healthboy;
	}

	public void setHealthboy(Rectangle healthboy) {
		this.healthboy = healthboy;
	}

	public CollisonManager(PlayerObject rectangle, Walls wall, PlayerLogic life, ArrayList<PowerUps> powerup,
			PowerLogic power) {

		this.wall = wall;
		this.rectangle = rectangle;
		this.life = life;
		this.powerup = powerup;
		
	}

//	public void getPowerup(PowerUps healthpowerup) {
//
//		this.healthpowerup = healthpowerup;
//
//	}

	public CollisonManager collisonDetection() {

		// this.healthboy = new Rectangle(healthpowerup.getX(),healthpowerup.getY(),
		// healthpowerup.getWidth(), healthpowerup.getHeight());

		Rectangle lowerRect = new Rectangle(wall.getX(), wall.getY(), wall.getWidth(), wall.getHeight());

		Rectangle upperRect = new Rectangle(wall.getX(), 0, wall.getWidth(), (wall.getY() - wall.getGap()));

		this.rect = new Rectangle(rectangle.getXX(), rectangle.getYY(), rectangle.getWWidth(), rectangle.getHHeight());

		if (lowerRect.intersects(rect) || upperRect.intersects(rect) || rectangle.getYY() <= 0
				|| rectangle.getYY() >= 800 - 60) {

			rectangle.setY(400);
			wall.setX(GamePanel.WIDTH);
			life.setLife(life.getLife() - 1);
			life.setGravity(-1);

			for (int i = 0; i < powerup.size(); i++) {

				powerup.get(i).setX(GamePanel.WIDTH + 200);

			}

		}
		return this;

	}

}
