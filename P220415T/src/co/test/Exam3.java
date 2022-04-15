package co.test;

import java.util.Arrays;

// 배열의 사용.
// 크기가 10인 배열에 1 ~ 10까지의 임의의 수를 저장.
// 평균값보다 큰 값을 새로운 배열에 저장하도록 하세요.
public class Exam3 {
	public static void main(String[] args) {
		int[] intAry = new int[10];
		int[] intAry2 = new int[10];
		int sum = 0;
		double avg = 0;
		
		for (int i = 0; i < 10; i++) {
			int ran = (int) (Math.random() * 10) + 1;
			intAry[i] = ran;
			System.out.println(intAry[i]);
			sum += intAry[i];
		}
		avg = sum/10.0;
		System.out.println("평균값은 "+ avg +"입니다");
		
		for (int i = 0; i < 10; i++) {
			if (intAry[i] > avg) {
				System.out.println(intAry[i]);
				intAry2[i] = intAry[i];
			}

		}
		System.out.println(Arrays.toString(intAry2));
	
		
		
		
		
		
		
		
	}
}
