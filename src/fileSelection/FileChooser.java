package fileSelection;

import java.io.File;

import javax.sound.sampled.LineUnavailableException;
import javax.swing.JFileChooser;

import fftHandler.FFTHandler;
import mainInterface.AnalyticsDisplay;
import mainInterface.FileMenu;
import mainInterface.PlayerPanel;
import playback.Playback;
//import javax.swing.filechooser.*;

public class FileChooser {

	/************* Fields *******************/

	private static File currentFile = null;
	private static boolean selecting = false;
	private static int returnValue = -1;

	/************* Methods ******************/

	/* Maintains whether user is actively selecting file */
	public static void setSelecting(boolean select) {
		selecting = select;
	}

	/* Updates fields after selecting a new file */
	public static void updateFields() {
		if (!selecting) {
			FileMenu.updateFields();
		}
	}

	/*********** Getter Methods ***********/

	public static File getCurrrentFile() {
		return currentFile;
	}

	public static String getFileName() {
		return currentFile.getName();
	}

	public static String getFilePath() {
		return currentFile.getPath();
	}

	/***************** Main Method *********************/

	/* Opens file chooser and initializes playback */
	public static void main(String[] args) {
		final JFileChooser fc = new JFileChooser();
		setSelecting(true);
		returnValue = fc.showOpenDialog(fc);
		setSelecting(false);
		if (returnValue == JFileChooser.APPROVE_OPTION) {
			if (FileManager.isFileLoaded())
				FileManager.removeCurrentStream();
			currentFile = fc.getSelectedFile();
			setSelecting(false);
			updateFields();
			Playback.setAudioFile(FileChooser.getCurrrentFile());
			FFTHandler.setAudioFile(FileChooser.getCurrrentFile());
			try {
				Playback.createAudioStream();
			} catch (LineUnavailableException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Playback.isSupportedAudioFile();
			PlayerPanel.enablePlayButton();
			AnalyticsDisplay.enableAnalytics();
			FileManager.setFileLoaded(true);
		}
	}


}
