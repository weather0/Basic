package PacJY1;

import java.util.Scanner;

public class CtoF {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in); //키보드
		
		int fr;
		System.out.println("화씨입력");
		fr = scn.nextInt();
		
		double cel = 5/9.0*(fr-32);

		System.out.printf("화씨는 %2d, 섭씨는 %.1f", fr, cel);
		
	}

}
