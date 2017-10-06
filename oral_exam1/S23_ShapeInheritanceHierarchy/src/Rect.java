import java.awt.*;

/**
 * Class representing a 2D rectangle
 */
public class Rect extends TwoDimShape {
    /**
     *
     */
    private double perimeter;

    /**
     *
     * @param length length of rect
     * @param width width of rect
     */
    Rect(double length, double width){
        super(length, width, Color.white);
    }

    /**
     *
     * @param length length of rect
     * @param width width of rect
     * @param color color of rect
     */
    Rect(double length, double width, Color color){
        super(length, width, color);
        if (length < 0 || width < 0) {
            throw new IllegalArgumentException("Length or width invalid cannot be < 0");
        }
        perimeter = (2*length) + (2*width);
    }

    /**
     *
     * @return perimeter of rect
     */
    public double getPerimeter(){
        return perimeter;
    }
}
