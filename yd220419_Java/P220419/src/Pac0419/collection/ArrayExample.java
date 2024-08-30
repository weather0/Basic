package Pac0419.collection;

import java.util.ArrayList;

// 배열 vs 컬렉션
// 배열 활용한 프로그램, 컬렉션을 활용한 프로그램
// 인터페이스 선언 => 구현하는 클래스
public class ArrayExample {
	// 배열은 크기 변경 불가 . 아래 코드 예외뜸
	public static void main(String[] args) {
		Friend[] friendAry = new Friend[10];
		friendAry[0] = new Friend("홍길동", "010-1111", null);
		friendAry[1] = new Friend("김길동", "010-2222", null);
		friendAry[9] = null;
		for(int i =0; i < friendAry.length; i++) {
			if (friendAry[i] != null) {
				System.out.println(friendAry[i].toString());
			}
		}
		
		// 컬렉션 활용. 인터페이스 => List:컬렉션 => ArrayList
		ArrayList friendList = new ArrayList();
		friendList.add(new Friend("박찬호", "010-3333", null)); // 추가
		friendList.add(new Friend("손흥민", "010-4444", null));
		friendList.remove(0); // 삭제
		
		for (int i = 0; i < friendList.size(); i++) {
			System.out.println(friendList.get(i));
		}
		
		Friend f2 = (Friend) friendList.get(0); // get(인덱스) => Object 형변환
				
		
		
		
		
		
		
		
		
	}

}
