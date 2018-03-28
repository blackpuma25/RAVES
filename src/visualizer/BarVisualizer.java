package visualizer;

public class BarVisualizer extends Visualizer {

	private Visualization vis;
	private BarVisualizerThread thread;
	private boolean hasPlayed = false;
	public BarVisualizer() {
		vis  = new Visualization();
		thread = new BarVisualizerThread(vis, null);
		
	
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
	public void giveData() {
		// TODO Auto-generated method stub

	}

}
