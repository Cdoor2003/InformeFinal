package Ventana;

import Tienda.Tienda;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class VentanaPrincipal extends JFrame {
    private JPanel panel;
    private JButton botonMenuPropietario;
    private JButton botonMenuCliente;

    public VentanaPrincipal() {
        setTitle("Menú Principal");
        setBounds(50,50,500,500);
        setLocationRelativeTo(null);
        setResizable(false);
        iniciarComponentes();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void iniciarComponentes(){
        generarPanel();
        generarEtiqueta();
        generarLogoUfro();
        generarBotonMenuPropietario();
        generarBotonMenuCliente();
    }

    public void generarPanel(){
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.white);
        this.getContentPane().add(panel);
    }

    public void generarEtiqueta(){
        JLabel etiqueta = new JLabel();
        etiqueta.setText("Menú Principal");
        etiqueta.setBounds(85,50,300,80);
        etiqueta.setHorizontalAlignment(SwingConstants.CENTER);
        etiqueta.setForeground(Color.BLACK);
        etiqueta.setFont(new Font("cooper black",1,30));
        panel.add(etiqueta);
    }

    public void generarLogoUfro(){
        ImageIcon imagen = new ImageIcon("LogoUfro.png");
        JLabel etiqueta = new JLabel(imagen);
        etiqueta.setBounds(380,5,80,80);
        etiqueta.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(etiqueta.getWidth(),etiqueta.getHeight(),Image.SCALE_SMOOTH)));
        panel.add(etiqueta);
    }

    public void generarBotonMenuPropietario(){
        botonMenuPropietario = new JButton();
        botonMenuPropietario.setText("Menú Propietario");
        botonMenuPropietario.setBounds(110,200,250,40);
        botonMenuPropietario.setForeground(Color.black);
        botonMenuPropietario.setFont(new Font("cooper black",1,20));
        panel.add(botonMenuPropietario);

        ActionListener irMenuPropietario = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                VentanaPedirContraseña ventanaPedirContraseña = new VentanaPedirContraseña();
                ventanaPedirContraseña.setVisible(true);
            }
        };
        botonMenuPropietario.addActionListener(irMenuPropietario);
    }

    public void generarBotonMenuCliente(){
        botonMenuCliente = new JButton();
        botonMenuCliente.setText("Menú Cliente");
        botonMenuCliente.setBounds(110,300,250,40);
        botonMenuCliente.setForeground(Color.black);
        botonMenuCliente.setFont(new Font("cooper black",1,20));
        panel.add(botonMenuCliente);

        ActionListener irMenuCliente = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                VentanaMenuCliente ventanaMenuCliente = new VentanaMenuCliente();
                ventanaMenuCliente.setVisible(true);

            }
        };
        botonMenuCliente.addActionListener(irMenuCliente);
    }
}
