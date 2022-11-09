package model;

public class Cineplexes extends Model{
	public static final long serialVersionUID = 85L;

	private String location;
	private int openingTime;
	private Cinema[] cinemaList;
	
	public Cineplexes() {
		Cinema[] cinemaList = new Cinema[3];
	}
	
	public Cineplexes(String location, int openingTime) {
		this.location = location;
		this.openingTime = openingTime;
		Cinema[] cinemaList = new Cinema[3];
	}
	
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public int getOpeningTime() {
		return openingTime;
	}
	public void setOpeningTime(int openingTime) {
		this.openingTime = openingTime;
	}
	public Cinema[] getCinema() {
	    return this.cinemaList;
	}
}
