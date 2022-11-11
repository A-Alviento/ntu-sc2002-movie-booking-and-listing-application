package model;

/*
 * Represents list of Public Holidays to be stored in a database
 */
import java.util.ArrayList;
import java.util.Iterator;
<<<<<<< HEAD

=======
>>>>>>> 8db0f11 (Made some changes.)
import java.time.LocalDate;

public class PublicHolidays extends Model {
	public static final long serialVersionUID = 91L;

	/*
	 * Array of the public holidays
	 */
	private static ArrayList<LocalDate> publicHolidayList;
	
	public PublicHolidays(ArrayList<LocalDate> list) {
	    
	    publicHolidayList = list;
	}
	
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
	
		/*
	 * Remove public holidays from the list.
	 * @return  int 0 - if Entered date is not in the list
	 * 			int 1 - if entered date is removed.
	 */
	public static int removePublicHoliday(LocalDate date) {
		Iterator <LocalDate> itr = publicHolidayList.iterator();
		LocalDate temp;
		while(itr.hasNext()) {
			temp = itr.next();
			if(date.isEqual(temp) ) {
				itr.remove();
				return 1;
			}
		}
		return 0;
	}
	
}
