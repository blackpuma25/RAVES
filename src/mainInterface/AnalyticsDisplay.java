package mainInterface;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class AnalyticsDisplay extends JPanel{
	
	private JTextField txtAnalyticsDisplay;
	
	public AnalyticsDisplay() {
		setBackground(new Color(0, 128, 0));
		setBounds(300, 0, 300, 50);
		setLayout(null);
		
		txtAnalyticsDisplay = new JTextField();
		txtAnalyticsDisplay.setBackground(Color.LIGHT_GRAY);
		txtAnalyticsDisplay.setHorizontalAlignment(SwingConstants.CENTER);
		txtAnalyticsDisplay.setText("Analytics Display");
		txtAnalyticsDisplay.setBounds(75, 6, 130, 26);
		add(txtAnalyticsDisplay);
		txtAnalyticsDisplay.setColumns(10);
	}

}
