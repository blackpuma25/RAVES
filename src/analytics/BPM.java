package analytics;

public class BPM extends Thread {
	
	/* Algorithm to calculate BPM */
	public static int getBPM(double[][] fftData) {
		System.out.println("Starting BPM analysis");
		return 0;
	}
	
	/* Returns time resolution of FFT algorithm */
	public static int getTimeResolution() {
		return 0;
	}
	
	@Override
	public void run() {
		getBPM(Analytics.getFFTReference());
	}

}
