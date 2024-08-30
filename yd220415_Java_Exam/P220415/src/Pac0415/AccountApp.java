package Pac0415;

import java.util.InputMismatchException;
import java.util.Scanner;

public class AccountApp {
	Scanner scn = new Scanner(System.in);
	
	
	Account[] accounts = new Account[100]; // 계좌정보 저장 배열
	
	
	
	
	public void execute() {
		while(true){
			System.out.println("-----------------------------------");
			System.out.println("1.계좌생성 2.입금 3.출금 4.목록조회 5.종료");
			System.out.println("-----------------------------------");
			
			System.out.print("선택>> ");
			int menu = -1;
			try {
				menu = scn.nextInt();
			} catch(InputMismatchException e) {
				System.out.println("잘못된 처리를 시도했습니다");
			}
			scn.nextLine();
			
			
			if (menu == 1){
				createAccount();
				
			} else if (menu == 2) {
				deposit();
				
			} else if (menu == 3) {
				withdraw();
				
			} else if (menu == 4) {
				accountList();
				
			} else if (menu == 5) {
				System.out.println("프로그램을 종료합니다");
				break;
			} else {
				System.out.println("정확한 메뉴를 선택하시오");
			}
		}
		System.out.println("end of prog.");
		
		
	}

	

	
	
	
	
	// 계좌생성 메서드
	public void createAccount() {
		System.out.print("계좌번호 입력>>");
		String accNum = scn.nextLine();
		System.out.print("계좌주 입력>>");
		String accName = scn.nextLine();
		System.out.print("초기입금액 입력>>");
		int balance = scn.nextInt();
		scn.nextLine();
		
		for (int i=0; i < accounts.length; i++) {
			if (accounts[i] == null) {
				accounts[i] = new Account(accNum, accName, balance);
				break;
			}
		}
		System.out.println("계좌번호: "+accNum);
		System.out.println("계좌주: "+accName);
		System.out.println("초기입금액: "+balance);
		System.out.println("결과: 계좌가 생성되었습니다");
		
		
		
//		int errorCase = -1; // 저장공간 없음
//		for (int i = 0; i < accounts.length; i++) {
//			if(accounts[i] != null && accounts[i].getAccNum() == account.getAccNum()) {
//				errorCase = 1; // 동일한 값이 있을 경우의 에러
//				break;
//			}
//			if (accounts[i] == null) {
//				accounts[i] = account;
//				errorCase = 0; // 정상처리
//				break;
//			}
//		}
		
		
		
		
	}
	
	
	
	
	
	// 입금처리 메서드
	public void deposit() {
		System.out.print("입금할 계좌번호를 입력하시오>> ");
		String accNum = scn.nextLine();	
		
		for (int i = 0; i < accounts.length; i++) {
			if(accounts[i].getAccNum().equals(accNum)) {
				System.out.print("입금액 입력>> ");
				int money = scn.nextInt();
				int nBal = accounts[i].getBalance();
				nBal += money;
				accounts[i].setBalance(nBal);
				System.out.println("입금 완료");
				break;				
			} else {
				System.out.println("잘못된 계좌입니다");
				break;
			}	
		}	
	}
	
	// 출금처리 메서드
	public void withdraw() {
		System.out.print("출금할 계좌번호를 입력하시오>> ");
		String accNum = scn.nextLine();	
		
		for (int i = 0; i < accounts.length; i++) {
			if(accounts[i].getAccNum().equals(accNum)) {
				System.out.print("출금액 입력>> ");
				int money = scn.nextInt();
				int nBal = accounts[i].getBalance();
				nBal -= money;
				accounts[i].setBalance(nBal);
				System.out.println("출금 완료");
				break;				
			} else {
				System.out.println("잘못된 계좌입니다");
				break;
			}
		}
	}
	
	// 전체목록 메서드
	public void accountList() {
		System.out.println("계좌목록");
		System.out.println("====================");
		for (int i =0; i < accounts.length; i++) {
			if(accounts[i] != null) {
			System.out.println(accounts[i].getAccNum()+ "  " + accounts[i].getAccName() + "  " + accounts[i].getBalance());
			}
		}

		}
	
}
