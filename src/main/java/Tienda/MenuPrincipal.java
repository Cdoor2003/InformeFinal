package Tienda;

public class MenuPrincipal {
    public boolean contraseñaExiste(){
        Tienda tienda = new Tienda();
        String contraseña;
        contraseña = tienda.leerContraseña("Contraseña.txt");
        if(contraseña != null){
            return true;
        }
        return false;
    }
}
