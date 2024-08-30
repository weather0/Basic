package Pac0413.dimension;

import java.util.Scanner;

public class StudentExample {
	public static void main(String[] args) {
		// 다른 타입끼리 한 배열에 넣기
		// 학생이름, 점수 --> names, scores
		Student s1 = new Student(); // Student라는 임의의 타입을 생성(Student.java라는 새로운 클래스)
		s1.studName = "홍길동";
		s1.score = 80;
		s1.age = 30;

		Student s2 = new Student();
		s2.studName = "박찬호";
		s2.score = 75;
		s2.age = 50;

		Student s3 = new Student();
		s3.studName = "손흥민";
		s3.score = 82;
		s3.age = 23;

		Student[] students = { s1, s2, s3 };
		int searchAge = 23;


		Scanner sn = new Scanner(System.in);
		System.out.println("학생이름 입력하시오>>");
		String searchName = sn.nextLine();

		for (int i = 0; i < students.length; i++) {
			if (students[i].studName.equals(searchName)) {
				System.out.println(students[i].score);
			}

		}
		
	
		System.out.println("end of prog.");

	}

}
