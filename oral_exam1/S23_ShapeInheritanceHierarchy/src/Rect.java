import java.awt.*;

/**
 * Class representing a 2D rectangle
 */
public class Rect extends TwoDimShape {

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

    }
}
