
public enum MovieStatus {
	COMING_SOON("Coming Soon"),
	NOW_SHOWING("Now Showing"),
	PREVIEW("Preview");
	
	private String movieStatus;
	private MovieStatus(String movieStatus){
		this.movieStatus = movieStatus;
	}
	
	@Override
	public String toString() {
		return movieStatus;
	}
						
}
