package Pac0418.game;

import java.util.Arrays;
import java.util.Scanner;

// 1~5 임의의 값 생성
// [#],[#],[#],[#],[#] 5가 들어있는 위치 맞추는 게임  
public class brain {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		
		int[] arr = new int [5];
		for (int i =0; i<arr.length; i++) { // 중복값 나왔을 경우
			arr[i] = (int)(Math.random()*5)+1;
			for (int j =0; j<i; j++) {
				if (arr[i] == arr[j]) {
					i--;  // 이게 핵심아이디어. i=1일때 중복값 나왔을 경우 i→0→다시위로가서i++되어 i=1 다시실행되는 로직
					break;
				}
			}
			
		}
		System.out.println(Arrays.toString(arr));
		
		while(true) {
			System.out.println("5가 들어간 위치를 맞춰보세요");
			int num = scn.nextInt();
			if (arr[num-1] == 5) {
				System.out.println("맞았습니다");
				break;
			}else {
				System.out.println("재도전");
			}
		}
		
		
		
		
	}

}
