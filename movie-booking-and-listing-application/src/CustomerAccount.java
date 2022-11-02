import java.util.Scanner;
import java.time.LocalDate;
/**
 * 
 */

public class CustomerAccount extends Account {
	//private Booking[] Bookings;
	private String phoneNum;
	private int age;
	Scanner sc = new Scanner(System.in) ;
	
	public CustomerAccount() {
		name = "Default Name";
		email = "default Email";
		phoneNum = "69696969";
	}
	
	public void createAccount() {
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
		
	}
	
	public String getPhoneNum() {
		return phoneNum;
	}
	
	public String getName() {
		return name;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public int getAge() {
		return age;
	}


	

}
