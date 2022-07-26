package Listeners;

import city.cs.engine.SensorEvent;
import city.cs.engine.SensorListener;
import game.ButtonSensor;
import game.MovingPlat;

public class PlatOn implements SensorListener {

    MovingPlat M;
    ButtonSensor B;
    int ObjectsIn = 0;

    public PlatOn(ButtonSensor B, MovingPlat M) { this.B =B;
        this.M = M;
    }

    @Override
    public void beginContact(SensorEvent e) {
        if((e.getContactBody().getFillColor() == e.getSensor().getBody().getFillColor())  ){
            ObjectsIn++;
            M.setMove(true);
            System.out.println("Plat On");

        }
    }

    @Override
    public void endContact(SensorEvent e) {
        if((e.getContactBody().getFillColor() == e.getSensor().getBody().getFillColor())  ){
            ObjectsIn--;
        }
        if(ObjectsIn ==0){
            M.setMove(false);
            System.out.println("Plat off");
        }


    }
}
