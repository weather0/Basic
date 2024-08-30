package Pac0413;

public class ArryExam2 {
	public static void main(String[] args) {
		int[] intAry = { 10, 20, 30, 40, 50 };
		
		int maxVal = 0;
		int sum = 0;
		for(int i=0; i<5; i++) { // 배열은 0부터 시작하니깐
			System.out.println(intAry[i]);
			if(maxVal < intAry[i]) {
				maxVal = intAry[i]; // maxVal값이 이빠이 오를때까지 계속 덮어쓰기 되어 최대값 구하는 원리
			}
			sum += intAry[i];
		
		}
		
		System.out.println("최대값: " + maxVal);
		System.out.println("합계: " + sum);
		
		
		

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//────────────────────────────────────────────
	}

}
