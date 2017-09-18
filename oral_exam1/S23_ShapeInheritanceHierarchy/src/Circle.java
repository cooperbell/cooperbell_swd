public class Circle extends TwoDimShape {

    private double radius;
    private double circumference;
    private double area;

    Circle(double radius) {
        this.radius = radius;
        this.area = Math.PI * Math.pow(radius, 2);
        circumference = 2 * Math.PI * radius;
    }

    public double getArea() {
        return area;
    }

    public double getCircumference() {
        return circumference;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        if (radius < 0.0){
            throw new IllegalArgumentException("Radius must be at >= 0");
        }
        this.radius = radius;
        this.area = Math.PI * Math.pow(radius, 2);
        this.circumference = 2 * Math.PI * radius;
    }
}
