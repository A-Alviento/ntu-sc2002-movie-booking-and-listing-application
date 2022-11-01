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
	private ArrayList<Integer> ratings;
	
	//Movie Review
	private ArrayList<String> reviews;
	
	//Movie status
	private MovieStatus movieStatus;
	
	// All 7 setters
	public Movie(String title) {
		this.title = title;
		this.reviews = new ArrayList<String>();
		this.casts = new ArrayList<String>();
		this.ratings = new ArrayList<Integer>();
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
	public void addReview(String review) {
		this.reviews.add(0, review);
	}
	

	// Add Rating to movie
	public void addRating(int rating) {
		if (rating < 1 || rating >5 ) {
			System.out.println("Rating is out of scope");
			return;
		}
		this.ratings.add(0, rating);
	}
	

	
	public void addCast(String cast) {
		this.casts.add(0,cast);
	}
	// Calculate the rating that is to be shown on UI
	private double calculateRating() {
		int count = ratings.size();
		
		if(count == 0) return -1.0;
		
		double totalRating = 0.0;
		for(int i = 0; i < count; i++) {
			totalRating += ratings.get(i);
		}
		
		return totalRating/count;
	}
	
	
	// Rating that will be shown on UI
	public String getRating() {
		double calculatedRating = this.calculateRating();
		if(calculatedRating == -1.0) {
			return "NA"; 
		}else {
			return String.format("%.1f", calculatedRating);
		}
	}
	

	
	public ArrayList<String> getReviews() {
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
