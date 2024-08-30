package co.micol.prg.app;

import java.lang.reflect.Array;
import java.util.Arrays;

import co.micol.prg.SelectionSort;

public class MainApp {
	public static void main(String[] args) {
		SelectionSort selectSort = new SelectionSort();
		int data[] = { 5, 1, 4, 3, 2 };
		for (int d : data) {
			System.out.print(d);
		}
		System.out.println("\n================");
//		data = selectSort.sort(data); // 내가 만든 로직 활용
		Arrays.sort(data); // Arrays클래스 활용
		for (int i = 0; i < data.length; i++) {
			System.out.print(data[i]);
		}
		

	}
}
