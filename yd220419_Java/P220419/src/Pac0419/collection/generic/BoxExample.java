package Pac0419.collection.generic;

import java.util.ArrayList;

import Pac0419.collection.Friend;

class Orange { // extends Object가 생략되어있음(기본)
	
}
// <제네릭타입>: 클래스 작성시점이 아닌 사용하는 시점에 <타입>을 정함
public class BoxExample {
	public static void main(String[] args) {
		Box<String> box = new Box<String>();
		box.setField("Orange");
		String result = box.getField(); // 형변환
		
		Box<Integer> box2 = new Box<Integer>();
		box2.setField(10);
		Integer result2 = box2.getField();
		
		ArrayList<String> list = new ArrayList<String>();
		list.add("홍길동");
		
		ArrayList<Friend> friends = new ArrayList<Friend>();
		friends.add(new Friend("박길동", "010-2222", null));
		
		
//		Orange orange = (Orange) box.getField();
		
		System.out.println("end of prog");
		
		
	}

}
