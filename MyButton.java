/**
 * This class creates buttons for the game BattleShip.
 * 
 * 
 * @author Aayushi Khurana
 * @author Pranay Shashank Adavi
 * 
 * 
 */

import javax.swing.JButton;

public class MyButton extends JButton {

	/** id of each button */
	int id;

	/**
	 * Constructor for the class MyButton
	 * 
	 * @param i
	 *            id of the button
	 * 
	 * @return void
	 */

	MyButton(int i) {
		id = i;
	}

	/**
	 * Returns id of the button
	 * 
	 * 
	 * @return id id of the button
	 */

	int getId() {
		return id;
	}

}
