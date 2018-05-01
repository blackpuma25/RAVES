package mainInterface;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class TutorialPanel extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public TutorialPanel() {
		setBackground(new Color(112, 128, 144));
		setBounds(500, 400, 225, 103);
		setLayout(null);
		
		JButton btnHelp = new JButton("Help");
		btnHelp.setBounds(53, 37, 117, 29);
		btnHelp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/* Open instruction manual */
				TutorialDisplay.main(null);
			}
		});
		add(btnHelp);
		
	}
}
