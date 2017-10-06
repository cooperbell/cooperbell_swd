import java.awt.*;

/**
 * Represents a two dimensional circle. Inherits directly from TwoDimShape Class
 */
public class Circle extends TwoDimShape {

    /**
     * radius of the circle
     */
    private double radius;

    /**
     * circumference of the circle
     */
    private double circumference;

    /**
     * area of the circle
     */
    private double area;

    /**
     * Constructor initializes the radius. Sets color to a default white
     *
     * @param radius radius of circle
     */
    Circle(double radius) {
        this(radius, Color.white);
    }

    /**
     * Constructor initializes the radius and color.
     *
     * @param radius radius of circle
     * @param color color of circle
     */
    Circle(double radius, Color color) {
        super(color);
        if (radius < 0) {
            throw new IllegalArgumentException("height cannot be less than 0");
        }
        this.radius = radius;
        this.area = Math.PI * Math.pow(radius, 2);
        circumference = 2 * Math.PI * radius;
    }

    /**
     * Getter for area variable
     *
     * @return area of circle
     */
    public double getArea() {
        return area;
    }

    /**
     * Setter for area variable
     *
     * @param radius radius of circle
     */
    public void setArea(double radius) {
        if (radius < 0) {
            throw new IllegalArgumentException("Radius cannot be less than 0");
        }
        this.radius = radius;
        this.area = Math.PI * Math.pow(radius, 2);
    }

    /**
     * Getter for circumference variable
     *
     * @return circumference of circle
     */
    public double getCircumference() {
        return circumference;
    }

    /**
     * Seter for circumference variable
     *
     * @param radius radius of circle
     */
    public void setCircumference(double radius) {
        this.circumference = 2 * Math.PI * radius;
    }

    /**
     * Getter for radius of circle
     *
     * @return radius of circle
     */
    public double getRadius() {
        return radius;
    }

    /**
     * Setter for radius variable
     *
     * @param radius radius of circle
     */
    public void setRadius(double radius) {
        if (radius < 0.0) {
            throw new IllegalArgumentException("Radius must be at >= 0");
        }
        this.radius = radius;
        this.area = Math.PI * Math.pow(radius, 2);
        this.circumference = 2 * Math.PI * radius;
    }
}
