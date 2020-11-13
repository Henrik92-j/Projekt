package graphics;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.AbstractAction;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import logic.CollisonManager;
import logic.HealthPowerLogic;
import logic.LevelChanger;
import logic.PowerLogic;
import logic.SpeedEnemy;
import logic.SpeedPowerUp;
import logic.StarPowerLogic;
import logic.PlayerLogic;
import logic.WallLogic;


public class GamePanel extends JPanel {

	private static final long serialVersionUID = 1L;
	public static final int WIDTH = 800;
	public static final int HEIGHT = 800;
	private PlayerObject rectangle;
	private PlayerLogic rectLogic;
	private Walls wall;
	private WallLogic wallLogic;
	private CollisonManager collision;
	private LifeSymbol life = new LifeSymbol();
	private HealthPowerUp power1;
	private PowerLogic powerLogic1;
	private SpeedPowerUp powerLogic2;
	private StarPower star;
	private StarPowerLogic starLogic;
	private int timer;
	private SpeedEnemy speedEnemy;
	private LevelChanger level;

	public static int score = 0;

	ArrayList<PowerUps> powerup;

	ArrayList<Walls> walls;

	public GamePanel() {

		rectangle = new PlayerObject(WIDTH / 2, 10, 20, 20);
		rectLogic = new PlayerLogic(rectangle);
		level = new LevelChanger(rectLogic);
		star = new StarPower();
		power1 = new HealthPowerUp(rectLogic);
		powerup = new ArrayList<PowerUps>();
		speedEnemy = new SpeedEnemy();

		powerup.add(power1);
		powerup.add(star);

		walls = new ArrayList<Walls>();
		wall = new Walls(WIDTH);
		walls.add(wall);
		wallLogic = new WallLogic();

		powerLogic1 = new HealthPowerLogic(wallLogic, powerup, rectLogic, rectangle);
		powerLogic2 = new SpeedPowerUp(wallLogic, powerup, rectLogic, rectangle);
		starLogic = new StarPowerLogic(wallLogic, powerup, rectLogic, rectangle);
		collision = new CollisonManager(rectangle, wall, rectLogic, powerup, powerLogic1);

		this.getInputMap(WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("UP"), "press");
		this.getActionMap().put("press", new AbstractAction() {

			@Override
			public void actionPerformed(ActionEvent e) {
				rectLogic.jump();

			}
		});

	}

	public void timer() {

		if (timer / 50 == 30) {

			timer = 0;
		}

	}

	public void PowerupSpawner() {

		powerLogic1.execute();
		powerLogic2.execute();
		starLogic.execute();

	}

	public void paintComponent(Graphics g) {
		int x = 800;

		super.paintComponent(g);

		System.out.println(timer);

		g.setColor(Color.BLACK);
		g.fillRect(0, 0, WIDTH, HEIGHT);

		if (powerup.size() > 0) {

			for (int i = 0; i < powerup.size(); i++) {

				powerup.get(i).DrawYourself(g);

			}
		}

		rectangle.drawRectangle(g);
		wall.DrawWall(g);

		for (int i = 0; i < rectLogic.getLife(); i++) {

			x = x - 50;

			try {
				life.PaintYourself(g, x);

			} catch (IOException e) {

				e.printStackTrace();
			}
		}

		speedEnemy.PaintComponent(g, timer);
		level.PaintComponent(g, timer);
		
		
		g.setFont(new Font("Tahoma", Font.BOLD, 25));
		g.drawString("Score :" + score / 50, 650, 75);

	}

	public PlayerLogic getRectLogic() {
		return rectLogic;
	}

	public void update() {
		
		score = score + 1;
		timer = timer + 1;


		speedEnemy.triggerEnemy(timer);
		level.action(timer);

		timer();

		rectLogic.rectMovement();

		collision.collisonDetection();

		powerLogic1.move();

		for (int i = 0; i < walls.size(); i++) {
			{

				wallLogic.getWall(walls.get(i));
				wallLogic.wallMovement();
			}

		}

	}

}
