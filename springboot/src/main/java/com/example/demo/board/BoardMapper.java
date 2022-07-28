package com.example.demo.board;

import java.util.List;


public interface BoardMapper {
	public BoardVO getBoard(BoardVO vo);
	public List<BoardVO> getBoardList(Criteria cri);
	public int getTotal(Criteria cri);
	public void insertBoard(BoardVO vo);
	public int updateBoard(BoardVO vo);
	public int deleteBoard(BoardVO vo);
}
