import java.awt.*;

/**
 *
 */
public class Circle extends TwoDimShape {

    /**
     *
     */
    private double radius;

    /**
     *
     */
    private double circumference;

    /**
     *
     */
    private double area;

    /**
     *
     * @param radius
     */
    Circle(double radius) {
        this(radius, Color.white);
    }

    /**
     *
     * @param radius
     * @param color
     */
    Circle(double radius, Color color){
        super(color);
        if(radius < 0){
            throw new IllegalArgumentException("height cannot be less than 0");
        }
        this.radius = radius;
        this.area = Math.PI * Math.pow(radius, 2);
        circumference = 2 * Math.PI * radius;
    }

    /**
     *
     * @return
     */
    public double getArea() {
        return area;
    }

    /**
     *
     * @return
     */
    public double getCircumference() {
        return circumference;
    }

    /**
     *
     * @return
     */
    public double getRadius() {
        return radius;
    }

    /**
     *
     * @param radius
     */
    public void setRadius(double radius) {
        if (radius < 0.0){
            throw new IllegalArgumentException("Radius must be at >= 0");
        }
        this.radius = radius;
        this.area = Math.PI * Math.pow(radius, 2);
        this.circumference = 2 * Math.PI * radius;
    }
}
