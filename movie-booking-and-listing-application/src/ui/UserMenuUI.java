package ui;

import java.util.Scanner;

/*
 * This represents the menu for users after login
 * 
 */
public class UserMenuUI {
    
    static Scanner sc = new Scanner(System.in);
    private MainController mC;
    private boolean isSortSales;
    private boolean isSortRatings;
    
    public UserMenuUI(MainController mC) {
        
        this.mC = mC;
        isSortSales = true;
        isSortRatings = true;
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
                    mC.movCont.listMovies();
                    System.out.println("Please select a movie by indicating it's number: ");
                    
                    // exception
                    int movieSelected = sc.nextInt();
                    
                    // sets the selected movie
                    while (!mC.movCont.setCurrMovie(movieSelected)) {
                        System.out.println("Please select from the options.");
                        movieSelected = sc.nextInt();
                    }
                    
                    
                    if (!mC.movie.displayMovieUI()) {
                        return false;
                    }
                    
                    break;
                    
                case 2:
                    System.out.println("Key in a movie title:");
                    // exception
                    String movieSearch = sc.next();
                    int movieLocation = mC.movCont.searchMovies(movieSearch);
                    if (movieLocation == -1) {
                        System.out.println("Movie not found");
                        break;
                    }
                    
                    mC.movCont.setCurrMovie(movieLocation);
                    
                    if (!mC.movie.displayMovieUI()) {
                        return false;
                    }
                    
                    break;
                    
                case 3:
                    if (mC.currAcc == null) {
                        System.out.println("Please go back to the main page and login to view booking history.");
                        break;
                    }
                    
                    /*
                     * TODO:
                     * wait for customerAccount implementation of bookings
                     * 
                     */
                    break;
                    
                case 4:
                    if (!this.isSortSales) {
                        System.out.println("Not authorised to access");
                        break;
                    }
                    
                    int sortSize = mC.movCont.sortMovSales();
                    if (sortSize == 0) {
                        System.out.println("No movies to show.");
                        break;
                    }
                    for (int i = mC.movList.size()-1; i < sortSize; i--) {
                        System.out.println(i + ". " + mC.movList.get(i).getTitle() + " " + mC.movList.get(i).getTicketSale() + " sales.");
                    }
                    break;
                    
                case 5:
                    if (!this.isSortRatings) {
                        System.out.println("Not authorised to access");
                        break;
                    }
                    
                    int sortSize1 = mC.movCont.sortMovRatings();
                    if (sortSize1 == 0) {
                        System.out.println("No movies to show.");
                        break;
                    }
                    for (int i = mC.movList.size()-1; i < sortSize1; i--) {
                        System.out.println(i + ". " + mC.movList.get(i).getTitle() + " " + mC.movList.get(i).getRating() + " rating.");
                    }
                    break;
                    
                case 6:
                    if(!mC.cineplex.displayCineplexUI())
                        return false;
            }     
        }while(repeat = true);    
        
        return true;
    }
    
    
    
    /*
     * Setter methods for admin to give access rights to
     * filter
     * 
     */
    public void setSortSales() {
        
        if (this.isSortSales) {
            this.isSortSales = false;
            System.out.println("Users can no longer sort by ticket sales.");
        }
        else {
            this.isSortSales = true;
            System.out.println("Users can now view sort by ticket sales");
        }
    }
    
    public void setSortRatings() {
        
        if (this.isSortRatings) {
            this.isSortRatings = false;
            System.out.println("Users can no longer sort by ratings.");
        }
        else {
            this.isSortRatings = true;
            System.out.println("Users can now view sort by ratings");
        }
    }
}