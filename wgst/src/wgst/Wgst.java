package wgst;

import java.awt.GridLayout;
import javax.swing.*;
import javax.swing.ImageIcon;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * @author DesktopStian
 */
public class Wgst extends JFrame {

    public Wgst() {

    }

    public static void main(String[] args) throws Exception {
        Wgst frame = new Wgst();
        GamePanel a = new GamePanel();
        frame.add(a);
        frame.setSize(400, 600);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        while (true) {
            a.newGame();
            a.move();
            a.repaint();
            Thread.sleep(20);
        }
    }

}
