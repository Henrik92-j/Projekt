package logic;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import graphics.GamePanel;

public class SpeedEnemy {

	public SpeedEnemy() {

	}

	ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);

	Runnable random1 = new Runnable() {
		public void run() {

			PowerLogic.speed = PowerLogic.speed + 2;
			WallLogic.speed = WallLogic.speed + 2;

		}
	};

	public void triggerEnemy(int x) {

		if (x == 1000) {

			PowerLogic.speed = PowerLogic.speed - 2;
			WallLogic.speed = WallLogic.speed - 2;
			executor.schedule(random1, 5, TimeUnit.SECONDS);
		}

	}

	public void PaintComponent(Graphics g, int x) {

		if (x > 960 & x < 1000) {

			g.setColor(Color.RED);

			g.setFont(new Font("Tahoma", Font.BOLD, 25));
			g.drawString("SPEED INCREASING", GamePanel.WIDTH / 2 - 200, GamePanel.HEIGHT / 2 - 100);

		}

	}

}
