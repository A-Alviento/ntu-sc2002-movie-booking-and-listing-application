

public abstract class Account {
	protected String name;
	protected String email;
	protected String password;

	
	public Account() {
		name = "Default Name";
		email = "default Email";
		password = "password";
	}
	
	public abstract void createAccount() ;
//		System.out.println("Enter your name: ");
//		name = sc.next();
//		System.out.println("Enter your email: ");
//		email = sc.next();
//		System.out.println("Enter your age: ");
//		age = sc.nextInt();
//		System.out.println("Enter your password: ");
//		password = sc.next();
//		
	

	
}
