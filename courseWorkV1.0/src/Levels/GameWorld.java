package Levels;

import Listeners.LevelExit;
import city.cs.engine.*;
import city.cs.engine.Shape;


import game.*;
import org.jbox2d.common.Vec2;

import java.awt.*;

public abstract class GameWorld extends World{

    private int CurrentRewinds;
    private Player PY_main;
    private Door door;
    private Image BG;

    public Boolean getRcollected() {
        return Rcollected;
    }

    public void setRcollected(Boolean rcollected) {
        Rcollected = rcollected;
    }

    private Boolean Rcollected = false;
    public abstract Vec2 startPosition();
    public abstract Vec2 doorPosition();
    public abstract Image BGimage();

    public void Populate(Game g){
        PY_main = new Player(this);
        PY_main.setPosition(startPosition());
        door = new Door(this);
        door.setPosition(doorPosition());
        door.SetOrigin();

        // make the ground
        Shape groundShape = new BoxShape(21f, 1f);
        Body ground = new StaticBody(this, groundShape);
        ground.setPosition(new Vec2(0, -15f));
        // walls
        Shape leftWallShape = new BoxShape(0.5f, 18, new Vec2(-19.5f, 19f));
        Fixture leftWall = new SolidFixture(ground, leftWallShape);
        Shape rightWallShape = new BoxShape(0.5f, 18, new Vec2(19.5f, 21.1f));
        Fixture rightWall = new SolidFixture(ground, rightWallShape);
        // end game
        NLsensor end = new NLsensor(this);
        end.getBody().setPosition(new Vec2(20f,-5));
        end.addSensorListener(new LevelExit(g, PY_main));

    }
    public int getCurrentRewinds() {
        return CurrentRewinds;
    }

    public void setCurrentRewinds(int currentRewinds) {
        CurrentRewinds = currentRewinds;
    }

    public Player getPlayer() {
        return PY_main;
    }
    public Door getDoor(){
        return door;
    }





}

