package ac.yedam.mvc.reply;

import java.util.List;

public interface ReplyMapper {
	public ReplyVO read(String bno);
	public List<ReplyVO> getList(String bno);
	public int insert(ReplyVO vo);
	public int update(ReplyVO vo);
	public int delete(String bno);
//	public void getCountByBno(String bno);
}
