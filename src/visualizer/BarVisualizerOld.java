package visualizer;

public class BarVisualizerOld extends Visualizer {

	private Visualization vis;
	private BarVisualizer thread;
	private boolean hasPlayed = false;
	public BarVisualizerOld() {
		//vis  = new Visualization();
		//thread = new BarVisualizer(vis, null);
		
	
	}
	
	
	@Override
	public Visualization getVisualization() {

		return vis;
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		if(hasPlayed) {
			thread.suspend();
		}
	}

	@Override
	public void play() {
		if(!hasPlayed) {
		thread.play();
		thread.start();
		hasPlayed = true;
		}else if(hasPlayed) {
		thread.resume();
		}
	}

	@Override
	public void skip(int t) {
		// TODO Auto-generated method stub

	}

	@Override
	public void giveData(double[][] data) {
		// TODO Auto-generated method stub

	}

}
