package visualizer;

public class BarVisualizerThread extends Thread{
	private Visualization vis;
	private double[][] data = new double[][] {{1, 2, 3, 4, 5, 6, 7, 8, 9, 10},
								{1, 2, 3, 4, 5, 6, 7, 8, 9, 10},
								{1, 2, 3, 4, 5, 6, 7, 8, 9, 10},
								{2, 3, 4, 5, 5, 5, 6, 7, 8, 9},
								{3, 4, 5, 5, 5, 5, 5, 6, 7, 8},
								{4, 5, 5, 5, 5, 5, 5, 5, 6, 7},
								{5, 5, 5, 5, 5, 5, 5, 5, 5, 5},
								{1, 2, 3, 4, 5, 6, 7, 8, 9, 10},
								{1, 2, 3, 4, 5, 6, 7, 8, 9, 10},
								{2, 3, 4, 5, 5, 5, 6, 7, 8, 9},
								{3, 4, 5, 5, 5, 5, 5, 6, 7, 8},
								{4, 5, 5, 5, 5, 5, 5, 5, 6, 7},
								{5, 5, 5, 5, 5, 5, 5, 5, 5, 5},
								{1, 2, 3, 4, 5, 6, 7, 8, 9, 10},
								{1, 2, 3, 4, 5, 6, 7, 8, 9, 10},
								{2, 3, 4, 5, 5, 5, 6, 7, 8, 9},
								{3, 4, 5, 5, 5, 5, 5, 6, 7, 8},
								{4, 5, 5, 5, 5, 5, 5, 5, 6, 7},
								{5, 5, 5, 5, 5, 5, 5, 5, 5, 5},
								{1, 2, 3, 4, 5, 6, 7, 8, 9, 10},
								{1, 2, 3, 4, 5, 6, 7, 8, 9, 10},
								{2, 3, 4, 5, 5, 5, 6, 7, 8, 9},
								{3, 4, 5, 5, 5, 5, 5, 6, 7, 8},
								{4, 5, 5, 5, 5, 5, 5, 5, 6, 7},
								{5, 5, 5, 5, 5, 5, 5, 5, 5, 5},
								{1, 2, 3, 4, 5, 6, 7, 8, 9, 10},
								{1, 2, 3, 4, 5, 6, 7, 8, 9, 10},
								{2, 3, 4, 5, 5, 5, 6, 7, 8, 9},
								{3, 4, 5, 5, 5, 5, 5, 6, 7, 8},
								{4, 5, 5, 5, 5, 5, 5, 5, 6, 7},
								{5, 5, 5, 5, 5, 5, 5, 5, 5, 5},
								{1, 2, 3, 4, 5, 6, 7, 8, 9, 10},
								{1, 2, 3, 4, 5, 6, 7, 8, 9, 10},
								{2, 3, 4, 5, 5, 5, 6, 7, 8, 9},
								{3, 4, 5, 5, 5, 5, 5, 6, 7, 8},
								{4, 5, 5, 5, 5, 5, 5, 5, 6, 7},
								{5, 5, 5, 5, 5, 5, 5, 5, 5, 5}
																};
	private boolean playing = false;
	private int delay = 100;
	
	public BarVisualizerThread(Visualization vis, double[][] data) {
		this.vis = vis;
		//this.data = data;
	}
	
	public void play() {
		//check if data loaded?
		playing = true;
		vis.start();
	}
	
	public void pause() {
	}

	public void run() {
		int i = 0;
		
		while(playing && data[i] != null) {
		vis.giveInput(data[i]);
		vis.repaint();
		i++;
		if(i>=data.length) {
			i = 0;
		}
			try {
				Thread.sleep(delay);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		}
		
	
	}
	
	
}
