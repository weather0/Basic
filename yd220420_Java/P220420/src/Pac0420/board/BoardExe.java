package Pac0420.board;

import java.util.Scanner;

public class BoardExe {
	public static void main(String[] args) {
		BoardService service = new BoardApp();

		Scanner scn = new Scanner(System.in);

		while (true) {
			System.out.println("1.글등록  2.글수정  3.글삭제  4.글상세조회(글번호)  5.전체목록 6.종료");
			int menu = scn.nextInt();
			if (menu == BoardService.ADD) {
				service.addBoard();

			} else if (menu == BoardService.MOD) {
				service.modBoard();

			} else if (menu == BoardService.DEL) {
				service.remBoard();

			} else if (menu == BoardService.SEARCH) {
				service.findBoard();

			} else if (menu == BoardService.LIST) {
				service.listBoard();

			} else if (menu == BoardService.EXIT) {
				System.out.println("프로그램 종료");
				break;
			}

		}

	}

}
