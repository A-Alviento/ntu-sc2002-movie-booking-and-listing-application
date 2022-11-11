package model;
import java.time.LocalDate;
import java.time.LocalTime;
/**
 * This class is a static class whose role is to calculate the price of the movie ticket.
 */
public final class PriceUtil {
	/**
	 * Default constructor to prevent any object to be created using this class 
	 */
	private PriceUtil() {};
	/**
	 * Current GST
	 */
	private static double gst = 1.07;
	/**
	 * Used as a temp varible to store price
	 */
	private static double price = 0.0;
	/**
	 * Base ticket price (without any additional conditions)
	 */
	private static double basePrice = 10;
	/**
	 * Base Price Getter
	 */
	public static double getBasePrice() {
		return basePrice;
	}
	/**
	 * Base Price Setter
	 */
	public static void setBasePrice(double input) {
		basePrice = input;
	}
	/**
	 * GST setter
	 */
	public static void setGST(double newGst) {
		gst = newGst;
	}
	/**
	 * GST getter
	 */
	public static double getGST() {
		return gst;
	}
	
	
	/**
	 * The multiplier for people watching movie in BRONZE cinema.
	 */
	private static double bronzeCinemaMultiplier = 1.0;
	/**
	 * The multiplier for people watching movie in SILVER cinema.
	 */
	private static double silverCinemaMultiplier = 1.2;
	/**
	 * The multiplier for people watching movie in GOLD cinema.
	 */
	private static double goldCinemaMultiplier = 1.4;
	/**
	 * Getter for bronze cinema multiplier
	 */
	public static double getBronzeCinemaMultipler() {
		return bronzeCinemaMultiplier;
	}
	/**
	 * Setter for bronze cinema multiplier
	 */
	public static void setBronzeCinemaMultipler(double multiplier) {
		bronzeCinemaMultiplier = multiplier;
	}
	/**
	 * Getter for silver cinema multiplier
	 */
	public static double getSilverCinemaMultipler() {
		return silverCinemaMultiplier;
	}
	/**
	 * Setter for silver cinema multiplier
	 */
	public static void setSilverCinemaMultipler(double multiplier) {
		silverCinemaMultiplier = multiplier;
	}
	/**
	 * Getter for gold cinema multiplier
	 */
	public static double getGoldCinemaMultipler() {
		return goldCinemaMultiplier;
	}
	/**
	 * Setter for gold cinema multiplier
	 */
	public static void setGoldCinemaMultipler(double multiplier) {
		goldCinemaMultiplier = multiplier;
	}
	/**
	 * The multiplier for blockbuster. If a movie is a blockbuster, it is more expensive.
	 */
	private static double blockbusterMultiplier = 1.1;
	/**
	 * THe multiplier for 3D movie. If a movie is in 3D, it is more expensive.
	 */
	private static double movie3DMultiplier = 1.2;
	/**
	 * Getter for blockbuster multiplier
	 */
	public static double getBlockbusterMultipler() {
		return blockbusterMultiplier;
	}
	/**
	 * Setter for blockbuster multiplier
	 */
	public static void setBlockbusterMultipler(double multiplier) {
		blockbusterMultiplier = multiplier;
	}
	/**
	 * Getter for 3D Movie multiplier
	 */
	public static double getMovie3DMultipler() {
		return movie3DMultiplier;
	}
	/**
	 * Setter for 3D Movie multiplier
	 */
	public static void setMovie3DMultipler(double multiplier) {
		movie3DMultiplier = multiplier;
	}
	
	
	/**
	 * Movie multiplier for weekend. So when it is a weekend, movie is more expensive.
	 */
	private static double weekendMultiplier = 1.3;
	/**
	 * Movie multiplier for public Holiday. So when it is a public holiday, movie is more expensive.
	 */
	private static double publicHolidayMultipler = 2.0;
	/**
	 * Get Weekend Multiplier
	 */
	public static double getWeekendMultipler() {
		return weekendMultiplier;
	}
	/**
	 * Setter for weekend multiplier
	 */
	public static void setWeekendMultipler(double multiplier) {
		weekendMultiplier = multiplier;
	}
	/**
	 * Get public holiday Multiplier
	 */
	public static double getPublicHolidayMultipler() {
		return publicHolidayMultipler;
	}
	/**
	 * Setter for public holiday multiplier
	 */
	public static void setPublicHolidayMultipler(double multiplier) {
		publicHolidayMultipler = multiplier;
	}	
	/**
	 * Student Multiplier (cheaper if customer is student)
	 */
	private static double studentMultipler = 0.8;
	/**
	 * Multiplier for Elderly (cheaper if customer is elderly)
	 */
	private static double elderlyMultuipler = 0.65;
	/**
	 * Student Multiplier getter
	 */
	public static double getStudentMultipler() {
		return studentMultipler;
	}
	/**
	 * Student Multiplier setter
	 */
	public static void setStudentMultipler(double multiplier) {
		studentMultipler = multiplier;
	}	
	/**
	 * Elderly Multiplier getter
	 */
	public static double getElderlyMultipler() {
		return elderlyMultuipler;
	}
	/**
	 * Elderly Multiplier setter
	 */
	public static void setElderlyMultipler(double multiplier) {
		elderlyMultuipler = multiplier;
	}

	/**
	 * A private function to calculate the price of the movie. This function do not include any considerations for date and customer
	 */
	private static void movieBasePrice(boolean is3D, CinemaClass cinemaClass, boolean isBlockbuster) {
		price = basePrice;
		if(cinemaClass == CinemaClass.BRONZE) {
			price *= bronzeCinemaMultiplier;
		}else if (cinemaClass == CinemaClass.SILVER) {
			price *= silverCinemaMultiplier;
		}else {
			price *= goldCinemaMultiplier;
		}
		
		if(is3D) {
			price *= movie3DMultiplier;
		}
		
		if(isBlockbuster) {
			price *= blockbusterMultiplier;
		}
		
	}
	/**
	 * A private function to check if a time is after 6pm.
	 * @return boolean true if over 6pm, else false
	 */
	private static boolean isEvening(LocalTime time) {
		return (time.getHour() >= 18);
	}
	/**
	 * A private function that takes the movie price and modifiy it with time of movie and date of movie and the customer age and cinema class.
	 */
	private static void updatePrice(LocalDate date, LocalTime time, int age, boolean is3D, CinemaClass cinemaClass, boolean isBlockbuster) {
		movieBasePrice(is3D, cinemaClass, isBlockbuster);
		if(CheckDate.isPublicHoliday(date)) {
			price *= publicHolidayMultipler;
			return;
		}
		
		if (CheckDate.isWeekend(date)) {
			price *=  weekendMultiplier;
			return;
		}
		//Weekdays past 6pm -> no discount
		if(isEvening(time)) {
			return;
		}
		//weekday and before 6pm 
		Age ageCategory = CheckAge.checkAgeCategory(age);
		if(ageCategory == Age.STUDENT) {
			price *= studentMultipler; 
			return;
		}else if (ageCategory == Age.ELDERLY) {
			price *= elderlyMultuipler;
			return;
		}
	}
	/**
	 * A private function to add the GST at the end.
	 */
	private static void addGst() {
		price *= gst;
	}
	/**
	 * A function to give the price of the movie with all the required considerations.
	 * @return price of the movie for the customer.
	 */
	public static String getPrice(LocalDate date, LocalTime time, int age, boolean is3D, CinemaClass cinemaClass, boolean isBlockbuster) {
		updatePrice( date,  time,  age,  is3D,  cinemaClass,  isBlockbuster);
		addGst();
		return String.format("%.2f", price);
	}
	
}
