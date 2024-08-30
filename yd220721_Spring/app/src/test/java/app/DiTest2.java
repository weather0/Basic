package app;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

// 컨테이너 = 앱컨텍스트 구성 (방법2)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:root-context.xml")
public class DiTest2 {
	@Autowired TV tv; // Autowired = getBean
	
//	@Component를 두 구현 클래스에 다 붙이면 오류나는데 그걸 qualifier로 해결
//	@Qualifier("samsungTV")
//	TV tv;
	
	@Test
	public void test() {
		tv.poweron();
	}

}
