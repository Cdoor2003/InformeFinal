package Ventana;

import Tienda.Producto;
import GestorDatos.GestorDatos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class VentanaComprarProducto extends JFrame {
    private JPanel panel;
    private JButton boton;

    public VentanaComprarProducto(){
        setTitle("Comprar productos");
        setBounds(50, 50, 500, 500);
        setLocationRelativeTo(null);
        setResizable(false);
        iniciarComponentes();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void iniciarComponentes(){
        generarPanel();
        etiquetaComprarProductos();
        comprarProducto();
    }

    public void generarPanel(){
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.white);
        this.getContentPane().add(panel);
    }

    public void etiquetaComprarProductos(){
        JLabel etiqueta = new JLabel();
        etiqueta.setText("Comprar producto");
        etiqueta.setBounds(85,50,300,80);
        etiqueta.setHorizontalAlignment(SwingConstants.CENTER);
        etiqueta.setForeground(Color.BLACK);
        etiqueta.setFont(new Font("cooper black",1,20));
        panel.add(etiqueta);
    }

    public void comprarProducto(){
        ArrayList<Producto> listaDeProductos = new ArrayList<>();
        listaDeProductos = GestorDatos.leerArchivoProductos();

        JLabel etiqueta = new JLabel();
        etiqueta.setText("Ingrese el nombre del producto");
        etiqueta.setBounds(0,100,500,80);
        etiqueta.setHorizontalAlignment(SwingConstants.CENTER);
        etiqueta.setForeground(Color.BLACK);
        etiqueta.setFont(new Font("cooper black",1,20));
        panel.add(etiqueta);

        JTextField nombreProducto = new JTextField();
        nombreProducto.setBounds(100,150,300,40);
        panel.add(nombreProducto);

        JLabel etiqueta2 = new JLabel();
        etiqueta2.setText("Ingrese la cantidad que desea comprar");
        etiqueta2.setBounds(0,200,500,80);
        etiqueta2.setHorizontalAlignment(SwingConstants.CENTER);
        etiqueta2.setForeground(Color.BLACK);
        etiqueta2.setFont(new Font("cooper black",1,20));
        panel.add(etiqueta2);

        JTextField cantidad = new JTextField();
        cantidad.setBounds(100,250,300,40);
        panel.add(cantidad);

        JButton boton = new JButton();
        boton.setText("Comprar");
        boton.setBounds(135,300,200,40);
        boton.setForeground(Color.black);
        boton.setFont(new Font("cooper black",1,12));
        panel.add(boton);

        ActionListener eventoClick = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                VentanaBoleto ventanaBoleto = new VentanaBoleto(nombreProducto.getText(),Integer.parseInt(cantidad.getText()));
                ventanaBoleto.setVisible(true);
            }
        };
        boton.addActionListener(eventoClick);
    }
}
