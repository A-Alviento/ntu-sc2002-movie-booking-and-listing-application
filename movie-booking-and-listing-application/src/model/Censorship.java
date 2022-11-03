/**
 *  Represents the constants that is used by movie class to decide the movie's censorship 
 */

public enum Censorship {
	/*
	 * There is 4 different censorship for a movie:
	 * 		General (G) , Parental Guidance (PG) , Mature 18 (M18) and Restricted 21 (R21)
	 * Integer represents the minimum Age needed by the customer to watch that movie.
	 */
	G(0),
	PG(0),
	M18(18),
	R21(21);
	
	private int minAge;
	
	private Censorship(int age) {
		this.minAge = age;
	}
	
	/*
	 * @return the minimum Age needed for a customer to watch that movie. 
	 */
	public int getMinAge() {
		return minAge;
	}
	
}
