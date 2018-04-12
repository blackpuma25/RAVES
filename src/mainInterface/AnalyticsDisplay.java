package mainInterface;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class AnalyticsDisplay extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtAnalyticsDisplay;
	
	public AnalyticsDisplay() {
		setBackground(new Color(0, 128, 0));
		setBounds(300, 0, 500, 126);
		setLayout(null);
		
		txtAnalyticsDisplay = new JTextField();
		txtAnalyticsDisplay.setBackground(Color.LIGHT_GRAY);
		txtAnalyticsDisplay.setHorizontalAlignment(SwingConstants.CENTER);
		txtAnalyticsDisplay.setText("Analytics Display");
		txtAnalyticsDisplay.setBounds(185, 45, 130, 26);
		add(txtAnalyticsDisplay);
		txtAnalyticsDisplay.setColumns(10);
	}

}
