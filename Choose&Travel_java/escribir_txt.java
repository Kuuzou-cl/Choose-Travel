import java.io.*;
public class escribir_txt
{
    private String usuario;
    public Datos_txt txt;
    
    public escribir_txt()
    {
        usuario="";
    }
       
    public void stringUsserPass(String u, String p)
    {
        usuario=u+"|"+p;
    }
    
    public void save_usser()throws IOException
    {
        txt.escribir(usuario);
    }
    
    public void setUsuario(String u)
    {
        usuario=u;
    }
    
    public String getUsuario()
    {
        return usuario;
    }
}
