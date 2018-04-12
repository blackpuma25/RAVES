package fileSelection;

import java.io.File;

import javax.sound.sampled.LineUnavailableException;
import javax.swing.JFileChooser;

import mainInterface.FileMenu;
import playback.Playback;
//import javax.swing.filechooser.*;

public class FileChooser {
	
	/************* Fields *******************/
	
	private static File currentFile = null;
	private static boolean selecting = false;
	
	/********** Constructor *****************/
	
	public static File getCurrrentFile() {
		return currentFile;
	}
	
	public static String getFileName() {
		return currentFile.getName();
	}
	
	public static String getFilePath() {
		return currentFile.getPath();
	}
	
	/* Maintains whether user is actively selecting file */
	public static void setSelecting(boolean select) {
		selecting = select;
	}
	
	public static void updateFields() {
		if (!selecting) {
			FileMenu.updateFields();
		}
	}
	
	
	public static void main(String[] args) {
		final JFileChooser fc = new JFileChooser();
		setSelecting(true);
		fc.showOpenDialog(fc);
		currentFile = fc.getSelectedFile();
		setSelecting(false);
		updateFields();
		Playback.setAudioFile(FileChooser.getCurrrentFile());
		try {
			Playback.createAudioStream();
		} catch (LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Playback.isSupportedAudioFile();
		
	}
	
	
}
