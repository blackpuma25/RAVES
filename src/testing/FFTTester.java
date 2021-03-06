package testing;

import static org.junit.Assert.assertEquals;
import java.io.File;

import org.junit.Test;

import fftHandler.FFTHandler;

public class FFTTester {
	
	private static double[][] reference;	
	private static File audioFile = new File("testing/A River Flows in You.wav");

	
	@SuppressWarnings("deprecation")
	@Test
	public void getData() throws Exception {
		reference = FFTHandler.getFFTData(audioFile);
		double[][] reference2;
		
		FFTHandler.setAudioFile(audioFile);
		FFTHandler.initializeAudioData();
		FFTHandler.getBytesPerTimeInterval();
		FFTHandler.calculateDataPoints();
		FFTHandler.splitAudio();
		FFTHandler.convertByteChunks();
		reference2 = FFTHandler.calculateFFT();
		
		assertEquals(reference, reference2);
		assertEquals(reference.length, reference2.length);
	}
}
