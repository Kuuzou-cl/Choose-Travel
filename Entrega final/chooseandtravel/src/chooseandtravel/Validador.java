package chooseandtravel;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 * Clase con todas los metodos validadores static
 * 
 * @author Carlo Bernucci, Javier Nualart
 * @version 3.1
 */
public class Validador {

    /**
     * Metodo que recibe un String, para validar el formato segun 
     * el formato de cuenta de usuario, si es verdadero esta correcto
     * @param oper Parametro String a revisar si coincide con el formato de cuenta de usuario
     * @return Retorna true si es correcto el formato, y false si es incorrecto
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
     * Metodo que recibe un String y lo compara con el formato de Nombre real 
     * asociada a la cuenta
     * @param oper Parametro String, es el String a comprobar si esta correcto
     * @return Retorna true si coincide con el formato, sino es false
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
     * Metodo que valida si un String son solo letras y solo una palabra
     * @param oper Parametro recibido en formato String
     * @return Retorna true si el parametro recibido es una palabra y solo letras
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
     * Metodo que recibe un Arraylist de Cuentas y un usuario, para verificar si
     * el usuario existe dentro del Arraylist
     * @param cuentas Parametro ArrayList de tipo Cuenta
     * @param us Parametro String, que representa el usuario que se quiere verificar
     * @return Retorne true si no existe, y false si existe en el ArrayList
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
     * Metodo para saber si la fecha y hora de un viaje ya han pasado segun la fecha de hoy
     * @param viaje Parametro String de la fecha del viaje a revisar
     * @param hViaje Parametro String de la hora del viaje a revisar
     * @return Retorna true si ya paso la fecha y hora del viaje, sino retorna false
     */
    public static boolean fechaPasada(String viaje, String hViaje){
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date hoyFecha = new Date();
        DateFormat horaFormat = new SimpleDateFormat("HH:mm");
        Date hoyHora = new Date();
        StringTokenizer split = new StringTokenizer(viaje, "/");
        String diaViaje1 = split.nextToken().trim();
        int diaViaje = Integer.parseInt(diaViaje1);
        String mesViaje1 = split.nextToken().trim();
        int mesViaje = Integer.parseInt(mesViaje1);
        String añoViaje1 = split.nextToken().trim();
        int añoViaje = Integer.parseInt(añoViaje1);
        StringTokenizer splitHoy = new StringTokenizer(dateFormat.format(hoyFecha), "/");
        String diaHoy1 = splitHoy.nextToken().trim();
        int diaHoy = Integer.parseInt(diaHoy1);
        String mesHoy1 = splitHoy.nextToken().trim();
        int mesHoy = Integer.parseInt(mesHoy1);
        String añoHoy1 = splitHoy.nextToken().trim();
        int añoHoy = Integer.parseInt(añoHoy1);
        StringTokenizer splitHora = new StringTokenizer(horaFormat.format(hoyHora), ":");
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
    
    /**
     * Metodo para verificar si una sucursal existe, segun un parametro int
     * @param sucursales Parametro ArrayList de tipo sucursal que representa las sucursales
     * @param cod Parametro Integer que representa el codigo de sucursal a revisar
     * @return Retorna true si ya existe el codigo, y false sino
     */
    public static boolean existSuc(ArrayList sucursales,int cod){
        for (int i = 0; i <sucursales.size(); i++) {
            if(((Sucursal) sucursales.get(i)).getCodigo() ==(cod)){
            return true;
            }
        }
        return false;
    }
    
    /**
     * Metodo que segun parametros verifica si existe un viaje solicitado en un ArrayList
     * @param origen Parametro de origen del viaje a revisar si existe
     * @param destino Parametro de destrino del viaje a revisar si existe
     * @param horario Parametro de horario del viaje a revisar si existe
     * @param fecha Parametro de fecha del viaje a revisar si existe
     * @param asiento Parametro de asiento del viaje a revisar si existe
     * @param viajes ArrayList de viaje en donde se va a revisar y comparar los parametros
     * @return Retorna true si el viaje existe, o false si no se encontro un viaje con estos datos
     */
    public static boolean viajeExiste(String origen, String destino, String horario, String fecha, int asiento,ArrayList viajes){
        for (int i = 0; i < viajes.size(); i++) {
            if (((Viaje) viajes.get(i)).getOrigen().equals(origen) 
                    && ((Viaje) viajes.get(i)).getDestino().equals(destino)
                    && ((Viaje) viajes.get(i)).getHorario().equals(horario)
                    && ((Viaje) viajes.get(i)).getFecha().equals(fecha)) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Metodo que verifica si una fecha esta pasada al dia actual
     * @param fecha Parametro String con formato dd/MM/yyyy
     * @return retorna true si la fecha no ha pasdo aun
     */
    public static boolean fechaActual(String fecha) {
        Calendario date = new Calendario();
        String[] fechaSplit = fecha.split("/");
        int dia = Integer.parseInt(fechaSplit[0]);
        int mes = Integer.parseInt(fechaSplit[1]);
        int año = Integer.parseInt(fechaSplit[2]);
        if (mes > date.getMes()) {
            return true;
        } else {
             if (mes == date.getMes() && dia >= date.getDia()) {
            return true;
          }
        }
           
        return false;
    }

}
