package model;

public class MovieShowing extends Model{
	public static final long serialVersionUID = 23L;

	private int timing;
	/**
	 * @param numofMovies Number of movies at a certain timing
	 */
	private int numofMovies;
	Movie[] movieList;
	
	public MovieShowing(int timing, int numofMovies) {
		this.timing = timing;
		movieList = new Movie[numofMovies];
	}
	
	public int getTiming() {
		return timing;
	}
	public void setTiming(int timing) {
		this.timing = timing;
	}
	public int getNumofMovies() {
		return numofMovies;
	}
}
