package logic;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import graphics.HealthPowerUp;
import graphics.PlayerObject;
import graphics.PowerUps;
import graphics.Walls;


public class HealthPowerLogic extends PowerLogic {

	public HealthPowerLogic(WallLogic wall, ArrayList<PowerUps> powerup, PlayerLogic player, PlayerObject player2) {
		super(wall, powerup, player, player2);

	}

	public void execute() {

		executor.scheduleAtFixedRate(helloRunnable2, 10, 10, TimeUnit.SECONDS);

	}

	Runnable helloRunnable2 = new Runnable() {

		public void run() {

			getPowerup().add(new HealthPowerUp(getPlayer1()));

		}
	};

	@Override
	public void effect() {

	}

}
