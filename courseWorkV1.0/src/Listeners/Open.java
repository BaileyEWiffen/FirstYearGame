package Listeners;

import city.cs.engine.*;
import game.ButtonSensor;
import game.Door;
import org.jbox2d.common.Vec2;

public class Open implements SensorListener{
    Door D;
    ButtonSensor B;
    int ObjectsIn = 0;

    public Open(ButtonSensor B, Door D) { this.B =B;
        this.D = D;
    }

    @Override
    public void beginContact(SensorEvent e){
        if((e.getContactBody().getFillColor() == e.getSensor().getBody().getFillColor())  ){
            ObjectsIn++;
            D.setPosition(new Vec2(-100,-100));
            System.out.println("Door Open");
            //e.getReportingBody().destroy();
        }

    }
    @Override
    public void endContact(SensorEvent e){

        if((e.getContactBody().getFillColor() == e.getSensor().getBody().getFillColor())  ){
            ObjectsIn--;
        }
        if(ObjectsIn ==0){
            D.setPosition(D.GetOrigin());
            System.out.println("Door close");
        }



    }
}
