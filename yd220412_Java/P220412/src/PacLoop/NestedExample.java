package PacLoop;

public class NestedExample {
	public static void main(String[] args) {
		// 구구단
		for (int j = 2; j <= 9; j++) {
			int dan = j;
			for (int i = 1; i <= 9; i++) {
				System.out.println(dan + " * " + i + " = " + dan * i);
			}

		}

//────────────────────────────────────────────

		for (int j = 1; j <= 5; j++) {
			for (int i = 1; i <= j; i++) {
				System.out.print("*"); // 줄바꿈 없이 그냥 나열됨
			}
			System.out.println(); // 단순 줄바꿈
		}

//──────────────────────────────────────────── 교재 p.161
		System.out.println("==============");
		for (int j = 1; j <= 5; j++) {
			for (int i = 5; i >= j; i--) {
				System.out.print("*");
			}
			System.out.println();
		}

// for (int i = 5; i >= 1; i--) {System.out.print("*"); → 5에서 1까지의 반복횟수 = 5회 → ***** (프린트를 5회 한다) 
// for (int i = 5; i >= 2; i--) {System.out.print("*"); → 5에서 2까지의 반복횟수 = 4회 → **** 
// for (int i = 5; i >= 3; i--) {System.out.print("*"); → 5에서 3까지의 반복횟수 = 3회 → *** 
// for (int i = 5; i >= 4; i--) {System.out.print("*"); → 5에서 4까지의 반복횟수 = 2회 → ** 
// for (int i = 5; i >= 5; i--) {System.out.print("*"); → 5에서 5까지의 반복횟수 = 1회 → * 

		
//──────────────────────────────────────────── 교재 p.161
		System.out.println("==============");
		for (int j = 1; j <= 10; j++) {
			for (int i = 10; i >= j; i--) {
				System.out.print(" ");
			}
			for (int i = 1; i <= j; i++) {
				System.out.print("*");
			}
			
			System.out.println();
		}

		
		
		
		
		
		
		
		
		
		
		
		
//────────────────────────────────────────────
	}

}
