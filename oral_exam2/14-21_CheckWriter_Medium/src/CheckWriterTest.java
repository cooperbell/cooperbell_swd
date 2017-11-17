import java.util.Scanner;

/**
 * Driver class for Check Writer assignment
 */
public class CheckWriterTest {

    /**
     * Main method. Instantiates new CheckWriter and invokes writeNumber class with a user specified number that's less
     * than $1000 US dollars
     * @param args command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double checkAmount;
        String finalNum;

        System.out.println("Enter a numeric check amount less than $1000");
        checkAmount = scanner.nextDouble();

        CheckWriter checkWriter = new CheckWriter();
        finalNum = checkWriter.writeNumber(checkAmount);

        System.out.println(finalNum);
    }
}
