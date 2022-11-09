package ui;

import java.util.Scanner;

/*
 * This represents login UI component for user to login 
 * as user or as admin
 * 
 */
public class LoginUI {
    
    
    static Scanner sc = new Scanner(System.in);
    private MainController mC;
    
    public LoginUI(MainController mC) {
        
        this.mC = mC;
    }
    
    /*
     * display the login UI and process user input
     * 
     */
    public void displayLoginUI() {
        
        int selection;
        System.out.println("MOBLIMA\n");
        
        do {
            System.out.println("**************************************************************************************************");
            System.out.println("1. User Login\n"
                    + "2. User Signup\n"
                    + "3. Guest\n"
                    + "4. Admin Login\n"
                    + "5. Quit.");
            System.out.println("**************************************************************************************************");
            System.out.println("**************************************************************************************************");
            System.out.println("\nPlease choose an option:");
            selection = sc.nextInt();
        }while(mC.login(selection) == -1);
    }
}
