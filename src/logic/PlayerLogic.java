package logic;

import graphics.GamePanel;
import graphics.PlayerObject;

public class PlayerLogic {

	private float gravity = -1;
	private PlayerObject rect;
	private int life = 5;
	private float acceleration = (float) 0.3;

	public PlayerLogic(PlayerObject rect) {

		this.rect = rect;

	}

	public void jump() {

		if (rect.getYY() >= 0 && rect.getYY() <= GamePanel.HEIGHT) {

			gravity -= 6;

		}

	}

	public void rectMovement() {

		int k = rect.getYY();

		if (rect.getYY() >= 0 && rect.getYY() <= GamePanel.HEIGHT) {

			gravity += acceleration;

			k += gravity;

			rect.setY(k);
		}

	}

	public void increaseLife() {

		life = life + 1;

	}

	public float getAcceleration() {
		return acceleration;
	}

	public void setAcceleration(float acceleration) {
		this.acceleration = acceleration;
	}

	public int getLife() {
		return life;
	}

	public void setLife(int life) {
		this.life = life;
	}

	public void setGravity(float gravity) {
		this.gravity = gravity;
	}

}
