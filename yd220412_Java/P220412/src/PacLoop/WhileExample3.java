package PacLoop;

import java.util.Scanner;

public class WhileExample3 {
	public static void main(String[] args) {
		// Math.random()의 생성범위 1 ~ 10 까지가 되도록
		// 사용자의 입력값을 담는 변수 uval

		// while 구문을 사용해서 임의의 값이랑 입력값이 같으면 종료
		// 사용자 값 랜덤값이랑 비교.. 입력한 랜덤이 크냐 작냐
		// 랜덤이 만들어준 값을 맞추는 게임. 같으면 빠져나옴

		int rand = (int) (Math.random() * 10) + 1;

		Scanner sn = new Scanner(System.in);
		
		while (true) {
			System.out.println("값을 입력해");
			int uval = sn.nextInt();
			if (uval == rand) {
				break;
			}
			if (uval > rand) {
				System.out.println("Down!");
			} else {
				System.out.println("Up!");
			}

		}
		System.out.println("정답!! 랜덤값은 " + rand);

		
		
		
		
		
//────────────────────────────────────────────
	}

}
