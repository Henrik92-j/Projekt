package logic;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import graphics.HealthPowerUp;
import graphics.PlayerObject;
import graphics.PowerUps;
import graphics.SlowPowerUp;
import graphics.Walls;

public class SpeedPowerUp extends PowerLogic {

	public SpeedPowerUp(WallLogic wall, ArrayList<PowerUps> powerup, PlayerLogic player, PlayerObject player2) {
		super(wall, powerup, player, player2);

	}

	public void execute() {

		executor.scheduleAtFixedRate(kek, 8, 16, TimeUnit.SECONDS);

	}

	Runnable kek = new Runnable() {

		public void run() {

			getPowerup().add(new SlowPowerUp(this, getWall()));

		}
	};

	@Override
	public void effect() {

	}

}
