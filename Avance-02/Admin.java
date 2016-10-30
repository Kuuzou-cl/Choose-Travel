package chooseandtravel;

public class Admin extends Cuenta {

    private boolean admin;

    
    public Admin(String u, String p) {
        super(u, p);
        this.admin = true;
    }

    public boolean getAdmin() {
        return admin;
    }

    public static void menuAdmin() {
        System.out.println("--------Menu de configuracion-------");
        System.out.println("1. Agregar cuenta");
        System.out.println("2. Modificar password");
        System.out.println("3. Modificar informacion de usuario ");
        System.out.println("4. Eliminar Cuenta");
        System.out.println("5. Mostrar Cuentas");
        System.out.println("6. Agregar Sucursal");
        System.out.println("7. Eliminar Sucursal");
        System.out.println("8. Mostrar Sucursales");
        System.out.println("9. Guardar y Salir");
    }
    
    
}
