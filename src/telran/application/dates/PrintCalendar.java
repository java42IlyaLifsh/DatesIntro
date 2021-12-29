package telran.application.dates;

import java.time.*;
import java.time.format.TextStyle;
import java.util.Locale;

public class PrintCalendar {
	private static final TextStyle WEEK_DAY_LENGTH = TextStyle.SHORT_STANDALONE;
	static DayOfWeek[] daysOfWeek;
	private static Locale locale = Locale.forLanguageTag("en");
	public static void main(String[] args) {
		/*****************************************/
		int[] monthYear = null;

		/************************************************/
		try {

			// TODO Part for arguments processing
			// java -jar <jar file name> <month number> <year> <full name of week day
			// (SUNDAY upper case)>
			// no arguments - current month, current year, MONDAY
			// no year, no week day - current year, MONDAY
			// no week day - MONDAY
			monthYear = getMonthYear(args);
			setDaysOfWeek(args);
		} catch (RuntimeException e) {
			e.printStackTrace();//functionality error
		}
		catch (Exception e) {
			System.out.println(e.getMessage());//wrong input data 
			return;
		}
		printCalendar(monthYear[0], monthYear[1]);

	}

	private static int[] getMonthYear(String[] args) throws Exception {
		LocalDate current = LocalDate.now();
		int[] res = { current.getMonthValue(), current.getYear() };
		if (args.length > 0) {
			int month = getMonth(args[0]);
			res[0] = month;
		}
		if (args.length > 1) {
			int year = getYear(args[1]);
			res[1] = year;
		}
		return res;
	}

	private static int getYear(String strYear) throws Exception {
		int res = 0;
		try {
			res = Integer.parseInt(strYear);
		} catch (NumberFormatException e) {
			throw new Exception("Year should be a number");
		}
		if (res < 0) {
			throw new Exception("Year can't be negative");
		}
		return res;
	}

	private static int getMonth(String monthStr) throws Exception {
		int res = 0;
		try {
			res = Integer.parseInt(monthStr);
		} catch (NumberFormatException e) {
			throw new Exception("Month should be a number");
		}
		if (res < 1 || res > 12) {
			throw new Exception("Wrong month number, should be [1,12] ");
		}
		return res;
	}

	private static void setDaysOfWeek(String[] args) throws Exception {
		DayOfWeek[] sourceDays = DayOfWeek.values();
		int daysOnWeek = sourceDays.length;
		DayOfWeek firstDay = null;
		try {
			firstDay = args.length > 2 ? DayOfWeek.valueOf(args[2].toUpperCase()) : sourceDays[0];
		} catch (Exception e) {
			throw new Exception("wrong name of week day " + args[2]);
		}
		if (firstDay == sourceDays[0]) {
			daysOfWeek = sourceDays;
		} else {
			daysOfWeek = new DayOfWeek[daysOnWeek];
			int dayNumber = firstDay.getValue();
			for (int i = 0; i < daysOfWeek.length; i++) {
				int ind = dayNumber <= daysOnWeek ? dayNumber : dayNumber - daysOnWeek;
				daysOfWeek[i] = sourceDays[ind - 1];
				dayNumber++;
			}
		}

	}

	private static void printCalendar(int month, int year) {
		printTitle(month, year);
		printWeekDays();
		printDates(month, year);

	}

	private static void printDates(int month, int year) {
		int firstColumn = getFirstColumn(month, year);
		printOffset(firstColumn);
		int days = getDaysNumber(month, year);
		int columnWidth = getColumnWidth();
		int line = 1;
		for (int i = 1; i <= days; i++) {
			System.out.printf("%" + columnWidth + "d", i);
			if ((line + firstColumn) % daysOfWeek.length == 0) {
				System.out.println();

				firstColumn = 0;
			} else {
				firstColumn++;
			}

		}

	}

	private static int getColumnWidth() {

		return (daysOfWeek[0].getDisplayName(WEEK_DAY_LENGTH, locale) + " ").length();
	}

	private static int getDaysNumber(int month, int year) {

		return YearMonth.of(year, month).lengthOfMonth();
	}

	private static void printOffset(int firstColumn) {
		System.out.print(" ".repeat(firstColumn * getColumnWidth()));

	}

	private static int getFirstColumn(int month, int year) {
		LocalDate firstDateMonth = LocalDate.of(year, month, 1);
		int firstWeekDay = firstDateMonth.getDayOfWeek().getValue();
		int firstValue = daysOfWeek[0].getValue();
		int delta = firstWeekDay - firstValue;

		return delta >= 0 ? delta : delta + daysOfWeek.length;
	}

	private static void printWeekDays() {
		String res = " ".repeat(getColumnWidth() / 2);
		for (int i = 0; i < daysOfWeek.length; i++) {
			res += daysOfWeek[i].getDisplayName(WEEK_DAY_LENGTH, locale) + " ";
		}
		System.out.println(res);

	}

	private static void printTitle(int month, int year) {
		Month monthObj = Month.of(month);
		System.out.printf("%s, %d\n", monthObj.getDisplayName(TextStyle.FULL_STANDALONE, locale), year);

	}

}
