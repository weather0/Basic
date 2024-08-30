package Pac0418.game;

import java.util.Arrays;
import java.util.Scanner;

// 1~5 임의의 값 생성
// [#],[#],[#],[#],[#] 5가 들어있는 위치 맞추는 게임  
public class brain2 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		int[] arr = new int[5];
		for (int i = 0; i < arr.length; i++) { // 중복값 나왔을 경우
			arr[i] = (int) (Math.random() * 5) + 1;
			for (int j = 0; j < i; j++) {
				if (arr[i] == arr[j]) {
					i--; // 이게 핵심아이디어. i=1일때 중복값 나왔을 경우 i→0→다시위로가서i++되어 i=1 다시실행되는 로직
					break;
				}
			}

		}
		System.out.println(Arrays.toString(arr)); // 답지 미리보기

		int arr2[] = new int[5];
		System.out.println("5가 들어간 위치를 맞춰보세요");
		while (true) {
			int num = scn.nextInt();
			if (arr[num - 1] == 5) {
				for (int i = 0; i < arr.length; i++) {
					System.out.print("[" + arr[i] + "]");
				}
				System.out.println(" 정답입니다!!");
				break;
			} else {
				for (int j = 0; j < arr2.length; j++) {
					if (j == num - 1) {
						arr2[j] = arr[j];
						System.out.print("[" + arr2[j] + "]");
					} else if (arr2[j] != 0) {
						System.out.print("[" + arr2[j] + "]");
					} else {
						System.out.print("[*]");
					}
				}
				System.out.print(" 실패!! 다시시도하세요>> ");
			}

		}

	}

}
