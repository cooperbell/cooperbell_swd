import java.awt.*;

/**
 *
 */
public class ThreeDimShape extends Shape {
    /**
     *
     */
    private double height;

    /**
     *
     */
    private double volume;

    /**
     *
     */
    private double surfaceArea;

    /**
     * @param color
     */
    ThreeDimShape(Color color) {
        this(0, 0, 0, color);
    }

    /**
     * @param length
     * @param width
     * @param height
     */
    ThreeDimShape(double length, double width, double height) {
        this(length, width, height, Color.white);
    }

    /**
     * @param length
     * @param width
     * @param height
     * @param color
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

    /**
     * @return
     */
    public double getVolume() {
        return volume;
    }

    /**
     * @param area
     */
    private void setSurfaceArea(double area) {
        surfaceArea = area * 6;
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
