package model;

/*
 * Represent a review that a customer can make
 */
public class Review extends Model{
	/*
	 * Comment about a movie that the customer wrote
	 */
	private String comment;
	/*
	 * Rating given by the customer
	 */
	private int rating;
	
	/*
	 * Creates the review of the customer
	 * @param comment Comment written by customer
	 * @param rating Rating given by customer
	 */
	public Review(String comment, int rating){
		this.comment = comment;
		this.rating = rating;
	}
	
	/*
	 *  Get comment of a review
	 *  @return review's comment
	 */
	public String getComment() {
		return comment;
	}
	/*
	 * Get rating of a review
	 * @return rating review's rating
	 */
	public int getRating() {
		return rating;
	}
}
