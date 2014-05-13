/**
* Filename:  Game.java
* @author:  Valentin Bajrami / Fokko Bronsema
* @version: 090323
* Date: 23 - 03 - 09
* Description: The program simulates a horse race
* This class take care of the race. It starts the horses and stops the horses when one horse
* is entered the finish line.
**/

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

public class Game extends JPanel implements Runnable {
	
	private Image horseImage;
	private Horse horses[];
	private Thread threadHorses[];
	private final static int AMOUNT_HORSES = 5;
	
	/*
	 * Start the race
	 * @see java.lang.Runnable#run()
	 */
	public void run()
	{
		// set up horses
		for (int i = 0; i < AMOUNT_HORSES ; i++) {
			threadHorses[i] = new Thread(horses[i]);
		}
		
		// start the race
		for (int i = 0 ; i < AMOUNT_HORSES ; i++) {
			threadHorses[i].start();
		}
	}
	
	/*
	 * constructor
	 * Create and load the horses the horses
	 */
	public Game()
	{
		horses = new Horse[AMOUNT_HORSES];
		threadHorses = new Thread[AMOUNT_HORSES];
		
		// set up horses
		for (int i = 0; i < AMOUNT_HORSES ; i++) {
			horses[i] = new Horse(5, (i * 40) + 40, i + 1, this);
			threadHorses[i] = new Thread(horses[i]);
		}
		
		try {
			horseImage = ImageIO.read(new File("horse.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * Reset the horses to there default place.
	 */
	public void reset()
	{
		stopHorses();
		for (int i = 0; i < AMOUNT_HORSES ; i++) {
			horses[i].setX(5);
		}
		repaint();
	}
	
	/*
	 * end the race
	 * @param winner / number of the winning horse
	 * @see Horse.java-private void checkEndLine()
	 */
	public void end(int winner)
	{
		stopHorses();
		drawWinner(winner);
	}
	
	/*
	 * Stop the Threads in the horses.
	 */
	private void stopHorses()
	{
		for (int i = 0 ; i < AMOUNT_HORSES ; i++) {
			horses[i].stopMove();
		}
	}
	
	/*
	 * Draw the winner as a string on the panel
	 */
	private void drawWinner(int winner)
	{
		Graphics g = this.getGraphics();
		g.setColor(Color.black);
		g.drawString("The winner is horse number " + winner, 300, 250);
	}
	
	/*
	 * Repaint the horses
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		g.drawLine(40, 0, 40, 250);
		g.drawLine(700, 0, 700, 250);
		
		for (int i = 0 ; i < AMOUNT_HORSES ; i++) {
			g.drawImage(horseImage, horses[i].getX(), horses[i].getY(), null);
		}
	}
}
