package Pac0414;

public class TVExample {
	public static void main(String[] args) {
		int num = 10;
		String str = "Hello";
		
		Television tv = new Television(); // new: 만들겠다(메모리에 저장). Television(): 인스턴스
		tv.company = "삼성";
		tv.color = "검은색";
		tv.price = 300000;
		tv.model = "30Inch";
		tv.turnOn();
		tv.changeChannel(10);
		tv.turnOff();
		
		Television tv1 = new Television(); // tv != tv1
		tv1.company = "삼성";
		tv1.color = "검은색";
		tv1.price = 300000;
		tv1.model = "30Inch";
		
		System.out.println(tv); // @34ce8af7: 주소값(16진수)
		System.out.println(tv1); // @b684286
		System.out.println(tv == tv1); // 내용이 같아도 주소값이 달라서 false
		
		
// ─────────────────────────────────────────────────────		
		
		Student stud1 = new Student(); // 기본생성자 (Ctrl클릭으로 확인 가능)
		stud1.name = "홍길동";
		stud1.studNo = "22-1234567";
		stud1.age = 20;
		stud1.height = 174.5;
		
		Student stud2 = new Student(); // 기본생성자
		stud2.name = "우영원";
		stud2.studNo = "19-9934567";
		stud2.age = 24;
		stud2.height = 162.7;
		
		Student stud3 = new Student("황하경", "23-11111");
		stud3.age = 25;
		stud3.height = 155.2;
		
		Student stud4 = new Student("홍길동", "24235", 45);
		
		
		stud1.study();
		stud2.study();
		
	
		stud1.showInfo();
		stud2.showInfo();
		stud3.showInfo();
		stud4.showInfo();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
