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

        // Create 7 movies
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
                                            LocalDate.of(2022,6, k%28),
                                            LocalTime.of(8,30),
                                            k%2==0);
            m.addMovieShowTime(ms);
            mdc.addToDatabase("movieshowtime", ms);
            movieShowTimes.add(ms);
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