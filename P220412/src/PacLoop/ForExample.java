package PacLoop;

public class ForExample {
	public static void main(String[] args) {
		int sum = 0;

		for (int i = 1; i <= 5; i++) {
			sum = sum + 3;
			// i = 1, sum = 3;
			// i = 2, sum = 6;
			// i = 3, sum = 9;
			// i = 4, sum = 12;
			// i = 5, sum = 15;
			// i = 6 → false로 반복문 빠져나옴

		}

		System.out.println("sum => " + sum);

//────────────────────────────────────────────

		for (int i = 1; i <= 9; i++) { // 감소식은 i--
			System.out.println("3 * " + i + " = " + (3 * i));

		}
		/// 아래 노가다를 반복문으로 처리↑
		System.out.println("==============");
		System.out.println("3 * 1 = 3");
		System.out.println("3 * 2 = 6");
		System.out.println("3 * 3 = 9");
		System.out.println("3 * 4 = 12");
		System.out.println("3 * 5 = 15");
		System.out.println("3 * 6 = 18");
		System.out.println("3 * 7 = 21");
		System.out.println("3 * 8 = 24");
		System.out.println("3 * 9 = 27");

//────────────────────────────────────────────
		// 5단
		System.out.println("==============");
		for (int i = 1; i <= 9; i++) {
			System.out.println("5 * " + i + " = " + (5 * i));
		}

//────────────────────────────────────────────
		System.out.println("==============");
		sum = 0;
		for (int i = 1; i <= 9; i += 2) { // 더하는 값 i 가 2개씩 증가
			sum = sum + i;
			System.out.println("sum은" + sum);
		}

//────────────────────────────────────────────
		System.out.println("==============");
		sum = 0;
		for (int i = 1; i <= 10; i++) { // 더하는 값 i가 짝수일 때만
			sum = sum + (2 * i);
			System.out.println("sum은" + sum);

		}
		
		
		
		

//────────────────────────────────────────────		
	}

}
