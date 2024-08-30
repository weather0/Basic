package Pac0421.api;

import java.util.Random;

//0428 헬퍼쌤 수업
public class StringExam0428 {
	public static void main(String[] args) {
		// a와 b는 같은 주소값
		String a = "1";
		String b = "1";
		// c와 d는 다은 주소값
		String c = new String("1");
		String d = new String("1");
		
		a = a + b;
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("a");
		sb.append("b");
		sb.append("c");
		
		System.out.println(sb.toString());
		
		String exam = "1,2,3,4,5,6,7";
//		exam.split(",");
		
		String[] temp = exam.split(",");
		
		
		Random rd = new Random();
		rd.setSeed(0);
		long time = System.currentTimeMillis();
		long time2 = System.nanoTime();
		
		System.out.println(rd.nextInt());
		

	}

}
