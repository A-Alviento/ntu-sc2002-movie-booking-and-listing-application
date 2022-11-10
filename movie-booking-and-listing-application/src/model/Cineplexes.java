package model;

public class Cineplexes extends Model{
	public static final long serialVersionUID = 85L;

	private String location;
	private int openingTime;
	private Cinema[] cinemaList;
	private int cineplexNum;
	
	public Cineplexes(String location, int openingTime, char id, CinemaClass type, int cineplexNum) {
	    cinemaList = new Cinema[3];
	    
		this.location = location;
		this.openingTime = openingTime;
		this.cineplexNum = cineplexNum;
		
		int cinemaCount = 0;
		for (char c = 'A'; c < 'D'; ++c) {
		    String s = new StringBuilder(Character.toString(id)).append(Character.toString(c)).toString();
		    this.cinemaList[cinemaCount] = new Cinema(s, type, cinemaCount, cineplexNum);
		    cinemaCount++;
		}
		    
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
	public int getCineplexNum() {
	    return this.cineplexNum;
	}
}
