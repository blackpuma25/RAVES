package fileSelection;

import fileSelection.FileChooser;
import fftHandler.FFTHandler;
import playback.Playback;

/* Responsible for maintaining and loading only one file at a time */
public class FileManager {
	
	private static boolean FileLoaded = false;
	
	public static boolean isFileLoaded() {
		return FileLoaded;
	}
	
	public static void setFileLoaded(boolean loaded) {
		FileLoaded = loaded;
	}
	
	public static void removeCurrentStream() {
		Playback.closeSession();
		Playback.resetPosition();
		FileChooser.updateFields();
		FFTHandler.resetData();
		FileLoaded = false;
		
		//add visualizer code to quit visualizer
		
	}

}
