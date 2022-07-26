package game;

import city.cs.engine.*;
import city.cs.engine.Shape;

import java.awt.*;

public class Player extends Walker{
    private Boolean Holding = false;
     private int MovingDirection =1;

    public Boolean getHolding() {
        return Holding;
    }

    public void setHolding(Boolean holding) {
        Holding = holding;
    }

    private static final Shape shape = new PolygonShape(
            -0.808f,-0.996f, -0.816f,0.996f, 0.304f,1.0f, 0.3f,-0.996f);

    private static final BodyImage whiteR =
            new BodyImage("data/PlayerSpriteR.png", 2f);
    private static final BodyImage yellowR =
            new BodyImage("data/PlayerSpriteYellowR.png", 2f);
    private static final BodyImage redR=
            new BodyImage("data/PlayerSpriteRedR.png", 2f);
    private static final BodyImage blueR =
            new BodyImage("data/PlayerSpriteBlueR.png", 2f);
    private static final BodyImage whiteL =
            new BodyImage("data/PlayerSprite.png", 2f);
    private static final BodyImage yellowL =
            new BodyImage("data/PlayerSpriteYellow.png", 2f);
    private static final BodyImage redL=
            new BodyImage("data/PlayerSpriteRed.png", 2f);
    private static final BodyImage blueL =
            new BodyImage("data/PlayerSpriteBlue.png", 2f);


    public int getMovingDirection() {
        return MovingDirection;
    }

    public void setMovingDirection(int movingDirection) {
        MovingDirection = movingDirection;
    }

    public void Refresh(){
        removeAllImages();

        if(this.MovingDirection ==1){
            if(this.getFillColor() == Color.white){
                addImage(whiteR);
            }
            if(this.getFillColor() == Color.red){
                addImage(redR);
            }
            if(this.getFillColor() == Color.yellow){
                addImage(yellowR);
            }
            if(this.getFillColor() == Color.blue){
                addImage(blueR);
            }
        }
        if(this.MovingDirection ==-1){
            if(this.getFillColor() == Color.white){
                addImage(whiteL);
            }
            if(this.getFillColor() == Color.red){
                addImage(redL);
            }
            if(this.getFillColor() == Color.yellow){
                addImage(yellowL);
            }
            if(this.getFillColor() == Color.blue){
                addImage(blueL);
            }
        }

    }


    public Player(World world) {
        super(world, shape);
        setFillColor(Color.white);
        this.Refresh();

    }
}
