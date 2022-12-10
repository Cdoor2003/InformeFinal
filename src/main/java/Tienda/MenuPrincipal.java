package Tienda;

public class MenuPrincipal {
    public String contraseñaExiste(){
        Tienda tienda = new Tienda();
        String contraseña;
        contraseña = tienda.leerContraseña("Contraseña.txt");
        return contraseña;
    }
}
