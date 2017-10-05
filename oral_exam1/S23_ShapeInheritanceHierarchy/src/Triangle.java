import java.awt.*;

/**
 *
 */
public class Triangle extends TwoDimShape{

    /**
     *
     */
    private double perimeter;

    /**
     *
     * @param side1
     * @param side2
     * @param side3
     */
    Triangle(double side1, double side2, double side3){
        this(side1, side2, side3, Color.white);
    }

    /**
     *
     * @param side1
     * @param side2
     * @param side3
     * @param color
     */
    Triangle(double side1, double side2, double side3, Color color){
        super(side1, side2, color);
    }

    /**
     *
     * @return
     */
    @Override
    public double getArea() { return super.getArea()/2; }

    /**
     *
     * @return
     */
    public double getPerimeter(){
        return perimeter;
    }

    /**
     *
     * @param side1
     * @param side2
     * @param side3
     */
    public void setPerimeter(double side1, double side2, double side3){
        if(side1 < 0 || side2 < 0 || side3 <0){
            throw new IllegalArgumentException("Side lengths must be >=0");
        }
        this.perimeter = side1 + side2 + side3;
    }
}
