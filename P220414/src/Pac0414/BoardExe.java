package Pac0414;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BoardExe {
	public static void main(String[] args) {
		Scanner sn = new Scanner(System.in);

		// BoardList에 정의해놓은 필드와 메소드를 활용해서 기능.
		BoardList boardList = new BoardList();
		boardList.init(5); // 배열의 크기지정

		while (true) {
			System.out.println("1.추가 2.수정 3.목록 4.삭제 5.한건조회 6.작성자조회 9.종료");
			System.out.print("선택>> ");
			int menu = -1;
			try { // 예외 떴을 때 종료하지말고 안내해주는 기능
				menu = sn.nextInt();
			} catch(InputMismatchException e) { // Input뭐시깽이 예외시
				System.out.println("잘못된 처리를 시도했습니다");
			}
			sn.nextLine();

			if (menu == 1) {
				System.out.print("글번호입력>> ");
				int bNo = sn.nextInt();
				sn.nextLine();
				System.out.print("제목입력>> ");
				String bTitle = sn.nextLine();
				System.out.print("내용입력>> ");
				String bContent = sn.nextLine();
				System.out.print("작성자입력>> ");
				String bWriter = sn.nextLine();
				Board newBod = new Board(bNo, bTitle, bContent, bWriter); // 생성자 호출
				int chk = boardList.addBoard(newBod);
				if (chk == 0) {
					System.out.println("정상입력되었습니다");
				} else if(chk == -1){
					System.out.println("저장공간이 없습니다");
				} else if(chk == 1) {
					System.out.println("이미 있는 번호 입니다");
				}

			} else if (menu == 2) {
				System.out.print("수정할 글번호>>> ");
				int bNo = sn.nextInt();
				sn.nextLine();
				System.out.print("변경할 제목 입력>>> ");
				String title = sn.nextLine();
				System.out.print("변경할 내용 입력>>> ");
				String content = sn.nextLine();
				Board cBoard = new Board(bNo, title, content, null);

				if (boardList.modifyBoard(cBoard)) {
					System.out.println("정상수정완료");
				} else {
					System.out.println("수정 실패");
				}

			} else if (menu == 3) {
				Board[] boards = boardList.boardListmokrok();
				System.out.println("게시글번호 제목         내용         사용자   조회수");
				System.out.println("=============================================");
				for (Board board : boards) {
					if (board != null) {
						board.getInfo();
					}

				}

			} else if (menu == 4) {
				System.out.print("삭제할 글번호>>> ");
				int bNo = sn.nextInt();
				sn.nextLine();

				if (boardList.removeBoard(bNo)) {
					System.out.println("삭제되었음");
				} else {
					System.out.println("삭제 실패");
				}

			} else if (menu == 5) {
				System.out.print("조회할 글번호 >>> ");
				int bNo = sn.nextInt();
				sn.nextLine();

				Board getBoard = boardList.searchBoard(bNo);
				if (getBoard == null) {
					System.out.println("조회결과 없음");
				} else {

					getBoard.getDetailInfo();
				}

				
				
				
				
				
				
			} else if (menu == 6) {
				System.out.print("작성자 입력>>");
				String sWriter = sn.nextLine();
				Board[] writerList = boardList.getWriterList(sWriter);
				
				System.out.println("게시글번호 제목         내용         사용자   조회수");
				System.out.println("=============================================");
				
				for (Board board : writerList) {
					if (board != null) {
						board.getInfo();
					}

				}
				
				
				
				
				
				
				
				
				
			
			} else if (menu == 9) {
				System.out.println("프로그램을 종료합니다");
				break;
			} else {
				System.out.println("정확한 메뉴를 선택하시오");

			}

		}
		System.out.println("end of prog");

		
		
	}

}
