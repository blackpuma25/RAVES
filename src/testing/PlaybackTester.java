package testing;

import static org.junit.Assert.assertEquals;

import java.io.File;

import org.junit.jupiter.api.Test;

import playback.Playback;

class PlaybackTester {
	
	/************ Test Files *******************/
	public File nullFile = null;
	public File audioFile = new File("testing/A River Flows in You.wav");
	public File nonAudioFile = new File("testing/NonAudio.txt");

	
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
	
	@Test
	public void getDuration() throws Exception {
		
		/* null test */
		Playback.setAudioFile(nullFile);
		String msg = null;
		try {
			Playback.getDuration();
		} catch (NullPointerException e) {
			msg = "File Not Found";
		}
		assertEquals("File Not Found", msg);
		
		/* audio file test */
		Playback.setAudioFile(audioFile);
		Playback.createAudioStream();
		assertEquals((int) 281, (int) Playback.getDuration());
		
		/*non-audio file test */
		Playback.setAudioFile(nonAudioFile);
		Playback.createAudioStream();
		//Playback.getDuration();
		assertEquals(0, (int) Playback.getDuration());	
	}

}
