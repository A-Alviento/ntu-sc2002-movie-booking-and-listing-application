package ui;

import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import model.MovieShowTime;

/*
 * This represents the booking logic
 * 
 */
public class BookingManager {
    
    static Scanner sc = new Scanner(System.in);
    private MainController mC;
    
    public BookingManager(MainController mC) {
        
        this.mC = mC;
    }
    
    /*
     * This prints the UI
     * 
     */
    public void textDisplayUI() {
        
        System.out.println("**************************************************************************************************");
        System.out.println("Please select a cinema theatre: \n");
        System.out.println("1. Cinema 1.\n"
                + "2. Cinema 2.\n"
                + "3. Cinema 3.\n"
                + "4. Back.");
        System.out.println("**************************************************************************************************");
        System.out.println("**************************************************************************************************");
    }
    
    
    /*
     * This prints the UI and processes user input
     * 
     */
    public boolean displayBookingManagerUI(){
        
        int selection;
        
            
        this.textDisplayUI();
        selection = sc.nextInt();
        
        while (selection < 1 || selection > 4) {
            
            System.out.println("Please choose from the options\n");
            selection = sc.nextInt();
        }
        
        if (selection == 4) {
            if(!mC.movie.displayMovieUI())
                return false;
        }
        
        int showTimeSize = mC.currMov.getMovieShowTimes().size();
        
        if (showTimeSize == 0) {
            System.out.println("No available showings.");
            return true;
        }
        
        this.displayShowTimes();
        System.out.println("Select a showing: ");
        // exception
        int showing = sc.nextInt();
        
        
        
        if (mC.currAcc == null) {
            
        }
        
    }
    
    /*
     * This first sorts the showtimes for a movie
     * then prints them in order
     * 
     */
    public void displayShowTimes() {
        
        Collections.sort(mC.currMov.getMovieShowTimes(), new ShowTimeSort());
        
        for (int i = 1; i <= mC.currMov.getMovieShowTimes().size(); i++) {
            
            System.out.println(i + ". " + "Date: " + mC.currMov.getMovieShowTimes().get(i).getMovieDate() + " Time: " + mC.currMov.getMovieShowTimes().get(i).getMovieTime());
        }
        
    }
    
    /*
     * This first sorts the showtimes for a movie
     * then prints them in order
     * 
     */
    public void displaySeatAllocation(int cinemaNum) {
        
        mC.currCineplex
    }
    
}

class ShowTimeSort implements Comparator<MovieShowTime>{

    @Override
    public int compare(MovieShowTime o1, MovieShowTime o2) {
        
        return (o1.getMovieDate().getDayOfYear() + o1.getMovieDate().getYear() + o1.getMovieTime().getHour() - 
                o2.getMovieDate().getDayOfYear() + o2.getMovieDate().getYear())+ o2.getMovieTime().getHour();
    }

}