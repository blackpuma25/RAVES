package analytics;

import fftHandler.FFTHandler;

public class BPM extends Thread {
	
	private static float timeRes;
	private static int windowRes;
	
	/* The length of these arrays are determined by number of frames in file */
	private static double[] peakTimes; //stores times at which peak amplitudes occur
	private static double[] peakAmplitudes; //stores values of peak amplitudes
	private static double[] averageAmplitude; //stores average amplitude for the time period
	
	
	/* Algorithm to calculate BPM */
	public static int getBPM(double[][] fftData) {
		
		/* Get Option settings */
		System.out.println("Starting BPM analysis");
		FFTHandler.getOptions();
		timeRes = FFTHandler.getTimeInterval();
		windowRes = FFTHandler.getWindowSize();
		
		/* Determine number of frequency bands to use */
		// Window size/2
		
		
		/* Determine number of time intervals in a frame */
		// Length of frame/time interval
		
		/* For each band and each frame, compute time at which peak amplitude occurs */
		
		/* Have an estimate for the period at which next peak will occur? */
		
		/* Based off pattern of time intervals, calculate BPM */
		
		//May need to add a variation for peak amplitudes
		
		return 0;
	}
	
	/************ Helper Methods ********************/
	
	
	@Override
	public void run() {
		getBPM(Analytics.getFFTReference());
	}

}
