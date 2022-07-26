package game;

import city.cs.engine.BoxShape;
import city.cs.engine.DynamicBody;
import city.cs.engine.*;
import city.cs.engine.Shape;

import java.awt.*;

public class PainterBase extends DynamicBody {

    private static final Shape shape = new PolygonShape(-1.75f,-1.73f, -1.75f,-1.24f, 1.74f,-1.22f, 1.74f,-1.74f);
    private static final BodyImage yellow =
            new BodyImage("data/PainterYellow.png", 3.5f);
    private static final BodyImage white =
            new BodyImage("data/PainterWhitePH.png", 3.5f);
    private static final BodyImage red =
            new BodyImage("data/PainterRed.png", 3.5f);
    private static final BodyImage blue =
            new BodyImage("data/PainterBlue.png", 3.5f);


    public PainterBase(World world, Color C){
        super(world);
        SolidFixture buttonFixture = new SolidFixture(this, shape, 10000);
        setFillColor(C);
        if (C == Color.white){
            addImage(white);
        }
        if (C == Color.red){
            addImage(red);
        }
        if (C == Color.yellow){
            addImage(yellow);
        }
        if (C == Color.blue){
            addImage(blue);
        }




    }
}
