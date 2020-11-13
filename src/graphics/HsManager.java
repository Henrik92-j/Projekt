package graphics;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class HsManager {

	private ArrayList<Integer> highscoreArray = new ArrayList<Integer>();

	public HsManager() {

		loadData();

	}

	public void SaveData2(int i) {

		highscoreArray.add(i);
		Collections.sort(highscoreArray);
		Collections.reverse(highscoreArray);

		try {

			BufferedWriter out = new BufferedWriter(new FileWriter("HighScoureSavings"));

			for (int k = 0; k < highscoreArray.size(); k++) {

				out.write(Integer.toString(highscoreArray.get(k)));
				out.newLine();

			}

			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public ArrayList<Integer> ArrayTransfer() {

		return highscoreArray;
	}

	public void loadData() {
		try {

			FileReader fr = new FileReader("HighScoureSavings");
			BufferedReader bufffile = new BufferedReader(fr);

			String tempString;

			int i = 1;

			while ((tempString = bufffile.readLine()) != null) {

				// resultText.append(i+ ": " + tempString + "\n" );

				i = i + 1;

				int k = Integer.parseInt(tempString);

				highscoreArray.add(k);

			}

			bufffile.close();

		} catch (IOException e) {

			e.printStackTrace();
		}

		Collections.sort(highscoreArray);
		Collections.reverse(highscoreArray);

		for (int i = 0; i < highscoreArray.size(); i++) {

			System.out.println(highscoreArray.get(i));

		}

	}

}
