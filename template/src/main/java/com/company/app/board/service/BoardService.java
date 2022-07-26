package com.company.app.board.service;

import java.util.List;

import com.company.app.common.Criteria;

public interface BoardService {
	public BoardVO getBoard(BoardVO vo);
	public List<BoardVO> getBoardList(Criteria cri);
	public int getTotal(Criteria cri);
	public void insertBoard(BoardVO vo);
	public boolean updateBoard(BoardVO vo);
	public boolean deleteBoard(BoardVO vo);
}
