package ui;

import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import model.MovieShowTime;
import model.PriceUtil;
import model.Booking;

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
     * This prints the UI and processes user input
     * 
     */
    public boolean displayBookingManagerUI(){
        
        /* display showtimes in order */
        this.displayShowTimes(mC);
        System.out.println("Select a showing: ");
        // exception
        /* represents the index of movie showing selected */
        int movShowingIndex = sc.nextInt();
        
        /* represents the cinema hall number */
        int cinemaHall = mC.currMov.getMovieShowTimes().get(movShowingIndex-1).getCinema().getCinemaHall();
        
        /* displays seat allocation for selected showing at selected cinemaHall */
        this.displaySeatAllocation(cinemaHall-1, movShowingIndex-1);
        
        
        while (mC.currAcc == null) {
            System.out.println("To book:\n"
                    + "1. login.\n"
                    + "2. create an account \n");
            int choice = sc.nextInt();
            if (choice == 1) {
                mC.accMan.authenticateUserAccount();
            }
            else {
                mC.accMan.makeAccount();
                System.out.println("Great, now login using the account you just created: ");
                mC.accMan.authenticateUserAccount();
            }
        }
        
        System.out.println("Enter the row number ");
        // exception
        int row = sc.nextInt();
        while (row > mC.currCineplex.getCinema()[0].getSeatLayout().length || row < 0) {
            System.out.println("Invalid row number, try again: ");
            row = sc.nextInt();
        }
        
        System.out.println("Enter the column number ");
        // exception
        int col = sc.nextInt();
        while (col > mC.currCineplex.getCinema()[0].getSeatLayout()[0].length || col < 0) {
            System.out.println("Invalid column number, try again: ");
            col = sc.nextInt();
        }
        
        /*
         * TODO:
         * Cinema class has a getCinemaClass method but 
         * it returns a string instead of the enum; change
         * 
         */
        String price = PriceUtil.getPrice(mC.currMov.getMovieShowTimes().get(movShowingIndex-1).getMovieDate(),
                mC.currMov.getMovieShowTimes().get(movShowingIndex-1).getMovieTime(), mC.currAcc.getAge(),
                mC.currMov.getMovieShowTimes().get(movShowingIndex-1).getIs3D(), mC.currCineplex.getCinema()[cinemaHall].getCinemaClass(),
                mC.currMov.isBlockbuster());
        System.out.println("The final price is " + price + " SGD");
        System.out.println("1. Book\n"
                + "2. Cancel\n");
        System.out.println("Please choose an option:");
        
        // exception
        int finalChoice = sc.nextInt();
        
        while (finalChoice < 1 ||  finalChoice > 2) {
            System.out.println("Please choose from the options\n");
            cinemaHall = sc.nextInt();
        }
        

        if (finalChoice == 1) {
            int[] seatid = {row, col};
            
            mC.currAcc.addBooking(seatid, Double.parseDouble(price), 
                    mC.currMov.getTitle(), mC.currCineplex.getCinema()[cinemaHall].getCinemaCode());
            
            /*
             * TODO:
             * Update in binary file as well
             * 
             */
            
            mC.currMov.incTicketSale();
            /*
             * TODO:
             * Update in binary file as well
             * 
             */
            
            System.out.println("Booking successful, you can check your booking history.");
        }
        return true;
        
    }
    
    /*
     * This first sorts the showtimes for a movie
     * then prints them in order
     * 
     */
    public void displayShowTimes(MainController mC) {
        
        Collections.sort(mC.currMov.getMovieShowTimes(), new ShowTimeSort());
        
        for (int i = 1; i <= mC.currMov.getMovieShowTimes().size(); i++) {
            
            System.out.println(i + ". " + "Date: " + mC.currMov.getMovieShowTimes().get(i).getMovieDate() + " Time: " + mC.currMov.getMovieShowTimes().get(i).getMovieTime() + " at cinema " + mC.currMov.getMovieShowTimes().get(i).getCinema().getCinemaCode());
        }
        
    }
    
    /*
     * This displays seat allocation for a movie
     * at a particular showing
     * 
     */
    public void displaySeatAllocation(int cinemaNum, int showTimeIndex) {
        
//        int [][] seatLayout = new int [mC.currCineplex.getCinema()[cinemaNum].getSeatLayout().length][];
//        for (int i = 0; i < mC.currCineplex.getCinema()[cinemaNum].getSeatLayout().length; i++)
//            seatLayout[i] = mC.currCineplex.getCinema()[cinemaNum].getSeatLayout()[i].clone();

        int col;
        int row;
        
        /* 0 for aisle, 1 for seat*/
//        for (int j = 0; j < mC.currMov.getMovieShowTimes().get(showTimeIndex).getBooking().size(); j++) {
//            if (mC.currMov.getMovieShowTimes().get(showTimeIndex).getCinema().getCinemaHall() == cinemaNum) {
//                row = mC.currMov.getMovieShowTimes().get(showTimeIndex).getBooking().get(j).getSeat()[0];
//                col = mC.currMov.getMovieShowTimes().get(showTimeIndex).getBooking().get(j).getSeat()[1];
//                seatLayout[row][col] = 2;
//            }
//        }
        
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
                if ([i][j] == 1)
                    System.out.print("O ");
                else
                    System.out.print("  ");
            }
            System.out.println();
        }
        
        // ---------------------- //
        System.out.print("  ");
        for (int k = 0; k < mC.currCineplex.getCinema()[cinemaNum].getSeatLayout()[0].length; k++) {
            System.out.print(k + " ");
        }
        
        System.out.println();
        
        for (int m = 0; m < mC.currCineplex.getCinema()[cinemaNum].getSeatLayout().length; m++) {
            
            System.out.print(m + " ");
            for (int l = 0; l < mC.currCineplex.getCinema()[cinemaNum].getSeatLayout()[m].length; l++) {
                System.out.print(seatLayout[m][l] + " ");
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