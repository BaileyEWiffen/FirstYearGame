package Listeners;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import game.Cube;
import game.MovingPlat;
import game.Player;
import org.jbox2d.common.Vec2;
import org.jbox2d.common.Vec3;

public class Carry implements CollisionListener {
    Player P;
    Cube C;
    MovingPlat MP;

    public Carry(Player P, Cube C) {
        this.P = P;
        this.C = C;
    }
    public Carry(Player P, Cube C, MovingPlat MP) {
        this.P = P;
        this.C = C;
        this.MP = MP;
    }

    @Override
    public void collide(CollisionEvent e){
        if(e.getOtherBody() == P && P.getHolding()){
            //C.putOn(P);
            C.setHeld(true);
            C.setOnPlat(false);
            //C.setPosition(new Vec2(P.getPosition().x+1, (P.getPosition().y)));
        }

        else if(e.getOtherBody() == MP){
            C.setOnPlat(true);
            System.out.println("Stick");
        }
        else{
            C.setOnPlat(false);
        }

    }
}
