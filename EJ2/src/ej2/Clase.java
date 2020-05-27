package ej2;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.*;

public class Clase extends JFrame implements ActionListener{
    
    int x=10,y=350;
    JTextField txf = new JTextField();
    JButton btnreset = new JButton("Reset");
    private ArrayList<Component> comps = new ArrayList<Component>();
    private JMenuBar menu = new JMenuBar();
    JMenuItem grabar = new JMenuItem("Grabar número");
    JMenuItem leer = new JMenuItem("Leer");
    JMenuItem reset = new JMenuItem("Reset");
    JMenuItem salir = new JMenuItem("Salir");
    JMenuItem acerca = new JMenuItem("Acerca de...");
    public String home = System.getProperty("user.home");
    public String separator = System.getProperty("file.separator");
    private File archivonum = new File(home+separator+"numeros.txt");

    public Clase() {
        super("Teclado");
        this.setLayout(null);
        btnreset.setLocation(90,5);
        btnreset.addActionListener(this);
        btnreset.setSize(btnreset.getPreferredSize());
        txf.setColumns(12);
        txf.setEditable(false);
        txf.setSize(txf.getPreferredSize());
        txf.setLocation(10,100);
        this.setFocusable(true);
        this.addKeyListener(new KeyboardHandler(this));
        this.add(txf);
        this.add(btnreset);
        generarTeclado();

        //Archivo
        JMenu archivo = new JMenu("Archivo");
        archivo.setMnemonic('A');
        grabar.setMnemonic('G');
        leer.setMnemonic('L');
        grabar.addActionListener(this);
        leer.addActionListener(this);
        archivo.add(grabar);
        archivo.add(leer);
        menu.add(archivo);

        //Móvil
        JMenu movil = new JMenu("Móvil");
        movil.setMnemonic('M');
        reset.setMnemonic('R');
        reset.addActionListener(this);
        salir.setMnemonic('S');
        salir.addActionListener(this);
        movil.add(reset);
        movil.addSeparator();
        movil.add(salir);
        menu.add(movil);
        
        //Otros
        JMenu otros = new JMenu("Otros");
        otros.setMnemonic('O');
        acerca.addActionListener(this);
        acerca.setMnemonic('C');
        otros.add(acerca);
        menu.add(otros);

        this.setJMenuBar(menu);
    }

    public void generarTeclado(){
        for(int i = 0;i < 12;i++){
            JButton b = new JButton();
            if(i > 8){
                if(i == 9){
                    b.setText("#");
                }else if(i == 10){
                    b.setText(String.valueOf(0));
                }else{
                    b.setText("*");
                }
            }else{
                b.setText(Integer.toString(i+1));
            }
            b.setSize(b.getPreferredSize());
            if(i == 0){
                b.setText(String.valueOf(i+1));
                b.setLocation(x, y);
            }else if(i % 3 != 0){
                x+=45;
                b.setLocation(x, y);
            }else{
                x=10;
                y+=30;
                b.setLocation(x, y);
            }
            b.addMouseListener(new MouseHandler(this));
            this.add(b);
            comps.add(b);
        }
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        if(arg0.getSource() == btnreset || arg0.getSource() == reset){
            reset();
        }else if(arg0.getSource() == this.grabar){
            try(PrintWriter escritor = new PrintWriter(new FileWriter(archivonum,true))){
                escritor.append(txf.getText()+"\n");
            }catch(IOException | SecurityException e){
                JOptionPane.showMessageDialog(null,"Error de acceso al archivo!");
            }
        }else if(arg0.getSource() == this.leer){
            if(archivonum.exists()){
                try (Scanner sc = new Scanner(archivonum)) {
                    txf.setText(sc.nextLine());
                } catch (FileNotFoundException | SecurityException e) {
                    JOptionPane.showMessageDialog(null,"Error de acceso al archivo!");
                }
            }else{
                JOptionPane.showMessageDialog(null,"No existe el archivo: "+archivonum+" del que  se lee!");
            }
        }else if(arg0.getSource() == acerca){
            JOptionPane.showMessageDialog(null, "Ejercicio 2 del boletín de Swing parte 2.\nAutor:Matias Louzao Ataria. Alumno del colegio vivas de primer año de DAM.\n Los menús hacen crecer el código muy rápido.");
        }else if(arg0.getSource() == salir){
            this.dispose();
        }
    }

    private void reset() {
        this.txf.setText("");
        for (Component component : this.comps) {
            component.setBackground(null);
        }
    }

}
