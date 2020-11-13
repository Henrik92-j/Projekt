package graphics;

import java.awt.Color;
import java.awt.Dimension;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Mainmenu extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	public static final int WIDTH = 800;
	public static final int HEIGHT = 800;

	Font font = new Font("Serif", Font.PLAIN, 50);
	JButton Startbutton = new JButton("Start");
	JButton Scorebutton = new JButton("Score");
	JButton Quitbutton = new JButton("Quit");
	JLabel label = new JLabel("Flappy bird");

	graphics.Window window;

	public Mainmenu(graphics.Window window2) {

		this.window = window2;

		label.setFont(new Font("Serif", Font.PLAIN, 100));
		label.setForeground(Color.PINK);
		label.setAlignmentX(CENTER_ALIGNMENT);
		this.add(label);

		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		this.add(Box.createRigidArea(new Dimension(0, 100)));
		Startbutton.setFont(font);
		Startbutton.setPreferredSize(new Dimension(400, 100));
		Startbutton.setMinimumSize(new Dimension(200, 50));
		Startbutton.setMaximumSize(new Dimension(400, 100));
		Startbutton.setAlignmentX(CENTER_ALIGNMENT);
		Startbutton.addActionListener(this);

		this.add(Startbutton);

		this.add(Box.createRigidArea(new Dimension(0, 50)));
		Scorebutton.setFont(font);
		Scorebutton.setPreferredSize(new Dimension(400, 100));
		Scorebutton.setMinimumSize(new Dimension(200, 50));
		Scorebutton.setMaximumSize(new Dimension(400, 100));
		Scorebutton.setAlignmentX(CENTER_ALIGNMENT);
		Scorebutton.addActionListener(this);
		this.add(Scorebutton);

		this.add(Box.createRigidArea(new Dimension(0, 50)));
		Quitbutton.setFont(font);
		Quitbutton.setPreferredSize(new Dimension(400, 100));
		Quitbutton.setMinimumSize(new Dimension(200, 50));
		Quitbutton.setMaximumSize(new Dimension(400, 100));
		Quitbutton.setAlignmentX(CENTER_ALIGNMENT);
		Quitbutton.addActionListener(this);
		this.add(Quitbutton);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == Quitbutton) {
			System.exit(0);
		} else if (e.getSource() == Scorebutton) {

			window.swapToHighscore();

		} else if (e.getSource() == Startbutton) {

			window.swapToGamepanel();

		}

	}

	public void paintComponent(Graphics g) {

		super.paintComponent(g);

		g.setColor(Color.BLACK);
		g.fillRect(0, 0, WIDTH, HEIGHT);

	}

}
