package PacCondition;

public class IfExample4 {
	public static void main(String[] args) {
		// 임의의 값을 생성해주는 Math.random().
		int randomVal = (int) (Math.random() * 10) + 1;
		System.out.println(randomVal);

		// 생성값이 1~50, 51~60, 61~70, ... ~100
		System.out.println("생성된 값은 1~50까지 범위 값");
		int ran0 = (int) (Math.random() * 50) + 1;
		System.out.println(ran0);
		
		System.out.println("생성된 값은 61~70까지 범위 값");
		int ran60 = (int) (Math.random() * 10) + 61;
		System.out.println(ran60);
		
		System.out.println("생성된 값은 71~80까지 범위 값");
		int ran70 = (int) (Math.random() * 10) + 71;
		System.out.println(ran70);
		
		System.out.println("생성된 값은 81~90까지 범위 값");
		int ran80 = (int) (Math.random() * 10) + 81;
		System.out.println(ran80);

	}

}
