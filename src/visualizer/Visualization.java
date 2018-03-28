package visualizer;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;
import javax.swing.JTextField;

public class Visualization extends JPanel{

	private JTextField txtVisualiztionPanel;
	int x = 0;
	int y = 50;
	int width = 1000;
	int height = 450;
	int barwidth = 70;
	int gap = 10;
	private double input[];
	public Thread thread;
	private boolean running = false;
	public Visualization() {
		setBackground(Color.WHITE);
		setBounds(x, y, width, height);
		//getContentPane().add(vPanel);
		setLayout(null);
		
		txtVisualiztionPanel = new JTextField();
		txtVisualiztionPanel.setBackground(Color.LIGHT_GRAY);
		txtVisualiztionPanel.setText("Visualiztion Panel");
		txtVisualiztionPanel.setBounds(430, 217, 130, 26);
		add(txtVisualiztionPanel);
		txtVisualiztionPanel.setColumns(10);
//		thread = new BarVisualizerThread(this, null);
//		thread.start();
		//repaint();
	}
	
	public void giveInput(double[] i) {
	input = i;
	}
	
	public void start() {
		running = true;
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if(running) {
			g.setColor(Color.red);
		
		for (int i = 0; i< input.length; i++) {
			g.fillRect(10 + (barwidth + gap) * i, (int)(height - (20 * input[i])), barwidth, (int)(input[i] * 20));
		}
		}
		
	}

}
