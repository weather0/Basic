package co.micol.prj.menuTest;

import java.util.Scanner;

public class MainMenu {
	private Scanner scn = new Scanner(System.in);

	private void mainMenu() {
		boolean b = true;
		do {
			menuTitle();
			System.out.println("원하는 작업을 선택하시오");
			int num = scn.nextInt();
			switch(num) {
			case 1:
				subTitle();
				break;
			case 2:
				b = false;
				break;
			}
		} while (b);
		scn.close();

	}

	private void menuTitle() {
		System.out.println("=================");
		System.out.println("===== 1.입력 =====");
		System.out.println("===== 2.종료 =====");
		System.out.println("=================");
	}

	private void subTitle() {
		System.out.println("=================");
		System.out.println("===== 이  름 =====");
		System.out.println("===== 1.복귀 =====");
		System.out.println("=================");
		int ll = scn.nextInt();

	}
	
	public void run() { // 정보은폐. 위에메뉴들은 private으로 지정하여 App클래스의 main메소드에서는 보이지 않는다
		mainMenu();
	}

}
