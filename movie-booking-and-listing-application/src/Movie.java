import java.util.ArrayList;

public class Movie {
	// Movie title
	private String title = "";
	
	//Movie director
	private String director = "";
	
	//Movie Casts: Use ArrayList as length of Array can be dynamically changed.
	private ArrayList<String> casts;
	
	//Movie Synopsis
	private String synopsis = "";
	
	//Movie rating
	private double rating = -1.0;
	
	//Movie Review
	private ArrayList<Review> reviews;
	
	//Movie status
	private MovieStatus movieStatus;
	
	// All 7 setters
	public Movie(String title) {
		this.title = title;
		this.reviews = new ArrayList<Review>();
		this.casts = new ArrayList<String>();
	}
	
	public void setDirector(String director) {
		this.director = director;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public void setCasts(ArrayList<String> casts) {
		this.casts = casts;
	}
	
	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}
	
	public void setMovieStatus(MovieStatus movieStatus) {
		this.movieStatus = movieStatus;
	}
	

	//Add reviews to movie
	public void addReview(Review review) {
		this.reviews.add(0, review);
	}

	public void addCast(String cast) {
		this.casts.add(0,cast);
	}
	// Calculate the rating that is to be shown on UI
	private void updateRating() {
		int count = reviews.size();
		
		if(count == 0) rating = -1.0;
		
		double totalRating = 0.0;
		for(int i = 0; i < count; i++) {
			totalRating += reviews.get(i).getRating();
		}
		
		rating = totalRating/count;
	}
	
	
	// Rating that will be shown on UI
	public String getRating() {
		this.updateRating();
		if(rating == -1.0) {
			return "NA"; 
		}else {
			return String.format("%.1f", rating);
		}
	}
	

	
	public ArrayList<Review> getReviews() {
		return this.reviews;
	}
	
	public ArrayList<String> getCasts(){
		return this.casts;
	}
	
	public String getDirector() {
		return this.director;
	}
	
	public String getTitle() {
		return this.title;
	}
	

	
	public MovieStatus getMovieStatus() {
		return this.movieStatus;
	}
	
	public String getSynopsis() {
		return this.synopsis;
	}
}
