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
                + "2. View reviews.\n"
                + "3. Book ticket.\n"
                + "4. Rate and review.\n"
                + "5. Back.");
        System.out.println("**************************************************************************************************");
        System.out.println("**************************************************************************************************");
        System.out.println("\nPlease choose an option from the menu:");
    }
    
    /*
     * This method uses textDisplayUI to print movie 
     * options for users and process user input
     * 
     */
    public boolean displayMovieUI() {
        
        boolean repeat = true;
        int selection;

        Movie mov = mC.currMov;
        
        do {
            
            this.textDisplayUI();
            selection = sc.nextInt();
            
            while (selection < 1 || selection >5) {
                System.out.println("Please choose from the options\n");
                selection = sc.nextInt();
                
            }
            switch(selection) {
                
                case 1:
                    System.out.println("Title: " + mov.getTitle());
                    System.out.println("Status: " + mov.getMovieStatus());
                    System.out.println("Parental Guidance: " + mov.getCensorship());
                    System.out.println("Synopsis: " + mov.getSynopsis());
                    System.out.println("Director: " + mov.getDirector());
                    System.out.println("Cast: " + mov.getCasts());
                    System.out.println("Rating: " + mov.getRating());
                    System.out.println("Reviews: " + mov.getReviews());
                    break;
                    
                case 2:
                    int len = mov.getReviews().size();
                    
                    for (int i = 0; i < len; i++) {
                        System.out.println("Review " + i + ": " + mov.getReviews().get(i));
                        System.out.println("--------------------------------------------------------------------------------------------------");
                    }
                    break;
                    
                case 3:
                    /*
                     * TODO:
                     * ASK USER TO SELECT A CINEMA FROM THE CURRENT CINEPLEX. FROM THERE, ACCESS 
                     * CURRMOVIE AND EXTRACT MOVIE SHOWING (DATE + TIMING) FOR THAT PARTICULAR
                     * CINEPLEX AND CINEMA; THEN ASK USER TO SELECT A SLOT
                     * 
                     * ONCE SELECTED, SHOW SEATLAYOUT AND ASK USER TO SELECT SEAT
                     * 
                     * PROCEED TO PAYMENT
                     * 
                     * RECORD THE BOOKING TO THE CURRCUSTOMER OBJECT
                     * 
                     * 
                     * CONFUSION: MOVIE SHOULD HAVE ASSOCIATION TO MOVIESHOWING AND MOVIESHOWING IS MISSING DATE
                     * 
                     */
                    break;
                    
                case 4:
                    System.out.println("Input your rating out of 5:\n");
                    int rating = sc.nextInt();
                    System.out.println("Input your review:\n");
                    String review = sc.next();
                    Review r = new Review(review, rating);
                    mov.addReview(r);
                    break; 
                    
                case 5:
                    if(!mC.user.displayMainUI())
                        return false;
            }
        }while(repeat = true);
        
        return true;
    }
    
}
