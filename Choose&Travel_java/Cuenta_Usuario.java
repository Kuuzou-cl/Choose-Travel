
public class Cuenta
{
    private String user;
    private String pass;
    private boolean admin;

    public Cuenta()
    {
        user=null;
        pass=null;
        admin=false;
    }

    public void setUser(String u)
    {
        user=u;
    }
    
    public String getUser()
    {
        return user;
    }
    
    public void setPass(String p)
    {
        pass=p;
    }
    
    public String getPass()
    {
        return pass;
    }
    
    public void setAdmin(boolean a)
    {
        admin=a;
    }
    
    public boolean getAdmin()
    {
        return admin;
    }
    
    
}
