package logic;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Slowtime {

	ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);

	Runnable random1 = new Runnable() {
		public void run() {

			PowerLogic.speed = PowerLogic.speed - 2;
			WallLogic.speed = WallLogic.speed - 22;

		}
	};

	public void sleepy() {

		executor.scheduleAtFixedRate(random1, 0, 3, TimeUnit.SECONDS);

	}

}
