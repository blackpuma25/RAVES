package testing;

import static org.junit.jupiter.api.Assumptions.assumingThat;

import java.io.File;

import fftHandler.FFTHandler;

public class FFTTester {
	
	private static File audioFile = new File("/Users/Batman/Documents/GitHub/RAVES/src/testing/A River Flows in You.wav"); //pathname may need to be edited for testing on personal machine;
	
	public static void main(String[] args) {
		FFTHandler.setAudioFile(audioFile);
		FFTHandler.createAudioStream();
		FFTHandler.getBytesPerTimeInterval();
		FFTHandler.calculateDataPoints();
		FFTHandler.splitAudio();
		FFTHandler.convertByteChunks();
		FFTHandler.getFFTData();
		
		int length = FFTHandler.getFFTData().length;
		System.out.println(length);
	}

}
