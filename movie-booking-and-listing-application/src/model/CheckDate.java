package model;

/**
 *  A utility function used by the Price Class to check if a date is public holiday or weekend
 *  to determine the pricing.
 */

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;

public class CheckDate {
	/**
	 * Check if a date is weekend
	 * @param date Date to be checked
	 * @return a boolean that shows if the date is a weekend
	 */
	public static boolean isWeekend(LocalDate date) {
		if(date.getDayOfWeek() == DayOfWeek.SATURDAY ||date.getDayOfWeek() == DayOfWeek.SUNDAY ) {
			return true;
		}
		return false;
	}
	
	/**
	 * Check if a date is a public holiday
	 * @param date Date to be checked
	 * @return a boolean that shows if the date is a public holiday
	 */
	public static boolean isPublicHoliday(LocalDate date) {
		ArrayList<LocalDate> publicHolidayList = PublicHolidays.getPublicHolidays();
		if (publicHolidayList == null){
		    return false;
		}
		return publicHolidayList.contains(date);
	}
	
	/** Note:
	** LocalDate.of(2022,11,3) is how to create a LocalDate
	** Alternatively, LocalDate.parse("2022-11-3") also works
	*/
	
	public static boolean isFriday(LocalDate date) {
	    if(date.getDayOfWeek() == DayOfWeek.FRIDAY)
	        return true;
	    return false;
	}
}
