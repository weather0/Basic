package Pac0414;

public class Board {
	// 게시글번호, 제목, 내용, 작성자, 조회회수(조회할때마다 증가)
	private int boardNo;
	private String title;
	private String content;
	private String writer;
	private int searchCnt = 0;
	
	// 생성자
	public Board(int boardNo, String title, String content, String writer) {
		super();
		this.boardNo = boardNo;
		this.title = title;
		this.content = content;
		this.writer = writer;
	}

	
	// 메소드 get set
	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public int getSearchCnt() {
		return searchCnt;
	}

	public void setSearchCnt(int searchCnt) {
		this.searchCnt = searchCnt;
	}
	
	
	// 게시글번호 작성자 내용 작성자 조회수
	public void getInfo() {
		System.out.printf("%3d %-10s %-15s %-5s %2d\n", 
				this.boardNo, this.title, this.content, this.writer, this.searchCnt);
	}
	
	// 게시글번호           작성자
	// 제목                조회수
	// 내용
	public void getDetailInfo() {
		String info = "==================================================\n"+
	                  "게시글번호 : %2d                   작성자: %-5s\n"+
				      "제목 : %-10s                     조회수: %3d\n"+
	                  "내용 : %-30s\n" +
	                  "==================================================\n";
		
		System.out.printf(info,
				this.boardNo, this.writer, this.title, this.searchCnt, this.content);
		
	}


	@Override // 부모클래스 toString -> 자식클래스 재정의 (부모클래스의 시그니처(타입 메서드 매개변수 등)가 자식클래스와 다를 때 알려주는 기능
	public String toString() {
		return "Board [boardNo=" + boardNo + ", title=" + title + ", content=" + content + ", writer=" + writer
				+ ", searchCnt=" + searchCnt + "]";
	}
	
	
	
	
	

}
