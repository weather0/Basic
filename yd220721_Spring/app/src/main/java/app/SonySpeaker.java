package app;

import org.springframework.stereotype.Component;

@Component
public class SonySpeaker implements Speaker {

	public void volumeUp() {
		System.out.println("sony up");
	}

	public void volumeDown() {
		System.out.println("sony down");
	}

}
