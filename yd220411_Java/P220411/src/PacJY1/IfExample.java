package PacJY1;

public class IfExample {
	public static void main(String[] args) {
		int myAge = 19;
		boolean over20; // 변수 첫단어는 영문소문자(숫자x)
		over20 = myAge > 20;
		if(over20) {
			System.out.println("over 20");
		} else {
			System.out.println("unver 20");
		}
	}

}
