package PacLoop;

import java.util.Scanner;

public class AccountExample {
	public static void main(String[] args) {
		Scanner sn = new Scanner(System.in);
		int bal = 0;
		boolean run = true;
		
		while(run) {
			System.out.println("========================");
			System.out.println("1.입금 2.출금 3.조회 4.종료");
			System.out.println("========================");
			System.out.print("메뉴선택>>> "); // println = print("\n")
			int menu = sn.nextInt();
			if(menu == 1) {
				// 입금기능
				System.out.print("입금액> ");
				int money = sn.nextInt();
				bal += money;
				System.out.println("잔액은 " + bal + "입니다");
				
			}else if (menu ==2) {
				// 출금기능
				System.out.print("출금액> ");
				int money = sn.nextInt();
				if (money <= bal) {
					bal -= money;
					System.out.println("잔액은 " + bal + "입니다");
				}else {
					System.out.println("잔액이 부족합니다");
					
				}
					
					
				
			}else if (menu ==3) {
				// 조회기능
				System.out.println("잔액은 " + bal + "입니다");
				
				
			}else if (menu ==4) {
				// 종료
				run = false;
				
				
			}else {
				System.out.println("잘못된 메뉴 선택 입니다");
			}
			
		}
		System.out.println("프로그램 종료");
		
		
		
		
		
		

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//────────────────────────────────────────────
	}

}
