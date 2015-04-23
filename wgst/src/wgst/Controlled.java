package wgst;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.Rectangle;

public class Controlled {

    int x = 0;
    int xa = 0;
    int y = 530;
    int ya = 530;
    private static final int WIDTH = 100;
    private static final int HEIGHT = 10;

    private GamePanel game;

    public Controlled(GamePanel game) {
        this.game = game;
    }

    public void move() {
        if (x + xa > 0 && x + xa < game.getWidth() - WIDTH) {
            x = x + xa;
        }
        if (y + ya > 0 && y + ya < game.getHeight() - HEIGHT) {
            y = y + ya;
        }
    }

    public void paint(Graphics2D g) {
        g.fillRect(x, y, WIDTH, HEIGHT);
    }

    public void keyReleased(KeyEvent e) {
        xa = 0;
        ya = 0;
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            xa = -game.speed-3;
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            xa = game.speed+3;
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            ya = game.speed-3;
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            ya = game.speed+3;
        }
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, WIDTH, HEIGHT);
    }

    public int getTopY() {
        return y - HEIGHT;
    }
    public int getCenter(){
        return x+(WIDTH/2);
    }
}
