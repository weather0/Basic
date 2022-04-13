package Pac0413;

public class ArrayExam {
	public static void main(String[] args) {
		// 학생의 점수 30명
//		int score1 = 80;
//		int score2 = 90;
//		....
//		int score30 = 68;
//		→코드 길어지고 비효율적임
//		

		// 배열 기능 활용: 여러개의 같은 유형의 값을 저장

		int[] intAry = new int[30]; // 정수int 30개 담을 공간

		intAry[0] = 30;
		intAry[4] = 30;
		intAry[29] = 55;

		System.out.println(intAry[0]);
		System.out.println(intAry[1]);

		double[] dbleAry = new double[10]; // double형태 10개 저장

		String[] strAry = new String[5]; // 참조변수는 null로 처리됨
		System.out.println(strAry[0]);

		int[] otherAry = { 10, 20, 30, 40 }; // 초기값을 지정
		int[] theOtherAry = { 10, 20, 30, 40 }; // 초기값을 지정
		System.out.println(otherAry[0]);
		
		if(otherAry[0] == theOtherAry[0]) {
			System.out.println("같다");
		} else {
			System.out.println("다르다");
		}

		
		
		
//────────────────────────────────────────────
	}

}
