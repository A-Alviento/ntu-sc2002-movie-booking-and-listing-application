package ui;

import java.util.Scanner;

/*
 * This represents app entry UI component for user to 
 * begin using the app
 * 
 */
public class AppEntryUI {
    
    
    static Scanner sc = new Scanner(System.in);
    private MainController mC;
    private int selection;
    
    public AppEntryUI(MainController mC) {
        
        this.mC = mC;
    }
    
    /*
     * display the login UI and process user input
     * 
     */
    public void displayLoginUI() {
        
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
            System.out.println();
            selection = CheckUserInput.loopUntilValidInt("Please choose an option: ", 1, 5);
            sc.nextLine();
        }while(mC.login(selection) == -1);
    }
}
