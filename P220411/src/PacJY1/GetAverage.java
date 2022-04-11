package PacJY1;

import java.util.Scanner;

public class GetAverage {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		
		// 정수 연산 → 정수. 10,15,15 → 40/3.0(더블타입) → 13.333
	
		int age = 10;
		String myName = "홍길동";
		
		int num1, num2, num3;
		num1 = 10;
		num2 = 15;
		num3 = 15;
		
		
		double avg = (num1 + num2 + num3)/3.0;
		
//		System.out.printf("이름은 %3s이고 평균은 %.2f이고 나이는 %2d", myName, avg, age );
		//.2f 소수점2째자리,  d는 정수타입 (교재)
		System.out.printf("입력한 세 정수는 %3d, %3d, %3d 이고 평균은 %.5f"
				, num1, num2, num3, avg);
		
	}

}
