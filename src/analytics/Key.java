package analytics;

public class Key extends Thread {
	
	/* Algorithm to calculate the musical key */
	public static String getKey(double[][] fftData) {
		System.out.println("Starting Key analysis");
		return null;
	}
	
	@Override
	public void run() {
		getKey(Analytics.getFFTReference());
	}
	
}
