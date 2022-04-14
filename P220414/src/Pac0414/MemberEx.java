package Pac0414;

import java.util.Scanner;

public class MemberEx {
	public static void main(String[] args) {
//		Member m1 = new Member("user1","사용자1","010-1111-2222",20);

////		m1.setAge(-25); // private 필드떄문에 접근 못함. 대신 메서드로 가져오겠다(아래)
//		
//		m1.setAge(-25);
//		m1.setId("user1");
//		
//	
//		System.out.println(m1.getAge());
//		m1.showInfo();
//		
//
//		

		Scanner sn = new Scanner(System.in);
		Member[] members = new Member[3];

		for (int i = 0; i < members.length; i++) {
			System.out.println("아이디 이름 연락처 나이 입력");
			String id = sn.next();
			String name = sn.next();
			String phone = sn.next();
			int age = sn.nextInt();
			Member newMember = new Member(id, name, phone, age);

			members[i] = newMember;

		}

		
		
		// 1.조회(이름), 2.변경(아이디,연락처), 3.조회(나이 큰 회원) 4.종료
		while(true) {
			System.out.println("1.조회(이름), 2.변경(아이디,연락처), 3.조회(나이 큰 회원) 4.종료");
			System.out.print("선택>> ");
			int menu = sn.nextInt();
			sn.nextLine(); // 메뉴와 엔터키 처리
			
			
			if (menu == 1) {
				System.out.print("조회할 이름 입력>> ");
				String sName = sn.nextLine();
				
				for (Member member : members) {
					if(member.getName().equals(sName)) {					
						member.showInfo();
					}
				}
				
			
			}else if (menu ==2) {
				System.out.print("변경할 아이디를 입력>> ");
			    String sID = sn.nextLine();
			    System.out.print("변경할 연락처를 입력>> ");
			    String sPhone = sn.nextLine();
			    for (Member member : members) {
					if(member.getContact().equals(sID)) {
						member.setContact(sPhone);
						break;
					}
				}
		
			    
			    

				
			}else if (menu ==3) {
				System.out.print("나이 입력>> ");
				int sAge = sn.nextInt();
				sn.nextLine();
				for (Member member : members) {
					if(member.getAge() > sAge) {					
						member.showInfo();
					}
				}
				
			}else if (menu ==4) {

				System.out.println("프로그램 종료합니다");
				break;
				
			}
			

			
		}

//		System.out.println("end of prog.");

		
		
		
		
		
		
		
		
		
		
	}

}
