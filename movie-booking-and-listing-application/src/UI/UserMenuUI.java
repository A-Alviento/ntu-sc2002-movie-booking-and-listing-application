package UI;

import java.util.Scanner;

public class UserMenuUI {
    
    static Scanner sc = new Scanner(System.in);
    private MainController mC;
    
    public void displayMainUI() {
        int selection;
        
        do {
            // list out main menu selection UI
            System.out.println("**************************************************************************************************");
            System.out.println("1. List movies.\n"
                    + "2. Search for a specific movie.\n"
                    + "3. View booking history \n"
                    + "4. List top 5 ranking by sales"
                    + "5. List top 5 ranking by ratings"
                    + "6. Logout.");
            System.out.println("**************************************************************************************************");
            System.out.println("**************************************************************************************************");
            System.out.println("\nPlease choose an option from the menu:");
            selection = sc.nextInt();
        }while(mC.User(selection) == -1); 
        
    }
    
}