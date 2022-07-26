package game;

import city.cs.engine.*;
import city.cs.engine.Shape;

import java.awt.*;

public class CreateTurret extends Sensor {
    private static final Shape S = new BoxShape(50f,0.1f);
    public CreateTurret(World w, Color c) {
        super(new Turret(w,c), S);
    }
}
