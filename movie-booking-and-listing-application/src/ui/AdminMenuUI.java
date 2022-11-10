package ui;

import java.util.Scanner;

import model.Movie;
import model.MovieStatus;

public class AdminMenuUI {
    
    static Scanner sc = new Scanner(System.in);
    private MainController mC;
    private MovieController movCont;
    private BookingManager bookMan;
    private MovieControllerAdmin movContAdm;


    public AdminMenuUI(MainController mC) {
        
        this.mC = mC;
        this.movCont = new MovieController(this.mC);
        this.bookMan = new BookingManager(this.mC);
        this.movContAdm = new MovieControllerAdmin(this.mC);
    }
    
    /*
     * This method prints the options for admins after login
     * 
     */
    public void textDisplayUI() {
        System.out.println("**************************************************************************************************");
        System.out.println("1. Create Movie Listing.\n"
                + "2. Update/Remove Movie Listing.\n"
                + "3. Create Movie Showtime.\n"
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
        
        int selection;
        int cineplexNum;
        int cinemaNum;
        int movieSelected;
        
        while(true) {
            
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
                    movCont.listMovies();
                    System.out.println("Please select a movie by indicating it's number: ");
                    
                    // exception
                    int movie = sc.nextInt();
                    movCont.setCurrMovie(movie-1);
                    
                    movContAdm.updateMovie(movie-1);

                    break;
                    
                case 3:
                    
                    movCont.listMovies();
                    System.out.println("Please select a movie by indicating it's number: ");
                    
                    // exception
                    movieSelected = sc.nextInt();
                    movCont.setCurrMovie(movieSelected-1);
                    
                    System.out.println("Enter Cineplex (1, 2, 3) : ");
                    // exception
                    cineplexNum = sc.nextInt();
                    System.out.println("Enter Cinema (1, 2, 3) : ");
                    // exception
                    cinemaNum = sc.nextInt();
                    
                    movContAdm.addShowTime(cineplexNum - 1, cinemaNum - 1);
                    
                    break;
                    
                case 4:
                    movCont.listMovies();
                    System.out.println("Please select a movie by indicating it's number: ");
                    
                    // exception
                    movieSelected = sc.nextInt();
                    movCont.setCurrMovie(movieSelected-1);
                    
                    bookMan.displayShowTimes();
                    
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
        
        }
        
    }

}








