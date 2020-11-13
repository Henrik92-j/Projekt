package logic;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import graphics.GamePanel;

public class LevelChanger {

	private PlayerLogic player;
	private int state = 1;

	public LevelChanger(PlayerLogic player) {

		this.player = player;

	}

	ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);

	Runnable random1 = new Runnable() {
		public void run() {

			PowerLogic.speed = -8;
			WallLogic.speed = -8;
			player.setGravity(1);
			player.setAcceleration((float) 0.3);
			state = 2;
		}
	};

	public void action(int x) {

		if (x == 1500) {

			PowerLogic.speed = 0;
			WallLogic.speed = 0;
			player.setGravity(0);
			player.setAcceleration(0);
			executor.schedule(random1, 3, TimeUnit.SECONDS);

		}

		if (x == 1500 & state == 2) {

			GamePanel.score = (int) (GamePanel.score * (player.getLife() * 0.05 + 1));

			player.setLife(0);

		}

	}

	public void PaintComponent(Graphics g, int x) {

		if (x >= 1450) {

			g.setColor(Color.RED);
			g.setFont(new Font("Tahoma", Font.BOLD, 50));
			g.drawString("NEXT LEVEL REACHED, DIFFICULTY INCREASED", GamePanel.WIDTH / 2 - 200,
					GamePanel.HEIGHT / 2 - 100);

		}

	}

}
