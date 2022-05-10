package co.jyk.exam0510;

import java.util.Scanner;

import co.jyk.exam0510.service.BookService;
import co.jyk.exam0510.service.BookServiceImpl;
import co.jyk.exam0510.vo.BookInfo;

public class App {
	
	public static void main(String[] args) {
		BookService dao = new BookServiceImpl();
		BookInfo book = new BookInfo();
		Scanner scn = new Scanner(System.in);

		while (true) {
			System.out.println("==============================================================================");
			System.out.println("1.전체조회 | 2.단건조회 | 3.내용검색 | 4.대여가능 | 5.책대여 | 6.책반납 | 7.책등록 | 9.종료");
			System.out.println("==============================================================================");
			System.out.print("메뉴선택>");
			int num = Integer.parseInt(scn.nextLine());
			switch (num) {
			case 1:
				dao.booklist().toString();
				break;
			case 2:
				System.out.print("책제목>");
				String bookone =scn.nextLine();
				book.setBookname(bookone);
				dao.bookone(book).toString();
				break;
			case 3:
				System.out.print("검색내용>");
				String bookjava =scn.nextLine();
				dao.bookjava(bookjava).toString();
				break;
			case 4:
				dao.bookrent().toString();
				break;
			case 5:
				break;
			case 6:
				break;
			case 7:
				System.out.println("책을 등록합니다");
				System.out.print("제목 입력>");
				book.setBookname(scn.nextLine());
				System.out.print("작가 입력>");
				book.setAuthor(scn.nextLine());
				System.out.println("내용 입력>");
				book.setContent(scn.nextLine());
				int n = dao.bookIn(book);
				if (n != 0) {
					System.out.println("입력 완료");
				} else {
					System.out.println("입력 실패");
				}
				break;
			case 8:
				break;
			case 9:
				break;
			}
			break;

		}

		
		
		
		
	}

}
