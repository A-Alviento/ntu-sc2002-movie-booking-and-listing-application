package ui;

import java.util.Scanner;

/*
 * This represents the CineplexUI component for user to 
 * choose which cineplex to go to
 * 
 */


public class CineplexUI {
    
    static Scanner sc = new Scanner(System.in);
    
    /*
     * List of cineplexes and their opening time
     * 
     */
    private static final String[][] arr = { {"Cineplex 1", "9"}, {"Cineplex 2", "10"},
                                            {"Cineplex 3", "11"} };
    

    private MainController mC;
    
    public void setMainController(MainController mC) {
        
        this.mC = mC;
    }
    
    /*
     * This method prints the Cineplex options and 
     * process user input
     * 
     */
    public boolean displayCineplexUI() {
        
        int selection;
        
        System.out.println("**************************************************************************************************");
        System.out.println("1. Cineplex 1\n"
                + "2. Cineplex 2\n"
                + "3. Cineplex 3\n"
                + "4. logout.");
        System.out.println("**************************************************************************************************");
        System.out.println("**************************************************************************************************");
        System.out.println("\nPlease choose a cineplex");
        selection = sc.nextInt();
        
        while (selection < 1 || selection > 4) {
            System.out.println("Please choose from the options\n");
            selection = sc.nextInt();
        }
        if (selection == 4)
            return false;
                   
        mC.currCineplex = mC.cinPlex.get(selection-1);
        return true;
    }
    
}