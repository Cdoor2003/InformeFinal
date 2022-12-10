package Ventana;

import Tienda.Tienda;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaCambiarContraseña extends JFrame {
    private JPanel panel;

    public VentanaCambiarContraseña() {
        setTitle("Cambiar contraseña");
        setBounds(50, 50, 500, 500);
        setLocationRelativeTo(null);
        setResizable(false);
        iniciarComponentes();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void iniciarComponentes() {
        generarPanel();
        cambiarContraseña();
    }

    public void generarPanel() {
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.white);
        this.getContentPane().add(panel);
    }

    public void cambiarContraseña(){
        JLabel etiqueta = new JLabel();
        etiqueta.setText("Ingrese la nueva contraseña");
        etiqueta.setBounds(85,50,300,80);
        etiqueta.setHorizontalAlignment(SwingConstants.CENTER);
        etiqueta.setForeground(Color.BLACK);
        etiqueta.setFont(new Font("cooper black",1,20));
        panel.add(etiqueta);

        JTextField txtContraseña = new JTextField();
        txtContraseña.setBounds(150,120,200,40);
        panel.add(txtContraseña);

        JButton botonAceptarContraseña = new JButton();
        botonAceptarContraseña.setText("Ingresar");
        botonAceptarContraseña.setBounds(150,290,200,40);
        botonAceptarContraseña.setForeground(Color.black);
        botonAceptarContraseña.setFont(new Font("cooper black",1,15));
        panel.add(botonAceptarContraseña);

        ActionListener eventoClick = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Tienda tienda = new Tienda();
                String nuevaContraseña = txtContraseña.getText();
                tienda.guardarContraseña(nuevaContraseña);
                dispose();
                VentanaMenuPropietario ventanaMenuPropietario = new VentanaMenuPropietario();
                ventanaMenuPropietario.setVisible(true);
            }
        };
        botonAceptarContraseña.addActionListener(eventoClick);
    }
}
