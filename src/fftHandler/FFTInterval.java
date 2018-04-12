package fftHandler;

//import java.util.List;

public class FFTInterval {
	
	private static double[] fftData = new double[FFTHandler.getWindowSize()]; //Initialized to frequency resolution
	
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
