package visualizer;

public abstract class Visualizer extends Thread {

	public abstract Visualization getVisualization();
	
	public abstract void pause();
	
	public abstract void play();
	
	public abstract void skip(int t);
	

	public void giveData(double[][] data) {
		// TODO Auto-generated method stub
		
	}
	
}
