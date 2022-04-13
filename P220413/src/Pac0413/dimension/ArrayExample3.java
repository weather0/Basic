package Pac0413.dimension;

import java.util.Scanner;

public class ArrayExample3 {
	public static void main(String[] args) {
		// 변수 vs 배열

		// 변수활용
		Scanner sn = new Scanner(System.in);
		int num1, num2, num3;
		System.out.println("첫번째 값 입력>>>");
		num1 = sn.nextInt();
		System.out.println("첫번째 값 입력>>>");
		num2 = sn.nextInt();
		System.out.println("첫번째 값 입력>>>");
		num3 = sn.nextInt();
//
//		// 제일 작은 수 ~ 제일 큰 수의 순으로 출력 (경우의 수가 너무 많다..)
//		if (num1 > num2) {
//			if (num2 > num3) {
//				System.out.println(num3 + num2 + num1);
//			} else if (num1 > num3) {
//				System.out.println(num2 + num3 + num1);
//
//			}
//		}a

		// 배열활용

		int[] intAry = { num1, num2, num3 };

		for (int j = 0; j < intAry.length - 1; j++) {

			for (int i = 0; i < intAry.length; i++) {
				if (intAry[i] > intAry[i + 1]) {
					int temp = intAry[i]; // 앞 뒤 값 서로 바꾸기
					intAry[i] = intAry[i + 1]; //
					intAry[i + 1] = intAry[i]; //

				}
			}

			System.out.println(intAry[0] + ", " + intAry[1] + "," + intAry[2]);
		}

	}

}
