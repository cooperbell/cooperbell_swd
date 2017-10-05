import java.awt.*;

/**
 *
 */
public class Sphere extends ThreeDimShape {

    /**
     *
     */
    private double radius;

    /**
     *
     */
    private double volume;

    /**
     *
     */
    private double surfaceArea;

    /**
     *
     * @param radius
     */
    Sphere(double radius){
        this(radius, Color.white);
    }

    /**
     *
     * @param radius
     * @param color
     */
    Sphere(double radius, Color color) {
        super(color);
        this.radius = radius;
        setVolume();
        setSurfaceArea();
    }

    /**
     *
     */
    private void setVolume() {
        volume = (4 / 3) * Math.PI * Math.pow(radius, 3);
    }

    /**
     *
     * @return
     */
    public double getVolume() {
        return volume;
    }

    /**
     *
     */
    private void setSurfaceArea() {
        surfaceArea = 4 * Math.PI * Math.pow(radius, 2);
    }

    /**
     *
     * @return
     */
    public double getSurfaceArea(){
        return surfaceArea;
    }
}
