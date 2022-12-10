package Ventana;

import GestorDatos.GestorDatos;
import Tienda.Tienda;
import Tienda.Producto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class VentanaAgregarProducto extends JFrame {
    private JPanel panel;
    private JTextField nombreProducto;

    public VentanaAgregarProducto() {
        setTitle("Menú Propietario");
        setBounds(50, 50, 500, 500);
        setLocationRelativeTo(null);
        setResizable(false);
        iniciarComponentes();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void iniciarComponentes() {
        generarPanel();
        agregarProducto();
    }

    public void generarPanel() {
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.white);
        this.getContentPane().add(panel);
    }

    public void agregarProducto(){
        JLabel etiqueta = new JLabel();
        etiqueta.setText("Ingrese el nombre del producto");
        etiqueta.setBounds(0,50,500,80);
        etiqueta.setHorizontalAlignment(SwingConstants.CENTER);
        etiqueta.setForeground(Color.BLACK);
        etiqueta.setFont(new Font("cooper black",1,20));
        panel.add(etiqueta);

        nombreProducto = new JTextField();
        nombreProducto.setBounds(100,100,300,40);
        panel.add(nombreProducto);

        JLabel etiqueta2 = new JLabel();
        etiqueta2.setText("Ingrese el precio por unidad del producto");
        etiqueta2.setBounds(0,150,500,80);
        etiqueta2.setHorizontalAlignment(SwingConstants.CENTER);
        etiqueta2.setForeground(Color.BLACK);
        etiqueta2.setFont(new Font("cooper black",1,20));
        panel.add(etiqueta2);

        JTextField precioUnidad = new JTextField();
        precioUnidad.setBounds(100,200,300,40);
        panel.add(precioUnidad);

        JLabel etiqueta3 = new JLabel();
        etiqueta3.setText("Ingrese la cantidad total de dicho producto");
        etiqueta3.setBounds(0,250,500,80);
        etiqueta3.setHorizontalAlignment(SwingConstants.CENTER);
        etiqueta3.setForeground(Color.BLACK);
        etiqueta3.setFont(new Font("cooper black",1,20));
        panel.add(etiqueta3);

        JTextField cantidadProducto = new JTextField();
        cantidadProducto.setBounds(100,300,300,40);
        panel.add(cantidadProducto);

        JButton botonAceptarContraseña = new JButton();
        botonAceptarContraseña.setText("Ingresar");
        botonAceptarContraseña.setBounds(150,350,200,40);
        botonAceptarContraseña.setForeground(Color.black);
        botonAceptarContraseña.setFont(new Font("cooper black",1,15));
        panel.add(botonAceptarContraseña);

        ActionListener eventoClick = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Tienda tienda = new Tienda();
                ArrayList<Producto> listaDeProducto = GestorDatos.leerArchivoProductos();
                Producto producto = new Producto(nombreProducto.getText(),Integer.parseInt(precioUnidad.getText()),Integer.parseInt(cantidadProducto.getText()));
                Producto producto1 = tienda.buscarProducto(nombreProducto.getText(),listaDeProducto);
                if(producto1 == null){
                    tienda.agregarProducto(producto);
                    dispose();
                    VentanaMenuPropietario ventanaMenuPropietario = new VentanaMenuPropietario();
                    ventanaMenuPropietario.setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null,"El producto ya existe en el inventario");
                }
            }
        };
        botonAceptarContraseña.addActionListener(eventoClick);
    }
}
