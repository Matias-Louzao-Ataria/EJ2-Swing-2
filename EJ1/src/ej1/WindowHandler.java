package ej1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class WindowHandler extends WindowAdapter{
    @Override
        public void windowClosing(WindowEvent e) {
            int select = JOptionPane.showConfirmDialog(null, "Quieres cerrar la ventana?");
                if(select == 0){
                    e.getWindow().dispose();
                }
        }
}