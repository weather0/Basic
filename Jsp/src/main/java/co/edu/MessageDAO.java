package co.edu;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MessageDAO extends DAO {
	
	public Message getMessage(String user, String pass) {
		Message msg = new Message();
		msg.setMsgId(100);
		msg.setContent("반갑습니다.");
		msg.setWriter("admin");
		msg.setCreateDate("2022-06-01");
		return msg;
	}
	
	//
	// GET방식
	public List<Message> messageList() {
		connect();
		List<Message> list = new ArrayList<Message>();
		String sql = "SELECT * FROM MESSAGES WHERE CREATE_DATE >= SYSDATE -(1/24/60)*30 ORDER BY 1";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				Message msg = new Message();
				msg.setMsgId(rs.getInt("msg_id"));
				msg.setContent(rs.getString("content"));
				msg.setWriter(rs.getString("writer"));
				msg.setCreateDate(rs.getString("create_date"));
				list.add(msg);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}

	
	// POST방식
	public void insertMessage(Message msg) {
		connect();
		String sql = "INSERT INTO MESSAGES VALUES(MESS_SEQ.NEXTVAL, ?, ?, SYSDATE)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, msg.getContent());
			psmt.setString(2, msg.getWriter());
			psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

}
