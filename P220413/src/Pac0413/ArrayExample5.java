package Pac0413;

import java.util.Scanner;

public class ArrayExample5 {
	public static void main(String[] args) {
		Scanner sn = new Scanner(System.in);

		int[] scores = new int[5];

		// min때문에 필연적으로 배열의 값을 먼저 정의할 수밖에 없음
		for (int i = 0; i < scores.length; i++) {
			System.out.println("학생점수를 입력하세요 >>>> ");
			scores[i] = sn.nextInt();
		}
		

		int maxs = 0;
		int mins = 0;
		mins = scores[0]; // 이줄 빼고 min초기값 9999로 빠꼼하게 할 수도 있지만 일반화가 안돼서 위에 for문으로 먼저 배열의 값을 정의함

		for (int i = 0; i < scores.length; i++) {
			if (maxs < scores[i]) {
				maxs = scores[i];
			}
			if (mins > scores[i]) {
				mins = scores[i];
			}

		}

		// 학생중에 최고점, 최저점.
		System.out.println("최고점은 " + maxs + ", 최저점은 " + mins);

		
		
		
		
//────────────────────────────────────────────
	}

}
