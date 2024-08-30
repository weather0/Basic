package com.company.app.book.mapper;

import java.util.List;

import com.company.app.book.service.BookVO;


public interface BookMapper {
	public BookVO getBookNo(BookVO vo);
	public List<BookVO> getBookList(BookVO vo);
	public List<BookVO> getRentList(BookVO vo);
	public void insertBook(BookVO vo);
	public void updateBook(BookVO vo);
	public void deleteBook(BookVO vo);
}
