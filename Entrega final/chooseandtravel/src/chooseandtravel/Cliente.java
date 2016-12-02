package chooseandtravel;

/**
 * Clase base para crear objetos de tipo Cliente
 * 
 * @author Carlo Bernucci, Javier Nualart
 * @version 3.1
 */
public class Cliente extends Cuenta {

    private String nombre;
    private int sucursal;

    /**
     *
     * @param u Parametro de tipo String, representa el nombre de usuario
     * @param p Parametro de tipo String, representa la contraseña del usuario
     * @param n Parametro de tipo String, representa el nombre de la persona que ocupa el usuario 
     * @param s Parametro de tipo Integer, representa el numerod e sucursal del usuario
     */
    public Cliente(String u, String p, String n, int s) {
        super(u, p);
        this.nombre = n;
        this.sucursal = s;
    }

    /**
     *
     * @return Retorna un el nombre de la persona en formato String
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     * 
     * @return Retorn la sucursal del usuario, en formato Integer
     */
    public int getSucursal() {
        return this.sucursal;
    }

    /**
     * Metodo que cambia el nombre de la persona de un usuario, segun
     * un String recibido
     * @param n Parametro de tipo String, sera el nuevo nombre real del usuario
     */
    public void setNombre(String n) {
        nombre = n;
    }

    /**
     * Metodo que cambia la sucursal de un usuario, segun un parametro de
     * tipo Integer recibido
     * @param s Parametro de tipo Integer, sera la nueva sucursal del usuario
     */
    public void setSucursal(int s) {
        sucursal = s;
    }
    

}
