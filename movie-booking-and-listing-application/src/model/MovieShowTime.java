package model;
import java.util.ArrayList;
import java.time.LocalDate;
import java.time.LocalTime;

public class MovieShowTime {
	private Cinema cinema;
	private ArrayList<Booking> Bookings;
	LocalDate movieDate;
	LocalTime movieTime;
	boolean is3D = false;
	
	
	//Use either LocalTime.of(6,30) or LocalTime.parse("06:30") for local time
	//Use either LocalDate.of(2022,12,25) or LocalDate.parse("2022-12-25")
	public MovieShowTime(LocalDate showDate, LocalTime showTime) {
		this.movieDate = showDate;
		this.movieTime = showTime;
	}
	
	public MovieShowTime(Cinema cinema, LocalDate showDate, LocalTime showTime, boolean is3D) {
		this.cinema = cinema;
		this.movieDate = showDate;
		this.movieTime = showTime;
		this.Bookings = new ArrayList<Booking>();
		this.is3D = is3D;
	}
	
	public Cinema getCinema() {
		return cinema;
	}
	
	public boolean getIs3D() {
		return is3D;
	}
	
	public void setIs3D(boolean is3D) {
		this.is3D = is3D;
	}
	
	public LocalDate getMovieDate() {
		return movieDate;
	}
	
	public ArrayList<Booking> getBooking(){
		return Bookings;
	}
	
	public LocalTime getMovieTime() {
		return movieTime;
	}
	
	public void setCinema(Cinema cinema) {
		this.cinema = cinema;
	}
	
	public void setMovieTime(LocalTime movieTime) {
		this.movieTime = movieTime;
	}
	
	public void setMovieDate(LocalDate movieDate) {
		this.movieDate = movieDate;
	}
	
	
	
}
