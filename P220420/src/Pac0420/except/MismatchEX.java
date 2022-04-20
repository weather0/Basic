package Pac0420.except;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MismatchEX {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		while (true) {
			System.out.println("1.추가  2.종료");
			System.out.println("선택>> ");
			int menu = 0;

			try {
				Class.forName("java.lang.String"); // Exception클래스를 상속받아 처리되는 예외는 반드시 try/catch 처리해줘야함
			} catch (ClassNotFoundException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}

			try { // RuntimeException
				menu = Integer.parseInt(scn.next()); // scn.next()는 문자열임. 문자열"10"을 숫자10을 변환
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("배열 범위 넘어서려 합니다");
			} catch (InputMismatchException | NumberFormatException e2) {
				System.out.println("숫자선택");
				scn.nextLine(); // 이 줄 안 넣으면 무한루프..
			} catch (Exception e3) { // 최상위 예외. 기타등등(만능문구). 얘가 마지막에 와야 상식적
				System.out.println("알 수 없는 예외 발생");
			} finally {
				System.out.println("예외처리에서 반드시 한번은 실행");
			}

			
			if (menu == 1) {
				System.out.println("추가작업");
			} else if (menu == 2) {
				break;
			}

		}
		System.out.println("프로그램종료");

	}

}
