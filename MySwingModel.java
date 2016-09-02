/**
 * This class contains the Model for the game BattleShip.
 * 
 * 
 * @author Aayushi Khurana
 * @author Pranay Shashank Adavi
 * 
 * 
 */

public class MySwingModel {

	/** count of ships */
	int count = 0;
	/** name of the player */
	String name;
	/** boolean array of the board */
	boolean field[] = new boolean[25];
	/** variable to start the game */
	boolean startPlay = false;
	/** variable for winning */
	static boolean winPlay = false;

	/**
	 * Constructor for the class MySwingModel
	 * 
	 * @param name
	 *            name of the player
	 * 
	 * @return void
	 */

	MySwingModel(String name) {
		this.name = name;
		for (int i = 0; i < 25; i++) {
			field[i] = false;
		}
	}

	/**
	 * Returns the ship count of this player
	 * 
	 * 
	 * @return count count of the ship
	 */

	int getCount() {
		return count;
	}

}
