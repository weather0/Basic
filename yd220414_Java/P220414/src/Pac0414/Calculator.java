package Pac0414;

public class Calculator {
	private double pi = 3.14;

	// 리턴타입 없는 메서드: void
	void printPI() {
		System.out.println("원주율은 " + pi);
	}

	void getArea(double radius) {
		double area = pi * radius * radius;
		System.out.println("반지름 " + radius + "의 넓이는 " + area);

	}

// ─────────────────────────────────────────────────────	
	// 리턴타입 있는 것
	int sum(int num1, int num2) {
		return num1 + num2;
	}

	double sum(double n1, double n2) {
		return n1 + n2;
	} // 메서드 오버로딩: 메서드명 같아도 매개변수의 타입이나 개수가 다르면 정상처리됨

	
	
	// 밑변과 높이 입력 => 삼각형의 넓이 계산 메소드. getTriangleArea
	double getTriangleArea(double width, double height) {
		return (width * height) / 2;
	}

	
	// 매개변수에 클래스, 배열 다 올 수 있음
	int sum(int[] ary) {
		int sum = 0;
		for (int i = 0; i < ary.length; i++) {
			sum += ary[i];
		}
		return sum;
	}

	
	
	// 평균계산
	double average(int n1, int n2, int n3) {
		return (n1 + n2 + n3) / 3.0;
	}
	// 메서드 타입(리턴에 대한 타입)과 매개변수 타입은 달라도 됨


	double average(int... args) {
		int sum = 0;
		for (int i =0; i < args.length; i++) {
			sum += args[i];
		}
		return (double) sum / args.length;
		
	}
	
	
	
}	
	
	

