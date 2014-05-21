import javax.swing.JOptionPane;

//Define the class name. This should match the filename itself
public class DecToBinConverter {
	
	public static void main(String[] args)
	{
		int inputDec; // The input string from the user
		String outputBin; // The variable that holds the output
		
		inputDec = Integer.parseInt(JOptionPane.showInputDialog("Enter decimal value"));
		outputBin = Integer.toBinaryString(inputDec);
		JOptionPane.showMessageDialog(null, "The value converted to binary is " + outputBin,null, JOptionPane.INFORMATION_MESSAGE);
	}
}
