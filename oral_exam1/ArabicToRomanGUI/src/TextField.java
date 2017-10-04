import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class TextField extends JFrame {
    private JTextField romanTextField, arabicTextField;
    private JLabel romanLabel, arabicLabel;

    /**
     *
     */
    public TextField() {
        super("Arabic to Roman GUI");
        setLayout(new FlowLayout());

        romanLabel = new JLabel("Roman: ", JLabel.LEFT);
        romanTextField = new JTextField(10);
        add(romanLabel);
        add(romanTextField);

        arabicLabel = new JLabel("Arabic: ", JLabel.CENTER);
        arabicTextField = new JTextField(10);
        add(arabicLabel);
        add(arabicTextField);

        //setup key listeners
        romanTextField.addKeyListener(new RomanKeyListener());
        arabicTextField.addKeyListener(new ArabicKeyListener());


    }

    /**
     *
     */
    private class RomanKeyListener implements KeyListener {
        /**
         * Invoked when a key has been typed.
         * See the class description for {@link KeyEvent} for a definition of
         * a key typed event.
         */
        public void keyTyped(KeyEvent e) {

        }

        /**
         * Invoked when a key has been pressed.
         * See the class description for {@link KeyEvent} for a definition of
         * a key pressed event.
         */
        public void keyPressed(KeyEvent e) {

        }

        /**
         * Invoked when a key has been released.
         * See the class description for {@link KeyEvent} for a definition of
         * a key released event.
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
     *
     */
    private class ArabicKeyListener implements KeyListener {
        /**
         * Invoked when a key has been typed.
         * See the class description for {@link KeyEvent} for a definition of
         * a key typed event.
         */
        public void keyTyped(KeyEvent e) {

        }

        /**
         * Invoked when a key has been pressed.
         * See the class description for {@link KeyEvent} for a definition of
         * a key pressed event.
         */
        public void keyPressed(KeyEvent e) {

        }

        /**
         * Invoked when a key has been released.
         * See the class description for {@link KeyEvent} for a definition of
         * a key released event.
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
