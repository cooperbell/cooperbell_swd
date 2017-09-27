public class Rect extends TwoDimShape {
    private double perimeter;

    Rect(){}

    Rect(double length, double width){
        super(length, width);
        if (length < 0 || width < 0) {
            throw new IllegalArgumentException("Length or width invalid cannot be < 0");
        }
        perimeter = (2*length) + (2*width);
    }

    public double getPerimeter(){
        return perimeter;
    }

    public void setPerimeter(double length, double width) {
        this.perimeter = (2*length) + (2*width);
    }
}
