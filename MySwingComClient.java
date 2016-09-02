import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;


public class MySwingComClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
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

		MySwingController com = new MySwingController("COM");
//		JFrame myFrame2 = new JFrame("Player 2");
//		Component comp2 = player2.frame.createcomponents();
//		myFrame2.getContentPane().add(comp2);
//		myFrame2.addWindowListener(new WindowAdapter() {
//			public void windowClosing(WindowEvent e) {
//				System.exit(0);
//			}
//		});
//		myFrame2.setBounds(700, 100, 300, 730);
//		myFrame2.setMinimumSize(new Dimension(300, 730));
//		myFrame2.setVisible(true);
		player1.getShipArray();
		com.getComShips();
		while (true) {

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			if (player1.model.startPlay) {
				break;
			}
		}
		player1.enableButtons();
		player1.play(com);
		

	}

}
