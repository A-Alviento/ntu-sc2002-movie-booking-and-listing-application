package ui;

import java.util.Scanner;

public class MovieUI {
    
    static Scanner sc = new Scanner(System.in);
    private MainController mC;
    
    public void setMainController(MainController mC) {
        
        this.mC = mC;
    }
    
    public void displayMovieUI() {
        int selection;
        
        do {
            // list out main menu selection UI
            System.out.println("**************************************************************************************************");
            System.out.println("1. View details.\n"
                    + "2. Seat Availability.\n"
                    + "3. Book ticket.\n"
                    + "4. Back.");
            System.out.println("**************************************************************************************************");
            System.out.println("**************************************************************************************************");
            System.out.println("\nPlease choose an option from the menu:");
            selection = sc.nextInt();
        }while(mC.Movie(selection) == -1); 
        
    }
    
    
}
