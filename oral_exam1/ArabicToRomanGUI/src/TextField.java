import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TextField extends JFrame {
    private JTextField arabicTextField;
    private JTextField romanTextField;

    public TextField() {
        super("Arabic to Roman GUI");
        setLayout(new FlowLayout());

        arabicTextField = new JTextField(10);
        add(arabicTextField);

        romanTextField = new JTextField(10);
        add(romanTextField);

        //setup handlers
        TextFieldHandler handler = new TextFieldHandler();
        arabicTextField.addActionListener(handler);
        romanTextField.addActionListener(handler);
    }

    private class TextFieldHandler implements ActionListener {
        String input = "";
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == arabicTextField){
                input = e.getActionCommand();
            }
            else if (e.getSource() == romanTextField){
                input = e.getActionCommand();
            }

        }
    }
}

