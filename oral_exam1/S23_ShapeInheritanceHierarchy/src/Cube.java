import java.awt.*;

/**
 * Class for cubes
 */
public class Cube extends ThreeDimShape {

    /**
     * Constructor initializes length, width, height. Sets color to default white
     *
     * @param length length of base
     * @param width width of base
     * @param height height of cube
     */
    Cube(double length, double width, double height) {
        this(length, width, height, Color.white);

    }

    /**
     * Constructor initializes length, width, height, colors, surface area and volume
     *
     * @param length length of base
     * @param width width of base
     * @param height height of cube
     * @param color color of cube
     */
    Cube(double length, double width, double height, Color color) {
        super(length, width, height, color);
        double surfaceArea = (length * width) * 6;
        double volume = length * width * height;
        super.setSurfaceArea(surfaceArea);
        super.setVolume(volume);
    }


}
