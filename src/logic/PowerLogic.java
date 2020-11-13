package logic;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import graphics.GamePanel;
import graphics.HealthPowerUp;
import graphics.HealthPowerUp;
import graphics.PlayerObject;
import graphics.PowerUps;
import graphics.SlowPowerUp;
import graphics.Walls;

public abstract class PowerLogic {

	private PowerUps object;
	public static int speed = -7;
	private PlayerLogic player1;
	private ArrayList<PowerUps> powerup;
	private PlayerObject rect;
	private WallLogic wall;

	public PowerLogic(WallLogic wall, ArrayList<PowerUps> powerup, PlayerLogic player, PlayerObject player2) {

		this.powerup = powerup;
		this.player1 = player;
		this.rect = player2;
		this.wall = wall;
	}

	public PlayerLogic getPlayer1() {
		return player1;
	}

	public void setPlayer1(PlayerLogic player1) {
		this.player1 = player1;
	}

	public void Collision() {

		Rectangle healthboy = new Rectangle(object.getX(), object.getY(), object.getWidth(), object.getHeight());
		Rectangle player = new Rectangle(rect.getXX(), rect.getYY(), rect.getWWidth(), rect.getHHeight());

		if (healthboy.intersects(player)) {

			object.collisionEffect();
			powerup.remove(object);

		}

	}

	public void move() {

		for (int i = 0; i < powerup.size(); i++) {

			add(i);

			if (object.getX() <= -object.getWidth()) {

				powerup.remove(object);
			}

			int tempX = object.getX();
			tempX += speed;

			object.setX(tempX);

			Collision();

		}
	}

	ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);

	public void execute() {

	}

	public WallLogic getWall() {
		return wall;
	}

	public void setWall(WallLogic wall) {
		this.wall = wall;
	}

	public PlayerObject getRect() {
		return rect;
	}

	public void setRect(PlayerObject rect) {
		this.rect = rect;
	}

	public ArrayList<PowerUps> getPowerup() {
		return powerup;
	}

	public void setPowerup(ArrayList<PowerUps> powerup) {
		this.powerup = powerup;
	}

	public void effect() {
		object.collisionEffect();

	}

	public void add(int i) {
		this.object = powerup.get(i);

	}

}
