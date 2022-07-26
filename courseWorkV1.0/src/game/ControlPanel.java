package game;
import game.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlPanel extends JPanel implements ActionListener {
    private JButton BT_reset;
    private JButton BT_pause;
    private Game g;


    public ControlPanel(Game g){
        this.g = g;
        BT_reset = new JButton("Rewind");
        this.add(BT_reset);
        BT_pause = new JButton("Pause");
        this.add(BT_pause);
        BT_pause.addActionListener(this);
        BT_reset.addActionListener(this);
    }

    public void StableCheck(){
        if(g.getWorld().getCurrentRewinds() == 0){
            BT_reset.setText("ERROR:Unstable");
        }
        else{
            BT_reset.setText("Rewind");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == BT_reset){
            g.getWorld().setCurrentRewinds(g.getWorld().getCurrentRewinds()-1);
            g.Restart();

        }
        if (e.getSource() == BT_pause){
            g.Pause();
            if (BT_pause.getText()== "Pause"){
                BT_pause.setText("Resume");
            }
            else{
                BT_pause.setText("Pause");
            }


        }

    }
}
