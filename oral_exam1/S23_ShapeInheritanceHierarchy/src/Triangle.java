public class Triangle extends TwoDimShape{

    private double perimeter;

    Triangle(double side1, double side2, double side3){
        super(side1, side2);
    }

    @Override
    public double getArea() { return super.getArea()/2; }

    public double getPerimeter(){
        return perimeter;
    }

    public void setPerimeter(double side1, double side2, double side3){
        if(side1 < 0 || side2 < 0 || side3 <0){
            throw new IllegalArgumentException("Side lengths must be >=0");
        }
        this.perimeter = side1 + side2 + side3;
    }
}
