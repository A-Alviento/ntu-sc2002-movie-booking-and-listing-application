package ui;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import model.Movie;
import model.MovieShowTime;
import model.MovieStatus;

public class MovieControllerAdmin {
    
    static Scanner sc = new Scanner(System.in);
    private MainController mC;
    
    public MovieControllerAdmin(MainController mC) {
        
        this.mC = mC;
    }
    
    public void addMov() {
        
        System.out.println("Enter movie title: ");
        String title = sc.next();
        Movie newMov = new Movie(title);
        
        System.out.println("Enter movie director: ");
        String director = sc.next();
        newMov.setDirector(director);
        
        System.out.println("Enter number of cast: ");
        int castSize = sc.nextInt();
        for (int i = 0; i < castSize; i++) {
            System.out.println("Enter Cast " + i +": ");
            newMov.addCast(sc.next()); 
        }
        
        System.out.println("Enter Synopsis: ");
        newMov.setSynopsis(sc.next());
        
        System.out.println("Enter movieStatus: ");
        System.out.println("1. Coming Soon\n2. Now Showing\n3. Preview\n4.End of Showing");
        boolean loop = true;
        
        while(loop) {
            switch(sc.nextInt()){
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
        if(sc.nextInt() == 0)
            newMov.setBlockbuster(false);
        else
            newMov.setBlockbuster(true);
        
        mC.movList.add(newMov);
        /*
         * TODO:
         * Update in binary file as well
         * 
         */
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
            
            // exception
            switch(sc.nextInt()) {
                
                case 1:
                    System.out.println("Enter movie title: ");
                    mC.currMov.setTitle(sc.next());
                    break;
                    
                case 2:
                    System.out.println("Enter movie director: ");
                    mC.currMov.setDirector(sc.next());
                    break;
                    
                case 3:
                    System.out.println("Enter number of cast: ");
                    int size = sc.nextInt();
                    for (int i = 0; i < size; i++) {
                        System.out.println("Enter Cast " + i +": ");
                        mC.currMov.addCast(sc.next()); 
                    }
                    break;
                    
                case 4:
                    System.out.println("Enter movie synopsis: ");
                    mC.currMov.setSynopsis(sc.next());
                    break;
                    
                case 5:
                    System.out.println("Enter movieStatus: ");
                    System.out.println("1. Coming Soon\n2. Now Showing\n3. Preview\n4.End of Showing");
                    
                    // exception
                    int choice = sc.nextInt();
                    while (choice < 1 || choice > 4) {
                        System.out.println("Please choose from the options\n");
                        choice = sc.nextInt();
                    }
                    
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
                            /*
                             * TODO:
                             * Update in binary file as well
                             * 
                             */
                            System.out.println("Movie removed.");
                            return;
                        default:
                                
                    }        
                    break;
                    
                case 6:
                    System.out.println("Is the movie a blockbuster? (0 - No ; 1 - Yes) ");
                    // exception
                    int option = sc.nextInt();
                    
                    while (option < 1 || option> 2) {
                        System.out.println("Please choose from the options\n");
                        option = sc.nextInt();
                    }
                    if (option == 0)
                        mC.currMov.setBlockbuster(false);
                    else
                        mC.currMov.setBlockbuster(true);
        
                    break;
                    
                case 7:
                    loop = false;
                    /*
                     * TODO:
                     * Update all changes in binary file as well
                     * 
                     */
                    return;
                    
                default:
                    System.out.println("Please choose from the options\n");
            }
        }
    }
    
    public void addShowTime(int cineplexNum, int cinemaNum) {
        
        System.out.println("Enter date (yyyy-mm-dd): ");
        LocalDate newDate = dateInput("Enter a date: ");
        
        System.out.println("Enter time (hh:mm): ");
        LocalTime newTime = timeInput("Enter time (hh:mm): ");
        
        System.out.println("Is the movie 3D or not (0 - No ; 1 - Yes): ");
        // exception
        boolean is3D;
        int select3D = sc.nextInt();
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
            
            // exception
            switch(sc.nextInt()) {
                
                case 1:
                    System.out.println("Enter date (yyyy-mm-dd): ");
                    LocalDate newDate = dateInput("Enter a date: ");
                    
                    System.out.println("Enter time (hh:mm): ");
                    LocalTime newTime = timeInput("Enter time (hh:mm): ");
                    
                    mC.currMov.getMovieShowTimes().get(showTimeIndex).setMovieDate(newDate);
                    mC.currMov.getMovieShowTimes().get(showTimeIndex).setMovieTime(newTime);
                    break;
                    
                case 2:
                    System.out.println("Enter Cineplex (1, 2, 3) : ");
                    // exception
                    int cineplexNum = sc.nextInt();
                    System.out.println("Enter Cinema (1, 2, 3) : ");
                    // exception
                    int cinemaNum = sc.nextInt();
                    
                    mC.currMov.getMovieShowTimes().get(showTimeIndex).setCinema(mC.cinPlex.get(cineplexNum-1).getCinema()[cinemaNum-1]);
                    break;
                    
                case 3:
                    System.out.println("Is the movie 3D or not (0 - No ; 1 - Yes): ");
                    // exception
                    int is3D = sc.nextInt();
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
    
    public LocalDate dateInput(String userInput) {
        
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-mm-dd");
        LocalDate date = LocalDate.parse(userInput, dateFormat);
        
        System.out.println(date);
        return date ;
    }
    
    public LocalTime timeInput(String userInput) {
            
            DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("hh:mm");
            LocalTime time = LocalTime.parse(userInput, dateFormat);
            
            System.out.println(time);
            return time ;
        }
}
