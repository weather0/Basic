package com.company.app.board;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.company.app.board.service.BoardService;
import com.company.app.board.service.BoardVO;
import com.company.app.common.Criteria;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:config/*-context.xml")
@Log4j // ->변수명은 log로 자동생성됨
public class BoardServiceTest {

	@Autowired // = @Setter(onMethod_ = @Autowired)
	BoardService service;

	@Test
	public void list() {
		service.getBoardList(new Criteria());
	}
	
//	@Test
//	public void insert() {
//		for (int i = 1; i < 100; i++) {
//			BoardVO vo = new BoardVO();
//			vo.setTitle("제목" + i);
//			vo.setContent("테스트" + i);
//			vo.setWriter("작성자" + i);
//			service.insertBoard(vo);
////			log.info("생성된 게시물 번호: " + vo.getBno());
//		}
//	}
}
