package co.micol.student.dao;

// DAO
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DataSource { // singleton 싱글톤 클래스 패턴
	private static DataSource dataSource = new DataSource(); // 자신을 객체로

	private DataSource() {
	}; // 자기 자신을 외부에서 실행 못 하도록 private으로

	private Connection conn;
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String user = "micol";
	private String password = "1234";

	public static DataSource getInstance() {
		return dataSource;
	}

	public Connection getConnection() {
		dbconfiguration();
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("DB 연결 성공!!!");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("DB 연결 실패");
		}

		return conn;
	}

	private void dbconfiguration() {
		Properties properties = new Properties();
		String resource = getClass().getResource("/db.properties").getPath();
		try {
			properties.load(new FileReader(resource));
			driver = properties.getProperty("driver");
			url = properties.getProperty("url");
			user = properties.getProperty("user");
			password = properties.getProperty("password");
		} catch (Exception e) { // 파일 못 찾을 경우
			e.printStackTrace();
		}

	}

}
