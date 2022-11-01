/**
 * 
 */
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
/**
 * @author Ming Ru
 *
 */

public class PaymentUtil {

	/**
	 * Generate the date in the correct format for only the class to use
	 * @return formattedDate
	 */
	private static String formattedDate() {
		LocalDateTime dateObj = LocalDateTime.now();
		DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyyMMddHHmm");
		String formattedDate = dateObj.format(myFormatObj);
		return formattedDate;
	}
	
	public static String generateTID(String cinemaCode) {
		return cinemaCode+formattedDate();
	}
	
}
