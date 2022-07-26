package Listeners;

import city.cs.engine.*;
import game.Game;
import game.Player;

public class LevelExit implements SensorListener {
    Game g;
    Player p;
    public LevelExit(Game g,Player p){
        this.g =g;
        this.p = p;
    }
    @Override
    public void beginContact(SensorEvent e) {
        if(e.getContactBody() == p ){
            g.NextLevel();
        }


    }

    @Override
    public void endContact(SensorEvent sensorEvent) {

    }
}
