package mainInterface;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class TutorialDisplay extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2004007389987770513L;
	private static File manual = new File("mainInterface/User_Manual.txt");
	private static JTextArea txtrTutorialText;
	
	public TutorialDisplay() {
		/*Initialize Options Menu */
		setSize(1000, 700);
		setLocationRelativeTo(null);
		setVisible(true);
		getContentPane().setLayout(null);
		
		txtrTutorialText = new JTextArea();
		txtrTutorialText.setEditable(false);
		txtrTutorialText.setWrapStyleWord(true);
		txtrTutorialText.setText("Tutorial Text");
		txtrTutorialText.setBounds(30, 30, 930, 630);
		getContentPane().add(txtrTutorialText);
		displayManual();
		
	}
	
	public static void displayManual() {
		try {
			FileReader reader = new FileReader(manual);
			BufferedReader br = new BufferedReader(reader);
			txtrTutorialText.read(br, null);
			br.close();
			txtrTutorialText.requestFocus();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}
	
	public static void main(String[] args) {
		new TutorialDisplay();
	}
}
