/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

/**
 *
 * @author juan
 */
public class Admin extends Cuenta{
    private boolean admin;
    public Admin(String us,String pas){
    super(us,pas);
    admin=true;
    }
    public boolean getAdmin(){
    return admin;
    }
    public static void AdMenu(){
    System.out.println("--------Menu de configuracion-------");
     System.out.println("1. Agregar cuenta");
     System.out.println("2. Modificar password");
     System.out.println("3. Modificar informacion de usuario ");
     System.out.println("4. Eliminar Cuenta");
     //FALTA LA OPCION MOSTRAR OBJETOS
     System.out.println("5. Guardar y Salir");
    }
}
