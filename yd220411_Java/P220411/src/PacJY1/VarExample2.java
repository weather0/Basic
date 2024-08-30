package PacJY1;

public class VarExample2 {
	public static void main(String[] args) {
		int han = 80;
		int eng = 70;
		int math = 63;
		int avg = (han + eng + math)/3;
		
		han = 85;
		eng = 75;
		math = 60;
		avg = (han + eng + math)/3;
		
		double avg2 = (han + eng + math)/3.0;
		
		System.out.println("80점, 70점, 63점의 평균: " + avg + "점입니다");
		System.out.println("85점, 75점, 60점의 평균: " + avg2 + "점입니다");
	}

}
