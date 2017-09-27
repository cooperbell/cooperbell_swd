public class Main {
    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        Shape s1 = new Shape(5,6, "Blue");
        System.out.println("Color of s1: " + s1.getColor());
        System.out.print("Length of s1: " + s1.getLength());
        System.out.println("Width of s1: " + s1.getWidth());
    }
}
