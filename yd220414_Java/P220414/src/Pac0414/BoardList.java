package Pac0414;

public class BoardList {
	private Board[] boards;

	// 배열크기 초기화
	public void init(int size) {
		boards = new Board[size];

	}

	// 배열에 한 건 입력
	public int addBoard(Board board) { // 클래스타입의 배열은 초기값이 0이 아니라 null임
		// 더이상 저장공간이 없을 때는 false
//		boolean check = false; // 초기값
		int errorCase = -1; // 저장공간 없음
		for (int i = 0; i < boards.length; i++) {
			if(boards[i] != null && boards[i].getBoardNo() == board.getBoardNo()) {
				errorCase = 1; // 동일한 값이 있을 경우의 에러
				break;
			}
			if (boards[i] == null) {
				boards[i] = board;
				errorCase = 0; // 정상처리
				break;
			}
		}
		return errorCase;

	}

	// 수정: 게시글 번호를 찾아 내용,제목 변경
	public boolean modifyBoard(Board board) {
		boolean check = false;
		for (int i = 0; i < boards.length; i++) {
			if (boards[i].getBoardNo() == board.getBoardNo()) {
				boards[i].setContent(board.getContent());
				boards[i].setTitle(board.getTitle());
				check = true;
				break;
			}
		}
		return check;
	}

	// 삭제: 게시글번호
	public boolean removeBoard(int bNo) {
		boolean check = false;
		for (int i = 0; i < boards.length; i++) {
			if (boards[i].getBoardNo() == bNo) {
				boards[i] = null; // 배열의 위치 null대입
				check = true;
				break;
			}
		}
		return check;
	}

	
	
	// 한 건 조회: 게시글번호
	public Board searchBoard(int bNo) {
		for (int i = 0; i < boards.length; i++) {
			if (boards[i].getBoardNo() == bNo) {
				int currentCnt = boards[i].getSearchCnt();
				boards[i].setSearchCnt(currentCnt+1);  // 조회수 증가
				return boards[i]; // 배열의 위치 null대입
				
			}
		}
		return null;
	}

	
	// 작성자 조회 기능
	public Board[] getWriterList(String writer) {
		Board[] sBoards = new Board[5];
		
		for (int i = 0; i < boards.length; i++) { // 찾을 대상 배열
			if (boards[i] != null && boards[i].getWriter().equals(writer)) {
				for(int j = 0 ; j<sBoards.length; j++) { // 이름 조회 반환 배열
					if(sBoards[j] == null) { // 이 for문을 안쓰면 null공간에다가 새로 넣는게 아니라 writer로 찾을 때마다 계속 덮어써버림. 그래서 목록이 다 나오는게 아니라 한 줄만 나올 거임 
						sBoards[j] = boards[i];
						break;  // break안쓰면 null공간마다 똑같은 걸 전부 다 넣어버릴 거니깐 반드시 빠져나와야함 
					}
				}
			}	
		}
		return sBoards;
		
	}
	
	
	// 게시글 목록
	public Board[] boardListmokrok() {
		return boards;

	}

}
