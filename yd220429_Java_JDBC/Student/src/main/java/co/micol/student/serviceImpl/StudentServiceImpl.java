package co.micol.student.serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.micol.student.dao.DataSource;
import co.micol.student.dto.StudentVO;
import co.micol.student.service.StudentService;

// 메서드(함수) 유형: procedure형(void), function형(리턴값있는거)
public class StudentServiceImpl implements StudentService {
	private DataSource dataSource = DataSource.getInstance(); // DAO instance 생성
	private Connection conn = dataSource.getConnection(); // connection
	private PreparedStatement psmt; // sql 명령실행
	private ResultSet rs; // select 결과를 담음

	@Override
	public List<StudentVO> selectListStudent() {
		// 전체 학생 목록 가져오기
		List<StudentVO> students = new ArrayList<StudentVO>();
		StudentVO student;
		String sql = "SELECT * FROM STUDENT"; // 대문자화: 컨+쉬+X
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery(); // sql을 실행하고 결과를 담음
			while (rs.next()) {
				student = new StudentVO(); // 읽을 데이터가 있다면 초기화
				student.setStudentID(rs.getString("studentid")); // "칼럼명"
				student.setName(rs.getString("name"));
				student.setBirthday(rs.getDate("birthday"));
				student.setAddress(rs.getString("address"));
				student.setMajor(rs.getString("major"));
				student.setTel(rs.getString("tel"));
				students.add(student); // 리스트 추가
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return students;
	}

	@Override
	public StudentVO selectStudent(StudentVO student) {
		// 한 명 조회
		StudentVO vo = new StudentVO();
		String sql = "SELECT * FROM STUDENT WHERE STUDENTID = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, student.getStudentID()); // 1: 1번 물음표
			rs = psmt.executeQuery();
			if (rs.next()) {
				vo.setStudentID(rs.getString("studentid"));
				vo.setName(rs.getString("name"));
				vo.setBirthday(rs.getDate("birthday"));
				vo.setAddress(rs.getString("address"));
				vo.setMajor(rs.getString("major"));
				vo.setTel(rs.getString("tel"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vo;
	}

	@Override
	public int insertStudent(StudentVO student) {
		// 한 명 추가
		int n = 0;
		String sql = "INSERT INTO STUDENT VALUES(?,?,?,?,?,?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, student.getStudentID());
			psmt.setString(2, student.getName());
			psmt.setDate(3, student.getBirthday());
			psmt.setString(4, student.getAddress());
			psmt.setString(5, student.getMajor());
			psmt.setString(6, student.getTel());
			n = psmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n;
	}

	@Override
	public int updateStudent(StudentVO student) {
		// 한 명 정보 업데이트(PK제외)
		int n = 0;
		String sql = "UPDATE STUDENT SET MAJOR = ?, ADDRESS = ?," + " TEL=? WHERE STUDENTID = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, student.getMajor());
			psmt.setString(2, student.getAddress());
			psmt.setString(3, student.getTel());
			psmt.setString(4, student.getStudentID());
			n = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n;
	}

	@Override
	public int deletetStudent(StudentVO student) {
		// 한 명 삭제
		int n = 0;
		String sql = "DELETE FROM STUDENT WHERE STUDENTID = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, student.getStudentID());
			n = psmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n;
	}

}
