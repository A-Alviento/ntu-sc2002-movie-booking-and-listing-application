import java.io.File;

import model.*;

/**
 * Fill the database with dummy test entries. Will wipe the current database if
 * it already exists. Since we don't want repeat entries.
 */
public class FillDatabaseMain extends Main{
    @Override
    public void mainBody() throws Exception {
        Movie m1 = new Movie("Movie 1");
        m1.setDirector("Director 1");
        m1.addCast("Cast A1");
        m1.addCast("Cast B1");
        m1.setSynopsis("Synopsis 1");
        m1.setMovieStatus(MovieStatus.COMING_SOON);
        m1.setBlockbuster(false);
        mdc.addToDatabase("movie", m1);

        Movie m2 = new Movie("Movie 2");
        m2.setDirector("Director 2");
        m2.addCast("Cast A2");
        m2.addCast("Cast B2");
        m2.setSynopsis("Synopsis 2");
        m2.setMovieStatus(MovieStatus.NOW_SHOWING);
        m2.setBlockbuster(false);
        mdc.addToDatabase("movie", m2);

        Movie m3 = new Movie("Movie 3");
        m3.setDirector("Director 3");
        m3.addCast("Cast A3");
        m3.addCast("Cast B3");
        m3.setSynopsis("Synopsis 3");
        m3.setMovieStatus(MovieStatus.NOW_SHOWING);
        m3.setBlockbuster(true);
        mdc.addToDatabase("movie", m3);

        Movie m4 = new Movie("Movie 4");
        m4.setDirector("Director 4");
        m4.addCast("Cast A4");
        m4.addCast("Cast B4");
        m4.setSynopsis("Synopsis 4");
        m4.setMovieStatus(MovieStatus.NOW_SHOWING);
        m4.setBlockbuster(true);
        mdc.addToDatabase("movie", m4);

        Movie m5 = new Movie("Movie 5");
        m5.setDirector("Director 5");
        m5.addCast("Cast A5");
        m5.addCast("Cast B5");
        m5.setSynopsis("Synopsis 5");
        m5.setMovieStatus(MovieStatus.NOW_SHOWING);
        m5.setBlockbuster(false);
        mdc.addToDatabase("movie", m5);

        Movie m6 = new Movie("Movie 6");
        m6.setDirector("Director 6");
        m6.addCast("Cast A6");
        m6.addCast("Cast B6");
        m6.setSynopsis("Synopsis 6");
        m6.setMovieStatus(MovieStatus.END_OF_SHOWING);
        m6.setBlockbuster(false);
        mdc.addToDatabase("movie", m6);

        Movie m7 = new Movie("Movie 7");
        m7.setDirector("Director 7");
        m7.addCast("Cast A7");
        m7.addCast("Cast B7");
        m7.setSynopsis("Synopsis 7");
        m7.setMovieStatus(MovieStatus.PREVIEW);
        m7.setBlockbuster(false);
        mdc.addToDatabase("movie", m7);

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