package model;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Represents a customer Account stored in the database.
 */
public class CustomerAccount extends Account {
    
	public static final long serialVersionUID = 73L;

	static Scanner sc = new Scanner(System.in);
	
	/**
	 * Customer's email 
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
	 * Customer's list of past bookings
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
	 *  Constructor for a customer account
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
	 * Creating a Customer account by asking for their name, number, email, age and password.
	 * To be depreciated once its not used.
	 */
	public void createAccount() {
		System.out.print("Enter your name: ");
		name = sc.nextLine();
		System.out.print("Enter phone number: ");
		phoneNum = sc.nextLine();
		System.out.print("Enter your email: ");
		email = sc.nextLine();
		System.out.print("Enter your age: ");
		age = sc.nextInt();  
		sc.nextLine();
		System.out.print("Enter your password: ");
		password = sc.nextLine();

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