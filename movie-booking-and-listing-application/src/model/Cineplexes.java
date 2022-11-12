package model;

/**
 * Represent the cineplex.
 */
public class Cineplexes extends Model{
	public static final long serialVersionUID = 85L;

	private String location;
	private int openingTime;
	private Cinema[] cinemaList;
	private int i = 0;		// iterator for cinemaList
	private int cineplexNum;
	
	public Cineplexes(String location, int openingTime, int cineplexNum) {
	    cinemaList = new Cinema[3];
	    
		this.location = location;
		this.openingTime = openingTime;
		this.cineplexNum = cineplexNum;

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

	public void addCinema(Cinema c){
		this.cinemaList[i++] = c;
	}
	public Cinema[] getCinema() {
	    return this.cinemaList;
	}
	public int getCineplexNum() {
	    return this.cineplexNum;
	}
}
