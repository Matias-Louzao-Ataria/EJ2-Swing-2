package ej2;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MouseHandler extends MouseAdapter {
    
    private Clase c;
    
    public MouseHandler(Clase c) {
        super();
        this.c = c;
    }
    
    @Override
    public void mouseEntered(MouseEvent e) {
        JButton b;
        b = (JButton) e.getSource();
        if(b.getBackground() == Color.ORANGE){

        }else{
            b.setBackground(Color.GREEN);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        JButton b;
        b = (JButton) e.getSource();
        if(b.getBackground() == Color.ORANGE){

        }else{
            b.setBackground(null);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        JButton b;
        b = (JButton) e.getSource();
        b.setBackground(Color.ORANGE);
        c.txf.setText(c.txf.getText()+b.getText());
    }
}