package options;

public class Options {
	
	/****************** Fields ***********************/
	
	/* Option values initialized to default values */
	private static int timeRes = 1;
	private static int freqRes = 5; // may need to change this to number of frequency bands
	private static boolean visualizerOn = true;
	
	/* Option assignment bindings */
	private static float[] timeIntervals = new float[] //time resolution 
			{(float) .0333, (float) 0.05, (float) .0666, (float) 0.75, 
					(float) 0.1, (float) 0.3, (float) 0.5}; //we can change these values as needed
	private static int[] windowSizes = new int[] //frequency resolution
			{32, 64, 128, 256, 512, 1024, 32768};
	
	/****************** Methods *********************/
	
	/* Gets options defined by user */
	public static void updateOptions() {
		//set values to integer values from options menu panel
	}
	
	/******************** Getters and Setters for each field ***********************/

	public static float[] getTimeIntervals() {
		return timeIntervals;
	}

	public static int[] getWindowSizes() {
		return windowSizes;
	}
	
	public static int getTimeRes() {
		return timeRes;
	}

	public static void setTimeRes(int timeRes) {
		Options.timeRes = timeRes;
	}

	public static int getFreqRes() {
		return freqRes;
	}

	public static void setFreqRes(int freqRes) {
		Options.freqRes = freqRes;
	}

	public static boolean isVisualizerOn() {
		return visualizerOn;
	}

	public static void setVisualizerOn(boolean visualizerOn) {
		Options.visualizerOn = visualizerOn;
	}

}
