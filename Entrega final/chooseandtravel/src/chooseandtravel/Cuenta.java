package chooseandtravel;

/**
 *Clase Padre de las clase Cliente y Admin
 * 
 * @author Carlo Bernucci, Javier Nualart
 * @version 3.1
 */
public class Cuenta {

    /**
     *
     */
    protected String user;

    /**
     *
     */
    protected String pass;

    /**
     *
     * @param u Parametro de tipo String, que representa el nombre de usuario
     * @param p Paramtro de tipo String, que representa la contraseña del usuario
     */
    public Cuenta(String u, String p) {
        this.user = u;
        this.pass = p;
    }

    /**
     *
     * @return Retorna el nombre de usuario
     */
    public String getUser() {
        return this.user;

    }

    /**
     *
     * @return Retorna la contraseña del usuario
     */
    public String getPass() {
        return this.pass;

    }
    
    /**
     * Metodo para asignar un String al nombre de usuario
     * @param u Parametro que representa el nombre de usuario
     */
    public void setUser(String u){
        user=u;
    }
    
    /**
     * Metodo para asignar un String a la contraseña de usuario
     * @param p Parametro que representa la contraseña de usuario
     */
    public void setPass(String p){
        pass=p;
    }
}
