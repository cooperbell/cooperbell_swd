import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.BorderFactory;


public class MyColorChooser extends JFrame {
    /**
     *
     */
    private JTextField redField, greenField, blueField;
    /**
     * The three RGB sliders
     */
    private JSlider redSlider, greenSlider, blueSlider;

    /**
     *
     */
    private Color c;

    /**
     *
     */
    MyColorChooser() {
        super("Color Chooser");
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(0, 20, 50, 0);

        c.gridx = 0;
        c.gridy = 0;
        redSlider = new JSlider(0, 255, 130);
        redSlider.setMajorTickSpacing(255);
        redSlider.setPaintLabels(true);
        add(redSlider, c);

        c.gridx = 0;
        c.gridy = 1;
        greenSlider = new JSlider(0, 255, 130);
        greenSlider.setMajorTickSpacing(255);
        greenSlider.setPaintLabels(true);
        add(greenSlider, c);

        c.gridx = 0;
        c.gridy = 2;
        blueSlider = new JSlider(0, 255, 130);
        blueSlider.setMajorTickSpacing(255);
        blueSlider.setPaintLabels(true);
        add(blueSlider, c);

        c.gridx = 1;
        c.gridy = 0;
        c.ipadx = 20;
        redField = new JTextField("130", 3);
        add(redField, c);

        c.gridx = 1;
        c.gridy = 1;
        c.ipadx = 20;
        greenField = new JTextField("130", 3);
        add(greenField, c);

        c.gridx = 1;
        c.gridy = 2;
        c.ipadx = 20;
        blueField = new JTextField("130", 3);
        add(blueField, c);

        c.gridx = 2;
        c.gridy = 1;
        add(new PaintStuff(), c);

//        setColor(redSlider.getValue(), greenSlider.getValue(), blueSlider.getValue());

        //setup slider handlers
        redSlider.addChangeListener(new SliderHandler());
        greenSlider.addChangeListener(new SliderHandler());
        blueSlider.addChangeListener(new SliderHandler());

        //setup textfield handlers
        redField.addActionListener(new TextFieldListener());
        greenField.addActionListener(new TextFieldListener());
        blueField.addActionListener(new TextFieldListener());

    }

    /**
     *
     */
    private class SliderHandler implements ChangeListener {
        /**
         * Invoked when the target of the listener has changed its state.
         *
         * @param e a ChangeEvent object
         */
        public void stateChanged(ChangeEvent e) {
            JSlider source = (JSlider) e.getSource();

            if (e.getSource() == redSlider) {
                redField.setText(source.getValue() + "");
            }
            if (e.getSource() == greenSlider) {
                greenField.setText(source.getValue() + "");
            }
            if (e.getSource() == blueSlider) {
                blueField.setText(source.getValue() + "");
            }
//            setColor(redSlider.getValue(), greenSlider.getValue(), blueSlider.getValue());
            PaintStuff ps = new PaintStuff();
            ps.repaint();
        }
    }


    /**
     *
     */
    private class TextFieldListener implements ActionListener {
        /**
         * Invoked when an action occurs.
         */
        public void actionPerformed(ActionEvent e) {

            if (e.getSource() == redField) {
                redSlider.setValue(Integer.parseInt(e.getActionCommand()));
            }
            if (e.getSource() == greenField) {
                greenSlider.setValue(Integer.parseInt(e.getActionCommand()));
            }
            if (e.getSource() == blueField) {
                blueSlider.setValue(Integer.parseInt(e.getActionCommand()));
            }
//            setColor(redSlider.getValue(), greenSlider.getValue(), blueSlider.getValue());
            PaintStuff ps = new PaintStuff();
            ps.repaint();
        }
    }


//    private void setColor(int red, int green, int blue) {
//        c = new Color(red, green, blue);
//    }
//
//    public Color getColor() {
//        return c;
//    }

    public int getRed() {
        return redSlider.getValue();
    }

    public int getGreen() {
        return greenSlider.getValue();
    }

    public int getBlue() {
        return blueSlider.getValue();
    }

    class PaintStuff extends JPanel {

        PaintStuff() {
            setBorder(BorderFactory.createLineBorder(Color.black));
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(100, 100);
        }

        @Override
        public void paintComponent(Graphics g) {
            MyColorChooser mcc = new MyColorChooser();
            super.paintComponent(g);
            g.setColor(new Color(mcc.getRed(), mcc.getGreen(), mcc.getBlue()));
            g.drawRect(0, 0, 100, 100);
            g.fillRect(0, 0, 100, 100);

        }
    }
}

