package visualizer;

public class BarVisualizerThread extends Thread{
	private Visualization vis;
	private double[][] data = new double[][] {{1, 2, 3, 4, 5, 6, 7, 8, 9, 10},
								{1, 2, 3, 4, 5, 6, 7, 8, 9, 10},
								{1, 2, 3, 4, 5, 6, 7, 8, 9, 10},
								{2, 3, 4, 5, 5, 5, 6, 7, 8, 9},
								{3, 4, 5, 5, 5, 5, 5, 6, 7, 8},
								{4, 5, 5, 5, 5, 5, 5, 5, 6, 7},
								{5, 5, 5, 5, 5, 5, 5, 5, 5, 5}
																};
	private boolean playing = true;
	private int delay = 1000;
	
	public BarVisualizerThread(Visualization vis, double[][] data) {
		this.vis = vis;
		//this.data = data;
	}
	


	public void run() {
		int i = 0;
		
		while(playing) {
		System.out.println(i);
		System.out.println(data[i]);
		vis.giveInput(data[i]);
		vis.repaint();
		i++;
			try {
				Thread.sleep(delay);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		}
		
	
	}
	
	
}
