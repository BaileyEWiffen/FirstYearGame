package Levels;

import Listeners.*;
import city.cs.engine.*;
import game.*;
import org.jbox2d.common.Vec2;

import javax.swing.*;
import java.awt.*;

public class RoomTwo extends GameWorld {
    private Image BG = new ImageIcon("data/LevelBG2.jpg").getImage();

        @Override
        public void Populate(Game g){
            super.Populate(g);
            Body platform1 = new StaticBody(this, new BoxShape(9, 0.5f));
            platform1.setPosition(new Vec2(0, -8f));

            Body platform2 = new StaticBody(this, new BoxShape(0.5f, 2f));
            platform2.setPosition(new Vec2(7, -6f));

            Body platform3 = new StaticBody(this, new BoxShape(7, 0.5f));
            platform3.setPosition(new Vec2(-14, -3f));
            //moving plat
            MovingPlat MP = new MovingPlat(this,-5,5, new Vec2(-5,-3f));
            //cubes
            Cube CB = new Cube(this, Color.blue);
            CB.setPosition(new Vec2(-14, -0));

            CB.addCollisionListener(new Carry(this.getPlayer(), CB, MP));
            //painters
            CreatePainter PT_blue = new CreatePainter(this, Color.blue);
            PT_blue.getBody().setPosition(new Vec2(-14, -1f));
            PT_blue.addSensorListener(new ColourSwap(this.getPlayer(), CB));

            CreatePainter PT_red = new CreatePainter(this, Color.red);
            PT_red.getBody().setPosition(new Vec2(-6, -6f));
            PT_red.addSensorListener(new ColourSwap(this.getPlayer(), CB));
            //buttons
            ButtonSensor BT_blue = new ButtonSensor(this,Color.blue);
            BT_blue.getBody().setPosition(new Vec2(0,-11));

            ButtonSensor BT_red = new ButtonSensor(this,Color.red);
            BT_red.getBody().setPosition(new Vec2(-10,-11));
            //open door
            BT_blue.addSensorListener(new Open(BT_blue, this.getDoor()));
            //move plat
            BT_red.addSensorListener(new PlatOn(BT_red,MP));
            //rewind
            RewindCap R = new RewindCap(this, this.getPlayer(),g);
            R.setPosition(new Vec2(7,0));
            //Carry
            this.addStepListener(new Bind(CB, this.getPlayer(),MP));
        }











    public boolean Finished() {
        return false;
    }

    @Override
    public Vec2 startPosition() {
        return new Vec2(-18, -13);
    }

    @Override
    public Vec2 doorPosition() {
        return new Vec2(19.5f,-13f);
    }


    public Image BGimage() {
        return BG;
    }
}

