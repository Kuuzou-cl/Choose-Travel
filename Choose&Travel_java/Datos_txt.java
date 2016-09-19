import java.io.*;
import java.io.File;
import java.io.FileWriter;


public class Datos_txt
{
    private static String nombre;
    private File datos_usuarios;
    
    public Datos_txt()
    {
      nombre="d_usuarios";
    }
    
    public static void crear()throws IOException
    {
        File datos_usuarios = new File (nombre);  
        String saludo="Hola";    
        datos_usuarios.createNewFile();       
    }
    
    public void escribir(String u)throws IOException
    {
        FileWriter writer = new FileWriter(datos_usuarios);
        writer.write(u+"\n"); 
        writer.flush();
        writer.close();
    }
    
    public void setNombre(String n)
    {
        nombre=n;
    }
    
    public String getNombre()
    {
        return nombre;
    }
}
