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

public class Playback {
	
	/*********************** Fields ********************************/
	private static File audioFile; //instance of audio file
	private static AudioInputStream audioStream; //instance of audio to read data
	private static AudioFormat audioFMT; //keeps audio formatting info (sample rate, number of channels, etc.)
	private static Clip clip = null;
	private static Long currentFrame;

	private static boolean playing = false;
	private static double position = 0;
	
	
	/************************ Methods 
	 * @throws LineUnavailableException *******************************/
	
	public static void setAudioFile(File file){
		audioFile = file;
		Position p = new Position();
		p.start();
		//updatePosition();
		//PlayerPanel.maintainPosition();
		//createAudioStream();
		//isSupportedAudioFile();
	}
	
	public static AudioInputStream getAudioStream() {
		return audioStream;
	}
	
	public static AudioFormat getAudioFormat() {
		return audioFMT;
	}
	
	/* Creates the audio stream and formating instance of audio file */
	public static void createAudioStream() throws LineUnavailableException {
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
		PlayerPanel.updateDuration();
		
	}
	
	public static boolean isPlaying() {
		return playing;
	}
	
	public static void pause() {
		if (playing) {
			clip.stop();
			playing = false;
		}
		
	}
	
	public static void updatePosition() {
		do {
			setPosition(clip.getMicrosecondPosition());
		} while (playing);
	}
	
	public void skip(float time) {
		
	}
	
	public static boolean isScrubbed() {
		int newPosition = PlayerPanel.getSlider().getValue();
		if (newPosition != (int) getPosition())
			return true;
		return false;
	}
	
	public static void scrub() {
		int newPosition = PlayerPanel.getSlider().getValue();
		System.out.println(newPosition);
		//int jumpDistance = 0;
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
	
	public static void jump(long c) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		if (c > 0 && c < clip.getMicrosecondLength()) 
		{
			clip.stop();
			clip.close();
			resetAudioStream();
			currentFrame = c;
			clip.setMicrosecondPosition(c * 1000000);
			clip.start();
		}
	}

	// Method to reset audio stream
	public static void resetAudioStream() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		audioStream = AudioSystem.getAudioInputStream(audioFile);
		clip.open(audioStream);
		clip.loop(Clip.LOOP_CONTINUOUSLY);
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

	public static double getPosition() {
		return position;
	}

	public static void setPosition(double position) {
		Playback.position = position * 0.000001;
	}
	
	public static Clip getClip() {
		return clip;
	}

}
