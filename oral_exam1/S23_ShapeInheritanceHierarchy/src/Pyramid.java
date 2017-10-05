import java.awt.*;

/**
 *
 */
public class Pyramid extends ThreeDimShape {
    /**
     *
     */
    private double surfaceArea;

    /**
     *
     * @param length
     * @param width
     * @param height
     */
    Pyramid(double length, double width, double height) {
        this(length, width, height, Color.white);
    }

    /**
     *
     * @param length
     * @param width
     * @param height
     * @param color
     */
    Pyramid(double length, double width, double height, Color color) {
        super(length, width, height, color);
        setSurfaceArea();

    }

    /**
     *
     * @return
     */
    @Override
    public double getVolume() {
        return super.getVolume() / 3;
    }


    /**
     *
     */
    private void setSurfaceArea(){
        double l = getLength();
        double w = getWidth();
        double h = getHeight();
        this.surfaceArea = (l*w) + Math.pow(Math.pow((w/2),2)+Math.pow(h,2),1/2) + (w*Math.pow(Math.pow(l/2,2)+Math.pow(h,2),(1/2)));
    }

    /**
     *
     * @return
     */
    @Override
    public double getSurfaceArea(){
        return this.surfaceArea;
    }
}
