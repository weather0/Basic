package PacJY1;

public class VarExample5 {
	public static void main(String[] args) {
		int val = 10; 
		long val2 = 2147483648L; // long형은 L붙이자(대소문자상관x)
		long val3 = 10; // 숫자 작아서 L안써도 10이 자동으로 long형으로 변환(promotion)
		
		int val4 = (int) 2147483648L; 
		// long형 큰수를 int로 변환시에는 (casting:강제형변환) 필수(오류방지)
		// 다만 버려지는 값 있어서 결과는 부정확함
		int result = (int) (100000000000L/5);
		long val5= 10000000000L;
		long val6 = 10L;
		
		result =(int) (val5 - val6);
		System.out.println(result);
		
		char charLit = 97;
		charLit = 44032;
		System.out.println(charLit++);
		System.out.println(charLit++);
		System.out.println(charLit++);
		System.out.println(charLit++);
		System.out.println(charLit++);
		System.out.println(charLit++);
		System.out.println(charLit++);
		System.out.println(charLit++);
		System.out.println(charLit++);
		System.out.println(charLit++);
		System.out.println(charLit++);	
	}

}
