import javax.swing.*;

/**
 * Driver class for ColorChooser assignment
 */
public class ColorChooserTest {

    /**
     * Instantiates class MyColorChooser
     *
     * @param args arguments
     */
    public static void main(String[] args) {

        MyColorChooser mcc = new MyColorChooser();
        mcc.setSize(500, 300);
        mcc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mcc.pack();
        mcc.setVisible(true);
    }
}
