package Pac0414.statics;

public class Person {
	final String nation = "Korea";
	final String ssn;
	static final double PI = 3.14; 
	// 이 클래스소속(static), 일단선언하면변경불가(final) = 상수(어디든 공통으로 사용하겠다)(대문자국룰)
	// 이클립스 기본 Math클래스에 PI가 이미 탑재되어있음
	String name;

	public Person(String ssn, String name) {
		this.ssn = ssn;
		this.name = name;

	}
}
