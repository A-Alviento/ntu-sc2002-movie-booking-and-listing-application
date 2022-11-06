package ui;

import java.util.Scanner;

import model.Movie;
import model.MovieStatus;

public class AdminMenuUI {
    
    static Scanner sc = new Scanner(System.in);
    private MainController mC;

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
                    
                    break;
                case 2:
                    /*
                     * TODO:
                     * DISPLAY MOVIE LIST -> SELECT MOVIE -> TWO OPTIONS 
                     * -> UPDATE OR REMOVE
                     * 
                     */
                    
                    Movie selectedMovie;
                    
                    System.out.println("Update or remove? (0 - update ; 1 - remove) ");
                    if(sc.nextInt() == 0) {
                        boolean loop1 = true;
                        
                        while(loop1) {
                            System.out.println("1. Update Movie Title");
                            System.out.println("2. Update Movie Director");
                            System.out.println("3. Update Movie Cast");
                            System.out.println("4. Update Movie Synopsis");
                            System.out.println("5. Update Movie Status");
                            System.out.println("6. Update Movie Blockbuster Status");
                            System.out.println("7. Done");
                            
                            switch(sc.nextInt()) {
                                case 1:
                                    System.out.println("Enter movie title: ");
                                    selectedMovie.setTitle(sc.next());
                                    break;
                                case 2:
                                    System.out.println("Enter movie director: ");
                                    selectedMovie.setDirector(sc.next());
                                    break;
                                case 3:
                                    System.out.println("Enter number of cast: ");
                                    int size = sc.nextInt();
                                    for (int i = 0; i < size; i++) {
                                        System.out.println("Enter Cast " + i +": ");
                                        selectedMovie.addCast(sc.next()); 
                                    }
                                    break;
                                case 4:
                                    System.out.println("Enter movie synopsis: ");
                                    selectedMovie.setSynopsis(sc.next());
                                    break;
                                case 5:
                                    System.out.println("Enter movieStatus: ");
                                    System.out.println("1. Coming Soon\n2. Now Showing\n3. Preview\n4.End of Showing");
                                    boolean loop2 = true;
                                    
                                    while(loop2) {
                                        switch(sc.nextInt()){
                                            case 1:
                                                selectedMovie.setMovieStatus(MovieStatus.COMING_SOON);
                                                loop = false;
                                                break;
                                            case 2:
                                                selectedMovie.setMovieStatus(MovieStatus.NOW_SHOWING);
                                                loop = false;
                                                break;
                                            case 3:
                                                selectedMovie.setMovieStatus(MovieStatus.PREVIEW);
                                                loop = false;
                                                break;
                                            case 4:
                                                selectedMovie.setMovieStatus(MovieStatus.END_OF_SHOWING);
                                                loop = false;
                                                break;
                                            default:
                                                System.out.println("Please choose from the options\n");
                                        }        
                                    }
                                    break;
                                case 6:
                                    System.out.println("Is the movie a blockbuster? (0 - No ; 1 - Yes) ");
                                    if(sc.nextInt() == 0)
                                        selectedMovie.setBlockbuster(false);
                                    else
                                        selectedMovie.setBlockbuster(true);
                                    break;
                                case 7:
                                    loop1 = false;
                                    break;
                                default:
                                    System.out.println("Please choose from the options\n");
                            }
                        }
                    }
                    else {
                        int len = mC.movList.size();
                        
                        for (int i = 0; i < len; i++) {
                            if (selectedMovie.getTitle().equals(mC.movList.get(i))) {
                                mC.movList.remove(i);
                            }
                        }
                    }
                    
                    break;
                    
                case 3:
                    /*
                     * TODO:
                     * ASK USER TO SELECT A MOVIE, A CINEPLEX AND A CINEMA. FROM THERE, ACCESS 
                     * THE MOVIE AND ADD A MOVIE SHOWING (DATE + TIMING) FOR THAT PARTICULAR
                     * CINEPLEX AND CINEMA; 
                     * 
                     * ADD IF NO CONFLICT ELSE PROMPT AGAIN
                     * 
                     * CONFUSION: MOVIE SHOULD HAVE ASSOCIATION TO MOVIESHOWING AND MOVIESHOWING IS MISSING DATE
                     * 
                     */
                    break;
                    
                case 4:
                    /*
                     * TODO:
                     * ASK USER TO SELECT A MOVIE. FROM THERE, LIST THE SHOWTIMES FOR THE MOVIE
                     * ORGANISED IN CINEPLEX, CINEMA DATE AND TIME;
                     * PROMPT USER TO SELECT A SHOWTIME TO UPDATE 
                     * 
                     * UPDATE IF NO CONFLICT ELSE PROMPT AGAIN
                     * 
                     * CONFUSION: MOVIE SHOULD HAVE ASSOCIATION TO MOVIESHOWING AND MOVIESHOWING IS MISSING DATE
                     * 
                     */
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








