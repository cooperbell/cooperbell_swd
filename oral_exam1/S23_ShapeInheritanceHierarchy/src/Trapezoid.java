import java.awt.*;

public class Trapezoid extends TwoDimShape {

    private double perimeter;

    Trapezoid(double sideA, double sideB, double sideC, double sideD, double height, Color color) {
        super(sideA + sideB, height, color);
        if (sideA < 0 || sideB < 0 || sideC < 0 || sideD < 0) {
            throw new IllegalArgumentException("Sides cannot be less than 0");
        }
        perimeter = sideA + sideB + sideC + sideD;


    }

    @Override
    public double getArea() {
        return super.getArea() / 2;
    }

    @Override
    public double getPerimeter() {
        return perimeter;
    }
}
