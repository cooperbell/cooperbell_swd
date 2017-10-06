import java.awt.*;

public class Square extends TwoDimShape {

    Square(double sideLength) {
        this(sideLength, Color.WHITE);
    }

    Square(double sideLength, Color color) {
        super(sideLength, sideLength, color);
    }
}
