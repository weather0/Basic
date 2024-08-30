package Pac0421.api;

import java.util.HashSet;

class Member {
	String name;
	int age;

	Member(String name, int age) {
		this.name = name;
		this.age = age;

	}

	@Override
	public int hashCode() {
//		return super.hashCode();
//		return 100; // 이렇게 일정값을 뱉으면 members에 뭘 넣든 100으로 인식함.
		// 용도? 데이터가 많을 경우 그룹별로 나눌때 유용.
		return this.age;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Member) { // obj가 Member클래스의 인스턴스면
			Member member = (Member) obj;
			return this.name.equals(member.name);
		}
		return false;
//		return super.equals(obj);
		
	}

	@Override
	public String toString() {
		return "이름은 " + name + ", 나이는 " + age;
	}
}

public class ObjectExample {
	public static void main(String[] args) {

		// ArrayList : 인덱스 요소를 구분 => 중복된 저장
		// Set(집합) : 요소값으로 구분 => 중복된 값X

		HashSet<Integer> set = new HashSet<Integer>();
		set.add(100);
		set.add(200);
		set.add(300);
		set.add(200);

		System.out.println(set.size()); // 중복값을 제외 => 3
		
		HashSet<Member> members = new HashSet<Member>();
		members.add(new Member("홍길동",20));
		members.add(new Member("김길동",22));
		members.add(new Member("홍길동",20));
		
		System.out.println(members.size()); // 중복값을 제외 => 3
//		System.out.println("홍길동".hashCode());
		System.out.println(new Member("홍길동",20).toString());
		
		

	}

}
