package Ventana;

import GestorDatos.GestorDatos;
import Tienda.Producto;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class VentanaMostrarProducto extends JFrame {
    private JPanel panel;

    public VentanaMostrarProducto() {
        setTitle("Lista de productos");
        setBounds(50, 50, 500, 500);
        setLocationRelativeTo(null);
        setResizable(false);
        iniciarComponentes();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void iniciarComponentes(){
        generarPanel();
        etiquetaListaProductos();
        mostrarProductos();
    }

    public void generarPanel(){
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.white);
        this.getContentPane().add(panel);
    }

    public void etiquetaListaProductos(){
        JLabel etiqueta = new JLabel();
        etiqueta.setText("Lista de productos");
        etiqueta.setBounds(85,50,300,80);
        etiqueta.setHorizontalAlignment(SwingConstants.CENTER);
        etiqueta.setForeground(Color.BLACK);
        etiqueta.setFont(new Font("cooper black",1,20));
        panel.add(etiqueta);
    }

    public void mostrarProductos(){
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        JComboBox listaDesplegable = new JComboBox(modelo);
        ArrayList<Producto> listaDeProductos = new ArrayList<>();
        listaDeProductos = GestorDatos.leerArchivoProductos();
        for(Producto producto: listaDeProductos){
            modelo.addElement(producto.getNombre());
        }
        listaDesplegable.setBounds(140,150,200,30);
        panel.add(listaDesplegable);
    }
}
