import javax.swing.*;
import java.awt.*;

/**
 *
 */
public class RandomCircle extends JFrame {

    /**
     *
     */
    private int radius;

    /**
     *
     * @param radius
     */
    public RandomCircle(int radius){
        super("Random Circle Generator");
        this.radius = radius;

        /**
         *  Don't do grid bag layout for the paint stuff
         *  Make JFrame two sections of two jPanels, using Grid layout
         *  Top panel adds drawCirlce
         *  Bottom panel can have all the info, and can be grid bag layout
         */

        GridLayout gridLayout = new GridLayout(5,2);
        setLayout(gridLayout);

        /* ------------ area  --------- */

        JLabel areaLabel = new JLabel("Area: ");
        JPanel areaLabelPanel = new JPanel();
        areaLabelPanel.add(areaLabel);
        add(areaLabelPanel);

        JPanel areaFieldPanel = new JPanel();
        JTextField areaField = new JTextField(10);
        areaField.setEditable(false);
        areaField.setText(getArea() + "");
        areaFieldPanel.add(areaField);
        add(areaFieldPanel);

        /* ------------ radius  --------- */

        JLabel radiusLabel = new JLabel("Radius: ");
        JPanel radiusLabelPanel = new JPanel();
        radiusLabelPanel.add(radiusLabel);
        add(radiusLabelPanel);

        JPanel radiusFieldPanel = new JPanel();
        JTextField radiusField = new JTextField(10);
        radiusField.setEditable(false);
        radiusField.setText(getRadius() + "");
        radiusFieldPanel.add(radiusField);
        add(radiusFieldPanel);

        /* ------------ diameter  --------- */

        JLabel diameterLabel = new JLabel("Diameter: ");
        JPanel diameterLabelPanel = new JPanel();
        diameterLabelPanel.add(diameterLabel);
        add(diameterLabelPanel);

        JPanel diameterFieldPanel = new JPanel();
        JTextField diameterField = new JTextField(10);
        diameterField.setEditable(false);
        diameterField.setText(getDiameter() + "");
        diameterFieldPanel.add(diameterField);
        add(diameterFieldPanel);

        /* ------------ circumference  --------- */

        JLabel circumferenceLabel = new JLabel("Circumference: ");
        JPanel circumferenceLabelPanel = new JPanel();
        circumferenceLabelPanel.add(circumferenceLabel);
        add(circumferenceLabelPanel);

        JPanel circumferenceFieldPanel = new JPanel();
        JTextField circumferenceField = new JTextField(10);
        circumferenceField.setEditable(false);
        circumferenceField.setText(getCircumference() + "");
        circumferenceFieldPanel.add(circumferenceField);
        add(circumferenceFieldPanel);


        /* ------------ circle  --------- */

        add(new drawCircle());

    }


    /**
     *
     */
    private class drawCircle extends JPanel {
        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawOval(50, 25, getDiameter(), getDiameter());
        }

    }

    /**
     *
     * @return
     */
    public int getRadius(){
        return radius;
    }

    /**
     *
     * @return
     */
    public int getDiameter(){
        return getRadius() * 2;
    }

    /**
     *
     * @return
     */
    public double getArea(){
        return Math.pow(getRadius(), 2) * Math.PI;
    }

    /**
     *
     * @return
     */
    public double getCircumference(){
        return 2 * Math.PI * getRadius();
    }

}
