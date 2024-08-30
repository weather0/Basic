package Pac0413;

public class ArrayExample4 {
	public static void main(String[] args) {
		// 15이상만 합
		int[] intAry = new int[5];
		int sum = 0;

		for (int i = 0; i < 5; i++) {
			int ran = (int) (Math.random() * 30) + 1;
			intAry[i] = ran;
			System.out.println(intAry[i]);
			if (intAry[i] > 15) {
				sum += intAry[i];

			}
		}
		System.out.println("합은 " + sum);

		
		
		
		
		
//────────────────────────────────────────────

	}

}
