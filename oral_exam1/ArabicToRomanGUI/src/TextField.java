import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Houses all the GUI components and runs everything GUI-related
 */
public class TextField extends JFrame {
    /**
     * Text field where the roman numerals go
     */
    private JTextField romanTextField;

    /**
     * Text field where arabic numbers go
     */
    private JTextField arabicTextField;

    /**
     * Constructor
     * Sets up the JTextfields
     */
    public TextField() {
        super("Arabic to Roman GUI");
        setLayout(new FlowLayout());

        JLabel romanLabel = new JLabel("Roman: ", JLabel.LEFT);
        romanTextField = new JTextField(10);
        add(romanLabel);
        add(romanTextField);

        JLabel arabicLabel = new JLabel("Arabic: ", JLabel.CENTER);
        arabicTextField = new JTextField(10);
        add(arabicLabel);
        add(arabicTextField);

        //setup key listeners
        romanTextField.addKeyListener(new RomanKeyListener());
        arabicTextField.addKeyListener(new ArabicKeyListener());


    }

    /**
     * Key listener class for the roman text field. Only using the keyReleased() method.
     */
    private class RomanKeyListener implements KeyListener {
        /**
         * Invoked when a key has been typed.
         */
        public void keyTyped(KeyEvent e) {

        }

        /**
         * Invoked when a key has been pressed.
         */
        public void keyPressed(KeyEvent e) {

        }

        /**
         * Invoked when a key has been released.
         */
        public void keyReleased(KeyEvent e) {
            String RomanNum = romanTextField.getText();
            RomanToArabic r = new RomanToArabic();

            if (r.checkRomanChar(e.getKeyChar()) || e.getKeyCode() == 8) {
                RomanNum = r.convertRomanToArabic(RomanNum);
                arabicTextField.setText(RomanNum);
            } else {
                throw new IllegalArgumentException("Illegal character");
            }
        }
    }

    /**
     * Key listener class for the arabic text field. Only using the keyReleased() method.
     */
    private class ArabicKeyListener implements KeyListener {
        /**
         * Invoked when a key has been typed.
         */
        public void keyTyped(KeyEvent e) {

        }

        /**
         * Invoked when a key has been pressed.
         */
        public void keyPressed(KeyEvent e) {

        }

        /**
         * Invoked when a key has been released.
         */
        public void keyReleased(KeyEvent e) {
            String romanNum;
            int arabicNum = 0;
            String arabic = arabicTextField.getText();
            ArabicToRoman a = new ArabicToRoman();

            if (!arabic.equals("")) {
                arabicNum = Integer.parseInt(arabic);
            }
            romanNum = a.convertArabicToRoman(arabicNum);
            romanTextField.setText(romanNum);
        }
    }
}
