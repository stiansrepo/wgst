package wgst;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

/**
 * @author DesktopStian
 */
public class Weapon {

    int x = -500;
    int xa;
    int ya = 5;
    int WIDTH = 2;
    int HEIGHT = 5;
    int y = -500;
    boolean shooting = false;
    int temp;
    boolean collided = false;

    private GamePanel game;

    public Weapon(GamePanel game) {
        this.game = game;
    }

    public void paint(Graphics2D g) {
        g.fillRect(x, y, WIDTH, HEIGHT);
    }

    public void move() {

        if (shooting == true) {
            if (collided) {
                x = -10;
                shooting = false;
                collided = false;
            }
            else if (y < 0) {
                x = -5;
                shooting = false;
            }
            else{
            y -= ya;
            }
        }
    }

    public void setCollided() {
        collided = true;
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, WIDTH, WIDTH);
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE && shooting == false) {
            x = game.racquet.getCenter();
            y = game.racquet.getTopY() + 5;
            shooting = true;
        }
    }
}
