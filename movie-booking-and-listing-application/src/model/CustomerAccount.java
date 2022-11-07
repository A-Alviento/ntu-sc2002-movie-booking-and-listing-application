package model;


/**
 * Represents a customer Account stored in the db
 */
import java.util.Scanner;
//import java.time.LocalDate;


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
	 * Default constructor for a customer account
	 */
	public CustomerAccount() {
		name = "Default Name";
		email = "default Email";
		phoneNum = "69696969";
	}
	
	/*
	 * Creating a Customer account by asking for their name, number, email, age and password.
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


	

}
