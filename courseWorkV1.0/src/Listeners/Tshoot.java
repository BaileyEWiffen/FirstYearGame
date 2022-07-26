package Listeners;

import city.cs.engine.*;
import game.Game;
import game.*;

public class Tshoot implements SensorListener {
    Game g;
    Player p;
    public Tshoot(Game g,Player p){
        this.g =g;
        this.p = p;
    }

    @Override
    public void beginContact(SensorEvent e) {
        if((e.getContactBody() == p) && (e.getContactBody().getFillColor() != e.getSensor().getBody().getFillColor())){
            g.getWorld().setCurrentRewinds(g.getWorld().getCurrentRewinds()-1);
            g.Restart();
        }

    }

    @Override
    public void endContact(SensorEvent sensorEvent) {

    }
}
