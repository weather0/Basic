package app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SamsungTV implements TV {
	
//	방법1: 여기에다 Autowired 쓰고
	@Autowired
	Speaker speaker;

	public void poweron() {
		System.out.println("Samsung 전원 켬");
		speaker.volumeUp();
	}

	
	
	
//	방법2: 생성자 또는 세터를 직접쓰기(번거로움)
//	@Autowired 
//	public SamsungTV(Speaker speaker) {
//		System.out.println("생성자방식");
//		this.speaker = speaker;
//	}
//
//	public SamsungTV() {
//	}
//
//	
//	
//	public Speaker getSpeaker() {
//		return speaker;
//	}
//
//	public void setSpeaker(Speaker speaker) {
//		System.out.println("setter방식");
//		this.speaker = speaker;
//	};
	
	

}
