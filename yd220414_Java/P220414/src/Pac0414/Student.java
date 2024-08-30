package Pac0414;

public class Student {
	// 클래스의 3요소
	// 1.필드
	String name;
	String studNo;
	int age;
	double height;

	
	
// ─────────────────────────────────────────────────────	
	
	// 2.생성자(Constructor) -> 인스턴스를 만들어줄 때 처리할 기능 정의 public(주의!반환유형이 아님) 생성자명(매개변수)
	public Student() { // 기본생성자(매개변수없는거): 필수임. 없으면 에러남(단, 아예 아무 임의생성자도 없을 경우엔 생략 가능)
		System.out.println("Student() 생성자가 호출되었습니다");		
	}
	
	public Student(String nm, String sn) {
		name = nm;
		studNo = sn;
	} // 생성자는 필드의 값을 지정할 때 주로 이용
	
	public Student(String nm, String sn, int ag) {
		name = nm;
		studNo = sn;
		age = ag;
		
	} 	// 이클립스꿀기능: 우클릭-소스-Generate Constructor using Feild로 한방에 생성자 생성.
	    public Student(String name, String studNo, int age, double height) {
		this.name = name;
		this.studNo = studNo;
		this.age = age;
		this.height = height;
	} // this.의 기능: 필드명과 변수명이 같으면 기본적으로 변수가 선순위라 꼬이는데, 이걸 필드>변수 순으로 자동 설정해줌. 즉 this.필드=변수

	    
	    
// ─────────────────────────────────────────────────────
	
	// 3.메서드: 반환유형(type) 메소드명(매개변수) {}
	void study() { // void: 반환유형이 없음. (예: int 타입이면 int 써주면 됨)
		System.out.println(name + "가 공부를 합니다");
	}

	void eat() {
		System.out.println(name + "가 식사를 합니다");
	}

	void showInfo() {
		System.out.println("이름은 " + name + ", 학생번호는 " + studNo + ", 키는 " + height + " 이고 나이는 " + age + "입니다");

		
		
		
	}

}
