
import java.time.LocalDate;

public class Booking {
	private int[] seat = new int[2];
	private double price;
	private LocalDate date;	
	private String cinemaCode;
	private String movieTitle;
	private String transectionID = "";
	
	public Booking(String name, String code, int[] seat, double price, String movieTitle, String cinemaCode) {
		this.seat = seat;
		this.price = price;
		this.date = LocalDate.now();
		this.setMovie(movieTitle);
		cinemaCode = code;
		transectionID = createTransectionID();
	}
	
	private String createTransectionID() {
		return PaymentUtil.generateTID(cinemaCode);
	}
	
	public String getTransectionID() {
		return transectionID;
	}
	public LocalDate getBookingDate() {
		return date;
	}
	
	public int[] getSeat() {
		return seat;
	}
	
	public double getPrice() {
		return price;
	}
	
	public String getCinema() {
		return cinemaCode;
	}

	public String getMovie() {
		return movieTitle;
	}

	public void setMovie(String movie) {
		this.movieTitle = movie;
	}
	
	
}
