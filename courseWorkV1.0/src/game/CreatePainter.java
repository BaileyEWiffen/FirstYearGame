package game;

import city.cs.engine.*;
import city.cs.engine.Shape;

import javax.swing.*;
import java.awt.*;

public class CreatePainter extends Sensor {
    private static final Shape S = new BoxShape(1.7f,2f);

    public CreatePainter(World W, Color C){
        //PainterBase B = new PainterBase(W);
        super(new PainterBase(W,C),S);

    }
}
