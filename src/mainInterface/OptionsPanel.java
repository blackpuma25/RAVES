package mainInterface;

import java.awt.Color;
import javax.swing.JPanel;

import options.OptionsMenu;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class OptionsPanel extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public OptionsPanel() {
		setBackground(new Color(112, 128, 144));
		setBounds(0, 400, 225, 103);
		setLayout(null);
		
		JButton btnOptionsMenu = new JButton("Options Menu");
		btnOptionsMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OptionsMenu.main(null);
			}
		});
		btnOptionsMenu.setBounds(53, 43, 117, 29);
		add(btnOptionsMenu);
	}
}
