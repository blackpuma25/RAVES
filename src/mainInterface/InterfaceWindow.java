package mainInterface;

import javax.swing.JFrame;

import visualizer.*;


public class InterfaceWindow extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/* Objects for each component interface */
	private Visualization vPanel;
	private PlayerPanel pPanel;
	private FileMenu fPanel;
	private OptionsMenu oPanel;
	private AnalyticsDisplay aPanel;
	private TutorialPanel tPanel;
	private static Visualizer visualizer;
	
	
	
	public InterfaceWindow() {
		
		/* Initialize Main Window */
		setSize(1000, 700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
		getContentPane().setLayout(null);
		
		//get visualizer from settings eventually
		visualizer = new BarVisualizer();
		
		
		/* Initialize interfaces for each component */
		vPanel = visualizer.getVisualization();
		vPanel.setSize(1000, 450);
		vPanel.setLocation(0, 125);
		getContentPane().add(vPanel);
		pPanel = new PlayerPanel();
		pPanel.setSize(550, 103);
		pPanel.setLocation(225, 575);
		getContentPane().add(pPanel);
		fPanel = new FileMenu();
		fPanel.setBounds(0, 0, 500, 126);
		getContentPane().add(fPanel);
		aPanel = new AnalyticsDisplay();
		aPanel.setSize(500, 126);
		aPanel.setLocation(500, 0);
		getContentPane().add(aPanel);
		oPanel = new OptionsMenu();
		oPanel.setSize(225, 103);
		oPanel.setLocation(0, 575);
		getContentPane().add(oPanel);
		tPanel = new TutorialPanel();
		tPanel.setSize(225, 103);
		tPanel.setLocation(775, 575);
		getContentPane().add(tPanel);
		vPanel.setVisible(true);
		add(vPanel);
		vPanel.setVisible(true);
		repaint();
	}
	

	
	public static Visualizer getVisualizer() {
		return visualizer;
	}
	
	public static void main(String[] args) {
		new InterfaceWindow();
		
	}
}
