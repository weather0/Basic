package ac.yedam.mvc.reply;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import ac.yedam.mvc.board.BoardController;

@Controller
public class ReplyController {
	Logger logger = LoggerFactory.getLogger(BoardController.class);

	@Autowired
	ReplyMapper mapper;

	// 목록
	@RequestMapping("/replyList/{bno}")
	public void replyList(Model model, @PathVariable String bno) {
		model.addAttribute("replies", mapper.getList(bno));
//		return "board/boardUpdate";
	}

}
