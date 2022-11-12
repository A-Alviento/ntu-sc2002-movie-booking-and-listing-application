package ui;

import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import model.Movie;

/**
 * Serves as the logic for Movie functions 
 * 
 */
public class MovieController {
    
    static Scanner sc = new Scanner(System.in);
    private MainController mC;
    
    public MovieController(MainController mC) {
        
        this.mC = mC;
    }
    
    /**
     * This method list the available movies
     * 
     */
    public boolean listMovies() {

        if (mC.movList.size() == 0) {
            System.out.println("No movies available.");
            return false;
        }
        
        for (int i = 1; i <= mC.movList.size(); i++)
            System.out.println(i + ". " + mC.movList.get(i-1).getTitle());
        return true;
    }
    
    /**
     * This method takes a string and matches with a movie title
     * return index of where the movie is located in the array
     * of movies or -1 if no match found
     * 
     */
    public int searchMovies(String s) {
        
        int location = -1;
        
        for (int i = 0; i < mC.movList.size(); i++) {
            if (mC.movList.get(i).getTitle().equalsIgnoreCase(s)) {
                location = i;
                break;
            }
        }
        
        return location;
    }
    
    /**
     * This method sets the current movie to selected one
     * 
     */
    public boolean setCurrMovie(int selection) {
        if (selection < 0 || selection > mC.movList.size())
            return false;
        mC.currMov = mC.movList.get(selection);
        
        return true;
    }
    
    /**
     * This method sorts the movie list in ascending order 
     * of sales
     * 
     */
    public int sortMovSales() {
        int numMov = mC.movList.size();
        
        if (numMov == 0)
            return 0;
        if (numMov > 5)
            numMov = 5;
        
        Collections.sort(mC.movList, new MovieSalesSort());
        return numMov;
    }
    
    /**
     * This method sorts the movie list in ascending order 
     * of ratings
     * 
     */
    public int sortMovRatings() {
        int numMov = mC.movList.size();
        
        if (numMov == 0)
            return 0;
        if (numMov > 5)
            numMov = 5;
        
        Collections.sort(mC.movList, new MovieRatingsSort());
        return numMov;
    }
    
    /**
     * This method prints out current movie details
     * 
     */
    public void viewMovDetails() {
        
        System.out.println("Title: " + mC.currMov.getTitle());
        System.out.println("Status: " + mC.currMov.getMovieStatus());
        System.out.println("Parental Guidance: " + mC.currMov.getCensorship());
        System.out.println("Synopsis: " + mC.currMov.getSynopsis());
        System.out.println("Director: " + mC.currMov.getDirector());
        System.out.println("Cast: " + mC.currMov.getCasts());
        System.out.println("Rating: " + mC.currMov.getRating());
    }
    
    
    /**
     * This method prints out current movie details
     * 
     */
    public void viewMovReviews() {
        
        if (mC.currMov.getReviews().size() == 0) {
            System.out.println("No reviews.");
            return;
        }
        
        for (int i = 1; i <= mC.currMov.getReviews().size(); i++) {
            System.out.println("Review " + i + ": " + mC.currMov.getReviews().get(i-1).getComment());
            System.out.println("--------------------------------------------------------------------------------------------------");
        }
    }
    
    /**
     * This method records a review and a rating
     * 
     */
    public void inputReview() {
        
        int rating = CheckUserInput.loopUntilValidInt("Input your rating out of 5: ", 1, 5);
        
        String review = CheckUserInput.loopUntilValidString("Input your review: ", 0);
        
        mC.currMov.addReview(review, rating);
        mC.currMov.updateRating();
    }
    

}

class MovieSalesSort implements Comparator<Movie>{

    @Override
    public int compare(Movie o1, Movie o2) {
        
        return o1.getTicketSale() - o2.getTicketSale();
    }

}

class MovieRatingsSort implements Comparator<Movie>{
    
    @Override
    public int compare(Movie o1, Movie o2) {
        double a, b;
        String s = "NA";
        
        if (o1.getRating().equals(s))
            a = 0;
        else
            a = Double.parseDouble(o1.getRating());
        
        if (o2.getRating().equals(s))
            b = 0;
        else
            b = Double.parseDouble(o2.getRating());
        
        if (a > b)
            return 1;
        if (a == b)
            return 0;
        else 
            return -1;
        
    }

}

