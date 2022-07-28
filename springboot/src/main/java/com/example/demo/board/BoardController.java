package com.example.demo.board;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.extern.log4j.Log4j;

//@Log4j
@Controller
public class BoardController {
//	Logger logger = LoggerFactory.getLogger(BoardController.class);
	// -> @Log4j로 대체. 변수명은 log로 자동생성됨
	
	@Autowired
	BoardMapper service;
	
	// 단건조회
	@RequestMapping("/board")
	public String board(Model model, BoardVO vo, HttpServletRequest request) {
//		logger.info("파라미터: " + vo.toString());
//		스프링은 주로 model을 씀(request써도 무방)
		model.addAttribute("board", service.getBoard(vo));
//		request.setAttribute("board", service.getBoard(vo));
		return "board/board";
	}

	// 목록
	@RequestMapping("/boardList")
	public String boardList(Model model, @ModelAttribute("cri") Criteria cri) {
		// 페이징
		// 전체건수
		cri.setAmount(5);
		int total = service.getTotal(cri);
		model.addAttribute("pageMaker",new PageDTO(cri, total));
		model.addAttribute("boards", service.getBoardList(cri));
		return "boardList";
	}
	
//	// 등록페이지 이동
//	@GetMapping("/boardInsert")
//	public String boardInsert() {
//		return "board/boardInsert";
//	}
//
//	// 등록처리
////	@RequestMapping(value = "/boardInsert", method = RequestMethod.POST) // = @PostMapping
//	@PostMapping("/boardInsert")
//	public String boardInsertProc(BoardVO vo) {
////		logger.debug(vo.toString());
//		System.out.println(vo);
//		service.insertBoard(vo);
//		System.out.println(vo.getBno() + "게시글 등록");
//		return "redirect:boardList"; // redirect 안쓰면 페이지이동해도 암것도 안 뜸
//	}
//	
//	// 수정페이지
//	@GetMapping("/boardUpdate/{bno}")
//	public String boardUpdateForm(Model model, BoardVO vo, @PathVariable String bno) {
//		vo.setBno(bno);
//		model.addAttribute("board", service.getBoard(vo));
//		return "board/boardUpdate";
//	}
//	
//	// 수정처리
//	@PostMapping("/boardUpdate")
//	public String boardUpdateProc(BoardVO vo, RedirectAttributes rttr) {
//		if(service.updateBoard(vo)) {
//			rttr.addFlashAttribute("result", "success");
//		};
//		return "redirect:boardList";
//	}
//	
//	// 삭제처리
//	@GetMapping("/boardDelete")
//	public String boardDeleteForm(Model model, BoardVO vo, RedirectAttributes rttr) {
//		if(service.deleteBoard(vo)) {
//			rttr.addFlashAttribute("result1","success"); // 일회성
//			rttr.addAttribute("result2","success"); // 파라미터
//		}
//		return "redirect:boardList";
//	}

}
