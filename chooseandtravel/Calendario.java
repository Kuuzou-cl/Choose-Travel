
package chooseandtravel;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

/**
 *
 * @author kuuzou
 */
public  class Calendario {

    Date date = new Date();
    LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    
    /**
     *
     * @return
     */
    public int getDia(){
        int dia   = localDate.getDayOfMonth();
        return dia;
    }
    
    /**
     *
     * @return
     */
    public int getMes(){
        int mes = localDate.getMonthValue();
        return mes;
    }
    
    /**
     *
     * @return
     */
    public int getAño(){
        int año  = localDate.getYear();
        return año;
    }
}
