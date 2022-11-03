/**
 * An abstract class for account that both customer and an admin needs to login
 *
 */

public abstract class Account extends Model{
	/*
	 * The name of the account
	 */
	protected String name;
	
	/*
	 * The password of that account
	 */
	protected String password;

	/*
	 * A default constructor 
	 */
	public Account() {
		name = "Default Name";
		password = "password";
	}
	
	/*
	 * An abstract method to be implemented by child classes to create their account.  
	 */
	public abstract void createAccount() ;
//		System.out.println("Enter your name: ");
//		name = sc.next();
//		System.out.println("Enter your email: ");
//		email = sc.next();
//		System.out.println("Enter your age: ");
//		age = sc.nextInt();
//		System.out.println("Enter your password: ");
//		password = sc.next();		
	

	
}
