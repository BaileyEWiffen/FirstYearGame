package Levels;
import Listeners.*;
import city.cs.engine.Body;
import city.cs.engine.BoxShape;
import city.cs.engine.*;
import game.*;
import org.jbox2d.common.Vec2;

import javax.swing.*;
import java.awt.*;

public class RoomThree extends GameWorld {
    private  Image BG = new ImageIcon("data/LevelBG3.jpg").getImage();


    @Override
    public void Populate(Game g) {
        super.Populate(g);
        Body platform1 = new StaticBody(this, new BoxShape(4, 0.5f));
        platform1.setPosition(new Vec2(-15, -8f));

        Body platform2 = new StaticBody(this, new BoxShape(2f, 0.5f));
        platform2.setPosition(new Vec2(-17, -2f));

        Body platform3 = new StaticBody(this, new BoxShape(4f, 0.5f));
        platform3.setPosition(new Vec2(15, -8f));

        Body platform4 = new StaticBody(this, new BoxShape(2f, 0.5f));
        platform4.setPosition(new Vec2(17, -2f));

        Body platform5 = new StaticBody(this, new BoxShape(2f, 0.5f));
        platform5.setPosition(new Vec2(9, -2f));

        Body platform6 = new StaticBody(this, new BoxShape(2f, 0.5f));
        platform6.setPosition(new Vec2(-9, -2f));

        //cube
        Cube CB = new Cube(this, Color.white);
        CB.setPosition(new Vec2(-17, 0));

        CB.addCollisionListener(new Carry(this.getPlayer(), CB));

        //painters
        CreatePainter PT_yellow = new CreatePainter(this,Color.yellow);
        PT_yellow.getBody().setPosition(new Vec2(17, -6f));
        PT_yellow.addSensorListener(new ColourSwap(this.getPlayer(), CB));

        CreatePainter PT_blue = new CreatePainter(this,Color.blue);
        PT_blue.getBody().setPosition(new Vec2(-17,-6));
        PT_blue.addSensorListener(new ColourSwap(this.getPlayer(), CB));

        //button
        ButtonSensor BT_blue = new ButtonSensor(this,Color.blue);
        BT_blue.getBody().setPosition(new Vec2(5,-12));

        //turret
        CreateTurret T_yellow = new CreateTurret(this,Color.yellow);
        T_yellow.getBody().setPosition(new Vec2(17, 0f));;
        T_yellow.addSensorListener(new Tshoot(g, this.getPlayer()));
        //rewind
        RewindCap R = new RewindCap(this, this.getPlayer(),g);
        R.setPosition(new Vec2(9, 0f));

        //open door
        BT_blue.addSensorListener(new Open(BT_blue, this.getDoor()));
        //Carry
        this.addStepListener(new Bind(CB, this.getPlayer()));
    }



    @Override
    public Vec2 startPosition() {
        return new Vec2(-18, -13);
    }

    @Override
    public Vec2 doorPosition() {
        return new Vec2(19.5f,-13f);
    }

    @Override
    public Image BGimage() {
        return BG;
    }




}
