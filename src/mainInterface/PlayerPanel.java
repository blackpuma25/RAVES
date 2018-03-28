package mainInterface;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import playback.Playback;

public class PlayerPanel extends JPanel {
	
	private JTextField txtPlayer;
	
	public PlayerPanel() {
		setBackground(new Color(32, 178, 170));
		setBounds(100, 400, 550, 103);
		setLayout(null);
		
		txtPlayer = new JTextField();
		txtPlayer.setBackground(Color.LIGHT_GRAY);
		txtPlayer.setHorizontalAlignment(SwingConstants.CENTER);
		txtPlayer.setText("Player Panel");
		txtPlayer.setBounds(209, 60, 130, 26);
		add(txtPlayer);
		txtPlayer.setColumns(10);
		
		JButton btnPlay = new JButton("Play");
		btnPlay.setText("Play");
		btnPlay.setBounds(209, 19, 130, 29);
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
	}

}
