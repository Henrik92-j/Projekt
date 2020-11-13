package graphics;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Dimension;
import java.util.Collections;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

//import denSomSparHanHar.ReadFile;
//import denSomSparHanHar.WriteFile;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class HighScore extends JPanel {

	Font font = new Font("Serif", Font.PLAIN, 25);
	JLabel label = new JLabel("Flappy bird");
	private JTextArea resultText = new JTextArea(3, 1);
	FileWriter fileWriter;
	Window window;
	private ArrayList<Integer> highscoreArray;
	JLabel poang = new JLabel("dina poang");
	private HsManager hm = new HsManager();

	public HighScore(HsManager hm) {

		this.hm = hm;
		label.setFont(new Font("Serif", Font.PLAIN, 100));
		label.setForeground(Color.PINK);
		label.setBackground(Color.black);
		label.setAlignmentX(CENTER_ALIGNMENT);
		this.add(label);
		// this.add(results);

		highscoreArray = new ArrayList<Integer>();

		writeText();

		this.setBackground(Color.BLACK);

		poang.setForeground(Color.PINK);
		poang.setFont(new Font("Serif", Font.PLAIN, 50));
		poang.setForeground(Color.PINK);
		poang.setBackground(Color.white);
		poang.setAlignmentX(CENTER_ALIGNMENT);
		this.add(poang);
		resultText.setVisible(true);
		// resultText.setText("one\ntwo\nthree");
		resultText.setPreferredSize(new Dimension(600, 600));
		resultText.setFont((new Font("Serif", Font.PLAIN, 50)));
		this.add(resultText);

	}

	public void writeText() {

		highscoreArray = hm.ArrayTransfer();

		String tempString = null;

		int i = 1;

		for (int c = 0; c < highscoreArray.size(); c++) {

			tempString = highscoreArray.get(c).toString();

			resultText.append(i + ": " + tempString + "\n");

			i = i + 1;

		}

	}
}
