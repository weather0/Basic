package PacCondition;

import java.util.Scanner;

public class IfExample3 {
	public static void main(String[] args) {
		// 중첩 구문
		// 90점이상이면 A, 80점B, 70점C, F
		// A중에 95점이상이면 A쁠
		System.out.println("점수 입력");

		Scanner sn = new Scanner(System.in);
		int score = sn.nextInt();

		if (score >= 90) {
			if (score >= 95) {
				System.out.println("A+학점.");
			} else {
				System.out.println("A학점.");
			}
		} else if (score >= 80) {
			if (score >= 85) {
				System.out.println("B+학점.");
			} else {
				System.out.println("B학점.");
			}
		} else if (score >= 70) {
			if (score >= 75) {
				System.out.println("C+학점.");
			} else {
				System.out.println("C학점.");
			}
		} else {
			System.out.println("F학점.");
		}

	}

}
