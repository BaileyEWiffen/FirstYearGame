package game;

import city.cs.engine.*;
import city.cs.engine.Shape;

import java.awt.*;

public class Cube extends DynamicBody {
    private static final Shape shape = new BoxShape(0.5f,0.5f);
    private Boolean held = false;
    private Boolean OnPlat = false;

    public Boolean getOnPlat() {
        return OnPlat;
    }

    public void setOnPlat(Boolean onPlat) {
        OnPlat = onPlat;
    }



    private static final BodyImage CB_white =
            new BodyImage("data/Cube.png", 1f);
    private static final BodyImage CB_red =
            new BodyImage("data/CubeRed.png", 1f);
    private static final BodyImage CB_blue =
            new BodyImage("data/CubeBlue.png", 1f);
    private static final BodyImage CB_yellow =
            new BodyImage("data/CubeYellow.png", 1f);

    public Boolean getHeld() {
        return held;
    }

    public void setHeld(Boolean held) {
        this.held = held;
    }

    public void Refresh(){
        removeAllImages();
        if(this.getFillColor() == Color.white){
            addImage(CB_white);
        }
        if(this.getFillColor() == Color.red){
            addImage(CB_red);
        }
        if(this.getFillColor() == Color.yellow){
            addImage(CB_yellow);
        }
        if(this.getFillColor() == Color.blue){
            addImage(CB_blue);
        }
    }

    public Cube(World world, Color C) {
        super(world);
        SolidFixture cubeFixture = new SolidFixture(this, shape, 50);
        setFillColor(C);

        this.Refresh();


    }
}
