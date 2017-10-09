import java.awt.*;

/**
 * Driver class for the Shape Inheritance assignment
 */
public class ShapeInheritanceHierarchyTest {
    /**
     * ShapeInheritanceHierarchyTest method that creates some shapes and demonstrates inheritance
     * @param args arguments
     */
    public static void main(String[] args) {
        Shape s1 = new Shape(5,6, Color.BLUE);
        System.out.println("Color of s1: " + s1.getColor());
        System.out.print("Length of s1: " + s1.getLength());
        System.out.println("Width of s1: " + s1.getWidth());

        TwoDimShape twoD = new TwoDimShape(10,20);
        System.out.println("Length of twoD: " + twoD.getLength());
        System.out.println("Color of twoD: " + twoD.getColor());

        Rect rect = new Rect(100,200,Color.white);
        System.out.println("Area of Rect: " + rect.getArea());
        System.out.println("Perimeter of Rect: " + rect.getPerimeter());

        Circle circle = new Circle(6);
        circle.setXLocation(5);
        circle.setYLocation(5);
        System.out.println("Area of circle: " + circle.getArea());
        System.out.println("Circumference of circle: " + circle.getCircumference());
        System.out.println("x Location of circle: " + circle.getXLocation());
        System.out.println("y Location of circle: " + circle.getYLocation());

        ThreeDimShape cube = new ThreeDimShape(5,6,7);
        System.out.println("Volume of Three D cube:" + cube.getVolume());
        System.out.println("Surface Area of Three D cube: " + cube.getSurfaceArea());

        Pyramid pyramid = new Pyramid(5,6,7,Color.RED);
        System.out.println("Surface Area of pyramid: " + pyramid.getSurfaceArea());
        System.out.println("Volume of pyramid: " + pyramid.getVolume());

        Sphere sphere = new Sphere(14);
        System.out.println("Volume of sphere: " + sphere.getVolume());
        System.out.println("Surface Area of sphere: " + sphere.getSurfaceArea());
    }
}
