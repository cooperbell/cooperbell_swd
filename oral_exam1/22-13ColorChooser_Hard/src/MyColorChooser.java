import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.BorderFactory;

/**
 *  This class sets up the GUI with the constructor, and holds all the handler and Paint component classes
 */
public class MyColorChooser extends JFrame {

    /**
     * The text field for the red value
     */
    private JTextField redField;

    /**
     * The text field for the green value
     */
    private JTextField greenField;

    /**
     * The text field for the blue value
     */
    private JTextField blueField;
    /**
     * The slider for the red value
     */
    private JSlider redSlider;

    /**
     * The slider for the green value
     */
    private JSlider greenSlider;

    /**
     * The slider for the blue value
     */
    private JSlider blueSlider;

    /**
     * class Color object used as the argument for painting the color panel
     */
    private Color c;

    /**
     *  class ColorPanel object
     */
    private ColorPanel colorPanel;

    /**
     * Constructor sets up layout, JTextfields, JSliders, handlers, and the color panel
     */
    MyColorChooser() {
        super("Color Chooser");
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(0, 20, 50, 0);
        colorPanel = new ColorPanel();

        c.gridx = 0;
        c.gridy = 0;
        JLabel redLabel = new JLabel("Red Value: ");
        add(redLabel, c);

        c.gridx = 1;
        c.gridy = 0;
        redSlider = new JSlider(0, 255, 100);
        redSlider.setMajorTickSpacing(255);
        redSlider.setPaintLabels(true);
        add(redSlider, c);

        c.gridx = 0;
        c.gridy = 1;
        JLabel greenLabel = new JLabel("Green Value: ");
        add(greenLabel, c);

        c.gridx = 1;
        c.gridy = 1;
        greenSlider = new JSlider(0, 255, 220);
        greenSlider.setMajorTickSpacing(255);
        greenSlider.setPaintLabels(true);
        add(greenSlider, c);

        c.gridx = 0;
        c.gridy = 2;
        JLabel blueLabel = new JLabel("Blue Value: ");
        add(blueLabel, c);

        c.gridx = 1;
        c.gridy = 2;
        blueSlider = new JSlider(0, 255, 100);
        blueSlider.setMajorTickSpacing(255);
        blueSlider.setPaintLabels(true);
        add(blueSlider, c);

        c.gridx = 2;
        c.gridy = 0;
        c.ipadx = 20;
        redField = new JTextField("100", 3);
        add(redField, c);

        c.gridx = 2;
        c.gridy = 1;
        c.ipadx = 20;
        greenField = new JTextField("220", 3);
        add(greenField, c);

        c.gridx = 2;
        c.gridy = 2;
        c.ipadx = 20;
        blueField = new JTextField("100", 3);
        add(blueField, c);

        c.gridx = 3;
        c.gridy = 1;
        add(colorPanel, c);

        colorPanel.setColor(redSlider.getValue(), greenSlider.getValue(), blueSlider.getValue());

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
     * Handler class for the sliders. Reads value from which one was changed and updates the Color object
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
            colorPanel.setColor(redSlider.getValue(), greenSlider.getValue(), blueSlider.getValue());
        }
    }

    /**
     * Handler class for the text fields. Reads value from which one was changed and updates the Color object
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
            colorPanel.setColor(redSlider.getValue(), greenSlider.getValue(), blueSlider.getValue());
        }
    }

    /**
     * Class for managing the color panel
     */
    class ColorPanel extends JPanel {

        ColorPanel() {
            setBorder(BorderFactory.createLineBorder(Color.black));
        }

        /**
         * Specifies size of color panel
         * @return Dimension object
         */
        @Override
        public Dimension getPreferredSize() {
            return new Dimension(100, 100);
        }

        /**
         * Sets up the color panel and paints it
         *
         * @param g Graphics
         */
        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(getColor());
            g.drawRect(0, 0, 100, 100);
            g.fillRect(0, 0, 100, 100);
        }

        /**
         * Setter for color object c
         *
         * @param red value for red
         * @param green value for green
         * @param blue value for blue
         */
        private void setColor(int red, int green, int blue) {
            c = new Color(red, green, blue);
            repaint();
        }

        /**
         * Getter for color object c
         *
         * @return Color object
         */
        public Color getColor() {
            return c;
        }
    }

}

