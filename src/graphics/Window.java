package graphics;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;
import javax.swing.Timer;


public class Window {
	public int gravity;
	public final int Width = 800;
	public final int Height = 800;
	private Timer timer;
	private JFrame jframe;
	private GamePanel gp;
	private Mainmenu menu;
	private HighScore highscore;
	private HsManager hm;

	public Window() {

		jframe = new JFrame();
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jframe.setSize(Width, Height);
		jframe.setResizable(true);
		jframe.setTitle("BAD GAME");
		jframe.setLocationRelativeTo(null);
		hm = new HsManager();						// Kolla upp HSManager

	}

	public void run1() {							// 

		menu = new Mainmenu(this);
		gp = new GamePanel();

		
		jframe.add(menu);
		jframe.setVisible(true);

		gp.PowerupSpawner();  

		
		
		if (gp.getRectLogic().getLife() > 0) {

			timer = new Timer(20, new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					if (gp.getRectLogic().getLife() > 0) {

						gp.update();
						gp.repaint();
						Toolkit.getDefaultToolkit().sync();

					}

					else {
						hm.SaveData2(GamePanel.score/50);
						timer.stop();
						jframe.remove(gp);
						jframe.dispose();
						jframe.add(menu);
						jframe.revalidate();
						jframe.setVisible(true);
				
					}

				}
			});

		}



	}

	public void swapToHighscore() {
		highscore = new HighScore(hm);
		jframe.remove(menu);
		jframe.add(highscore);
		jframe.revalidate();

	}

	public static void main(String[] args) {

		Window mainframe = new Window();
		mainframe.run1();

	}

	public void swapToGamepanel() {
	
		jframe.remove(menu);
		jframe.add(gp);
		timer.start();
		jframe.revalidate();
	}

}
