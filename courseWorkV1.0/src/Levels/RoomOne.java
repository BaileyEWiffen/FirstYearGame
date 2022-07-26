package Levels;
import Listeners.Bind;
import Listeners.Carry;
import Listeners.ColourSwap;
import Listeners.Open;
import city.cs.engine.*;
import city.cs.engine.Shape;
import game.*;

import org.jbox2d.common.Vec2;

import javax.swing.*;
import java.awt.*;

public class RoomOne extends GameWorld {

    private Boolean Finished = false;
    private  Image BG = new ImageIcon("data/Space.jpg").getImage();

    @Override
    public void Populate(Game g) {
        super.Populate(g);

        // make platforms
        Shape boxShape = new BoxShape(4, 0.5f);

        Body platform1 = new StaticBody(this, boxShape);
        platform1.setPosition(new Vec2(10, -2.5f));

        Body platform2 = new StaticBody(this, boxShape);
        platform2.setPosition(new Vec2(0, -8.5f));

        Body platform3 = new StaticBody(this, boxShape);
        platform3.setPosition(new Vec2(-10, -2.5f));

        Body platform4 = new StaticBody(this, boxShape);
        platform4.setPosition(new Vec2(0, 4.5f));


        //make buttons
        ButtonSensor BT_R1_1 = new ButtonSensor(this,Color.red);
        BT_R1_1.getBody().setPosition(new Vec2(-10,-12));


        //Make door
        BT_R1_1.addSensorListener(new Open(BT_R1_1, this.getDoor()));

        //Cube
        Cube CB_R1_1 = new Cube(this, Color.white);
        CB_R1_1.setPosition(new Vec2(0,10));
        CB_R1_1.addCollisionListener(new Carry(this.getPlayer(),CB_R1_1));

        //Paint
        CreatePainter PT_R1_red = new CreatePainter(this, Color.red);
        PT_R1_red.getBody().setPosition(new Vec2(10,0));
        PT_R1_red.addSensorListener(new ColourSwap(this.getPlayer(), CB_R1_1));

        //rewind
        RewindCap R = new RewindCap(this,this.getPlayer(),g);
        R.setPosition(new Vec2(0,0));

        //Carry
        this.addStepListener(new Bind(CB_R1_1,this.getPlayer()));



    }





    public boolean Finished() {
        return false;
    }


    public Vec2 startPosition() {
        return new Vec2(8, -10);
    }


    public Vec2 doorPosition() {
        return new Vec2(19.5f,-13f);
    }

    public Image BGimage() {
        return BG;
    }


}
