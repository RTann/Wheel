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

/**
 *
 * @author rosstannenbaum
 */
public class Panel extends JPanel implements ActionListener,
        MouseListener {

    private Dimension screensize;
    private int height, width;
    private static JFrame jf;
    private static Timer time, delay;
    private static int mouseX, mouseY;

    public Panel() {
        time = new Timer(0, this);
        delay = new Timer(1, this);
        screensize = Toolkit.getDefaultToolkit().getScreenSize();
        height = screensize.height;
        width = screensize.width;
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
        g.fillArc((width / 2) - 200, height - 600, 400, 400, 0, 360);
    }

    public static void main(String[] args) {
        Panel p = new Panel();
        jf = new JFrame();
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.add(p);
        jf.pack();
        jf.setVisible(true);
        jf.addMouseListener(p);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (!time.isRunning()) {
            mouseX = e.getX();
            mouseY = e.getY();
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (!time.isRunning()) {
            time.start();
            delay.start();
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}
