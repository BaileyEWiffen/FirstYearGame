package game;

import city.cs.engine.DynamicBody;
import city.cs.engine.Shape;
import city.cs.engine.*;
import org.jbox2d.common.Vec2;


public class MovingPlat extends Walker{
    private static final Shape shape = new BoxShape(2f,0.5f);
    private int minX;
    private int maxX;
    private Vec2 startP;
    private Boolean move =false;
    private Vec2 currentP;
    private int direction = 1;

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }





    public MovingPlat(World w,int minX, int maxX, Vec2 startP) {
        super(w);
        SolidFixture doorFixture = new SolidFixture(this, shape, 10000);
        this.minX = minX;
        this.maxX = maxX;
        this.startP = startP;
        currentP = startP;
        this.setPosition(startP);
        this.setGravityScale(0);

    }



    public int getMinX() {
        return minX;
    }



    public int getMaxX() {
        return maxX;
    }


    public Vec2 getStartP() {
        return startP;
    }



    public Boolean getMove() {
        return move;
    }

    public void setMove(Boolean move) {
        this.move = move;
    }

    public Vec2 getCurrentP() {
        return currentP;
    }

    public void setCurrentP(Vec2 currentP) {
        this.currentP = currentP;
    }


}
