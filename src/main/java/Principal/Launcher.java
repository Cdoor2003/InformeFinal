package Principal;

import Ventana.VentanaPrincipal;

import java.io.IOException;

public class Launcher {
    public static void main(String[] args) throws IOException {
        VentanaPrincipal ventanaPrincipal = new VentanaPrincipal();
        ventanaPrincipal.setVisible(true);
    }
}
