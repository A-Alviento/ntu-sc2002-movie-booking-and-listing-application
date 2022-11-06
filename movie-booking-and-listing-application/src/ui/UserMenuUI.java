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
                + "6. back.");
        System.out.println("**************************************************************************************************");
        System.out.println("**************************************************************************************************");
        System.out.println("\nPlease choose an option from the menu:");
    }
    
    /*
     * This method uses textDisplayUI to print options and
     * process user input 
     * 
     */
    public boolean displayMainUI() {
        
        boolean repeat = true;
        int selection;
        
        do {
            
            this.textDisplayUI();
            selection = sc.nextInt();
            
            while (selection < 1 || selection > 6) {
                System.out.println("Please choose from the options\n");
                selection = sc.nextInt();
            }
            
            switch(selection){

                case 1:
                    /*
                     * TODO:
                     * FIRST LIST MOVIE USING MOVIE LIST FROM MAINCONTROLLER
                     * ASK FOR USER INPUT TO INDICATE SELECTED MOVIE
                     * COPY THE SELECTED MOVIE TO CURRMOV IN MAIN CONTROLLER
                     * GO TO MOVIEUI 
                     * 
                     */
                    if (!mC.movie.displayMovieUI()) {
                        return false;
                    }
                    
                    break;
                case 2:
                    /*
                     * TODO:
                     * FIRST TAKE INPUT OF MOVIE TITLE FROM USER
                     * FIND MATCHING MOVIE TITLE FROM MOVIE LIST IN MAINCONTROLLER
                     * IF MATCH FOUND, COPY TO CURRMOV AND GO TO MOVIEUI
                     * ELSE PROMPT USER TO TRY AGAIN
                     * 
                     */
                    if (!mC.movie.displayMovieUI()) {
                        return false;
                    }
                    
                    break;
                case 3:
                    /*
                     * TODO:
                     * SIMPLY EXTRACT FROM THE CURRUSER IN MAINCONTROLLER AND PRINT OUT
                     * 
                     */
                    break;
                case 4:
                    /*
                     * TODO:
                     * FROM THE MOVIE LIST, SORT IN DESCENDING ORDER
                     * ACCORDING TO SALES, THEN EXTRACT AND PRINT 
                     * FIRST 5 ELEMENTS
                     * 
                     */
                    break;
                case 5:
                    /*
                     * TODO:
                     * FROM THE MOVIE LIST, SORT IN DESCENDING ORDER
                     * ACCORDING TO RATING, THEN EXTRACT AND PRINT 
                     * FIRST 5 ELEMENTS
                     * 
                     */
                    break;
                case 6:
                    if(!mC.cineplex.displayCineplexUI())
                        return false;
            }     
        }while(repeat = true);    
        
        return true;
    }
}