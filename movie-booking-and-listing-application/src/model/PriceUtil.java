package model;
import java.time.LocalDate;
import java.time.LocalTime;

public final class PriceUtil {
	private PriceUtil() {};
	private static double price = 0.0;
	private static double basePrice = 10;
	
	
	private static double bronzeCinemaMultiplier = 1.0;
	private static double silverCinemaMultiplier = 1.2;
	private static double goldCinemaMultiplier = 1.4;
	
	public static double getBronzeCinemaMultipler() {
		return bronzeCinemaMultiplier;
	}
	public static void setBronzeCinemaMultipler(double multiplier) {
		bronzeCinemaMultiplier = multiplier;
	}
	
	public static double getSilverCinemaMultipler() {
		return silverCinemaMultiplier;
	}
	public static void setSilverCinemaMultipler(double multiplier) {
		silverCinemaMultiplier = multiplier;
	}
	public static double getGoldCinemaMultipler() {
		return goldCinemaMultiplier;
	}
	public static void setGoldCinemaMultipler(double multiplier) {
		goldCinemaMultiplier = multiplier;
	}
	
	private static double blockbusterMultiplier = 1.1;
	private static double movie3DMultiplier = 1.2;
	
	public static double getBlockbusterMultipler() {
		return blockbusterMultiplier;
	}
	public static void setBlockbusterMultipler(double multiplier) {
		blockbusterMultiplier = multiplier;
	}
	public static double getMovie3DMultipler() {
		return movie3DMultiplier;
	}
	public static void setMovie3DMultipler(double multiplier) {
		movie3DMultiplier = multiplier;
	}
	
	
	
	private static double weekendMultiplier = 1.3;
	private static double publicHolidayMultipler = 2.0;
	private static double adultFridayMultipler = 0.95;
	public static double getWeekendMultipler() {
		return weekendMultiplier;
	}
	public static void setWeekendMultipler(double multiplier) {
		weekendMultiplier = multiplier;
	}
	public static double getPublicHolidayMultipler() {
		return publicHolidayMultipler;
	}
	public static void setPublicHolidayMultipler(double multiplier) {
		publicHolidayMultipler = multiplier;
	}	
	public static double getAdultFridayMultipler() {
		return adultFridayMultipler;
	}
	public static void setAdultFridayMultipler(double multiplier) {
		adultFridayMultipler = multiplier;
	}
	
	private static double studentMultipler = 0.8;
	private static double elderlyMultuipler = 0.65;
	
	public static double getStudentMultipler() {
		return studentMultipler;
	}
	public static void setStudentMultipler(double multiplier) {
		studentMultipler = multiplier;
	}	
	public static double getElderlyMultipler() {
		return elderlyMultuipler;
	}
	public static void setElderlyMultipler(double multiplier) {
		elderlyMultuipler = multiplier;
	}

	
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
	
	private static boolean isEvening(LocalTime time) {
		return (time.getHour() >= 18);
	}
	
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
		}else {
			if (CheckDate.isFriday(date)) {
				price *= adultFridayMultipler;
			}
			return;
		}
	}
	
	public static String getPrice(LocalDate date, LocalTime time, int age, boolean is3D, CinemaClass cinemaClass, boolean isBlockbuster) {
		updatePrice( date,  time,  age,  is3D,  cinemaClass,  isBlockbuster);
		return String.format("%.2f", price);
	}
	
}
