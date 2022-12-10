package Ventana;

import GestorDatos.GestorDatos;
import Tienda.Producto;
import Tienda.Tienda;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class VentanaBoleto extends JFrame {
    private JPanel panel;
    private String nombreProducto;
    private int cantidad;

    public VentanaBoleto(String nombreProducto, int cantidad){
        this.nombreProducto = nombreProducto;
        this.cantidad = cantidad;
        setTitle("boleta");
        setBounds(50, 50, 500, 500);
        setLocationRelativeTo(null);
        setResizable(false);
        iniciarComponentes();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void iniciarComponentes(){
        generarPanel();
        etiquetaBoleta();
    }

    public void generarPanel(){
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.white);
        this.getContentPane().add(panel);
    }

    public void etiquetaBoleta(){
        Tienda tienda = new Tienda();
        ArrayList<Producto> listaDeProductos = new ArrayList<Producto>();
        listaDeProductos = GestorDatos.leerArchivoProductos();
        Producto producto = tienda.buscarProducto(nombreProducto,listaDeProductos);

        int valorCompra = producto.getPrecioUnidad() * cantidad;

        JLabel etiqueta = new JLabel();
        etiqueta.setText("El valor de su compra es de: "+valorCompra);
        etiqueta.setBounds(0,50,500,80);
        etiqueta.setHorizontalAlignment(SwingConstants.CENTER);
        etiqueta.setForeground(Color.BLACK);
        etiqueta.setFont(new Font("cooper black",1,20));
        panel.add(etiqueta);
    }
}
