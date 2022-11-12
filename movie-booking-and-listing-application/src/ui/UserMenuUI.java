package ui;

import java.util.Scanner;

/**
 * Serves as UI Menu for users or guest after login
 * 
 */
public class UserMenuUI {
    
    static Scanner sc = new Scanner(System.in);
    private MainController mC;
    private MovieController movCont;
    
    public static boolean isSortSales;
    public static boolean isSortRatings;
    
    
    public UserMenuUI(MainController mC) {
        
        this.mC = mC;
        this.movCont = new MovieController(this.mC);
        
        isSortSales = true;
        isSortRatings = true;
    }
    
    /**
     * This method prints the options for users after login
     * 
     */
    public void textDisplayUI() {
        System.out.println("**************************************************************************************************");
        System.out.println("1. List movies.\n"
                + "2. Search for a specific movie.\n"
                + "3. View booking history \n"
                + "4. List top 5 ranking by sales\n"
                + "5. List top 5 ranking by ratings\n"
                + "6. Back.");
        System.out.println("**************************************************************************************************");
        System.out.println("**************************************************************************************************");
        System.out.println();
    }
    
    /**
     * This method uses textDisplayUI to print options and
     * process user input 
     * 
     */
    public boolean displayMainUI() {
        
        int selection;
        
        while(true) {
            
            this.textDisplayUI();
            selection = CheckUserInput.loopUntilValidInt("Please choose an option from the menu: \n", 1, 6);

            
            switch(selection){

                case 1:
                    if(movCont.listMovies()) {
                        int movieSelected = CheckUserInput.loopUntilValidInt("Please select a movie by indicating it's number: \n", 1, mC.movList.size());
                        movCont.setCurrMovie(movieSelected-1);
                        
                        if (!mC.movie.displayMovieUI()) {
                            return false;
                        }
                    }

                    break;
                    
                case 2:
                    String movieSearch = CheckUserInput.loopUntilValidString("Key in a movie title: \n", 0).toLowerCase();
                    
                    int movieLocation = movCont.searchMovies(movieSearch);
                    if (movieLocation == -1) {
                        System.out.println("Movie not found");
                        break;
                    }
                    
                    movCont.setCurrMovie(movieLocation);
                    
                    if (!mC.movie.displayMovieUI()) {
                        return false;
                    }
                    
                    break;
                    
                case 3:
                    if (mC.currAcc == null) {
                        System.out.println("Please go back to the main page and login to view booking history.");
                        break;
                    }
                    
                    int numBook = mC.currAcc.getBookingList().size();
                    
                    if (numBook == 0) {
                        System.out.println("No bookings yet.");
                        break;
                    }
                    
                    for (int i = 1; i <= numBook; i++) {
                        System.out.println("Booking " + i + ": " + mC.currAcc.getBookingList().get(i-1).getMovieTitle() 
                                + "| Cinema: " + mC.currAcc.getBookingList().get(i-1).getCinemaCode() + "| Transaction ID: " 
                                + mC.currAcc.getBookingList().get(i-1).getTransectionID() + "| Date/Time: " 
                                + mC.currAcc.getBookingList().get(i-1).getBookingDate());
                    }
                    
                    break;
                     
                case 4:
                    if (!UserMenuUI.isSortSales) {
                        System.out.println("Not authorised to access");
                        break;
                    }
                    
                    int sortSize = movCont.sortMovSales();
                    int count = 1;
                    if (sortSize == 0) {
                        System.out.println("No movies to show.");
                        break;
                    }
                    for (int i = mC.movList.size(); i > mC.movList.size() - sortSize; i--) {
                        System.out.println(count++ + ". " + mC.movList.get(i-1).getTitle() + " " + mC.movList.get(i-1).getTicketSale() + " sales.");
                    }
                    break;
                    
                case 5:
                    if (!UserMenuUI.isSortRatings) {
                        System.out.println("Not authorised to access");
                        break;
                    }
                    
                    int sortSize1 = movCont.sortMovRatings();
                    int count1 = 1;
                    if (sortSize1 == 0) {
                        System.out.println("No movies to show.");
                        break;
                    }
                    for (int j = mC.movList.size(); j > mC.movList.size() - sortSize1; j--) {
                        System.out.println(count1++ + ". " + mC.movList.get(j-1).getTitle() + " " + mC.movList.get(j-1).getRating() + " rating.");
                    }
                    break;
                    
                case 6:
                        return false;
                    
            }   
            
        } 
        
    }
    
    
    
    /**
     * Setter methods for admin to give access 
     * rights to filter sort
     * 
     */
    public void setSortSales() {
        
        if (UserMenuUI.isSortSales) {
            UserMenuUI.isSortSales = false;
            System.out.println("Users can no longer sort by ticket sales.");
        }
        else {
            UserMenuUI.isSortSales = true;
            System.out.println("Users can now view sort by ticket sales");
        }
    }
    
    public void setSortRatings() {
        
        if (UserMenuUI.isSortRatings) {
            UserMenuUI.isSortRatings = false;
            System.out.println("Users can no longer sort by ratings.");
        }
        else {
            UserMenuUI.isSortRatings = true;
            System.out.println("Users can now view sort by ratings");
        }
    }
}