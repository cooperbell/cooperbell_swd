import java.awt.*;

/**
 * Class for three dimensional shapes. Directly inherits from Shape
 */
public class ThreeDimShape extends Shape {
    /**
     * height of three dimensional shape
     */
    private double height;

    /**
     * volume of three dimensional shape
     */
    private double volume;

    /**
     * surface area of three dimensional shape
     */
    private double surfaceArea;

    /**
     * Constructor initializes color. Sets length, width, and height to default 0
     *
     * @param color color of three dimensional shape
     */
    ThreeDimShape(Color color) {
        this(0, 0, 0, color);
    }

    /**
     * Constructor initializes length, width, and height
     *
     * @param length length of three dimensional shape
     * @param width width of three dimensional shape
     * @param height height of three dimensional shape
     */
    ThreeDimShape(double length, double width, double height) {
        this(length, width, height, Color.white);
    }

    /**
     * Constructor initializes length, width, height, and color
     *
     * @param length length of three dimensional shape
     * @param width width of three dimensional shape
     * @param height height of three dimensional shape
     * @param color color of three dimensional shape
     */
    ThreeDimShape(double length, double width, double height, Color color) {
        super(length, width, color);
        if (height < 0) {
            throw new IllegalArgumentException("height cannot be less than 0");
        }
        this.height = height;
        this.volume = getArea() * height;
        setSurfaceArea(getArea());
    }

    public void setVolume(double volume){
        this.volume = volume;
    }
    /**
     * Getter for volume variable
     *
     * @return volume of three dimensional shape
     */
    public double getVolume() {
        return volume;
    }

    /**
     * Setter for surface area variable
     *
     * @param surfaceArea area of the three dimensional shape
     */
    public void setSurfaceArea(double surfaceArea) {
        this.surfaceArea = surfaceArea;
    }

    /**
     * @return
     */
    public double getSurfaceArea() {
        return surfaceArea;
    }

    /**
     * @return
     */
    public double getHeight() {
        return height;
    }
}
