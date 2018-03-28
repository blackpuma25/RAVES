package mainInterface;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import fileSelection.FileChooser;

public class FileMenu extends JPanel{
	
	private static JTextField txtFileMenu;
	private static JTextField txtFileName;
	private static JTextField txtFilePath;
	
	private static boolean selecting = false;
	
	public FileMenu() {
		setBackground(new Color(65, 105, 225));
		setBounds(0, 0, 500, 126);
		setLayout(null);
		
		txtFileMenu = new JTextField();
		txtFileMenu.setBackground(Color.LIGHT_GRAY);
		txtFileMenu.setForeground(Color.BLACK);
		txtFileMenu.setHorizontalAlignment(SwingConstants.CENTER);
		txtFileMenu.setText("File Menu");
		txtFileMenu.setBounds(184, 4, 130, 26);
		add(txtFileMenu);
		txtFileMenu.setColumns(10);
		
		JButton btnSelect = new JButton("Select File");
		btnSelect.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		btnSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/* Run Java File chooser */
				FileChooser.main(null);
			}
		});
		btnSelect.setBounds(23, 6, 96, 26);
		add(btnSelect);
		
		txtFileName = new JTextField();
		txtFileName.setText("File Name: ");
		txtFileName.setBounds(124, 42, 261, 26);
		add(txtFileName);
		txtFileName.setColumns(10);
		
		txtFilePath = new JTextField();
		txtFilePath.setText("File Path: ");
		txtFilePath.setBounds(86, 94, 333, 26);
		add(txtFilePath);
		txtFilePath.setColumns(10);
	}
	
	public static void setSelecting(boolean select) {
		selecting = select;
	}
	
	public static void updateFields() {
		if (!selecting) {
			txtFileName.setText("File Name: " + FileChooser.getFileName());
			txtFilePath.setText("File Path: " + FileChooser.getFilePath());
		}
	}
}
