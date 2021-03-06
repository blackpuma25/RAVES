package visualizer;

import fftHandler.FFTHandler;
import fileSelection.FileChooser;
import playback.Playback;

public class BarVisualizer extends Visualizer{
	private BarVisualization vis;
	private boolean hasPlayed = false;
	private double[][] data = null;
	private boolean playing = false;
	private int delay = 48;
	private int i=0;
	
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
		i = 0;
		
		System.out.println(data.length);
//		for(int k = 0; k < data.length; k++) {
//			for(int j = 0; j < data[k].length; j++) {
//				System.out.println(data[k][j]);
//			}
//		
//		}
		while(playing && data[i] != null) {
			//System.out.println(data[i]);
		
		vis.giveData(data[i]);
		vis.repaint();
		i++;
		if(i>=data.length) {
			this.stop();
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
		i = (int) (data.length * (t/Playback.getDuration()));
		
	}

	@Override
	public void giveData(double[][] data) {
		this.data = data;
		vis.giveSize(data[0].length);
		i=0;
	}
	
	
}
