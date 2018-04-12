package playback;

import mainInterface.PlayerPanel;

public class Position extends Thread {
	
	@Override
	public void run() {
		System.out.println("Starting position thread");
		do {
			PlayerPanel.getSlider().setValue((int) Playback.getPosition());
			PlayerPanel.getTextField().setText(Playback.convertToMinSeconds((int) Playback.getPosition() ));
			if (Playback.isPlaying()) {
				Playback.setPosition(Playback.getClip().getMicrosecondPosition());
			}
		} while(true);
		
	}

}
