import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

public class KeyGenerator {
//    private int startPoint;

    /**
     * Uses PrinterWriter to generate a new file in the user specified file location. Generates a random number that
     * corresponds to the 'start point' of the encryption key and then generates n random values.
     *
     * @param n number of values to generate
     * @param fileLocation the file location of the key file
     */
    public void generateKeyFile(int n, String fileLocation){
        Random rand = new Random();
        try{
            PrintWriter writer = new PrintWriter(fileLocation);
            int r = rand.nextInt(n);
            System.out.println("Starting point: " + r);
            writer.println(r); //this is the starting position int

            for (int i = 0; i < n; i++){
                r = rand.nextInt(20);
                writer.println(r);
                System.out.println(r);
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Unable to create file in specified location");
        }
    }

//    public int getStartPoint() {
//        return startPoint;
//    }
//
//    public void setStartPoint(int startPoint) {
//        this.startPoint = startPoint;
//    }

}
