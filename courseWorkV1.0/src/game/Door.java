package game;

import city.cs.engine.BoxShape;
import city.cs.engine.DynamicBody;
import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;

import java.awt.*;

public class Door extends DynamicBody {
    private static final Shape shape = new BoxShape(0.5f,0.95f);
    private Vec2 Origin;

    public void SetOrigin(){
        Origin = this.getPosition();
    }
    public Vec2 GetOrigin(){
        return Origin;
    }



    private static final BodyImage image =
            new BodyImage("data/Door.png", 1.9f);


    public Door(World world) {
        super(world);
        addImage(image);
        SolidFixture doorFixture = new SolidFixture(this, shape, 10000);






    }

}
