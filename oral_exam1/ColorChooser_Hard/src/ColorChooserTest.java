import javax.swing.*;

public class ColorChooserTest {

    public static void main(String[] args) {
        MyColorChooser MCC = new MyColorChooser();
        MCC.setSize(500, 300);
        MCC.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MCC.setVisible(true);
        MCC.pack();
    }
}
