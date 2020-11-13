package logic;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import graphics.PlayerObject;
import graphics.PowerUps;
import graphics.StarPower;



public class StarPowerLogic extends PowerLogic {

	public StarPowerLogic(WallLogic wall, ArrayList<PowerUps> powerup, PlayerLogic player, PlayerObject player2) {
		super(wall, powerup, player, player2);
		
	}

	public void execute() {

		executor.scheduleAtFixedRate(starSpawner, 5, 5, TimeUnit.SECONDS);

	}

	Runnable starSpawner = new Runnable() {

		public void run() {

			getPowerup().add(new StarPower());

		}
	};

}
