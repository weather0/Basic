package co.micol.study.student.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.study.comm.Command;
import co.micol.study.student.service.StudentService;
import co.micol.study.student.serviceImpl.StudentServiceImpl;
import co.micol.study.student.vo.StudentVO;

public class LoginForm implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {

		return "student/loginForm";
	}

}
