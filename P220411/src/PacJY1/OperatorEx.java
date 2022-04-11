package PacJY1;

public class OperatorEx {
	public static void main(String[] args) {
//		int result = 6 / 4;
//		int result2 = 6 % 4; // 나머지: %
//		int val = 5;
//		if (val % 2 == 0) {
//			System.out.println("짝수입니다.");
//		} else {
//			System.out.println("홀수입니다");
//		}
//		
		
		int v, v1, v2, v3, v4, v5, v6, r1, r2, r3, c1, c2, c3;
		v = 75300;
		v1 = 50000;
		v2 = 10000;
		v3 = 5000;
		v4 = 1000;
		v5 = 500;
		v6 = 100;
		c1 = v % v1;
		c2 = c1 % v2;
		c3 = c2 % v3;
		// 5300 - 300 / 5000 = 5300 5000 300
		r1 = v1 / (v - c1);
		r2 = (v - c1) / (c1 - c2);
		r3 = (v - c1 - c2) / (c1 - c2 - c3);
		
		
		System.out.println("5만원짜리 "+ r1 + 
				"장, 1만원짜리 " + r2 + 
				"장, 5천원짜리 " + r3);
		
//		if (v % v1 == 0) {
			
			
		}

}
