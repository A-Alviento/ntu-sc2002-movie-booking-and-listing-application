import java.io.File;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import model.*;

/**
 * Fill the database with dummy test entries. Will wipe the current database if
 * it already exists. Since we don't want repeat entries.
 */
public class FillDatabaseMain extends Main{
    @Override
    public void mainBody() throws Exception {
        ArrayList<Cineplexes> cineplexes = mdc.getEphemeralArrayList("cineplexes");
        ArrayList<Cinema> cinemas = new ArrayList<>();
        ArrayList<Movie> movies = new ArrayList<>();
        ArrayList<MovieShowTime> movieShowTimes = new ArrayList<>();
        ArrayList<CustomerAccount> customers = new ArrayList<>();
        int k;

        
        // Create 3 cinemas for each cineplex
        for (Cineplexes cp : cineplexes) {
            int cinemaCount = 0;
            for (char c = 'A'; c < 'D'; ++c) {
                String s;
                if(cp.getCineplexNum() == 0)
                    s = "A";
                else if (cp.getCineplexNum() == 1)
                    s = "B";
                else
                    s = "C";
                Cinema cinema = new Cinema(s + c, CinemaClass.values()[cinemaCount], cinemaCount, cp.getCineplexNum());
                mdc.addToDatabase("cinema", cinema);
                cp.addCinema(cinema);
                cinemas.add(cinema);
                cinemaCount++;
            }
        }

        // Create 7 movies and 3 reviews for each respectively
        for (int i = 0; i < 7; i++) {
            String id = Integer.toString(i);
            Movie movie = new Movie("Movie " + id);
            movie.setDirector("Director " + id);
            movie.addCast("Cast A"+id);
            movie.addCast("Cast B"+id);
            movie.setSynopsis("Synopsis "+id);
            movie.setMovieStatus(MovieStatus.values()[i % 4]);
            movie.setBlockbuster(i % 2 == 0);
            mdc.addToDatabase("movie", movie);
            movies.add(movie);

            for (int j = 0; j < 3; j++) {
                // generate R such that it is psuedo-random - to get random average
                // for testing sort
                int R = (i * 57 + 12 * 7*j) % 5 + 1;
                switch(R) {
                    case 1:
                    case 2:
                        movie.addReview("Very bad. Don't go and see it.", R);
                        break;
                    case 3:
                    case 4:
                        movie.addReview("Meh. So so.", R);
                        break; 
                    case 5:
                        movie.addReview("Get out of your seats and go buy a ticket.", R);
                        break;
                    default:
                        movie.addReview("Default comment", R);
                        break;
                } 
                //mdc.addToDatabase("review", review);
            }
        }

        // For each movie create 2 movie showing at 2 cinemas
        k = 0;
        int movieSize = cinemas.size();
        for (Movie m : movies) {
            MovieShowTime ms = new MovieShowTime(
                                            cinemas.get(k++ % movieSize),
                                            LocalDate.of(2022,6, k%28),
                                            LocalTime.of(6,30),
                                            k%2==0);
            m.addMovieShowTime(ms);
            mdc.addToDatabase("movieshowtime", ms);
            movieShowTimes.add(ms);

            ms = new MovieShowTime(
                                            cinemas.get(k++ % movieSize),
                                            LocalDate.of(2030,6, k%28),
                                            LocalTime.of(8,30),
                                            k%2==0);
            m.addMovieShowTime(ms);
            mdc.addToDatabase("movieshowtime", ms);
            movieShowTimes.add(ms);
        }

    for (int i = 0; i < 10; i++) {
        CustomerAccount ca = new CustomerAccount(
                                    "Customer " + Integer.toString(i),
                                    "email" + Integer.toString(i) + "@gmail.com",
                                    Integer.toString(61202200+i),
                                    "password" + Integer.toString(i),
                                    20+i
        );
        mdc.addToDatabase("customeraccount", ca);
        customers.add(ca);
    }
}

    public static void main(String args[]) {
        try {
            File databaseFile = new File(Main.MODELDATABASEPATH);
            if (databaseFile.exists()) {
                databaseFile.delete();
            }
            new FillDatabaseMain();
        }  catch (Exception except) {

        }
    }
}