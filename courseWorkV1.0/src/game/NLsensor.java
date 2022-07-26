package game;

import city.cs.engine.*;

public class NLsensor extends Sensor {


    public NLsensor(World w) {

        super(new StaticBody(w, new BoxShape(0.5f, 0.5f)), new BoxShape(0.25f,10));
    }
}
