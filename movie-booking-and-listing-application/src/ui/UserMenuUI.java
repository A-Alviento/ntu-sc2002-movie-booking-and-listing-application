package ui;

import java.util.Scanner;

/*
 * This represents the menu for users after login
 * 
 */
public class UserMenuUI {
    
    static Scanner sc = new Scanner(System.in);
    private MainController mC;
    
    public void setMainController(MainController mC) {
        
        this.mC = mC;
    }
    
    /*
     * This method prints the options for users after login
     * 
     */
    public void textDisplayUI() {
        System.out.println("**************************************************************************************************");
        System.out.println("1. List movies.\n"
                + "2. Search for a specific movie.\n"
                + "3. View booking history \n"
                + "4. List top 5 ranking by sales"
                + "5. List top 5 ranking by ratings"
                + "6. logout.");
        System.out.println("**************************************************************************************************");
        System.out.println("**************************************************************************************************");
        System.out.println("\nPlease choose an option from the menu:");
    }
    
    /*
     * This method uses textDisplayUI to print options and
     * process user input 
     * 
     */
    public void displayMainUI() {
        
        boolean repeat = false;
        int selection;
        
        // list out main menu selection UI
        this.textDisplayUI();
        selection = sc.nextInt();
        
        while (selection < 1 || selection > 6) {
            System.out.println("Please choose from the options\n");
            selection = sc.nextInt();
        }
        
        do {
            switch(selection){
                case 1:
                    // TODO
                    // first we list the movie using the movie list from MainController
                    // then we ask for user input
                    // match that input to currMov in MainController and copy it
                    // go to MovieUI
                    // 
                    break;
                case 2:
                    // TODO
                    // first we take an input of movie title from user
                    // find any matching movie title from movie list in MainController
                    // If match found, match input to currMov go ot MovieUI
                    // If no match, try again
                    break;
                case 3:
                    // TODO
                    // Simply get from current customeraccount object
                    break;
                case 4:
                    // TODO
                    // print from movie list extracted from db
                    break;
                case 5:
                    // print from movie list extracted from db
                    break;
                case 6:
                    mC.cineplex.displayCineplexUI();
                    repeat = true;
                    this.textDisplayUI();
                    selection = sc.nextInt();
            }     
        }while(repeat = true);      
    }
}