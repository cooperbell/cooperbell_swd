import java.awt.*;

/**
 * Class represents trapezoids
 */
public class Trapezoid extends TwoDimShape {

    /**
     * Perimeter of trapezoid
     */
    private double perimeter;

    /**
     * Constructor initializes sides. Sets color to default white
     *
     * @param sideA  side of trapezoid
     * @param sideB  side of trapezoid
     * @param sideC  side of trapezoid
     * @param sideD  side of trapezoid
     * @param height height of trapezoid
     */
    Trapezoid(double sideA, double sideB, double sideC, double sideD, double height) {
        super(sideA + sideB, height, Color.WHITE);
    }

    /**
     * Constructor initializes sides, color and perimeter
     *
     * @param sideA  side of trapezoid
     * @param sideB  side of trapezoid
     * @param sideC  side of trapezoid
     * @param sideD  side of trapezoid
     * @param height height of trapezoid
     * @param color  color of trapezoid
     */
    Trapezoid(double sideA, double sideB, double sideC, double sideD, double height, Color color) {
        super(sideA + sideB, height, color);
        if (sideA < 0 || sideB < 0 || sideC < 0 || sideD < 0) {
            throw new IllegalArgumentException("Sides cannot be less than 0");
        }
        perimeter = sideA + sideB + sideC + sideD;
    }

    /**
     * @return the area of the trapezoid divided by 2
     */
    @Override
    public double getArea() {
        return super.getArea() / 2;
    }

    /**
     * Getter for the perimeter variable
     *
     * @return the perimeter of the trapezoid
     */
    @Override
    public double getPerimeter() {
        return perimeter;
    }
}
