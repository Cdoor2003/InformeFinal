package Ventana;

import GestorDatos.GestorDatos;
import Tienda.Producto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class VentanaMenuCliente extends JFrame {
    private JPanel panel;
    private JButton botonMostrarProductos, botonBuscarProducto, botonComprarProducto, botonSalir;

    public VentanaMenuCliente() {
        setTitle("Menú Cliente");
        setBounds(50, 50, 500, 500);
        setLocationRelativeTo(null);
        setResizable(false);
        iniciarComponentes();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void iniciarComponentes() {
        generarPanel();
        etiquetaCLiente();
        generarBotonMostrarProducto();
        generarBotonBuscarProducto();
        generarBotonComprarProducto();
        generarBotonSalir();
    }

    public void generarPanel(){
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.white);
        this.getContentPane().add(panel);
    }

    public void etiquetaCLiente(){
        JLabel etiqueta = new JLabel();
        etiqueta.setText("Menú Cliente");
        etiqueta.setBounds(85,50,300,80);
        etiqueta.setHorizontalAlignment(SwingConstants.CENTER);
        etiqueta.setForeground(Color.BLACK);
        etiqueta.setFont(new Font("cooper black",1,30));
        panel.add(etiqueta);
    }

    public void generarBotonSalir(){
        botonSalir = new JButton();
        botonSalir.setText("Salir");
        botonSalir.setBounds(135,330,200,40);
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

    public void generarBotonComprarProducto(){
        botonComprarProducto = new JButton();
        botonComprarProducto.setText("Comprar producto");
        botonComprarProducto.setBounds(135,270,200,40);
        botonComprarProducto.setForeground(Color.black);
        botonComprarProducto.setFont(new Font("cooper black",1,12));
        panel.add(botonComprarProducto);

        ActionListener eventoClick = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                VentanaComprarProducto ventanaComprarProducto = new VentanaComprarProducto();
                ventanaComprarProducto.setVisible(true);
            }
        };
        botonComprarProducto.addActionListener(eventoClick);
    }

    public void generarBotonBuscarProducto(){
        botonBuscarProducto = new JButton();
        botonBuscarProducto.setText("Buscar producto");
        botonBuscarProducto.setBounds(135,210,200,40);
        botonBuscarProducto.setForeground(Color.black);
        botonBuscarProducto.setFont(new Font("cooper black",1,12));
        panel.add(botonBuscarProducto);

        ActionListener eventoClick = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                VentanaBuscarProductos ventanaBuscarProductos = new VentanaBuscarProductos();
                ventanaBuscarProductos.setVisible(true);
            }
        };
        botonBuscarProducto.addActionListener(eventoClick);
    }

    public void generarBotonMostrarProducto(){
        botonMostrarProductos = new JButton();
        botonMostrarProductos.setText("Mostrar productos");
        botonMostrarProductos.setBounds(135,150,200,40);
        botonMostrarProductos.setForeground(Color.black);
        botonMostrarProductos.setFont(new Font("cooper black",1,12));
        panel.add(botonMostrarProductos);

        ActionListener eventoClick = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                VentanaMostrarProducto ventanaMostrarProducto = new VentanaMostrarProducto();
                ventanaMostrarProducto.setVisible(true);
            }
        };
        botonMostrarProductos.addActionListener(eventoClick);
    }
}
