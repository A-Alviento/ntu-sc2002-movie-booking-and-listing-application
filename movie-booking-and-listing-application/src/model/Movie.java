package model;

/*
 * Represents a movie in the database. 
 * Each movie has 9 attributes: title, director, casts (array), reviews (array), synopsis, 
 * 							    rating, movieStatus (enum), censorship (enum), isBlockbuster (bool)
 * 
 */
import java.util.ArrayList;

public class Movie extends Model {
	/*
	 * Movie Title
	 */
	private String title = "";
	
	/*
	 * Movie director
	 */
	private String director = "";
	
	/*
	 * Movie Casts: Use ArrayList as length of Array can be dynamically changed.
	 */
	private ArrayList<String> casts;
	
	/*
	 * Movie Synopsis
	 */
	private String synopsis = "";
	
	/*
	 * Movie rating
	 */
	private double rating = -1.0;
	
	/*
	 * Movie Review
	 */
	private ArrayList<Review> reviews;
	
	/*
	 * Movie status
	 */
	private MovieStatus movieStatus;
	
	/*
	 * Movie Censorship
	 */
	private Censorship censorship;
	
	/*
	 * Whether a movie is a blockbuster
	 */
	private boolean isBlockbuster = false;
	
	/*
	 * Creates a new Movie with a title
	 * Also, creates a empty array for the reviews and casts for that movie.
	 * @param title The movie's title
	 */
	public Movie(String title) {
		this.title = title;
		this.reviews = new ArrayList<Review>();
		this.casts = new ArrayList<String>();
	}
	
	/*
	 * Sets the movie's censorship
	 * @param censorship Movie's censorship
	 */
	public void setCensorship(Censorship censorship) {
		this.censorship = censorship;
	}
	
	/*
	 * Sets the movie's director
	 * @param director Movie's director
	 */
	public void setDirector(String director) {
		this.director = director;
	}
	
	/*
	 * Change the movie's title (if error in keying)
	 * @param title Movie's title
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	
	/*
	 * Sets the movie's casts
	 * @param ArrayList<String> casts : Movie's list of casts
	 */
	public void setCasts(ArrayList<String> casts) {
		this.casts = casts;
	}
	
	/*
	 * Sets the movie's synopsis
	 * @param director Movie's synopsis
	 */
	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}
	
	/*
	 * Sets the movie's status
	 * @param movieStatus Movie's Status
	 */
	public void setMovieStatus(MovieStatus movieStatus) {
		this.movieStatus = movieStatus;
	}
	
	/*
	 * Sets if movie is a blockbuster
	 * @param boolean that indicator if movie is a blockbuster
	 */
	public void setBlockbuster(boolean isBlockbuster) {
		this.isBlockbuster = isBlockbuster;
	}
	/*
	 * Add reviews to the movie by customers
	 * @param review : Movie's review by customers
	 */
	public void addReview(Review review) {
		this.reviews.add(0, review);
	}

	/*
	 * Add a member of the cast to the movie
	 * @param cast  A cast of the movie
	 */
	public void addCast(String cast) {
		this.casts.add(0,cast);
	}
	
	/*
	 *  Updates the rating in the movie class
	 */
	private void updateRating() {
		int count = reviews.size();
		
		if(count == 0) rating = -1.0;
		
		double totalRating = 0.0;
		for(int i = 0; i < count; i++) {
			totalRating += reviews.get(i).getRating();
		}
		
		rating = totalRating/count;
	}
	
	
	/*
	 *  Get the Rating of the movie in string format
	 *  @return A string with contains the rating of the movie
	 */
	public String getRating() {
		this.updateRating();
		if(rating == -1.0) {
			return "NA"; 
		}else {
			return String.format("%.1f", rating);
		}
	}
	

	/*
	 * Gets the reviews of the movie in an array
	 * @return Array of the reviews of the movie
	 */
	public ArrayList<Review> getReviews() {
		return this.reviews;
	}
	
	/*
	 * Gets the casts of the movie
	 * @return Array of the casts of the movie
	 */
	public ArrayList<String> getCasts(){
		return this.casts;
	}
	
	/*
	 * Gets the director of the movie
	 * @return movie's director
	 */
	public String getDirector() {
		return this.director;
	}
	
	/*
	 * Gets the title of the movie
	 * @return movie's title
	 */
	public String getTitle() {
		return this.title;
	}
	
	/*
	 * Gets the censorship of the movie
	 * @return movie's censorship 
	 */
	public Censorship getCensorship() {
		return this.censorship;
	}
	
	/*
	 * Gets the movie Status of the movie
	 * @return movie's movieStatus 
	 */
	public MovieStatus getMovieStatus() {
		return this.movieStatus;
	}
	
	/*
	 * Gets the synopsis of the movie
	 * @return movie's synopsis
	 */
	public String getSynopsis() {
		return this.synopsis;
	}

	/*
	 * Get whether movie is a blockbuster
	 * @return boolean which indicate blockbuster or not
	 */
	public boolean isBlockbuster() {
		return isBlockbuster;
	}


}
