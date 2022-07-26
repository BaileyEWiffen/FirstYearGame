package game;


import Levels.*;
import city.cs.engine.*;

import javax.swing.JFrame;
import java.awt.*;

/**
 * The computer game.
 */
public class Game {

    /** The World in which the bodies move and interact. */
    private GameWorld world;
    private  int levelNum =1;
    private int CollectedT =0;
    private Controller con;

    public int getCollectedT() {
        return CollectedT;
    }

    public void setCollectedT(int collectedT) {
        CollectedT = collectedT;
    }

    /** A graphical display of the world (a specialised JPanel). */
    private MyView view;
    ControlPanel CP = new ControlPanel(this);



    /** Initialise a new Game. */
    public Game() {


        // make the world
        world = new RoomOne();

       //world = new RoomTwo();
        //levelNum =3;

        world.Populate(this);
        world.setCurrentRewinds(2);





        view = new MyView(world, 800, 600, CP);


        // make a view


        // uncomment this to draw a 1-metre grid over the view
         view.setGridResolution(1);

        // display the view in a frame
        JFrame frame = new JFrame("Project");


        frame.add(CP, BorderLayout.SOUTH);


        // quit the application when the game window is closed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        // display the world in the window
        frame.add(view);

        // don't let the game window be resized
        frame.setResizable(false);
        // size the game window to fit the world view
        frame.pack();
        // make the window visible
        frame.setVisible(true);
        // get keyboard focus
        frame.requestFocus();
        // give keyboard focus to the frame whenever the mouse enters the view
        view.addMouseListener(new GiveFocus(frame));
        con = new Controller(world.getPlayer());
        frame.addKeyListener(con);
        // uncomment this to make a debugging view
        JFrame debugView = new DebugViewer(world, 500, 500);

        // start!
        world.start();
        System.out.println("begin");

    }

    /** Run the game. */
    public static void main(String[] args) {
        new Game();


    }

    public void NextLevel(){
        levelNum++;
        Restart();
        System.out.println("Moving to level "+levelNum);
    }

    public GameWorld getWorld() {
        return world;
    }

    public int getLevelNum() {
        return levelNum;
    }

    public void Restart(){
        if(world.getCurrentRewinds()>=0) {
            int Rhold = world.getCurrentRewinds();
            //System.out.println("Moving to level "+levelNum);
            System.out.println("r");
            world.stop();
            if (levelNum == 1) {
                world = new RoomOne();
            }
            else if (levelNum == 2) {
                world = new RoomTwo();
            }
            else if (levelNum == 3) {
                world = new RoomThree();
            }
            else{
                System.exit(0);
            }
            world.Populate(this);
            world.setCurrentRewinds(Rhold);
            con.setBody(world.getPlayer());
            view.setWorld(world);
            world.start();
        }
        else{
            /*levelNum = 1;
            world.setCurrentRewinds(2);
            Restart();*/
            System.exit(0);

        }
    }
    public void Pause(){
        if (world.isRunning()){
            world.stop();
        }
        else{
            world.start();
        }


    }


}
