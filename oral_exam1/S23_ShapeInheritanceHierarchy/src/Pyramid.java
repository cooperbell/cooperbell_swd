import java.awt.*;

/**
 * Class representing a pyramid
 */
public class Pyramid extends ThreeDimShape {


    /**
     * Constructor initializes length, width, height. Sets colors to default white
     *
     * @param length length of base
     * @param width wdith of base
     * @param height height of pyramid
     */
    Pyramid(double length, double width, double height) {
        this(length, width, height, Color.white);
    }

    /**
     * Constructor initializes length, width, height, color, surface area, and volume
     *
     * @param length length of base
     * @param width width of base
     * @param height height of pyramid
     * @param color color of pyramid
     */
    Pyramid(double length, double width, double height, Color color) {
        super(length, width, height, color);
        double surfaceArea = (length * width) + Math.pow(Math.pow((width / 2), 2) + Math.pow(height, 2), 1 / 2) + (width * Math.pow(Math.pow(length / 2, 2) + Math.pow(height, 2), (1 / 2)));
        double volume = (length * width * height) / 3;
        super.setSurfaceArea(surfaceArea);

    }
}
