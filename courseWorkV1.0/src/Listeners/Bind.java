package Listeners;

import city.cs.engine.*;
import game.*;

import org.jbox2d.common.Vec2;

public class Bind implements StepListener {
    Player P;
    Cube C;
    MovingPlat M = null;


    public Bind (Cube C, Player P){
        this.C =C;
        this.P=P;
    }
    public Bind (Cube C, Player P, MovingPlat M){
        this.C =C;
        this.P=P;
        this.M =M;
    }




    @Override
    public void preStep(StepEvent e) {
        if(C.getHeld()){
            C.setGravityScale(0);
        }
        if(!P.getHolding()){
            C.setHeld(false);
        }
        if(!C.getHeld()){
            C.setGravityScale(1);
            //System.out.println("graviry on");
        }
        if (C.getHeld() && P.getHolding())
        C.setPosition(new Vec2(P.getPosition().x-0.35f, (P.getPosition().y+1.7f)));

        //



    }

    @Override
    public void postStep(StepEvent e) {



       if ((M != null)){
            M.setLinearVelocity(new Vec2 (0,0));
            if(M.getMove()){

                if ((M.getPosition().x >= M.getMaxX()) && (M.getDirection() == 1)){
                    M.setDirection(-1);
                  //  System.out.println("flip to -1");
                }
                //System.out.println(M.getPosition().x +" "+M.getMinX());

                if ((M.getPosition().x <= M.getMinX()+0.2) && (M.getDirection() == -1)){
                    M.setDirection(1);
                   // System.out.println("flip to 1");
                }

                if((M.getPosition().x < M.getMaxX())&&(M.getDirection() == 1)){
                    if(C.getOnPlat()){
                        C.setPosition(new Vec2((C.getPosition().x+0.02f),C.getPosition().y));
                    }
                    M.setPosition(new Vec2((M.getPosition().x+0.02f),M.getPosition().y));
                }
                if((M.getPosition().x > M.getMinX()+0.2)&&(M.getDirection() == -1)){
                    if(C.getOnPlat()){
                        C.setPosition(new Vec2((C.getPosition().x-0.02f),C.getPosition().y));
                    }
                    M.setPosition(new Vec2((M.getPosition().x-0.02f),M.getPosition().y));

                }
            }

    }

}
}

