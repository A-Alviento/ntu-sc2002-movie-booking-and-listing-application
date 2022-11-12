package model;
/**
 * Cinema class represents a cinema to be stored in a database
 */
public class Cinema extends Model {
	public static final long serialVersionUID = 26L;

	private String cinemaID;
	private int[][] seatLayout;
	private CinemaClass cinemaType;
	private int cinemaHall;
	private int cineplexNum;
	
	/**
	 * Constructor for Cinema class
	 */
	public Cinema(String id, CinemaClass type, int cinemaHall, int cineplexNum) {
		this.cinemaID = id;
		this.cinemaType = type;
		this.cinemaHall = cinemaHall;
		this.cineplexNum = cineplexNum;
		
		this.seatLayout = new int[9][9];
		
		for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (j == 4)
                    seatLayout[i][j] = 0;
                else
                    seatLayout[i][j] = 1;
            }
        }
	}
	/**
	 * Getter for cinema id
	 */
	public String getCinemaCode() {
		return cinemaID;
	}
	/**
	 * Setter for cinema id
	 */
	public void setCinemaCode(String id) {
		this.cinemaID = id;
	}
	/**
	 * Getter for seat layout
	 */
	public int[][] getSeatLayout() {
		return seatLayout;
	}
	/**
	 * Setter for cinema code
	 */
	public void setSeatLayout(int[][] seatLayout) {
		this.seatLayout = seatLayout;
	}
	/**
	 * Getter for cinema type
	 */
	public CinemaClass getCinemaClass() {
		return cinemaType;
	}
	/**
	 * Setter for cinema type
	 */
	public void setCinemaClass(CinemaClass type) {
		this.cinemaType = type;
	}
	/**
	 * Getter for cinema hall
	 */
	public int getCinemaHall() {
	    return this.cinemaHall;
	}
	/**
	 * Setter for cinema type
	 */
	public int getCineplexNum() {
	    return this.cineplexNum;
	}
//	public String getCinemaClass() {
//		return cinemaClass;
//	}
//	public void setCinemaType(String cinemaClass) {
//		switch(cinemaClass) {
//			case("Bronze"): cinemaType = CinemaClass.BRONZE;break;
//			case("Silver"): cinemaType = CinemaClass.SILVER;break;
//			case("Gold"): cinemaType = CinemaClass.GOLD;break;
//			default: System.out.println("You have entered an invalid cinema Class.");break;
//		}
//	}
	

}
