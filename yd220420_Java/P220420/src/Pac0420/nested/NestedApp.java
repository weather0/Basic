package Pac0420.nested;

import java.util.Scanner;

class Friend {
	String name;
	String phone;
	int age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Friend [name=" + name + ", phone=" + phone + ", age=" + age + "]";
	}

}

// 중첩클래스, 중첩인터페이스
public class NestedApp {
	static Scanner scn = new Scanner(System.in);
	static Friend[] friends = new Friend[10];

	// 중첩인터페이스
	interface FriendService {
		int ADD = 1;
		int MOD = 2;
		int LIST = 3;

		void add();

		void modify();

		void list();
	}

	// 중첩클래스
	static class FriendApp implements FriendService {

		@Override
		public void add() {
			// 배열의 비어있는 위치에 저장
			System.out.println("이름>> ");
			String name = scn.next();
			System.out.println("연락처>> ");
			String phone = scn.next();
			System.out.println("나이>> ");
			int age = scn.nextInt();

			Friend friend = new Friend();
			friend.setName(name);
			friend.setPhone(phone);
			friend.setAge(age);

			for (int i = 0; i < friends.length; i++) {
				if (friends[i] == null) {
					friends[i] = friend;
					break;
				}
			}

		}

		@Override
		public void modify() {
			System.out.println("이름>> ");
			String name = scn.next();
			for (int i = 0; i < friends.length; i++) {
				// ##작성중
			}
			
			

		}

		@Override
		public void list() {
			// 배령의 저장되어 있는 값을 출력
			for (int i = 0; i < friends.length; i++) {
				if(friends[i] != null) {
					System.out.println(friends[i].toString());					
				} else {
					break;
				}
			}
			
		}

	}

	public static void main(String[] args) {
		FriendApp app = new FriendApp();

		while (true) {
			System.out.println("1.추가 2.수정 3.목록");
			int num = scn.nextInt();
			if (num == FriendService.ADD) {
				app.add();
			} else if (num == FriendService.MOD) {
				app.modify();
			} else if (num == FriendService.LIST) {
				app.list();
			} else {
				System.out.println("프로그램 종료");
			}
		}

	}

}