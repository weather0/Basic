package com.company.app.board.mapper;

import java.util.List;

import com.company.app.board.service.BoardVO;
import com.company.app.common.Criteria;

public interface BoardMapper {
	public BoardVO getBoard(BoardVO vo);
	public List<BoardVO> getBoardList(Criteria cri);
	public int getTotal(Criteria cri);
	public void insertBoard(BoardVO vo);
	public int updateBoard(BoardVO vo);
	public int deleteBoard(BoardVO vo);
}
