import java.awt.*;

/**
 * Second tier class for two-dimensional shapes
 */
public class TwoDimShape extends Shape {

    /**
     * Constructor initializes color. Automatically sets length and width to 0
     *
     * @param color color of 2D shape
     */
    TwoDimShape(Color color){
        this(0,0, color);
    }

    /**
     * Constructor initializes length and width. Automatically sets color empty string
     *
     * @param length length of 2D shape
     * @param width width of 2D shape
     */
    TwoDimShape(double length, double width){
        this(length, width, Color.white);
    }

    /**
     * Constructor initializes color, length, and width using a call to the super constructor
     *
     * @param length length of 2D shape
     * @param width width of 2D shape
     * @param color color of 2D shape
     */
    TwoDimShape(double length, double width, Color color){
        super(length, width, color);
    }


}
