package ui;

import java.util.Scanner;

public class LoginUI {
    
    
    static Scanner sc = new Scanner(System.in);
    private MainController mC;
    
    public void displayLoginUI() {
        // type specifies if user logging in is 
        // movie goer (0) or cinema staff (1)
        int type;
        System.out.println("MOBLIMA\n");
        
        do {
            System.out.println("**************************************************************************************************");
            System.out.println("1. User\n"
                    + "2. Admin\n"
                    + "3. Quit.");
            System.out.println("**************************************************************************************************");
            System.out.println("**************************************************************************************************");
            System.out.println("\nPlease choose an option:");
            type = sc.nextInt();
        }while(mC.login(type) == -1);
    }
    
    
}
