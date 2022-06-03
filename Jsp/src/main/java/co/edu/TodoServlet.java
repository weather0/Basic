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

//    public TodoServlet() {
//    }
	TodoDAO dao = new TodoDAO();
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");

		Gson gson = new GsonBuilder().create();
		
		List<Todolist> list = dao.todoshow();
		resp.getWriter().print(gson.toJson(list));
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		
		
		Todolist todo = new Todolist();
		todo.setContent(req.getParameter("content"));
		dao.todoInsert(todo);
		// {"retCode":"success"}
//		resp.getWriter().print("{\"retCode\":\"success\"}");
		

	}

}
