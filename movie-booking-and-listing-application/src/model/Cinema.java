package model;
public class Cinema extends Model {
	public static final long serialVersionUID = 26L;

	private String cinemaID;
	private int[][] seatLayout;
	private CinemaClass cinemaType;
	
	public Cinema(String id, CinemaClass type) {
		this.cinemaID = id;
		this.cinemaType = type;
		
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
	
	public String getCinemaCode() {
		return cinemaID;
	}
	public void setCinemaCode(String id) {
		this.cinemaID = id;
	}
	public int[][] getSeatLayout() {
		return seatLayout;
	}
	public void setSeatLayout(int[][] seatLayout) {
		this.seatLayout = seatLayout;
	}
	
	public CinemaClass getCinemaClass() {
		return cinemaType;
	}
	
	public void setCinemaClass(CinemaClass type) {
		this.cinemaType = type;
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
