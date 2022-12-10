package Ventana;

import Tienda.Tienda;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaPedirContraseña extends JFrame {
    private JPanel panel;

    public VentanaPedirContraseña(){
        setTitle("Pedir contraseña");
        setBounds(50,50,500,500);
        setLocationRelativeTo(null);
        setResizable(false);
        generarPanel();
        pedirContraseña();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void generarPanel(){
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.white);
        this.getContentPane().add(panel);
    }

    public void pedirContraseña(){
        JLabel etiqueta = new JLabel();
        etiqueta.setText("Ingrese la contraseña");
        etiqueta.setBounds(85,50,300,80);
        etiqueta.setHorizontalAlignment(SwingConstants.CENTER);
        etiqueta.setForeground(Color.BLACK);
        etiqueta.setFont(new Font("cooper black",1,17));
        panel.add(etiqueta);

        JPasswordField campoContraseña = new JPasswordField();
        campoContraseña.setBounds(85,110,300,20);
        panel.add(campoContraseña);

        JButton botonAceptarContraseña = new JButton();
        botonAceptarContraseña.setText("Ingresar");
        botonAceptarContraseña.setBounds(150,290,200,40);
        botonAceptarContraseña.setForeground(Color.black);
        botonAceptarContraseña.setFont(new Font("cooper black",1,15));
        panel.add(botonAceptarContraseña);

        ActionListener eventoAccion = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Tienda tienda = new Tienda();
                String contraseña1 = tienda.leerContraseña("Contraseña.txt");
                String contraseña = String.valueOf(campoContraseña.getPassword());
                if(contraseña.equals(contraseña1)){
                    dispose();
                    VentanaMenuPropietario ventanaMenuPropietario = new VentanaMenuPropietario();
                    ventanaMenuPropietario.setVisible(true);
                }else{
                    dispose();
                    VentanaPrincipal ventanaPrincipal = new VentanaPrincipal();
                    ventanaPrincipal.setVisible(true);
                }
            }
        };
        botonAceptarContraseña.addActionListener(eventoAccion);
    }
}

