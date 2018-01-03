package clock;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;

/**
 * Clock Component
 * @author KazukoAura
 * @since 05 / 10 / 2017
 */
public class ClockComponent extends JComponent {
    
    @Override
    public void paintComponent(Graphics g) {

        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.BLACK);
        
        // Instansiating a new instance of Clock and setting the integer time
        Clock clock = new Clock(3, 45);
        clock.draw(g2);
        
        //clock.setHand(g2,0,0, Math.min(getWidth(), getHeight()));
        clock.drawCircleFace(g2);
    }
}
