package mainInterface;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class FileMenu extends JPanel{
	
	private JTextField txtFileMenu;
	
	public FileMenu() {
		setBackground(new Color(65, 105, 225));
		setBounds(0, 0, 300, 50);
		setLayout(null);
		
		txtFileMenu = new JTextField();
		txtFileMenu.setBackground(Color.LIGHT_GRAY);
		txtFileMenu.setForeground(Color.BLACK);
		txtFileMenu.setHorizontalAlignment(SwingConstants.CENTER);
		txtFileMenu.setText("File Menu");
		txtFileMenu.setBounds(148, 4, 130, 26);
		add(txtFileMenu);
		txtFileMenu.setColumns(10);
		
		JButton btnSelect = new JButton("Select File");
		btnSelect.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		btnSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSelect.setBounds(23, 6, 96, 26);
		add(btnSelect);
	}

}
