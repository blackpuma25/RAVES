package mainInterface;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class OptionsMenu extends JPanel {
	
	private JTextField txtOptionsMenu;
	
	public OptionsMenu() {
		setBackground(new Color(112, 128, 144));
		setBounds(0, 400, 100, 78);
		setLayout(null);
		
		txtOptionsMenu = new JTextField();
		txtOptionsMenu.setBackground(Color.LIGHT_GRAY);
		txtOptionsMenu.setHorizontalAlignment(SwingConstants.CENTER);
		txtOptionsMenu.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		txtOptionsMenu.setText("Options Menu");
		txtOptionsMenu.setBounds(6, 29, 88, 26);
		add(txtOptionsMenu);
		txtOptionsMenu.setColumns(10);
	}

}
