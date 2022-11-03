/**
 *  Represents 4 different movie status a movie can have. 
 */
public enum MovieStatus {
	COMING_SOON("Coming Soon"),
	NOW_SHOWING("Now Showing"),
	PREVIEW("Preview"),
	END_OF_SHOWING("End of Showing");
	
	private String movieStatus;
	/*
	 * Create the movie status of a movie
	 * @param movieStatus the movie's status
	 */
	private MovieStatus(String movieStatus){
		this.movieStatus = movieStatus;
	}
	
	
	/*
	 * To format the constants into a string
	 * @return movie's status
	 */
	@Override
	public String toString() {
		return movieStatus;
	}
						
}
