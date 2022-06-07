package co.micol.prj.web;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 모든 요청을 받아서 처리하는 곳
 */
@WebServlet("*.do") // .do는 관례적으로 붙임
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private HashMap<String, Command> map = new HashMap<String, Command>();

	public FrontController() {
		super();
	}

	/**
	 * 요청과 처리 명령어를 연결하는 부분(Command Mapper)
	 */
	public void init(ServletConfig config) throws ServletException {
		map.put("/test.do", new TestCommand()); // map.put(키,밸류)
//		System.out.println("map.put: " + map.put("/test.do", new TestCommand()));
		
		// 이제 이 부분에 요청 커맨드를 계속 적으면 됨
		map.put("/memberList.do", new MemberListCommand());

	}

	/**
	 * 여기서 들어온 요청을 분석하고 명령을 실행해서 결과를 돌려보내주는 것
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String uri = request.getRequestURI();
//		System.out.println("uri: " + uri); // uri = /P220607/*.do
		String contextPath = request.getContextPath(); // 루트디렉토리 정보
//		System.out.println("contextPath: "+ contextPath); // contextPath = /P220607
		String page = uri.substring(contextPath.length()); // 실제 요청 명령을 받음
//		System.out.println("page: "+ page); // page = /*.do

		Command command = map.get(page); // 실행할 명령객체를 찾음. map.get(키)를 던져서 벨류를 얻음
//		System.out.println("command: " + command); // command: null
		String viewPage = command.exec(request, response); // 명령을 실행하고 결과를 돌려받음
		
		if (!viewPage.endsWith(".do") && !viewPage.equals(null)) { // viewResolve
			// 마지막에 .do가 포함돼있지 않고 null이 아니면
			viewPage = "/WEB-INF/jsp/" + viewPage + ".jsp";
//			System.out.println("viewPage: " + viewPage);
		}

		// 결과 페이지를 돌려준다
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
//		System.out.println("dispatcher: " + dispatcher);
		dispatcher.forward(request, response);

	}

}
