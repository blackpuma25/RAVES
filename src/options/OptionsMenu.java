package options;

import javax.swing.JFrame;
import mainInterface.InterfaceWindow;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.JList;
import javax.swing.JSpinner;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.Color;

public class OptionsMenu extends JFrame {
	
	public static int[] optionValues;
	private JTextField txtTimeResolution;
	private JTextField txtFrequencyResolution;
	private JTextField txtVisualizer;
	
	public OptionsMenu() {
		setTitle("Options");
		
		/*Initialize Options Menu */
		setSize(800, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
		getContentPane().setLayout(null);
		
		txtTimeResolution = new JTextField();
		txtTimeResolution.setEditable(false);
		txtTimeResolution.setHorizontalAlignment(SwingConstants.CENTER);
		txtTimeResolution.setText("Time Resolution");
		txtTimeResolution.setBounds(205, 100, 175, 26);
		getContentPane().add(txtTimeResolution);
		txtTimeResolution.setColumns(10);
		
		txtFrequencyResolution = new JTextField();
		txtFrequencyResolution.setEditable(false);
		txtFrequencyResolution.setHorizontalAlignment(SwingConstants.CENTER);
		txtFrequencyResolution.setText("Frequency Resolution");
		txtFrequencyResolution.setBounds(205, 175, 175, 26);
		getContentPane().add(txtFrequencyResolution);
		txtFrequencyResolution.setColumns(10);
		
		SpinnerNumberModel tModel = new SpinnerNumberModel(1, 0, 6, 1); //default, min, max, step size
		JSpinner tSpinner = new JSpinner(tModel);
		tSpinner.setBounds(392, 100, 33, 26);
		getContentPane().add(tSpinner);
		
		SpinnerNumberModel fModel = new SpinnerNumberModel(5, 0, 6, 1);
		JSpinner fSpinner = new JSpinner(fModel);
		fSpinner.setBounds(392, 175, 33, 26);
		getContentPane().add(fSpinner);
		
		SpinnerNumberModel vModel = new SpinnerNumberModel(1, 0, 1, 1);
		JSpinner vSpinner = new JSpinner(vModel);
		vSpinner.setBounds(392, 250, 33, 26);
		getContentPane().add(vSpinner);
		
		JButton btnSaveOptions = new JButton("Save Options");
		btnSaveOptions.setBounds(350, 387, 117, 29);
		getContentPane().add(btnSaveOptions);
		
		txtVisualizer = new JTextField();
		txtVisualizer.setEditable(false);
		txtVisualizer.setHorizontalAlignment(SwingConstants.CENTER);
		txtVisualizer.setText("Visualizer");
		txtVisualizer.setBounds(205, 250, 175, 26);
		getContentPane().add(txtVisualizer);
		txtVisualizer.setColumns(10);
		
		JTextArea txtrTvalue = new JTextArea();
		txtrTvalue.setBackground(Color.LIGHT_GRAY);
		txtrTvalue.setText("TValue");
		txtrTvalue.setBounds(487, 105, 100, 16);
		getContentPane().add(txtrTvalue);
		
		JTextArea txtrFvalue = new JTextArea();
		txtrFvalue.setText("FValue");
		txtrFvalue.setBackground(Color.LIGHT_GRAY);
		txtrFvalue.setBounds(487, 180, 100, 16);
		getContentPane().add(txtrFvalue);
		
		JTextArea txtrOnoff = new JTextArea();
		txtrOnoff.setText("On/Off");
		txtrOnoff.setBackground(Color.LIGHT_GRAY);
		txtrOnoff.setBounds(487, 255, 100, 16);
		getContentPane().add(txtrOnoff);
		
		
	}
	
	public static void main(String ars[]) {
		//InterfaceWindow.disableMainWindow();
		new OptionsMenu();
	}
}
