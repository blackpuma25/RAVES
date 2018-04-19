package fftHandler;

import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.List;

import javax.sound.sampled.*;

import fileSelection.FileChooser;
import options.Options;

public class FFTHandler {
	
	/*********************************** Fields *******************************************/
	
	private static double[][] fftData = null; //The data used by the visualizer and analytics
	private static float timeInterval = 0; //Value for time resolution
	private static int windowSize = 0; //Value for frequency resolution
	
	private static File audioFile = null; //instance of audio file
	private static AudioInputStream audioStream = null; //instance of audio to read data
	private static AudioFormat audioFMT = null; //keeps audio formatting info (sample rate, number of channels, etc.)
	private static float bytesPerInterval = 0; //stores number of bytes for specified time interval
	
	private static List<byte[]> chunks = null; //stores the byte information for each time interval in audio file
	private static List<double[]> sampleData = null; //stores byte chunks as double to calculate FFT
	private static int dataPoints = 0; //stores number of points to calculate FFT (determined by timeInterval)
	
	/****************************************** Methods **************************************/
	
	/* Obtains values defined by options */
	public static void getOptions() {
		timeInterval = Options.getTimeIntervals()[Options.getTimeRes()];
		windowSize = Options.getWindowSizes()[Options.getFreqRes()];
	}
	
	/* Create audio stream for data analysis */
	public static void initializeAudioData() {
		try {
			audioStream = AudioSystem.getAudioInputStream(audioFile);
		} catch (UnsupportedAudioFileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		audioFMT = audioStream.getFormat();
	}
	
	/* Divides audio data into small chunks */
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
		}
	}
	
	/* Returns the number of bytes in a single time interval */
	public static float getBytesPerTimeInterval() {
		bytesPerInterval = getBytesPerSecond() * timeInterval;
		return bytesPerInterval;
	}
	
	/* Converts entire list of byte chunks from audio */
	public static void convertByteChunks() {
		sampleData = new ArrayList<double[]>();
		for(int i = 0; i < chunks.size(); i++) {
			try {
				sampleData.add(i, convertToDouble(chunks.get(i)));
			} catch (UnsupportedAudioFileException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	/* Gets entire FFT data structure from audio file */
	public static double[][] calculateFFT() {
		fftData = new double[dataPoints][windowSize];
		
		for (int i = 0; i < dataPoints; i++) { //for each time interval
			FFTInterval.calculateFFT(sampleData.get(i));
			FFTInterval.getFFTData();
			for (int j = 0; j < windowSize; j++) { //for each frequency
				fftData[i][j] = FFTInterval.getFFTData()[j];
				
			}
		}
		return fftData;
	}
	
	/* returns FFT data for given input file */
	public static double[][] getFFTData(File file) {
		getOptions();
		setAudioFile(file);
		initializeAudioData();
		getBytesPerTimeInterval();
		calculateDataPoints();
		splitAudio();
		convertByteChunks();
		return calculateFFT();
		
	}
	
	public static void resetData() {
		fftData = null;
		timeInterval = 0;
		windowSize = 0;
		
		audioFile = null;
		try {
			audioStream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		audioFMT = null;
		bytesPerInterval = 0;
		
		chunks = null;
		sampleData = null;
		dataPoints = 0;
	}
	
	/****************************** Helper Methods ***************************************/
	
	/* Returns window size (frequency resolution) */
	public static int getWindowSize() {
		return windowSize;
	}
	
	/* Calculates number of time intervals in file (time resolution) */
	public static void calculateDataPoints() {
		//dataPoints = (int) ((int) Playback.getDuration()/timeInterval); //What we will use
		
		dataPoints = (int) (getDuration()/timeInterval);
	}
	
	/* Calculates the duration of the audio file in seconds */
	public static double getDuration() { //Extra method to be deleted
		long audioFileLength = audioFile.length();
		int frameSize = audioFMT.getFrameSize();
		float frameRate = audioFMT.getFrameRate();
		double fullDuration = audioFileLength / (frameSize * frameRate);
		return fullDuration;	
	}
	
	/* Returns the number of bytes in a one second interval of audio file */
	public static float getBytesPerSecond() {
		int channels = audioFMT.getChannels();
		float sampleRate = audioFMT.getSampleRate();
		int bitsPerSample = audioFMT.getSampleSizeInBits();
		float bytesPerSecond = (channels * sampleRate * bitsPerSample)/8;
		return bytesPerSecond;
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
	
	/* Retrieves chosen audio file from File Chooser */
	public static File getAudioFile() {
		return FileChooser.getCurrrentFile();
	}
	
	/* Sets audio file to input file */
	public static void setAudioFile(File file) {
		audioFile = file;
	}

	public static float getTimeInterval() {
		return timeInterval;
	}
	
	

}
