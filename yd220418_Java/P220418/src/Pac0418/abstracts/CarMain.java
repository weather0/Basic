package Pac0418.abstracts;

import java.util.Scanner;

public class CarMain {
	public static void main(String[] args) {
		// 1.시동켜기 2.출발 3.운행 4.멈추기 5.시동끄기
		Scanner scn = new Scanner(System.in);

//		Sonata car = new Sonata();
//		Avante car = new Avante();
// 추상클래스 용도 장점: 위에 처럼 만들면 번거로우니깐. 공통된 필드와 메소드명 통일		
		Car car = null;
		car = new Sonata();
		car = new Avante();
		

		while (true) {
			System.out.println("1.시동켜기 2.출발 3.운행 4.멈추기 5.시동끄기");
			int menu = scn.nextInt();
			if (menu == 1) {
				car.turnOn();
			} else if (menu == 2) {
				car.start();
			} else if (menu == 3) {
				car.run();
			} else if (menu == 4) {
				car.stop();
			} else if (menu == 5) {
				car.turnOff();
			} else {
				break;
			}

		}

	}

}
