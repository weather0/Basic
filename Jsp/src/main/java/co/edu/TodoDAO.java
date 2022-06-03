package co.edu;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TodoDAO extends DAO {

	public List<Todolist> todoshow() {
		connect();
		List<Todolist> list = new ArrayList<Todolist>();
		String sql = "SELECT * FROM TODOLIST ORDER BY 1";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				Todolist todo = new Todolist();
				todo.setTodoId(rs.getInt("todo_id"));
				todo.setContent(rs.getString("content"));
				todo.setChecked(rs.getInt("checked"));
				list.add(todo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}
//	
//	
//	
//	
//	
	public void todoInsert(Todolist todo) {
		connect();
		String sql = "insert into todolist values(todo_seq.nextval, ?, 0)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, todo.getContent());
			psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}
	
	

}
