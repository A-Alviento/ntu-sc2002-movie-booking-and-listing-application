/**
 * 
 */


public enum Censorship {
	G(0),
	PG(0),
	M18(18),
	R21(21);
	
	private int minAge;
	
	private Censorship(int age) {
		this.minAge = age;
	}
	
	public int getMinAge() {
		return minAge;
	}
	
}
