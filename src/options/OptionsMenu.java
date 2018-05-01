package options;

import javax.swing.JFrame;
import mainInterface.InterfaceWindow;

import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import javax.swing.JSpinner;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class OptionsMenu extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8234393176541053362L;
	public static int[] optionValues;
	private JTextField txtTimeResolution;
	private JTextField txtFrequencyResolution;
	private JTextField txtVisualizer;
	
	private static JSpinner tSpinner;
	private static JSpinner fSpinner;
	private static JSpinner vSpinner;
	
	private static JTextArea txtrTvalue;
	private static JTextArea txtrFvalue;
	private static JTextArea txtrOnoff;
	
	private static int spinnerValue;
	
	public OptionsMenu() {
		setTitle("Options");
		
		/*Initialize Options Menu */
		setSize(800, 500);
		setLocationRelativeTo(null);
		setVisible(true);
		getContentPane().setLayout(null);
		this.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                InterfaceWindow.enableMainWindow();
            }
        });
		
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
		
		SpinnerNumberModel tModel = new SpinnerNumberModel(Options.getTimeRes(), 0, 6, 1); //default, min, max, step size
		tSpinner = new JSpinner(tModel);
		tSpinner.setBounds(392, 100, 33, 26);
		getContentPane().add(tSpinner);
		tSpinner.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				txtrTvalue.setText(String.valueOf(Options.getTimeIntervals((int) tSpinner.getValue())));
			}
		});
		
		SpinnerNumberModel fModel = new SpinnerNumberModel(Options.getFreqRes(), 0, 6, 1);
		fSpinner = new JSpinner(fModel);
		fSpinner.setBounds(392, 175, 33, 26);
		getContentPane().add(fSpinner);
		fSpinner.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				txtrFvalue.setText(String.valueOf(Options.getWindowSizes((int) fSpinner.getValue())));
			}
		});
		
		SpinnerNumberModel vModel = new SpinnerNumberModel(1, 0, 1, 1);
		vSpinner = new JSpinner(vModel);
		vSpinner.setBounds(392, 250, 33, 26);
		spinnerValue = (int) vSpinner.getValue();
		getContentPane().add(vSpinner);
		vSpinner.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				spinnerValue = (int) vSpinner.getValue();
				if (spinnerValue == 1)
					txtrOnoff.setText("On");
				else {
					txtrOnoff.setText("Off");
				}
			}
		});
		
		JButton btnSaveOptions = new JButton("Save Options");
		btnSaveOptions.setBounds(350, 387, 117, 29);
		btnSaveOptions.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/* Updates new parameters */
				Options.updateOptions();
			}
		});
		getContentPane().add(btnSaveOptions);
		
		txtVisualizer = new JTextField();
		txtVisualizer.setEditable(false);
		txtVisualizer.setHorizontalAlignment(SwingConstants.CENTER);
		txtVisualizer.setText("Visualizer");
		txtVisualizer.setBounds(205, 250, 175, 26);
		getContentPane().add(txtVisualizer);
		txtVisualizer.setColumns(10);
		
		txtrTvalue = new JTextArea();
		txtrTvalue.setBackground(Color.LIGHT_GRAY);
		txtrTvalue.setText(String.valueOf(Options.getTimeIntervals((int) tSpinner.getValue())));
		txtrTvalue.setBounds(487, 105, 100, 16);
		getContentPane().add(txtrTvalue);
		
		txtrFvalue = new JTextArea();
		txtrFvalue.setText(String.valueOf(Options.getWindowSizes((int) fSpinner.getValue())));
		txtrFvalue.setBackground(Color.LIGHT_GRAY);
		txtrFvalue.setBounds(487, 180, 100, 16);
		getContentPane().add(txtrFvalue);
		
		txtrOnoff = new JTextArea();
		if (Options.isVisualizerOn())
			txtrOnoff.setText("On");
		else {
			txtrOnoff.setText("Off");
		}
		txtrOnoff.setBackground(Color.LIGHT_GRAY);
		txtrOnoff.setBounds(487, 255, 100, 16);
		getContentPane().add(txtrOnoff);
		
	}
	
	/* Methods to retrieve updated values changed by user */
	
	public static int getTSpinner() {
		return (int) tSpinner.getValue();
	}
	
	public static int getFSpinner() {
		return (int) fSpinner.getValue();
	}
	
	public static int getVSpinner() {
		return (int) vSpinner.getValue();
	}
	
	/* Methods to display the values of each parameter */
	
	
	public static void main(String ars[]) {
		InterfaceWindow.disableMainWindow();
		new OptionsMenu();
	}
}
