class Shape {
    private double area;
    private double length;
    private double width;
    private String color;

    Shape() {
        this(0, 0, "");
    }

    Shape(String color) {
        this(0, 0, color);
    }

    Shape(double length, double width) {
        this(length, width, "");
    }

    Shape(double length, double width, String color) {
        if (length < 0 || width < 0) {
            throw new IllegalArgumentException("Length or width invalid cannot be < 0");
        }
        this.length = length;
        this.width = width;
        this.color = color;
        this.area = length * width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        if (length < 0) {
            throw new IllegalArgumentException("Length invalid cannot be < 0");
        }
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        if (width < 0) {
            throw new IllegalArgumentException("Width invalid cannot be < 0");
        }
        this.width = width;
    }

    public double getArea() {
        return area;
    }


    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }


}
