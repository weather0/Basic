package PacCondition;

import java.util.Scanner;

public class IfExample2 {
	public static void main(String[] args) {
		System.out.println("숫자를 입력");

		Scanner sn = new Scanner(System.in);
		int num = sn.nextInt();

		if ((num % 2 == 0) && (num % 3 == 0)) {
			System.out.println(num + "는 2와 3의 공통배수");
		} else if ((num % 2) == 0) {
			System.out.println(num + "는 2의 배수");
		} else if ((num % 3) == 0) {
			System.out.println(num + "는 3의 배수");
		} else {
			System.out.println(num + "는 2와 3의 배수가 아님");
		}

	}

}
