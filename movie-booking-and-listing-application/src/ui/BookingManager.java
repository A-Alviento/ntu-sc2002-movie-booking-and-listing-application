package ui;

import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import model.MovieShowTime;
import model.PriceUtil;

/**
 * This represents the booking logic to book
 * a ticket
 * 
 */
public class BookingManager {
    
    static Scanner sc = new Scanner(System.in);
    private MainController mC;
    
    public BookingManager(MainController mC) {
        
        this.mC = mC;
    }
    
    
    
    /**
     * This prints the UI and processes user input
     * 
     */
    public boolean displayBookingManagerUI(){
        
        /** display showtimes in order */
        if(!this.displayShowTimes())
            return false;
        System.out.println();

        
        /** represents the index of movie showing selected */
        int movShowingIndex = CheckUserInput.loopUntilValidInt("Select a showing by typing its number: ", 1, mC.currMov.getMovieShowTimes().size());
        
        /** represents the cinema hall number */
        int cinemaHall = mC.currMov.getMovieShowTimes().get(movShowingIndex-1).getCinema().getCinemaHall();
        int cineplexNum = mC.currMov.getMovieShowTimes().get(movShowingIndex-1).getCinema().getCineplexNum();
        
        /** displays seat allocation for selected showing at selected cinemaHall */
        this.displaySeatAllocation(cinemaHall, cineplexNum, movShowingIndex-1);
        
        /** if user not logged in, prompt login */
        while (mC.currAcc == null) {
            System.out.println("To book:\n"
                    + "1. login.\n"
                    + "2. create an account \n");
            
            int choice = CheckUserInput.loopUntilValidInt("Please choose an option: ", 1, 2);
            if (choice == 1) {
                mC.accMan.authenticateUserAccount();
            }
            else {
                mC.accMan.makeAccount();
                System.out.println("Great, now login using the account you just created: ");
                mC.accMan.authenticateUserAccount();
            }
        }
        
        /** represents row selected by user */
        int row = CheckUserInput.loopUntilValidInt("Enter the row number: ", 1, mC.cinPlex.get(cineplexNum).getCinema()[cinemaHall].getSeatLayout().length);
        
        System.out.println("Enter the column letter ");
        
        String s = CheckUserInput.loopUntilValidString("Enter the column letter: ", 1).toUpperCase();
        char c = s.charAt(0);
        
        while (c < 'A' || c > 'H') {
            System.out.println("Invalid column (Only A-H), try again: ");
            s = CheckUserInput.loopUntilValidString("Enter the column letter: ", 1).toUpperCase();
            c = s.charAt(0);
        }
        
        /** represents column selected by user */
        int col = 0;
        
        if (c == 'A')
            col = 0;
        else if (c == 'B')
            col = 1;
        else if (c == 'C')
            col = 2;
        else if (c == 'D')
            col = 3;
        else if (c == 'E')
            col = 5;
        else if (c == 'F')
            col = 6;
        else if (c == 'G')
            col = 7;
        else if (c == 'H')
            col = 8;
            
        /** gets the price */
        String price = PriceUtil.getPrice(mC.currMov.getMovieShowTimes().get(movShowingIndex-1).getMovieDate(),
                mC.currMov.getMovieShowTimes().get(movShowingIndex-1).getMovieTime(), mC.currAcc.getAge(),
                mC.currMov.getMovieShowTimes().get(movShowingIndex-1).getIs3D(), 
                mC.currMov.getMovieShowTimes().get(movShowingIndex-1).getCinema().getCinemaClass(),
                mC.currMov.isBlockbuster());
        System.out.println("The final price is " + price + " SGD");
        
        
        System.out.println("1. Book\n"
                + "2. Cancel\n");
        
        int finalChoice = CheckUserInput.loopUntilValidInt("Please choose an option: ", 1, 2);
        
        if (finalChoice == 1) {
            int[] seatid = {row - 1, col};
            
            /** update the booking history of current user */
            mC.currAcc.addBooking(seatid, Double.parseDouble(price), 
                    mC.currMov.getTitle(), 
                    mC.currMov.getMovieShowTimes().get(movShowingIndex-1).getCinema().getCinemaCode(),
                    mC.currMov.getMovieShowTimes().get(movShowingIndex-1).getCinema());
            
            /** increment ticket sale of the movie */
            mC.currMov.incTicketSale();
            
            System.out.println("Booking successful, you can check your booking history.");
        }
        return true;
        
    }
    
