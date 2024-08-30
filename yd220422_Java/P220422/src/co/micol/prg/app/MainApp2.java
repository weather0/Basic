package co.micol.prg.app;

// main메서드는 없다!! 정보은닉
import co.micol.prg.SelectionSort2;

public class MainApp2 {
	public static void main(String[] args) {
		SelectionSort2 selectSort = new SelectionSort2();
		int data[] = { 5, 1, 4, 3, 2 };
		selectSort.sort(data);
		
		

	}
}
