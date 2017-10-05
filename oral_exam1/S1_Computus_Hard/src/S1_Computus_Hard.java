import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.util.Hashtable;

/**
 * The driver class for the hard portion of the assignment
 */
public class S1_Computus_Hard {

    /**
     * Main is a test method, which tests the Easter class's logic against a Hashtable of Easter dates from 1997 to 2017
     * Source: https://en.wikipedia.org/wiki/List_of_dates_for_Easter -- Western dates
     *
     * @param args arguments
     */
    @Test
    public static void main(String[] args) {

        Hashtable<Integer, String> dates = new Hashtable<>();
        dates.put(1997, "March 30, 1997");
        dates.put(1998, "April 12, 1998");
        dates.put(1999, "April 4, 1999");
        dates.put(2000, "April 23, 2000");
        dates.put(2001, "April 15, 2001");
        dates.put(2002, "March 31, 2002");
        dates.put(2003, "April 20, 2003");
        dates.put(2004, "April 11, 2004");
        dates.put(2005, "March 27, 2005");
        dates.put(2006, "April 16, 2006");
        dates.put(2007, "April 8, 2007");
        dates.put(2008, "March 23, 2008");
        dates.put(2009, "April 12, 2009");
        dates.put(2010, "April 4, 2010");
        dates.put(2011, "April 24, 2011");
        dates.put(2012, "April 8, 2012");
        dates.put(2013, "March 31, 2013");
        dates.put(2014, "April 20, 2014");
        dates.put(2015, "April 5, 2015");
        dates.put(2016, "March 27, 2016");
        dates.put(2017, "April 16, 2017");

        for(int i = 1997; i < 2017; i++){
            Easter e = new Easter(i);
            String date = e.getDate();
            assertEquals(dates.get(i), date + ", " + i);
        }
    }
}
