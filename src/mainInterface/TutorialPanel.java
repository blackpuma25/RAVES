package mainInterface;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class TutorialPanel extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtTutorial;
	
	public TutorialPanel() {
		setBackground(new Color(112, 128, 144));
		setBounds(500, 400, 225, 103);
		setLayout(null);
		
		txtTutorial = new JTextField();
		txtTutorial.setBackground(Color.LIGHT_GRAY);
		txtTutorial.setHorizontalAlignment(SwingConstants.CENTER);
		txtTutorial.setText("Tutorial");
		txtTutorial.setBounds(69, 37, 88, 26);
		add(txtTutorial);
		txtTutorial.setColumns(10);
		
	}

}
