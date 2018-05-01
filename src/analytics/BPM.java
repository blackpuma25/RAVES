package analytics;

import fftHandler.FFTHandler;
import playback.Playback;

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
		int numBands = windowRes/2;
		
		/* Determine number of time intervals in a frame */
		float frameRate = Playback.getAudioFormat().getFrameRate(); //frames per second
		float frameLength = 1/frameRate;
		int intervalsPerFrame = (int) (frameLength/timeRes);
		
		/* For each band and each frame, compute time at which peak amplitude occurs */
		double maxAmplitude = 0;
		int peakTime = 0;
		for (int i = 0; i < Analytics.getFFTReference().length; i++) {
			for (int j = 0; j < numBands; j++) {
				if (Analytics.getFFTReference()[i][j] > maxAmplitude) {
					maxAmplitude = Analytics.getFFTReference()[i][j];
					peakTime = j;
				}
			}
		}
		
		/* Calculate space between next peak */
		
		
		/* Based off pattern of time intervals, calculate BPM */
		
		return 0;
	}
	
	/************ Helper Methods ********************/
	
	
	@Override
	public void run() {
		getBPM(Analytics.getFFTReference());
	}

}
