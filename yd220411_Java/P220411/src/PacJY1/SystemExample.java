package PacJY1;

import java.io.IOException;
import java.util.Scanner;

public class SystemExample {
	public static void main(String[] args) {
//		Scanner scn = new Scanner(System.in); // 키보드
//		Scanner scn = new Scanner("홍 박 이"); // 지정문자
//		System.out.println("세 개의 단어를 입력. 예) 안녕 방가 잘가");
//		while (scn.hasNext()) {
//			String str = scn.next();
//			System.out.println(str);
//			if (str.equals("exit")) {
//				break;
//			}
//		}
		System.out.println("숫자를 입력하세요.");
		while( true) {
			int readByte;
			try{
				readByte = System.in.read();
				System.out.println(readByte);
				if(readByte == -1)
					break;
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			}	
		System.out.println("end of program");
	}
	
}
