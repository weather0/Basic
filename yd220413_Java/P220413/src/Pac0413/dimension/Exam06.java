package Pac0413.dimension;

import java.util.Scanner;

public class Exam06 {
	public static void main(String[] args) {
		boolean run = true;
		int studentNum = 0;
		int[] scores = null;
		Scanner sn = new Scanner(System.in);

		while (run) {
			System.out.println("----------------------------------------------");
			System.out.println("1.학생수 | 2.점수입력 | 3.점수리스트 | 4.분석 | 5.종료");
			System.out.println("----------------------------------------------");
			System.out.print("선택> ");

			int selectNo = Integer.parseInt(sn.nextLine());

			if (selectNo == 1) {
				System.out.print("학생수> ");
				studentNum = sn.nextInt();
				scores = new int[studentNum];
				sn.nextLine(); // 이거 안 넣으면 오류 뜸. Int를 다시 Line으로 돌려주는 작업

			} else if (selectNo == 2) {
				if (scores == null) {
					System.out.println("학생수를 입력하세요");

				} else {
					for (int i = 0; i < scores.length; i++) {
						System.out.print("scores[" + i + "]> ");
						scores[i] = sn.nextInt();
						sn.nextLine();
					}
				}

			} else if (selectNo == 3) {
				if (scores == null) {
					System.out.println("학생수와 점수를 입력하세요");

				} else {
					for (int i = 0; i < scores.length; i++) {
						System.out.println("scores[" + i + "]> " + scores[i]);
					}
				}

			} else if (selectNo == 4) {
				if (scores == null) {
					System.out.println("학생수와 점수를 입력해야해요");

				} else {
					int maxVal, sum;
					maxVal = sum = 0;
					for (int i = 0; i < scores.length; i++) {
						sum += scores[i];
						if (scores[i] > maxVal) {
							maxVal = scores[i];
						}
					}
					System.out.println("최고 점수: " + maxVal);
					System.out.println("평균 점수: " + sum / studentNum);
				}

			} else if (selectNo == 5) {
				run = false;

			}

		}

		System.out.println("프로그램 종료");

		
		
		
		
		
		
		
	}

}
