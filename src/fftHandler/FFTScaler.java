package fftHandler;

public class FFTScaler {
	
	private static double[][] amplitudes;
	
	private static double[] linearFreq;
	private static double[] logFreq;
	private static int numBins;
	
	
	public static void setAmplitudes(double[][] samples) {
		amplitudes = samples;
	}
	
	public static void calculateFrequencies() {
		int windowSize = FFTHandler.getWindowSize();
		double sampleRate = FFTHandler.getAudioFMT().getSampleRate();
		linearFreq = new double[windowSize/2];
		for (int i = 0; i < linearFreq.length; i++) {
			linearFreq[i] = (i * sampleRate/windowSize);
		}
	}
	
	public static void calculateNewBins() {
		int startFreq = 20;
		int endFreq = 21000;
		
		for (int i = startFreq; i < endFreq; numBins++) {
			i = i*2;
		}
		System.out.println(numBins);
	}
	
	public static void getLogFrequencies() {
		logFreq = new double[numBins];
		
		
	}
	
	
	
	/******************* Helpers ******************************/
	public static int log2(double x) {
		return (int) (Math.log(x)/Math.log(2) + 1e-10);
	}
	

}
