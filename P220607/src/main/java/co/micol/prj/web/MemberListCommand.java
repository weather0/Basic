package co.micol.prj.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.prj.student.service.StudentService;
import co.micol.prj.student.serviceImpl.StudentServiceImpl;
import co.micol.prj.student.vo.StudentVO;

public class MemberListCommand implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		StudentService dao = new StudentServiceImpl();
		List<StudentVO> students = new ArrayList<StudentVO>();
		students = dao.studentSelectList();
		request.setAttribute("students", students);
		return "member/member";
	}

}
