package app;

import org.springframework.stereotype.Component;

//@Component
public class LgTV implements TV {
	public void poweron() {
		System.out.println("LG 전원 켬");
	}
}
