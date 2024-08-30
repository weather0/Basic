package co.jyk.exam0510.service;

import java.util.List;

import co.jyk.exam0510.vo.BookInfo;

public interface BookService {
	List<BookInfo> booklist();
	BookInfo bookone(BookInfo vo);
	List<BookInfo> bookjava(String vo);
	List<BookInfo> bookrent();
	int bookIn(BookInfo vo);
	
	
	

}
