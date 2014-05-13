// Creating a screenshot 

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Capture {

	public static void main(String[] args)
	{
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Toolkit kit = Toolkit.getDefaultToolkit();
		final Dimension d = kit.getScreenSize();
		frame.setSize(d);
		
		Rectangle rect = new Rectangle(d);
		try{
			Robot robot = new Robot();
			final BufferedImage image = robot.createScreenCapture(rect);
			image.flush();
			
			JPanel panel = new JPanel()
			{
				public void paintComponent(Graphics g) {
					g.drawImage(image, 0, 0, d.width, d.height, this);
				}
			};
			panel.setOpaque(false);
			panel.prepareImage(image, panel);
			panel.repaint();
			frame.getContentPane().add(panel);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		frame.setVisible(true);
	}
}
