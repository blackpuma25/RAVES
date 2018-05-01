package mainInterface;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class AnalyticsDisplay extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static JTextField txtBpm;
	private static JButton btnPerformAnalytics;
	
	public AnalyticsDisplay() {
		setBackground(new Color(0, 128, 0));
		setBounds(300, 0, 500, 126);
		setLayout(null);
		
		txtBpm = new JTextField();
		txtBpm.setText("BPM: ");
		txtBpm.setBounds(183, 77, 130, 26);
		add(txtBpm);
		txtBpm.setColumns(10);
		
		btnPerformAnalytics = new JButton("Perform Analytics");
		btnPerformAnalytics.setBounds(155, 26, 182, 29);
		btnPerformAnalytics.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtBpm.setText("Calculating BPM...");
			}
		});
		btnPerformAnalytics.setEnabled(false);
		add(btnPerformAnalytics);
	}
	
	public static void enableAnalytics() {
		btnPerformAnalytics.setEnabled(true);
	}
	
	public static void disableAnalytics() {
		btnPerformAnalytics.setEnabled(false);
	}
}
