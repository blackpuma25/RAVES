package mainInterface;

import java.awt.Color;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import playback.Playback;
import javax.swing.JSlider;

public class PlayerPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private static JTextField textField;
	private static JTextField textField_1;
	private static JSlider slider;

	public PlayerPanel() {
		setBackground(new Color(32, 178, 170));
		setBounds(100, 400, 550, 103);
		setLayout(null);
		
		JButton btnPlay = new JButton("Play");
		btnPlay.setText("Play");
		btnPlay.setBounds(212, 57, 130, 29);
		btnPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/* Play/pause audio file */
				
				if (btnPlay.getText() == "Play") {
					
					InterfaceWindow.getVisualizer().play();
					Playback.play();
					btnPlay.setText("Pause");
				}
				else {
					InterfaceWindow.getVisualizer().pause();
					Playback.pause();
					btnPlay.setText("Play");
				}
				
			}
		});
		add(btnPlay);
		
		slider = new JSlider(0, 100, 0);
		slider.setBounds(117, 16, 321, 29);
		slider.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				if (Playback.isScrubbed())
					Playback.scrub();
			}
		});
		add(slider);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setBounds(44, 16, 73, 26);
		textField.setText("Position");
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setColumns(10);
		textField_1.setBounds(433, 16, 73, 26);
		textField_1.setText("Duration");
		add(textField_1);
	}
	
	public static JTextField getTextField() {
		return textField;
	}



	public static void setTextField(JTextField textField) {
		PlayerPanel.textField = textField;
	}



	public static JTextField getTextField_1() {
		return textField_1;
	}



	public static void setTextField_1(JTextField textField_1) {
		PlayerPanel.textField_1 = textField_1;
	}



	public static JSlider getSlider() {
		return slider;
	}



	public static void setSlider(JSlider slider) {
		PlayerPanel.slider = slider;
	}
	
	public static void updateDuration() {
		textField_1.setText(Playback.convertToMinSeconds((int) Playback.getDuration()));
		slider.setMaximum((int) Playback.getDuration());
		
	}
}
