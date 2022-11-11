package model;
/**
 * Represents a customer Account stored in the db
 */
import java.util.Scanner;
import java.util.ArrayList;


public class CustomerAccount extends Account {
	public static final long serialVersionUID = 73L;
	/*
	 * Name and password variables to be inherited from Account class
	 */
	
	/*
	 * Cusomter's email 
	 */
	private String email;
	/*
	 * Customer's phone number
	 */
	private String phoneNum;
	/*
	 * Customer's age
	 */
	private int age;
	/*
	 * Cusotmer's list of past bookings
	 */
	private ArrayList<Booking> bookingList;
	
	/*
	 * Default constructor for a customer account
	 */
	public CustomerAccount() {
		name = "Default Name";
		email = "default Email";
		phoneNum = "69696969";
		bookingList = new ArrayList<Booking>();
	}
	
	public CustomerAccount(String name, String email, String phoneNum, String password, int age ) {
		this.name = name;
		this.email = email;
		this.phoneNum = phoneNum;
		this.password = password;
		this.age = age;
		bookingList = new ArrayList<Booking>();
	}
	
	/*
	 * Creating a Customer account by asking for their name, number, email, age and password.
	 * To be depreciated once its not used.
	 */
	public void createAccount() {
		Scanner sc = new Scanner(System.in) ;
		System.out.print("Enter your name: ");
		name = sc.nextLine();
		System.out.print("Enter phone number: ");
		phoneNum = sc.next();
		System.out.print("Enter your email: ");
		email = sc.next();
		System.out.print("Enter your age: ");
		age = sc.nextInt();
		System.out.print("Enter your password: ");
		password = sc.next();
		sc.close();
		
	}
	
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
	/*
	 * Get phone number of the account
	 * @return customer's phone number
	 */
	public String getPhoneNum() {
		return phoneNum;
	}
	
	/*
	 * Get phone name of the account
	 * @return customer's name
	 */
	public String getName() {
		return name;
	}
	
	/*
	 * Get email of the account
	 * @return customer's email
	 */
	public String getEmail() {
		return email;
	}
	
	/*
	 * Get password of the account
	 * @return customer's password
	 */
	public String getPassword() {
		return password;
	}
	
	/*
	 * Get age of the account
	 * @return customer's age
	 */
	public int getAge() {
		return age;
	}	
	
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setPassword(String pw) {
		password = pw;
	}
	

}
