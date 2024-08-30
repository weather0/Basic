package co.yedam.prg;

public class Exam4 {
	public static void main(String[] args) {
		String[] arr = { "010102-4", "991012-1", "960304-1", "881012-2", "040403-3" };
		int gender = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i].substring(7, 8).equals("1") || arr[i].substring(7, 8).equals("3")) {
				gender++;
			}
		}
		System.out.println("남 " + gender + " 여 " + (arr.length - gender));
	}

}
