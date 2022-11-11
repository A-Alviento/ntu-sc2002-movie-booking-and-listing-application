package ui;

import java.util.Scanner;

/**
 * This represents the movie options UI
 * 
 */
public class MovieUI {
    
    static Scanner sc = new Scanner(System.in);
    private MainController mC;
    private MovieController movCont;
    private BookingManager bookMan;
    
    public MovieUI(MainController mC) {
        
        this.mC = mC;
        this.movCont = new MovieController(this.mC);
        this.bookMan = new BookingManager(this.mC);
    }
    
    /**
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
    
    /**
     * This method uses textDisplayUI to print movie 
     * options for users and process user input
     * 
     */
    public boolean displayMovieUI() {
        
        int selection;
        
        while(true) {
            
            this.textDisplayUI();
            selection = sc.nextInt();
            sc.nextLine();
            
            while (selection < 1 || selection >5) {
                System.out.println("Please choose from the options\n");
                selection = sc.nextInt();
                sc.nextLine();
                
            }
            switch(selection) {
                
                case 1:
                    movCont.viewMovDetails();
                    break;
                    
                case 2:
                    movCont.viewMovReviews();
                    break;
                    
                case 3:
                    if(bookMan.displayBookingManagerUI())
                        return false;
                    break;
                    
                case 4:
                    movCont.inputReview();
                    break; 
                    
                case 5:
                    if(!mC.user.displayMainUI())
                        return false;
            }
        }
    }
    
}
