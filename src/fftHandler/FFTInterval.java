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
		fftData = realData;
		fftData = scaleData(fftData);
	}
	
	public static double[] getFFTData() {
		return fftData;
	}
	
	public static double[] scaleData(double[] fft) {
		int scale = FFTHandler.getWindowSize();
		for (int i = 0; i < fft.length; i++) {
			fft[i] = fft[i]/scale;
		}
		
		return fft;
	}

}
