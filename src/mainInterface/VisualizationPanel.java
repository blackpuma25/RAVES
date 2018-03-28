package mainInterface;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JTextField;

public class VisualizationPanel extends JPanel {
	
	private JTextField txtVisualiztionPanel;
	
	public VisualizationPanel() {
		setBackground(Color.WHITE);
		setBounds(0, 50, 600, 350);
		//getContentPane().add(vPanel);
		setLayout(null);
		
		txtVisualiztionPanel = new JTextField();
		txtVisualiztionPanel.setBackground(Color.LIGHT_GRAY);
		txtVisualiztionPanel.setText("Visualiztion Panel");
		txtVisualiztionPanel.setBounds(240, 180, 130, 26);
		add(txtVisualiztionPanel);
		txtVisualiztionPanel.setColumns(10);
		
	}

}
