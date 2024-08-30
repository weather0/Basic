package co.micol.study.comm;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//common: 공통사용 패키지

public interface Command {
	public String exec(HttpServletRequest request, HttpServletResponse response);

}
