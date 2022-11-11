import java.util.ArrayList;

import io.ModelDatabase;
import model.*;

/**
 * Print all items in the database, for debugging purpose.
 */
public class TestDatabaseMain extends Main{
    @Override
    public void mainBody() throws Exception {
        // "booking", "cinema", "cineplexes", "customeraccount", "movie",
        // "movieshowtime", "review", "publicholiday"

        System.out.println("List of models and respective database size:");
        System.out.println("--------------------------------------------");
        for (String s : ModelDatabase.modelKeywords) {
            ArrayList<Model> models = mdc.getArrayList(s);
            System.out.println(s + " : size = " + models.size());

            for (Model m: models) {
                showAttributes(s, m);
            }

            System.out.println("--------------------------------------------");
        }

    }

    public static void main(String args[]) {
       new TestDatabaseMain();
    }

    public static void showAttributes(String keyword, Model m) {
        ArrayList<Object> printable = new ArrayList<>();
        printable.add("#"+Integer.toString(m.hashCode()));

        switch(keyword) {
            case "cinema":
                printable.add(((Cinema) m).getCinemaCode());
                printable.add(((Cinema) m).getCinemaClass());
                printable.add(((Cinema) m).getCinemaHall());
                printable.add(((Cinema) m).getCineplexNum());
                break;
            case "cineplexes":
                printable.add(((Cineplexes) m).getLocation());
                printable.add(((Cineplexes) m).getOpeningTime());
                printable.add(((Cineplexes) m).getCinema());
                break;
            case "movie":
                printable.add(((Movie)m).getTitle());
                printable.add(((Movie)m).getTicketSale());
                printable.add(((Movie)m).getClass());
                printable.add(((Movie)m).getDirector());
                printable.add(((Movie)m).getRating());
                printable.add(((Movie)m).getSynopsis());
                printable.add(((Movie)m).getCasts());
                printable.add(((Movie)m).getCensorship());
                printable.add(((Movie)m).getMovieShowTimes());
                printable.add(((Movie)m).getMovieStatus());
                printable.add(((Movie)m).getReviews());
                break;
            default:
                break;
        }
        showPrintable(printable);

    }

    public static void showPrintable(ArrayList<Object> printable) {
        for (Object o: printable) {
            System.out.print(convertToPrintable(o) + "\t");
        }
        System.out.println();
    }

    @SuppressWarnings("unchecked")
    public static String convertToPrintable(Object o) {
        if (o == null) {
            return "null";
        }

        if (o instanceof Model) {
            return "#"+Integer.toString(o.hashCode());
        } else if (o instanceof ArrayList) {
            String ret = "ArrayList[";
            ArrayList<Object> al = (ArrayList<Object>)o;
            for (Object os : al) {
                ret += convertToPrintable(os) +", ";
            }
            ret += "]";
            return ret;
        } else if (o.getClass().isArray()) {
            String ret = "[";
            for (Object os : (Object[]) o) {
                ret += convertToPrintable(os) + ", ";
            }
            ret += "]";
            return ret;
        }
        return o.toString();
    }
}
