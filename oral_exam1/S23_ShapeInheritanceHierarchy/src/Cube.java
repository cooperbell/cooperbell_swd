import java.awt.*;

/**
 *
 */
public class Cube extends ThreeDimShape {

    /**
     *
     * @param length
     * @param width
     * @param height
     */
    Cube(double length, double width, double height) {
        this(length, width, height, Color.white);

    }

    /**
     *
     * @param length
     * @param width
     * @param height
     * @param color
     */
    Cube(double length, double width, double height, Color color) {
        super(length, width, height, color);
    }


}
