package fftHandler;

import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.List;

import javax.sound.sampled.*;

import fileSelection.FileChooser;
import playback.Playback;

public class FFTHandler {
	
	private static double[][] fftData;
	private static float timeInterval = 1; //initialized to one second intervals
	private static double frequencyBand;
	private static int windowSize = 64; //default resolution of window size
	
	private static File audioFile; //instance of audio file
	private static AudioInputStream audioStream; //instance of audio to read data
	private static AudioFormat audioFMT; //keeps audio formatting info (sample rate, number of channels, etc.)
	private static float Bps; //Bytes per second
	private static float bytesPerInterval; //stores number of bytes for specified time interval
	
	private static List<byte[]> chunks; //stores the byte information for each time interval in audio file
	private static double[] sampleData; //stores byte chunks as double to calculate fft
	private static int dataPoints; //stores number of points to calculate FFT (determined by timeInterval)
	
	
	public static int getWindowSize() {
		return windowSize;
	}
	
	public static File getAudioFile() {
		return FileChooser.getCurrrentFile();
	}
	
	public static void createAudioStream() {
		try {
			audioStream = AudioSystem.getAudioInputStream(audioFile);
		} catch (UnsupportedAudioFileException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		audioFMT = audioStream.getFormat();
	}
	
	/* Divides audio data into small chunks for threads to handle */
	public static void splitAudio() {
		chunks = new ArrayList<byte[]>();
		int length = (int) bytesPerInterval;
		int bytesRead = 0;
		byte[] byteBuffer = new byte[176401];
		
		for(int i = 0; i < dataPoints; i++) {
			byteBuffer = new byte[176401]; //allows for new reference for chunks list
			
			
			try {
				bytesRead = audioStream.read(byteBuffer, 0, length);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			chunks.add(byteBuffer);
			System.out.println("Bytes Read for t = " + i + ": " + bytesRead);
		}
		System.out.println("");
	}
	
	
	/* Returns the number of bytes in a one second interval of audio file */
	public static float getBytesPerSecond() {
		int channels = audioFMT.getChannels();
		float sampleRate = audioFMT.getSampleRate();
		int bitsPerSample = audioFMT.getSampleSizeInBits();
		float bytesPerSecond = (channels * sampleRate * bitsPerSample)/8;
		return bytesPerSecond;
	}
	
	public static float getBytesPerTimeInterval() {
		return getBytesPerSecond() * timeInterval;
	}
	
	/* Converts individual byte chunks to double */
	public static double[] convertToDouble(byte[] bytes) throws UnsupportedAudioFileException {
		ByteBuffer bb = ByteBuffer.wrap(bytes);
		bb.order(audioFMT.isBigEndian() ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
		int bits = audioFMT.getSampleSizeInBits();
		double max = Math.pow(2, bits - 1);
		double[] samples = new double[windowSize]; //setting to window of FFT
		
		for(int i = 0; i < samples.length; ++i) {
	        switch(bits) {
	            case 8:  samples[i] = (bb.get()/max);
	                     break;
	            case 16: samples[i] = (bb.getShort()/max);
	                     break;
	            case 32: samples[i] = (bb.getInt()/max);
	                     break;
	            case 64: samples[i] = (bb.getLong()/max);
	                     break;
	            default: throw new UnsupportedAudioFileException();
	        }
	    }
		return samples;
	}
	
	public static void calculateDataPoints() {
		dataPoints = (int) ((int) Playback.getDuration()/timeInterval);
	}
	
	public static double[][] getFFTData() {
		fftData = new double[dataPoints][windowSize];
		
		for (int i = 0; i < dataPoints; i++) {
			FFTInterval.calculateFFT(sampleData);
			FFTInterval.getFFTData();
			for (int j = 0; j < windowSize; j++) {
				
			}
		}
		
		
		return fftData;
	}
	
	public static void main(String[] args) {
		audioFile = getAudioFile();
		createAudioStream();
		getBytesPerTimeInterval();
		splitAudio();
		
		
		
		
	}

}
