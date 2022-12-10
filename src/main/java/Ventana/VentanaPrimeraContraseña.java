package Ventana;

import Tienda.Tienda;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaPrimeraContraseña extends JFrame {
    private JPanel panel;
    private JTextField txtContraseña;

    public VentanaPrimeraContraseña(){
        setTitle("Primera contraseña");
        setBounds(50,50,500,500);
        setLocationRelativeTo(null);
        setResizable(false);
        iniciarComponentes();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void iniciarComponentes(){
        generarPanel();
        etiquetaPrimeraContraseña();
        cajaTextoPrimeraContraseña();
        generarBotonPrimeraContraseña();
    }

    public void generarPanel(){
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.white);
        this.getContentPane().add(panel);
    }

    public void etiquetaPrimeraContraseña(){
        JLabel etiqueta = new JLabel();
        etiqueta.setText("No ha ingresado una contraseña anteriormente");
        etiqueta.setBounds(0,50,500,80);
        etiqueta.setHorizontalAlignment(SwingConstants.CENTER);
        etiqueta.setForeground(Color.BLACK);
        etiqueta.setFont(new Font("cooper black",1,17));
        panel.add(etiqueta);

        JLabel etiqueta1 = new JLabel();
        etiqueta1.setText("Por favor ingrese una contraseña");
        etiqueta1.setBounds(0,90,500,80);
        etiqueta1.setHorizontalAlignment(SwingConstants.CENTER);
        etiqueta1.setForeground(Color.BLACK);
        etiqueta1.setFont(new Font("cooper black",1,17));
        panel.add(etiqueta1);
    }

    public void cajaTextoPrimeraContraseña(){
        txtContraseña = new JTextField();
        txtContraseña.setBounds(150,200,200,40);
        panel.add(txtContraseña);
    }

    public void generarBotonPrimeraContraseña(){
        JButton botonPrimeraContraseña = new JButton();
        botonPrimeraContraseña.setText("Agregar contraseña");
        botonPrimeraContraseña.setBounds(150,270,200,40);
        botonPrimeraContraseña.setForeground(Color.black);
        botonPrimeraContraseña.setFont(new Font("cooper black",1,12));
        panel.add(botonPrimeraContraseña);

        ActionListener eventoClick = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Tienda tienda = new Tienda();
                String contraseña;
                contraseña = txtContraseña.getText();
                if(contraseña == null){
                    JOptionPane.showMessageDialog(null,"tiene que ingresar una contraseña valida");
                }else{
                    tienda.guardarContraseña(contraseña);
                    dispose();
                    VentanaMenuPropietario ventanaMenuPropietario = new VentanaMenuPropietario();
                    ventanaMenuPropietario.setVisible(true);
                }
            }
        };
        botonPrimeraContraseña.addActionListener(eventoClick);
    }
}
