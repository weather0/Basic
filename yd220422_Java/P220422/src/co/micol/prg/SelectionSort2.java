package co.micol.prg;

// [com.naver.메인P명]→기본(필수).서브P명.관련단어
public class SelectionSort2 {
	private int i;
	private int j;
	private int min;
	// 내부적으로 사용할때는 private하고 게터세터 불필요

	public void sort(int[] arr) {
		arrPrint(arr);

		for (i = 0; i < arr.length - 1; i++) {
			min = i;
			for (j = i + 1; j < arr.length; j++) { // 요소 비교
				if (arr[min] > arr[j]) { // 내림차순 <
					min = j;
				}

			}
			if (min != i) { // swap처리
				int temp = arr[i];
				arr[i] = arr[min];
				arr[min] = temp;
			}

		}
		resultPrint(arr);
	}

	private void arrPrint(int[] arr) {
		System.out.println("초기데이터");
		for (int i : arr) {
			System.out.print(i + " ");
		}
		System.out.println("\n==============");
	}

	private void resultPrint(int[] arr) {
		System.out.println("결과데이터");
		for (int i : arr) {
			System.out.print(i + " ");
		}
	}

}
