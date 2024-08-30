package co.test;

import java.util.InputMismatchException;
import java.util.Scanner;



// 종합.
// 클래스의 인스턴스와 배열의 활용.
// 친구의 소중한 정보를 관리하는 앱을 구현하세요.
// Exam4(친구정보) 클래스의 인스턴스를 저장, 수정, 삭제, 조회 처리.
public class Exam5 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);	
		Exam4[] books = new Exam4[100];

		while (true) {
			System.out.println("1.추가 2.수정(이름,연락처) 3.삭제(이름) 4.조회(이름) 5.종료");
			
			System.out.print("선택>> ");
			int menu = -1;
			try {
				menu = scn.nextInt();
			} catch(InputMismatchException e) {
				System.out.println("잘못된 처리를 시도했습니다");
			}
			scn.nextLine();
			
			
			if (menu == 1){
				System.out.print("친구 이름 입력>>");
				String name = scn.nextLine();
				System.out.print("친구 생일 입력>>");
				String birth = scn.nextLine();
				System.out.print("친구 연락처 입력>>");
				String call = scn.nextLine();
				
				
				for (int i=0; i < books.length; i++) {
					if (books[i] == null) {
						books[i] = new Exam4(name, birth, call);
						break;
					}
				}
				System.out.println("친구 이름: "+name);
				System.out.println("친구 생일: "+birth);
				System.out.println("친구 연락처: "+call);
				System.out.println("결과 정상등록되었음");
				
			
				
			} else if (menu == 2) {
	
				System.out.print("수정할 친구이름>>> ");
				String name2 = scn.nextLine();
				System.out.print("변경할 연락처>>> ");
				String call2 = scn.nextLine();
				
				
				for (int i = 0; i < books.length; i++) {
					if(books[i].getName().equals(name2)) {
						books[i].setCall(call2);
						break;				
					} else {
						System.out.println("정확한 친구 이름을 입력하세요");
						break;
					}	
				}	

				
				
			} else if (menu == 3) {
				System.out.print("삭제할 친구이름>>> ");
				String name3 = scn.nextLine();	
				
				for (int i = 0; i < books.length; i++) {
					if(books[i].getName().equals(name3)) {
						books[i] = null;
						break;				
					} else {
						System.out.println("정확한 친구 이름을 입력하세요");
						break;
					}	
					
				}
				
			} else if (menu == 4) {
				System.out.println("친구 목록");
				System.out.println("=============================");
				for (int i =0; i < books.length; i++) {
					if(books[i] != null) {
					System.out.println(books[i].getName()+ "  " + books[i].getBirth() + "  " + books[i].getCall());
					}
				}	
			
				
			} else if (menu == 5) {
				System.out.println("프로그램을 종료합니다");
				break;
			} else {
				System.out.println("정확한 메뉴를 선택하시오");
			}	
			
		}
		System.out.println("end of prog.");
		
		
		
		
		

		
		
		
	}
}
