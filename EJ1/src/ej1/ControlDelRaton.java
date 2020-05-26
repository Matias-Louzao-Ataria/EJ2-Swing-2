package ej1;

import javax.swing.*;
import java.awt.Color;
import java.awt.event.*;

public class ControlDelRaton extends JFrame {
    
    JButton btnizquierda = new JButton("Izquierdo");
    JButton btnderecha = new JButton("Derecho");
    JLabel lblteclas = new JLabel("Teclas");
    String titulo = "Control de Ratón";
    Color color = Color.BLUE;
    Secundario s;
    double x,y;

    public ControlDelRaton() {
        super();
        this.setTitle(titulo);
        this.setLayout(null);
        lblteclas.setLocation(50,110);
        lblteclas.setSize(lblteclas.getPreferredSize());
        btnizquierda.setLocation(20,150);
        btnizquierda.setSize(btnizquierda.getPreferredSize());
        btnderecha.setLocation(150,150);
        btnderecha.setSize(btnderecha.getPreferredSize());
        this.addWindowListener(new WindowHandler());
        this.addMouseListener(new MouseHandler());
        this.addMouseMotionListener(new MouseHandler());
        btnizquierda.addMouseMotionListener(new MouseHandler());
        btnderecha.addMouseMotionListener(new MouseHandler());
        this.addKeyListener(new KeyboardHandler());
        this.setFocusable(true);
        this.add(btnizquierda);
        this.add(btnderecha);
        this.add(lblteclas);
        s = new Secundario(this,"Secundario",true);
    }

    private class MouseHandler extends MouseAdapter{
        
        @Override
        public void mousePressed(MouseEvent e) {
            if(e.getButton() == MouseEvent.BUTTON1){
                btnizquierda.setForeground(color);
            }else{
                btnderecha.setForeground(color);
            }
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            if(e.getButton() == MouseEvent.BUTTON1) {
                btnizquierda.setForeground(Color.BLACK);
            }else if(e.getButton() == MouseEvent.BUTTON3){
                btnderecha.setForeground(Color.BLACK);
            }
        }
        
        @Override
        public void mouseMoved(MouseEvent e) {
            if(e.getSource().getClass() == ControlDelRaton.class){
                x = e.getX();
                y = e.getY();
                setTitle(titulo+" X: "+x+" Y: "+y);
            }else{
                setTitle(titulo+" X: "+(e.getX()+x)+" Y: "+(e.getY()+y));
            }
        }

        @Override
        public void mouseExited(MouseEvent e) {
            setTitle(titulo);
        }
    }

    private class KeyboardHandler extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e) {
            if(e.isControlDown() && (e.getKeyCode() == KeyEvent.VK_C)) {
                s.pack();
                s.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);            
                s.setVisible(true);//Todo el código déspues de hacer visible no se ejecuta hasta que se cierra, por lo tanto se pone de último.
            }else{
                lblteclas.setText("Unicode: "+Integer.toString(e.getKeyChar())+" Código de teclado: "+e.getKeyCode()+".");
                lblteclas.setSize(lblteclas.getPreferredSize());
            }

        }
    }

    public String getTitulo() {
        return this.titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Color getColor() {
        return this.color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}