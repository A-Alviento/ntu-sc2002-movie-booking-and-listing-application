package ui;

import java.util.Scanner;

import model.Movie;

/*
 * This represents the movie options UI
 * 
 */
public class MovieUI {
    
    static Scanner sc = new Scanner(System.in);
    private MainController mC;
    
    public void setMainController(MainController mC) {
        
        this.mC = mC;
    }
    
    /*
     * This method prints the movie options
     * 
     */
    public void textDisplayUI() {
     // list out main menu selection UI
        System.out.println("**************************************************************************************************");
        System.out.println("1. View details.\n"
                + "2. Seat Availability.\n"
                + "3. Book ticket.\n"
                + "4. Back.");
        System.out.println("**************************************************************************************************");
        System.out.println("**************************************************************************************************");
        System.out.println("\nPlease choose an option from the menu:");
    }
    
    /*
     * This method uses textDisplayUI to print movie 
     * options for users and process user input
     * 
     */
    public void displayMovieUI(Movie mov) {
        
        boolean repeat = true;
        int selection;
        
        this.textDisplayUI();
        selection = sc.nextInt();
        
        while (selection < 1 || selection >4) {
            System.out.println("Please choose from the options\n");
            selection = sc.nextInt();
        }
        
        do {
            switch(selection) {
                case 1:
                    System.out.println(mov.getTitle());
                    System.out.println(mov.getMovieStatus());
                    System.out.println(mov.getCensorship());
                    System.out.println(mov.getSynopsis());
                    System.out.println(mov.getDirector());
                    System.out.println(mov.getCasts());
                    System.out.println(mov.getRating());
                    System.out.println(mov.getReviews());
                    break;
                case 2:
                    System.out.println();
                    break;
                case 3:
              
                    break;
                case 4:
                    mC.user.displayMainUI();
                    repeat = false; 
            }
        }while(repeat = true);
        
    }
    
    
}
