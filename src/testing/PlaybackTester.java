package testing;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;

import org.junit.jupiter.api.Test;

import playback.Playback;

class PlaybackTester {
	
	/************ Test Files *******************/
	public File nullFile = null;
	public File audioFile = new File("/Users/Batman/Documents/GitHub/RAVES/src/testing/A River Flows in You.wav"); //pathname may need to be edited for testing on personal machine;
	public File nonAudioFile = new File("/Users/Batman/Documents/GitHub/RAVES/src/testing/NonAudio.txt"); //^same

	
	@Test
	public void createAudioStream() throws Exception {		
		
		/* null test */
		Playback.setAudioFile(nullFile);
		String msg = null;
		try {
			Playback.createAudioStream();
		} catch (NullPointerException e) {
			msg = "File Not Found";
		}
		assertEquals("File Not Found", msg);
		
		/* audio file test */
		Playback.setAudioFile(audioFile);
		Playback.createAudioStream();
		assertEquals(false, Playback.getAudioStream().markSupported());
		assertEquals(44100, (int) Playback.getAudioFormat().getSampleRate());
		
		/* non-audio file test */
		Playback.setAudioFile(nonAudioFile);
		Playback.createAudioStream();
		
		
	}
	
	@Test
	public void isSupportedAudioFile() throws Exception {
		
		/* null test */
		Playback.setAudioFile(nullFile);
		String msg = null;
		try {
			Playback.isSupportedAudioFile();
		} catch (NullPointerException e) {
			msg = "File Not Found";
		}
		assertEquals(null, msg);
		
		/* audio file test */
		Playback.setAudioFile(audioFile);
		Playback.isSupportedAudioFile();
		assertEquals(false, Playback.getAudioStream().markSupported());
		assertEquals(44100, (int) Playback.getAudioFormat().getSampleRate());
		
		/* non-audio file test */
		Playback.setAudioFile(nonAudioFile);
		Playback.createAudioStream();
		
	}

}
