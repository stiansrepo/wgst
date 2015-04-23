package wgst;

import java.awt.Graphics2D;
import java.awt.Rectangle;

/**
 * @author DesktopStian
 */
public class Entity {

    private int x = 0;
    private int y = 0;
    private int xa = 1;
    private int ya = 1;
    private int oldX;
    private int oldY;
    private GamePanel game;
    private String name;

    boolean destroyed = false;

    private int d;

    public Entity(GamePanel game, int x, int y, int xa, int ya, int d, String name) {
        this.game = game;
        this.x = x;
        this.y = y;
        this.xa = xa;
        this.ya = ya;
        this.d = d;
        this.name = name;
    }

    public void move() {

        boolean changeDirection = true;

        if (!destroyed) {

            if (x + xa < 0) {
                xa = game.speed;
            } else if (x + xa > game.getWidth() - d) {
                xa = -game.speed;
            } else if (y + ya < 0) {
                ya = game.speed;
            } else if (y + ya > game.getHeight() - d) {
                game.gameOver();
            } else if (collisionBall()) {
                x=oldX;
                y=oldY;
                xa = -xa;
                ya = -ya;
            } else if (collision()) {
                ya = -game.speed;
                //y = game.racquet.getTopY() - d;
                game.score += 5;

            } else if (collisionWeapon()) {
                x = -100;
                y = -100;
                destroyed = true;
                game.destroyedInc();
                game.weapon.setCollided();
                game.score += 1;
                AudioHandler.EXPLODE.play();
            } else {
                changeDirection = false;
            }

            if (changeDirection) {
                AudioHandler.BALL.play();
            }

            x = x + xa;
            y = y + ya;
            oldX = x;
            oldY = y;
        }
    }

    public void paint(Graphics2D g) {
        g.fillOval(x, y, d, d);
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, d, d);
    }

    private boolean collisionBall() {
        for (int i = 0; i < game.balls.length; i++) {
            if (!game.balls[i].equals(this) && game.balls[i].getBounds().intersects(getBounds())) {

                return game.balls[i].getBounds().intersects(getBounds());
            }
        }
        return false;
    }
    
    

    private boolean collision() {
        return game.racquet.getBounds().intersects(getBounds());
    }

    private boolean collisionWeapon() {
        return game.weapon.getBounds().intersects(getBounds());
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Entity)) {
            return false;
        }
        Entity that = (Entity) other;
        return this.name.equals(that.name);
    }

}
