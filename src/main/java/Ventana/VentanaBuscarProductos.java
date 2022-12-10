package Ventana;

import Tienda.Producto;
import Tienda.Tienda;
import GestorDatos.GestorDatos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class VentanaBuscarProductos extends JFrame {
    private JPanel panel;
    private JTextField cajaTexto;

    public VentanaBuscarProductos() {
        setTitle("Lista de productos");
        setBounds(50, 50, 500, 500);
        setLocationRelativeTo(null);
        setResizable(false);
        iniciarComponentes();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void iniciarComponentes(){
        generarPanel();
        etiquetaBuscarProductos();
        buscarProductos();
    }

    public void generarPanel(){
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.white);
        this.getContentPane().add(panel);
    }

    public void etiquetaBuscarProductos(){
        JLabel etiqueta = new JLabel();
        etiqueta.setText("Buscar productos");
        etiqueta.setBounds(85,50,300,80);
        etiqueta.setHorizontalAlignment(SwingConstants.CENTER);
        etiqueta.setForeground(Color.BLACK);
        etiqueta.setFont(new Font("cooper black",1,20));
        panel.add(etiqueta);
    }

    public void buscarProductos(){
        JLabel etiqueta = new JLabel();
        etiqueta.setText("Ingrese el nombre del producto");
        etiqueta.setBounds(58,100,350,80);
        etiqueta.setHorizontalAlignment(SwingConstants.CENTER);
        etiqueta.setForeground(Color.BLACK);
        etiqueta.setFont(new Font("cooper black",1,12));
        panel.add(etiqueta);

        cajaTexto = new JTextField();
        cajaTexto.setBounds(135,200,200,40);
        panel.add(cajaTexto);

        JButton boton = new JButton();
        boton.setText("Aceptar");
        boton.setBounds(135,250,200,40);
        boton.setForeground(Color.black);
        boton.setFont(new Font("cooper black",1,12));
        panel.add(boton);

        ActionListener eventoClick = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Tienda tienda = new Tienda();
                ArrayList<Producto> listaDeProductos = GestorDatos.leerArchivoProductos();
                String nombreProducto = cajaTexto.getText();
                Producto producto = tienda.buscarProducto(nombreProducto,listaDeProductos);
                if(producto != null){
                    JOptionPane.showMessageDialog(null,"Cantidad disponible: "+producto.getCantidad()+"\nPrecio por unidad: "+producto.getPrecioUnidad());
                    JButton boton2 = new JButton();
                    boton2.setText("Volver");
                    boton2.setBounds(135,300,200,40);
                    boton2.setForeground(Color.black);
                    boton2.setFont(new Font("cooper black",1,12));
                    panel.add(boton2);

                    ActionListener eventoClick2 = new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            dispose();
                            VentanaMenuCliente ventanaMenuCliente = new VentanaMenuCliente();
                            ventanaMenuCliente.setVisible(true);
                        }
                    };
                    boton2.addActionListener(eventoClick2);
                }else{
                    JOptionPane.showMessageDialog(null,"El producto que busca no se encuentra en el inventario");
                }
            }
        };
        boton.addActionListener(eventoClick);
    }
}
