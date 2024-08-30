package co.edu;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@WebServlet("/TodoServlet")
public class TodoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	TodoDAO dao = new TodoDAO();

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 웹(.html .jsp 등) → [req: 1.전달방식:GET,POST / 2.내용(body):매개변수=값 / 3.값형식:문자열,json,xml등]
		//   → 서블릿(여기서 jdbc DAO든 뭐든 원하는 작업수행. 이때 받아온 req값형식에 따라 적절히 파싱해야 함)
		//     → [resp: 1.전달값형식:json,xml등] → 웹
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");

		Gson gson = new GsonBuilder().create();

		List<Todolist> list = dao.todoshow();
		resp.getWriter().print(gson.toJson(list));
		// list를 Json형식으로 변환해서 웹의 스크립트로 넘겨줌. (xml형식 등 다른 방식도 가능)
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");

		if (req.getParameter("cmd").equals("insert")) {
			Todolist todo = new Todolist();
			todo.setContent(req.getParameter("content")); // html에서 받아온 content를 할당시키고
			dao.todoInsert(todo); // DAO에 던져주고 DB입력한 뒤, 선물로 todoId값을 받아온다.
			Gson gson = new GsonBuilder().create();
			resp.getWriter().print(gson.toJson(todo)); // todoId 실고 다시 html로 떠남
		}
		if (req.getParameter("cmd").equals("delete")) {
			int todoId = Integer.parseInt(req.getParameter("todoId"));
			dao.todoDelete(todoId);

		}
		if (req.getParameter("cmd").equals("modify")) {
			Todolist todo = new Todolist();
			todo.setChecked(Integer.parseInt(req.getParameter("checked")));
			todo.setTodoId(Integer.parseInt(req.getParameter("todoId")));
			dao.todoModify(todo);
		}

		// JSON형식 넘어가는지 테스트
//		resp.getWriter().print("{\"retCode\":\"success\"}");

	}

}
