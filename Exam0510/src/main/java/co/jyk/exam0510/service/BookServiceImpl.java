package co.jyk.exam0510.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import co.jyk.exam0510.dao.DataSource;
import co.jyk.exam0510.vo.BookInfo;

public class BookServiceImpl implements BookService {
	private DataSource dataSource = DataSource.getInstance();
	private Connection conn = dataSource.getConnection();
	private PreparedStatement psmt;
	private ResultSet rs;
	BookInfo book = new BookInfo();

	// 전체조회
	@Override
	public List<BookInfo> booklist() {
		List<BookInfo> booklist = new ArrayList<BookInfo>();
		BookInfo vo;
		String sql = "SELECT * FROM BOOKS";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				vo = new BookInfo();
				vo.setBookname(rs.getString("bookname"));
				vo.setAuthor(rs.getString("author"));
				vo.setContent(rs.getString("content"));
				vo.setRent(rs.getString("rent"));
				booklist.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return booklist;

	}

	// 단건조회
	@Override
	public BookInfo bookone(BookInfo vo) {
		String sql = "SELECT * FROM BOOKS WHERE BOOKNAME = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getBookname());
			rs = psmt.executeQuery();
			if (rs.next()) {
				book.setBookname(rs.getString("bookname"));
				book.setAuthor(rs.getString("author"));
				book.setContent(rs.getString("content"));
				book.setRent(rs.getString("rent"));
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}return book;
	}
	
	//자바 책 찾기
	@Override
	public List<BookInfo> bookjava(String vo) {
		List<BookInfo> booklist = new ArrayList<BookInfo>();
		BookInfo vo2;
		String sql = "SELECT * FROM BOOKS WHERE CONTENT LIKE ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, "%"+vo+"%"); //주의!!!! 위에 쿼리문에 %이걸 다는 게 아니라 여기에서 문자열 조합
			rs = psmt.executeQuery();
			while (rs.next()) {
				vo2 = new BookInfo();
				vo2.setBookname(rs.getString("bookname"));
				vo2.setAuthor(rs.getString("author"));
				vo2.setContent(rs.getString("content"));
				vo2.setRent(rs.getString("rent"));
				booklist.add(vo2);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}return booklist;
	}
	
	

	//책등록
	@Override
	public int bookIn(BookInfo vo) {
		int n = 0;
		String sql = "INSERT INTO BOOKS VALUES(?,?,?,DEFAULT)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getBookname());
			psmt.setString(2, vo.getAuthor());
			psmt.setString(3, vo.getContent());
			n = psmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return n;

	}

	//대여가능조회
	@Override
	public List<BookInfo> bookrent() {
		List<BookInfo> booklist = new ArrayList<BookInfo>();
		BookInfo vo3;
		String sql = "SELECT * FROM BOOKS WHERE RENT = '대여가능'";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				vo3 = new BookInfo();
				vo3.setBookname(rs.getString("bookname"));
				vo3.setAuthor(rs.getString("author"));
				vo3.setContent(rs.getString("content"));
				vo3.setRent(rs.getString("rent"));
				booklist.add(vo3);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return booklist;
	}

	

}
