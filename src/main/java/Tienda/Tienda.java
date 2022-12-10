package Tienda;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import GestorDatos.GestorDatos;

public class Tienda {
    private String contraseña;
    private static ArrayList<Producto> listaProductos;

    public String leerContraseña(String direccionArchivo) {
        String textoArchivo = "";
        try {
            File archivo = new File(direccionArchivo);
            FileReader fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);
            while ((textoArchivo = br.readLine()) != null) {
                String[] data = textoArchivo.split(",");
                contraseña = data[0];
            }
            br.close();
            fr.close();
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Documento no disponible, favor contactar con administrador");
        }
        return contraseña;
    }

    public void guardarContraseña(String nuevaContraseña){
        boolean lineaVacia = false;
        File file = new File("Contraseña.txt");
        try {
            Files.deleteIfExists(Paths.get("Contraseña.txt"));
            if (!file.exists()) {
                file.createNewFile();
                lineaVacia = true;
            }
            FileWriter fw = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(fw);
            if (lineaVacia == false) {
                bw.newLine();
            }
            bw.write(nuevaContraseña);
            bw.close();
            fw.close();
        } catch (Exception e) {
            System.out.println("Documento no disponible, favor contactar con administrador");
        }
    }

    public void agregarProducto(Producto producto) {
        String nombre = producto.getNombre();
        listaProductos = GestorDatos.leerArchivoProductos();
        if(buscarProducto(nombre,listaProductos) == null){
            listaProductos.add(producto);
            GestorDatos.registrarDatos(getListaProductos(),"Productos.txt");
        }
    }

    public Producto buscarProducto(String nombre, ArrayList<Producto> listaDeProductos){
        for(Producto producto : listaDeProductos){
            if(producto.getNombre().equals(nombre)){
                return producto;
            }
        }
        return null;
    }

    public static ArrayList<Producto> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(ArrayList<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }
    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
}
