package co.edu;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SampleServlet extends HttpServlet {
	// IOC: 개발자가 처리X HttpServlet이라는 컨테이너가 처리
	@Override
	public void init(ServletConfig config) throws ServletException {
		// 최초실행시에만 작동
		System.out.println("init 호출...");
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		resp.setCharacterEncoding("utf-8");

		System.out.println("service 호출...");

		if (req.getMethod().equals("GET")) {
			System.out.println("GET 요청입니다");
		} else if (req.getMethod().equals("POST")) {
			System.out.println("POST 요청입니다");
		}

		String name = req.getParameter("name"); // name=???&age=???
		String age = req.getParameter("age");
		PrintWriter out = resp.getWriter(); // getWriter()의 결과 타입이 PrintWriter
		out.print("<h3>요청파라미터: " + name + "</h3>");
		out.print("<h3>요청파라미터: " + age + "</h3>");
		out.close();

	}

	@Override
	public void destroy() {
		System.out.println("destroy 호출...");
	}

}
