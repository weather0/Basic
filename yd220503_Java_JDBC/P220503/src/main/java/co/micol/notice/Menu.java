package co.micol.notice;

import java.util.Scanner;

import co.micol.program.Notice;

public class Menu {
	private Scanner scn = new Scanner(System.in);
	Notice notice = new Notice();
	
	private void mainMenu() {
		boolean b = false;
		do {
			menuTitle();
			int num = scn.nextInt();
			switch(num) {
			case 1:
				studentTitle();
				studentMenu();
				break;
			case 2:
				noticeTitle();
				noticeMenu();
				break;
			case 3:
				System.out.println("감사합니다");
				b = true;
				break;
			}
		} while (!b);

	}

	private void menuTitle() {
		System.out.println("====================");
		System.out.println("===== 1.학생관리 =====");
		System.out.println("===== 2.공지사항 =====");
		System.out.println("===== 3.종   료 =====");
		System.out.println("====================");
		System.out.println("원하는 작업을 선택하세오");
	}

	private void studentTitle() {
		System.out.println("====================");
		System.out.println("=== 1.전체학생목록 ====");
		System.out.println("=== 2.학생정보조회 ====");
		System.out.println("=== 3.학생정보등록 ====");
		System.out.println("=== 4.학생정보수정 ====");
		System.out.println("=== 5.학생정보삭제 ====");
		System.out.println("=== 6.메인메뉴복귀 ====");
		System.out.println("====================");
		System.out.println("원하는 작업을 선택하세오");

	}
	
	private void studentMenu() {
		boolean b = false;
		do {
			int num = scn.nextInt();
			switch(num) {
			case 1: //목록
				break;
			case 2: //조회
				break;
			case 3: //등록
				break;
			case 4: //수정
				break;
			case 5: //삭제
				break;
			case 6:
				b = true;
				break;
			}
		} while (!b);

	}
	private void noticeTitle() {
		System.out.println("====================");
		System.out.println("=== 1.전체공지목록 ====");
		System.out.println("=== 2.공지사항조회 ====");
		System.out.println("=== 3.공지사항등록 ====");
		System.out.println("=== 4.공지사항수정 ====");
		System.out.println("=== 5.공지사항삭제 ====");
		System.out.println("=== 6.메인메뉴복귀 ====");
		System.out.println("====================");
		System.out.println("원하는 작업을 선택하세오");
		
	}
	private void noticeMenu() {
		boolean b = false;
		do {
			int num = scn.nextInt();
			switch(num) {
			case 1: //목록
				notice.noticeAll();
				noticeTitle();
				break;
			case 2: //조회
				notice.noticeOne();
				noticeTitle();
				break;
			case 3: //등록
				notice.noticeWrite();
				noticeTitle();
				break;
			case 4: //수정
				break;
			case 5: //삭제
				break;
			case 6:
				b = true;
				break;
			}
		} while (!b);

	}
	
	public void run() { // 정보은폐. 위에메뉴들은 private으로 지정하여 App클래스의 main메소드에서는 보이지 않는다
		mainMenu();
	}
	

}
