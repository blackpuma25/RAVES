package fftHandler;

public class FFTScaler {

	private static double[][] amplitudes;
	private static double[][] scaledFFT;

	private static double[] linearFreq;
	private static double[] logFreq;
	private static int numBins;

	public static void setAmplitudes(double[][] samples) {
		amplitudes = samples;
		scaledFFT = new double[FFTHandler.getDataPoints()][FFTHandler.getWindowSize()];
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
		int count = 0;
		for (int i = startFreq; i < endFreq; count++) {
			i = i*2;
		}
		numBins = count;
		System.out.println(numBins);
	}

	public static void getLogFrequencies() {
		int startFreq = 20;
		int endFreq = 21000;
		int freq = startFreq;
		logFreq = new double[numBins];
		for (int i = 0; i < logFreq.length; i++) {
			logFreq[i] = freq;
			System.out.println(freq);
			freq = freq*2;
		}
	}

	public static double[][] mergeAmplitudes() {

		double amplitudeBuffer = 0;
		int scaleIndex = 0;
		boolean merged = false;

		for (int i = 0; i < FFTHandler.getDataPoints(); i++) {
			for(int j = 0; j < FFTHandler.getWindowSize()/2; j++) {
				if (scaleIndex < 11) {
					if (linearFreq[j] < logFreq[scaleIndex]) {
						amplitudeBuffer = amplitudeBuffer + amplitudes[i][j];
						merged = true;
					}
					else if (merged && linearFreq[j] >= logFreq[scaleIndex]) {
						scaledFFT[i][scaleIndex] = amplitudeBuffer;
						amplitudeBuffer = 0;
						scaleIndex++;
						merged = false;
					}
					else {
						scaledFFT[i][scaleIndex] = amplitudes[i][j];
						scaleIndex++;
					}
				}
			}
			scaleIndex = 0;
		}
		return scaledFFT;
	}

	public static double[][] scaleData() {
		calculateFrequencies();
		calculateNewBins();
		getLogFrequencies();
		return mergeAmplitudes();
	}



	/******************* Helpers ******************************/
	public static int log2(double x) {
		return (int) (Math.log(x)/Math.log(2) + 1e-10);
	}


}
