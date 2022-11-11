package model;
/**
 * Represents a customer Account stored in the db
 */
import java.util.Scanner;
import java.util.ArrayList;


public class CustomerAccount extends Account {
    
	public static final long serialVersionUID = 73L;
	/**
	 * Name and password variables to be inherited from Account class
	 */
	
	/**
	 * Cusomter's email 
	 */
	private String email;
	/**
	 * Customer's phone number
	 */
	private String phoneNum;
	/**
	 * Customer's age
	 */
	private int age;
	/**
	 * Cusotmer's list of past bookings
	 */
	private ArrayList<Booking> bookingList;
	
	/**
	 * Default constructor for a customer account
	 */
	public CustomerAccount() {
		name = "Default Name";
		email = "default Email";
		phoneNum = "69696969";
		bookingList = new ArrayList<Booking>();
	}
	/**
	 *  constructor for a customer account
	 */
	public CustomerAccount(String name, String email, String phoneNum, String password, int age ) {
		this.name = name;
		this.email = email;
		this.phoneNum = phoneNum;
		this.password = password;
		this.age = age;
		bookingList = new ArrayList<Booking>();
	}
	
	/**
	* Setter for customer Name
	*/ 
	
	public void setName(String name) {
		this.name = name;
	}
	

	public void addBooking(int[] seat, double price, String movieTitle, String cinemaCode, Cinema cinema) {
		Booking temp = new Booking( seat,  price,  movieTitle,  cinemaCode, cinema);
		this.bookingList.add(0, temp);
	}
	
	public ArrayList<Booking> getBookingList() {
		return this.bookingList;
	}
	/**
	 * Get phone number of the account
	 * @return customer's phone number
	 */
	public String getPhoneNum() {
		return phoneNum;
	}
	
	/**
	 * Get phone name of the account
	 * @return customer's name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Get email of the account
	 * @return customer's email
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * Get password of the account
	 * @return customer's password
	 */
	public String getPassword() {
		return password;
	}
	
	/**
	 * Get age of the account
	 * @return customer's age
	 */
	public int getAge() {
		return age;
	}	
	/**
	* Setter for customer phone number
	*/
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	/**
	* Setter for customer age
	*/
	public void setAge(int age) {
		this.age = age;
	}
	/**
	* Setter for customer email
	*/
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	* Setter for customer password
	*/
	public void setPassword(String pw) {
		password = pw;
	}
	

}
