package visualizer;

import fftHandler.FFTHandler;
import fileSelection.FileChooser;

public class BarVisualizer extends Visualizer{
	private BarVisualization vis;
	private boolean hasPlayed = false;
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
	
	//depreciated
	public BarVisualizer(BarVisualization vis, double[][] data) {
		this.vis = vis;
		//this.data = data;
	}
	public BarVisualizer() {
		vis = new BarVisualization();
	}
	
	public void play() {
		//check if data loaded?
		playing = true; //probably not needed
		vis.start();
		if(!hasPlayed) {
			start();
			System.out.println("started");
			hasPlayed = true;
			}else if(hasPlayed) {
			resume();
			}
	}
	
	public void pause() {
		if(hasPlayed) {
			suspend();
		}
	}

	public void run() {
		int i = 0;
		data = FFTHandler.getData(FileChooser.getCurrrentFile());
		System.out.println(data.length);
//		for(int k = 0; k < data.length; k++) {
//			for(int j = 0; j < data[k].length; j++) {
//				System.out.println(data[k][j]);
//			}
//		
//		}
		while(playing && data[i] != null) {
			//System.out.println(i);
		vis.giveData(data[i]);
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

	@Override
	public Visualization getVisualization() {
		
		return vis;
	}

	@Override
	public void skip(int t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void giveData() {
		// TODO Auto-generated method stub
		
	}
	
	
}
