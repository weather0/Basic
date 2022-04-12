package PacCondition;

import java.util.Scanner;

public class SwitchExample {
	public static void main(String[] args) {
		Scanner sn = new Scanner(System.in);

		System.out.println("피자의 종류 입력");
		String result = sn.nextLine();
		int price = 0;
		switch (result) {
		case "콤비네이션":
		case "슈퍼슈프림":
			price = 20000; break;
		case "포테이토":
			price = 15000; break;
		case "쉬림프":
			price = 25000; break;
		default:
			price = 0;

		}
		System.out.println("피자 " + result + "의 값은 " + price);

	}
}
