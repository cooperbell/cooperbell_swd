public class Rect extends TwoDimShape {
    private double perimeter;

    Rect(){}

    Rect(double length, double width){
        super(length, width);
    }

    public double getPerimeter(){
        return perimeter;
    }
    public void setPerimeter(double length, double width) {
        this.perimeter = (2*length) + (2*width);
    }
}
