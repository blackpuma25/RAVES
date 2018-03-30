package fftHandler;

import java.util.List;

public class FFTInterval {
	
	private List<double[]> sampleData; //Stores data calculated from AudioAnalyzer.java
	private static double[] fftData = new double[FFTHandler.getWindowSize()]; //Initialized to frequency resolution
	private int timeInterval; //Time interval for thread to evaluate
	
	/* Calculates FFT from given double[] data */
	public static void calculateFFT(double[] samples) {
		double[] realData = samples;
		double[] ImagData = new double[realData.length];
		FFT myFFT = new FFT(FFTHandler.getWindowSize());
		myFFT.fft(realData, ImagData);
		fftData = FFT.beforeAfter(myFFT, realData, ImagData);
	}
	
	public static double[] getFFTData() {
		return fftData;
	}

}
