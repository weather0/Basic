package app;

import org.springframework.context.support.GenericXmlApplicationContext;

//DI Injection(주입)
public class DiTest {
	public static void main(String[] args) {
		// 컨테이너 = 앱컨텍스트 구성 (방법1)
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:root-context.xml");
		TV tv = ctx.getBean(SamsungTV.class); // new TV();
		TV tv2 = (TV) ctx.getBean("mytv");
		System.out.println(tv == tv2);
	}
}
