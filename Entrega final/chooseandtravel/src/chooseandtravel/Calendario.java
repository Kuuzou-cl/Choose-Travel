
package chooseandtravel;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

/**
 *
 * Clase que entrega informacion de la fecha de hoy del sistema
 * 
 * @author Carlo Bernucci, Javier Nualart
 * @version 3.1
 */
public  class Calendario {

    Date date = new Date();
    LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    
    /**
     *
     * @return Retorna el dia actual
     */
    public int getDia(){
        int dia   = localDate.getDayOfMonth();
        return dia;
    }
    
    /**
     *
     * @return Retorna el mes actual
     */
    public int getMes(){
        int mes = localDate.getMonthValue();
        return mes;
    }
    
    /**
     *
     * @return Retorna el año actual
     */
    public int getAño(){
        int año  = localDate.getYear();
        return año;
    }
}
