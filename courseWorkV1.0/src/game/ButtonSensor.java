package game;

import city.cs.engine.BoxShape;
import city.cs.engine.Sensor;
import city.cs.engine.Shape;
import city.cs.engine.World;

import java.awt.*;

public class ButtonSensor extends Sensor {
    private static final Shape S = new BoxShape(1.7f,1f);

    public ButtonSensor(World W, Color C){

        super(new Button(W,C),S);

    }
}
