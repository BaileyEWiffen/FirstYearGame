package game;

import city.cs.engine.*;
import city.cs.engine.Shape;

import java.awt.*;

public class Turret extends DynamicBody {
    //-0.591f,-0.418f, -0.609f,0.451f, 0.591f,0.487f, 0.586f,-0.423f
    private static final Shape shape = new PolygonShape(-0.895f,-0.669f, -0.891f,0.692f, 0.899f,0.727f, 0.841f,-0.669f);

    private static final BodyImage image =
            new BodyImage("data/turret.png", 1.5f);

    public Turret(World w, Color c) {
        super(w, shape);
        this.setFillColor(c);
        addImage(image);
    }
}
