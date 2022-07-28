package com.example.demo.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// 교재198p (매퍼 vs 서비스 분리하는 이유)
@Service
public class BoardServiceImpl implements BoardService {

	@Autowired BoardMapper mapper;
	
	@Override
	public BoardVO getBoard(BoardVO vo) {
		return mapper.getBoard(vo);
	}

	@Override
	public List<BoardVO> getBoardList(Criteria cri) {
		System.out.println("(220727AOP수업)위에 before로그, list service(이줄), 밑에 after로그");
		return mapper.getBoardList(cri);
	}

	@Override
	public void insertBoard(BoardVO vo) {
		mapper.insertBoard(vo);
	}

	@Override
	public boolean updateBoard(BoardVO vo) {
		return mapper.updateBoard(vo) == 1;
	}

	@Override
	public boolean deleteBoard(BoardVO vo) {
		return mapper.deleteBoard(vo) == 1;
	}

	@Override
	public int getTotal(Criteria cri) {
		return mapper.getTotal(cri);
	}

}
