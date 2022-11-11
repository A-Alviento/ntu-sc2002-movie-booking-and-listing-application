import io.ModelDatabase;

/**
 * Print all items in the database, for debugging purpose.
 */
public class TestDatabaseMain extends Main{
    @Override
    public void mainBody() throws Exception {
        // "booking", "cinema", "cineplexes", "customeraccount", "movie",
        // "movieshowing", "review", "publicholiday"

        System.out.println("List of models and respective database size:");
        System.out.println("--------------------------------------------");
        for (String s : ModelDatabase.modelKeywords) {
            System.out.println(s + " : size = " + mdc.getArrayList(s).size());
        }
    }

    public static void main(String args[]) {
       new TestDatabaseMain();
    }
}
