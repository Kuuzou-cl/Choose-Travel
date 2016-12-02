package chooseandtravel;

/**
 * 
 * Clase base para generar un objeto de tipo Admin
 *
 * @author Carlo Bernucci, Javier Nualart
 * @version 3.1
 */
public class Admin extends Cuenta {

    /**
     *
     * Constructor de la Clase Admin
     * @param u Parámetro tipo String, que se refiere al nombre de usuario
     * @param p Parámetro tipo String, que se refiere a la contraseña
     */
    public Admin(String u, String p) {
        super(u, p);
    }

    
}
