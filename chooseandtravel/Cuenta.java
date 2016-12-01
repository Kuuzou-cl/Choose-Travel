package chooseandtravel;

/**
 *
 * @author kuuzou
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
     * @param u
     * @param p
     */
    public Cuenta(String u, String p) {
        this.user = u;
        this.pass = p;
    }

    /**
     *
     * @return
     */
    public String getUser() {
        return this.user;

    }

    /**
     *
     * @return
     */
    public String getPass() {
        return this.pass;

    }
    
    /**
     *
     * @param u
     */
    public void setUser(String u){
        user=u;
    }
    
    /**
     *
     * @param p
     */
    public void setPass(String p){
        pass=p;
    }
}
