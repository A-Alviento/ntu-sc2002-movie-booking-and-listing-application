package model;
import java.time.LocalDate;

/**
 * Represents the booking for a movie show time that a customer account can make.
 */
public class Booking extends Model{
	public static final long serialVersionUID = 711L;

	private int[] seat = new int[2];
	private double price;
	private LocalDate date;	
	private String cinemaCode;
	private String movieTitle;
	private String transactionID = "";
	private Cinema cinema;
	
	public Booking(int[] seat, double price, String movieTitle, String cinemaCode, Cinema cinema) {
		this.seat = seat;
		this.price = price;
		this.date = LocalDate.now();
		this.movieTitle = movieTitle;
		this.cinemaCode = cinemaCode;
		transactionID = createTransactionID();
		this.cinema = cinema;
	}
	
	private String createTransactionID() {
		return PaymentUtil.generateTID(cinemaCode);
	}
	
	public String getTransactionID() {
		return transactionID;
	}
	
	public LocalDate getBookingDate() {
		return date;
	}
	
	public void setBookingDate(LocalDate date) {
		this.date = date;
	}
	
	public int[] getSeat() {
		return seat;
	}
	
	public void setSeat(int[] seat) {
		this.seat = seat;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public String getCinemaCode() {
		return cinemaCode;
	}
	
	public void setCinemaCode(String cinemaCode) {
		this.cinemaCode = cinemaCode;
	}
	
	public String getMovieTitle() {
		return movieTitle;
	}
	
	public void setMovieTitle(String movieTitle) {
		this.movieTitle = movieTitle;
	}
	
	public Cinema getCinema() {
	    return this.cinema;
	}
}
