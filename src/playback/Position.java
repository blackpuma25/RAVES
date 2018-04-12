package playback;

import mainInterface.PlayerPanel;

public class Position extends Thread {
	
	public static void maintainPosition() {
		System.out.println("Starting this");
		do {
			if (Playback.isPlaying()) {
				PlayerPanel.getSlider().setValue((int) Playback.getPosition());
				PlayerPanel.getTextField().setText(String.valueOf((int) Playback.getPosition()));
				Playback.setPosition(Playback.getClip().getMicrosecondPosition());
				System.out.println("Playing");
			}
		} while(true);
		
		
	}
	
	@Override
	public void run() {
		//maintainPosition();
		System.out.println("Starting this");
		do {
			PlayerPanel.getSlider().setValue((int) Playback.getPosition());
			PlayerPanel.getTextField().setText(String.valueOf((int) Playback.getPosition()));
			if (Playback.isPlaying()) {
				Playback.setPosition(Playback.getClip().getMicrosecondPosition());
			}
		} while(true);
		
	}

}
