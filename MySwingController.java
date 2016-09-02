/**
 * This class contains the Controller for the game BattleShip.
 * 
 * 
 * @author Aayushi Khurana
 * @author Pranay Shashank Adavi
 * 
 * 
 */

import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class MySwingController {

	/** reference variable of class MySwingView */
	MySwingView frame;
	/** reference variable of class MySwingModel */
	MySwingModel model;
	/** name of the player */
	String playerName;

	/**
	 * Constructor for the class MySwingController
	 * 
	 * @param pl
	 *            name of the player
	 * 
	 * @return void
	 */

	MySwingController(String pl) {
		playerName = pl;
		frame = new MySwingView(pl);
		model = new MySwingModel(pl);
		for (int i = 0; i < 25; i++) {
			model.field[i] = false;
		}
	}

	/**
	 * Enables the buttons of the lower board
	 * 
	 * 
	 * @return void
	 */

	public void enableButtons() {
		for (int i = 0; i < 25; i++) {
			frame.buttons_set2[i].setEnabled(true);
		}
	}

	/**
	 * Disables the buttons of the lower board
	 * 
	 * 
	 * @return void
	 */

	public void disableButtons() {
		for (int i = 0; i < 25; i++) {
			frame.buttons_set2[i].setEnabled(false);
		}
	}

	/**
	 * Changes state of the lower board buttons
	 * 
	 * 
	 * @return void
	 */

	public void displayButtons() {
		for (int i = 0; i < 25; i++) {
			frame.buttons_set2[i].setVisible(true);
		}
	}

	/**
	 * Changes state of the lower board buttons
	 * 
	 * 
	 * @return void
	 */

	public void dontDisplayButtons() {
		for (int i = 0; i < 25; i++) {
			frame.buttons_set2[i].setVisible(false);
		}
	}

	/**
	 * Lets each player select ships
	 * 
	 * 
	 * @return void
	 */
	public void getComShips(){
		Random n = new Random();
		for(int i = 0;i<5;i++){
			model.field[n.nextInt(25)] = true;
		}
		model.startPlay = true;
		model.count = 5;
	}
	public void getShipArray()

	{
		if (frame.name.equals("player1")) {
			frame.label3.setText("player1 select 5 ships");
			for (int i = 0; i < 25; i++) {
				frame.buttons_set2[i].setEnabled(false);
				frame.buttons_set1[i].addMouseListener(new MouseListener() {

					@Override
					public void mouseClicked(MouseEvent e) {

					}

					@Override
					public void mousePressed(MouseEvent e) {

					}

					@Override
					public void mouseReleased(MouseEvent e) {

						if (model.count < 5) {
							MyButton o = (MyButton) e.getSource();
							o.setBackground(Color.BLUE);
							model.field[o.getId()] = true;
							model.count++;

						}
						if (model.count == 5) {
							model.startPlay = true;
						}
					}

					@Override
					public void mouseEntered(MouseEvent e) {

					}

					@Override
					public void mouseExited(MouseEvent e) {

					}

				});
			}
		}

		else {

			frame.label3.setText("player2 select 5 ships");
			for (int i = 0; i < 25; i++) {
				frame.buttons_set2[i].setEnabled(false);
				frame.buttons_set1[i].addMouseListener(new MouseListener() {

					@Override
					public void mouseClicked(MouseEvent e) {

					}

					@Override
					public void mousePressed(MouseEvent e) {

					}

					@Override
					public void mouseReleased(MouseEvent e) {
						// TODO Auto-generated method stub
						if (model.count < 5) {
							MyButton o = (MyButton) e.getSource();
							o.setBackground(Color.RED);
							model.field[o.getId()] = true;
							model.count++;
						}

						if (model.count == 5) {
							model.startPlay = true;
						}

					}

					@Override
					public void mouseEntered(MouseEvent e) {

					}

					@Override
					public void mouseExited(MouseEvent e) {

					}

				});
			}

		}

	}

	/**
	 * Lets each player play the game
	 * 
	 * @param other
	 *            other player
	 * 
	 * @return void
	 */

	public void play(final MySwingController other) {
		if(other.model.name.equals("COM")){
			for (int i = 0; i < 25; i++) {

				frame.buttons_set2[i].addMouseListener(new MouseListener() {

					@Override
					public void mouseClicked(MouseEvent e) {

					}

					@Override
					public void mousePressed(MouseEvent e) {

					}

					@Override
					public void mouseReleased(MouseEvent e) {
						if (model.count > 0) {
							frame.label3.setText("");
							MyButton o = (MyButton) e.getSource();

							if (other.model.field[o.getId()]) {
								frame.buttons_set2[o.getId()]
										.setBackground(Color.RED);

								model.count--;
								frame.label4
										.setText("You Sank Player 2's Ship!   PLAYER 2's TURN");

								if (model.count == 0) {
									frame.label4
											.setText("PLAYER 1 WINS! GAME OVER.");

									MySwingModel.winPlay = true;
								}
							} else {
								frame.label4
										.setText("That Was a Miss!   PLAYER 2's TURN");
								frame.buttons_set2[o.getId()].setText("No!");
							}
						}

					}

					@Override
					public void mouseEntered(MouseEvent e) {

					}

					@Override
					public void mouseExited(MouseEvent e) {

					}

				});

			}
		}

		else if (frame.name.equals("player1")) {

			for (int i = 0; i < 25; i++) {

				frame.buttons_set2[i].addMouseListener(new MouseListener() {

					@Override
					public void mouseClicked(MouseEvent e) {

					}

					@Override
					public void mousePressed(MouseEvent e) {

					}

					@Override
					public void mouseReleased(MouseEvent e) {
						if (model.count > 0) {
							frame.label3.setText("");
							MyButton o = (MyButton) e.getSource();

							if (other.model.field[o.getId()]) {
								frame.buttons_set2[o.getId()]
										.setBackground(Color.RED);

								model.count--;
								frame.label4
										.setText("You Sank Player 2's Ship!   PLAYER 2's TURN");

								if (model.count == 0) {
									frame.label4
											.setText("PLAYER 1 WINS! GAME OVER.");
									other.frame.label4.setText("");

									MySwingModel.winPlay = true;
									dontDisplayButtons();
									other.dontDisplayButtons();
									// disableButtons();
									// other.disableButtons();

								}

							} else {
								frame.label4
										.setText("That Was a Miss!   PLAYER 2's TURN");
								frame.buttons_set2[o.getId()].setText("No!");
							}
							if (!MySwingModel.winPlay) {
								disableButtons();
								other.enableButtons();
								// dontDisplayButtons();
								// other.displayButtons();

							}

						}

					}

					@Override
					public void mouseEntered(MouseEvent e) {

					}

					@Override
					public void mouseExited(MouseEvent e) {

					}

				});

			}
		} else {

			for (int i = 0; i < 25; i++) {

				frame.buttons_set2[i].addMouseListener(new MouseListener() {

					@Override
					public void mouseClicked(MouseEvent e) {

					}

					@Override
					public void mousePressed(MouseEvent e) {

					}

					@Override
					public void mouseReleased(MouseEvent e) {
						if (model.count > 0) {
							frame.label3.setText("");
							MyButton o = (MyButton) e.getSource();
							if (other.model.field[o.getId()]) {
								frame.buttons_set2[o.getId()]
										.setBackground(Color.BLUE);

								model.count--;
								frame.label4
										.setText("You Sank Player 1's Ship!   PLAYER 1's TURN");

								if (model.count == 0) {
									frame.label4
											.setText("PLAYER 2 WINS! GAME OVER.");
									other.frame.label4.setText("");

									MySwingModel.winPlay = true;
									dontDisplayButtons();
									other.dontDisplayButtons();
									// disableButtons();
									// other.disableButtons();

								}
							} else {
								frame.label4
										.setText("That Was a Miss!   PLAYER 1's TURN");
								frame.buttons_set2[o.getId()].setText("No!");
							}
							if (!MySwingModel.winPlay) {
								disableButtons();
								other.enableButtons();
								// dontDisplayButtons();
								// other.displayButtons();
							}
						}

					}

					@Override
					public void mouseEntered(MouseEvent e) {

					}

					@Override
					public void mouseExited(MouseEvent e) {

					}

				});
			}
		}

	}

}
