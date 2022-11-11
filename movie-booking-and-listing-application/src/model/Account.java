package model;

/**
 * An abstract class for account that both customer and an admin needs to login
 *
 */

public abstract class Account extends Model{
	/**
	 * The name of the account
	 */
	protected String name;
	
	/**
	 * The password of that account
	 */
	protected String password;

	/**
	 * A default constructor 
	 */
	public Account() {
		name = "Default Name";
		password = "password";
	}
	
	
	

	
}
