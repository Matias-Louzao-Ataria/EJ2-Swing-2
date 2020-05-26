package ej2;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class KeyboardHandler extends KeyAdapter{
    
    Clase c;

    public KeyboardHandler(Clase c) {
        super();
        this.c = c;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        if((Character.getNumericValue(e.getKeyChar()) >= 0 && Character.getNumericValue(e.getKeyChar()) <= 9) || e.getKeyChar() == '#' || e.getKeyChar() == '*'){
            c.txf.setText(c.txf.getText()+e.getKeyChar());
        }
    }

}