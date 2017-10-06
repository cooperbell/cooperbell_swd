import java.awt.*;

/**
 * Class for squares
 */
public class Square extends TwoDimShape {

    /**
     * Constructor initializes side lengths. Sets color to default white
     *
     * @param sideLength length of the square's sides
     */
    Square(double sideLength) {
        this(sideLength, Color.WHITE);
    }

    /**
     * Constructor initializes side lengths and color.
     *
     * @param sideLength length of the square's sides
     * @param color color of square
     */
    Square(double sideLength, Color color) {
        super(sideLength, sideLength, color);
    }
}
