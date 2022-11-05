package ui;

import java.util.Scanner;

import model.Movie;
import model.Review;

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
                + "2. Book ticket.\n"
                + "3. Rate and review.\n"
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
                    // TODO
                    // clarify how the seat layout is done (by movie or by cinema etc and how about timing)
                    // display price and ask to confirm or go back
                    // if confirm, record movie booking under current CustomerAccount
                    break;
                case 3:
                    System.out.println("Input your rating out of 5:\n");
                    int rating = sc.nextInt();
                    System.out.println("Input your review:\n");
                    String review = sc.next();
                    Review r = new Review(review, rating);
                    mov.addReview(r);
                    break; 
                case 4:
                    mC.user.displayMainUI();
                    repeat = false; 
                this.textDisplayUI();
                selection = sc.nextInt();
            }
        }while(repeat = true);
        
    }
    
    
}
