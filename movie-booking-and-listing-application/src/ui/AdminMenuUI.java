package ui;

import java.util.Scanner;

/**
 * Serves as UI Menu for admins after login
 * 
 */
public class AdminMenuUI {
    
    static Scanner sc = new Scanner(System.in);
    private MainController mC;
    private MovieController movCont;
    private BookingManager bookMan;
    private MovieControllerAdmin movContAdm;
    private ConfigController confCont;


    public AdminMenuUI(MainController mC) {
        
        this.mC = mC;
        this.movCont = new MovieController(this.mC);
        this.bookMan = new BookingManager(this.mC);
        this.movContAdm = new MovieControllerAdmin(this.mC);
        this.confCont = new ConfigController(this.mC);
    }
    
    /**
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
        System.out.println();
    }
    
    /**
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
            selection = CheckUserInput.loopUntilValidInt("Please choose an option from the menu: \n", 1, 6);

            switch(selection){
                case 1:
                    movContAdm.addMov();
                    break;
                case 2:
                    movCont.listMovies();

                    int movie = CheckUserInput.loopUntilValidInt("Please select a movie by indicating it's number: \n", 1, mC.movList.size());
                    
                    movCont.setCurrMovie(movie-1);
                    
                    movContAdm.updateMovie(movie-1);

                    break;
                    
                case 3: 
                    
                    movCont.listMovies();

                    movieSelected = CheckUserInput.loopUntilValidInt("Please select a movie by indicating it's number: \n", 1, mC.movList.size());
                    
                    movCont.setCurrMovie(movieSelected-1);
                    
                    cineplexNum = CheckUserInput.loopUntilValidInt("Enter Cineplex (1, 2, 3): \n", 1, 3);
                    cinemaNum = CheckUserInput.loopUntilValidInt("Enter Cinema Hall (1, 2, 3): \n", 1, 3);
                    
                    movContAdm.addShowTime(cineplexNum - 1, cinemaNum - 1);
                    
                    break;
                    
                case 4:
                    movCont.listMovies();
                    
                    movieSelected = CheckUserInput.loopUntilValidInt("Please select a movie by indicating it's number: \n", 1, mC.movList.size());
                    
                    movCont.setCurrMovie(movieSelected-1);
                    
                    if(bookMan.displayShowTimes()) {
                        int showTime = CheckUserInput.loopUntilValidInt("Please select a showtime by indicating it's number: \n", 1, mC.currMov.getMovieShowTimes().size());
                        
                        movContAdm.updateShowTime(showTime-1); 
                    }
                    
                   
                      
                    break;
                    
                case 5:
                    
                    int option;
                    
                    do {
                        System.out.println("1. Update Ticket Prices");
                        System.out.println("2. Update Holidays");
                        System.out.println("3. Update Top 5 Sorting Access Rights");
                        System.out.println("4. Back");
                        System.out.println("");

                        option = CheckUserInput.loopUntilValidInt("Please select an option to configure: \n", 1, 4);
                        
                    } while (this.confCont.configEntry(option));
                    
                    break;
                    
                case 6:
                    return false;
            }
        }
    }
}