package Pac0418.friend;

import java.util.Scanner;

public class FriendList {
	public static void main(String[] args) {
		
		Friend[] friends = new Friend[10];
//		friends[0] = new UnivFriend("홍길동", "010-111-2222", "대구대", "경영학");
//		friends[1] = new ComFriend("박찬호", "010-444-3333", "네이버", "인사과");
//		friends[2] = new Friend("손흥민", "010-555-7677");

		
		Scanner scn = new Scanner(System.in);
		
		
		while(true) {
			System.out.println("1.친구등록  2.리스트  3.조회(이름)  4.종료");
			int menu = scn.nextInt();
			
			if (menu == 1) {
				Friend friend = null; // 섭메뉴마다 배열 따로 안만드려고(코드라인줄이기 아름다움)
				System.out.println("1.학생  2.회사원  3.백수");
				int submenu = scn.nextInt();				
				System.out.print("등록할 친구 이름을 입력하세요>> ");
				scn.nextLine();
				String name = scn.nextLine();
				System.out.print("전화번호를 입력>> ");
				String phone = scn.nextLine();
				if (submenu == 1) {
					System.out.print("학교를 입력>> ");
					String univ = scn.nextLine();
					System.out.print("학과를 입력>> ");
					String major = scn.nextLine();
					friend = new UnivFriend(name, phone, univ, major);
//					for (int i =0; i < friends.length; i++) {
//						if (friends[i] == null) {
//							friends[i] = new UnivFriend(name, phone, univ, major);
//							break;
//						}
//					}
//					System.out.println("이름: "+name+" | 전화번호: "+phone+" | 학교: "+univ+" | 전공: "+major);
//					System.out.println("결과 정상등록되었음");
				}
				if (submenu == 2) {
					System.out.print("회사를 입력>> ");
					String company = scn.nextLine();
					System.out.print("부서를 입력>> ");
					String depart = scn.nextLine();
					friend = new ComFriend(name, phone, company, depart);
//					for (int i =0; i < friends.length; i++) {
//						if (friends[i] == null) {
//							friends[i] = new ComFriend(name, phone, company, depart);
//							break;
//						}
//					}
//					System.out.println("이름: "+name+" | 전화번호: "+phone+" | 학교: "+company+" | 전공: "+depart);
//					System.out.println("결과 정상등록되었음");
				} 
				if (submenu == 3) {
					friend = new Friend(name, phone);
				}
					
						
				for (int i =0; i < friends.length; i++) {
					if (friends[i] == null) {
						friends[i] = friend;
						break;
					}
				}

				
				
				
			} else if (menu == 2 ) {				
				System.out.println("친구 목록");
				System.out.println("===================================");
				System.out.println("이름     번호     학교(회사)   학과(부서)");
				for (int i =0; i < friends.length; i++) {
					if(friends[i] != null) {
//					System.out.println(friends[i].getName()+ "  " + friends[i].getPhone() + "  ");
						System.out.println(friends[i].showData());
					}
				}
				
				
				
				
				
				
			} else if (menu == 3 ) {
				System.out.print("조회할 친구 이름>> ");
				scn.nextLine();
			
				
				
				
			} else if (menu == 4 ) {
				System.out.println("프로그램 종료");
				break;
			}
				
			
		}
		
		

		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
