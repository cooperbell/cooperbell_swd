import java.util.Scanner;

public class S1_Computus_Easy {
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
