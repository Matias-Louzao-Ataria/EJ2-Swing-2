package ej1;

import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) {
        ControlDelRaton f = new ControlDelRaton();
        f.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        f.setSize(300,300);
        f.setVisible(true);
    }
}