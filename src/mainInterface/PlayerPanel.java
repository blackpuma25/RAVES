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
	private static JSlider scrubSlider;
	private static JSlider volSlider;
	private static JButton btnPlay;
	
	public PlayerPanel() {
		setBackground(new Color(32, 178, 170));
		setBounds(100, 400, 550, 103);
		setLayout(null);
		
		btnPlay = new JButton("Play");
		btnPlay.setText("Play");
		btnPlay.setBounds(188, 49, 130, 29);
		btnPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/* Play/pause audio file */
				if (btnPlay.getText() == "Play") {
					Playback.play();
				}
				else {
					Playback.pause();
				}
				
			}
		});
		btnPlay.setEnabled(false);
		add(btnPlay);
		
		scrubSlider = new JSlider(0, 100, 0);
		scrubSlider.setBounds(92, 16, 321, 29);
		scrubSlider.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
//				System.out.println(scrubSlider.getValue());
//				JSlider source = (JSlider)e.getSource();
//				if(source.getValueIsAdjusting()) {
//				
//				}
				if (Playback.isScrubbed()) {
					Playback.scrub();
					
					InterfaceWindow.getVisualizer().skip(0);
				}
				
			}
		});
		add(scrubSlider);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setBounds(19, 16, 73, 26);
		textField.setText("Position");
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setColumns(10);
		textField_1.setBounds(406, 16, 73, 26);
		textField_1.setText("Duration");
		add(textField_1);
		
		volSlider = new JSlider();
		volSlider.setOrientation(SwingConstants.VERTICAL);
		volSlider.setBounds(491, 0, 53, 103);
		volSlider.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				Playback.changeVolume();
			}
		});
		add(volSlider);
	}
	
	public static void enablePlayButton() {
		btnPlay.setEnabled(true);
	}
	
	public static void disablePlayButton() {
		btnPlay.setEnabled(false);
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



	public static JSlider getscrubSlider() {
		return scrubSlider;
	}



	public static void setscrubSlider(JSlider slider) {
		PlayerPanel.scrubSlider = slider;
	}
	
	public static JSlider getVolSlider() {
		return volSlider;
	}

	public static void setVolSlider(JSlider volSlider) {
		PlayerPanel.volSlider = volSlider;
	}

	
	public static void updateDuration() {
		textField_1.setText(Playback.convertToMinSeconds((int) Playback.getDuration()));
		scrubSlider.setMaximum((int) Playback.getDuration());
	}
	
	public static void initializeVolSlider() {
		volSlider.setMaximum(6);
		volSlider.setMinimum(-20);
		volSlider.setValue(0);
	}

	public static JButton getBtnPlay() {
		return btnPlay;
	}

	public static void setBtnPlay(JButton btnPlay) {
		PlayerPanel.btnPlay = btnPlay;
	}
}
