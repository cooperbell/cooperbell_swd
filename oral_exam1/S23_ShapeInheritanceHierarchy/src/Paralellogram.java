import java.awt.*;

/**
 * Class representing parallelograms
 */
public class Paralellogram extends TwoDimShape {

    /**
     * Constructor initializes length, width, and sets color to default white
     *
     * @param length length of parallelogram
     * @param width width of parallelogram
     */
    Paralellogram(double length, double width) {
        this(length, width, Color.WHITE);
    }

    /**
     * Constructor initializes length, width, and color
     *
     * @param length length of parallelogram
     * @param width width of parallelogram
     * @param color color of parallelogram
     */
    Paralellogram(double length, double width, Color color) {
        super(length, width, color);
    }

}
