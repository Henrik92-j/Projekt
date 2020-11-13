package graphics;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;


public class LifeSymbol {

	private BufferedImage img;
	private Image img2;

	public LifeSymbol() {

		try {
			img = ImageIO.read(new File("Heart.png"));
		} catch (IOException e) {

		}

		img2 = img.getScaledInstance(30, 30, 5);

	}

	public void PaintYourself(Graphics g, int x) throws IOException {

		g.drawImage(img2, x, 5, null);

	}

}
