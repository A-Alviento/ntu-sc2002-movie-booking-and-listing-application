package ui;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

import model.Movie;
import model.MovieShowTime;
import model.MovieStatus;

/**
 * Serves as the logic for Movie functions concerning 
 * an admin user
 * 
 */
public class MovieControllerAdmin {
    
    static Scanner sc = new Scanner(System.in);
    private MainController mC;
    
    public MovieControllerAdmin(MainController mC) {
        
        this.mC = mC;
    }
    
    public void addMov() {
        
        String title = CheckUserInput.loopUntilValidString("Enter movie title: ", 0);
        Movie newMov = new Movie(title);
        
        String director = CheckUserInput.loopUntilValidString("Enter movie director: ", 0);
        newMov.setDirector(director);
        
        int castSize = CheckUserInput.loopUntilValidInt("Enter movie title: ", 0, 1000);
        
        for (int i = 0; i < castSize; i++) {
            String s = "Enter Cast " + i + ": ";
            newMov.addCast(CheckUserInput.loopUntilValidString(s, 0));
        }
        
        newMov.setSynopsis(CheckUserInput.loopUntilValidString("Enter Synopsis: ", 0));
        
        System.out.println("1. Coming Soon\n2. Now Showing\n3. Preview\n4.End of Showing\n");
        boolean loop = true;
        
        while(loop) {
            
            switch(CheckUserInput.loopUntilValidInt("Enter movie Status:  \n", 1, 4)){
                case 1:
                    newMov.setMovieStatus(MovieStatus.COMING_SOON);
                    loop = false;
                    break;
                case 2:
                    newMov.setMovieStatus(MovieStatus.NOW_SHOWING);
                    loop = false;
                    break;
                case 3:
                    newMov.setMovieStatus(MovieStatus.PREVIEW);
                    loop = false;
                    break;
                case 4:
                    newMov.setMovieStatus(MovieStatus.END_OF_SHOWING);
                    loop = false;
                    break;
                default:
                    System.out.println("Please choose from the options\n");
            }        
        }
        
        System.out.println("Is the movie a blockbuster? (0 - No ; 1 - Yes) ");
        int option = CheckUserInput.loopUntilValidInt("Is the movie a blockbuster? (0 - No ; 1 - Yes) \n", 0, 1);
        
        if(option == 0)
            newMov.setBlockbuster(false);
        else
            newMov.setBlockbuster(true);
        
        mC.movList.add(newMov);
        
    }
    
    public void updateMovie(int movieIndex) {
        
        boolean loop = true;
        
        while(loop) {
            System.out.println("1. Update Movie Title");
            System.out.println("2. Update Movie Director");
            System.out.println("3. Update Movie Cast");
            System.out.println("4. Update Movie Synopsis");
            System.out.println("5. Update Movie Status");
            System.out.println("6. Update Movie Blockbuster Status");
            System.out.println("7. Done");
            
            int selection = CheckUserInput.loopUntilValidInt("Select from the option: \n", 1, 7);
            
            switch(selection) {
                
                case 1:
                    mC.currMov.setTitle(CheckUserInput.loopUntilValidString("Enter movie title: \n", 0));
                    break;
                    
                case 2:
                    mC.currMov.setDirector(CheckUserInput.loopUntilValidString("Enter movie director: \n", 0));
                    break;
                    
                case 3:
                    int size = CheckUserInput.loopUntilValidInt("Enter number of cast: \n", 0, 1000);
                    
                    for (int i = 0; i < size; i++) {
                        String s = "Enter Cast " + i + ": ";
                        mC.currMov.addCast(CheckUserInput.loopUntilValidString(s, 0));
                    }
                    break;
                    
                case 4:
                    mC.currMov.setSynopsis(CheckUserInput.loopUntilValidString("Enter movie synopsis: \n", 0));
                    break;
                    
                case 5:
                    System.out.println("1. Coming Soon\n2. Now Showing\n3. Preview\n4.End of Showing");
              
                    int choice = CheckUserInput.loopUntilValidInt("Enter movie status: \n", 1, 4);
                    
                    switch(choice){
                        case 1:
                            mC.currMov.setMovieStatus(MovieStatus.COMING_SOON);
                            break;
                        case 2:
                            mC.currMov.setMovieStatus(MovieStatus.NOW_SHOWING);
                            break;
                        case 3:
                            mC.currMov.setMovieStatus(MovieStatus.PREVIEW);
                            break;
                        case 4:
                            mC.currMov.setMovieStatus(MovieStatus.END_OF_SHOWING);
                            mC.movList.remove(movieIndex);
                            System.out.println("Movie removed.");
                            return;
                        default:
                                
                    }        
                    break;
                    
                case 6:
                    int option = CheckUserInput.loopUntilValidInt("Is the movie a blockbuster? (0 - No ; 1 - Yes) \n", 0, 1);

                    if (option == 0)
                        mC.currMov.setBlockbuster(false);
                    else
                        mC.currMov.setBlockbuster(true);
        
                    break;
                    
                case 7:
                    loop = false;
                    return;
                    
                default:
                    System.out.println("Please choose from the options\n");
            }
        }
    }
    
