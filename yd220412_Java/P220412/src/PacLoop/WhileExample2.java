package PacLoop;

import java.util.Scanner;

public class WhileExample2 {
	public static void main(String[] args) {
		Scanner sn = new Scanner(System.in);
		boolean isTrue = true;
		int sum = 0;
		//200이 넘게 되면 반복문 빠져나오도록
		while(isTrue) {
			System.out.println("숫자입력");
			int tm = sn.nextInt();
			if (tm >= 200) {
				isTrue = false;				
			}
			sum += tm;
			
			
		}
		System.out.println("결과: " + sum);
		
		
		
		
		
		

		
		
//────────────────────────────────────────────
	}

}
