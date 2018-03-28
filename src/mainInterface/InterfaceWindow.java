package mainInterface;

import javax.swing.JFrame;

public class InterfaceWindow extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/* Current Dimensions for main window */
	private static int width = 600;
	private static int height = 500;
	
	/* Objects for each component interface */
	private VisualizationPanel vPanel;
	private PlayerPanel pPanel;
	private FileMenu fPanel;
	private OptionsMenu oPanel;
	private AnalyticsDisplay aPanel;
	private TutorialPanel tPanel;
	
	public InterfaceWindow() {
		
		/* Initialize Main Window */
		setSize(width, height);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
		getContentPane().setLayout(null);
		
		/* Initialize interfaces for each component */
		vPanel = new VisualizationPanel();
		getContentPane().add(vPanel);
		pPanel = new PlayerPanel();
		getContentPane().add(pPanel);
		fPanel = new FileMenu();
		getContentPane().add(fPanel);
		aPanel = new AnalyticsDisplay();
		getContentPane().add(aPanel);
		oPanel = new OptionsMenu();
		getContentPane().add(oPanel);
		tPanel = new TutorialPanel();
		getContentPane().add(tPanel);
		
	}
	
	public static void main(String[] args) {
		new InterfaceWindow();
		
	}
}
