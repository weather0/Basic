package co.micol.prj.menu;

import java.util.Scanner;

import co.micol.prj.game.Lotto;
import co.micol.prj.game.Mabang;
import co.micol.prj.game.Tetris;

public class Menu {
	private Scanner scn = new Scanner(System.in);
	
	private Lotto lotto = new Lotto();
	private Mabang mabang = new Mabang();
	private Tetris tetris = new Tetris();

	private void title() {
		System.out.println("=======================");
		System.out.println("====== 게 임 모 음 ======");
		System.out.println("====== 1. 로   또 ======");
		System.out.println("====== 2. 마 방 진 ======");
		System.out.println("====== 3. 테트리스 ======");
		System.out.println("====== 4. 종   료 ======");
		System.out.println("=======================");
		System.out.print("원하는 게임을 선택하세요>> ");
	}

	
	private void mainMenu() {
		boolean b = true;
		do {
			title();
			int num = scn.nextInt();
			switch(num) {
			case 1: // 로또
				lotto.run();
				break;
			case 2: // 마방진
				mabang.run();
				break;
			case 3: // 테트리스
				tetris.run();
				break;
			case 4:
				b = false;
				scn.close();
				break;
			}
			
		} while(b);
	}
	
	public void run() {
		mainMenu();
	}
	
}
