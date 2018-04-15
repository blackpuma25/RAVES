package mainInterface;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import analytics.Analytics;

import javax.swing.JButton;

public class AnalyticsDisplay extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtBpm;
	private JTextField txtKey;
	
	public AnalyticsDisplay() {
		setBackground(new Color(0, 128, 0));
		setBounds(300, 0, 500, 126);
		setLayout(null);
		
		txtBpm = new JTextField();
		txtBpm.setText("BPM: ");
		txtBpm.setBounds(34, 78, 130, 26);
		add(txtBpm);
		txtBpm.setColumns(10);
		
		txtKey = new JTextField();
		txtKey.setText("Key: ");
		txtKey.setBounds(337, 78, 130, 26);
		add(txtKey);
		txtKey.setColumns(10);
		
		JButton btnPerformAnalytics = new JButton("Perform Analytics");
		btnPerformAnalytics.setBounds(155, 26, 182, 29);
		btnPerformAnalytics.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Analytics.performAnalytics();
				txtBpm.setText("Calculating BPM...");
				txtKey.setText("Calculating Key...");
			}
		});
		add(btnPerformAnalytics);
	}
}
