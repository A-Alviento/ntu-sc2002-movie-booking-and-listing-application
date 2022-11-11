import java.io.File;
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


        // Create 3 cinemas for each cineplex
        for (Cineplexes cp : cineplexes) {
            int cinemaCount = 0;
            for (char c = 'A'; c < 'D'; ++c) {
                int cineplexId = cp.getId();
                String s = new StringBuilder(Character.toString(cineplexId)).append(Character.toString(c)).toString();
                Cinema cinema = new Cinema(s, CinemaClass.values()[cinemaCount], cinemaCount, cineplexId);
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

        // Create movie showing

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