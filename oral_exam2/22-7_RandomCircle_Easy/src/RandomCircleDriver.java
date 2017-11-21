import javax.swing.*;
import java.util.Random;

/**
 * Driver class for RandomCircle assignment
 */
public class RandomCircleDriver {

    /**
     * Instantiates class RandomCircleDriver
     *
     * @param args arguments
     */
    public static void main(String[] args) {

        Random random = new Random();
        RandomCircle rc = new RandomCircle(random.nextInt(20) + 5);
        rc.setSize(500, 1000);
        rc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        rc.setVisible(true);

    }
}

