package PacLoop;

public class ForExample3 {
	public static void main(String[] args) {
		// 1 ~ 100번 반복
		// 최초로 1000보다 큰 값중 최소값을 구하시오
		int sum = 0;
		int cnt = 0;
		for (int i = 1; i <= 100; i++) {
			sum += i;
			if (sum > 1000) {
				cnt = i;
				break;
			}
		}
		System.out.println("1000보다 큰 최소합계: " + sum + ", 순번: " + cnt);

//────────────────────────────────────────────
		// 100의 약수

		for (int i = 1; i <= 100; i++) {
			if (100 / i == 0) {
				System.out.println(i + " 는 100의 약수");
			}
		}

//────────────────────────────────────────────
	}

}
