package options;

public class Options {
	
	/****************** Fields ***********************/

	private static int visStyle = 0;
	private static int timeRes = 0;
	private static int freqRes = 0;
	private static boolean analyticsOn = true;
	private static boolean visualizerOn = true;
	
	/****************** Methods *********************/
	
	/* Loads settings from file on startup */
	public static void load() {
		
	}
	
	/******************** Getters and Setters for each field ***********************/

	public static int getVisStyle() {
		return visStyle;
	}

	public static void setVisStyle(int visStyle) {
		Options.visStyle = visStyle;
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

	public static boolean isAnalyticsOn() {
		return analyticsOn;
	}

	public static void setAnalyticsOn(boolean analyticsOn) {
		Options.analyticsOn = analyticsOn;
	}

	public static boolean isVisualizerOn() {
		return visualizerOn;
	}

	public static void setVisualizerOn(boolean visualizerOn) {
		Options.visualizerOn = visualizerOn;
	}

}
