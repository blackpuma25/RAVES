package mainInterface;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class PlayerPanel extends JPanel {
	
	private JTextField txtPlayer;
	
	public PlayerPanel() {
		setBackground(new Color(32, 178, 170));
		setBounds(100, 400, 400, 78);
		setLayout(null);
		
		txtPlayer = new JTextField();
		txtPlayer.setBackground(Color.LIGHT_GRAY);
		txtPlayer.setHorizontalAlignment(SwingConstants.CENTER);
		txtPlayer.setText("Player Panel");
		txtPlayer.setBounds(137, 46, 130, 26);
		add(txtPlayer);
		txtPlayer.setColumns(10);
		
		JButton btnPlay = new JButton("Play");
		btnPlay.setBounds(137, 17, 130, 29);
		add(btnPlay);
	}

}
