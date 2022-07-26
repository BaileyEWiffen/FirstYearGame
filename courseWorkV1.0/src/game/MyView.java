package game;

import Levels.GameWorld;
import city.cs.engine.*;

import javax.swing.*;
import java.awt.*;

public class MyView extends UserView {
    private int frame = 0;
    private int seconds;
    private int min;
    private  Image R = new ImageIcon("data/R.png").getImage();
    private ControlPanel CP;


    public MyView(World world, int width, int height, ControlPanel CP) {
        super(world, width, height);
        this.CP = CP;

    }

    @Override
    protected void paintBackground(Graphics2D g) {
        g.drawImage(((GameWorld)this.getWorld()).BGimage(),0,0,this);
    }



    @Override
    protected void paintForeground(Graphics2D g) {
        CP.StableCheck();
        for(int i =0;i<((GameWorld)this.getWorld()).getCurrentRewinds();i++){
            g.drawImage(R,25*(i+1),15, this);
        }
        //System.out.println(((GameWorld)this.getWorld()).getCurrentRewinds());
        System.out.println();


        //
        frame++;
        seconds=(frame /15);

        if(seconds == 60){
            seconds =0;
            frame=0;
            min++;
        }
        g.setColor(Color.yellow);
        g.scale(1.5,1.5);
        if(seconds<10){
            g.drawString(min+":0"+seconds, 475,20);
        }
        else{
            g.drawString(min+":"+seconds, 475,20);
        }


    }



}
