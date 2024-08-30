package Pac0413;

public class For0413 {
	public static void main(String[] args) {
		// 2개의 합이 6이 되는 숫자의 조합을 출력하시오
		// 츨략: 1,5. 2,4. 3,3. 4,2. 5,1

		for (int i = 1; i <= 6; i++) {
			for (int j = 1; j <= 6; j++) {
				if (i + j == 6) {
					System.out.println(i + "," + j);
				}
			}

		}

		
		
		
		
		
	}

}
