package com.company.app.book.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.app.book.mapper.BookMapper;
import com.company.app.book.service.BookVO;



@Controller
public class BookController {
	@Autowired
	BookMapper mapper;

	// 목록
	@RequestMapping("/bookList")
	public String bookList(Model model, BookVO vo) {
		model.addAttribute("books", mapper.getBookList(vo));
		return "book/bookList";
	}
	
	// 목록
	@RequestMapping("/rentList")
	public String rentList(Model model, BookVO vo) {
		model.addAttribute("rents", mapper.getRentList(vo));
		return "book/rentList";
	}
	
	// 등록페이지 이동
	@GetMapping("/bookInsert")
	public String bookInsert(Model model, BookVO vo) {
		model.addAttribute("books", mapper.getBookNo(vo));
		return "book/bookInsert";
	}
	
	// 등록처리
	@PostMapping("/bookInsert")
	public String bookInsertProc(BookVO vo) {
		mapper.insertBook(vo);
//		System.out.println(vo.getBookNo() + "도서 등록");
		return "redirect:bookList";
	}
	
}
