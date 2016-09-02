/**
 * This class contains the view of the game BattleShip.
 * 
 * 
 * @author Aayushi Khurana
 * @author Pranay Shashank Adavi
 * 
 * 
 */

import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.*;

public class MySwingView {

	/** array of buttons for the upper board */
	MyButton buttons_set1[] = new MyButton[25];
	/** array of buttons for the lower board */
	MyButton buttons_set2[] = new MyButton[25];
	/** label within the board */
	JLabel label1;
	/** label within the board */
	JLabel label2;
	/** label within the board */
	JLabel label3 = new JLabel();
	/** label within the board */
	JLabel label4 = new JLabel();
	/** panel for each player */
	JPanel main = new JPanel();
	/** name of the player */
	String name;

	/**
	 * Constructor for the class Server
	 * 
	 * @param player
	 *            name of the player
	 * 
	 * @return void
	 */

	MySwingView(String player) {
		name = player;
	}

	/**
	 * Creates the view of the game.
	 * 
	 * 
	 * 
	 * @return main main panel component
	 */

	public Component createcomponents() {

		String lookAndFeel;
		lookAndFeel = UIManager.getCrossPlatformLookAndFeelClassName();
		try {
			UIManager.setLookAndFeel(lookAndFeel);
		} catch (Exception e) {
		}

		if (this.name.equals("player1")) {
			label1 = new JLabel("Player1 Primary Board");
			label2 = new JLabel("Player1 Hits and Misses");
		} else {
			label1 = new JLabel("Player2 Primary Board");
			label2 = new JLabel("Player2 Hits and Misses");
		}
		JPanel jpan1 = new JPanel();
		JPanel jpan3 = new JPanel();
		JPanel jpan5 = new JPanel();
		JPanel jpan2 = new JPanel();
		JPanel jpan4 = new JPanel();
		JPanel jpan6 = new JPanel();

		jpan3.setPreferredSize(new Dimension(300, 20));
		jpan3.add(label1);

		jpan5.setPreferredSize(new Dimension(300, 20));
		jpan5.add(label3);

		jpan1.setPreferredSize(new Dimension(300, 300));
		jpan1.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		jpan1.setLayout(new GridLayout(5, 5));
		for (int i = 0; i < 25; i++) {
			buttons_set1[i] = new MyButton(i);
			jpan1.add(buttons_set1[i]);

		}

		jpan4.setPreferredSize(new Dimension(300, 20));
		jpan4.add(label2);

		jpan6.setPreferredSize(new Dimension(300, 20));
		jpan6.add(label4);

		jpan2.setPreferredSize(new Dimension(300, 300));
		jpan2.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		jpan2.setLayout(new GridLayout(5, 5));
		for (int i = 0; i < 25; i++) {
			buttons_set2[i] = new MyButton(i);
			jpan2.add(buttons_set2[i]);
		}

		main.add(jpan3);
		main.add(jpan5);
		main.add(jpan1);
		main.add(new JSeparator());
		main.add(jpan4);
		main.add(jpan6);
		main.add(jpan2);

		return main;

	}

}
