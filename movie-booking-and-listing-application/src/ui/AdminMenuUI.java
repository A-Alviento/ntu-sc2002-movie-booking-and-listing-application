package ui;

import java.util.Scanner;

import model.Movie;
import model.MovieStatus;

public class AdminMenuUI {
    
    static Scanner sc = new Scanner(System.in);
    private MainController mC;

    public AdminMenuUI() {

    }

    public void setMainController(MainController mC) {
        
        this.mC = mC;
    }
    
    /*
     * This method prints the options for admins after login
     * 
     */
    public void textDisplayUI() {
        System.out.println("**************************************************************************************************");
        System.out.println("1. Create Movie Listing.\n"
                + "2. Update/Remove Movie Listing.\n"
                + "3. Create Cinema Showtime.\n"
                + "4. Update/Remove Cinema Showtime.\n"
                + "5. Configure system settings.\n"
                + "6. Logout.");
        System.out.println("**************************************************************************************************");
        System.out.println("**************************************************************************************************");
        System.out.println("\nPlease choose an option from the menu:");
    }
    
    /*
     * This method uses textDisplayUI to print options and
     * process user input 
     * 
     */
    public boolean displayAdminUI() {
        
        MovieControllerAdmin movContAdm = new MovieControllerAdmin(this.mC);
        
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
                    movContAdm.addMov();
                    break;
                case 2:
                    mC.movCont.listMovies();
                    System.out.println("Please select a movie by indicating it's number: ");
                    
                    // exception
                    int movie = sc.nextInt();
                    mC.movCont.setCurrMovie(movie-1);
                    
                    movContAdm.updateMovie(movie-1);

                    break;
                    
                case 3:
                    
                    mC.movCont.listMovies();
                    System.out.println("Please select a movie by indicating it's number: ");
                    
                    // exception
                    int movieSelected = sc.nextInt();
                    mC.movCont.setCurrMovie(movieSelected-1);
                    
                    mC.cineplex.displayCineplexUI();
                    
                    System.out.println("Select a cinema (1, 2, 3)");
                    // exception
                    int cinema = sc.nextInt();
                    
                    // TODO:
                    // need method in Movie class to add a showtime
                    
                    
                    break;
                    
                case 4:
                    mC.movCont.listMovies();
                    System.out.println("Please select a movie by indicating it's number: ");
                    
                    // exception
                    int movieSelected1 = sc.nextInt();
                    mC.movCont.setCurrMovie(movieSelected1-1);
                    
                    mC.cineplex.displayCineplexUI();
                    
                    BookingManager.displayShowTimes();
                    
                    System.out.println("Please select a showtime by indicating it's number: ");
                    // exception
                    int showTime = sc.nextInt();
                    
                    movContAdm.updateShowTime(showTime-1);                    
                    
                    break;
                    
                case 5:
                    /*
                     * TODO:
                     * 
                     */
                    break;
                    
                case 6:
                    return false;
            }
        }while(repeat = true);
        
        return true;
    }
}








