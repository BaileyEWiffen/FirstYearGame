package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Key handler to control an Walker.
 */
public class Controller extends KeyAdapter {
    private static final float JUMPING_SPEED = 12f;
    private static final float WALKING_SPEED = 4;

    private Player body;

    public Controller(Player body) {
        this.body = body;
    }

    /**
     * Handle key press events for walking and jumping.
     * @param e description of the key event
     */
    @Override
    public void keyPressed(KeyEvent e) {

        int code = e.getKeyCode();
        if (code == KeyEvent.VK_T) { // T = quit
            System.exit(0);
        } else if (code == KeyEvent.VK_W) { // w = jump
            Vec2 v = body.getLinearVelocity();
            // only jump if body is not already jumping
            if((Math.abs(v.y) < 0.01f) && body.getHolding()){//half jump hight when carrying
                body.jump(JUMPING_SPEED/2);
            }
            else if (Math.abs(v.y) < 0.01f) {
                body.jump(JUMPING_SPEED);
            }
        } else if (code == KeyEvent.VK_A) {
            body.setMovingDirection(-1);
            body.startWalking(-WALKING_SPEED); // a = walk left
        } else if (code == KeyEvent.VK_D) {
            body.setMovingDirection(1);
            body.startWalking(WALKING_SPEED); // d= walk right
        }
        else if((code == KeyEvent.VK_SHIFT && !body.getHolding())){//grab is shift
            body.setHolding(true);
            System.out.println("Holding");
        }
        else if((code == KeyEvent.VK_S)){//fall faster
            body.setGravityScale(6);
        }
        body.Refresh();


    }

    /**
     * Handle key release events (stop walking).
     * @param e description of the key event
     */
    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_A) {
            body.startWalking(0);

        } else if (code == KeyEvent.VK_D) {
            body.startWalking(0);
        }

        else if((code == KeyEvent.VK_SHIFT) && body.getHolding()){
            body.setHolding(false);
            System.out.println("Dropping");
        }
        else if((code == KeyEvent.VK_S)){//grab is shift
            body.setGravityScale(1);
        }
    }

    public void setBody(Player body) {
        this.body = body;
    }
}