    public void addShowTime(int cineplexNum, int cinemaNum) {

        LocalDate newDate = DateTimeInputController.dateInput("Enter a date (yyyy-mm-dd) : ");
        LocalTime newTime = DateTimeInputController.timeInput("Enter time (hh:mm) : ");
        
        boolean is3D;
        int select3D = CheckUserInput.loopUntilValidInt("Is the movie 3D or not (0 - No ; 1 - Yes): \n", 0, 1);
        
        if (select3D == 1)
            is3D = true;
        else
            is3D = false;
        
        MovieShowTime movShowTime = new MovieShowTime(mC.cinPlex.get(cineplexNum).getCinema()[cinemaNum], newDate, newTime, is3D);
        mC.currMov.getMovieShowTimes().add(movShowTime);
    }
    
    public void updateShowTime(int showTimeIndex) {
        boolean loop = true;
        
        while(loop) {
            System.out.println("1. Update Date and Time");
            System.out.println("2. Update Cinema");
            System.out.println("3. Update 3D");
            System.out.println("4. Done");
            
            int selection = CheckUserInput.loopUntilValidInt("Select an option: \n", 1, 4);
            
            switch(selection) {
                
                case 1:
                    LocalDate newDate = DateTimeInputController.dateInput("Enter a date (yyyy-mm-dd) : ");
                    LocalTime newTime = DateTimeInputController.timeInput("Enter time (hh:mm) : ");
                    
                    mC.currMov.getMovieShowTimes().get(showTimeIndex).setMovieDate(newDate);
                    mC.currMov.getMovieShowTimes().get(showTimeIndex).setMovieTime(newTime);
                    break;
                    
                case 2:
                    int cineplexNum = CheckUserInput.loopUntilValidInt("Enter Cineplex (1, 2, 3) : \n", 1, 3);

                    int cinemaNum = CheckUserInput.loopUntilValidInt("Enter Cinema Hall (1, 2, 3) : \n", 1, 3);
                    
                    mC.currMov.getMovieShowTimes().get(showTimeIndex).setCinema(mC.cinPlex.get(cineplexNum-1).getCinema()[cinemaNum-1]);
                    break;
                    
                case 3:
                    int is3D = CheckUserInput.loopUntilValidInt("Is the movie 3D or not (0 - No ; 1 - Yes): \n", 0, 1);
                    
                    if (is3D == 1)
                        mC.currMov.getMovieShowTimes().get(showTimeIndex).setIs3D(true);
                    else
                        mC.currMov.getMovieShowTimes().get(showTimeIndex).setIs3D(false);

                    break;
                    
                case 4:
                    loop = false;
                    return;
                    
                default:
                    System.out.println("Please choose from the options\n");
            }
        }
    }
}
