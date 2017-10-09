import java.awt.*;

/**
 * Class for sphere
 */
public class Sphere extends ThreeDimShape {

    /**
     * radius of sphere
     */
    private double radius;


    /**
     * Constructor initializes radius. Sets color to default white
     *
     * @param radius radius of sphere
     */
    Sphere(double radius) {
        this(radius, Color.white);
    }

    /**
     * Constructor initializes radius, color, surface area, and volume
     *
     * @param radius radius of sphere
     * @param color color of sphere
     */
    Sphere(double radius, Color color) {
        super(color);
        this.radius = radius;
        double surfaceArea = 4 * Math.PI * Math.pow(radius, 2);
        double volume = (4 / 3) * Math.PI * Math.pow(radius, 3);
        super.setSurfaceArea(surfaceArea);
        super.setVolume(volume);
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        if(radius < 0){
            throw new IllegalArgumentException("Radius cannot be less than 0");
        }
        this.radius = radius;
    }

}
