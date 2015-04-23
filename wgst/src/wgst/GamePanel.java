package wgst;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 * @author DesktopStian
 */
public class GamePanel extends JPanel {

    /*
     Entity ball = new Entity(this,0,0,1,1,30,"a");
     Entity ball2 = new Entity (this,40,100,1,1,20,"b");
     Entity ball3 = new Entity(this,80,0,1,1,15,"c");
     Entity ball4 = new Entity(this,120,0,1,1,20,"d");
     Entity ball5 = new Entity(this,180,0,1,1,30,"e");
     */
    boolean newGame = true;

    Entity[] balls = new Entity[10];

    Controlled racquet = new Controlled(this);

    private int destroyedCounter = 0;

    Weapon weapon = new Weapon(this);
    int speed = 1;
    int score = 0;

    public GamePanel() {
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
                racquet.keyReleased(e);
                weapon.keyPressed(e);
            }

            @Override
            public void keyPressed(KeyEvent e) {
                racquet.keyPressed(e);
                weapon.keyPressed(e);
            }
        });
        setFocusable(true);
        AudioHandler.BACK.loop();
    }

    public void ballGenerator() {
        Random rgen = new Random();
        int xloc = 10;
        int yloc = 10;
        int maxD = 40;
        int minD = 10;
        int counter = 1;
        balls[0] = new Entity(this, 0, 0, 1, 1, 30, "a");

        while (counter < balls.length) {
            int randomD = rgen.nextInt((maxD - minD) + 1) + minD;

            if (!new Rectangle(xloc, yloc, randomD, randomD).intersects(balls[counter - 1].getBounds())) {
                String rn = "" + Integer.toString(randomD);
                balls[counter] = new Entity(this, xloc, yloc, 1, 1, randomD, rn);
                counter++;
                xloc += (rgen.nextInt(60 - 20) + 1) + 20;
                yloc += (rgen.nextInt(40 - 10) + 1) + 10;
            }

        }
    }

    public void destroyedInc() {
        destroyedCounter++;
    }

    private int getScore() {
        return score;
    }

    public void move() {   
        
        if (destroyedCounter >= balls.length) {
            ballGenerator();
            destroyedCounter = 0;
        }
    
        for (int i = 0; i < balls.length; i++) {
            balls[i].move();
        }
        weapon.move();
        racquet.move();
        
    }
    
    public void newGame(){
        ballGenerator();
    }
        @Override
        public void paint
        (Graphics g
        
            ) {
        super.paint(g);
            Graphics2D g2d = (Graphics2D) g;
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);

            g2d.setColor(Color.BLUE);

            for (int i = 0; i < balls.length; i++) {
                balls[i].paint(g2d);
            }

            racquet.paint(g2d);
            g2d.setColor(Color.RED);
            weapon.paint(g2d);
            g2d.setColor(Color.GRAY);
            g2d.setFont(new Font("Verdana", Font.BOLD, 15));
            g2d.drawString("XP: " + String.valueOf(getScore()), 10, 20);
        }

    

    public void gameOver() {
        AudioHandler.BACK.stop();
        AudioHandler.GAMEOVER.play();
        JOptionPane.showMessageDialog(this, "your score is: " + getScore(),
                "Game Over", JOptionPane.YES_NO_OPTION);
        System.exit(ABORT);
    }
}
