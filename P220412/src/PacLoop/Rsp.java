package PacLoop;

import java.util.Scanner;

public class Rsp {
	public static void main(String[] args) {
		
//		임의의 값 범위 (1 ~ 6:주사위의 면의 갯수)
//		---------------------------------------------
//		임의의 값 범위 (1: 가위, 2: 바위, 3: 보)
//		사용자 입력값  : 가위(1), 바위(2), 보(3)
//
//		가위바위보 게임
//		이기는 경우 : 1=2, 2=.3, 3=1의 경우
//		이외의 경우는 짐
//		가위(1) → you win. you lose.
		Scanner sn = new Scanner(System.in);
		int com = (int) (Math.random()*3+1);
		
		while(true) {
			System.out.println("번호를 입력하세요 1:가위 2:바위 3:보");
			int user = sn.nextInt();
			if (user == com ) {
				System.out.println("무승부!");
				if (com == 3) {
					System.out.println("승리!");
//				}else if(){
					
					System.out.println("(당신)가위:(봇)보. 승리!");
				}
				
				
				
			}
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		

		
		
		
//────────────────────────────────────────────
	}

}
