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
        etiqueta.setText("Buscar de productos");
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
                ArrayList<Producto> listaDeProductos = new ArrayList<>();
                listaDeProductos = GestorDatos.leerArchivoProductos();
                String nombreProducto = cajaTexto.getText();
                Producto producto = tienda.buscarProducto(nombreProducto,listaDeProductos);
                if(producto != null){
                    JLabel etiqueta1 = new JLabel();
                    etiqueta1.setText("Cantidad del Producto: "+producto.getCantidad());
                    etiqueta1.setBounds(85,300,300,80);
                    etiqueta1.setHorizontalAlignment(SwingConstants.CENTER);
                    etiqueta1.setForeground(Color.BLACK);
                    etiqueta1.setFont(new Font("cooper black",1,20));
                    panel.add(etiqueta1);

                    JLabel etiqueta2 = new JLabel();
                    etiqueta2.setText("Precio del producto: "+producto.getPrecioUnidad());
                    etiqueta2.setBounds(85,350,300,80);
                    etiqueta2.setHorizontalAlignment(SwingConstants.CENTER);
                    etiqueta2.setForeground(Color.BLACK);
                    etiqueta2.setFont(new Font("cooper black",1,20));
                    panel.add(etiqueta2);
                }else{
                    dispose();
                    VentanaMenuCliente ventanaMenuCliente = new VentanaMenuCliente();
                    ventanaMenuCliente.setVisible(true);
                }
            }
        };
        boton.addActionListener(eventoClick);
    }
}
