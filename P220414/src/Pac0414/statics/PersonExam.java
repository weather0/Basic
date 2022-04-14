package Pac0414.statics;

public class PersonExam {
	public static void main(String[] args) {
		Person p1 = new Person("123456-23243", "홍길동");
		p1.name = "김길동";
//		p1.ssn = "223123-123123"; // final로 선언되어 이렇게 값 변경 할 수 없음. 오류남
		
		Person p2 = new Person("342361-32423", "박찬호");
		
	}

}
