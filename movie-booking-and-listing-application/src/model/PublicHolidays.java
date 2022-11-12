package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Represents list of public holidays to be stored in a database.
 */
public class PublicHolidays extends Model {
	public static final long serialVersionUID = 91L;

	/**
	 * Array of the public holidays 
	 */
	private ArrayList<LocalDate> publicHolidayList;
	
	public PublicHolidays(ArrayList<LocalDate> list) {
	    if (list == null)
	        publicHolidayList = new ArrayList<>();
	    else
	        publicHolidayList = list;
	}
	
	/**
	 * Add a date into the list of public Holiday
	 * @param date date to be added to the list
	 */
	public void addPublicHoliday(LocalDate date) {
		publicHolidayList.add(date);
	}
	
	/**
	 * Get List of public holiday
	 * @return publicHolidayList  list of public holiday in db
	 */
	public ArrayList<LocalDate> getPublicHolidays(){
		return publicHolidayList;
	}
	
	/**
	 * Remove public holidays from the list.
	 * @return  int 0 - if Entered date is not in the list
	 * 			int 1 - if entered date is removed.
	 */
	public int removePublicHoliday(LocalDate date) {
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
