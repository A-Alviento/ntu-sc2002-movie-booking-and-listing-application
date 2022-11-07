package model;

public class Cinema extends Model{
	private int id;
	private int[][] seatLayout;
	private String cinemaClass;
	
	public Cinema() {
	}
	public Cinema(int id, int[][] seatLayout, String cinemaClass) {
		super();
		this.id = id;
		this.seatLayout = seatLayout;
		this.cinemaClass = cinemaClass;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int[][] getSeatLayout() {
		return seatLayout;
	}
	public void setSeatLayout(int[][] seatLayout) {
		this.seatLayout = seatLayout;
	}
	public String getCinemaClass() {
		return cinemaClass;
	}
	public void setCinemaClass(String cinemaClass) {
		this.cinemaClass = cinemaClass;
	}
	
//	public void checkAvailability(int row, int col) {
//		if (seatLayout[row][col]==0)
//			System.out.println("Seat Available!");
//		else System.out.println("Seat Not Available!");
//	}
	
	public void printLayout() {
		for (int[] i : seatLayout) {
			for (int j : i) {
				if (j==0)
					System.out.print("0 ");
				else
					System.out.print("1 ");
			}
			System.out.println();	
		}
		
	}	
	
	public static void main(String args[]) 
	{
		int[][] y = new int[][] {{1,2},{4,5},{1,0},{4,0,7,2},{4,0,0,2}};	
		Cinema x2 = new Cinema(1001, y,"Cinema1");
		x2.printLayout();
	}
}
