import java.util.Scanner;

/**
 * Driver class
 */
public class CheckWriterTest {

    /**
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int checkAmount;

        System.out.println("Enter a numeric check amount less than $1000");
        checkAmount = scanner.nextInt();

        CheckWriter checkWriter = new CheckWriter();

    }
}
