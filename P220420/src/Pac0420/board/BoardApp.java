package Pac0420.board;

import java.util.ArrayList;
import java.util.Scanner;

public class BoardApp implements BoardService {
	ArrayList<Board> boards = new ArrayList<Board>();
	Scanner scn = new Scanner(System.in);

	@Override
	public void addBoard() {
		System.out.println("글 번호>> ");
		int boardNo = scn.nextInt();
		System.out.println("글 제목>> ");
		String title = scn.next();
		System.out.println("글 내용>> ");
		String content = scn.next();
		System.out.println("작성자>> ");
		String writer = scn.next();
		System.out.println("작성일시>> ");
		String date = scn.next();
		boards.add(new Board(boardNo, title, content, writer, date));
	}

	@Override
	public void modBoard() {
		System.out.println("글번호를 입력>> ");
		int num = Integer.parseInt(scn.next());
		for (int i = 0; i < boards.size(); i++) {
			if (boards.get(i).getBoardNo() == num) {
				System.out.println("글 제목>> ");
				String title = scn.next();
				System.out.println("글 내용>> ");
				String content = scn.next();
				boards.get(i).setTitle(title);
				boards.get(i).setTitle(content);

			}

		}

	}

	@Override
	public void remBoard() {
		System.out.println("글번호를 입력>> ");
		int num = Integer.parseInt(scn.next());
		for (int i = 0; i < boards.size(); i++) {
			if (boards.get(i).getBoardNo() == num) {
				boards.remove(i);
			}
		}

	}

	@Override
	public void findBoard() {
		System.out.println("글번호를 입력>> ");
		int num = Integer.parseInt(scn.next());
		for (int i = 0; i < boards.size(); i++) {
			if (boards.get(i).getBoardNo() == num) {
				System.out.println(boards.get(i).toString());

			}
		}

	}

	@Override
	public void listBoard() {
//		if(!boards.isEmpty()) {
//			for(Board i : boards) {
//				System.out.println(i);
//				
//			}
//			
//		}

		for (int i = 0; i < boards.size(); i++) {
			System.out.println(boards.get(i).toString());

		}

	}

}
