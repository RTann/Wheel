package graphics;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import physics.Mechanics;

/**
 * Simulates motion of a wheel pushed by a force
 *
 * @author Ross Tannenbaum and Michael Francis
 */
public class Panel extends JPanel implements ActionListener, MouseListener {

    /* Dimension on screen in pixels */
    private static Dimension screensize;
    /* height and width of screen in pixels */
    private static int height, width;
    /* Timer to trigger actionPerformed() */
    private static Timer delay;
    /* Indiciates if ball is moving */
    private static boolean ballIsMoving;
    /* Coordinates of mouse press */
    private static int mouseX, mouseY;
    /* Real time when mouse is pressed and held */
    private static long pressedTime, releasedTime;
    /* Mass of Wheel. 1kg minimum */
    private static final int mass = 2;
    /* Forces exerted on Wheel */
    private static int force, friction;
    /* Acceleration of Wheel */
    private static double acceleration;
    /* Velocities of Wheel */
    private static double prevVelocity, currentVelocity;
    /* Positions of Wheel */
    private static int xPrevPosition, xPosition;
    /* Change in time for each call to actionPerformed() */
    private static final int deltaT = 1;

    /**
     * Constructs a Panel Object
     */
    public Panel() {
        delay = new Timer(0, this);
        screensize = Toolkit.getDefaultToolkit().getScreenSize();
        height = screensize.height;
        width = screensize.width;
        xPrevPosition = width / 2 - 200;
        xPosition = xPrevPosition;
        setPreferredSize(screensize);
        setBackground(Color.BLACK);
        setFocusable(true);
    }

    /**
     * Paint current image of Simulation
     *
     * @param g Graphics
     */
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.WHITE);
        g.drawLine(0, height - 200, width, height - 200);
        g.setColor(Color.CYAN);
        g.fillArc(xPosition, height - 600, 400, 400, 0, 360);
    }

    /**
     * Update simulation based on ActionEvent e
     *
     * @param e Event to indicate change in Simulation
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        prevVelocity = currentVelocity;
        currentVelocity = Mechanics.getVelocity(prevVelocity, acceleration,
                deltaT);
        xPrevPosition = xPosition;
        if (currentVelocity <= 0) {
            ballIsMoving = false;
            delay.stop();
            return;
        }
        xPosition = Mechanics.getPosition(xPrevPosition, currentVelocity,
                acceleration, deltaT);
        if (xPosition >= width) {
            xPosition = -400;
        }
        repaint();
    }

    /**
     * Not implemented
     *
     * @param e
     */
    @Override
    public void mouseClicked(MouseEvent e) {
    }

    /**
     * Utilizes information based on location and time of mouse press
     *
     * @param e Mouse is pressed
     */
    @Override
    public void mousePressed(MouseEvent e) {
        if (!ballIsMoving) {
            pressedTime = System.currentTimeMillis();
            mouseX = e.getX();
            mouseY = e.getY();
        }
    }

    /**
     * Utilizes information based on time of release and time relative to press
     *
     * @param e Mouse is released
     */
    @Override
    public void mouseReleased(MouseEvent e) {
        if (!ballIsMoving) {
            releasedTime = System.currentTimeMillis();
            ballIsMoving = true;
            force = Mechanics.getForce(pressedTime, releasedTime);
            prevVelocity = Mechanics.getVelocity(force, mass);
            currentVelocity = prevVelocity;
            friction = Mechanics.getFriction(mass);
            acceleration = 0/*-Mechanics.getAcceleration(friction, mass)*/;
            delay.start();
        }
    }

    /**
     * Not implemented
     *
     * @param e
     */
    @Override
    public void mouseEntered(MouseEvent e) {
    }

    /**
     * Not implemented
     *
     * @param e
     */
    @Override
    public void mouseExited(MouseEvent e) {
    }

    /**
     * Runs Simulation
     *
     * @param args Most likely will be implemented to indicate how program will
     * run (ex. with or without friction)
     */
    public static void main(String[] args) {
        Panel p = new Panel();
        JFrame jf = new JFrame();
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.add(p);
        jf.pack();
        jf.setVisible(true);
        jf.addMouseListener(p);
    }

}
