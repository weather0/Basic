package co.micol.prj.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Lotto {
	public void lotto() {
		Scanner scn = new Scanner(System.in);

		System.out.print("한 게임에 1000원입니다. 몇 게임을 하시겠습니까?(숫자입력)>> ");
		int gameTry = Integer.parseInt(scn.nextLine());
//		scn.nextLine();
//		Integer[][] gameSet = new Integer[gameTry][lottoNums];

		for (int g = 0; g < gameTry; g++) {
			List<Integer> lottoNums = new ArrayList<Integer>();

			for (int i = 0; i < 6; i++) {
				lottoNums.add((int) (Math.random() * 45) + 1);
				for (int j = 0; j < i; j++) {
					if (lottoNums.get(i) == lottoNums.get(j)) {
						lottoNums.remove(i);
						i--;
						break;
					}
				}
			}
			for (int h = 0; h < lottoNums.size(); h++) {
				System.out.print("[" + lottoNums.get(h) + "]");
			}
			System.out.println();

		}

	}

	public void run() {
		System.out.println("로또게임");
		lotto();
	}



}
