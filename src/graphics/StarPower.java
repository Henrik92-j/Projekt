package graphics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class StarPower extends PowerUps {

	private BufferedImage img;
	private Image img2;

	public StarPower() {
		// this.setPreferredSize(new Dimension(30, 30));

		try {
			img = ImageIO.read(new File("Star2.png"));
		} catch (IOException e) {

		}

		img2 = img.getScaledInstance(30, 30, 5);

	}

	public void DrawYourself(Graphics g) {

		g.drawImage(img2, getX(), getY(), null);

	}

	@Override
	public void collisionEffect() {

		GamePanel.score = GamePanel.score + +250;

	}

	@Override
	public Color getColor() {
		
		return null;
	}

}
