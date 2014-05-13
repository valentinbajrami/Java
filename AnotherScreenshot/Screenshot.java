import javax.swing.*;
import javax.imageio.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;

public class Screenshot {
  public static void main(String[] args) throws Exception {
    Screenshot ss = new Screenshot();
  }

  public Screenshot(){
    JFrame frame = new JFrame("AnotherScreenshotApp.");
    JButton button = new JButton("Create screenshot");
    button.addActionListener(new MyAction());
    JPanel panel = new JPanel();
    panel.add(button);
    frame.add(panel, BorderLayout.CENTER);
    frame.setSize(158, 30);
    frame.setLocation(500, 30);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
  }

  public class MyAction implements ActionListener{
    public void actionPerformed(ActionEvent ae){
      try{
        String fileName = JOptionPane.showInputDialog(null, "Enter filename: ",  "Screenshot", 1);
        if (!fileName.toLowerCase().endsWith(".gif")){
          JOptionPane.showMessageDialog(null, "Error: Filename has to end with \".gif\".", "Screenshot", 1);
        }
        else{
          try {
        	  Thread th = new Thread();
        	  th.sleep(2000);
              Robot robot = new Robot();
              BufferedImage image = robot.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
              ImageIO.write(image, "gif", new File(fileName));
              JOptionPane.showMessageDialog(null, "Screenshot created successfully.","Screenshot", 1);
      
    }catch(Exception e){}
   }
    }catch(Exception aa){}
  }
 }
}
