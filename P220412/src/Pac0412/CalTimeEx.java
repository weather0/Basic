package Pac0412;

import java.util.Scanner;

public class CalTimeEx {
	public static void main(String[] args) {
		Scanner sn = new Scanner(System.in);
		System.out.println("초를 입력하세요.");
		int time = sn.nextInt();
		// 시,분,초 → 5000초. 5000/(60*60) → ?시간
		// 5000%(60*60) → 1400/60 → ?분
		// 초 → ?초
		
		int hs, mins, secs;
		hs=time/(60*60);
		time=time%(60*60); //연산결과의 나머지를 time에 대입
		mins=time/60;
		time=time%60;
		secs=time; // 나머지 값을 secs에 대입
		
		System.out.printf("%2d시 %2d분 %2d초", hs, mins, secs);
		
		
		
	}

}
