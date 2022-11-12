package model;

/**
 * An abstract class for account that both customer and an admin needs to login.
 */
public abstract class Account extends Model{
	/**
	 * The name of the account
	 */
	protected String name;
	
	/**
	 * The password of the account
	 */
	protected String password;

	/**
	 * Default constructor.
	 */
	public Account() {
		name = "Default Name";
		password = "password";
	}
}
