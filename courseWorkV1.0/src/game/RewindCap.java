package game;

import Levels.GameWorld;
import city.cs.engine.*;
import city.cs.engine.World;

public class RewindCap extends DynamicBody implements CollisionListener {
    Player p;
    GameWorld w;
    Game g;

    private static final BodyImage image =
            new BodyImage("data/R.png", 1.5f);
    private static final Shape shape = new BoxShape(0.5f,0.5f);
    public RewindCap(GameWorld w, Player p, Game g) {
        super(w, shape);
        this.p =p;
        this.w =w;
        this.g = g;
        this.addImage(image);
        this.addCollisionListener(this);
    }
    @Override
    public void collide(CollisionEvent e){
        if(e.getOtherBody() == p){

            e.getReportingBody().destroy();
            w.setCurrentRewinds(w.getCurrentRewinds()+1);

        }
    }

}
