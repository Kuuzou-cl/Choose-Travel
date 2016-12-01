package chooseandtravel;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author kuuzou
 */
public class Validador {

    /**
     *
     * @return
     */
    public String leerString() {
        Scanner intro = new Scanner(System.in);
        String cadena = intro.nextLine();
        return cadena;
    }

    /**
     *
     * @param oper
     * @return
     */
    public static boolean valUs(String oper) {
        Pattern pat = Pattern.compile("^([a-z]{1}" + "\\.{1}" + "[a-z]+" + "\\d{2})|admin$");
        Matcher mat = pat.matcher(oper);
        if (mat.matches() == false) {
            System.out.println("Usuario ingresado incorrecto. intente de nuevo.");
            return false;
        }
        return true;
    }

    /**
     *
     * @param oper
     * @return
     */
    public static boolean valInfo(String oper) {
        Pattern pat = Pattern.compile("^[a-z]+" + " " + "[a-z]+$");
        Matcher mat = pat.matcher(oper);
        if (mat.matches() == false) {
            System.out.println("Ingresado incorrecto. intente de nuevo.");
            return false;
        }
        return true;
    }

    /**
     *
     * @param oper
     * @return
     */
    public static boolean valSuc(String oper) {
        Pattern pat = Pattern.compile("^[a-z]+$");
        Matcher mat = pat.matcher(oper);
        if (mat.matches() == false) {
            System.out.println("Ingresado incorrecto. intente de nuevo.");
            return false;
        }
        return true;
    }

    /**
     *
     * @return
     */
    public int leerInt() {
        int num = 0;
        boolean x;
        do {
            try {
                Scanner intro = new Scanner(System.in);
                num = intro.nextInt();
                x = true;
            } catch (Exception e) {
                System.out.println("Opcion ingresada incorrecta, intente denuevo");
                x = false;
            }
        } while (x == false);
        return num;
    }

    /**
     *
     * @param cuentas
     * @param us
     * @return
     */
    public static boolean existUs(ArrayList cuentas, String us) {
        for (int i = 0; i < cuentas.size(); i++) {
            if (((Cuenta) cuentas.get(i)).getUser().equals(us)) {
                System.out.println("El usuario ingresado no esta disponible");
                return false;
            }
        }
        return true;
    }
    
    /**
     *
     * @param viaje
     * @param fechaHoy
     * @param horaHoy
     * @param hViaje
     * @return
     */
    public static boolean fechaPasada(String viaje, String fechaHoy, String horaHoy, String hViaje){
        StringTokenizer split = new StringTokenizer(viaje, "/");
        String diaViaje1 = split.nextToken().trim();
        int diaViaje = Integer.parseInt(diaViaje1);
        String mesViaje1 = split.nextToken().trim();
        int mesViaje = Integer.parseInt(mesViaje1);
        String añoViaje1 = split.nextToken().trim();
        int añoViaje = Integer.parseInt(añoViaje1);
        StringTokenizer splitHoy = new StringTokenizer(fechaHoy, "/");
        String diaHoy1 = splitHoy.nextToken().trim();
        int diaHoy = Integer.parseInt(diaHoy1);
        String mesHoy1 = splitHoy.nextToken().trim();
        int mesHoy = Integer.parseInt(mesHoy1);
        String añoHoy1 = splitHoy.nextToken().trim();
        int añoHoy = Integer.parseInt(añoHoy1);
        StringTokenizer splitHora = new StringTokenizer(horaHoy, ":");
        String horaHoy1 = splitHora.nextToken().trim();
        int horaHoyDia = Integer.parseInt(horaHoy1);
        String minHoy1 = splitHora.nextToken().trim();
        int minHoyDia = Integer.parseInt(minHoy1);
        StringTokenizer splitHora1 = new StringTokenizer(hViaje, ":");
        String horaViaje1 = splitHora1.nextToken().trim();
        int horaViaje = Integer.parseInt(horaViaje1);
        String minViaje1 = splitHora1.nextToken().trim();
        int minViaje = Integer.parseInt(minViaje1);
        
        if(añoViaje<añoHoy){
            return true;
        }else{
            if(añoViaje==añoHoy&&mesViaje<mesHoy){
                return true;
            }else{
                if(añoViaje==añoHoy&&mesViaje==mesHoy&&diaViaje<diaHoy){
                    return true;
                }else{
                    if(añoViaje==añoHoy&&mesViaje==mesHoy&&diaViaje==diaHoy&&horaViaje<horaHoyDia){
                        return true;
                    }else{
                        if(añoViaje==añoHoy&&mesViaje==mesHoy&&diaViaje==diaHoy&&horaViaje==horaHoyDia&&minViaje<minHoyDia){
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }


}
