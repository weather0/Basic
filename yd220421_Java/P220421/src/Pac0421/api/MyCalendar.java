package Pac0421.api;

import java.util.Calendar;

public class MyCalendar {
	public static void main(String[] args) {
		String y = "2025";
		String m = "4";
		showCal(y, m);

	}

	public static void showCal(String year, String month) {
		// 달력 출력
		Calendar cal = Calendar.getInstance();
		int y = Integer.parseInt(year);
		int m = Integer.parseInt(month);
		cal.set(y, m - 1, 1);
		cal.get(Calendar.YEAR);
		cal.get(Calendar.MONTH);
//		System.out.println(cal.get(Calendar.DAY_OF_WEEK));
		System.out.printf("         %d년  %d월        ", y, m);
		System.out.println();
		System.out.println(" Sun Mon Tue Wed Thr Fri Sat");
		for (int i = 1; i < cal.get(Calendar.DAY_OF_WEEK); i++) {
			System.out.print("    ");
		}
		for (int i = 1; i < cal.getActualMaximum(Calendar.DATE) + 1; i++) {
			System.out.printf("%4d", i);
			if (cal.get(Calendar.DAY_OF_WEEK) == 1) {
				if (i % 7 == 1 - cal.get(Calendar.DAY_OF_WEEK)) {
					System.out.println("");
				}

			} else if (i % 7 == 8 - cal.get(Calendar.DAY_OF_WEEK)) {
				System.out.println("");
			}
		}

	}

}
