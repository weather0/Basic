package PacLoop;

import java.util.Scanner;

public class WhileExample {
	public static void main(String[] args) {
		// 1~10 합
		int i = 1;
		int sum = 0;
		while(i <= 10) {
			sum += i;
			System.out.println(sum);
			i++;
			
			
		}
		System.out.println(sum);
		
		Scanner sn = new Scanner(System.in);
		boolean isTrue = true;
		sum = 0;
		while(isTrue) {
			System.out.println("숫자를 입력하세요. 종료하려면 -1입력");
			int temp = sn.nextInt();
			if (temp == -1) {
				isTrue = false; // break해도 됨
				continue;
			}
			sum += temp;
			
		}
		System.out.println("입력값의 합은 "+sum);
		
		

		
		
		
//────────────────────────────────────────────
	}

}
