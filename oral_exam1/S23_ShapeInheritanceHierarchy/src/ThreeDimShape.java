public class ThreeDimShape extends Shape {
    private double height;
    private double volume;
    private double surfaceArea;

    ThreeDimShape(){}

    ThreeDimShape(double length, double width, double height){
        super(length, width);
        if(height < 0){
            throw new IllegalArgumentException("height cannot be less than 0");
        }
        this.height = height;
        this.volume = getArea() * height;
    }
    ThreeDimShape(double length, double width, double height, String color){
        super(length, width, color);
        this.height = height;
        this.volume = length * width * height;
    }

    public double getVolume() {
        return volume;
    }

    public double getSurfaceArea() {
        return surfaceArea;
    }
}
