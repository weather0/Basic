package ac.yedam.mvc.reply;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "classpath:config/*.xml")
public class ReplayMapperTests {
	@Autowired ReplyMapper mapper;

	// testList() 함수 따로 호출할 필요 없이 @Test가 기능을 자동으로 해줌
	// Spring Explorer창(나뭇잎아이콘)에서 결과 확인 가능
	@Test
	public void testList() {
		System.out.println(mapper.getList("1"));
	}

	@Test
	public void testCreate() {
		ReplyVO vo = new ReplyVO();
		
		vo.setBno("1");
		vo.setReply("댓글테스트");
		vo.setReplyer("Replyer");
		
		System.out.println(mapper.insert(vo) + "건 입력 완료");
	}
	
}
