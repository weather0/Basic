package co.micol.prj;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/First") // 1)어노테이션방식 또는 2)web.xml 추가 방식
// url(주소줄 전쳬): http://localhost/P220607/First
// uri(도메인제외한 나머지): P220607/First
// ContextPath: P220607
// 요청명: First
// (예) www.naver.com의 경우 URI: index.html(.jsp등), ContexPath: /(그냥root)

public class First extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public First() {
        super();
    }

    // 호출 할 때마다 매번 req, resp 객체가 만들어 짐
    
    // GET방식: url에 요청 파라미터가 다 보임 → 보안 취약
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.print("<h1>Hello</h1>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		doGet(request, response);
	}

}
