import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * Write a description of class datos here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class datos
{
    // instance variables - replace the example below with your own

    /**
     * Constructor for objects of class datos
     */
    public datos()
    {
    }
    public String leerString(){
        Scanner intro = new Scanner(System.in);
        String cadena=intro.nextLine();
        return cadena;
    }
    public static boolean valUs(String oper)
    {
        Pattern pat = Pattern.compile("^[a-z]{1}"+"\\.{1}"+"[a-z]+"+"\\d{2}$");
        Matcher mat = pat.matcher(oper);
        if (mat.matches()==false) {
            System.out.println("Rut ingresado incorrecto. intente de nuevo.");
            return false;
        }
        return true;
    }
     public static boolean valNewUs(String oper)
    {
        Pattern pat = Pattern.compile("^[a-z]+"+"\\|{1}"+"[a-z]+$");
        Matcher mat = pat.matcher(oper);
        if (mat.matches()==false) {
            System.out.println("Ingresado incorrecto. intente de nuevo.");
            return false;
        }
        return true;
    }
}
