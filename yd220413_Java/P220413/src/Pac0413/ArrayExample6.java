package Pac0413;

import java.util.Scanner;

public class ArrayExample6 {
	public static void main(String[] args) {
		Scanner sn = new Scanner(System.in);
		
		String[] names = new String[3];
		int[] scores = new int[3];
		
		for (int i = 0; i < names.length; i++) {
			System.out.println("이름를 입력하세요 >>>> ");
			names[i] = sn.nextLine();
			
			System.out.println("점수를 입력하세요 >>>> ");
			scores[i] = sn.nextInt();
			sn.nextLine(); // 이 줄 안넣으면 이상하게 중첩돼서 뜸
		}
		
		System.out.println("조회할 학생이름 입력>>> ");
		String searchName = sn.nextLine();
		for(int i=0; i<names.length; i++) {
			if(names[i].equals(searchName)) {
				System.out.println(searchName+"의 점수는"+scores[i]);
			}
		}
		
		System.out.println("end of prog.");
		

		
		
		
		
		
		
		
		


		
		
		
//────────────────────────────────────────────
	}

}
