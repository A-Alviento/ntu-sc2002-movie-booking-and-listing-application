package model;

public class Booking extends Model{
	public static final long serialVersionUID = 80L;
	/**
	 * @param seat An integer array with 2 elements
	 * seat[0] - row number; seat[1] - column number; 
	 */
	private int[] seat;
	private int price;
	private int bookingDate;

	public Booking(int[] seat, int price, int bookingDate) {
		this.seat = seat;
		this.price = price;
		this.bookingDate = bookingDate;
	}
	
	public void checkAvailability(int[][] Layout, int row, int col) {
		if (Layout[row][col]==0)
			System.out.println("Seat Available!");
		else System.out.println("Seat Not Available!");
	}

	public int[] getSeat() {
		return seat;
	}

	public void setSeat(int[] seat) {
		this.seat = seat;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(int bookingDate) {
		this.bookingDate = bookingDate;
	}
}