package graphics;

import java.awt.Color;

import logic.PlayerLogic;


public class HealthPowerUp extends PowerUps {

	private PlayerLogic player;
	
	
	public HealthPowerUp (PlayerLogic player) {
		
		this.player = player;
		
	}

	
	public void collisionEffect () {
		
		player.increaseLife();
		
		
	}
	
	
	
	
	@Override
	public Color getColor() {
	
		return Color.RED;
	}
	
	
}
