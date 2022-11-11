package model;

/**
 * Payment Utility are methods used for a customer to purchase a movie ticket.  
 */
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class PaymentUtil {

	/**
	 * Generate the date in the correct format for only this class to use
	 * @return date formatted in the way transaction ID needs it to be
	 */
	private static String formattedDate() {
		LocalDateTime dateObj = LocalDateTime.now();
		DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyyMMddHHmm");
		String formattedDate = dateObj.format(myFormatObj);
		return formattedDate;
	}
	
	/**
	 * @param cinemaCode Cinema's unique code
	 * @return The transaction ID for the purchase
	 */
	public static String generateTID(String cinemaCode) {
		return cinemaCode+formattedDate();
	}
	
}
