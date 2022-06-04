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
			while (rs.next()) {
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
	public Todolist todoInsert(Todolist todo) {
		connect();
		String sql = "INSERT INTO TODOLIST VALUES(?, ?, 0)";
		String seqSql = "SELECT TODO_SEQ.NEXTVAL FROM DUAL";
		int nextSeq = -1;
		try {
			psmt = conn.prepareStatement(seqSql);
			rs = psmt.executeQuery();
			if (rs.next()) {
				nextSeq = rs.getInt(1); // DUAL 1번열
			}

			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, nextSeq);
			psmt.setString(2, todo.getContent());
			int r = psmt.executeUpdate();
			System.out.println(r + "건 입력됨");

			todo.setTodoId(nextSeq);
			// 시퀀스를 통한 순번은 여기서 생성해서 바로 다시 웹으로 넘겨줘야 하기 때문에
			// void가 아닌 리턴값이 있는 메소드여야 하고
			// 또한 시퀀스 결과를 리턴물인 todo에다 실어줘야하니깐, 불가피하게 쿼리문을 나눌 수밖에 없다.
			// 만약 이 과정이 없이 그냥 void로 처리하고 별도로 웹에서는 그냥 순수 js로만 행을 생성한다면,
			// 일단 화면에 보여지는 결과는 동일하겠지만, 그 항목은 todoId 값이 없겠지.
			// 그럼 그 항목은 꼽표(삭제)기능이나 체크(할일완료)기능을 DB연동하여 수행할 수 없게 된다.(기본키 역할을 할 필드가 없음!)
			// 아 물론 그 상황에서도 웹에서 새로고침을 하면 어차피 불러오기 메서드로 인해 DB에서 항목을 불러오면서 ID값도 세팅되겠지만,
			// 사용자 입장에서는 Add를 클릭하고 매번 새로고침을 해줘야하는건 명백히 잘못 제작된 프로그램이다.
			// 물론 아예 첨부터 js단에서 시퀀스처럼 랜덤 id값을 생성하고 서블릿으로 요청해주면 좀더 편하겠지만,
			// 일단 지금 나는 그렇게 할 줄도 모르는데다, 그렇게 하나 이렇게 하나 전체적인 코딩복잡도는 비슷할 것으로 판단된다.
			// 따라서 지난 수업 때 emp서블릿 할 때 실습한 방식 그대로 이 프로젝트도 똑같이 진행하기로 한다.

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return todo;
	}

//	
//	
//	
//	
//	
	public void todoDelete(int todoId) {
		connect();
		String sql = "DELETE FROM TODOLIST WHERE TODO_ID = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, todoId);
			int r = psmt.executeUpdate();
			System.out.println(r + "건 삭제됨");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}

	}

//	
//	
//	
//	
//	
	public void todoModify(Todolist todo) {
		connect();
		String sql = "UPDATE TODOLIST SET CHECKED = ? WHERE TODO_ID = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, todo.getChecked());
			psmt.setInt(2, todo.getTodoId());
			int r = psmt.executeUpdate();
			System.out.println(r + "건 수정됨");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}

	}

}
