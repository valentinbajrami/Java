/**
* Filename:  Game.java
* @author:  Valentin Bajrami
* @version: 090323
* Date: 23 - 03 - 09
* Description: The program simulates a horse race
* The horse is a thread. When the thread runs the horse takes a random step every 
* 1 second. When x reach the END then the horse is to the finish line end wil call 
* game.end. Game.end will then end the game.
**/

public class Horse extends Thread implements Runnable {
	
	private final static int END = 700; // endline in pixels
	private int x;						// Coordinate x
	private int y;						// Coordinate y
	private Game game;					// reference to the game object.
	
	private boolean t1;					// Boolean of the race is on (true).
	
	private int number;					// The number of the horse
	
	
	/*
	 * Thread which will simulate the horse running.
	 * @see java.lang.Thread#run()
	 */
	public void run() {
		
		t1 = true;
		
		while (t1) {
			
			moveRandomStap();
			game.repaint();
			checkEndLine();
			
			try {
				sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	/*
	 * Method ends the Thread
	 */
	public void stopMove()
	{
		t1 = false;
	}
	
	/*
	 * Move a random step
	 */
	private void moveRandomStap()
	{
		x += Math.random() * 10;
	}
	
	/*
	 * check of the horse is over the end line.
	 */
	private void checkEndLine()
	{
		if (x > END) {
			game.end(number);
		}
	}
	
	/*
	 * Constructor. give the horse a place on the map
	 * @param x / x coordinate
	 * @param y / y coordinate
	 * @param number / number of the horse
	 * @param game / reference to the game object.
	 */
	public Horse(int x, int y, int number, Game game)
	{
		this.x = x;
		this.y = y;
		this.game = game;
		this.number = number;
	}
	
	/*
	 * @param x / Set the x coordinate
	 */
	public void setX(int x) 
	{
		this.x = x;
	}
	
	/*
	 * @return x Coordinate
	 */
	public int getX()
	{
		return x;
	}
	
	/*
	 * @return y Coordinate
	 */
	public int getY()
	{
		return y;
	}
	
	/*
	 * @return number of the horse
	 */
	public int getNumber()
	{
		return number;
	}
}
