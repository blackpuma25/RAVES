package analytics;

import fftHandler.FFTHandler;

public class BPM extends Thread {
	
	private static float timeRes;
	private static int windowRes;
	
	/* Algorithm to calculate BPM */
	public static int getBPM(double[][] fftData) {
		System.out.println("Starting BPM analysis");
		FFTHandler.getOptions();
		timeRes = FFTHandler.getTimeInterval();
		windowRes = FFTHandler.getWindowSize();
		
		return 0;
	}
	
	/************ Helper Methods ********************/
	
	public static void getWindowResolution() {
		
	}
	
	@Override
	public void run() {
		getBPM(Analytics.getFFTReference());
	}

}
