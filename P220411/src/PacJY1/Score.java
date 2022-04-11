package PacJY1;

import java.util.Scanner;

public class Score {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		
		double s1, s2, s3, sum, avg, max;
		s1 = scn.nextDouble();
		s2 = scn.nextDouble();
		s3 = scn.nextDouble();
		sum = s1 + s2 + s3;
		avg = (s1 + s2 + s3)/3.0;
		
		 // 최고점
		max = s1;
		if (max < s2) {
	 		max = s2;
		}
		if (max < s3) {
			max = s3;
		}
	
		System.out.printf("합은 %.0f, 평균은 %.2f, 최고점은 %.0f", sum, avg, max);
	}

}



