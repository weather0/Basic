package ac.yedam.mvc.board;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class BoardController {
	Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
	BoardMapper mapper;
	
	// 단건조회
	@RequestMapping("/board")
	public String board(Model model, BoardVO vo, HttpServletRequest request) {
		logger.info("파라미터: " + vo.toString());
//		스프링은 주로 model을 씀(request써도 무방)
		model.addAttribute("board", mapper.getBoard(vo));
//		request.setAttribute("board", mapper.getBoard(vo));
		return "board/board";
	}

	// 목록
	@RequestMapping("/boardList")
	public String boardList(Model model, BoardVO vo) {
		model.addAttribute("boards", mapper.getBoardList(vo));
		return "board/boardList";
	}
	
	// 등록페이지 이동
	@GetMapping("/boardInsert")
	public String boardInsert() {
		return "board/boardInsert";
	}

	// 등록처리
//	@RequestMapping(value = "/boardInsert", method = RequestMethod.POST) // = @PostMapping
	@PostMapping("/boardInsert")
	public String boardInsertProc(BoardVO vo) {
//		logger.debug(vo.toString());
		System.out.println(vo);
		mapper.insertBoard(vo);
		System.out.println(vo.getBno() + "게시글 등록");
		return "redirect:boardList"; // redirect 안쓰면 페이지이동해도 암것도 안 뜸
	}
	
	// 수정페이지
	@GetMapping("/boardUpdate/{bno}")
	public String boardUpdateForm(Model model, BoardVO vo, @PathVariable String bno) {
		vo.setBno(bno);
		model.addAttribute("board", mapper.getBoard(vo));
		return "board/boardUpdate";
	}
	
	// 수정처리
	@PostMapping("/boardUpdate")
	public String boardUpdateProc(BoardVO vo) {
		mapper.updateBoard(vo);
		return "redirect:boardList";
	}
	
	// 삭제처리
	@GetMapping("/boardDelete")
	public String boardDeleteForm(Model model, BoardVO vo) {
		mapper.deleteBoard(vo);
		return "redirect:boardList";
	}

}
