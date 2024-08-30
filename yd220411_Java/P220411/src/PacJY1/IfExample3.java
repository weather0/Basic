package PacJY1;

import java.util.Scanner;

public class IfExample3 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int num1, num2, result;
		
		System.out.println("첫번째 정수를 입력하세요.");
		num1 = scn.nextInt(); // 사용자입력값을 읽고 int형 반환
		System.out.println("두번째 정수를 입력하세요.");
		num2 = scn.nextInt();		
		
		
		if(num1 > num2) {
			result = num1 - num2;
		} else {
			result = num2 - num1;
		}
		System.out.println("큰 수와 작은 수의 차이 " + result);
		
	}

}
