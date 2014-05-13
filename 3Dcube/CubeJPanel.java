import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;


public class CubeJPanel extends JPanel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int x1;
	private int x;
	private int y;
	
	Cube mycube = new Cube();
	// draw cube
	public CubeJPanel(int x1, int x, int y)
	{
		this.x1 = x1;
		this.x = x;
		this.y = y;
	}
	public void paintComponent( Graphics g )
	{
		super.paintComponent( g );
		//positie
		//int x = 200;
	//	int y = 200;
		//de grootte 
		//int y1= 110;

		 Graphics2D g2d = ( Graphics2D ) g;
		 g2d.setColor(Color.green);
		 g2d.drawRect( x, y, x1, x1 );
		 // upper left line10
		 g2d.drawLine( x, y , x + (x1/2), y - (x1/2) );

		 // upper right line
		 g2d.drawLine( x + x1, y, x + (x1 + (x1/2)), y - (x1/2) );
		 // lower right line
		 g2d.drawLine( x + x1, y + x1, x + (x1 + (x1/2)), y + (x1 - (x1/2)) );
		 // lower left line
		 g2d.drawLine( x, y + x1, x + (x1/2), y + (x1 - (x1/2)) );
		 
		 int xUpperLeft = x + (x1/2);
		 int yUpperLeft = y - (x1/2);
		
		 int xUpperRight = x + (x1 + (x1/2));
		 int yUpperRight = y - (x1/2);
		
		 int xLowerRight = x + (x1 + (x1/2));
		 int yLowerRight = y + (x1 - (x1/2));
		
		 int xLowerLeft = x + (x1/2);
		 int yLowerleft = y + (x1 - (x1/2));
		// Select the font: 
		 g2d.setFont(new Font("monospaced", Font.PLAIN  , 14));
		 // close the rectangle
		 g2d.drawLine( xUpperLeft, yUpperLeft, xUpperRight, yUpperRight );
		 g2d.drawLine( xUpperRight, yUpperRight, xLowerRight, yLowerRight );
		 g2d.drawLine( xLowerRight, yLowerRight, xLowerLeft, yLowerleft );
		 g2d.drawLine( xLowerLeft, yLowerleft, xUpperLeft, yUpperLeft );
		 
		 //draw the text
		 g2d.drawString("The statistics are", x + (x1 + (x1/2))+20, y-40);
		 g2d.drawString(" ---------------------------------", x + (x1 + (x1/2))+20, y-20);
		 g2d.drawString( "The size is >> : " + x1,  x + (x1 + (x1/2))+20, y);
		 g2d.drawString("The horizontal position is >> : " + x, x+(x1+(x1/2))+20, y+20);
		 g2d.drawString("The vertical position is >> : " + y, x+(x1+(x1/2))+20, y+40);
		 g2d.drawString("The content is >> : "+ (x1*x1*x1)+ " m\u00B3", x + (x1 + (x1/2))+20, y+60);
		 g2d.drawString("The surface is >> : "+ (x1 * x1 * 6)+" m\u00B2", x + (x1 + (x1/2))+20, y+80);
		 g2d.drawString(" ---------------------------------", x + (x1 + (x1/2))+20, y+100
				 );
	} // end method paintComponent
 } // end class CubeJPanel