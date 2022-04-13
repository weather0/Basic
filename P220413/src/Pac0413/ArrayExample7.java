package Pac0413;

public class ArrayExample7 {
	public static void main(String[] args) {
		// 달력만들기
		
		String[] days = {"Sun","Mon","Tue","Wed","Thr","Fri","Sat"};
		
		
		int month = 3;
		int lnth = getLastDay(month);
		int[] intAry = new int[lnth];

		for (int i = 0; i < intAry.length; i++) {
			intAry[i] = i + 1;

		}
		
		for (int i = 0; i < days.length; i++) {
			System.out.printf("%4s", days[i]); // 4개의 공백 s:문자열
			
		}
		
		
		System.out.println(); // 줄바꿈
		int spc = getDayInfo(month);
		for (int i = 0; i < spc; i++) {
			System.out.printf("%4s", " ");
			
		}
		
		
		for (int i = 0; i < intAry.length; i++) {
			System.out.printf("%4d", intAry[i]); // 4개의 공백 d:숫자
			if ((i+spc) % 7 == 6) {
				System.out.println();
			}
		}

	} // end of main(); main메소드 종료

	
	public static int getLastDay(int month) {
		switch(month) {
		case 2: 
			return 28;
		case 3: 
			return 31;
		case 4: // 4월의 경우
			return 30; // 마지막날짜
		case 5: // 5월
			return 31;			
		case 6: 
			return 30;
		default:
			return 0;
			
		}
	}
	
	
	public static int getDayInfo(int month) {
		switch(month) {
		case 2: 
			return 2;
		case 3: 
			return 2;
		case 4: // 4월의 경우
			return 5; // 맨앞 빈공간. 요일정보
		case 5: // 5월
			return 0;			
		case 6: 
			return 3;
		default:
			return 0;
			
		}
			
	}
	
	
	
	
	
	

}
