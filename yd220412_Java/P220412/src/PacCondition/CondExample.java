package PacCondition;

public class CondExample {
	public static void main(String[] args) {
		int score = (int) (Math.random() * 50) + 51; // random은 정적 메소드라 Math라는 클래스를 바로 적음 (new로 인스턴스 호출 안해도 됨)
		score /= 10;

		
		System.out.println(score);
		
		switch(score) {
		case 10: 
		case 9: System.out.println("A학점");break;
		case 8: System.out.println("B학점");break;
		case 7: System.out.println("C학점");break;
		case 6: System.out.println("D학점");break;
		default:
			System.out.println("노학점");
		}
		
			
		
		
	}

}
