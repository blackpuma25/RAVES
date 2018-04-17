package analytics;

import fftHandler.FFTHandler;

public class BPM extends Thread {
	
	private static float timeRes;
	private static int windowRes;
	
	/* Algorithm to calculate BPM */
	public static int getBPM(double[][] fftData) {
		
		/* Get Option settings */
		System.out.println("Starting BPM analysis");
		FFTHandler.getOptions();
		timeRes = FFTHandler.getTimeInterval();
		windowRes = FFTHandler.getWindowSize();
		
		/* Determine number of bands to use */
		
		/* Determine number of time intervals in a frame */
		
		/* For each band and each frame, compute time at which peak amplitude occurs */
		
		/* Have an estimate for the period at which next peak will occur? */
		
		/* Based off pattern of time intervals, calculate BPM */
		
		//May need to add a variation for peak amplitudes
		
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