    /**
     * This first sorts the showtimes for a movie
     * then prints them in order
     * 
     */
    public boolean displayShowTimes() {
        
        Collections.sort(mC.currMov.getMovieShowTimes(), new ShowTimeSort());
        
        if (mC.currMov.getMovieShowTimes().size() == 0) {
            System.out.println("No showtimes available.");
            return false;
        }
        
        for (int i = 1; i <= mC.currMov.getMovieShowTimes().size(); i++) {
            
            System.out.println(i + ". " + "Date: " + mC.currMov.getMovieShowTimes().get(i-1).getMovieDate() + " Time: " + mC.currMov.getMovieShowTimes().get(i-1).getMovieTime() + " at cinema " + mC.currMov.getMovieShowTimes().get(i-1).getCinema().getCinemaCode());
        }
        return true;
        
    }
    
    /**
     * This displays seat allocation for a movie
     * at a particular showing
     * 
     */
    public void displaySeatAllocation(int cinemaNum, int cinePlexNum, int showTimeIndex) {
        
        int [][] seatLayout = new int [mC.cinPlex.get(cinePlexNum).getCinema()[cinemaNum].getSeatLayout().length][];
        for (int i = 0; i < mC.cinPlex.get(cinePlexNum).getCinema()[cinemaNum].getSeatLayout().length; i++)
            seatLayout[i] = mC.cinPlex.get(cinePlexNum).getCinema()[cinemaNum].getSeatLayout()[i].clone();

        int col;
        int row;
        
        
        /** 0 for aisle, 1 for vacant seat, 2 for non-vacant seat*/
        for (int j = 0; j < mC.currMov.getMovieShowTimes().get(showTimeIndex).getBooking().size(); j++) {
            if (mC.currMov.getMovieShowTimes().get(showTimeIndex).getBooking().get(j).getCinema().getCinemaHall() == cinemaNum &&
                    mC.currMov.getMovieShowTimes().get(showTimeIndex).getBooking().get(j).getCinema().getCineplexNum() == cinePlexNum) {
                row = mC.currMov.getMovieShowTimes().get(showTimeIndex).getBooking().get(j).getSeat()[0];
                col = mC.currMov.getMovieShowTimes().get(showTimeIndex).getBooking().get(j).getSeat()[1];
                seatLayout[row][col] = 2;
            }
        }
        
        
        System.out.print("    ");
        for (char c = 'A'; c < 'I'; c++) {
            if (Character.compare(c, 'E') == 0)
                System.out.print("  ");
            System.out.print(c + " ");
        }
        System.out.println("\n");

        
        for (int i = 0; i < 9; i++) {
            System.out.print(i+1 + "   ");
            for (int j = 0; j < 9; j++) {
                if (seatLayout[i][j] == 1)
                    System.out.print("O ");
                else if (seatLayout[i][j] == 2)
                    System.out.print("X ");
                else
                    System.out.print("  ");
            }
            System.out.println();
        }
    }
}

class ShowTimeSort implements Comparator<MovieShowTime>{

    @Override
    public int compare(MovieShowTime o1, MovieShowTime o2) {
        
        return (o1.getMovieDate().getDayOfYear() + o1.getMovieDate().getYear() + o1.getMovieTime().getHour() - 
                o2.getMovieDate().getDayOfYear() + o2.getMovieDate().getYear())+ o2.getMovieTime().getHour();
    }

}