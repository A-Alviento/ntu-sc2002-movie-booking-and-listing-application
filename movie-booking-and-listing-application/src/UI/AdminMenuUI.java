package ui;

import java.util.Scanner;

public class AdminMenuUI {
    
    static Scanner sc = new Scanner(System.in);
    private MainController mC;
    
    public void displayAdminUI() {
        int selection;
        
        do {
            // list out main menu selection UI
            System.out.println("**************************************************************************************************");
            System.out.println("1. Create Movie Listing.\n"
                    + "2. Update/Remove Movie Listing.\n"
                    + "3. Create Cinema Showtime.\n"
                    + "4. Update/Remove Cinema Showtime.\n"
                    + "5. Configure system settings.\n"
                    + "6. Logout.");
            System.out.println("**************************************************************************************************");
            System.out.println("**************************************************************************************************");
            System.out.println("\nPlease choose an option from the menu:");
            selection = sc.nextInt();
        }while(mC.Admin(selection) == -1); 
        
    }
    
}