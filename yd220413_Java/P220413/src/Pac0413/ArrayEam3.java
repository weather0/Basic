package Pac0413;

public class ArrayEam3 {
	public static void main(String[] args) {
		
		// 절대불변(암기하면 편함) 
//		1. 배열집[]안에는 무조건 뭐가 들어가야함. [2]이런식으로. []이런 빈집은 없음
//		2. 따라서 배열집안 내부를 특정규칙으로 일반화 하기 어려우므로, 필연적으로 for조건문과 친구가 됨
//		3. 배열은 무조건 0부터 시작 (실수하지 말자!)
		
		int[] intAry = { 78, 83, 88, 92, 63 };

		int sum = 0;

		for (int i = 0; i < intAry.length; i++) { // length 만능 대응 가능
			sum += intAry[i];

		}
		System.out.println("합계는 " + sum);

		double avg = sum / 5;
		System.out.println(avg);

//────────────────────────────────────────────
		// 1,2,5 번쨰만 합 구하기
		sum = 0;

		for (int i = 0; i < 5; i++) {
			if ((i == 0) || (i == 1) || (i == 4)) {
				sum += intAry[i];
			}

		}
		System.out.println("합계는 " + sum);

//────────────────────────────────────────────
		// 홀수인 데이터만 합 구하기
		sum = 0;

		for (int i = 0; i < 5; i++) {
			if ((i % 2 == 0)) {
				sum += intAry[i];
			}

		}
		System.out.println("합계는 " + sum);

//────────────────────────────────────────────
		// 짝수 번째인 데이터만 합 구하기
		sum = 0;
		for (int i = 0; i < 5; i++) {
			if (i % 2 == 1) {
				sum += intAry[i];
			}

		}
		System.out.println("합계는 " + sum);

//────────────────────────────────────────────
		// 짝수인 데이터만 합 구하기
		sum = 0;
		for (int i = 0; i < 5; i++) {
			if (intAry[i] % 2 == 0) {
				sum += intAry[i];
	

			}

		}
		System.out.println("합계는 " + sum);

//────────────────────────────────────────────
		sum = 0;
		
		// 1,3,5
		
		
		
		
		
		
		
//────────────────────────────────────────────
	}

}
