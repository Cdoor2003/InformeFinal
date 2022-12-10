package Ventana;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaMenuPropietario extends JFrame {
    private JPanel panel, panel2;
    private JButton botonPrimeraContraseña;
    private JTextField txtContraseña;
    private JLabel etiqueta1;

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
        etiquetaConCotraseña();
        generarBotonCambiarContraseña();
        generarBotonAgregarProducto();
        generarBotonSalir();
    }

    public void generarPanel(){
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.white);
        this.getContentPane().add(panel);
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

    public void generarBotonCambiarContraseña(){
        JButton botonCambiarContraseña = new JButton();
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
        JButton botonAgregarProducto = new JButton();
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
        JButton botonSalir = new JButton();
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
