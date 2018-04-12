package playback;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;


import mainInterface.PlayerPanel;

import javax.sound.sampled.AudioFormat.Encoding;

import fileSelection.FileChooser;

public class Playback {
	
	/************************************** Fields ******************************************/
	
	private static File audioFile; //instance of audio file
	private static AudioInputStream audioStream; //instance of audio to read data
	private static AudioFormat audioFMT; //keeps audio formatting info (sample rate, number of channels, etc.)
	
	private static Clip clip = null; //a clip instance used for playback and position control
	private static Long currentFrame; //tracks the current frame of clip
	private static int newPosition; //stores a value of new clip position from scrubbing
	private static double position = 0; //value that maintains position in seconds
	private static boolean playing = false; //tracks if sound is playing
	
	
	/************************************** Methods 
	 * @return *****************************************/
	
	/* Creates the audio stream and formating instance of audio file */
	public static AudioInputStream createAudioStream() throws LineUnavailableException {
		try {
			audioStream = AudioSystem.getAudioInputStream(audioFile);
			clip = AudioSystem.getClip();
			clip.open(audioStream);
		} catch (UnsupportedAudioFileException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		audioFMT = audioStream.getFormat();
		return audioStream;
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
	
	/* Plays audio file and updates duration field */
	public static void play() {
		clip.start();
		playing = true;
		PlayerPanel.updateDuration();
		
	}
	
	/* Pauses audio file */
	public static void pause() {
		if (playing) {
			clip.stop();
			playing = false;
		}
	}
	
	/* Maintains playing state of audio player */
	public static boolean isPlaying() {
		return playing;
	}
	
	/* Maintains current position while playing */
	public static void updatePosition() {
		do {
			setPosition(clip.getMicrosecondPosition());
		} while (playing);
	}
	
	/* Jumps to different time section based of scrub bar value */
	public static void scrub() {
		newPosition = PlayerPanel.getSlider().getValue();
		if (newPosition != (int) getPosition()) {
			try {
				jump((long) newPosition);
			} catch (UnsupportedAudioFileException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (LineUnavailableException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	 /* Maintains state of user interaction with scrub bar */
	public static boolean isScrubbed() {
		int newPosition = PlayerPanel.getSlider().getValue();
		if (newPosition != (int) getPosition())
			return true;
		return false;
	}
	
	/* Jumps to specified section of audio file */
	public static void jump(long c) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		if (c > 0 && c < clip.getMicrosecondLength()) {
			clip.stop();
			clip.close();
			resetAudioStream();
			currentFrame = c;
			clip.setMicrosecondPosition(c * 1000000);
			clip.start();
		}
	}

	/* Resets audio stream for scrubbing */
	public static void resetAudioStream() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		audioStream = AudioSystem.getAudioInputStream(audioFile);
		clip.open(audioStream);
		clip.loop(Clip.LOOP_CONTINUOUSLY);
	}
	
	/* Calculates the duration of the audio file in seconds */
	public static double getDuration() {
		long audioFileLength = audioFile.length();
		int frameSize = audioFMT.getFrameSize();
		float frameRate = audioFMT.getFrameRate();
		double fullDuration = audioFileLength / (frameSize * frameRate);
		return fullDuration;	
	}
	
	/**************************** Getters and Setters *******************************/
	
	/* Sets audio file to input file */
	public static void setAudioFile(File file){
		audioFile = file;
		Position p = new Position(); //Creates thread for maintaining position
		p.start();
	}
	
	/* Retrieves chosen audio file from File Chooser */
	public static File getAudioFile() {
		return FileChooser.getCurrrentFile();
	}
	
	/* Sets volume level */
	public static void setVolume(int x) {
		
	}
	
	/* Retrieves volume level */
	public static int getVolume(int x) {
		return 0;
	}
	
	/* Returns audio stream */
	public static AudioInputStream getAudioStream() {
		return audioStream;
	}
	
	/* Returns audio format */
	public static AudioFormat getAudioFormat() {
		return audioFMT;
	}
	
	/* Returns stored value for position */
	public static double getPosition() {
		return position;
	}
	
	/* Sets position to input value and converts to seconds */
	public static void setPosition(double position) {
		Playback.position = position * 0.000001;
	}
	
	/* Returns reference for clip */
	public static Clip getClip() {
		return clip;
	}

}
