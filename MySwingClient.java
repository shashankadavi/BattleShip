/**
 * This class launches the game BattleShip.
 * 
 * 
 * @author Aayushi Khurana
 * @author Pranay Shashank Adavi
 * 
 * 
 */

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;

public class MySwingClient {

	/**
	 * The main program.
	 * 
	 * @param args
	 *            command line arguments (ignored)
	 */

	public static void main(String[] args) {
		MySwingController player1 = new MySwingController("player1");
		JFrame myFrame1 = new JFrame("Player 1");
		Component comp1 = player1.frame.createcomponents();
		myFrame1.getContentPane().add(comp1);
		myFrame1.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		myFrame1.setBounds(100, 100, 300, 730);
		myFrame1.setMinimumSize(new Dimension(300, 730));
		myFrame1.setVisible(true);

		MySwingController player2 = new MySwingController("player2");
		JFrame myFrame2 = new JFrame("Player 2");
		Component comp2 = player2.frame.createcomponents();
		myFrame2.getContentPane().add(comp2);
		myFrame2.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		myFrame2.setBounds(700, 100, 300, 730);
		myFrame2.setMinimumSize(new Dimension(300, 730));
		myFrame2.setVisible(true);

		player1.getShipArray();
		player2.getShipArray();

		while (true) {

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			if (player1.model.startPlay && player2.model.startPlay) {
				break;
			}

		}

		player1.enableButtons();
		player2.enableButtons();
		player1.play(player2);
		player2.play(player1);

	}

}
