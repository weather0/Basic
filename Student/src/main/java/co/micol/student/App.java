package co.micol.student;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import co.micol.student.dto.StudentVO;
import co.micol.student.service.StudentService;
import co.micol.student.serviceImpl.StudentServiceImpl;

public class App {
	public static void main(String[] args) {
		StudentService dao = new StudentServiceImpl();

		// 리스트 출력
		List<StudentVO> list = new ArrayList<StudentVO>();
		list = dao.selectListStudent();
		for (StudentVO vo : list) {
			vo.toString();
		}

		// 한 명 출력
//		System.out.println("======================");
//		StudentVO student = new StudentVO();
//		student.setStudentID("park@abc.com");
//		student = dao.selectStudent(student);
//		student.toString();

		// 한 명 입력
		// 자바에서 실행하면 자동커밋됨. 입력 완료 후 그대로 재실행 시도하면 PK유일성 위배로 입력 안 됨
//		StudentVO vo = new StudentVO();
//		vo.setStudentID("Kim@google.com");
//		vo.setName("김박사");
//		vo.setBirthday(Date.valueOf("1992-11-01"));
//		vo.setMajor("회계학");
//		vo.setAddress("대구시 중구 중앙대로");
//		vo.setTel("010-5123-2111");
//
//		int n = dao.insertStudent(vo);
//		if (n != 0) {
//			System.out.println("입력 완료");
//		} else {
//			System.out.println("입력 실패");
//		}

	}
}
