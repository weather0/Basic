package PacCondition;

public class IfExample {
	public static void main(String[] args) {
		int score = 85;
		// 90점보다 크면 A, 80점보다 크면 B, 70보다 크면 C, 나머지는 F
		if (score >= 90) {
			System.out.println("A학점.");
		} else if (score >= 80) {
			System.out.println("B학점.");
		} else if (score >= 70) {
			System.out.println("C학점.");
		} else {
			System.out.println("F학점.");
		}
		
		// else if 활용과 if중복사용 구별
		if (score >= 90) {
			System.out.println("A학점.");
		}
		if (score >= 80) {
			System.out.println("B학점.");
		}
		if (score >= 70) {
			System.out.println("C학점.");
		}
		if (score < 70) {
			System.out.println("F학점.");
		}
		
		
		
	}

}
