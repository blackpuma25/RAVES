package analytics;

import fftHandler.FFTHandler;
import fileSelection.FileChooser;

public class Analytics {
	
	private static double[][] fftReference; //data reference for algorithms to access
	
	/* Returns calculate FFT data for audio file */
	public static double[][] getFFTReference() {
		return fftReference;
	}
	
	/* Starts performing analytics on given audio file */
	public static void performAnalytics() {
		fftReference = FFTHandler.getFFTData(FileChooser.getCurrrentFile());
		BPM b = new BPM();
		b.start();
	}

}
