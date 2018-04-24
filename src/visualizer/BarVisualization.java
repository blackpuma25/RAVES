package visualizer;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;
import javax.swing.JTextField;

public class BarVisualization extends Visualization{

	private JTextField txtVisualiztionPanel;
	int x = 0;
	int y = 50;
	int width = 1000;
	int height = 450;
	int barwidth = 4;
	int gap = 1;
	double[] smooth;
	private double input[];
	public Thread thread;
	private boolean running = false;
	public BarVisualization() {
		setBackground(Color.WHITE);
		setBounds(x, y, width, height);
		//getContentPane().add(vPanel);
		setLayout(null);
		


//		thread = new BarVisualizerThread(this, null);
//		thread.start();
		//repaint();
	}
	
	public void giveData(double[] i) {
	input = i;
	
	}
	
	public void start() {
		running = true;
	}
	public void giveSize(int size) {
		smooth = new double[size];
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if(running) {
			g.setColor(Color.red);
		
		for (int i = 1; i< (input.length + 1) / 2; i++) {
			if(input[i] > smooth[i]) {
				smooth[i] = input[i];
			}
			g.fillRect(10 + (barwidth + gap) * i, (int)(height - (smooth[i]) * 5000), barwidth, (int)((smooth[i]) * 5000));
			smooth[i] = smooth[i] * .85;
		}
		}
		
	}



}
