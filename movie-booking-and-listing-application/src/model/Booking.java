package model;
import java.time.LocalDate;

public class Booking extends Model{
	public static final long serialVersionUID = 711L;
	private int[] seat = new int[2];
	private double price;
	private LocalDate date;	
	private String cinemaCode;
	private String movieTitle;
	private String transectionID = "";
	private Cinema cinema;
	
	public Booking(int[] seat, double price, String movieTitle, String cinemaCode, Cinema cinema) {
		this.seat = seat;
		this.price = price;
		this.date = LocalDate.now();
		this.movieTitle = movieTitle;
		this.cinemaCode = cinemaCode;
		transectionID = createTransectionID();
		this.cinema = cinema;
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
