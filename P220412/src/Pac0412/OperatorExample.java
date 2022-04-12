package Pac0412;

public class OperatorExample {
	public static void main(String[] args) {
		// 증감연산자
		int num1 = 10;
		int num2 = 20;
		num1 = num1 + 2; // 변수 덮어쓰기 가능
		num1 = num1 + 2; // 변수 덮어쓰기 가능
		System.out.println(num1);

		num1 = num1 + 1;
		num1 += 1;
		num1++; // 위 세개 같은 표현: 1을 누적연산
		System.out.println(num1); // 17
		System.out.println(num1++); // 윗줄에서 출력처리한 후 +1처리
		System.out.println(num1); // 18

		System.out.println(++num1); // 오른쪽 연산 전에 +1을 함

		int result = num1++ + ++num2; // 19 + 21
		System.out.println(result + ",num1: " + num1 + ",num2: " + num2); // 40

		byte num3 = 10; // byte < short < int < long
		num3 = (byte) (num3 + 1); // 정수연산 int타입으로 처리

		num3 += 1;
		num3++;

		num3 = 125;
		num3++; // 126
		num3++; // 127
		num3++; // -128 byte타입이 127이 최대기 때문에 한바퀴 돎
		num3++; // -127
		num3++; // -126
		System.out.println(num3);

	}

}
