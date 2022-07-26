package game;

import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;

import java.awt.*;

public class Button extends DynamicBody{

    private static final Shape shape2 = new PolygonShape(-1.75f,-1.73f, -1.75f,-1.24f, 1.74f,-1.22f, 1.74f,-1.74f);
    private Boolean isOn = false;


    public Boolean getOn() {
        return isOn;
    }




    public void setOn(Boolean on) {
        isOn = on;
    }
    //-1.75f,-1.73f, -1.75f,-1.24f, 1.74f,-1.22f, 1.74f,-1.74f

    private static final BodyImage white =
            new BodyImage("data/Button.png", 3.5f);
    private static final BodyImage red =
            new BodyImage("data/ButtonRed.png", 3.5f);
    private static final BodyImage blue =
            new BodyImage("data/ButtonBlue.png", 3.5f);
    private static final BodyImage yellow =
            new BodyImage("data/ButtonYellow.png", 3.5f);
    private static final BodyImage purple =
            new BodyImage("data/ButtonPurple.png", 3.5f);

    public Button(World world, Color C) {
        super(world);
        SolidFixture buttonFixture = new SolidFixture(this, shape2, 10000);
        setFillColor(C);
        if(C == Color.white){
            addImage(white);
        }
        if(C == Color.red){
            addImage(red);
        }
        if(C == Color.yellow){
            addImage(yellow);
        }
        if(C == Color.blue){
            addImage(blue);
        }
        if(C == Color.pink){
            addImage(purple);
        }







    }
}
