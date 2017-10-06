import java.awt.*;

/**
 * Class for triangle shapes. Directly inherits from TwoDimShape
 */
public class Triangle extends TwoDimShape{

    /**
     * double representing the perimeter of a triangle
     */
    private double perimeter;

    /**
     *Constructor initializes the sides. Color set to default white
     *
     * @param side1 double - side of triangle
     * @param side2 double - side of triangle
     * @param side3 double - side of triangle
     */
    Triangle(double side1, double side2, double side3){
        this(side1, side2, side3, Color.white);
    }

    /**
     *Constructor initializes the sides and color
     *
     * @param side1 double - side of triangle
     * @param side2 double - side of triangle
     * @param side3 double - side of triangle
     * @param color Color object for color of triangle
     */
    Triangle(double side1, double side2, double side3, Color color){
        super(side1, side2, color);
        if(side1 < 0 || side2 < 0 || side3 <0){
            throw new IllegalArgumentException("Side lengths must be >=0");
        }
        this.perimeter = side1 + side2 + side3;
    }

    /**
     *Getter for area of triangle
     *
     * @return area variable
     */
    @Override
    public double getArea() { return super.getArea()/2; }

    /**
     *Getter for perimeter of triangle
     *
     * @return perimeter variable
     */
    public double getPerimeter(){
        return perimeter;
    }


}
