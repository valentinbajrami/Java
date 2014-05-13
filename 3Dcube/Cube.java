// Program draws a cube.
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Cube
{
	
	public static void main( String args[] )
	{
		int x1;
		int x;
		int y;
		// create frame for CubeJPanel
		JFrame frame = new JFrame( "Kubus" );
		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		x1 = Integer.parseInt(JOptionPane.showInputDialog("How big should the cubus be?"));
		x = Integer.parseInt(JOptionPane.showInputDialog("What should be the horizontal size?"));
		y = Integer.parseInt(JOptionPane.showInputDialog("What should be the vertical size?"));
		CubeJPanel cubeJPanel = new CubeJPanel(x1,x,y);
		cubeJPanel.setBackground(Color.black);
		frame.add( cubeJPanel ); // add cubeJPanel to frame
		frame.setSize( 1000, 700 ); // set frame size
		frame.setVisible( true ); // display frame
	} // end main
 } // end class Cube

