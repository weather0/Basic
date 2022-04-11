package PacJY1;

import java.util.Scanner;

public class Orange {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		int b1=(n/10);
		int b2=(n%10)/5;
		int b3=(n%10)%5;
		System.out.println("오렌지 "+n+"개는 10개씩 "+b1+"상자에 담고 "
		+"나머지를 5개씩 "+b2+"상자에 담고 "+b3+"개 남음");
		
		
	}

}