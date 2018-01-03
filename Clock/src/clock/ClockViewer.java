package clock;

import java.awt.Dimension;
import javax.swing.JFrame;

/**
 * Clock Viewer
 *
 * @author KazukoAura
 * @since 05 / 10 / 2017
 */


public class ClockViewer {

    public static void main(String[] args) {

        // JFrame configurations
        JFrame frame = new JFrame();
        frame.setSize(400, 400);
        frame.setTitle("Clock");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        // Setting of the conent pane dimensions
        frame.getContentPane().setPreferredSize(new Dimension(400, 400));
        frame.pack();

        // creating an instance of the class/component
        ClockComponent component = new ClockComponent();
        frame.add(component);

    }

}
