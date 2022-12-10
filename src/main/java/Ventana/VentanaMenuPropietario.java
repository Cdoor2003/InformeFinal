package Ventana;

import Tienda.MenuPrincipal;
import Tienda.Tienda;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaMenuPropietario extends JFrame {
    private JPanel panel, panel2;
    private JButton botonPrimeraContraseña, botonCambiarContraseña, botonAgregarProducto, botonSalir;
    private JTextField txtContraseña;

    public VentanaMenuPropietario(){
        setTitle("Menú Propietario");
        setBounds(50,50,500,500);
        setLocationRelativeTo(null);
        setResizable(false);
        iniciarComponentes();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void iniciarComponentes() {
        generarPanel();
        MenuPrincipal menuPrincipal = new MenuPrincipal();
        if(!menuPrincipal.contraseñaExiste()){
            etiquetaNoContraseña();
            cajaTextoNoContraseña();
            generarBotonPrimeraContraseña();
        }else{
            etiquetaConCotraseña();
            generarBotonCambiarContraseña();
            generarBotonAgregarProducto();
            generarBotonSalir();
        }
    }

    public void generarPanel(){
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.white);
        this.getContentPane().add(panel);
    }

    public void etiquetaNoContraseña(){
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

    public void etiquetaConCotraseña(){
        JLabel etiqueta = new JLabel();
        etiqueta.setText("Menú Propietario");
        etiqueta.setBounds(85,50,300,80);
        etiqueta.setHorizontalAlignment(SwingConstants.CENTER);
        etiqueta.setForeground(Color.BLACK);
        etiqueta.setFont(new Font("cooper black",1,30));
        panel.add(etiqueta);
    }

    public void cajaTextoNoContraseña(){
        txtContraseña = new JTextField();
        txtContraseña.setBounds(150,200,200,40);
        panel.add(txtContraseña);
    }

    public void generarBotonPrimeraContraseña(){
        botonPrimeraContraseña = new JButton();
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
                tienda.guardarContraseña(contraseña);
            }
        };
        botonPrimeraContraseña.addActionListener(eventoClick);
    }

    public void generarBotonCambiarContraseña(){
        botonCambiarContraseña = new JButton();
        botonCambiarContraseña.setText("Cambiar contraseña");
        botonCambiarContraseña.setBounds(150,170,200,40);
        botonCambiarContraseña.setForeground(Color.black);
        botonCambiarContraseña.setFont(new Font("cooper black",1,15));
        panel.add(botonCambiarContraseña);

        ActionListener eventoClick = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                VentanaCambiarContraseña ventanaCambiarContraseña = new VentanaCambiarContraseña();
                ventanaCambiarContraseña.setVisible(true);
            }
        };
        botonCambiarContraseña.addActionListener(eventoClick);
    }

    public void generarBotonAgregarProducto(){
        botonAgregarProducto = new JButton();
        botonAgregarProducto.setText("Agregar producto");
        botonAgregarProducto.setBounds(150,230,200,40);
        botonAgregarProducto.setForeground(Color.black);
        botonAgregarProducto.setFont(new Font("cooper black",1,15));
        panel.add(botonAgregarProducto);

        ActionListener eventoClick = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                VentanaAgregarProducto ventanaAgregarProducto = new VentanaAgregarProducto();
                ventanaAgregarProducto.setVisible(true);
            }
        };
        botonAgregarProducto.addActionListener(eventoClick);
    }

    public void generarBotonSalir(){
        botonSalir = new JButton();
        botonSalir.setText("Salir");
        botonSalir.setBounds(150,290,200,40);
        botonSalir.setForeground(Color.black);
        botonSalir.setFont(new Font("cooper black",1,15));
        panel.add(botonSalir);

        ActionListener eventoClick = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                VentanaPrincipal ventanaPrincipal = new VentanaPrincipal();
                ventanaPrincipal.setVisible(true);
            }
        };
        botonSalir.addActionListener(eventoClick);
    }
}
