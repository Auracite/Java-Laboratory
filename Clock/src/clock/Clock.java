package clock;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;

/**
 * Clock
 *
 * @author KazukoAura
 * @since 05 / 10 / 2017
 */

public class Clock {

    // Listing all instance variables
    private final int centerX = 400 / 2;
    private final int centerY = 400 / 2;

    private int hour;
    private int minute;
    private int size;

    private static final float radPerNum = (float) (Math.PI / - 6);
    private static final float radPerSecMin = (float) (Math.PI / 30.0);
    Color colorSecond, colorMHour, colorNumber;
    double angleSegmentation = Math.PI / 6;

    /**
     * Constructs a clock with given hour and minutes
     *
     * @param hours the hours indicated to be marked
     * @param minutes the minutes indicated to be marked
     */
    public Clock(int hours, int minutes) {
        this.hour = hours;
        this.minute = minutes;
    }

    /**
     * Implementing the drawing of the clock numbers
     *
     * @param g the graphics object
     */
    private void drawNumberClock(Graphics g) {
        size = 400;
        for (int num = 12; num > 0; num--) {
            drawnum(g, radPerNum * num, num);
        }
    }

    /**
     * Calculating the positioning of the clock numbers
     *
     * @param g the graphics object
     * @param angle the bearings indicated
     * @param n the integer being processed
     */
    private void drawnum(Graphics g, float angle, int n) {

        float sine = (float) Math.sin(angle);
        float cosine = (float) Math.cos(angle);
        int dx = (int) ((size / 2 - 20 - 25) * -sine);
        int dy = (int) ((size / 2 - 20 - 25) * -cosine);

        g.drawString("" + n, dx + centerX - 5, dy + centerY + 5);
    }

    /**
     * Drawing the Clock Face Tick Marks
     *
     * @param g the graphics tool
     */
    private void drawClockFace(Graphics g) {
        size = 400;

        for (int seconds = 0; seconds < 60; seconds++) {
            int ticStart;
            if (seconds % 5 == 0) {
                ticStart = size / 2 - 10;
            } else {
                ticStart = size / 2 - 5;
            }
            drawRadius(g, centerX, centerY, radPerSecMin * seconds, ticStart - 20, 400 / 2 - 10, colorNumber.BLACK);
        }
    }

    /**
     * Deciphering the radius of all clock marks
     *
     * @param g the graphics object
     * @param x the coordinate x of the bounded field
     * @param y the coordinate y of the bounded field
     * @param angle the bearings of the point
     * @param minRadius the minimum length
     * @param maxRadius the maximum length
     * @param colorNumber the colour of the lines to be set
     */
    private void drawRadius(Graphics g, int x, int y, double angle, int minRadius, int maxRadius, Color colorNumber) {
        float sine = (float) Math.sin(angle);
        float cosine = (float) Math.cos(angle);
        int dxmin = (int) (minRadius * sine);
        int dymin = (int) (minRadius * cosine);
        int dxmax = (int) (maxRadius * sine);
        int dymax = (int) (maxRadius * cosine);
        g.setColor(colorNumber);
        g.drawLine(x + dxmin, y + dymin, x + dxmax, y + dymax);
    }

    /**
     * Configuration of the minute and hour hands
     *
     * @param g2 the graphics tool
     * @param x the coordinate of the bounded field
     * @param y the coordinate of the bounded field
     * @param width
     */
    public void setHand(Graphics2D g2, int x, int y, int width) {

        int positionX = width / 2;
        int positionY = width / 2;
        double segmentingAngle = Math.PI / 6;

        
        int minuteLength = width / 2 - 10;
        double minuteAngle = (double) (Math.PI / 30) * ((double) minute) - Math.toRadians(90);
        double minuteOffsetX = (minuteLength * Math.cos(minuteAngle));
        double minuteOffsetY = (minuteLength * Math.sin(minuteAngle));

        g2.setStroke(new BasicStroke(2));
        Line2D minuteHand = new Line2D.Double(positionX, positionY, positionX + minuteOffsetX, positionY + minuteOffsetY);
        g2.draw(minuteHand);
        
        int hourLength = width / 2 - 60;
        double angleHour = (double) (segmentingAngle * ((double) hour)) - Math.toRadians(90);
        double hourOffsetX = (hourLength * Math.cos(angleHour));
        double hourOffsetY = (hourLength * Math.sin(angleHour));

        g2.setStroke(new BasicStroke(6));
        Line2D hourHand = new Line2D.Double(positionX, positionY, positionX + hourOffsetX, positionY + hourOffsetY);
        g2.draw(hourHand);

        
    }

    /**
     * Drawing the face of the circle
     *
     * @param g2 the graphics tool
     */
    public void drawCircleFace(Graphics2D g2) {

        g2.setStroke(new BasicStroke(7.0F));

        Ellipse2D.Double center = new Ellipse2D.Double(196, 196, 8, 8);
        g2.draw(center);

        g2.setStroke(new BasicStroke(5.0F));
        Ellipse2D.Double outerEllip = new Ellipse2D.Double(10, 10, 380, 380);
        g2.draw(outerEllip);
    }

    
    /**
     * Implements the final complex drawing of some of the methods
     *
     * @param g2 the graphics tool
     */
    public void draw(Graphics2D g2) {
        g2.setColor(Color.BLACK);
        
        drawClockFace(g2);

        drawNumberClock(g2);
        setHand(g2,0,0, Math.min(400, 400));

    }

}
