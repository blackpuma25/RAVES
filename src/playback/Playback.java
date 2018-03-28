package playback;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import fileSelection.FileChooser;

import javax.sound.sampled.AudioFormat.Encoding;

public class Playback {
	
	/*********************** Fields ********************************/
	private static File audioFile; //instance of audio file
	private static AudioInputStream audioStream; //instance of audio to read data
	private static AudioFormat audioFMT; //keeps audio formatting info (sample rate, number of channels, etc.)
	private static Clip clip = null;
	private static boolean playing = false;
	
	
	/************************ Methods 
	 * @throws LineUnavailableException *******************************/
	
	public static void setAudioFile() throws LineUnavailableException {
		audioFile = FileChooser.getCurrrentFile();
		createAudioStream();
		isSupportedAudioFile();
	}
	
	/* Creates the audio stream and formating instance of audio file */
	public static void createAudioStream() throws LineUnavailableException {
		try {
			audioStream = AudioSystem.getAudioInputStream(audioFile);
			clip = AudioSystem.getClip();
		} catch (UnsupportedAudioFileException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		audioFMT = audioStream.getFormat();
	}
	
	/* Checks if file format is supported for this program */
	public static void isSupportedAudioFile() {
		try {
			if(audioFMT.getEncoding() != Encoding.PCM_SIGNED) {
				throw new UnsupportedAudioFileException();
			}
		} catch (UnsupportedAudioFileException e) {
			e.printStackTrace();
		}
	}
	
	public static void play() {
		clip.start();
		playing = true;
		
	}
	
	public static void pause() {
		if (playing) {
			clip.stop();
			playing = false;
		}
		
	}
	
	public void skip(float time) {
		
	}
	
	public void setVolume(int x) {
		
	}
	
	public void giveFile(File f) {
		
	}
	
	/* Calculates the duration of the audio file in seconds */
	public static double getDuration() {
		long audioFileLength = audioFile.length();
		int frameSize = audioFMT.getFrameSize();
		float frameRate = audioFMT.getFrameRate();
		double fullDuration = audioFileLength / (frameSize * frameRate);
		return fullDuration;	
	}

}
