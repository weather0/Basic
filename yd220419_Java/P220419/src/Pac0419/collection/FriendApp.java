package Pac0419.collection;

import java.util.ArrayList;
import java.util.Scanner;

// 친구목록 저장하기 위한 App
// 추가, 수정, 삭제, 조회
// 1)배열 2)컬렉션 <= 인터페이스(FriendService) 구현
public class FriendApp {
	public static void main(String[] args) {
		// 추가, 수정, 삭제, 조회 => main메소드는 컨트롤 역할
//		FriendService service = new FriendServiceArray(); // 배열방식
		FriendService service = new FriendServiceList(); // 컬렉션 방식

		Scanner scn = new Scanner(System.in);

		while (true) {
			System.out.println("1.추가 2.수정 3.삭제 4.조회 5.남자 6.여자");
			int menu = scn.nextInt();
			scn.nextLine();
			if (menu == FriendService.ADD) {
				System.out.print("추가할 친구 이름>> ");
				String name = scn.nextLine();
				System.out.print("추가할 친구 연락처>> ");
				String call = scn.nextLine();
				System.out.print("추가할 친구 성별 ex)남자/여자 >> ");
				String gender = scn.nextLine();
				Gender gen = Gender.MEN; // 새 인스턴스 초기값
				if (gender.startsWith("남")) {
					gen = Gender.MEN;
				} else if (gender.startsWith("여")) {
					gen = Gender.WOMEN;
				}
				Friend friend = new Friend(name, call, gen);
				service.addFriend(friend);

			} else if (menu == FriendService.MOD) {
				System.out.print("수정할 친구 이름>> ");
				String name = scn.nextLine();
				System.out.print("수정할 친구 연락처>> ");
				String call = scn.nextLine();
				System.out.print("수정할 친구 성별 ex)남자/여자 >> ");
				String gender = scn.nextLine();
				Gender gen = Gender.MEN; // 새 인스턴스 초기값
				if (gender.startsWith("남")) {
					gen = Gender.MEN;
				} else if (gender.startsWith("여")) {
					gen = Gender.WOMEN;
				}
				Friend friend = new Friend(name, call, gen);
				service.modFriend(friend);

			} else if (menu == FriendService.DEL) {
				System.out.print("삭제할 친구이름>> ");
				String name = scn.nextLine();
				service.remFriend(name);

			} else if (menu == FriendService.SEARCH) {
				System.out.print("조회할 친구이름>> ");
				String name = scn.nextLine();
				Friend searchfriend = service.findFriend(name);
				System.out.println(searchfriend.toString());

			} else if (menu == FriendService.FIND_MEN) {
				ArrayList<Friend> list = service.findGender(Gender.MEN);
				for (Friend friend : list) {
					System.out.println(friend.toString());
				}

			} else if (menu == FriendService.FIND_WOMEN) {
				ArrayList<Friend> list = service.findGender(Gender.WOMEN);
				for (Friend friend : list) {
					System.out.println(friend.toString());
				}

			} else {
				System.out.println("프로그램 종료");
				break;
			}

		}

	}
}
