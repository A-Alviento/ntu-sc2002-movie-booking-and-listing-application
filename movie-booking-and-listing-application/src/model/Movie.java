package model;
/**
 * Represents a movie in the database. 
 * Each movie has 10 attributes: title, director, casts (array), reviews (array), synopsis, 
 * 							    rating, movieStatus (enum), censorship (enum), isBlockbuster (bool),
 * 								ticketSale and ShowTimes(array).
 * 
 */
import java.util.ArrayList;
import java.time.LocalDateTime;
import java.util.Iterator;


public class Movie extends Model{
	public static final long serialVersionUID = 67L;
	/**
	 * Movie Title
	 */
	private String title = "";
	
	/**
	 * Movie director
	 */
	private String director = "";
	
	/**
	 * Movie Casts: Use ArrayList as length of Array can be dynamically changed.
	 */
	private ArrayList<String> casts;
	
	/**
	 * Movie Synopsis
	 */
	private String synopsis = "";
	
	/**
	 * Movie rating
	 */
	private double rating = -1.0;
	
	/**
	 * Movie Review
	 */
	private ArrayList<Review> reviews;
	
	/**
	 * Movie status
	 */
	private MovieStatus movieStatus;
	
	/**
	 * Movie Censorship
	 */
	private Censorship censorship;
	
	/**
	 * Whether a movie is a blockbuster
	 */
	private boolean isBlockbuster = false;
	
	/**
	 * Number of ticket sales the movie has made
	 */
	private int ticketSale = 0;
	/**
	 * List of when movie is shown
	 */
	private ArrayList<MovieShowTime> movieShowTimes = new ArrayList<MovieShowTime>();
	
	
	
	
	
	/**
	 * Creates a new Movie with a title
	 * Also, creates a empty array for the reviews and casts for that movie.
	 * @param title The movie's title
	 */
	public Movie(String title) {
		this.title = title;
		this.reviews = new ArrayList<Review>();
		this.casts = new ArrayList<String>();
	}
	/**
	 * Gets the ticketSale
	 * @return ticketSale number of tickets sold by the movie
	 */
	public int getTicketSale() {
		return ticketSale;
	}
	
	/**
	 * Increment the ticketSale by 1 whenever a new sale is made
	 */
	public void incTicketSale() {
		ticketSale++;
	}
	
	/**
	 * Sets the movie's censorship
	 * @param censorship Movie's censorship
	 */
	public void setCensorship(Censorship censorship) {
		this.censorship = censorship;
	}
	
	/**
	 * Sets the movie's director
	 * @param director Movie's director
	 */
	public void setDirector(String director) {
		this.director = director;
	}
	
	/**
	 * Change the movie's title (if error in keying)
	 * @param title Movie's title
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	
	/**
	 * Sets the movie's casts
	 * @param ArrayList<String> casts : Movie's list of casts
	 */
	public void setCasts(ArrayList<String> casts) {
		this.casts = casts;
	}
	
	/**
	 * Sets the movie's synopsis
	 * @param director Movie's synopsis
	 */
	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}
	
	/**
	 * Sets the movie's status
	 * @param movieStatus Movie's Status
	 */
	public void setMovieStatus(MovieStatus movieStatus) {
		this.movieStatus = movieStatus;
	}
	
	/**
	 * Sets if movie is a blockbuster
	 * @param boolean that indicator if movie is a blockbuster
	 */
	public void setBlockbuster(boolean isBlockbuster) {
		this.isBlockbuster = isBlockbuster;
	}
	/**
	 * Add reviews to the movie by customers
	 * @param review : Movie's review by customers
	 */
	public void addReview(String s, int n) {
		Review review = new Review(s, n);
	    this.reviews.add(0, review);
	}

	/**
	 * Add a member of the cast to the movie
	 * @param cast  A cast of the movie
	 */
	public void addCast(String cast) {
		this.casts.add(0,cast);
	}
	
	/**
	 *  Updates the rating in the movie class
	 */
	public void updateRating() {
		int count = reviews.size();
		
		if(count == 0) rating = -1.0;
		
		double totalRating = 0.0;
		for(int i = 0; i < count; i++) {
			totalRating += reviews.get(i).getRating();
		}
		
		rating = totalRating/count;
	}
	
	
	/**
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
	

	/**
	 * Gets the reviews of the movie in an array
	 * @return Array of the reviews of the movie
	 */
	public ArrayList<Review> getReviews() {
		return this.reviews;
	}
	
	/**
	 * Gets the casts of the movie
	 * @return Array of the casts of the movie
	 */
	public ArrayList<String> getCasts(){
		return this.casts;
	}
	
	/**
	 * Gets the director of the movie
	 * @return movie's director
	 */
	public String getDirector() {
		return this.director;
	}
	
	/**
	 * Gets the title of the movie
	 * @return movie's title
	 */
	public String getTitle() {
		return this.title;
	}
	
	/**
	 * Gets the censorship of the movie
	 * @return movie's censorship 
	 */
	public Censorship getCensorship() {
		return this.censorship;
	}
	
	/**
	 * Gets the movie Status of the movie
	 * @return movie's movieStatus 
	 */
	public MovieStatus getMovieStatus() {
		return this.movieStatus;
	}
	
	/**
	 * Gets the synopsis of the movie
	 * @return movie's synopsis
	 */
	public String getSynopsis() {
		return this.synopsis;
	}

	/**
	 * Get whether movie is a blockbuster
	 * @return boolean which indicate blockbuster or not
	 */
	public boolean isBlockbuster() {
		return isBlockbuster;
	}
	/**
	 * Get list of when movie is shown to be displayed to user
	 * @return movieShowTimes
	 */
	public ArrayList<MovieShowTime> getMovieShowTimes() {
		return movieShowTimes;
	}
	/**
	 * Set movieShowTime
	 * @param ArrayList of movieShowTimes
	 */
	public void setMovieShowTimes(ArrayList<MovieShowTime> movieShowTimes) {
		this.movieShowTimes = movieShowTimes;
	}
	/**
	 * Automatically delete movies if their showTime has passed the current time and date
	 */
	private void updateMovieShowTime() {
		Iterator <MovieShowTime> itr = movieShowTimes.iterator();
		while(itr.hasNext()) {
			MovieShowTime movieShowTime = itr.next();
			LocalDateTime movieTime = LocalDateTime.of(movieShowTime.getMovieDate(), movieShowTime.getMovieTime() );
			LocalDateTime current = LocalDateTime.now();
			if(movieTime.isBefore(current)) {
				itr.remove();
			}
		}
	}
	
	/**
	 * Add when movieShowTime into the array and automatically remove movie screening pasted the current date and time
	 */
	public void addMovieShowTime(MovieShowTime movieShowTime) {
		this.movieShowTimes.add(0,movieShowTime);
		updateMovieShowTime();
	}

}

