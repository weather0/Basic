package Pac0414;

public class CalExample {
	public static void main(String[] args) {
		Calculator c1 = new Calculator();
		
		c1.printPI();
		c1.getArea(2.4);
		
		int result = c1.sum(30, 23);
		System.out.println("두 수의 합: "+ result);
//		double result2 = c1.sum(23.4, 30);
		
		
		
		
		double result3 = c1.getTriangleArea(3.9, 5.9);
		System.out.printf("삼각형의 넓이는 %.2f \n\n", result3);
		
		
		
		int[] intAry = {1,2,3,4,5};
		result = c1.sum(intAry);
		System.out.println("배열의 합: "+result);
		
		
		result3 = c1.average(10, 20, 30);
		System.out.println("평균; "+ result);
		
		result3 = c1.average(10,20,30,40,50);
		System.out.println("평균; "+result);
		
		
		
		
		
		
		
		
		
	}

}
