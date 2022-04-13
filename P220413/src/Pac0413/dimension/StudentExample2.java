package Pac0413.dimension;

import java.util.Scanner;

public class StudentExample2 {
	public static void main(String[] args) {
		Scanner sn = new Scanner(System.in);
		Student s1 = new Student(); // null이 아닌 빈공간을 s1에 정의
		
		System.out.println("학생이름 점수 나이"); // 홍길동 80 20
		s1.studName = sn.next();
		s1.score = Integer.parseInt(sn.next()); // 1 != "1"
		s1.age = Integer.parseInt(sn.next());
		
		Student[] students = {new Student(), new Student(), new Student()};
		students[0].studName = sn.next();
		students[0].score = Integer.parseInt(sn.next());
		students[0].age = Integer.parseInt(sn.next());
		
		// 조회하고 싶은 이름 입력..
		// 해당이름 홍길동은 20살이고 점수는 80점입니다.
		
		
		
		
		
		
		
		
	
	}

}
