package playback;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import mainInterface.InterfaceWindow;
import mainInterface.PlayerPanel;

import javax.sound.sampled.AudioFormat.Encoding;

import fileSelection.FileChooser;

public class Playback {
	
	/************************************** Fields ******************************************/
	
	private static File audioFile = null; //instance of audio file
	private static AudioInputStream audioStream = null; //instance of audio to read data
	private static AudioFormat audioFMT = null; //keeps audio formatting info (sample rate, number of channels, etc.)
	
	private static Clip clip = null; //a clip instance used for playback and position control
	private static Long currentFrame = (long) 0; //tracks the current frame of clip
	private static int newPosition = 0; //stores a value of new clip position from scrubbing
	private static double position = 0; //value that maintains position in seconds
	private static boolean playing = false; //tracks if sound is playing
	private static int volPosition = 0; //stores value of volume for slider
	private static FloatControl gainControl; //Used for storing volume level in decibels
	
	
	/************************************** Methods *****************************************/
	
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
		
		/* Volume control */
		//gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
		//System.out.println("Max Volume: " + gainControl.getMaximum() + " dB");
		//System.out.println("Min Volume: " + gainControl.getMinimum() + " dB");
		//PlayerPanel.initializeVolSlider();
		
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
	
	/* Closes and resets audio fields */
	public static void closeSession() {
		if (playing)
			pause();
		try {
			audioStream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		gainControl = null;
		audioFMT = null;
		clip = null;
		audioFile = null;
		audioStream = null;
		setCurrentFrame((long) 0);
	}
	
	/* Plays audio file and updates duration field */
	public static void play() {
		clip.start();
		playing = true;
		InterfaceWindow.getVisualizer().play();
		if (playing)
			PlayerPanel.getBtnPlay().setText("Pause");
		PlayerPanel.updateDuration();
		
	}
	
	/* Pauses audio file */
	public static void pause() {
		if (playing) {
			clip.stop();
			playing = false;
			InterfaceWindow.getVisualizer().pause();
			if (!playing)
				PlayerPanel.getBtnPlay().setText("Play");
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
	
	/* Sets position to beginning of scrub bar */
	public static void resetPosition() {
		setPosition(0);
		PlayerPanel.getscrubSlider().setValue(0);
	}
	
	
	/* Jumps to different time section based of scrub bar value */
	public static void scrub() {
		newPosition = PlayerPanel.getscrubSlider().getValue();
		//System.out.println(PlayerPanel.getscrubSlider().getValue());
		InterfaceWindow.getVisualizer().skip((PlayerPanel.getscrubSlider().getValue()));
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
		int newPosition = PlayerPanel.getscrubSlider().getValue();
		if (newPosition != (int) getPosition())
			return true;
		return false;
	}
	
	public static void changeVolume() {
		volPosition = PlayerPanel.getVolSlider().getValue();
		setVolume(volPosition);
	}
	
	/* Jumps to specified section of audio file */
	public static void jump(long c) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		if (c > 0 && c < clip.getMicrosecondLength()) {
			clip.stop();
			clip.close();
			resetAudioStream();
			setCurrentFrame(c);
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
	
	/* Converts seconds to minutes and seconds string */
	public static String convertToMinSeconds (int seconds) {
		int minutes = seconds / 60;
		seconds = seconds % 60;
		
		return getDigits(minutes) + " : " + getDigits(seconds);
	}
	
	/* Helper method for digit conversion */
	public static String getDigits (int n) {
		if (n == 0)
			return "00";
		if (n / 10 == 0)
			return "0" + n;
		return String.valueOf(n);
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
	public static void setVolume(float decibels) {
		gainControl.setValue(decibels);
	}
	
	/* Retrieves volume level */
	public static float getVolume() {
		return gainControl.getValue();
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

	public static Long getCurrentFrame() {
		return currentFrame;
	}

	public static void setCurrentFrame(Long currentFrame) {
		Playback.currentFrame = currentFrame;
	}

}
