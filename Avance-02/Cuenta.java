package chooseandtravel;

public class Cuenta {

    protected String user;
    protected String pass;

    public Cuenta(String u, String p) {
        this.user = u;
        this.pass = p;
    }

    public String getUser() {
        return this.user;

    }

    public String getPass() {
        return this.pass;

    }
    
    public void setUser(String u){
        user=u;
    }
    
    public void setPass(String p){
        pass=p;
    }
}
