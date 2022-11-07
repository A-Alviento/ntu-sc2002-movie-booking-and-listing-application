package model;

/*
 * Represents list of Public Holidays to be stored in a database
 */
import java.util.ArrayList;
import java.time.LocalDate;

public class PublicHolidays extends Model {
	public static final long serialVersionUID = 91L;

	/*
	 * Array of the public holidays
	 */
	private static ArrayList<LocalDate> publicHolidayList = new ArrayList<LocalDate>();
	
	/*
	 * Add a date into the list of public Holiday
	 * @param date date to be added to the list
	 */
	public static void addPublicHoliday(LocalDate date) {
		publicHolidayList.add(date);
	}
	
	/*
	 * Get List of public holiday
	 * @return publicHolidayList  list of public holiday in db
	 */
	public static ArrayList<LocalDate> getPublicHolidays(){
		return publicHolidayList;
	}
	
}
