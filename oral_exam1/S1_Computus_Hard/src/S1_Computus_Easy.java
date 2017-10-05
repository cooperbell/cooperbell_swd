import java.util.Scanner;

/**
 * The driver class for the easy portion of the assignment
 */
public class S1_Computus_Easy {
    /**
     *  User enters a year, then this method calls class Easter's getDate() method to get the date and print it out
     * @param args the arguments
     */
    public static void main(String[] args) {

        //Need code here to take in user input
        Scanner reader = new Scanner(System.in);
        System.out.println("Enter a year: ");
        int n = reader.nextInt();

        Easter e = new Easter(n);
        String date = e.getDate();
        System.out.println(date);
    }
}
