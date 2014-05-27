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
 *
 * @author rosstannenbaum
 */
public class Panel extends JPanel implements ActionListener, MouseListener {

    private static Dimension screensize;
    private static int height, width;
    private static JFrame jf;
    private static Timer timer, delay;
    private static int mouseX, mouseY;
    private static long pressedTime, releasedTime;
    private static int mass;
    private static int force;
    private static double initialVelocity, currentVelocity;
    private static int xInitialPosition, xPosition;
    private static long time;

    public Panel() {
        timer = new Timer(0, this);
        delay = new Timer(0, this);
        screensize = Toolkit.getDefaultToolkit().getScreenSize();
        height = screensize.height;
        width = screensize.width;
        xInitialPosition = width / 2 - 200;
        xPosition = xInitialPosition;
        setPreferredSize(screensize);
        setBackground(Color.BLACK);
        setFocusable(true);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.WHITE);
        g.drawLine(0, height - 200, width, height - 200);
        g.setColor(Color.CYAN);
        g.fillArc(xPosition, height - 600, 400, 400, 0, 360);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        time = System.currentTimeMillis() - releasedTime;
        currentVelocity = Mechanics.getVelocity(initialVelocity, 0, time);
        xPosition = Mechanics.getPosition(xInitialPosition, currentVelocity, 0, 
                time);
        repaint();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        //Not implemented
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (!timer.isRunning()) {
            pressedTime = System.currentTimeMillis();
            mouseX = e.getX();
            mouseY = e.getY();
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (!timer.isRunning()) {
            releasedTime = System.currentTimeMillis();
            force = Mechanics.getForce(pressedTime, releasedTime);
            initialVelocity = Mechanics.getVelocity(force, mass);
            currentVelocity = initialVelocity;
            timer.start();
            delay.start();
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        //Not implemented
    }

    @Override
    public void mouseExited(MouseEvent e) {
        //Not impletemented
    }

    public static void main(String[] args) {
        mass = 2;
        Panel p = new Panel();
        jf = new JFrame();
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.add(p);
        jf.pack();
        jf.setVisible(true);
        jf.addMouseListener(p);
    }

}
