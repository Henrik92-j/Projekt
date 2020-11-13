package graphics;

import java.awt.Color;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import logic.PowerLogic;

import logic.WallLogic;

public class SlowPowerUp extends PowerUps {

	public SlowPowerUp(Runnable runnable, WallLogic wall) {

	}

	ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);

	Runnable random1 = new Runnable() {
		public void run() {

			PowerLogic.speed = PowerLogic.speed - 2;
			WallLogic.speed = WallLogic.speed - 2;

		}
	};

	public void collisionEffect() {

		PowerLogic.speed = PowerLogic.speed + 2;
		WallLogic.speed = WallLogic.speed + 2;
		executor.schedule(random1, 4, TimeUnit.SECONDS);

	}

	@Override
	public Color getColor() {

		return Color.BLUE;

	}

}
