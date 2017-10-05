import java.awt.*;

/**
 * First tier class in this Shape Inheritance Hierarchy assignment. All following classes directly or indirectly inherit
 * from this Shape class
 */
class Shape {
    /**
     * double representing the area shape
     */
    private double area;

    /**
     * double representing the length of the shape
     */
    private double length;

    /**
     * double representing the width of the shape
     */
    private double width;

    /**
     *  Color object representing the color of the shape
     */
    private Color color;

    /**
     * double for the x location on a GUI, i.e. a JFrame
     */
    private double xLocation;

    /**
     * double for the u location on a GUI, i.e. a JFrame
     */
    private double yLocation;

    /**
     * Default constructor
     */
    Shape() {
        this(0, 0, Color.white );
    }

    /**
     * Constructor initializes color object. Length and width automatically initialized to 0
     *
     * @param color Color of shape
     */
    Shape(Color color) {
        this(0, 0, Color.white);
    }

    /**
     *Constructor initializes length and width. Automatically sets Color object to white
     *
     * @param length length of shape
     * @param width width of shape
     */
    Shape(double length, double width) {
        this(length, width, Color.white);
    }

    /**
     *Constructor initializes length, width, and color of shape
     *
     * @param length length of shape
     * @param width width of shape
     * @param color color of shape
     */
    Shape(double length, double width, Color color) {
        if (length < 0 || width < 0) {
            throw new IllegalArgumentException("Length or width invalid cannot be < 0");
        }
        this.length = length;
        this.width = width;
        this.color = color;
        this.area = length * width;
    }

    /**
     * Getter for the length variable
     *
     * @return length of shape
     */
    public double getLength() {
        return length;
    }

    /**
     * Setter for the length variable
     *
     * @param length length of shape
     */
    public void setLength(double length) {
        if (length < 0) {
            throw new IllegalArgumentException("Length invalid cannot be < 0");
        }
        this.length = length;
    }

    /**
     *Getter for width variable
     *
     * @return width of shape
     */
    public double getWidth() {
        return width;
    }

    /**
     *Seter for width variable
     *
     * @param width width of shape
     */
    public void setWidth(double width) {
        if (width < 0) {
            throw new IllegalArgumentException("Width invalid cannot be < 0");
        }
        this.width = width;
    }

    /**
     *Getter for area variable
     *
     * @return area of shape
     */
    public double getArea() {
        return area;
    }


    /**
     *Getter for color variable
     *
     * @return color of shape
     */
    public Color getColor() {
        return color;
    }

    /**
     *Setter for color variable
     *
     * @param color color of shape
     */
    public void setColor(Color color) {
        this.color = color;
    }

    /**
     * Setter for the xLocation variable
     *
     * @param x the x coordinate
     */
    public void setxLocation(double x){
        this.xLocation = x;
    }

    /**
     * Getter for the xLocation variable
     *
     * @return the x coordinate
     */
    public double getxLocation(){
        return xLocation;
    }

    /**
     * Setter for the yLocation variable
     *
     * @param y the y coordinate
     */
    public void setyLocation(double y){
        this.yLocation = y;
    }

    /**
     * Getter for the yLocation variable
     *
     * @return the y coordinate
     */
    public double getyLocation() {
        return yLocation;
    }
}
