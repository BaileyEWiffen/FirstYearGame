package Listeners;

import city.cs.engine.*;
import game.Cube;
import game.Player;

import java.awt.*;

public class ColourSwap implements SensorListener {
    Player P;
    Cube C;
    public ColourSwap(Player P, Cube C){
        this.P = P;
        this.C=C;

    }

    @Override
    public void beginContact(SensorEvent e){
        if((e.getSensor().getBody().getFillColor() != e.getContactBody().getFillColor()) && e.getContactBody()==P){
            e.getContactBody().setFillColor(e.getSensor().getBody().getFillColor());
            P.Refresh();
            System.out.println("swap");
        }
        if((e.getSensor().getBody().getFillColor() != e.getContactBody().getFillColor()) && e.getContactBody() == C){
            e.getContactBody().setFillColor(e.getSensor().getBody().getFillColor());

            C.Refresh();
            System.out.println("Cube paint");
        }

    }
    @Override
    public void endContact(SensorEvent e){

    }

}
