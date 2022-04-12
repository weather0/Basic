package PacLoop;

public class ForExample2 {
	public static void main(String[] args) {
		int sum = 0;
		for (int i = 1; i <= 100; i++) {
			if (i == 31) {
				break; // 반복문 종료
			}
			if (i % 2 == 0) {
				System.out.println("현재i값 " + i);
				continue; // continue 구문 아래 코드 실행없이 다음 순번
			}
			sum = sum + i;
		}
		System.out.println("sum은 " + sum);

		
		
		
		
		
		
		
		
		
		
//────────────────────────────────────────────
	}

}
