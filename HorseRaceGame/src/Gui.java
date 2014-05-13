/**
* Filename:  Gui.java
* @author:  Valentin Bajrami / Fokko Bronsema
* @version: 090323
* Date: 23 - 03 - 09
* Description: The program simulates a horse race
* This class makes the gui of the simulator
**/

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;

public class Gui extends JFrame implements ActionListener {
	
	private JButton b1 = new JButton("Start");
	private JButton b2 = new JButton("Reset");
	
	private JPanel control = new JPanel();
	private Game canvas = new Game();
	
	private Thread gameThread;				// Thread for the canvas
	
	/*
	 * Constructor
	 * @param title / title of the applet
	 */
	public Gui(String title)
	{
		super(title);
		getContentPane().setLayout(new BorderLayout());
		
		control.setLayout(new FlowLayout());
		control.setBackground(Color.blue);
		control.add(b1);
		control.add(b2);
		
		canvas.setBackground(Color.white);
		
		getContentPane().add("North", control);
		getContentPane().add("Center", canvas);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
	}
	
	/*
	 * ActionListeren from the buttons reset and Start.
	 * b1 = Start
	 * b2 = Reset
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() == b1) {
			b1.setEnabled(false);
			gameThread = new Thread(canvas);
			gameThread.start();
		}
		
		if (e.getSource()== b2) {
			b1.setEnabled(true);
			canvas.reset();
		}
	}
	
	/*
	 * Start up
	 */
	public static void main (String args[])
	{
		Gui s = new Gui("Horse racing");
		s.setSize(740, 400);
		s.setLocation(700, 400);
		s.setVisible(true);
		s.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e)
			{
				System.exit(0);
			}
		});
	}
}
