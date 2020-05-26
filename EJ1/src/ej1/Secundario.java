package ej1;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Secundario extends JDialog implements ActionListener, ItemListener {

    private JTextField text = new JTextField("Título del formulario principal.");
    private JComboBox combo = new JComboBox<>();

    public Secundario(ControlDelRaton c,String titulo,boolean modal) {
        super(c,titulo,modal);
        text.setSize(text.getPreferredSize());
        this.setLayout(new FlowLayout());
        text.addActionListener(this);
        combo.addItem("Green");
        System.setProperty("Green", Integer.toString(Color.GREEN.getRGB()));
        combo.addItem("Magenta");
        System.setProperty("Magenta", Integer.toString(Color.MAGENTA.getRGB()));
        combo.addItem("Yellow");
        System.setProperty("Yellow", Integer.toString(Color.YELLOW.getRGB()));
        combo.addItem("Red");
        System.setProperty("Red", Integer.toString(Color.RED.getRGB()));
        combo.addItemListener(this);
        this.add(text);
        this.add(combo);
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        ControlDelRaton c = (ControlDelRaton) this.getOwner();
        c.setTitle(text.getText());
        c.setTitulo(c.getTitle());
    }

    @Override
    public void itemStateChanged(ItemEvent arg0) {
        ControlDelRaton c = (ControlDelRaton) this.getOwner();
        c.color = Color.getColor((String)combo.getSelectedItem());

    }

}